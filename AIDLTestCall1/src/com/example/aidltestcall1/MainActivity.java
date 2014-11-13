package com.example.aidltestcall1;

import com.example.aidltest1.MyAIDL;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener
{

	private MyAIDL mAidl;
	private Button button1, button2;
	private TextView text;
	
	ServiceConnection serviceConnection = new ServiceConnection()
	{
		
		@Override
		public void onServiceDisconnected(ComponentName name)
		{
			// TODO Auto-generated method stub
			mAidl = null;
			Toast.makeText(MainActivity.this, "onServiceDisconnected : mAidl = null", Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service)
		{
			// TODO Auto-generated method stub
			mAidl = MyAIDL.Stub.asInterface(service);
			if ( button2 != null) button2.setEnabled(true);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	
	private void init ()
	{
		text = (TextView) findViewById(R.id.text);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button2.setEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch ( v.getId() )
		{
		case R.id.button1:
			bindService( new Intent("my.test.aidl.service"), serviceConnection, Context.BIND_AUTO_CREATE);
			
			break;
		case R.id.button2:
			try
			{
//				text.setText(mAidl.handler());
				text.setText(mAidl.getValue());
				mAidl.setValue("这是一个数据传送测试!");
			} catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				text.setText(e.toString());
			}
			break;
		}
	}
	
	@Override
	protected void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		unbindService(serviceConnection);
	}

}
