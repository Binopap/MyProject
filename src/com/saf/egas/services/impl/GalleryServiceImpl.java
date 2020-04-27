package com.miraglo.egas.services.impl;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.GalleryDAO;
import com.miraglo.egas.dm.Gallery;

import com.miraglo.egas.utils.Fileread;
import com.miraglo.egas.utils.ZipUtil;
import com.miraglo.services.GalleryService;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class GalleryServiceImpl implements GalleryService{
//	@Value("${versionno}")
//	private String myProperty;
	
	@Value("${gallary.home.path}")
	private String gallaryhome;
	
	@Autowired
	GalleryDAO gallarydao;
	@Override
	public Gallery getByHotelName(String hotelname) {
		// TODO Auto-generated method stub
		return gallarydao.getByHotelName(hotelname);
	}

	@Override
	public Gallery add(Gallery gallery) {
		// TODO Auto-generated method stub
		return null;
	}
	//private static final PropertiesLoader propertiesLoader = new PropertiesLoader();
	@Override
	public Gallery update(Gallery gallery) {
	
		
		//String versionNo=myProperty;
		
		//float version_no=Float.parseFloat(versionNo);
		Gallery gal=gallarydao.update(gallery);
		float version=gal.getVersion();
		try
		{
		Fileread.FileWrite(gallaryhome+"//"+gal.getHotelName(),"Egas.property", Float.toString(version), "");
		}
		catch(Exception ex)
		{
		}
		//prop.setProperty("versionno", Float.toString(version));
		
		return gallarydao.update(gallery);
	}

	@Override
	public Boolean remove(Gallery gallery) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String getZippedGallery(String hotelName) {
		
        
		String sourcepath=gallaryhome+hotelName;
         Gallery gallery= gallarydao.getByHotelName(hotelName);
        float versionCode= gallery.getVersion()+(float)0.1;
        double delete_version=versionCode-0.2;
        
        String destination=gallaryhome+hotelName+Float.toString(versionCode)+".zip";
        String source=gallaryhome+hotelName+Double.toString(delete_version)+".zip";
		try {
			ZipUtil.zipFolder(sourcepath,destination);
			ZipUtil.deleteZip(source);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//File file = new File(gallaryhome+hotelName+".zip");
			return hotelName+Float.toString(versionCode)+".zip";
		
		
	}

}
