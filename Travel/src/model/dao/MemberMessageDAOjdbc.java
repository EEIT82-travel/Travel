package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.MemberMessageBean;


public class MemberMessageDAOjdbc {
	private static final String URL = "jdbc:sqlserver://10.211.55.3:1433;database=travel";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_MEMBERID = "SELECT * FROM MemberMessage WHERE MemberID=?";
	private static final String SELECT_ID = "SELECT * FROM MemberMessage WHERE MemberMessageID=?";
	private static final String SELECT = "SELECT * FROM MemberMessage";
	private static final String INSERT_SETTIME = "insert into MemberMessage(MemberMessageContent,MessaageTime,memberId) values(?,?,?)";
	private static final String INSERT = "insert into MemberMessage(MemberMessageContent,memberId) values(?,?)";
	private static final String UPDATE = "update MemberMessage set MemberMessageContent=?,MessaageTime=?,memberId=? where MemberMessageID=?";
	private static final String DELETE = "delete FROM MemberMessage where MemberMessageID=?";
	
	private Connection conn= null;
	
	public List<MemberMessageBean> select(){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<MemberMessageBean> list = new ArrayList<MemberMessageBean>();
			while(rs.next()){
				MemberMessageBean tBean =new MemberMessageBean();
				tBean.setMemberMessageID(rs.getInt(1));
				tBean.setMemberMessageContent(rs.getString(2));
				tBean.setMessaageTime(rs.getString(3));
				tBean.setMemberId(rs.getInt(4));
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
	public List<MemberMessageBean> selectMemberId(int memberId){
		try {
			SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT_MEMBERID);
			ps.setInt(1, memberId);
			ResultSet rs = ps.executeQuery();
			List<MemberMessageBean> list = new ArrayList<MemberMessageBean>();
			while(rs.next()){
				MemberMessageBean tBean =new MemberMessageBean();
				tBean.setMemberMessageID(rs.getInt(1));
				tBean.setMemberMessageContent(rs.getString(2));
				tBean.setMessaageTime(sf.format(rs.getTimestamp(3)));
				tBean.setMemberId(rs.getInt(4));
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
	public MemberMessageBean select(int memberMessageId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT_ID);
			ps.setInt(1, memberMessageId);
			ResultSet rs = ps.executeQuery();
			MemberMessageBean tBean =new MemberMessageBean();
			while(rs.next()){
				tBean.setMemberMessageID(rs.getInt(1));
				tBean.setMemberMessageContent(rs.getString(2));
				tBean.setMessaageTime(rs.getString(3));
				tBean.setMemberId(rs.getInt(4));
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
	public List<MemberMessageBean> insert(MemberMessageBean memberMessageBean) {
		try {
			SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT_SETTIME);
			ps.setString(1, memberMessageBean.getMemberMessageContent());
			ps.setDate(2, new java.sql.Date((sf.parse(memberMessageBean.getMessaageTime())).getTime()));
			ps.setInt(3, memberMessageBean.getMemberId());
			if(ps.executeUpdate()==1){
				return this.selectMemberId(memberMessageBean.getMemberId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
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
	public List<MemberMessageBean> update(MemberMessageBean memberMessageBean){
		try {
			SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setString(1, memberMessageBean.getMemberMessageContent());
			Date date = new java.sql.Date((sf.parse(memberMessageBean.getMessaageTime())).getTime());
			ps.setTimestamp(2, new Timestamp(date.getTime()));
			ps.setInt(3, memberMessageBean.getMemberId());
			ps.setInt(4, memberMessageBean.getMemberMessageID());
			if(ps.executeUpdate()==1){
				return this.selectMemberId(memberMessageBean.getMemberId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
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
	public boolean delete(int memberMessageID){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,memberMessageID);
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
		MemberMessageDAOjdbc t = new MemberMessageDAOjdbc();
		
		MemberMessageBean tb = new MemberMessageBean();
		tb.setMemberMessageID(2);
		tb.setMemberMessageContent("會員提醒你 生日快樂");
		tb.setMessaageTime("2011-12-22 22:44:44");
		tb.setMemberId(3);
		
//		tb.setThoughtId(1);
//		tb.setThoughtName("台東熱氣球");
//		tb.setThoughtType("景點");
//		tb.setThoughtContent("泡溫泉 又可以看風景 還可以熱氣球唷");
//		tb.setMemberId(3);
//----------------------------------------------------------
//		System.out.println(t.select(5));  //單筆select
//----------------------------------------------------------
//		for(MemberMessageBean e : t.insert(tb)){
//			System.out.println(e);
//		}										// 新增資料
//----------------------------------------------------------
//		System.out.println(t.select("花蓮一日遊")); //單筆select 
//----------------------------------------------------------
//		System.out.println(t.update(tb)); //修改
//----------------------------------------------------------
		System.out.println(t.delete(1));//刪除
//----------------------------------------------------------
		for(MemberMessageBean e : t.select()){
			System.out.println(e);
		}
//----------------------------------------------------------
	}
		
}

