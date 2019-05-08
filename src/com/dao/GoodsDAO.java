package com.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import com.pojo.Goods;
import com.pojo.GoodsColor;
import com.pojo.GoodsDetail;
import com.pojo.GoodsEdition;
import com.util.DBUtil;

public class GoodsDAO implements Serializable{
	public Goods getgoodsdetail(String goodsname){
	String sql = "select goods_id,goods_price.goods_name,discounts,goods_price,goods_desc,goods_type,big_type,goods_pic,goods_color,goods_edition from goods_pic join goods_price ON goods_pic.goods_name = goods_price.goods_name  join edition on edition.edition_id = goods_price.edition_id  join goods_type on goods_type.small_type=goods_price.goods_type where goods_price.goods_name = ? LIMIT 1";
	
	List<Goods> list = DBUtil.query(Goods.class, sql, goodsname);
		return list.get(0);
		
	}
	public List<GoodsColor> getgoodscolor(String goodsname){
		String sql = "SELECT goods_color,goods_pic FROM goods_pic where goods_name=?";
		
		List<GoodsColor> list = DBUtil.query(GoodsColor.class, sql, goodsname);
			return list;
			
		}
	public List<GoodsEdition> getgoodedition(String goodsname){
		String sql = "SELECT goods_edition from goods_price JOIN edition on goods_price.edition_id = edition.edition_id where goods_name=?";
		
		List<GoodsEdition> list = DBUtil.query(GoodsEdition.class, sql, goodsname);
			return list;
			
		}
	public GoodsDetail getdetailpic(String goodsname){
		String sql = "select detail from details where goods_name = ?";
		
		List<GoodsDetail> list = DBUtil.query(GoodsDetail.class, sql, goodsname);
			return list.get(0);
			
		}
	public List<GoodsEdition> getgoodeditionprice(String goodsname){
		String sql = "SELECT edition_id,goods_price,discounts,goods_id FROM goods_price where goods_name=?";
		
		List<GoodsEdition> list = DBUtil.query(GoodsEdition.class, sql, goodsname);
			return list;
			
		}
	public static String getgoodsid(String goods_name,String goods_edition) {
		Connection connection = DBUtil.getConnection();
		String sql = "SELECT goods_id FROM goods_price where goods_name =? and edition_id in(select edition_id from edition where goods_edition=?)";
		String ch = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, goods_name);
			ps.setObject(2, goods_edition);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ch = rs.getString(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		System.out.println(ch);
		return ch;

	}
	
	
	
	
}
