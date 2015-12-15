package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SceneGradeBean;


public class SceneGradreDAOjdbc {
	private static final String URL = "jdbc:sqlserver://10.211.55.3:1433;database=travel";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_MEMBERID = "SELECT * FROM SceneGrade WHERE MemberID=?";
	private static final String SELECT_SCENEID = "SELECT memberId,SceneID,Evaluate FROM SceneGrade WHERE SceneID=?";
	private static final String SELECT = "SELECT memberId,SceneID,Evaluate FROM SceneGrade";
	private static final String INSERT = "insert into SceneGrade(memberId,SceneID,Evaluate) values(?,?,?)";
	private static final String UPDATE = "update SceneGrade set Evaluate=? where MemberID=? and SceneID=?";
	private static final String DELETE = "delete FROM SceneGrade where memberId=? and SceneID=?";
	private Connection conn= null;
	
	public List<SceneGradeBean> select(){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<SceneGradeBean> list = new ArrayList<SceneGradeBean>();
			while(rs.next()){
				SceneGradeBean cBean =new SceneGradeBean();
				cBean.setMemberId(rs.getInt(1));
				cBean.setSceneId(rs.getInt(2));
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
	
	public List<SceneGradeBean> select(int sceneId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT_SCENEID);
			ps.setInt(1, sceneId);
			ResultSet rs = ps.executeQuery();
			List<SceneGradeBean> list = new ArrayList<SceneGradeBean>();
			while(rs.next()){
				SceneGradeBean cBean =new SceneGradeBean();
				cBean.setSceneId(rs.getInt(2));
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
	
	public List<SceneGradeBean> insert(SceneGradeBean sceneGradeBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setInt(1, sceneGradeBean.getMemberId());
			ps.setInt(2, sceneGradeBean.getSceneId());
			ps.setInt(3, sceneGradeBean.getEvaluate());

			if(ps.executeUpdate()==1){
				return this.select(sceneGradeBean.getSceneId());
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
	
	public List<SceneGradeBean> update(SceneGradeBean sceneGradeBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setInt(2, sceneGradeBean.getMemberId());
			ps.setInt(3, sceneGradeBean.getSceneId());
			ps.setInt(1, sceneGradeBean.getEvaluate());

			if(ps.executeUpdate()==1){
				return this.select(sceneGradeBean.getSceneId());
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
	public boolean delete(int memberId,int sceneId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,memberId);
			ps.setInt(2,sceneId);
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
		SceneGradreDAOjdbc t = new SceneGradreDAOjdbc();
		
		SceneGradeBean cb = new SceneGradeBean();

		cb.setSceneId(1);
		cb.setMemberId(5);
		cb.setEvaluate(11);
//----------------------------------------------------------
//		System.out.println(t.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(t.insert(cb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(t.update(cb)); //修改
//----------------------------------------------------------
//		System.out.println(t.delete(2,2));//刪除
//----------------------------------------------------------
		for(SceneGradeBean e : t.select()){
			System.out.println(e);
		}
//----------------------------------------------------------
	}
}
