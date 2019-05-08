package com.dao;

import java.util.List;

import com.pojo.Goods_info1;
import com.util.DBUtil;

public class ShowGoodsDAO {
	public List<Goods_info1> findbylike(int page,int size, String like){
		String sql = "SELECT t.big_type,d.small_type,d.goods_name,d.lowest_price,d.show_pic  from goods_type t,details d WHERE  d.goods_name like concat('%',?,'%') AND t.small_type=d.small_type  OR t.small_type like concat('%',?,'%') AND  t.small_type=d.small_type  OR big_type LIKE concat('%',?,'%') AND t.small_type=d.small_type  LIMIT ?,?";
		List<Goods_info1> list = DBUtil.query(Goods_info1.class, sql,like,like,like,(page-1)*size,size);
		return list;
	}
	

	public int getlikecount(String like){
		String sql = "SELECT count(*) from goods_type t,details d WHERE  d.goods_name like concat('%',?,'%') AND t.small_type=d.small_type  OR t.small_type like concat('%',?,'%') AND  t.small_type=d.small_type  OR big_type LIKE concat('%',?,'%') AND t.small_type=d.small_type";
		int count = DBUtil.uniqueQuery(sql,like,like,like);
		return count;
	}
	public int getbigtypecount(String big_type){
		String sql = "SELECT COUNT(*) from goods_type t,details d where t.big_type = ?  and t.small_type = d.small_type";
		int count = DBUtil.uniqueQuery(sql,big_type);
		return count;
	}
	
	public List<Goods_info1> findbybig_type(int page,int size, String big_type){
		String sql = "SELECT big_type,t.small_type,d.goods_name,d.lowest_price,d.show_pic  from goods_type t,details d where big_type= ? and t.small_type = d.small_type limit ? , ? ";
		List<Goods_info1> list = DBUtil.query(Goods_info1.class, sql, big_type,(page-1)*size,size);
		return list;
	}
	public  int getsmalltypecount(String small_type){
		String sql ="SELECT COUNT(*) from details  where small_type = ?";
		int count = DBUtil.uniqueQuery(sql, small_type);
		return count;
	}
	public List<Goods_info1> findbysmall_type(int page,int size, String small_type){
		String sql = "SELECT big_type,t.small_type,d.goods_name,d.lowest_price,d.show_pic  from goods_type t,details d where d.small_type = ?  and t.small_type=d.small_type  limit ?, ? ";
		List<Goods_info1> list = DBUtil.query(Goods_info1.class, sql, small_type,(page-1)*size,size);
		return list;
	}
	
	public List<Goods_info1> findbysmallorderbyup(int page,int size, String small_type){
		String sql = "SELECT big_type,t.small_type,d.goods_name,d.lowest_price,d.show_pic  from goods_type t,details d where d.small_type = ?  and t.small_type=d.small_type order by d.lowest_price limit ?, ?  ";
		List<Goods_info1> list = DBUtil.query(Goods_info1.class, sql, small_type,(page-1)*size,size);
		return list;
	}
	public List<Goods_info1> findbysmallorderbydown(int page,int size, String small_type){
		String sql = "SELECT big_type,t.small_type,d.goods_name,d.lowest_price,d.show_pic  from goods_type t,details d where d.small_type = ?  and t.small_type=d.small_type order by d.lowest_price desc limit ?, ?  ";
		List<Goods_info1> list = DBUtil.query(Goods_info1.class, sql, small_type,(page-1)*size,size);
		return list;
	}
	
	public List<Goods_info1> findbybigorderbyup(int page,int size, String big_type){
		String sql = "SELECT big_type,t.small_type,d.goods_name,d.lowest_price,d.show_pic  from goods_type t,details d where big_type= ? and t.small_type = d.small_type order by d.lowest_price limit ? , ? ";
		List<Goods_info1> list = DBUtil.query(Goods_info1.class, sql, big_type,(page-1)*size,size);
		return list;
	}
	public List<Goods_info1> findbybigorderbydown(int page,int size, String big_type){
		String sql = "SELECT big_type,t.small_type,d.goods_name,d.lowest_price,d.show_pic  from goods_type t,details d where big_type= ? and t.small_type = d.small_type order by d.lowest_price desc limit ? , ? ";
		List<Goods_info1> list = DBUtil.query(Goods_info1.class, sql, big_type,(page-1)*size,size);
		return list;
	}
	
	
}
