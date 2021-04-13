package com.cafeteriaexpreess.order.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.ReadOnlyProperty;

@Entity(name = "TB_ORDERS")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "order_id")
	private List<Item> items;
	
	@ReadOnlyProperty
	private Double total;

	public Order() {
		
	}

	public Order(Long id, List<Item> items) {
		super();
		this.id = id;
		this.items = items;
		this.total = getTotal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Double getTotal(){
		double totalValue =0.0;
		
		for(Item i: items) {
			totalValue += i.total();
		}
		return totalValue;
	}
}