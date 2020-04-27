package com.miraglo.egas.rest.controllers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraglo.egas.dm.ApiKey;
import com.miraglo.egas.dm.Complaint;
import com.miraglo.egas.dm.Food;
import com.miraglo.egas.dm.Gallery;
import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.egas.dm.Nonce;
import com.miraglo.egas.rest.responsemodels.SetupResponse;
import com.miraglo.egas.rest.responsemodels.TokenResponse;
import com.miraglo.egas.utils.KeyTools;
import com.miraglo.egas.utils.TimeBasedUuidGenerator;
import com.miraglo.egas.utils.UUIDGen;
import com.miraglo.services.ApiKeyService;
import com.miraglo.services.ComplaintService;
import com.miraglo.services.FoodService;
import com.miraglo.services.GalleryService;
import com.miraglo.services.GuestService;
import com.miraglo.services.HotelService;
import com.miraglo.services.NonceService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(description = "API Test", value = "test API")
@Controller
public class EntryController {
	private static final Logger logger=LoggerFactory.getLogger(EntryController.class);
	@Autowired
	ApiKeyService apiservice;
	@Autowired
	GuestService guestService;
	@Autowired
	KeyTools keytools;
	@Autowired
	NonceService nonceService;
	@Autowired
	GalleryService galleryservice;
	
	@ApiOperation(value = "Get_login", notes = "Returns news items")
	@RequestMapping(value="/{hotelname}/login.html",method=RequestMethod.GET)
	public @ResponseBody String loginController(@RequestParam(required=false) String username,@RequestParam(required=false) String password,@RequestParam(required=false,defaultValue="") String imei,@ApiParam(name="hotelname", value="hotel name", required=true) @PathVariable String hotelname,@RequestParam String nonce){
		logger.debug("Hotel :"+hotelname);
		Nonce nonceObj=nonceService.getNonce(nonce);
		if(!imei.equals("")){
			nonceObj.setGuest(guestService.getActiveGuestByImei(imei));
		}else{
			
		}
		return "success";
	}
	@ApiOperation(value = "authenticate", notes = "Returns Tokenresponse")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value="authenticate.html",method=RequestMethod.GET)
	public @ResponseBody
	TokenResponse authenticateRequest(@RequestParam String token,@RequestParam String hotelname,
			HttpServletResponse res) {
		TokenResponse tr = new TokenResponse();
		ApiKey apikey = apiservice.validateKey(token);
		if (apikey != null) {
			String nonce_val = UUIDGen.getRandomNumber(15);
			String challenge = keytools.encrypt(nonce_val);

			tr.setChallenge(challenge);
			tr.setStatus("200");

			tr.setResponse("Token validated!, Welcome onboard");
			Gallery gallery=galleryservice.getByHotelName(hotelname);
			
            tr.setVersion_no(gallery.getVersion());
			Nonce nonce = new Nonce();
			nonce.setLastAccess(new Date());
			nonce.setNonce(nonce_val);
			nonceService.addNonce(nonce);
			
			res.setStatus(HttpServletResponse.SC_OK);
			return tr;

		} else {
			tr.setResponse("401");
			tr.setResponse("Invalid request!");
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return tr;
		}

	}

	@RequestMapping(value="setup.html",method=RequestMethod.GET)
	public @ResponseBody
	SetupResponse doSetup() {
		SetupResponse setupResponse = new SetupResponse();
		ApiKey apiKey = new ApiKey();
		apiKey.setApikey(TimeBasedUuidGenerator.generate().toString()
				.replace("-", ""));
		apiKey.setToken(UUIDGen.getRandomNumber(16));
		apiKey = apiservice.createApiKey(apiKey);
		setupResponse.setApikey(apiKey.getApikey());
		setupResponse.setToken(apiKey.getToken());
		setupResponse.setLastLease(apiKey.getLastLease());
		setupResponse.setApiKeys(apiservice.listAllKeys());
		return setupResponse;
	}

	@RequestMapping(value="testAuthorization.html",method=RequestMethod.GET)
	public @ResponseBody
	SetupResponse doTestAuthorization() {
		SetupResponse setupResponse = new SetupResponse();
		ApiKey apiKey = new ApiKey();
		apiKey.setApikey(TimeBasedUuidGenerator.generate().toString()
				.replace("-", ""));
		apiKey.setToken(UUIDGen.getRandomNumber(16));
		apiKey = apiservice.createApiKey(apiKey);
		setupResponse.setApikey(apiKey.getApikey());
		setupResponse.setToken(apiKey.getToken());
		setupResponse.setLastLease(apiKey.getLastLease());
		setupResponse.setApiKeys(apiservice.listAllKeys());
		return setupResponse;
	}

	@RequestMapping(value="getApis.html",method=RequestMethod.GET)
	public @ResponseBody
	SetupResponse doGetApis() {
		SetupResponse setupResponse = new SetupResponse();

		setupResponse.setApiKeys(apiservice.listAllKeys());
		return setupResponse;
	}
	@Autowired
	FoodService foodservice;
	@Autowired
	HotelService hotelservice;
	
	@Autowired
	GuestService guestservice;
	@Autowired
	ComplaintService complaintservice;
	@Autowired
	NonceService nonceservice;

//	@ApiOperation(value = "Get News", notes = "Returns FoodList")
//	@Produces({ "application/json", "application/xml" })
//	@RequestMapping(value="foodlist/{hotelId}",method=RequestMethod.GET)
//	public @ResponseBody ArrayList<Food> getFoodListById(@PathVariable Long hotelId,@PathVariable String hotelName,@RequestParam String nonce, @RequestParam String imei,HttpServletResponse res){
//		
//		if(nonceservice.nonceCheck(hotelName, nonce, imei)){
//			Hotel hotel=hotelservice.getById(hotelId);
//			res.setStatus(HttpServletResponse.SC_OK);
//			return foodservice.getFoodListForHotel(hotel);
//		}else{
//			
//			return null;
//		}
//			
//	}
//	
//	@RequestMapping(value="submit_complaint",method=RequestMethod.GET)
//	public @ResponseBody Boolean saveComplaint(@RequestParam String imei,@RequestParam String msg,HttpServletResponse res,HttpServletRequest req){
//		res.setStatus(HttpServletResponse.SC_OK);
//		
//		Guest guest=guestservice.getActiveGuestByImei(imei);
//		//req.getParameter("hotelname")
//		Hotel hotel=hotelservice.getByName(req.getParameter("hotelname"));
//		Complaint complaint=new Complaint();
//		complaint.setMessage(msg);
//		complaint.setGuest(guest);
//		complaint.setHotel(hotel);
//		complaintservice.add(complaint);
//	return true;
//	}
	

//	@RequestMapping(value="/{hotelname}/testSecurity",method=RequestMethod.GET)
//	public @ResponseBody Guest testSecurity(@PathVariable String hotelname,@RequestParam String nonce, @RequestParam String imei){
//		Guest g=guestservice.getActiveGuestByImei(imei);
//		Nonce nonce1=nonceService.getNonce(nonce);
//		if(nonce1.getGuest()==null){
//			nonce1.setGuest(g);
//			nonce1.setHotel(hotelservice.getByName(hotelname));
//			nonce1.setLeaseTime(new Date().toString());
//			//nonceService.update
//		}
//		
//		
//	}
}
