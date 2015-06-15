package com.otn.android.toast;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MyDialogPsw extends Dialog implements android.view.View.OnClickListener {

	private Context context;
	public MyDialogPsw(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

	public MyDialogPsw(Context context) {
	    super(context);
	    this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.toast_validation_psw);
	    TextView tv_cancel = (TextView) findViewById(R.id.tv_cancel);
	    TextView tv_determine = (TextView) findViewById(R.id.tv_determine);
	    tv_cancel.setOnClickListener(this);
	    tv_determine.setOnClickListener(this);
	    
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_cancel:
			Toast.makeText(context, "取消按钮", 0).show();
			if(isShowing()){
				dismiss();
			}
			break;

		case R.id.tv_determine:
			Toast.makeText(context, "确定按钮", 0).show();
			break;
		}
	}
}
