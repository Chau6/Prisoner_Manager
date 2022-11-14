package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.Supervision;

public class Supervision_Dao {
	public void insertData(String S_Image, String S_Name, String S_Gender, String S_Dob, int S_Level) {
		// insert data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call InsertSupervision(?,?,?,?,?)}");) {
			cs.setString(1, S_Image);
			cs.setString(2, S_Name);
			cs.setString(3, S_Gender);
			cs.setString(4, S_Dob);
			cs.setInt(5, S_Level);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UpdateData(String S_Image, String S_Name, String S_Gender, String S_Dob, int S_Level,
			int U_Id) {
		// update data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call UpdateSupervision(?,?,?,?,?,?)}");) {
			cs.setString(1, S_Image);
			cs.setString(2, S_Name);
			cs.setString(3, S_Gender);
			cs.setString(4, S_Dob);
			cs.setInt(5, S_Level);
			cs.setInt(6, U_Id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int countSupervision() {
		int count = 0;
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call countSupervision}");
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
		String sql = "{call selectSupervision(?,?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, pageNumber);
		cs.setInt(2, rowsOfPage);
		return cs;
	}

	public List<Supervision> getList(int pageNumber, int rowsOfPage) {
		List<Supervision> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = createCS(con, pageNumber, rowsOfPage);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var sup = new Supervision();
				sup.setS_Id(rs.getInt("S_Id"));
				sup.setS_Image(rs.getString("S_Image"));
				sup.setS_Name(rs.getString("S_Name"));
				if(!(String.valueOf(rs.getBoolean("S_Gender"))==null)) {
					sup.setS_Gender(rs.getBoolean("S_Gender"));
				};
				if(!(rs.getDate("S_Dob")==null)) {
					sup.setS_Dob(rs.getDate("S_Dob").toLocalDate());
				};
				sup.setS_Level(rs.getInt("S_Level"));
				sup.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					sup.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};	
				list.add(sup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private static CallableStatement searchSupervision(Connection connect, int S_Id) throws SQLException {
		String sql = "{call searchSupervision(?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, S_Id);
		return cs;
	}

	public List<Supervision> getListSupervisionWhenSearch(int S_Id) {
		List<Supervision> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = searchSupervision(con, S_Id);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var sup = new Supervision();
				sup.setS_Id(rs.getInt("S_Id"));
				sup.setS_Image(rs.getString("S_Image"));
				sup.setS_Name(rs.getString("S_Name"));
				if(!(String.valueOf(rs.getBoolean("S_Gender"))==null)) {
					sup.setS_Gender(rs.getBoolean("S_Gender"));
				};
				if(!(rs.getDate("S_Dob")==null)) {
					sup.setS_Dob(rs.getDate("S_Dob").toLocalDate());
				};
				sup.setS_Level(rs.getInt("S_Level"));
				sup.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					sup.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};	
				list.add(sup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteData(int id) {
		// delete data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath(); var cs = con.prepareCall("{call deleteSupervision(?)}");) {
			cs.setInt(1, id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
