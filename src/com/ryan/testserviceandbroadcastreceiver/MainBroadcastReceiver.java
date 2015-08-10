package com.ryan.testserviceandbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainBroadcastReceiver extends BroadcastReceiver {
	
	public static final String RECEIVER = "com.ryantang.receiver";

	@Override
	public void onReceive(Context context, Intent arg1) {
		//注意：AlertDialog只能依附一个Activity存在，传入的context必须是Activity，在这里使用AlertDialog会报错
//		AlertDialog.Builder builder = new AlertDialog.Builder(context);
//		builder.setTitle("广播响应");
//		builder.setMessage("事件处理");
//		builder.setNegativeButton("Ok", null);
//		builder.create().show();
		
		//响应广播，弹出对话框
		Intent dialogIntent = new Intent(context,DilaogActivity.class);
		dialogIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Bundle bundle = new Bundle();
		bundle.putString("param", "HELLO");
		dialogIntent.putExtras(bundle);
		context.startActivity(dialogIntent);
		
	}

}
