package com.lgxl.training.corejava;
/**
 * This Class is used for Creating a User-defined Checked Exceptions.
 * @author Logixal
 */
public class MyException extends Exception 
{
	String message;

	public MyException(String message) 
	{
		super(message); 
	}
	
	
}
