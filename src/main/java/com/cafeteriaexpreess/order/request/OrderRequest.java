package com.cafeteriaexpreess.order.request;

import java.util.List;

public class OrderRequest {
	private List<ItemRequest> items;

	public OrderRequest() {
	}

	public OrderRequest(List<ItemRequest> items) {
		this.items = items;
	}

	public List<ItemRequest> getItems() {
		return items;
	}

	public void setItems(List<ItemRequest> items) {
		this.items = items;
	}	
	
}
