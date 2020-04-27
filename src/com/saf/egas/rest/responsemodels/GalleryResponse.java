package com.miraglo.egas.rest.responsemodels;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class GalleryResponse {

private ArrayList<String> aboutImages;
private String zipurl;

public ArrayList<String> getAboutImages() {
	return aboutImages;
}
public void setAboutImages(ArrayList<String> aboutImages) {
	this.aboutImages = aboutImages;
}
public String getZipurl() {
	return zipurl;
}
public void setZipurl(String zipurl) {
	this.zipurl = zipurl;
}

}
