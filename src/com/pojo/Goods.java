package com.pojo;

import java.io.Serializable;

public class Goods implements Serializable{

	private String goods_name;
	private String goods_id;
	private float discounts;
	private float goods_price;
	private String goods_desc;
	private String goods_type;
	private String big_type;
	private String goods_color;
	private String goods_pic;
	private String goods_edition;

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	public String getBig_type() {
		return big_type;
	}

	public void setBig_type(String big_type) {
		this.big_type = big_type;
	}

	public String getGoods_desc() {
		return goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public float getDiscounts() {
		return discounts;
	}

	public void setDiscounts(float discount) {
		this.discounts = discount;
	}

	public float getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_color() {
		return goods_color;
	}

	public void setGoods_color(String goods_color) {
		this.goods_color = goods_color;
	}

	public String getGoods_pic() {
		return goods_pic;
	}

	public void setGoods_pic(String goods_pic) {
		this.goods_pic = goods_pic;
	}

	public String getGoods_edition() {
		return goods_edition;
	}

	public void setGoods_edition(String goods_edition) {
		this.goods_edition = goods_edition;
	}

}
