package com.easypan.entity.pojo; 

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * @Author	王先森
 * @create	2023年-06月-11日 上午 09:27
 * @Description	db_user_info表的实体类
 * @Version	V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfo implements Serializable {

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 用户昵称
	 */
	private String nickName;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 用户关联QQ开放ID
	 */
	private String qqOpenId;

	/**
	 * 用户头像
	 */
	private String qqAvatar;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 用户创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date joinTime;

	/**
	 * 用户最后一次登录时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastLoginTime;

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

	/**
	 * 提供用户ID的get方法
	 */
	public String getUserId(){
		return this.userId;
	}
	/**
	 * 提供用户昵称的get方法
	 */
	public String getNickName(){
		return this.nickName;
	}
	/**
	 * 提供用户邮箱的get方法
	 */
	public String getEmail(){
		return this.email;
	}
	/**
	 * 提供用户关联QQ开放ID的get方法
	 */
	public String getQqOpenId(){
		return this.qqOpenId;
	}
	/**
	 * 提供用户头像的get方法
	 */
	public String getQqAvatar(){
		return this.qqAvatar;
	}
	/**
	 * 提供用户密码的get方法
	 */
	public String getPassword(){
		return this.password;
	}
	/**
	 * 提供用户创建时间的get方法
	 */
	public Date getJoinTime(){
		return this.joinTime;
	}
	/**
	 * 提供用户最后一次登录时间的get方法
	 */
	public Date getLastLoginTime(){
		return this.lastLoginTime;
	}
	/**
	 * 提供用户状态:0:禁用 1:启用的get方法
	 */
	public Integer getStatus(){
		return this.status;
	}
	/**
	 * 提供用户使用空间的get方法
	 */
	public Long getUserSpace(){
		return this.userSpace;
	}
	/**
	 * 提供用户总空间的get方法
	 */
	public Long getTotalSpace(){
		return this.totalSpace;
	}
	/**
	 * 提供用户ID的set方法
	 */
	public void setUserId(String userId){
		this.userId=userId;
	}
	/**
	 * 提供用户昵称的set方法
	 */
	public void setNickName(String nickName){
		this.nickName=nickName;
	}
	/**
	 * 提供用户邮箱的set方法
	 */
	public void setEmail(String email){
		this.email=email;
	}
	/**
	 * 提供用户关联QQ开放ID的set方法
	 */
	public void setQqOpenId(String qqOpenId){
		this.qqOpenId=qqOpenId;
	}
	/**
	 * 提供用户头像的set方法
	 */
	public void setQqAvatar(String qqAvatar){
		this.qqAvatar=qqAvatar;
	}
	/**
	 * 提供用户密码的set方法
	 */
	public void setPassword(String password){
		this.password=password;
	}
	/**
	 * 提供用户创建时间的set方法
	 */
	public void setJoinTime(Date joinTime){
		this.joinTime=joinTime;
	}
	/**
	 * 提供用户最后一次登录时间的set方法
	 */
	public void setLastLoginTime(Date lastLoginTime){
		this.lastLoginTime=lastLoginTime;
	}
	/**
	 * 提供用户状态:0:禁用 1:启用的set方法
	 */
	public void setStatus(Integer status){
		this.status=status;
	}
	/**
	 * 提供用户使用空间的set方法
	 */
	public void setUserSpace(Long userSpace){
		this.userSpace=userSpace;
	}
	/**
	 * 提供用户总空间的set方法
	 */
	public void setTotalSpace(Long totalSpace){
		this.totalSpace=totalSpace;
	}

}