package cn.muchenlou.practicepro.entity;

import lombok.Data;

@Data
public class TbCurriculum{
	/**
	* id
	*/
	private Integer id;
	/**
	* 课程名称
	*/
	private String name;
	/**
	* 类型ID
	*/
	private Integer typeId;

}