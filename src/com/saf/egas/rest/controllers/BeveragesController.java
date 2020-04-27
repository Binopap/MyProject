package com.miraglo.egas.rest.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraglo.egas.dm.Bar;
import com.miraglo.egas.dm.Beverages;
import com.miraglo.egas.dm.Food;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.services.BarService;
import com.miraglo.services.BeverageService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;


@Api(description = "BeveragesController", value = "BeveragesAPI")
@Controller
@RequestMapping("{hotelname}/beverageservice")
public class BeveragesController {
@Autowired
BeverageService beverageservice;
@Autowired
BarService barservice;

@ApiOperation(value = "save by beverageName", notes = "save")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="submit_beverages",method=RequestMethod.POST)
public @ResponseBody Beverages saveBeverage(@ModelAttribute(value="beverageform") Beverages beverage,HttpServletResponse res){
	res.setStatus(HttpServletResponse.SC_OK);
	return beverageservice.addBeverages(beverage);
}

@ApiOperation(value = "Get Beverage", notes = "Returns Beverages")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="/{beverageId}/hoteldata",method=RequestMethod.GET)
public @ResponseBody Beverages getById(@PathVariable Long beverageId,HttpServletResponse res){
	res.setStatus(HttpServletResponse.SC_OK);
	return beverageservice.getBeveragesById(beverageId);
}

 

@ApiOperation(value = "delete by Id", notes = "Barbyid")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="/{beverageId}/submit_beverages",method=RequestMethod.POST)
public @ResponseBody Boolean deleteBeverage(@PathVariable Long beverageId,HttpServletResponse res){
	Beverages beverage=beverageservice.getBeveragesById(beverageId);
	return beverageservice.removeBeverages(beverage);
}
@ApiOperation(value = "getbeverages_list", notes = "getbeverageslist")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="beverageslist/{barId}",method=RequestMethod.GET)
public @ResponseBody ArrayList<Beverages> getFoodListByType(@PathVariable Long barId,HttpServletResponse res){
	
	Bar bar=barservice.getById(barId);
	res.setStatus(HttpServletResponse.SC_OK);
	return beverageservice.getBeveragesListForBar(bar);
	
}
}
