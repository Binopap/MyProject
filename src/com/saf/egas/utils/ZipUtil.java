package com.miraglo.egas.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
	
	static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
	    ZipOutputStream zip = null;
	    FileOutputStream fileWriter = null;

	    fileWriter = new FileOutputStream(destZipFile);
	    zip = new ZipOutputStream(fileWriter);

	    addFolderToZip("", srcFolder, zip);
	    zip.flush();
	    zip.close();
	  }
	public static void deleteZip(String sourcepath){
		File f= new File(sourcepath);
		f.delete();
		
	}

	  static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
	      throws Exception {

	    File folder = new File(srcFile);
	    if (folder.isDirectory()) {
	      addFolderToZip(path, srcFile, zip);
	    } else {
	      byte[] buf = new byte[1024];
	      int len;
	      FileInputStream in = new FileInputStream(srcFile);
	      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
	      while ((len = in.read(buf)) > 0) {
	        zip.write(buf, 0, len);
	      }
	    }
	  }

	  static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
	      throws Exception {
	    File folder = new File(srcFolder);

	    for (String fileName : folder.list()) {
	      if (path.equals("")) {
	        addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
	      } else {
	        addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
	      }
	    }
	  }
	  
	  
	  /*Method to Unzip a folder*/
	  public static void unZip(String zipFile,String outputFolder) throws FileNotFoundException, IOException{
	  System.out.println("Begin unzip "+ zipFile + " into "+outputFolder);
	        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
	        ZipEntry ze = zis.getNextEntry();
	        while(ze!=null){
	            String entryName = ze.getName();
	            System.out.print("Extracting " + entryName + " -> " + outputFolder + File.separator +  entryName + "...");
	            File f = new File(outputFolder + File.separator +  entryName);
	            //create all folder needed to store in correct relative path.
	            f.getParentFile().mkdirs();
	            FileOutputStream fos = new FileOutputStream(f);
	            int len;
	            byte buffer[] = new byte[1024];
	            while ((len = zis.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	            }
	            fos.close();  
	            System.out.println("OK!");
	            ze = zis.getNextEntry();
	        }
	        zis.closeEntry();
	        zis.close();
	 
	  }
	  
	  public static void main(String args[])
	  {
		  String source="C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\EGAS_Gallery\\"+"akash";
		 // String source1="D:\\EGAS_Gallary\\hi\\";
	         String destination="C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\EGAS_Gallery\\"+"akash.zip";
			
			try {
				ZipUtil.zipFolder(source,destination);
				
				//ZipUtil.unZip(destination, source1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
}
