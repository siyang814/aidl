package com.example.aidltest1;

interface MyAIDL
{
	String handler();
	String getValue();
	void setHandler ( MyAIDL ma );
	void setValue ( String strings );
}
