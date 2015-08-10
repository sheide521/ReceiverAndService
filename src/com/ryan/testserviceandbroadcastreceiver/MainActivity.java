package com.ryan.testserviceandbroadcastreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	public static MainActivity mainActivity = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainActivity = this;

		// 静态注册
		this.findViewById(R.id.btn1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//在Servie中处理，3s后弹出对话框
				Intent serviceIntent = new Intent("com.ryan.service");
				startService(serviceIntent);
			}
		});

		// 动态注册
		this.findViewById(R.id.btn2).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//发送广播消息
				sendBroadcast(new Intent(MY_ACTION));
			}
		});
	}
	
	//自定义匿名内部类（广播）
	private static final String MY_ACTION = "MY_ACTION";
	private BroadcastReceiver receiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			Intent dialogIntent = new Intent(context,DilaogActivity.class);
			dialogIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(dialogIntent);
		}
	};

	@Override
	protected void onResume() {
		super.onResume();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(MY_ACTION);
		//动态注册广播
		registerReceiver(receiver, intentFilter);
	}

	@Override
	protected void onStop() {
		super.onStop();
		//注销广播
		unregisterReceiver(receiver);
	}

	
}
