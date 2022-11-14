package entity;

import java.time.LocalDate;

public class Feedback {
	private int F_Id;
	private String F_CMT;
	private int P_Id;
	private int G_Id;
	private LocalDate Created_At;
	private LocalDate Update_At;

	public Feedback() {
	};

	public Feedback(int f_Id, String f_CMT, int p_Id, int g_Id, LocalDate created_At, LocalDate update_At) {
		super();
		F_Id = f_Id;
		F_CMT = f_CMT;
		P_Id = p_Id;
		G_Id = g_Id;
		Created_At = created_At;
		Update_At = update_At;
	}

	public int getF_Id() {
		return F_Id;
	}

	public void setF_Id(int f_Id) {
		F_Id = f_Id;
	}

	public String getF_CMT() {
		return F_CMT;
	}

	public void setF_CMT(String f_CMT) {
		F_CMT = f_CMT;
	}

	public int getP_Id() {
		return P_Id;
	}

	public void setP_Id(int p_Id) {
		P_Id = p_Id;
	}

	public int getG_Id() {
		return G_Id;
	}

	public void setG_Id(int g_Id) {
		G_Id = g_Id;
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
		return "Feedback_Dao [F_Id=" + F_Id + ", F_CMT=" + F_CMT + ", P_Id=" + P_Id + ", G_Id=" + G_Id + ", Created_At="
				+ Created_At + ", Update_At=" + Update_At + "]";
	}
}
