package com.miraglo.egas.rest.controllers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import scala.collection.mutable.Publisher;

import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.egas.dm.Nonce;
import com.miraglo.egas.dm.Suggestion;
import com.miraglo.egas.rest.responsemodels.SuggestionResponse;
import com.miraglo.services.NonceService;
import com.miraglo.services.SuggestionService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(description = "Guest_Api", value = "Guest_APIs")
@Controller
@RequestMapping("/{hotelname}/Suggestionservice")
public class SuggestionController {

	@Autowired
	SuggestionService suggestionservice;
	@Autowired
	NonceService nonceService;

	@ApiOperation(value = "AddSuggestion", notes = "AddSuggestion")
	@RequestMapping(value = "AddSuggestion", method = RequestMethod.POST)
	public @ResponseBody
	Boolean InsertSuggestions(@RequestParam String msg,
			@RequestParam String nonce, HttpServletResponse res) {

		Suggestion suggestion = new Suggestion();

		Nonce non = nonceService.getNonce(nonce);
		Hotel hotel = non.getHotel();
		Guest guest = non.getGuest();
		suggestion.setGuest(guest);
		suggestion.setHotel(hotel);
		suggestion.setMessage(msg);
		suggestion.setTimestamp(new Date());

		return suggestionservice.AddSuggestion(suggestion);
	}

	@ApiOperation(value = "GetReplyById", notes = "GetReplyId")
	@RequestMapping(value = "getSuggestionReply/{suggestionId}", method = RequestMethod.GET)
	public @ResponseBody SuggestionResponse getReply(@PathVariable Long suggestionId) {
	
    SuggestionResponse response=new SuggestionResponse();
    response.setReply(suggestionservice.getReply(suggestionId));
		return response;
	}

}
