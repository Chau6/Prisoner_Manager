package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.Transfer;

public class Transfer_Dao {
	//sài date = String.ValueOf(date)
	public void insertData(String T_Old_Prison, String T_Reason, String T_Transfer_Date, int P_Id) {
		// insert data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call InsertTransfer(?,?,?,?)}");) {
			cs.setString(1, T_Old_Prison);
			cs.setString(2, T_Reason);
			cs.setString(3, T_Transfer_Date);
			cs.setInt(4, P_Id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UpdateData(String T_Old_Prison, String T_Reason, String T_Transfer_Date, int P_Id,
			int T_Id) {
		// update data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call UpdateTransfer(?,?,?,?,?)}");) {
			cs.setString(1, T_Old_Prison);
			cs.setString(2, T_Reason);
			cs.setString(3, T_Transfer_Date);
			cs.setInt(4, P_Id);
			cs.setInt(5, T_Id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int countTransfer() {
		int count = 0;
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = con.prepareCall("{call countTransfer}");
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
		String sql = "{call selectTransfer(?,?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, pageNumber);
		cs.setInt(2, rowsOfPage);
		return cs;
	}

	public List<Transfer> getList(int pageNumber, int rowsOfPage) {
		List<Transfer> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = createCS(con, pageNumber, rowsOfPage);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var tra = new Transfer();
				tra.setT_Id(rs.getInt("T_Id"));
				tra.setT_Old_Prison(rs.getString("T_Old_Prison"));
				tra.setT_Reason(rs.getString("T_Reason"));
				tra.setT_Transfer_Date(rs.getDate("T_Transfer_Date").toLocalDate());
				tra.setP_Id(rs.getInt("P_Id"));
				tra.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					tra.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};
				list.add(tra);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private static CallableStatement searchTransfer(Connection connect, int T_Id) throws SQLException {
		String sql = "{call searchTransfer(?)}";
		var cs = connect.prepareCall(sql);
		cs.setInt(1, T_Id);
		return cs;
	}

	public List<Transfer> getListTransferWhenSearch(int T_Id) {
		List<Transfer> list = new ArrayList<>();
		try (var con = ConnectDB.getConnectionFromClassPath();
				var cs = searchTransfer(con, T_Id);
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var tra = new Transfer();
				tra.setT_Id(rs.getInt("T_Id"));
				tra.setT_Old_Prison(rs.getString("T_Old_Prison"));
				tra.setT_Reason(rs.getString("T_Reason"));
				tra.setT_Transfer_Date(rs.getDate("T_Transfer_Date").toLocalDate());
				tra.setP_Id(rs.getInt("P_Id"));
				tra.setCreated_At(rs.getDate("Created_At").toLocalDate());
				if(!(rs.getDate("Update_At")==null)) {
					tra.setUpdate_At(rs.getDate("Update_At").toLocalDate());
				};
				list.add(tra);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteData(int id) {
		// delete data = store procedure
		try (var con = ConnectDB.getConnectionFromClassPath(); var cs = con.prepareCall("{call deleteTransfer(?)}");) {
			cs.setInt(1, id);

			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
