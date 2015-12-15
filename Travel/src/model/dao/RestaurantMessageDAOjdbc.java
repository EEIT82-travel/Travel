package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RestaurantMessageBean;

public class RestaurantMessageDAOjdbc {
	// DB連線資訊
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=travel";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";
	// select
	private static final String SELECT_ALL = "select * from RestaurantMessage";
	private static final String SELECT_BY_RESTAURANTID = "select * from RestaurantMessage where restaurantId = ?";
	// insert
	private static final String INSERT = "insert into RestaurantMessage" + " (messageContent,restaurantId,memberId) "
			+ "values(?, ?, ?)";
	// update
	private static final String UPDATE = "update RestaurantMessage set messageContent=?,restaurantId=?,memberId=?";
	// delete
	private static final String DELETE = "delete from RestaurantMessage where restaurantMessageId=?";
	private Connection conn = null;

	// 查詢 SELECT_ALL
	public List<RestaurantMessageBean> select() {
		List<RestaurantMessageBean> list = null;
		RestaurantMessageBean rmbean = null;
		try (// AutoCloseable
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {

			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<RestaurantMessageBean>();
			while (rs.next()) {
				rmbean = new RestaurantMessageBean();
				rmbean.setRestaurantMessageId(rs.getInt(1));
				rmbean.setMessageContent(rs.getString(2));
				rmbean.setRestaurantId(rs.getInt(3));
				rmbean.setMemberId(rs.getInt(4));

				list.add(rmbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 查詢SELECT_BY_RESTAURANTID
	public RestaurantMessageBean select(int sceneId) {
		RestaurantMessageBean rmbean = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			PreparedStatement ps = conn.prepareStatement(SELECT_BY_RESTAURANTID);
			ps.setInt(1, sceneId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rmbean = new RestaurantMessageBean();
				rmbean.setRestaurantMessageId(rs.getInt(1));
				rmbean.setMessageContent(rs.getString(2));
				rmbean.setRestaurantId(rs.getInt(3));
				rmbean.setMemberId(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rmbean;
	}

	// 新增INSERT
	public RestaurantMessageBean insert(RestaurantMessageBean bean) {
		RestaurantMessageBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			if (bean != null) {
				ps.setString(1, bean.getMessageContent());
				ps.setInt(2, bean.getRestaurantId());
				ps.setInt(3, bean.getMemberId());

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
	public RestaurantMessageBean update(RestaurantMessageBean bean) {
		RestaurantMessageBean result = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			if (bean != null) {
				ps.setString(1, bean.getMessageContent());
				ps.setInt(2, bean.getRestaurantId());
				ps.setInt(3, bean.getMemberId());

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
	public boolean delete(int RestaurantMessageId) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			PreparedStatement ps = conn.prepareStatement(DELETE);

			ps.setInt(1, RestaurantMessageId);

			int rs = ps.executeUpdate();
			if (rs == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		RestaurantMessageDAOjdbc test = new RestaurantMessageDAOjdbc();
		// ----------------------------------------------------------
		// List<RestaurantMessageBean> li= test.select(); //全部select
		// for(RestaurantMessageBean e:li){
		// System.out.println(e);
		// }
		// ----------------------------------------------------------
		// System.out.println(test.select(2)); // 單筆select
		// ----------------------------------------------------------
		RestaurantMessageBean rmbean = new RestaurantMessageBean();
		rmbean.setMessageContent("好吃");
		rmbean.setRestaurantId(3);
		rmbean.setMemberId(1);

		//
//		 System.out.println(test.insert(rmbean)); // 新增資料
		// ----------------------------------------------------------
		// System.out.println(test.select("text123")); //單筆select （帳號）
		// ----------------------------------------------------------
		// System.out.println(test.update(rmbean)); //修改
		// ----------------------------------------------------------
		// System.out.println(test.delete(3));//刪除
		// ----------------------------------------------------------
		// FileOutputStream fo = new
		// FileOutputStream("/Users/mouse/Desktop/4.jpg"); //把圖片取出來放桌面
		// fo.write(m.select(2).getPhoto(), 0, t);
		// fo.close();
		// ----------------------------------------------------------

	}
}
