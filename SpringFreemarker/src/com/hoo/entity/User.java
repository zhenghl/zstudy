package com.hoo.entity;

import java.io.Serializable;

import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 8606788203814942679L;

	private String name;
	private int age;
	private boolean sex;
	private String address;
	private Date brithday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return this.name + "#" + this.age + "#" + this.sex + "#" + this.address + "#" + this.brithday;
	}
}