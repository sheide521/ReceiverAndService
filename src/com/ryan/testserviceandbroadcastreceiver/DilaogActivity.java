package com.ryan.testserviceandbroadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
/**
 * @author Ryan
 *
 */
public class DilaogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.ok_dialog);
		
		if (getIntent().getExtras() != null) {
			Bundle bundle = getIntent().getExtras();
			String test = bundle.getString("param");
			System.out.println("----"+ test);
		}
		
		Button btn_ok = (Button)this.findViewById(R.id.btn_ok);
		btn_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//关闭对话框并进入新的Activity
				DilaogActivity.this.finish();
				Intent newiIntent = new Intent(DilaogActivity.this,NewActivity.class);
				startActivity(newiIntent);
				
//				MainActivity.mainActivity.finish();
			}
		});
		
	}

	
}
