package com.easypan.service; 

import java.util.List;
import com.easypan.entity.pojo.UserInfo;
import com.easypan.entity.example.UserInfoExample;
import com.easypan.entity.vo.PaginationResultVO;

/**
 * @Author	王先森
 * @create	2023年-06月-11日 上午 10:29
 * @Description	db_user_infoServiceImpl
 * @Version	V1.0
 */

public interface UserInfoService {

	/**
	 * 根据条件查询列表
	 */
	List<UserInfo> findListByParam(UserInfoExample query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(UserInfoExample query);

	/**
	 * 分页查询
	 */
	PaginationResultVO<UserInfo> findListByPage(UserInfoExample query);

	/**
	 * 新增
	 */
	Integer add(UserInfo bean );

	/**
	 * 批量新增
	 */
	Integer addBatch( List<UserInfo> listBean );

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch( List<UserInfo> listBean );

	/**
	 * 根据UserId查询
	 */
	 UserInfo getUserInfoByUserId(String userId);
	/**
	 * 根据UserId删除
	 */
	 Integer deleteUserInfoByUserId(String userId);
	/**
	 * 根据UserId更新
	 */
	 Integer updateUserInfoByUserId( UserInfo bean, String userId);
	/**
	 * 根据Email查询
	 */
	 UserInfo getUserInfoByEmail(String email);
	/**
	 * 根据Email删除
	 */
	 Integer deleteUserInfoByEmail(String email);
	/**
	 * 根据Email更新
	 */
	 Integer updateUserInfoByEmail( UserInfo bean, String email);
	/**
	 * 根据QqOpenId查询
	 */
	 UserInfo getUserInfoByQqOpenId(String qqOpenId);
	/**
	 * 根据QqOpenId删除
	 */
	 Integer deleteUserInfoByQqOpenId(String qqOpenId);
	/**
	 * 根据QqOpenId更新
	 */
	 Integer updateUserInfoByQqOpenId( UserInfo bean, String qqOpenId);
	/**
	 * 根据NickName查询
	 */
	 UserInfo getUserInfoByNickName(String nickName);
	/**
	 * 根据NickName删除
	 */
	 Integer deleteUserInfoByNickName(String nickName);
	/**
	 * 根据NickName更新
	 */
	 Integer updateUserInfoByNickName( UserInfo bean, String nickName);

    void registry(String email, String nickName, String password, String emailCode);
}

