package com.miraglo.egas.rest.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraglo.egas.dm.Food;
import com.miraglo.egas.dm.Gallery;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.egas.rest.responsemodels.GalleryResponse;
import com.miraglo.egas.utils.Fileread;
import com.miraglo.services.GalleryService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
@Api(description = "Gallery_API", value = "gallery_APIs")
@Controller
@RequestMapping("{hotelname}/galleryservice")
public class GalleryController {
	@Value("${gallary.home.path}")
	private String gallaryhome;
	@Value("${app.docs}")
	private String apiPath;
	@Autowired
	GalleryService galleryservice;
	@ApiOperation(value = "addGallery", notes = "addgallery")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value = "submit_gallery", method = RequestMethod.POST)
	public @ResponseBody
	Gallery addGallery(@ModelAttribute(value = "addfood") Gallery gallery,
			HttpServletResponse res) {
		res.setStatus(HttpServletResponse.SC_OK);
		return galleryservice.add(gallery);
	}
	@ApiOperation(value = "removegallery", notes = "remove gallery")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value = "submit_gallery/{hotelname}", method = RequestMethod.POST)
	public @ResponseBody
	Boolean removeGallery(@PathVariable String hotelname,
			HttpServletResponse res) {
		Gallery gallery = galleryservice.getByHotelName(hotelname);
		res.setStatus(HttpServletResponse.SC_OK);
		return galleryservice.remove(gallery);
	}
	@ApiOperation(value = "update_gallery", notes = "update_gallery")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value = "update_gallery/{hotelname}", method = RequestMethod.POST)
	public @ResponseBody
	Gallery updateGallery(@PathVariable String hotelname,
			HttpServletResponse res) {
		Gallery gallery = galleryservice.getByHotelName(hotelname);
		res.setStatus(HttpServletResponse.SC_OK);
		return galleryservice.update(gallery);
	}
	@ApiOperation(value = "getZippedData", notes = "GetZippedData")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="zipped_gallery_data",method=RequestMethod.GET)
	public @ResponseBody GalleryResponse GetZippedGallery(@RequestParam String hotelName,HttpServletResponse res){
		res.setStatus(HttpServletResponse.SC_OK);
		
	GalleryResponse galres=new GalleryResponse();
	galres.setAboutImages(Fileread.getFileContents(gallaryhome, hotelName+"\\AboutUs"));

	galres.setZipurl(apiPath+"//EGAS_Gallery//"+galleryservice.getZippedGallery(hotelName));
	// File f=new File(galleryservice.getZippedGallery(hotelName));

	 
	 
	 

		return galres;
	}
	
}
