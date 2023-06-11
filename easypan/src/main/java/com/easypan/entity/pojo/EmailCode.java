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
 * @create	2023年-06月-11日 上午 10:29
 * @Description	db_email_code表的实体类
 * @Version	V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailCode implements Serializable {

	/**
	 * 邮箱号码
	 */
	private String email;

	/**
	 * 编号
	 */
	private String code;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 状态 0:未使用 1:已使用
	 */
	private Integer status;

	/**
	 * 提供邮箱号码的get方法
	 */
	public String getEmail(){
		return this.email;
	}
	/**
	 * 提供编号的get方法
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * 提供创建时间的get方法
	 */
	public Date getCreateTime(){
		return this.createTime;
	}
	/**
	 * 提供状态 0:未使用 1:已使用的get方法
	 */
	public Integer getStatus(){
		return this.status;
	}
	/**
	 * 提供邮箱号码的set方法
	 */
	public void setEmail(String email){
		this.email=email;
	}
	/**
	 * 提供编号的set方法
	 */
	public void setCode(String code){
		this.code=code;
	}
	/**
	 * 提供创建时间的set方法
	 */
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	/**
	 * 提供状态 0:未使用 1:已使用的set方法
	 */
	public void setStatus(Integer status){
		this.status=status;
	}

}