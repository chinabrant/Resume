package com.wusj.resume.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "ProjectExperience")
public class ProjectExperience extends Model {
	@Column(name = "Resume")
	public Resume resume;
	// 项目名称
	@Column(name = "ProjectName")
	public String projectName;
	// 负责模块 
	@Column(name = "Module")
	public String module;
	// 项目介绍
	@Column(name = "ProjectIntroduction")
	public String projectIntroduction;
}
