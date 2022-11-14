package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.User;

public class User_Dao {
	public void insertData(String U_Image, String U_Username, String U_Password, String U_Gender, String U_Phone, String U_Email, int U_Level) {
		// insert data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call InsertUser(?,?,?,?,?,?,?)}");) {
			cs.setString(1, U_Image);
			cs.setString(2, U_Username);
			cs.setString(3, U_Password);
			cs.setString(4, U_Gender);
			cs.setString(5, U_Phone);
			cs.setString(6, U_Email);
			cs.setInt(7, U_Level);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UpdateData(String U_Image, String U_Username, String U_Password, String U_Gender, String U_Phone, String U_Email, int U_Level,
			int U_Id) {
		// update data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call UpdateUser(?,?,?,?,?,?,?,?)}");) {
			cs.setString(1, U_Image);
			cs.setString(2, U_Username);
			cs.setString(3, U_Password);
			cs.setString(4, U_Gender);
			cs.setString(5, U_Phone);
			cs.setString(6, U_Email);
			cs.setInt(7, U_Level);
			cs.setInt(8, U_Id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int countUser() {
		int count = 0;
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call countUser}");
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
		String sql = "{call selectUser(?,?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, pageNumber);
		cs.setInt(2, rowsOfPage);
		return cs;
	}

	public List<User> getList(int pageNumber, int rowsOfPage) {
		List<User> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = createCS(con, pageNumber, rowsOfPage);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var user = new User();
				user.setU_Id(rs.getInt("U_Id"));
				user.setU_Image(rs.getString("U_Image"));
				user.setU_Username(rs.getString("U_Username"));
				user.setU_Password(rs.getString("U_Password"));
				if(!(String.valueOf(rs.getBoolean("U_Gender"))==null)) {
					user.setU_Gender(rs.getBoolean("U_Gender"));
				};
				user.setU_Phone(rs.getString("U_Phone"));
				user.setU_Email(rs.getString("U_Email"));
				user.setU_Level(rs.getInt("U_Level"));
				user.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					user.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private static CallableStatement searchUser(Connection connect, int U_Id) throws SQLException {
		String sql = "{call searchUser(?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, U_Id);
		return cs;
	}

	public List<User> getListUserWhenSearch(int U_Id) {
		List<User> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = searchUser(con, U_Id);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var user = new User();
				user.setU_Id(rs.getInt("U_Id"));
				user.setU_Image(rs.getString("U_Image"));
				user.setU_Username(rs.getString("U_Username"));
				user.setU_Password(rs.getString("U_Password"));
				if(!(String.valueOf(rs.getBoolean("U_Gender"))==null)) {
					user.setU_Gender(rs.getBoolean("U_Gender"));
				};
				user.setU_Phone(rs.getString("U_Phone"));
				user.setU_Email(rs.getString("U_Email"));
				user.setU_Level(rs.getInt("U_Level"));
				user.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					user.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteData(int id) {
		// delete data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath(); var cs = con.prepareCall("{call deleteUser(?)}");) {
			cs.setInt(1, id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
