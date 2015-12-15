package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.MemberBean;
import model.ThoughtBean;

public class ThoughtDAOjdbc {
	
	private static final String URL = "jdbc:sqlserver://10.211.55.3:1433;database=travel";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_ID = "SELECT * FROM Thought WHERE ThoughtID=?";
	private static final String SELECT_UESRNAME = "SELECT * FROM Thought WHERE thoughtName=?";
	private static final String SELECT = "SELECT * FROM Thought";
	private static final String INSERT = "insert into Thought(thoughtName,thoughtContent,thoughtType,memberId) values(?,?,?,?)";
	private static final String UPDATE = "update Thought set thoughtName=?,thoughtContent=?,thoughtType=?,memberId=? where ThoughtID=?";
	private static final String DELETE = "delete FROM Thought where ThoughtID=?";
	private SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Connection conn= null;
	
	public List<ThoughtBean> select(){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<ThoughtBean> list = new ArrayList<ThoughtBean>();
			while(rs.next()){
				ThoughtBean tBean =new ThoughtBean();
				tBean.setThoughtId(rs.getInt(1));
				tBean.setThoughtName(rs.getString(2));
				tBean.setThoughtContent(rs.getString(3));
				tBean.setThoughtType(rs.getString(4));
				tBean.setMemberId(rs.getInt(5));
				list.add(tBean);
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
	public ThoughtBean select(String thoughtName){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT_UESRNAME);
			ps.setString(1, thoughtName);
			ResultSet rs = ps.executeQuery();
			ThoughtBean tBean =new ThoughtBean();
			while(rs.next()){
				tBean.setThoughtId(rs.getInt(1));
				tBean.setThoughtName(rs.getString(2));
				tBean.setThoughtContent(rs.getString(3));
				tBean.setThoughtType(rs.getString(4));
				tBean.setMemberId(rs.getInt(5));
			}
			return tBean;
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
	public ThoughtBean select(int thoughtId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT_ID);
			ps.setInt(1, thoughtId);
			ResultSet rs = ps.executeQuery();
			ThoughtBean tBean =new ThoughtBean();
			while(rs.next()){
				tBean.setThoughtId(rs.getInt(1));
				tBean.setThoughtName(rs.getString(2));
				tBean.setThoughtContent(rs.getString(3));
				tBean.setThoughtType(rs.getString(4));
				tBean.setMemberId(rs.getInt(5));
			}
			return tBean;
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
	public ThoughtBean update(ThoughtBean thoughtBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setInt(5, thoughtBean.getThoughtId());
			ps.setString(1, thoughtBean.getThoughtName());
			ps.setString(2, thoughtBean.getThoughtContent());
			ps.setString(3, thoughtBean.getThoughtType());
			ps.setInt(4, thoughtBean.getMemberId());
			if(ps.executeUpdate()==1){
				return this.select(thoughtBean.getThoughtId());
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
	public ThoughtBean insert(ThoughtBean thoughtBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, thoughtBean.getThoughtName());
			ps.setString(2, thoughtBean.getThoughtContent());
			ps.setString(3, thoughtBean.getThoughtType());
			ps.setInt(4, thoughtBean.getMemberId());
			if(ps.executeUpdate()==1){
				return this.select(thoughtBean.getThoughtName());
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
	public boolean delete(int thoughtId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,thoughtId);
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
		ThoughtDAOjdbc t = new ThoughtDAOjdbc();
		
		ThoughtBean tb = new ThoughtBean();
		tb.setThoughtId(1);
		tb.setThoughtName("台中花海節");
		tb.setThoughtType("景點");
		tb.setThoughtContent("去台中玩還可以吃東東芋圓 非常不錯得景點");
		tb.setMemberId(1);
		
//		tb.setThoughtId(1);
//		tb.setThoughtName("台東熱氣球");
//		tb.setThoughtType("景點");
//		tb.setThoughtContent("泡溫泉 又可以看風景 還可以熱氣球唷");
//		tb.setMemberId(3);
//----------------------------------------------------------
		for(ThoughtBean e : t.select()){
			System.out.println(e);
		}
//----------------------------------------------------------
//		System.out.println(t.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(t.insert(tb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(t.select("花蓮一日遊")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(t.update(tb)); //修改
//----------------------------------------------------------
//		System.out.println(t.delete(1));//刪除
//----------------------------------------------------------
		
	}
}
