package com.LockedMe;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject 
{
	static final String folderpath="C:\\Users\\Vigne\\Documents\\SIMPLI LEARN\\COURSE 2 Implement OOPS using JAVA with Data Structures and Beyond\\Phase 1-My Project\\File Directory";
	public static void main(String[] args) 
	{
		int proceed=1;
		
		do
		{
			
		//Variable declaration
		Scanner obj =new Scanner(System.in);
		int ch;
		
		//Menu
		displayMenu();
		System.out.println("Enter your choice:");
		ch=Integer.parseInt(obj.nextLine());
		
		switch(ch)
		{
			case 1 : getAllFiles();
						break;
			case 2 : createFiles();
						break;
			case 3 : deleteFile();
						break;
			case 4 : searchFile();
						break;
			case 5 : System.exit(0);
						break;
			default : System.out.println("Invalid Option");
						break;
			}
		
		//obj.close();
		
		}while(proceed>0);
	}
	
	/**
	 * List of Files
	 */
	public static void displayMenu()
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t\tLockedMe.com");
		System.out.println("\t      Lockers Pvt. Ltd.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
		System.out.println("1. List of files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Scanner obj = new Scanner(System.in);
		
	}
	/**
	 * List files in ascending order
	 * @param folderpath
	 */
	
	public static void sortFile(String folderpath)
	{
		File fileDir = new File(folderpath);
		System.out.println(folderpath);
		List<String> listFile = Arrays.asList(fileDir.list());
		Collections.sort(listFile);
		System.out.println("---------");
		System.out.println("Sorting by filename in ascending order");
		for(String s:listFile)
		{
			System.out.println(s);
		}
	}
	/**
	 * List of Files
	 */
	public static void getAllFiles()
	{
		// To Get File Names
		List<String> fileNames = FileManager.getAllFiles(folderpath);
		
		if(fileNames.size()==0)
			System.out.println("No files in the directory");
		else
		{
		System.out.println("FILE LIST IS BELOW:\n");
		for(String f:fileNames)
			System.out.println(f);
		}
	}
	
	/**
	 * To Create a file
	 */
	
	public static void createFiles() 
	{
		//Add New File

		//Variable Declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
				
		//Read file name from user
		System.out.println("Enter file Name:");
		fileName=obj.nextLine();
				
		//Read number of lines from user
		System.out.println("Enter how many lines in the file:");
		linesCount=Integer.parseInt(obj.nextLine());
				
		//Read Lines from user
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter line "+i+":");
			content.add(obj.nextLine());
		}
		//save the content into the file
		boolean isSaved = FileManager.addFiles(folderpath, fileName, content);
				
		if(isSaved)
			System.out.println("File and data saved successfully");
		else
			System.out.println("Some error occured. Please contact admin@lockedme.com");
		
		//System.out.println("Enter any character to proceed");
		//String data=obj.nextLine();
		
		//close scanner object
			//obj.close();
	}
	
	/**
	 * To Delete File
	 */
	
	public static void deleteFile()
	{
		//Delete File
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be deleted:");
		fileName=obj.nextLine();
				
		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
				
		if(isDeleted)
			System.out.println("File deleted successfully");
		else
			System.out.println("Either file not there or some access issue");
	}
	
	/**
	 * To Search File
	 */
	
	public static void searchFile()
	{

		//Search File
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be searched:");
		fileName=obj.nextLine();
						
		boolean isFound = FileManager.searchFile(folderpath, fileName);
						
		if(isFound)
			System.out.println("File is present in the folder");
		else
			System.out.println("file is not present in the folder");
	}
}
