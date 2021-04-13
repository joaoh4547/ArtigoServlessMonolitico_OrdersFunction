package com.cafeteriaexpreess.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteriaexpreess.order.models.Item;
import com.cafeteriaexpreess.order.models.Order;
import com.cafeteriaexpreess.order.models.Product;
import com.cafeteriaexpreess.order.repositories.ItemRepository;
import com.cafeteriaexpreess.order.repositories.OrderRepository;
import com.cafeteriaexpreess.order.repositories.ProductRepository;
import com.cafeteriaexpreess.order.request.ItemRequest;
import com.cafeteriaexpreess.order.request.OrderRequest;

@Service
public class OrderService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order save(OrderRequest request) {
		List<Item> items = new ArrayList<>();
		for(ItemRequest it: request.getItems()) {
			Product p = productRepository.findById(it.getProductId()).orElse(null);
			Item i = new Item(null, p, it.getQuantity());
			items.add(i);
			itemRepository.save(i);
		}
		Order order = orderRepository.save(new Order(null, items));
		
		return order;
	}
}
