package com.cafeteriaexpreess.order.function;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafeteriaexpreess.order.models.Order;
import com.cafeteriaexpreess.order.request.OrderRequest;
import com.cafeteriaexpreess.order.service.OrderService;

@Component
public class OrderFunction implements Function<OrderRequest, Order>{
	
	@Autowired
	private OrderService service;
	
	@Override
	public Order apply(OrderRequest request) {
		Order order = service.save(request);
		return order;
	}

}
