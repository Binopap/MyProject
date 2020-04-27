package com.miraglo.egas.rest.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraglo.egas.dm.Bill;
import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Nonce;
import com.miraglo.services.BillService;
import com.miraglo.services.GuestService;
import com.miraglo.services.NonceService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(description = "BillController", value = "BillAPI")
@Controller
@RequestMapping("{hotelname}/billService")
public class BillController {

	@Autowired
	BillService billservice;
	
	@Autowired
	NonceService nonceservice;
	@Autowired
	GuestService guestservice;
	
	@ApiOperation(value="getBillId",notes="getById")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="get/{nonce}",method=RequestMethod.POST)
	public @ResponseBody Bill getBill(@PathVariable String nonce,HttpServletResponse res){
		
		Nonce nonce1=nonceservice.getNonce(nonce);
		Guest guest=guestservice.getGuestById(nonce1.getGuest().getGuestId());
		res.setStatus(HttpServletResponse.SC_OK);
		return billservice.getBillByGuest(guest);
	}
}
