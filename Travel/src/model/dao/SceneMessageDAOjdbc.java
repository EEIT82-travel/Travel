package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SceneMessageBean;

public class SceneMessageDAOjdbc {
	//DB連線資訊
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=travel";
	private static final String USERNAME = "sa";

	private static final String PASSWORD = "sa123456";	
	//select
	private static final String SELECT_ALL = "select * from scenemessage";
	private static final String SELECT_BY_SCENEID = "select * from scenemessage where sceneId = ?";	
	//insert
	private static final String INSERT = 
			"insert into scenemessage"
		  + " (messageContent,memberId,sceneId) "
		  + "values(?, ?, ?)";
	//update
	private static final String UPDATE = "update scenemessage set messageContent=?,memberId=?,sceneId=?";	
	//delete
	private static final String DELETE = "delete from scenemessage where sceneMessageId=?";
	private Connection conn = null;
	
	//查詢 SELECT_ALL
	public  List<SceneMessageBean> select() {
		List<SceneMessageBean> list = null;
		SceneMessageBean smbean =null;
		try (//AutoCloseable
			 Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD); 
			 ){
			
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<SceneMessageBean>();
			while(rs.next()){
				smbean = new SceneMessageBean();
				smbean.setSceneMessageId(rs.getInt(1));
				smbean.setMessageContent(rs.getString(2));
				smbean.setMemberId(rs.getInt(3));
				smbean.setSceneId(rs.getInt(4));
				
				list.add(smbean);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	//查詢SELECT_BY_SCENEID
	public  SceneMessageBean select(int sceneId) {
		SceneMessageBean smbean =null;
		try (
			 Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD); 
			 ){
			PreparedStatement ps = conn.prepareStatement(SELECT_BY_SCENEID);
			ps.setInt(1, sceneId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				smbean = new SceneMessageBean();				
				smbean.setSceneMessageId(rs.getInt(1));
				smbean.setMessageContent(rs.getString(2));
				smbean.setMemberId(rs.getInt(3));
				smbean.setSceneId(rs.getInt(4));	
			}		
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	
		return smbean;
	}
	
	//新增INSERT
	public SceneMessageBean insert(SceneMessageBean bean) {
		SceneMessageBean result = null;
		try (
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);	
				){
			PreparedStatement ps = conn.prepareStatement(INSERT);
			if(bean != null){
			ps.setString(1, bean.getMessageContent());
			ps.setInt(2, bean.getMemberId());
			ps.setInt(3, bean.getSceneId());
								
			int rs = ps.executeUpdate();
			if (rs == 1){
				result = bean;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//修改UPDATE
	public SceneMessageBean update(SceneMessageBean bean){
		SceneMessageBean result = null;
		try (
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);	
				){
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			if(bean != null){
				ps.setString(1, bean.getMessageContent());
				ps.setInt(2, bean.getMemberId());
				ps.setInt(3, bean.getSceneId());
					
			int rs = ps.executeUpdate();
			if (rs == 1){
				result = bean;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//刪除DELETE
	public boolean delete(int sceneMessageId) {
		try (
				Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);	
					){
				PreparedStatement ps = conn.prepareStatement(DELETE);
				
				ps.setInt(1, sceneMessageId);
									
				int rs = ps.executeUpdate();
				if (rs == 1){
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	
	
	public static void main(String[] args){
		SceneMessageDAOjdbc test = new SceneMessageDAOjdbc();
//----------------------------------------------------------
//		List<SceneMessageBean> li= test.select();  //全部select
//		for(SceneMessageBean e:li){
//			System.out.println(e);
//		}
//----------------------------------------------------------
		System.out.println(test.select(2));  //單筆select
//----------------------------------------------------------
		SceneMessageBean smbean = new SceneMessageBean();
		smbean.setMessageContent("好玩");
		smbean.setMemberId(5);
		smbean.setSceneId(3);

		
//		
		System.out.println(test.insert(smbean)); // 新增資料
//----------------------------------------------------------
//		System.out.println(test.select("text123")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(test.update(smbean)); //修改
//----------------------------------------------------------
//		System.out.println(test.delete(3));//刪除
//----------------------------------------------------------
//		FileOutputStream fo = new FileOutputStream("/Users/mouse/Desktop/4.jpg");   //把圖片取出來放桌面 
//		fo.write(m.select(2).getPhoto(), 0, t);
//		fo.close();
//----------------------------------------------------------
		
	}
}//class
