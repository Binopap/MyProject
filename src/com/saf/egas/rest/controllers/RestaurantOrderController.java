package com.miraglo.egas.rest.controllers;

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

import com.miraglo.egas.dm.RestaurantOrder;
import com.miraglo.services.RestaurantOrderService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
@Api(description = "Order_API", value = "order API")
@Controller
@RequestMapping("{hotelname}/OrderService")
public class RestaurantOrderController {

	@Autowired
	RestaurantOrderService reststaurantorderservice;
	@Produces({ "application/json", "application/xml" })
	@ApiOperation(value = "create order", notes = "createOrder")
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public @ResponseBody
	RestaurantOrder createOrder(
			@ModelAttribute(value = "restaurantorder") RestaurantOrder order,
			HttpServletResponse res) {

		res.setStatus(HttpServletResponse.SC_OK);
		return reststaurantorderservice.create(order);
	}
	@ApiOperation(value = "cacel order", notes = "cancel")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value = "cancel", method = RequestMethod.POST)
	public @ResponseBody
	RestaurantOrder cancelOrder(@PathVariable Long orderId,
			HttpServletResponse res) {
		RestaurantOrder order = reststaurantorderservice.getByid(orderId);
		res.setStatus(HttpServletResponse.SC_OK);
		return reststaurantorderservice.create(order);
	}
	@ApiOperation(value = "Get orderby id", notes = "Returns orderlist")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value = "getOrder/{orderId}", method = RequestMethod.GET)
	public @ResponseBody
	int getstatus(@PathVariable Long orderId, HttpServletResponse res) {
		RestaurantOrder order = reststaurantorderservice.getByid(orderId);
		res.setStatus(HttpServletResponse.SC_OK);
		return reststaurantorderservice.getStatus(order);
	}
	@ApiOperation(value = "Get delayed order", notes = "Returns orderlist")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value = "orderList_delay", method = RequestMethod.GET)
	public @ResponseBody
	List<RestaurantOrder> getOrderListByDelay(@RequestParam String hotelName,
			@RequestParam Long minutes, HttpServletResponse res) {

		return reststaurantorderservice.getOrdersByDelay(minutes, hotelName);
	}
	@ApiOperation(value = "Get orderlist", notes = "Returns list")
	@Produces({ "application/json", "application/xml" })
	@RequestMapping(value = "orderList_in", method = RequestMethod.GET)
	public @ResponseBody
	List<RestaurantOrder> getOrderListDeliveredIn(
			@RequestParam String hotelName, @RequestParam Long minutes,
			HttpServletResponse res) {

		return reststaurantorderservice
				.getOrdersDeliveredIn(minutes, hotelName);
	}
}
