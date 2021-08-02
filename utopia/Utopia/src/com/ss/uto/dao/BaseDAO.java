/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public abstract class BaseDAO<T> {

	public static Connection conn = null;
	
	public BaseDAO(Connection conn) {
		this.conn = conn;
	}

	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		if (vals != null) {
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.executeUpdate();
	}
	
	public Integer saveReturnPK(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int count = 1;
		if (vals != null) {
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		while(rs.next()) {
			return rs.getInt(1);//check out if this is 1 or 0;
		}
		return null;
	}

	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		if (vals != null) {
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}

	abstract public List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;
}
