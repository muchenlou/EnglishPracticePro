package cn.muchenlou.practicepro.entity;

import lombok.Data;

@Data
public class TbUserCurriculum{
	/**
	* id
	*/
	private Integer id;
	/**
	* 用户id
	*/
	private Integer userId;
	/**
	* 课程id
	*/
	private Integer curriculumId;

}