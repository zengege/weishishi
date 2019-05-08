package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Car;
import com.pojo.Carxs;
import com.util.DBUtil;

public class CarDAO {

	public int addCar(String goods_id, String phone_num, int goods_num,
			String goods_color, String goods_edition) {
		
		String sql = "insert into shop_car(goods_id,phone_num,goods_num,goods_color,goods_edition) values(?,?,?,?,?)";
		int n = DBUtil.zsg(sql, goods_id, phone_num, goods_num, goods_color,goods_edition);
System.out.println(n);
		System.out.println(n);
		if (n > 0) {
			System.out.println("已加入购物车");
			return n;
		}

		return 0;
	}

	public int delfromcar(String goods_id, String phone_num,String goods_color,String goods_edition) {

		String sql = "delete from  shop_car  where phone_num=? and goods_id=? and goods_color=? and goods_edition=?";
		int n = DBUtil.zsg(sql, phone_num, goods_id,goods_color,goods_edition);
		if (n > 0) {
			System.out.println("删除成功"+n);
			return n;
		}
		System.out.println("删除失败"+n);
		return 0;
	}

	// 用Car 还是CarAll？ CarAll 里面还有largetotal Car里面还有smalltotal



	public int update(String goods_id, String phone_num, int goods_num,String goods_color, String goods_edition) {
		
		String sql = "update shop_car  set goods_num=goods_num+? where phone_num=? and goods_id=? and goods_color=? and goods_edition=?";
		int n = DBUtil.zsg(sql, goods_num, phone_num, goods_id,goods_color, goods_edition);
		if (n > 0) {
			return n;
		}
		return 0;
	}



	public List<Car> selectphone_num(String phone_num, String goods_id, String goods_color, String goods_edition) {
String sql = "SELECT * from shop_car where  phone_num=? and goods_id=? and goods_color=? and goods_edition=?";
		List<Car> list = DBUtil.query(Carxs.class, sql, phone_num,goods_id,goods_color,goods_edition);
		return list;
	}

	public List<Carxs> showCar(String phone_num) {
		String sql = "SELECT c.goods_id,p.goods_name,c.goods_edition,c.goods_color,p.discounts,p.goods_price,c.goods_num,i.goods_pic from shop_car c,goods_price p,goods_pic i where phone_num=? and c.goods_id=p.goods_id and p.goods_name=i.goods_name and c.goods_color=i.goods_color";
		List<Carxs> list = new ArrayList<Carxs>();
		
		list = DBUtil.query(Carxs.class, sql, phone_num);
		//list.get(0).getDiscounts();
		return list;
	}

	public List<Car> seke(String goods_color, String goods_edition,
			String goods_id, String phone_num) {
		
			String sql = "SELECT * from shop_car where phone_num=? and goods_color=? and goods_edition=? and goods_id = ? ";
			
			List<Car> list = new ArrayList<Car>();
			
			list = DBUtil.query(Car.class, sql, phone_num,goods_color,goods_edition,goods_id);
			//list.get(0).getDiscounts();
			return list;
		
		
	}
	

	
	
	
	
	
	
}
