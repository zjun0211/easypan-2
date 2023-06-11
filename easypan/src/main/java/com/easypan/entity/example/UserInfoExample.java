package com.easypan.entity.example; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;


/**
 * @Author	王先森
 * @create	2023年-06月-11日 上午 09:27
 * @Description	UserInfoExample表的实体类
 * @Version	V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfoExample extends BaseQuery {

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 用户ID模糊匹配字段
	 */
	private String userIdMohu;

	/**
	 * 用户昵称
	 */
	private String nickName;

	/**
	 * 用户昵称模糊匹配字段
	 */
	private String nickNameMohu;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 用户邮箱模糊匹配字段
	 */
	private String emailMohu;

	/**
	 * 用户关联QQ开放ID
	 */
	private String qqOpenId;

	/**
	 * 用户关联QQ开放ID模糊匹配字段
	 */
	private String qqOpenIdMohu;

	/**
	 * 用户头像
	 */
	private String qqAvatar;

	/**
	 * 用户头像模糊匹配字段
	 */
	private String qqAvatarMohu;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 用户密码模糊匹配字段
	 */
	private String passwordMohu;

	/**
	 * 用户创建时间
	 */
	private Date joinTime;

	/**
	 * 用户创建时间开始时间
	 */
	private String joinTimeStart;

	/**
	 * 用户创建时间结束时间
	 */
	private String joinTimeEnd;

	/**
	 * 用户最后一次登录时间
	 */
	private Date lastLoginTime;

	/**
	 * 用户最后一次登录时间开始时间
	 */
	private String lastLoginTimeStart;

	/**
	 * 用户最后一次登录时间结束时间
	 */
	private String lastLoginTimeEnd;

	/**
	 * 用户状态:0:禁用 1:启用
	 */
	private Integer status;

	/**
	 * 用户使用空间
	 */
	private Long userSpace;

	/**
	 * 用户总空间
	 */
	private Long totalSpace;


}