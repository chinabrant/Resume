package com.wusj.resume.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TitleTextView extends LinearLayout {

	private TextView mTitle;
	private TextView mContent;

	public TitleTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		setOrientation(LinearLayout.HORIZONTAL);
		mTitle = new TextView(context);
		mContent = new TextView(context);

		LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		params1.gravity = Gravity.CENTER;
		addView(mTitle, params1);
		
		LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		params1.gravity = Gravity.CENTER_VERTICAL;
		params2.weight = 1;
		addView(mContent, params2);
	}

}
