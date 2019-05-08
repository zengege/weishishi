package com.pojo;

import java.util.Date;

public class GoodsJudge {

	private String goods_name;
	private String phone_num;
	private String judge_pic;
	private Date judge_time;
	private String judge_words;
	
	public String getJudge_words() {
		return judge_words;
	}
	public void setJudge_words(String judge_words) {
		this.judge_words = judge_words;
	}
	public Date getJudge_time() {
		return judge_time;
	}
	public void setJudge_time(Date judge_time) {
		this.judge_time = judge_time;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getJudge_pic() {
		return judge_pic;
	}
	public void setJudge_pic(String judge_pic) {
		this.judge_pic = judge_pic;
	}
	
	
	
}
