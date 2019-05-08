package com.dao;

import java.util.List;

import com.pojo.User;
import com.util.DBUtil;

public class UserDAO {
	
	public int findUserPhone(String userPhone){
		String sql = "select phone_num from user where phone_num=?";
		List<User> list = DBUtil.query(User.class, sql, userPhone);
		
		return list.size();
	}
	public int findUserEmail(String userEmail){
		String sql = "select email from user where email=?";
		List<User> list = DBUtil.query(User.class, sql, userEmail);
		
		return list.size();
	}
	
	
	
	public int userRegister(String country,String phone,String password){
		String sql = "insert into user(country,phone_num,password) values(?,?,?)";
		int n = DBUtil.zsg(sql, country,phone,password);
		return n;
	}
	public int userRegister_2(String country,String email,String phone,String password){
		String sql = "insert into user(country,email,phone_num,password) values(?,?,?,?)";
		int n = DBUtil.zsg(sql, country,email,phone,password);
		return n;
	}
	public int userLogin(String phone,String password){
		String sql = "select phone_num,password from user where phone_num=? and password=?";
		List<User> list = DBUtil.query(User.class, sql, phone,password);
		return list.size();
	}
	public int userEmailLogin(String email,String password){
		String sql = "select email,password from user where email=? and password=?";
		List<User> list = DBUtil.query(User.class, sql, email,password);
		return list.size();
	}
	
}
