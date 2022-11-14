package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.Interior_Minister;
import entity.Supervision;

public class InteriorMinister_Dao {
	public void insertData(String G_Image, String G_Name, String G_Gender, String G_Dob) {
		// insert data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call InsertInteriorMinister(?,?,?,?)}");) {
			cs.setString(1, G_Image);
			cs.setString(2, G_Name);
			cs.setString(3, G_Gender);
			cs.setString(4, G_Dob);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UpdateData(String G_Image, String G_Name, String G_Gender, String G_Dob,
			int U_Id) {
		// update data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call UpdateInteriorMinister(?,?,?,?,?)}");) {
			cs.setString(1, G_Image);
			cs.setString(2, G_Name);
			cs.setString(3, G_Gender);
			cs.setString(4, G_Dob);
			cs.setInt(5, U_Id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int countInteriorMinister() {
		int count = 0;
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call countInteriorMinister}");
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
		String sql = "{call selectInteriorMinister(?,?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, pageNumber);
		cs.setInt(2, rowsOfPage);
		return cs;
	}

	public List<Interior_Minister> getList(int pageNumber, int rowsOfPage) {
		List<Interior_Minister> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = createCS(con, pageNumber, rowsOfPage);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var gua = new Interior_Minister();
				gua.setG_Id(rs.getInt("G_Id"));
				gua.setG_Image(rs.getString("G_Image"));
				gua.setG_Name(rs.getString("G_Name"));
				if(!(String.valueOf(rs.getBoolean("G_Gender"))==null)) {
					gua.setG_Gender(rs.getBoolean("G_Gender"));
				};
				if(!(rs.getDate("G_Dob")==null)) {
					gua.setG_Dob(rs.getDate("G_Dob").toLocalDate());
				};
				gua.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					gua.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};				
				list.add(gua);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private static CallableStatement searchInteriorMinister(Connection connect, int G_Id) throws SQLException {
		String sql = "{call searchInteriorMinister(?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, G_Id);
		return cs;
	}

	public List<Interior_Minister> getListInteriorMinisterWhenSearch(int G_Id) {
		List<Interior_Minister> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = searchInteriorMinister(con, G_Id);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var gua = new Interior_Minister();
				gua.setG_Id(rs.getInt("G_Id"));
				gua.setG_Image(rs.getString("G_Image"));
				gua.setG_Name(rs.getString("G_Name"));
				if(!(String.valueOf(rs.getBoolean("G_Gender"))==null)) {
					gua.setG_Gender(rs.getBoolean("G_Gender"));
				};
				if(!(rs.getDate("G_Dob")==null)) {
					gua.setG_Dob(rs.getDate("G_Dob").toLocalDate());
				};
				gua.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					gua.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};				
				list.add(gua);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteData(int id) {
		// delete data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath(); var cs = con.prepareCall("{call deleteInteriorMinister(?)}");) {
			cs.setInt(1, id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
