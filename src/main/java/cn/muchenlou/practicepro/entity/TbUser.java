package cn.muchenlou.practicepro.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbUser{
	/**
	* id
	*/
	private Integer id;
	/**
	* 用户名称
	*/
	private String userName;
	/**
	* 密码
	*/
	private String password;
	/**
	* 注册时间
	*/
	private Date newTime;
	/**
	 * 手机号
	 */
	private String phone;
}