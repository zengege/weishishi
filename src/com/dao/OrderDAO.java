package com.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pojo.Address;
import com.pojo.Goods;
import com.pojo.Order;
import com.util.DBUtil;

public class OrderDAO {
	
	public int  add(String phone_num,String ad_id,int goods_count,String goods_color,String goods_id){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String present = df.format(new Date());
		int ad = Integer.parseInt(ad_id);
		
		String sql = "insert into `order` (order_time,phone_num,adress_id,goods_count,goods_color,goods_id,`condition`) values(?,?,?,?,?,?,1)";
		int n = DBUtil.zsg(sql,present,phone_num,ad,goods_count,goods_color,goods_id);
		return n ;
	}

	public List<Order> findall(String phone_num,String condition, int page) {
		String q = new String("0");
		
		String sql = "select o.order_time,o.order_id,o.condition,o.goods_count,o.adress_id,c.goods_name,e.goods_edition,c.goods_price,"
				+ "p.goods_pic,p.goods_color,oc.cname from `order` o,goods_pic p,goods_price c,ocondition oc,edition e "
				+ "where o.phone_num = ? and o.goods_id = c.goods_id and c.goods_name = p.goods_name and o.condition = oc.condition "
				+ "and o.goods_color = p.goods_color and c.edition_id = e.edition_id";
		if (!condition.equals(q)){
			sql = sql+" and o.condition = "+ condition;
		}
		sql += " limit "+(page-1)*4+",4";
		System.out.println(sql);
		List<Order> list = DBUtil.query(Order.class,sql,phone_num);
		return list;
	}

	public int cancel(String id) {
		String sql = "update `order` set `condition` = 3 where order_id = ?";
		System.out.println(sql);
		int n = DBUtil.zsg(sql,id);
		return n;
	}

	public int getcount(String condition,String phone_num) {
		String q = new String("0");
		String sql = "select count(*) from `order` where phone_num = "+ phone_num;
		if (!condition.equals(q)){
			sql = sql+" and `condition` = "+ condition;
		}
		return DBUtil.uniqueQuery(sql);
	}

		
}
