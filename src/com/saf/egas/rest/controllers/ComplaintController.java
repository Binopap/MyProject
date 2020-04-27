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

import com.miraglo.egas.dm.Complaint;
import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.egas.rest.responsemodels.ComplaintResponse;
import com.miraglo.services.ComplaintService;
import com.miraglo.services.GuestService;
import com.miraglo.services.HotelService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
@Api(description = "Complaint_API", value = "complaint_API")
@Controller
@RequestMapping("{hotelname}/complaintservice")
public class ComplaintController {

	@Autowired
	ComplaintService complaintservice;
	@Autowired
	HotelService hotelservice;
	@Autowired
	GuestService guestservice;

	@ApiOperation(value = "submit", notes = "submit_complaint")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="submit_complaint",method=RequestMethod.POST)
	public @ResponseBody ComplaintResponse saveComplaint(@RequestParam String imei,@RequestParam String msg,HttpServletResponse res,HttpServletRequest req){
		res.setStatus(HttpServletResponse.SC_OK);
		
		Guest guest=guestservice.getActiveGuestByImei(imei);
		//req.getParameter("hotelname")
		Hotel hotel=hotelservice.getByName(req.getParameter("hotelname"));
		Complaint complaint=new Complaint();
		complaint.setMessage(msg);
		complaint.setGuest(guest);
		complaint.setHotel(hotel);
		complaint=complaintservice.add(complaint);
		ComplaintResponse response=new ComplaintResponse();
		response.setComplaint_id(complaint.getComplaintId());
		response.setStatus(true);
		return response;
	}
	
	@ApiOperation(value = "update", notes = "update_complaint")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="update_complaint",method=RequestMethod.PUT)
	public @ResponseBody Complaint updateComplaint(@PathVariable Long complaintId,HttpServletResponse res){
		
		Complaint complaint=complaintservice.getById(complaintId);
		res.setStatus(HttpServletResponse.SC_OK);
		return complaintservice.update(complaint);
	}
	@ApiOperation(value = "deleter", notes = "delete_complaint")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="submit_complaint",method=RequestMethod.DELETE)
	public @ResponseBody Boolean deleteComplaint(@PathVariable Long complaintId,HttpServletResponse res){
		Complaint complaint=complaintservice.getById(complaintId);
		return complaintservice.remove(complaint);
	}
}