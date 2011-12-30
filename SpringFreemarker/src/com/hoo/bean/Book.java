package com.hoo.bean;

public class Book {
	
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Book: " + this.id + " " + this.name; 
	}
	
}