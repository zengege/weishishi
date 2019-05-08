package com.pojo;

import java.io.Serializable;

public class Address implements Serializable {
	
	private String phone_num;
	private String sheng;
	private String shi;
	private String qu;
	private String name;
	private String phone;
	private String detail_ad;
	private int adress_id;
	
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDetail_ad() {
		return detail_ad;
	}
	public void setDetail_ad(String detail_ad) {
		this.detail_ad = detail_ad;
	}
	public int getAdress_id() {
		return adress_id;
	}
	public void setAdress_id(int adress_id) {
		this.adress_id = adress_id;
	}
	
	
	
	
	
}
