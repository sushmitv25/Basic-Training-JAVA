package com.lgxl.training.corejava;
import java.util.*;

/**
 * This class demonstrates the use of List for performing various Operations: Create List, Add, Search, Delete or Remove and Update Elements from List. 
 * @author Logixal
 */
public class CurdExample
{
	public static void main(String[] args)
	{
		int ch;
		char choice;
		String value, name;
		List <String>list=new ArrayList<String>();
		do
		{
			System.out.println("-----List Operations------");							//Menu for All List Operations
			System.out.println("1: Create and Insert Entry in List");
			System.out.println("2: Search an Entry in List");
			System.out.println("3: Delete or Remove an Entry from List");
			System.out.println("4: Update an Entry in List");
			System.out.println("5: Display the List");
			System.out.println("6: Exit");
			System.out.println("Enter your Choice....");
			Scanner reader=new Scanner(System.in);
			ch=reader.nextInt();
	
				
			switch(ch)
			{
			case 1:																		//Insert Data in the List
				System.out.println("Enter a Name to be added to the List....");
				name=reader.next();
				add_list(list, name);
				break;	
			
			case 2:																		//Search Data in the List
				System.out.println("Enter the name to be Searched.....");
				value=reader.next();
				search_entry(list,value);
				break;
				
			case 3:																		//Remove Data from List
				System.out.println("Enter the Name to be Removed from the List....");
				value=reader.next();
				remove_entry(list,value);
				break;
				
			case 4:																		//Update Data in the List	
				System.out.println("Enter the Name to be Updated.....");
				value=reader.next();
				System.out.println("Enter the updated Name...");
				String update_value=reader.next();
				update_entry(list, value, update_value);
				break;
			case 5:																		//Display the List
				display_list(list);
				break;
				
			case 6:
				System.exit(0);															//Exit Program
				break;
				
			default: System.out.println("Please Enter a Valid Option!!!!....");			//Invalid input
			}
			System.out.println("\nDo you want to continue");
			choice=reader.next().charAt(0);
		}while(choice!='n');
	}
	
	/**
	 * Method to Add new Entries into the List  
	 */
	static void add_list(List<String> pList, String pName)
	{
		pList.add(pName);
		System.out.println("\nEntry added Successfully!!!!...");
	}
	
	/**
	 * Method to Iterate and Display the Complete List 
	 */
	static void display_list(List<String> pList)
	{
		Iterator<String> i=pList.iterator();
		while(i.hasNext())
		{
			String entry=i.next();
			System.out.println(entry);
		}
	}
	
	/**
	 * Method to Search an Entry in the List by Name
	 */
	static void search_entry(List<String> pList, String pValue)
	{
		if(pList.contains(pValue))
			System.out.println("The entered Name exists in the list at "+pList.indexOf(pValue)+" position....");
		else
			System.out.println("Sorry!!!! The entered Name does not exist in the List.... ");
	}

	/**
	 * Method to Delete or Remove an entry From the List
	 */
	static void remove_entry(List<String>pList, String pValue)
	{
		pList.remove(pValue);
		System.out.println("Entry Removed Successfully....1");
	}
	
	
	/**
	 * Method to Update an Entry from the List
	 */
	static void update_entry(List<String>pList, String pValue, String pUpdate_value)
	{
		int index=pList.indexOf(pValue);
		pList.set(index, pUpdate_value);
		System.out.println("Entry updated successfully....");
	}
}
