package com.wusj.resume.model;

import java.util.Calendar;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * 工作经历
 * 
 * @author wusj
 * 
 */
@Table(name = "WorkExperience")
public class WorkExperience extends Model {
	@Column(name = "Resume")
	public Resume resume;
	// 开始时间
	@Column(name = "StartTime")
	public String startTime;
	// 结束时间
	@Column(name = "EndTime")
	public String endTime;
	// 职位
	@Column(name = "Position")
	public String position;
	// 公司名称
	@Column(name = "CompanyName")
	public String companyName;
}
