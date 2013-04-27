package com.wusj.resume.model;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import android.graphics.Bitmap;

@Table(name = "Resume")
public class Resume extends Model {
	// 姓名
	@Column(name = "Name")
	public String name;
	// 年龄
	@Column(name = "Age")
	public int age;
	// 性别
	@Column(name = "Sex")
	public String sex;
	// 民族
	@Column(name = "Nation")
	public String nation;
	// 户藉
	@Column(name = "HouseHoldRegister")
	public String houseHoldRegister;
	// 手机号码
	@Column(name = "PhoneNumber")
	public String phoneNumber;
	// 自我介绍
	@Column(name = "SelfIntroduction")
	public String selfIntroduction;
	// E-mail
	@Column(name = "Email")
	public String email;
	// 联系地址
	@Column(name = "Address")
	public String address;
	// 头像
	@Column(name = "Icon")
	public String icon;
	// 外语
	@Column(name = "ForeignLanguage")
	public String foreignLanguage;
	// 专业
	@Column(name = "Major")
	public String major;
	// 学历
	@Column(name = "EducationBackground")
	public String educationBackground;
	// 爱好
	@Column(name = "Hobby")
	public String hobby;
	//
	@Column(name = "Github")
	public String github;
	//
	@Column(name = "Stackoverflow")
	public String stackoverflow;
	// 工作经历
	private List<WorkExperience> workExperience;
	// 项目经验
	private List<ProjectExperience> projectExperience;

	public List<WorkExperience> getWorkExperience() {
		workExperience = getMany(WorkExperience.class, "Resume");

		return workExperience;
	}

	public List<ProjectExperience> getProjectExperience() {
		projectExperience = getMany(ProjectExperience.class, "Resume");

		return projectExperience;
	}

	public static Resume findByName(String name) {
		return new Select().from(Resume.class).where("Name = ?", name)
				.executeSingle();
	}
}
