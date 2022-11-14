package entity;

import java.time.LocalDate;

public class Interior_Minister {
	private int G_Id;
	private String G_Image;
	private String G_Name;
	private Boolean G_Gender;
	private LocalDate G_Dob;
	private LocalDate Created_At;
	private LocalDate Update_At;

	public Interior_Minister() {
	};

	public Interior_Minister(int g_Id, String g_Image, String g_Name, Boolean g_Gender, LocalDate g_Dob, LocalDate created_At,
			LocalDate update_At) {
		super();
		G_Id = g_Id;
		G_Image = g_Image;
		G_Name = g_Name;
		G_Gender = g_Gender;
		G_Dob = g_Dob;
		Created_At = created_At;
		Update_At = update_At;
	}

	public int getG_Id() {
		return G_Id;
	}

	public void setG_Id(int g_Id) {
		G_Id = g_Id;
	}

	public String getG_Image() {
		return G_Image;
	}

	public void setG_Image(String g_Image) {
		G_Image = g_Image;
	}

	public String getG_Name() {
		return G_Name;
	}

	public void setG_Name(String g_Name) {
		G_Name = g_Name;
	}

	public Boolean getG_Gender() {
		return G_Gender;
	}

	public void setG_Gender(Boolean g_Gender) {
		G_Gender = g_Gender;
	}

	public LocalDate getG_Dob() {
		return G_Dob;
	}

	public void setG_Dob(LocalDate g_Dob) {
		G_Dob = g_Dob;
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
		return "Guard [G_Id=" + G_Id + ", G_Image=" + G_Image + ", G_Name=" + G_Name + ", G_Gender=" + G_Gender
				+ ", G_Dob=" + G_Dob + ", Created_At=" + Created_At + ", Update_At="
				+ Update_At + "]";
	}
}
