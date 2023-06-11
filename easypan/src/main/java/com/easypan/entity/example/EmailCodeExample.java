package com.easypan.entity.example; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;


/**
 * @Author	王先森
 * @create	2023年-06月-11日 上午 10:29
 * @Description	EmailCodeExample表的实体类
 * @Version	V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailCodeExample extends BaseQuery {

	/**
	 * 邮箱号码
	 */
	private String email;

	/**
	 * 邮箱号码模糊匹配字段
	 */
	private String emailMohu;

	/**
	 * 编号
	 */
	private String code;

	/**
	 * 编号模糊匹配字段
	 */
	private String codeMohu;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建时间开始时间
	 */
	private String createTimeStart;

	/**
	 * 创建时间结束时间
	 */
	private String createTimeEnd;

	/**
	 * 状态 0:未使用 1:已使用
	 */
	private Integer status;


}