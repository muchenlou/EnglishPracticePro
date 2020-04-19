package cn.muchenlou.practicepro.entity;

import lombok.Data;

@Data
public class TbWord{
	/**
	* id
	*/
	private Integer id;
	/**
	* 英语单词
	*/
	private String english;
	/**
	* 汉语单词
	*/
	private String chinase;
	/**
	* 课程ID
	*/
	private Integer curriculumId;

}