package entity;

import java.time.LocalDate;

public class Block {
	private int B_Id;
	private String B_Name;
	private int B_Cell_Room;
	private int P_Id;
	private int G_Id;
	private int S_Id;
	private LocalDate Created_At;
	private LocalDate Update_At;

	public Block() {
	};

	public Block(int b_Id, String b_Name, int b_Cell_Room, int p_Id, int g_Id, int s_Id, LocalDate created_At,
			LocalDate update_At) {
		super();
		B_Id = b_Id;
		B_Name = b_Name;
		B_Cell_Room = b_Cell_Room;
		P_Id = p_Id;
		G_Id = g_Id;
		S_Id = s_Id;
		Created_At = created_At;
		Update_At = update_At;
	}

	public int getB_Id() {
		return B_Id;
	}

	public void setB_Id(int b_Id) {
		B_Id = b_Id;
	}

	public String getB_Name() {
		return B_Name;
	}

	public void setB_Name(String b_Name) {
		B_Name = b_Name;
	}

	public int getB_Cell_Room() {
		return B_Cell_Room;
	}

	public void setB_Cell_Room(int b_Cell_Room) {
		B_Cell_Room = b_Cell_Room;
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

	public int getS_Id() {
		return S_Id;
	}

	public void setS_Id(int s_Id) {
		S_Id = s_Id;
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
		return "Block_Dao [B_Id=" + B_Id + ", B_Name=" + B_Name + ", B_Cell_Room=" + B_Cell_Room + ", P_Id=" + P_Id
				+ ", G_Id=" + G_Id + ", S_Id=" + S_Id + ", Created_At=" + Created_At + ", Update_At=" + Update_At + "]";
	}
}
