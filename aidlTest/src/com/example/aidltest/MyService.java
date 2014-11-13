package com.example.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service { 
public class MyServiceImpl extends IMyService.Stub {

	@Override 
	public String getValue() throws RemoteException { 
	return "Android/OPhone开发讲义"; 
	}
 
} 
@Override 
public IBinder onBind(Intent intent) { 
return new MyServiceImpl(); 
}

@Override
	public boolean onUnbind(Intent intent)
	{
		// TODO Auto-generated method stub
		
		return super.onUnbind(intent);
	}

 @Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
	
	}

}