package com.example.aidltest1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class myAIDLSerive extends Service
{
	private MyAIDL ma;
	class MyAIDLTest extends MyAIDL.Stub
	{

		@Override
		public String handler() throws RemoteException
		{
			// TODO Auto-generated method stub
			Intent intent1 = new Intent();
			intent1.setClass(myAIDLSerive.this, MainActivity.class);
			intent1.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent1);
			return "this is AIDL Test!";
		}

		@Override
		public String getValue() throws RemoteException
		{
			// TODO Auto-generated method stub
			return "this is AIDL Test! - getValue";
		}

		@Override
		public void setHandler(MyAIDL ma) throws RemoteException
		{
			// TODO Auto-generated method stub
			myAIDLSerive.this.ma = ma;
		}

		@Override
		public void setValue(String strings) throws RemoteException
		{
			// TODO Auto-generated method stub
			Intent intent1 = new Intent();
			intent1.setClass(myAIDLSerive.this, MainActivity.class);
			intent1.putExtra("NAME", strings);
			intent1.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent1);
		}
		
	}
	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return  new MyAIDLTest();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO Auto-generated method stub
		return START_STICKY;
	}
}
