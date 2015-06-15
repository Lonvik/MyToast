package com.otn.android.toast;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyToast extends Activity implements OnClickListener {
	private static final String TOASTBTN_1 = "这是默认的Toast显示";
	private static final String TOASTBTN_2 = "这是自定义位置的Toast显示";
	private static final String TOASTBTN_3 = "这是带图片的Toast显示";
	private static final String TOASTBTN_4 = "这是完全自定义的Toast显示";
	private static final String TOASTBTN_5 = "这是长时间的Toast显示";
	private Button toastBtn_1, toastBtn_2, toastBtn_3, toastBtn_4, toastBtn_5;
	private Toast toast = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		toastBtn_1 = (Button) findViewById(R.id.button_1);
		toastBtn_2 = (Button) findViewById(R.id.button_2);
		toastBtn_3 = (Button) findViewById(R.id.button_3);
		toastBtn_4 = (Button) findViewById(R.id.button_4);
		toastBtn_5 = (Button) findViewById(R.id.button_5);
		toastBtn_1.setOnClickListener(this);
		toastBtn_2.setOnClickListener(this);
		toastBtn_3.setOnClickListener(this);
		toastBtn_4.setOnClickListener(this);
		toastBtn_5.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder;
		AlertDialog dialog;
		switch (v.getId()) {
		case R.id.button_1:
			toast.makeText(this, TOASTBTN_1, Toast.LENGTH_LONG).show();
			break;

		case R.id.button_2:
			toast = Toast.makeText(getApplicationContext(), TOASTBTN_2,
					Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			break;

		case R.id.button_3:
			toast = Toast.makeText(getApplicationContext(), TOASTBTN_3,
					Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 50, -100);
			LinearLayout layout = (LinearLayout) toast.getView();
			ImageView image = new ImageView(getApplicationContext());
			image.setImageResource(R.drawable.wallpaper_tree_small);
			layout.addView(image, 0);
			toast.show();
			break;

		case R.id.button_4:
			LayoutInflater inflater = getLayoutInflater();
			View view = inflater.inflate(R.layout.toast_bank_validation,
					(ViewGroup) findViewById(R.id.toast_layout));
			toast = new Toast(getApplicationContext());
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.setDuration(Toast.LENGTH_LONG);
			toast.setView(view);
			toast.show();
			break;
			
		case R.id.button_5:
			/*LayoutInflater inflater1 = getLayoutInflater();
			View view1 = inflater1.inflate(R.layout.toast_bank_validation_success,
					(ViewGroup) findViewById(R.id.toast_ll));
			TextView tv_perfect_order = (TextView) view1.findViewById(R.id.tv_perfect_order);
			tv_perfect_order.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "去完善订单吧", 0).show();
				}
			});
			builder = new AlertDialog.Builder(this);
			builder.setView(view1);
			dialog = builder.create();
			dialog.show();*/
			
			
		    MyDialogPsw selectDialog = new MyDialogPsw(this,R.style.add_dialog);//创建Dialog并设置样式主题  
		    Window win = selectDialog.getWindow();  
		    LayoutParams params = new LayoutParams();  
		    params.x = 0;//设置x坐标  
		    params.y = 500;//设置y坐标  
//		    params.
		    win.setAttributes(params);  
		    selectDialog.setCanceledOnTouchOutside(false);//设置点击Dialog外部任意区域关闭Dialog  ,false时没有效果
		    selectDialog.show();  
			
//			toast.makeText(this, TOASTBTN_5, Toast.LENGTH_LONG).show();
//			initToast();
//			myToast();
			break;

		default:
			break;
		}
	}
//	private void myToast(){
//		Timer timer = new Timer();
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				initToast();
//			}
//		}, 10);
//	}
//	private void initToast(){
//		toast.show();
//	}

}
