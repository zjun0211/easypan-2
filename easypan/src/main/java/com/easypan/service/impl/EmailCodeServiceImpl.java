package com.easypan.service.impl; 

import java.util.Date;
import java.util.List;

import com.easypan.config.RedisComponent;
import com.easypan.entity.constants.Constants;
import com.easypan.entity.dto.SysSettingsDto;
import com.easypan.entity.example.UserInfoExample;
import com.easypan.entity.pojo.EmailCode;
import com.easypan.entity.example.EmailCodeExample;
import com.easypan.entity.pojo.UserInfo;
import com.easypan.enums.ResponseCodeEnum;
import com.easypan.exception.BusinessException;
import com.easypan.mappers.EmailCodeMapper;
import com.easypan.entity.vo.PaginationResultVO;
import com.easypan.mappers.UserInfoMapper;
import com.easypan.utils.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.easypan.entity.example.SimplePage;
import com.easypan.enums.PageSize;
import com.easypan.service.EmailCodeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author	王先森
 * @create	2023年-06月-11日 上午 10:29
 * @Description	EmailCodeService
 * @Version	V1.0
 */

@Service("emailCodeService")
public class EmailCodeServiceImpl implements EmailCodeService {

	private static Logger logger = LoggerFactory.getLogger(EmailCodeServiceImpl.class);

	@Resource
	private EmailCodeMapper< EmailCode , EmailCodeExample > emailCodeMapper;

	@Resource
	private UserInfoMapper<UserInfo, UserInfoExample> userInfoMapper;

	@Resource
	private MailSender mailSender;

	@Resource
	private RedisComponent redisComponent;


	//注入的属性
	@Value("${spring.mail.username}")
	private String fromEmail;

	/**
	 * 根据条件查询列表
	 */
	public List<EmailCode> findListByParam(EmailCodeExample query) {

		return this.emailCodeMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(EmailCodeExample query) {

		return this.emailCodeMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<EmailCode> findListByPage(EmailCodeExample query) {

		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<EmailCode> list = this.findListByParam(query);
		PaginationResultVO<EmailCode> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;

	}

	/**
	 * 新增
	 */
	public Integer add(EmailCode bean ) {

		return this.emailCodeMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<EmailCode> listBean) {

		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.emailCodeMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增/修改
	 */
	public Integer addOrUpdateBatch(List<EmailCode> listBean) {

		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.emailCodeMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据EmailAndCode查询
	 */
	public EmailCode getEmailCodeByEmailAndCode(String email,String code) {

		return this.emailCodeMapper.selectByEmailAndCode(email,code);
	}

	/**
	 * 根据EmailAndCode删除
	 */
	public Integer deleteEmailCodeByEmailAndCode(String email,String code) {

		return this.emailCodeMapper.deleteByEmailAndCode(email,code);

	}

	/**
	 * 根据EmailAndCode更新
	 */
	public Integer updateEmailCodeByEmailAndCode( EmailCode bean, String email,String code) {

		return this.emailCodeMapper.updateByEmailAndCode(bean,email,code);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void sendEmailCode(String email, Integer type) {
		if (Constants.ZERO==0){
			//注册
			UserInfo userInfos = userInfoMapper.selectByEmail(email);
			if (userInfos!=null){
				throw new BusinessException(ResponseCodeEnum.CODE_906);
			}
		}
		String code = StringTools.getRandomNumber(Constants.FIXED_LENGTH);

		//发送邮件
		sendEmailCode(email,code);

		//更新邮箱的使用状态 置为无效
		emailCodeMapper.disableEmailCode(email);

		EmailCode emailCode = new EmailCode();
		emailCode.setEmail(email);
		emailCode.setCode(code);
		emailCode.setCreateTime(new Date());
		emailCode.setStatus(0);

		emailCodeMapper.insert(emailCode);
	}

	@Override
	public void checkEmailCode(String email, String code) {
		EmailCode emailCode = emailCodeMapper.selectByEmailAndCode(email, code);
		if (emailCode==null){
			throw new BusinessException(ResponseCodeEnum.CODE_908);
		}
		//判断验证码是否被使用过或过期
		if (emailCode.getStatus()==1 || emailCode.getCreateTime().getTime()+redisComponent.getSystemSettingDto().getRegistryMailExpireTime()*1000*60<System.currentTimeMillis()){
			throw new BusinessException(ResponseCodeEnum.CODE_907);
		}

		emailCodeMapper.disableEmailCode(email);
	}

	//发送邮件
	private void sendEmailCode(String toEmail,String code){
		//发送邮件
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(toEmail);

		SysSettingsDto systemSettingDto = redisComponent.getSystemSettingDto();

		simpleMailMessage.setSubject(systemSettingDto.getRegistryMailTitle());
		simpleMailMessage.setText(String.format(systemSettingDto.getRegistryMailContent(),code,systemSettingDto.getRegistryMailExpireTime()));
		simpleMailMessage.setFrom(fromEmail);
		simpleMailMessage.setSentDate(new Date());
		mailSender.send(simpleMailMessage);
	}

}

