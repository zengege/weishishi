package com.dao;

import java.util.List;

import com.pojo.GoodsEdition;
import com.pojo.GoodsJudge;
import com.pojo.User;
import com.util.DBUtil;

public class JudgeDAO {
	
	public int insertJufge(String goods_name,String phone_num,String judge_pic,String judge_time){
		String sql = "insert into judge(goods_name,phone_num,judge_pic,judge_time) values(?,?,?,?)";
		int n = DBUtil.zsg(sql, goods_name,phone_num,judge_pic,judge_time);
		return n;
	}
	
	
	
	public int insertJufge2(String phone_num,String judge_words){
		String sql = "insert into judge_word(phone_num,judge_words) values(?,?)";
		int n = DBUtil.zsg(sql, phone_num,judge_words);
		return n;
	}
	
	public List<GoodsJudge> getJudge(String goodsname,String username){
		String sql = "SELECT judge.phone_num,judge.judge_pic,judge.judge_time,judge_word.judge_words from judge JOIN judge_word on judge.phone_num = judge_word.phone_num WHERE goods_name=? and judge.phone_num = ?";
		List<GoodsJudge> list = DBUtil.query(GoodsJudge.class, sql, goodsname,username);
			return list;
			
		}
	public List<GoodsJudge> getJudgecount(String goodsname){
		String sql = "SELECT DISTINCT phone_num from judge where goods_name = ?";
		List<GoodsJudge> list = DBUtil.query(GoodsJudge.class, sql,goodsname);
			return list;
		}
	
	public int findUser(String userPhone){
		String sql = "select phone_num from judge_word where phone_num=?";
		List<GoodsJudge> list = DBUtil.query(GoodsJudge.class, sql, userPhone);
		
		return list.size();
	}

}
