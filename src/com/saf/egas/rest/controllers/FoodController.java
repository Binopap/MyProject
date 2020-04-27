package com.miraglo.egas.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraglo.egas.dm.Food;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.services.FoodService;
import com.miraglo.services.HotelService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
@Api(description = "Food_API", value = "Food_APIs")
@Controller
@RequestMapping("{hotelname}/foodservice/")
public class FoodController {
	
@Autowired
FoodService foodservice;
@Autowired
HotelService hotelservice;
@ApiOperation(value = "getfoodbyid", notes = "getfoodbyid")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="foodlist/{hotelId}",method=RequestMethod.GET)
public @ResponseBody List<Food> getFoodListById(@PathVariable Long hotelId,HttpServletResponse res){
	Hotel hotel=hotelservice.getById(hotelId);
	res.setStatus(HttpServletResponse.SC_OK);
	return foodservice.getFoodListForHotel(hotel);
}
@ApiOperation(value = "getfood_list", notes = "getfoodlist")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="/{type}/foodlist/{hotelName}",method=RequestMethod.GET)
public @ResponseBody ArrayList<Food> getFoodListByType(@PathVariable String hotelName,@PathVariable Boolean type,HttpServletResponse res){
	
	Hotel hotel=hotelservice.getByName(hotelName);
	res.setStatus(HttpServletResponse.SC_OK);
	return foodservice.getFoodListByType(hotel, type); 
	
}

@ApiOperation(value = "get_food", notes = "getFood")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="FoodById/{foodId}",method=RequestMethod.GET)
public @ResponseBody Food getFoodById(@PathVariable Long foodId,HttpServletResponse res){
	res.setStatus(HttpServletResponse.SC_OK);
	return foodservice.getFoodById(foodId);
}

@ApiOperation(value = "add_food", notes = "add_food")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="submit_food",method=RequestMethod.POST)
public @ResponseBody Food addFood(@ModelAttribute(value="addfood") Food food,HttpServletResponse res){
	res.setStatus(HttpServletResponse.SC_OK);
	return foodservice.addFood(food);
}

@ApiOperation(value = "remove_food", notes = "remove_food")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="submit_food/{foodId}",method=RequestMethod.POST)
public @ResponseBody Boolean removeFood(@PathVariable Long foodId,HttpServletResponse res){
	Food food=foodservice.getFoodById(foodId);
	res.setStatus(HttpServletResponse.SC_OK);
	return foodservice.removeFood(food);
}


@ApiOperation(value = "deletefood", notes = "delete food")
@Produces({ "application/json", "application/xml" })
@RequestMapping(value="delete_food/{foodId}",method=RequestMethod.POST)
public @ResponseBody Boolean deleteFoodById(@PathVariable Long foodId,HttpServletResponse res){
	res.setStatus(HttpServletResponse.SC_OK);
	return foodservice.deleteFoodById(foodId);
}


}
