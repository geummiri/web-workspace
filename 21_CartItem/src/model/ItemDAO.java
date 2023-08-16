package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;


public class ItemDAO implements ItemDAOTemplate{

	
	private static ItemDAO dao = new ItemDAO();
	
	private ItemDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ItemDAO getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("DB Connection!");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps,conn);
	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM ITEM";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Item> itemList = new ArrayList<>();
		
		while(rs.next()) {
			Item item = new Item(Integer.parseInt(rs.getString("item_Id")),
					rs.getString("item_Name"),
					Integer.parseInt(rs.getString("price")),
					rs.getString("description"),
					rs.getString("picture_Url"),
					Integer.parseInt(rs.getString("count")));
				
			itemList.add(item);
		}
		
		closeAll(rs,ps,conn);
		
		
		return itemList;
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM ITEM WHERE ITEM_ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, itemId);
		ResultSet rs= ps.executeQuery();
		
		Item item = null;
		
		if(rs.next()) {
			item = new Item(Integer.parseInt(rs.getString("item_Id")),
					rs.getString("item_Name"),
					Integer.parseInt(rs.getString("price")),
					rs.getString("description"),
					rs.getString("picture_Url"),
					Integer.parseInt(rs.getString("count")));
		}
		
		closeAll(rs, ps, conn);
		
		return item;
	}
	

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		
		return false;
	}
	
}
