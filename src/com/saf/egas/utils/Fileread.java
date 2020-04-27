package com.miraglo.egas.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Fileread {
	public static void FileWrite(String HotelPath,String FileName,String version,String Hpath) throws FileNotFoundException{
		 File f=new File(HotelPath+"\\"+FileName);
		  FileOutputStream f1 = new FileOutputStream(f);
		  PrintStream ps = new PrintStream(f1);
		  ps.print("versionno="+version);
		  ps.println(); //this writes your new line
		  ps.print("gallary.home.path="+Hpath);
		  ps.close();
		
	}
	public static ArrayList<String> getFileContents(String HotelPath,String FileName){
		 File folder=new File(HotelPath+"\\"+FileName);
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> images=new ArrayList<String>();
		
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  images.add(listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		return images;  
	}
	 public static void main(String args[]) throws FileNotFoundException
	  {
		 
	  }
}
