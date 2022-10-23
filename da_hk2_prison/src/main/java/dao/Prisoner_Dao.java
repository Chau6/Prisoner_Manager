package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.Prisoner;

public class Prisoner_Dao {
	// đếm được có bnh dòng
	public int countPrisoner() {
		int count = 0;
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call countPrisoner}"); // gọi store procedure
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	private static CallableStatement createCS(Connection connect, int pageNumber, int rowsOfPage) throws SQLException {
		String sql = "{call selectPrisoner(?,?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, pageNumber);
		cs.setInt(2, rowsOfPage);
		return cs;
	}
	//có phân trang
	public List<Prisoner> getList(int pageNumber, int rowsOfPage) {
		List<Prisoner> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = createCS(con,pageNumber,rowsOfPage);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var pri = new Prisoner();
				pri.setPrisoner_id(rs.getInt("prisoner_id"));
				pri.setFullname(rs.getString("fullname"));
				pri.setGender(rs.getBoolean("gender"));
				pri.setBirthday(rs.getDate("birthday").toLocalDate());
				pri.setDay_in(rs.getDate("day_in").toLocalDate());
				pri.setUpdate_time(rs.getDate("update_time").toLocalDate());
				pri.setPrison_id(rs.getInt("prison_id"));
				pri.setCase_id(rs.getInt("case_id"));
				pri.setDayout_id(rs.getInt("dayout_id"));
				
				list.add(pri);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	public void insertData(String fullname, String gender, LocalDate dob, LocalDate day_in) {
//		// insert data = store procedure
//		try (var con = ConnectDB.getConnectionFromClassPath(); var cs = con.prepareCall("{call InsertPri(?,?,?,?)}");) {
//			cs.setString(1, fullname);
//			cs.setBoolean(2, Boolean.parseBoolean(gender)); // 0|1 or false|true
//			cs.setDate(3, Date.valueOf(dob)); // yyyy-mm-dd ; mm < 13 and dd < 32
//			cs.setDate(4, Date.valueOf(day_in));
//
//			cs.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public void updateData(String fullname, String gender, LocalDate dob, LocalDate day_in, int id) {
//		// update data = store procedure
//		try (var con = ConnectDB.getConnectionFromClassPath();
//				var cs = con.prepareCall("{call UpdatePri(?,?,?,?,?)}");) {
//			cs.setInt(5, id);
//			cs.setString(1, fullname);
//			cs.setBoolean(2, Boolean.parseBoolean(gender)); // 0|1 or false|true
//			cs.setDate(3, Date.valueOf(dob)); // yyyy-mm-dd ; mm < 13 and dd < 32
//			cs.setDate(4, Date.valueOf(day_in));
//
//			cs.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void deleteData(int id) {
		// delete data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath(); var cs = con.prepareCall("{call DeletePri(?)}");) {
			cs.setInt(1, id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Prisoner> select() {
		// select all data = store procedure
		List<Prisoner> list = new ArrayList<>();

		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call SelAllPri}"); // gọi store procedure
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var pri = new Prisoner();
				pri.setPrisoner_id(rs.getInt("prisoner_id"));
				pri.setFullname(rs.getString("fullname"));
				pri.setGender(rs.getBoolean("gender"));
				pri.setBirthday(rs.getDate("birthday").toLocalDate());
				pri.setDay_in(rs.getDate("day_in").toLocalDate());
				pri.setUpdate_time(rs.getDate("update_time").toLocalDate());
				pri.setPrison_id(rs.getInt("prison_id"));
				pri.setCase_id(rs.getInt("case_id"));
				pri.setDayout_id(rs.getInt("dayout_id"));

				list.add(pri);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
