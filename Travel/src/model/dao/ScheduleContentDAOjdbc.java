package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ScheduleContentBean;

public class ScheduleContentDAOjdbc {
	private static final String URL = "jdbc:sqlserver://10.211.55.3:1433;database=travel";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_ID = "SELECT * FROM ScheduleContent WHERE ScheduleContentID=?";
	private static final String SELECT = "SELECT ScheduleContentId,ScheduleOrder,SceneID,ScheduleID FROM ScheduleContent";
	private static final String INSERT = "insert into ScheduleContent(scheduleOrder,sceneId,scheduleId) values(?,?,?)";
	private static final String UPDATE = "update ScheduleContent set scheduleOrder=?,sceneId=? ,scheduleId=? where ScheduleContentID=?";
	private static final String DELETE = "delete FROM ScheduleContent where ScheduleContentID=?";
	private Connection conn= null;
	
	public List<ScheduleContentBean> select(){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<ScheduleContentBean> list = new ArrayList<ScheduleContentBean>();
			while(rs.next()){
				ScheduleContentBean sBean =new ScheduleContentBean();
				sBean.setScheduleContentId(rs.getInt(1));
				sBean.setScheduleOrder(rs.getInt(2));
				sBean.setSceneId(rs.getInt(3));
				sBean.setScheduleId(rs.getInt(4));
				list.add(sBean);
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
	public ScheduleContentBean select(int scheduleContentId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT_ID);
			ps.setInt(1, scheduleContentId);
			ResultSet rs = ps.executeQuery();
			ScheduleContentBean sBean =new ScheduleContentBean();
			while(rs.next()){
				sBean.setScheduleContentId(rs.getInt(1));
				sBean.setScheduleOrder(rs.getInt(2));
				sBean.setSceneId(rs.getInt(3));
				sBean.setScheduleId(rs.getInt(4));
			}
			return sBean;
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
	public boolean insert(ScheduleContentBean scheduleContentBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setInt(1, scheduleContentBean.getScheduleOrder());
			ps.setInt(2, scheduleContentBean.getSceneId());
			ps.setInt(3, scheduleContentBean.getScheduleId());
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
	public boolean delete(int scheduleContentId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1, scheduleContentId);;
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
	public ScheduleContentBean update(ScheduleContentBean scheduleContentBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setInt(1, scheduleContentBean.getScheduleOrder());
			ps.setInt(2, scheduleContentBean.getSceneId());
			ps.setInt(3, scheduleContentBean.getScheduleId());
			ps.setInt(4, scheduleContentBean.getScheduleContentId());
			
			if(ps.executeUpdate()==1){
				return this.select(scheduleContentBean.getScheduleContentId());
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
		ScheduleContentDAOjdbc s = new ScheduleContentDAOjdbc();
		ScheduleContentBean sb = new ScheduleContentBean();
		sb.setScheduleContentId(4);;
		sb.setScheduleOrder(2);;
		sb.setSceneId(2);
		sb.setScheduleId(1);
//----------------------------------------------------------
//		System.out.println(s.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(s.insert(sb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(s.update(sb)); //修改
//----------------------------------------------------------
//		System.out.println(s.delete(4));//刪除
//----------------------------------------------------------
		for(ScheduleContentBean e : s.select()){
			System.out.println(e);
		}
//----------------------------------------------------------
	}
}
