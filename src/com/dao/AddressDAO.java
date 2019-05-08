package com.dao;

import java.util.List;

import com.pojo.Address;
import com.pojo.User;
import com.util.DBUtil;


public class AddressDAO {
	

	public int add(String phone_num, String username, String tel,
			String city, String detail_ad) {
		
		String[] a=new String[3];
		String as [] = city.split("-");
		for(int i = 0; i < 3; i++) {
			a[i] = as[i];
		} 
		String sheng = a[0];
		String shi = a[1];
		String qu = a[2];
		String sql = "insert into adress(phone_num,phone,sheng,shi,qu,detail_ad,name) values(?,?,?,?,?,?,?)";
		int n = DBUtil.zsg(sql, phone_num,tel,sheng,shi,qu,detail_ad,username);
		return n;
		
	}

	public List<Address> findall(String phone_num ) {
		String sql = "select adress_id,sheng , shi,qu,detail_ad,phone,name from adress where phone_num = ?";
		List<Address> list = DBUtil.query(Address.class,sql,phone_num);
		return list;
	}
	public List<Address> findbyid(String id) {
		String sql = "select a.phone,a.sheng,a.shi,a.qu,a.detail_ad,a.name from `order` o, adress a where o.adress_id = a.adress_id and order_id = ?";
		List<Address> list = DBUtil.query(Address.class,sql,id);
		return list;
	}

}
