package com.beyang.cn.entity;

public class Address {
	private String provice;
	private String city;
	
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [provice=" + provice + ", city=" + city + "]";
	}
	
}
