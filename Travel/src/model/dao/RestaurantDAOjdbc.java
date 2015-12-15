package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RestaurantBean;

public class RestaurantDAOjdbc {

	// DB連線資訊
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=travel";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";
	// select
	private static final String SELECT_ALL = "select * from restaurant";
	private static final String SELECT_BY_LOCATION = "select * from restaurant where location = ?";
	// insert
	private static final String INSERT = "insert into restaurant"
			+ " (location,city,restaurantName,restaurantContent,timeStart,timeEnd,price,telephone,evaluate,fans,MemberId) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	// update
	private static final String UPDATE = "update restaurant set location=?,city=?,restaurantName=?,"
			+ "restaurantContent=?,timeStart=?,timeEnd=?,price=?,telephone=?,evaluate=?,fans=?,MemberId=?";
	// delete
	private static final String DELETE = "delete from restaurant where restaurantName=?";
	private Connection conn = null;
	
	// 查詢 SELECT_ALL
	public List<RestaurantBean> select() {
		List<RestaurantBean> list = null;
		RestaurantBean rbean = null;
		try (// AutoCloseable
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {

			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<RestaurantBean>();
			while (rs.next()) {
				rbean = new RestaurantBean();
				rbean.setRestaurantId(rs.getInt(1));
				rbean.setLocation(rs.getString(2));
				rbean.setCity(rs.getString(3));
				rbean.setRestaurantName(rs.getString(4));
				rbean.setRestaurantContent(rs.getString(5));
				rbean.setTimeStart(rs.getString(6));
				rbean.setTimeEnd(rs.getString(7));
				rbean.setPrice(rs.getString(8));
				rbean.setTelephone(rs.getString(9));
				rbean.setEvaluate(rs.getInt(10));
				rbean.setFans(rs.getString(11));				
				rbean.setMemberId(rs.getInt(12));
				list.add(rbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 查詢SELECT_BY_LOCATION
	public RestaurantBean select(String location) {
		RestaurantBean rbean = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			PreparedStatement ps = conn.prepareStatement(SELECT_BY_LOCATION);
			ps.setString(1, location);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rbean = new RestaurantBean();
				rbean.setRestaurantId(rs.getInt(1));
				rbean.setLocation(rs.getString(2));
				rbean.setCity(rs.getString(3));
				rbean.setRestaurantName(rs.getString(4));
				rbean.setRestaurantContent(rs.getString(5));
				rbean.setTimeStart(rs.getString(6));
				rbean.setTimeEnd(rs.getString(7));
				rbean.setPrice(rs.getString(8));
				rbean.setTelephone(rs.getString(9));
				rbean.setEvaluate(rs.getInt(10));
				rbean.setFans(rs.getString(11));				
				rbean.setMemberId(rs.getInt(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rbean;
	}

	// 新增INSERT
	public RestaurantBean insert(RestaurantBean bean) {
		RestaurantBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			if (bean != null) {
				ps.setString(1, bean.getLocation());
				ps.setString(2, bean.getCity());
				ps.setString(3, bean.getRestaurantName());
				ps.setString(4, bean.getRestaurantContent());
				ps.setString(5, bean.getTimeStart());
				ps.setString(6, bean.getTimeEnd());
				ps.setString(7, bean.getPrice());
				ps.setString(8, bean.getTelephone());
				ps.setInt(9, bean.getEvaluate());
				ps.setString(10, bean.getFans());
				ps.setInt(11, bean.getMemberId());

				int rs = ps.executeUpdate();
				if (rs == 1) {
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 修改UPDATE
	public RestaurantBean update(RestaurantBean bean) {
		RestaurantBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			if (bean != null) {
				ps.setString(1, bean.getLocation());
				ps.setString(2, bean.getCity());
				ps.setString(3, bean.getRestaurantName());
				ps.setString(4, bean.getRestaurantContent());
				ps.setString(5, bean.getTimeStart());
				ps.setString(6, bean.getTimeEnd());
				ps.setString(7, bean.getPrice());
				ps.setString(8, bean.getTelephone());
				ps.setInt(9, bean.getEvaluate());
				ps.setString(10, bean.getFans());
				ps.setInt(11, bean.getMemberId());

				int rs = ps.executeUpdate();
				if (rs == 1) {
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 刪除DELETE
	public boolean delete(String sceneName) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			PreparedStatement ps = conn.prepareStatement(DELETE);

			ps.setString(1, sceneName);

			int rs = ps.executeUpdate();
			if (rs == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	public static void main(String[] args){
		RestaurantDAOjdbc test = new RestaurantDAOjdbc();
//----------------------------------------------------------
//		List<RestaurantBean> li= test.select();  //全部select
//		for(RestaurantBean e:li){
//			System.out.println(e);
//		}
//----------------------------------------------------------
//		System.out.println(test.select("北區"));  //單筆select
//----------------------------------------------------------
		RestaurantBean rbean = new RestaurantBean();
		rbean.setLocation("北區");
		rbean.setCity("新北市");
		rbean.setRestaurantName("tina廚房");
		rbean.setRestaurantContent("很好吃XXXXXXX");
		rbean.setTimeStart("09:00");
		rbean.setTimeEnd("21:00");
		rbean.setPrice("300");
		rbean.setTelephone("02-xxxxxxxx");
		rbean.setEvaluate(4);
		rbean.setFans("http://fans.xxx.xxx");
    	rbean.setMemberId(1);
//		
//		System.out.println(test.insert(rbean)); // 新增資料
//----------------------------------------------------------
//		System.out.println(test.select("text123")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(test.update(rbean)); //修改
//----------------------------------------------------------
//		System.out.println(test.delete("tina廚房"));//刪除
//----------------------------------------------------------
//		FileOutputStream fo = new FileOutputStream("/Users/mouse/Desktop/4.jpg");   //把圖片取出來放桌面 
//		fo.write(m.select(2).getPhoto(), 0, t);
//		fo.close();
//----------------------------------------------------------
		
	}
}//class
