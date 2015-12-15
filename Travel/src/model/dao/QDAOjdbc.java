package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.QBean;


public class QDAOjdbc {

	private static final String URL = "jdbc:sqlserver://10.211.55.3:1433;database=travel";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_ID = "SELECT * FROM Q WHERE Qid=?";
	private static final String SELECT_NAME = "SELECT * FROM Q WHERE Qname=?";
	private static final String SELECT = "SELECT Qid,Qname,ans,a,b,c,d FROM Q";
	private static final String INSERT = "insert into Q(Qname,ans,a,b,c,d) values(?,?,?,?,?,?)";
	private static final String UPDATE = "update Q set Qname=?,ans=?,a=?,b=?,c=?,d=? where QID=?";
	private static final String DELETE = "delete FROM Q where QID=?";
	private SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Connection conn= null;
	
	public List<QBean> select(){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<QBean> list = new ArrayList<QBean>();
			while(rs.next()){
				QBean tBean =new QBean();
				tBean.setqId(rs.getInt(1));
				tBean.setQName(rs.getString(2));
				tBean.setAns(rs.getString(3));
				tBean.setA(rs.getString(4));
				tBean.setB(rs.getString(5));
				tBean.setC(rs.getString(6));
				tBean.setD(rs.getString(7));
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
	public QBean select(int qId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT_ID);
			ps.setInt(1, qId);
			ResultSet rs = ps.executeQuery();
			QBean tBean =new QBean();
			while(rs.next()){
				tBean.setqId(rs.getInt(1));
				tBean.setQName(rs.getString(2));
				tBean.setAns(rs.getString(3));
				tBean.setA(rs.getString(4));
				tBean.setB(rs.getString(5));
				tBean.setC(rs.getString(6));
				tBean.setD(rs.getString(7));
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
	public QBean select(String qName){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT_NAME);
			ps.setString(1, qName);
			ResultSet rs = ps.executeQuery();
			QBean tBean =new QBean();
			while(rs.next()){
				tBean.setqId(rs.getInt(1));
				tBean.setQName(rs.getString(2));
				tBean.setAns(rs.getString(3));
				tBean.setA(rs.getString(4));
				tBean.setB(rs.getString(5));
				tBean.setC(rs.getString(6));
				tBean.setD(rs.getString(7));
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
	public boolean delete(int qId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,qId);
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
	public QBean insert(QBean qBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, qBean.getQName());
			ps.setString(2, qBean.getAns());
			ps.setString(3, qBean.getA());
			ps.setString(4, qBean.getB());
			ps.setString(5, qBean.getC());
			ps.setString(6, qBean.getD());
			if(ps.executeUpdate()==1){
				return this.select(qBean.getQName());
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
	public QBean update(QBean qBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setString(1, qBean.getQName());
			ps.setString(2, qBean.getAns());
			ps.setString(3, qBean.getA());
			ps.setString(4, qBean.getB());
			ps.setString(5, qBean.getC());
			ps.setString(6, qBean.getD());
			ps.setInt(7, qBean.getqId());
			if(ps.executeUpdate()==1){
				return this.select(qBean.getQName());
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
	public static void main(String[] args){
		QDAOjdbc t = new QDAOjdbc();
		
		QBean tb = new QBean();
		tb.setqId(5);
		tb.setQName("QQQQQQ");
		tb.setAns("A");
		tb.setA("w");
		tb.setB("w");
		tb.setC("w");
		tb.setD("w");
		
//----------------------------------------------------------
//		for(QBean e : t.select()){
//			System.out.println(e);
//		}
//----------------------------------------------------------
//		System.out.println(t.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(t.insert(tb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(t.select("花蓮一日遊")); //單筆select （帳號）
//----------------------------------------------------------
		System.out.println(t.update(tb)); //修改
//----------------------------------------------------------
//		System.out.println(t.delete(1));//刪除
//----------------------------------------------------------
	}	
}
