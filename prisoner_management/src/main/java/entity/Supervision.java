package entity;

import java.time.LocalDate;

public class Supervision {
	private int S_Id;
	private String S_Image;
	private String S_Name;
	private Boolean S_Gender;
	private LocalDate S_Dob;
	private int S_Level;
	private LocalDate Created_At;
	private LocalDate Update_At;

	public Supervision() {
	};

	public Supervision(int s_Id, String s_Image, String s_Name, Boolean s_Gender, LocalDate s_Dob, int s_Level, LocalDate created_At,
			LocalDate update_At) {
		super();
		S_Id = s_Id;
		S_Image = s_Image;
		S_Name = s_Name;
		S_Gender = s_Gender;
		S_Dob = s_Dob;
		S_Level = s_Level;
		Created_At = created_At;
		Update_At = update_At;
	}

	public int getS_Id() {
		return S_Id;
	}

	public void setS_Id(int s_Id) {
		S_Id = s_Id;
	}

	public String getS_Image() {
		return S_Image;
	}

	public void setS_Image(String s_Image) {
		S_Image = s_Image;
	}

	public String getS_Name() {
		return S_Name;
	}

	public void setS_Name(String s_Name) {
		S_Name = s_Name;
	}

	public Boolean getS_Gender() {
		return S_Gender;
	}

	public void setS_Gender(Boolean s_Gender) {
		S_Gender = s_Gender;
	}

	public LocalDate getS_Dob() {
		return S_Dob;
	}

	public void setS_Dob(LocalDate s_Dob) {
		S_Dob = s_Dob;
	}

	public int getS_Level() {
		return S_Level;
	}

	public void setS_Level(int s_Level) {
		S_Level = s_Level;
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
		return "Supervision [S_Id=" + S_Id + ", S_Image=" + S_Image + ", S_Name=" + S_Name + ", S_Gender=" + S_Gender
				+ ", S_Dob=" + S_Dob + ", S_Level=" + S_Level + ", Created_At=" + Created_At + ", Update_At="
				+ Update_At + "]";
	}
}
