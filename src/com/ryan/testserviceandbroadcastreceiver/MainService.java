package com.ryan.testserviceandbroadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class MainService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// To do something...
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				handler.sendEmptyMessage(0);
			}
		}).start();
	}

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			// MainBroadcastReceiver.RECEIVER 本身就是个意图对象 就等于
			// “com.ryantang.receiver”

			Intent boradcastIntent = new Intent(MainBroadcastReceiver.RECEIVER);
			sendBroadcast(boradcastIntent);
		}

	};

}
