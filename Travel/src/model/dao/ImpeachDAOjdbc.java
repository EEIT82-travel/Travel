package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.ImpeachBean;


public class ImpeachDAOjdbc {
	
	private static final String URL = "jdbc:sqlserver://10.211.55.3:1433;database=travel";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_ID = "SELECT * FROM Impeach WHERE ImpeachID=?";
//	private static final String SELECT_UESRNAME = "SELECT * FROM Impeach WHERE =?";
	private static final String SELECT = "SELECT ImpeachID,RestaurantID,RestaurantMessageID,ThoughtID,SceneMessageID,SceneID,Impeach,InpeachTime FROM Impeach";
//	private static final String INSERT = "insert into Impeach(restaurantId,restaurantMessageId,thoughtId,sceneMessageId,sceneId,impeach,inpeachTime) values(?,?,?,?,?,?,?)";
	private static final String INSERT_RESTAURANTID = "insert into Impeach(RESTAURANTID,impeach,inpeachTime) values(?,?,?)";
	private static final String INSERT_RESTAURANTMESSAGEID= "insert into Impeach(restaurantMessageId,impeach,inpeachTime) values(?,?,?)";
	private static final String INSERT_THOUGHTID = "insert into Impeach(thoughtId,impeach,inpeachTime) values(?,?,?)";
	private static final String INSERT_SCENEMESSAGEID = "insert into Impeach(sceneMessageId,impeach,inpeachTime) values(?,?,?)";
	private static final String INSERT_SCENEID = "insert into Impeach(sceneId,impeach,inpeachTime) values(?,?,?)";
//	private static final String UPDATE = "update Impeach set thoughtName=?,thoughtContent=?,thoughtType=?,memberId=? where ImpeachID=?";
	private static final String DELETE = "delete FROM Impeach where ImpeachID=?";
	private SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Connection conn= null;
	
	public boolean delete(int impeachId){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,impeachId);
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
	
	public List<ImpeachBean> insertSceneId(ImpeachBean impeachBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT_SCENEID);
			ps.setInt(1, impeachBean.getSceneId());
			ps.setString(2, impeachBean.getImpeach());
			ps.setTimestamp(3, new Timestamp(sf.parse(impeachBean.getInpeachTime()).getTime()));
			if(ps.executeUpdate()==1){
				return this.select();
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
	public List<ImpeachBean> insertSceneMessageId(ImpeachBean impeachBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT_SCENEMESSAGEID);
			ps.setInt(1, impeachBean.getSceneMessageId());
			ps.setString(2, impeachBean.getImpeach());
			ps.setTimestamp(3, new Timestamp(sf.parse(impeachBean.getInpeachTime()).getTime()));
			if(ps.executeUpdate()==1){
				return this.select();
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
	
	public List<ImpeachBean> insertThoughtId(ImpeachBean impeachBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT_THOUGHTID);
			ps.setInt(1, impeachBean.getThoughtId());
			ps.setString(2, impeachBean.getImpeach());
			ps.setTimestamp(3, new Timestamp(sf.parse(impeachBean.getInpeachTime()).getTime()));
			if(ps.executeUpdate()==1){
				return this.select();
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
	public List<ImpeachBean> insertRestaurantMessageId(ImpeachBean impeachBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT_RESTAURANTMESSAGEID);
			ps.setInt(1, impeachBean.getRestaurantMessageId());
			ps.setString(2, impeachBean.getImpeach());
			ps.setTimestamp(3, new Timestamp(sf.parse(impeachBean.getInpeachTime()).getTime()));
			if(ps.executeUpdate()==1){
				return this.select();
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
	public List<ImpeachBean> insertRestaurantId(ImpeachBean impeachBean){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(INSERT_RESTAURANTID);
			ps.setInt(1, impeachBean.getRestaurantId());
			ps.setString(2, impeachBean.getImpeach());
			ps.setTimestamp(3, new Timestamp(sf.parse(impeachBean.getInpeachTime()).getTime()));
			if(ps.executeUpdate()==1){
				return this.select();
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
	
	public List<ImpeachBean> select(){
		try {
			conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<ImpeachBean> list = new ArrayList<ImpeachBean>();
//"SELECT ImpeachID,RestaurantID,RestaurantMessageID,ThoughtID,SceneMessageID,SceneID,Impeach,InpeachTime FROM Impeach";
			while(rs.next()){
				ImpeachBean tBean =new ImpeachBean();
				tBean.setImpeachId(rs.getInt(1));
				tBean.setRestaurantId(rs.getInt(2));
				tBean.setRestaurantMessageId(rs.getInt(3));
				tBean.setThoughtId(rs.getInt(4));
				tBean.setSceneMessageId(rs.getInt(5));
				tBean.setSceneId(rs.getInt(6));
				tBean.setImpeach(rs.getString(7));
				tBean.setInpeachTime(sf.format(rs.getTimestamp(8)));
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
	public static void main(String[] args){
		ImpeachDAOjdbc t = new ImpeachDAOjdbc();
		SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		ImpeachBean tb = new ImpeachBean();
		tb.setImpeach("我要檢舉");
		tb.setRestaurantId(1);
		tb.setInpeachTime("2012-10-10 23:23:22");
		tb.setRestaurantMessageId(1);
		tb.setSceneId(1);
		tb.setSceneMessageId(1);
		tb.setThoughtId(1);
		
//----------------------------------------------------------
		for(ImpeachBean e : t.select()){
			System.out.println(e);
		}
//----------------------------------------------------------
//		System.out.println(t.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(t.insertRestaurantId(tb)); // 新增餐廳檢舉
//		System.out.println(t.insertRestaurantMessageId(tb)); // 新增餐廳訊息檢舉
//		System.out.println(t.insertThoughtId(tb)); // 新增餐廳訊息檢舉
//----------------------------------------------------------
//		System.out.println(t.select("花蓮一日遊")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(t.update(tb)); //修改
//----------------------------------------------------------
//		System.out.println(t.delete(2));//刪除
//----------------------------------------------------------
		
	}
}
