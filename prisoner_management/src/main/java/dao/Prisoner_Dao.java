package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.Prisoner;

public class Prisoner_Dao {
	public void insertData(int P_Id, String P_Image, String P_Name, String P_Gender, String P_Dob, String P_Admit,
			String P_Release, String P_Crime, int P_Security_Level) {
		// insert data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call InsertPrisoner(?,?,?,?,?,?,?,?,?)}");) {
			cs.setInt(1, P_Id);
			cs.setString(2, P_Image);
			cs.setString(3, P_Name);
			cs.setString(4, P_Gender);
			cs.setString(5, P_Dob);
			cs.setString(6, P_Admit);
			cs.setString(7, P_Release);
			cs.setString(8, P_Crime);
			cs.setInt(9, P_Security_Level);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UpdateData(String P_Image, String P_Name, String P_Gender, String P_Dob, String P_Admit,
			String P_Release, String P_Crime, int P_Security_Level, int P_Id) {
		// update data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call UpdatePrisoner(?,?,?,?,?,?,?,?,?)}");) {
			cs.setInt(9, P_Id);
			cs.setString(1, P_Image);
			cs.setString(2, P_Name);
			cs.setString(3, P_Gender);
			cs.setString(4, P_Dob);
			cs.setString(5, P_Admit);
			cs.setString(6, P_Release);
			cs.setString(7, P_Crime);
			cs.setInt(8, P_Security_Level);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int countUser() {
		int count = 0;
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call countPrisoner}");
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

	public List<Prisoner> getList(int pageNumber, int rowsOfPage) {
		List<Prisoner> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = createCS(con, pageNumber, rowsOfPage);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var pri = new Prisoner();
				//add data từ db vào list
				pri.setP_Id(rs.getInt("P_Id"));
				pri.setP_Image(rs.getString("P_Image"));
				pri.setP_Name(rs.getString("P_Name"));
				if(!(String.valueOf(rs.getBoolean("P_Gender"))==null)) {
					pri.setP_Gender(rs.getBoolean("P_Gender"));
				};
				if(!(rs.getDate("P_Dob")==null)) {
					pri.setP_Dob(rs.getDate("P_Dob").toLocalDate());
				};
				if(!(rs.getDate("P_Admit")==null)) {
					pri.setP_Admit(rs.getDate("P_Admit").toLocalDate());
				};
				if(!(rs.getDate("P_Release")==null)) {
					pri.setP_Release(rs.getDate("P_Release").toLocalDate());
				};
				pri.setP_Crime(rs.getString("P_Crime"));
				pri.setP_Security_Level(rs.getInt("P_Security_Level"));
				pri.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					pri.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};
				list.add(pri);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private static CallableStatement searchPrisoner(Connection connect, int P_Id) throws SQLException {
		String sql = "{call searchPrisoner(?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, P_Id);
		return cs;
	}

	public List<Prisoner> getListPrisonerWhenSearch(int P_Id) {
		List<Prisoner> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = searchPrisoner(con, P_Id);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var pri = new Prisoner();
				pri.setP_Id(rs.getInt("P_Id"));
				pri.setP_Image(rs.getString("P_Image"));
				pri.setP_Name(rs.getString("P_Name"));
				if(!(String.valueOf(rs.getBoolean("P_Gender"))==null)) {
					pri.setP_Gender(rs.getBoolean("P_Gender"));
				};
				if(!(rs.getDate("P_Dob")==null)) {
					pri.setP_Dob(rs.getDate("P_Dob").toLocalDate());
				};
				if(!(rs.getDate("P_Admit")==null)) {
					pri.setP_Admit(rs.getDate("P_Admit").toLocalDate());
				};
				if(!(rs.getDate("P_Release")==null)) {
					pri.setP_Release(rs.getDate("P_Release").toLocalDate());
				};
				pri.setP_Crime(rs.getString("P_Crime"));
				pri.setP_Security_Level(rs.getInt("P_Security_Level"));
				pri.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					pri.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};
				list.add(pri);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteData(int id) {
		// delete data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath(); var cs = con.prepareCall("{call deletePrisoner(?)}");) {
			cs.setInt(1, id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
