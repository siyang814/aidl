package com.example.aidlcalltest;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.R;
import com.example.aidltest.IMyService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener
{
	private IMyService myService = null;
	private Button btnInvokeAIDLService;
	private Button btnBindAIDLService;
	private TextView textView;
	private ServiceConnection serviceConnection = new ServiceConnection()
	{
		@Override
		public void onServiceConnected(ComponentName name, IBinder service)
		{
			// 获得服务对象
			myService = IMyService.Stub.asInterface(service);
			btnInvokeAIDLService.setEnabled(true);
		}

		@Override
		public void onServiceDisconnected(ComponentName name)
		{
		}
	};

	@Override
	public void onClick(View view)
	{
		switch (view.getId())
		{
		case R.id.btnBindAIDLService:
			// 绑定AIDL服务
			bindService(new Intent("net.blogjava.mobile.aidl.IMyService"),
					serviceConnection, Context.BIND_AUTO_CREATE);
			break;
		case R.id.btnInvokeAIDLService:
			try
			{
				textView.setText(myService.getValue());
				// 调用服务端的getValue方法
			} catch (Exception e)
			{
			}
			break;
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnInvokeAIDLService = (Button) findViewById(R.id.btnInvokeAIDLService);
		btnBindAIDLService = (Button) findViewById(R.id.btnBindAIDLService);
		btnInvokeAIDLService.setEnabled(false);
		textView = (TextView) findViewById(R.id.textView);
		btnInvokeAIDLService.setOnClickListener(this);
		btnBindAIDLService.setOnClickListener(this);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		   String nowTime=format.format(new Date());
		   textView.setText(nowTime);
	}
	
	@Override
	protected void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		/**
		 * 当你不需要绑定的时候就执行 unbindService() 方法，执行这个方法只会触发 Service 的 onUnbind() 而不会把这个 Service 销毁。这样就可以既保持和 Service 的通信，也不会随着 Activity 销毁而销毁了。
		 */
		unbindService(serviceConnection);
//		bindService(new Intent("net.blogjava.mobile.aidl.IMyService"),
//				serviceConnection, Context.BIND_AUTO_CREATE);
	}

}