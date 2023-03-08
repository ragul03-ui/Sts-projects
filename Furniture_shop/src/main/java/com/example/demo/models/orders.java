package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EmployeeInfo")
public class orders {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String item;
	private String colour;
	private String img;
	private int price;
	public orders(int id, String item, String colour, String img, int price) {
		super();
		this.id = id;
		this.item = item;
		this.colour = colour;
		this.img = img;
		this.price = price;
	}
	public orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getitem() {
		return item;
	}
	public void setitem(String item) {
		this.item = item;
	}
	public String getcolour() {
		return colour;
	}
	public void setcolour(String colour) {
		this.colour = colour;
	}
	public String getimg() {
		return img;
	}
	public void setimg(String img) {
		this.img = img;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	
	
}
