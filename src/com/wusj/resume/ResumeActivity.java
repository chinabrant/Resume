package com.wusj.resume;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.wusj.resume.model.ProjectExperience;
import com.wusj.resume.model.Resume;
import com.wusj.resume.model.WorkExperience;

public class ResumeActivity extends Activity {
	private static final String TAG = "ResumeActivity";
	
	private TextView mName;
	private TextView mSex;
	private TextView mAge;
	private TextView mAddress;
	private TextView mNation;
	private ImageView mIcon;
	private TextView mEmail;
	private TextView mPhoneNumber;
	private TextView mHouseHoldRegister;
	private TextView mEducationBackground;
	private TextView mSelfIntroduction;
	private TextView mForeignLanguage;
	private TextView mMajor;
	
	private LinearLayout mOther;
	private LinearLayout mWorkExperience;
	private LinearLayout mProjectExperience;
	
	private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);   
        
        initViews();
//        Resume re = new Resume();
//        re.name = "brant";
//        re.age = 24;
//        re.sex = "male";
//        re.nation = "汉";
//        re.phoneNumber = "10086";
//        re.email = "sjwu1234@gmail.com";
//        re.houseHoldRegister = "江西";
//        re.educationBackground = "二本";
//        re.selfIntroduction = "self introduction";
//        re.foreignLanguage = "cet4";
//        re.major = "electronic";
//        re.address = "深圳";
//        re.save();
//        
//        ProjectExperience pro = new ProjectExperience();
//        pro.resume = re;
//        pro.module = "launcher";
//        pro.projectName = "pro1";
//        pro.projectIntroduction = "pro introduction";
//        pro.save();
//        
//        WorkExperience work = new WorkExperience();
//        work.resume = re;
//        work.startTime = "2012-09-11";
//        work.endTime = "2013-01-12";
//        work.companyName = "msd";
//        work.save();
        
        
        
        
        Resume resume = Resume.findByName("brant");
        mName.setText(resume.name);
        mAge.setText(resume.age + "");
        mSex.setText(resume.sex);
        mNation.setText(resume.nation);
        mIcon.setImageResource(R.drawable.icon);
        mPhoneNumber.setText(resume.phoneNumber);
        mEmail.setText(resume.email);
        mHouseHoldRegister.setText(resume.houseHoldRegister);
        mEducationBackground.setText(resume.educationBackground);
        mSelfIntroduction.setText(resume.selfIntroduction);
        mForeignLanguage.setText(resume.foreignLanguage);
        mMajor.setText(resume.major);
        mAddress.setText(resume.address);
        
        TextView github = new TextView(this);
        github.setText("github:XXX");
        mOther.addView(github);
        TextView stackOverFlow = new TextView(this);
        stackOverFlow.setText("StackOverFlow:XXX");
        mOther.addView(stackOverFlow);
        
        initWorkExperience(resume.getWorkExperience(), mWorkExperience);
        initProjectExperience(resume.getProjectExperience(), mProjectExperience);
    }
    
    private void initViews() {
    	mName = (TextView) findViewById(R.id.tv_name);
    	mName.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
    	mAge = (TextView) findViewById(R.id.tv_age);
    	mAge.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mSex = (TextView) findViewById(R.id.tv_sex);
    	mSex.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mNation = (TextView) findViewById(R.id.tv_nation);
    	mNation.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mIcon = (ImageView) findViewById(R.id.img_icon);
    	
    	mPhoneNumber = (TextView) findViewById(R.id.tv_phone_number);
    	mPhoneNumber.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mEmail = (TextView) findViewById(R.id.tv_email);
    	mEmail.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mHouseHoldRegister = (TextView) findViewById(R.id.tv_house_hold_register);
    	mHouseHoldRegister.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mEducationBackground = (TextView) findViewById(R.id.tv_education_background);
    	mEducationBackground.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mSelfIntroduction = (TextView) findViewById(R.id.tv_self_introduction);
    	mSelfIntroduction.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mForeignLanguage = (TextView) findViewById(R.id.tv_foreign_language);
    	mForeignLanguage.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mMajor = (TextView) findViewById(R.id.tv_major);
    	mMajor.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	mAddress = (TextView) findViewById(R.id.tv_address);
    	mAddress.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    	
    	mOther = (LinearLayout) findViewById(R.id.ll_other);
    	mWorkExperience = (LinearLayout) findViewById(R.id.ll_work_experience);
    	mProjectExperience = (LinearLayout) findViewById(R.id.ll_project_experience);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.resume, menu);
        
        mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.menu_share).getActionProvider();
        mShareActionProvider.setShareIntent(getProviderIntent());
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, ResumeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    private Intent getProviderIntent() {
   	 	Intent intent=new Intent(Intent.ACTION_SEND);
        
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "The Mobile Resume");
        intent.putExtra(Intent.EXTRA_TEXT, "This app is very good!");
        return intent;
   }
    
    private void initWorkExperience(List<WorkExperience> works, LinearLayout workLayout) {
    	for (int i = 0; i < works.size(); i++) {
    		View view = initWorkExperienceView(works.get(i), i + 1);
    		workLayout.addView(view);
    	}
    }
    
    private void initProjectExperience(List<ProjectExperience> projects,  LinearLayout projectLayout) {
    	for (int i = 0; i < projects.size(); i++) {
    		View view = initProjectExperienceView(projects.get(i), i + 1);
    		projectLayout.addView(view);
    	}
    }
    
    /**
     * 
     * @param work
     * @param num
     * @return
     */
    private View initWorkExperienceView(WorkExperience work, int num) {
    	View view = LayoutInflater.from(this).inflate(R.layout.work_experience_item, null);
    	TextView numView = (TextView) view.findViewById(R.id.tv_num);
    	TextView time = (TextView) view.findViewById(R.id.tv_time);
    	TextView company = (TextView) view.findViewById(R.id.tv_company);
    	TextView position = (TextView) view.findViewById(R.id.tv_position);
    	
    	numView.setText(num + "");
    	time.setText(work.startTime + "/" + work.endTime);
    	company.setText(work.companyName);
    	position.setText(work.position);
    	
    	return view;
    }
    
    private View initProjectExperienceView(ProjectExperience project, int num) {
    	View view = LayoutInflater.from(this).inflate(R.layout.project_experience_item, null);
    	TextView numView = (TextView) view.findViewById(R.id.tv_num);
    	TextView projectName = (TextView) view.findViewById(R.id.tv_project_name);
    	TextView projectIntroduction = (TextView) view.findViewById(R.id.tv_project_introduction);
    	
    	numView.setText(num + "");
    	projectName.setText(project.projectName);
    	projectIntroduction.setText(project.projectIntroduction);
    	
    	return view;
    }
}
