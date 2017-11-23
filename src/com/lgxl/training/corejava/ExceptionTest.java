package com.lgxl.training.corejava;
import java.util.*;

/**
 * This Class demonstrates the use of Userdefined Exception "MyException"
 * @author Logixal
 *
 */
public class ExceptionTest {

	
	public static void main(String[] args) 
	{
			int age;
			System.out.println("Enter the Age of a Person....");		//Accepting Age from User
			Scanner sc= new Scanner(System.in); 
			age=sc.nextInt();
			
			try
			{
				checkAge(age);				//Passing age to Function which throws User Defined Exception
			} catch (MyException e) 
			{
				e.printStackTrace();		//Handling the UserDefined Exception Thrown by checkAge() method
			}
	}
	
	
	/**
	 * Function to examine Age of person
	 */
	static void checkAge(int age) throws MyException 
	{
		if (age<18)							//Throws User-defined Exception to caller if Age is less than 18 
			throw new MyException("Sorry!! This person is not Allowed to Vote.....");
		else
			System.out.println("This Person is Allowed to vote......");
	}

}
