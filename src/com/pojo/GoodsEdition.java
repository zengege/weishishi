package com.pojo;

import java.io.Serializable;

public class GoodsEdition implements Serializable {
	private String goods_edition;
	private int edition_id;
	private float goods_price;
	private float discounts;
	private String goods_id;
	

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public float getDiscounts() {
		return discounts;
	}

	public void setDiscounts(float discounts) {
		this.discounts = discounts;
	}

	public int getEdition_id() {
		return edition_id;
	}

	public void setEdition_id(int edition_id) {
		this.edition_id = edition_id;
	}

	public float getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_edition() {
		return goods_edition;
	}

	public void setGoods_edition(String goods_edition) {
		this.goods_edition = goods_edition;
	}

}
