/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\android\\HaiEr\\AIDLTest1\\src\\com\\example\\aidltest1\\MyAIDL.aidl
 */
package com.example.aidltest1;
public interface MyAIDL extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.aidltest1.MyAIDL
{
private static final java.lang.String DESCRIPTOR = "com.example.aidltest1.MyAIDL";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.aidltest1.MyAIDL interface,
 * generating a proxy if needed.
 */
public static com.example.aidltest1.MyAIDL asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.aidltest1.MyAIDL))) {
return ((com.example.aidltest1.MyAIDL)iin);
}
return new com.example.aidltest1.MyAIDL.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_handler:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.handler();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getValue:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getValue();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setHandler:
{
data.enforceInterface(DESCRIPTOR);
com.example.aidltest1.MyAIDL _arg0;
_arg0 = com.example.aidltest1.MyAIDL.Stub.asInterface(data.readStrongBinder());
this.setHandler(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setValue:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setValue(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.aidltest1.MyAIDL
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String handler() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_handler, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getValue() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getValue, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setHandler(com.example.aidltest1.MyAIDL ma) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((ma!=null))?(ma.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setHandler, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setValue(java.lang.String strings) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(strings);
mRemote.transact(Stub.TRANSACTION_setValue, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_handler = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getValue = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setHandler = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_setValue = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public java.lang.String handler() throws android.os.RemoteException;
public java.lang.String getValue() throws android.os.RemoteException;
public void setHandler(com.example.aidltest1.MyAIDL ma) throws android.os.RemoteException;
public void setValue(java.lang.String strings) throws android.os.RemoteException;
}
