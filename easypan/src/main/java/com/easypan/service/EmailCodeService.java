package com.easypan.service; 

import java.util.List;
import com.easypan.entity.pojo.EmailCode;
import com.easypan.entity.example.EmailCodeExample;
import com.easypan.entity.vo.PaginationResultVO;

/**
 * @Author	王先森
 * @create	2023年-06月-11日 上午 10:29
 * @Description	db_email_codeServiceImpl
 * @Version	V1.0
 */

public interface EmailCodeService {

	/**
	 * 根据条件查询列表
	 */
	List<EmailCode> findListByParam(EmailCodeExample query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(EmailCodeExample query);

	/**
	 * 分页查询
	 */
	PaginationResultVO<EmailCode> findListByPage(EmailCodeExample query);

	/**
	 * 新增
	 */
	Integer add(EmailCode bean );

	/**
	 * 批量新增
	 */
	Integer addBatch( List<EmailCode> listBean );

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch( List<EmailCode> listBean );

	/**
	 * 根据EmailAndCode查询
	 */
	 EmailCode getEmailCodeByEmailAndCode(String email,String code);
	/**
	 * 根据EmailAndCode删除
	 */
	 Integer deleteEmailCodeByEmailAndCode(String email,String code);
	/**
	 * 根据EmailAndCode更新
	 */
	 Integer updateEmailCodeByEmailAndCode( EmailCode bean, String email,String code);

	void sendEmailCode(String email, Integer type);

	void checkEmailCode(String email, String code);
}

