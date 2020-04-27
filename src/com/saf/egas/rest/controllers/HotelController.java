package com.miraglo.egas.rest.controllers;

import javax.servlet.http.HttpServletRequest;
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

import com.miraglo.egas.dm.Hotel;
import com.miraglo.services.HotelService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(description = "Hotel_api ", value = "hotel API")
@Controller
@RequestMapping("{hotelname}/hotelservice")
public class HotelController {
	
	@Autowired
	HotelService hotelservice;
	
	
	@ApiOperation(value = "save by Name", notes = "save")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="submit_hotel",method=RequestMethod.POST)
	public @ResponseBody Hotel saveHotel(@ModelAttribute(value="hotelform") Hotel hotel,HttpServletResponse res){
		res.setStatus(HttpServletResponse.SC_OK);
		return hotelservice.add(hotel); 
	}
	
	@ApiOperation(value = "update by Name", notes = "update by Hotelbyid")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="submit_hotel/{hotelId}",method=RequestMethod.POST)
	public @ResponseBody Hotel updateHotel(@PathVariable Long hotelId,HttpServletResponse res){
		
		Hotel hotel=hotelservice.getById(hotelId);
		res.setStatus(HttpServletResponse.SC_OK);
		return hotelservice.update(hotel);
	}
	@ApiOperation(value = "delete by Name", notes = "Hotelbyid")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="/{hotelId}/submit_hotel",method=RequestMethod.POST)
	public @ResponseBody Boolean deleteHotel(@PathVariable Long hotelId,HttpServletResponse res){
		Hotel hotel=hotelservice.getById(hotelId);
		return hotelservice.delete(hotel);
	}
	@ApiOperation(value = "Get Hotel by Name", notes = "Returns Hotelbyname")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="hoteldata/{hotelname}",method=RequestMethod.GET)
	public @ResponseBody Hotel getByName(@PathVariable String hotelname,HttpServletResponse res){
		res.setStatus(HttpServletResponse.SC_OK);
		
		return hotelservice.getByName(hotelname);
	}
	@ApiOperation(value = "Get Hotel", notes = "Returns Hotel")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="/{hotelId}/hoteldata",method=RequestMethod.GET)
	public @ResponseBody Hotel getById(@PathVariable Long hotelId,HttpServletResponse res){
		res.setStatus(HttpServletResponse.SC_OK);
		return hotelservice.getById(hotelId);
	}
	@ApiOperation(value = "Get Hotel by Status", notes = "Returns Hotelbystatus")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="hotelBystatus/{status}",method=RequestMethod.GET)
	public @ResponseBody Hotel getHotelByStatus(@PathVariable Short status,HttpServletResponse res){
		res.setStatus(HttpServletResponse.SC_OK);
		return hotelservice.getByStatus(status);
		}
}
