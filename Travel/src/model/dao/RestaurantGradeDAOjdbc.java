package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RestaurantGradeBean;


public class RestaurantGradeDAOjdbc {
	private static final String URL = "jdbc:sqlserver://10.211.55.3:1433;database=travel";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_MEMBERID = "SELECT * FROM RestaurantGrade WHERE MemberID=?";
	private static final String SELECT_RESTAURANTID = "SELECT memberId,RestaurantID,Evaluate FROM RestaurantGrade WHERE RestaurantID=?";
	private static final String SELECT = "SELECT memberId,RestaurantID,Evaluate FROM RestaurantGrade";
	private static final String INSERT = "insert into RestaurantGrade(memberId,RestaurantID,Evaluate) values(?,?,?)";
	private static final String UPDATE = "update RestaurantGrade set Evaluate=? where MemberID=? and RestaurantID=?";
	private static final String DELETE = "delete FROM RestaurantGrade where memberId=? and RestaurantID=?";
	private Connection conn= null;
	
	public List<RestaurantGradeBean> select(){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<RestaurantGradeBean> list = new ArrayList<RestaurantGradeBean>();
			while(rs.next()){
				RestaurantGradeBean cBean =new RestaurantGradeBean();
				cBean.setMemberId(rs.getInt(1));
				cBean.setRestaurantId(rs.getInt(2));
				cBean.setEvaluate(rs.getInt(3));
				list.add(cBean);
			}
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return null;
	}
	
	public List<RestaurantGradeBean> select(int restaurantId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT_RESTAURANTID);
			ps.setInt(1, restaurantId);
			ResultSet rs = ps.executeQuery();
			List<RestaurantGradeBean> list = new ArrayList<RestaurantGradeBean>();
			while(rs.next()){
				RestaurantGradeBean cBean =new RestaurantGradeBean();
				cBean.setRestaurantId(rs.getInt(2));
				cBean.setMemberId(rs.getInt(1));
				cBean.setEvaluate(rs.getInt(3));
				list.add(cBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return null;
	}
	
	public List<RestaurantGradeBean> insert(RestaurantGradeBean restaurantGradeBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setInt(1, restaurantGradeBean.getMemberId());
			ps.setInt(2, restaurantGradeBean.getRestaurantId());
			ps.setInt(3, restaurantGradeBean.getEvaluate());

			if(ps.executeUpdate()==1){
				return this.select(restaurantGradeBean.getRestaurantId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return null;
	}
	
	public List<RestaurantGradeBean> update(RestaurantGradeBean restaurantGradeBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setInt(2, restaurantGradeBean.getMemberId());
			ps.setInt(3, restaurantGradeBean.getRestaurantId());
			ps.setInt(1, restaurantGradeBean.getEvaluate());

			if(ps.executeUpdate()==1){
				return this.select(restaurantGradeBean.getRestaurantId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return null;
	}
	public boolean delete(int memberId,int restaurantId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,memberId);
			ps.setInt(2,restaurantId);
			if(ps.executeUpdate()==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return false;
	}
	public static void main(String[] args){
		RestaurantGradeDAOjdbc t = new RestaurantGradeDAOjdbc();
		
		RestaurantGradeBean cb = new RestaurantGradeBean();

		cb.setRestaurantId(1);
		cb.setMemberId(4);
		cb.setEvaluate(0);
//----------------------------------------------------------
//		System.out.println(t.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(t.insert(cb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(t.select("花蓮一日遊")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(t.update(cb)); //修改
//----------------------------------------------------------
		System.out.println(t.delete(2,2));//刪除
//----------------------------------------------------------
		for(RestaurantGradeBean e : t.select()){
			System.out.println(e);
		}
//----------------------------------------------------------
	}
}
