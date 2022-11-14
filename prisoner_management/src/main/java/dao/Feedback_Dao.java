package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.Feedback;

public class Feedback_Dao {
	//sài date = String.ValueOf(date)
		public void insertData(String F_CMT, int P_Id, int G_Id) {
			// insert data = store procedure
			try (var con = ConnectDB.getConnectionFromClassPath();
					var cs = con.prepareCall("{call InsertFeedback(?,?,?)}");) {
				cs.setString(1, F_CMT);
				cs.setInt(2, P_Id);
				cs.setInt(3, G_Id);

				cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void UpdateData(String F_CMT, int P_Id, int G_Id,
				int F_Id) {
			// update data = store procedure
			try (var con = ConnectDB.getConnectionFromClassPath();
					var cs = con.prepareCall("{call UpdateFeedback(?,?,?,?)}");) {
				cs.setString(1, F_CMT);
				cs.setInt(2, P_Id);
				cs.setInt(3, G_Id);
				cs.setInt(4, F_Id);

				cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public int countFeedback() {
			int count = 0;
			try (var con = ConnectDB.getConnectionFromClassPath();
					var cs = con.prepareCall("{call countFeedback}");
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
			String sql = "{call selectFeedback(?,?)}";
			var cs = connect.prepareCall(sql);
			cs.setInt(1, pageNumber);
			cs.setInt(2, rowsOfPage);
			return cs;
		}

		public List<Feedback> getList(int pageNumber, int rowsOfPage) {
			List<Feedback> list = new ArrayList<>();
			try (var con = ConnectDB.getConnectionFromClassPath();
					var cs = createCS(con, pageNumber, rowsOfPage);
					var rs = cs.executeQuery();) {
				while (rs.next()) {
					var fee = new Feedback();
					fee.setF_Id(rs.getInt("F_Id"));
					fee.setF_CMT(rs.getString("F_CMT"));
					fee.setP_Id(rs.getInt("P_Id"));
					fee.setG_Id(rs.getInt("G_Id"));
					fee.setCreated_At(rs.getDate("Created_At").toLocalDate());
					if(!(rs.getDate("Update_At")==null)) {
						fee.setUpdate_At(rs.getDate("Update_At").toLocalDate());
					};
					list.add(fee);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		private static CallableStatement searchFeedback(Connection connect, int F_Id) throws SQLException {
			String sql = "{call searchFeedback(?)}";
			var cs = connect.prepareCall(sql);
			cs.setInt(1, F_Id);
			return cs;
		}

		public List<Feedback> getListFeedbackWhenSearch(int F_Id) {
			List<Feedback> list = new ArrayList<>();
			try (var con = ConnectDB.getConnectionFromClassPath();
					var cs = searchFeedback(con, F_Id);
					var rs = cs.executeQuery();) {
				while (rs.next()) {
					var fee = new Feedback();
					fee.setF_Id(rs.getInt("F_Id"));
					fee.setF_CMT(rs.getString("F_CMT"));
					fee.setP_Id(rs.getInt("P_Id"));
					fee.setG_Id(rs.getInt("G_Id"));
					fee.setCreated_At(rs.getDate("Created_At").toLocalDate());
					if(!(rs.getDate("Update_At")==null)) {
						fee.setUpdate_At(rs.getDate("Update_At").toLocalDate());
					};
					list.add(fee);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		public void deleteData(int id) {
			// delete data = store procedure
			try (var con = ConnectDB.getConnectionFromClassPath(); var cs = con.prepareCall("{call deleteFeedback(?)}");) {
				cs.setInt(1, id);

				cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
