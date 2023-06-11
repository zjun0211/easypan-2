package com.easypan.mappers; 

import org.apache.ibatis.annotations.Param;
import java.util.Date;


/**
 * @Author	王先森
 * @create	2023年-06月-11日 上午 10:29
 * @Description	db_email_code表的Mapper类
 * @Version	V1.0
 */

public interface EmailCodeMapper<T, P> extends BaseMapper {

	/**
	 * 根据EmailAndCode查询
	 */
	 T selectByEmailAndCode(@Param("email") String email,@Param("code") String code);
	/**
	 * 根据EmailAndCode删除
	 */
	 Integer deleteByEmailAndCode(@Param("email") String email,@Param("code") String code);
	/**
	 * 根据EmailAndCode更新
	 */
	 Integer updateByEmailAndCode(@Param("bean") T t, @Param("email") String email,@Param("code") String code);

    void disableEmailCode(@Param("email") String email);
}