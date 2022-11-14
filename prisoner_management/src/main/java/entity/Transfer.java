package entity;

import java.time.LocalDate;

public class Transfer {
	private int T_Id;
	private String T_Old_Prison;
	private String T_Reason;
	private LocalDate T_Transfer_Date;
	private int P_Id;
	private LocalDate Created_At;
	private LocalDate Update_At;

	public Transfer() {
	};

	public Transfer(int t_Id, String t_Old_Prison, String t_Reason, LocalDate t_Transfer_Date, int p_Id,
			LocalDate created_At, LocalDate update_At) {
		super();
		T_Id = t_Id;
		T_Old_Prison = t_Old_Prison;
		T_Reason = t_Reason;
		T_Transfer_Date = t_Transfer_Date;
		P_Id = p_Id;
		Created_At = created_At;
		Update_At = update_At;
	}

	public int getT_Id() {
		return T_Id;
	}

	public void setT_Id(int t_Id) {
		T_Id = t_Id;
	}

	public String getT_Old_Prison() {
		return T_Old_Prison;
	}

	public void setT_Old_Prison(String t_Old_Prison) {
		T_Old_Prison = t_Old_Prison;
	}

	public String getT_Reason() {
		return T_Reason;
	}

	public void setT_Reason(String t_Reason) {
		T_Reason = t_Reason;
	}

	public LocalDate getT_Transfer_Date() {
		return T_Transfer_Date;
	}

	public void setT_Transfer_Date(LocalDate t_Transfer_Date) {
		T_Transfer_Date = t_Transfer_Date;
	}

	public int getP_Id() {
		return P_Id;
	}

	public void setP_Id(int p_Id) {
		P_Id = p_Id;
	}

	public LocalDate getCreated_At() {
		return Created_At;
	}

	public void setCreated_At(LocalDate created_At) {
		Created_At = created_At;
	}

	public LocalDate getUpdate_At() {
		return Update_At;
	}

	public void setUpdate_At(LocalDate update_At) {
		Update_At = update_At;
	}

	@Override
	public String toString() {
		return "Transfer_Dao [T_Id=" + T_Id + ", T_Old_Prison=" + T_Old_Prison + ", T_Reason=" + T_Reason
				+ ", T_Transfer_Date=" + T_Transfer_Date + ", P_Id=" + P_Id + ", Created_At=" + Created_At
				+ ", Update_At=" + Update_At + "]";
	}
}
