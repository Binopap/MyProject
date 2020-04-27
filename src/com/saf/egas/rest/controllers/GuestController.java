package com.miraglo.egas.rest.controllers;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraglo.egas.dm.Food;
import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.services.FoodService;
import com.miraglo.services.GuestService;
import com.miraglo.services.HotelService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
@Api(description = "Guest_Api", value = "Guest_APIs")
@Controller
@RequestMapping("{hotelname}/guestservice")
public class GuestController {
	@Autowired
	private GuestService guestService;
	
	@Autowired
	private FoodService foodService;
	@Autowired 
	private HotelService hotelservice;
	
	@ApiOperation(value = "Get by Name", notes = "getByName")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="foodlist/{hotelname}",method=RequestMethod.GET)
	
	public @ResponseBody List<Food> getFoodListByName(@PathVariable String hotelname,HttpServletResponse res){
		Hotel hotel=hotelservice.getByName(hotelname);
		res.setStatus(HttpServletResponse.SC_OK);
		return foodService.getFoodListForHotel(hotel);
	}
	
	
	@ApiOperation(value = "guest By IMEI", notes = "guestByIMEI")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="guestdata/{imei}",method=RequestMethod.GET)
	public @ResponseBody Guest getActiveGuestByImei(@PathVariable String imei,HttpServletResponse res){
		res.setStatus(HttpServletResponse.SC_OK);
		return guestService.getActiveGuestByImei(imei);	
	}
	
	@ApiOperation(value = "deactivate Guest", notes = "deactivate")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="change_guestStatus/{guestId}",method=RequestMethod.GET)
	public @ResponseBody boolean deactivateGuest(@PathVariable Long guestId,HttpServletResponse res){
		Guest guest=guestService.getGuestById(guestId);
		res.setStatus(HttpServletResponse.SC_OK);
		return guestService.deactivateGuest(guest);
	}
	
	@ApiOperation(value = "getById", notes = "get by id")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="/{guestId}/guestdata",method=RequestMethod.GET)
	public @ResponseBody Guest getGuestById(@PathVariable Long guestId,HttpServletResponse res){
		res.setStatus(HttpServletResponse.SC_OK);
	  return guestService.getGuestById(guestId);
	}
	
	@ApiOperation(value = "GuestBy Name", notes = "GuestByName")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="guestlist",method=RequestMethod.GET)
	public @ResponseBody List<Guest> getGuestByHotelName(@PathVariable String hotelname,HttpServletResponse res ){
		Hotel hotel=hotelservice.getByName(hotelname);
		res.setStatus(HttpServletResponse.SC_OK);
		return guestService.getGuestsByHotel(hotel);
	}
	
	@ApiOperation(value = "GetGuestwithallergies", notes = "getguest")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="guestwithallergies",method=RequestMethod.GET)
	public @ResponseBody List<Guest> getGuestsWithAllergies(HttpServletResponse res){
		res.setStatus(HttpServletResponse.SC_OK);
		return guestService.getGuestsWithAllergies();
	}
	@ApiOperation(value = "updateguest", notes = "update")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="submit_guest",method=RequestMethod.POST)
	public @ResponseBody Guest updateGuestDevice(@PathVariable Long guestId,@PathVariable String imei,HttpServletResponse res){
		Guest guest=guestService.getGuestById(guestId);
		res.setStatus(HttpServletResponse.SC_OK);
	  return guestService.updateGuestDevice(guest, imei);
	}
}
