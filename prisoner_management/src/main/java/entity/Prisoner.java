package entity;

import java.time.LocalDate;

public class Prisoner {
	private int P_Id;
	private String P_Image;
	private String P_Name;
	private Boolean P_Gender;
	private LocalDate P_Dob;
	private LocalDate P_Admit;
	private LocalDate P_Release;
	private String P_Crime;
	private int P_Security_Level;
	private LocalDate Created_At;
	private LocalDate Update_At;

	public Prisoner() {
	};

	public Prisoner(int p_Id, String p_Image, String p_Name, Boolean p_Gender, LocalDate p_Dob, LocalDate p_Admit,
			LocalDate p_Release, String p_Crime, int p_Security_Level, LocalDate created_At, LocalDate update_At) {
		super();
		P_Id = p_Id;
		P_Image = p_Image;
		P_Name = p_Name;
		P_Gender = p_Gender;
		P_Dob = p_Dob;
		P_Admit = p_Admit;
		P_Release = p_Release;
		P_Crime = p_Crime;
		P_Security_Level = p_Security_Level;
		Created_At = created_At;
		Update_At = update_At;
	}

	public int getP_Id() {
		return P_Id;
	}

	public void setP_Id(int p_Id) {
		P_Id = p_Id;
	}

	public String getP_Image() {
		return P_Image;
	}

	public void setP_Image(String p_Image) {
		P_Image = p_Image;
	}

	public String getP_Name() {
		return P_Name;
	}

	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}

	public Boolean getP_Gender() {
		return P_Gender;
	}

	public void setP_Gender(Boolean p_Gender) {
		P_Gender = p_Gender;
	}

	public LocalDate getP_Dob() {
		return P_Dob;
	}

	public void setP_Dob(LocalDate p_Dob) {
		P_Dob = p_Dob;
	}

	public LocalDate getP_Admit() {
		return P_Admit;
	}

	public void setP_Admit(LocalDate p_Admit) {
		P_Admit = p_Admit;
	}

	public LocalDate getP_Release() {
		return P_Release;
	}

	public void setP_Release(LocalDate p_Release) {
		P_Release = p_Release;
	}

	public String getP_Crime() {
		return P_Crime;
	}

	public void setP_Crime(String p_Crime) {
		P_Crime = p_Crime;
	}

	public int getP_Security_Level() {
		return P_Security_Level;
	}

	public void setP_Security_Level(int p_Security_Level) {
		P_Security_Level = p_Security_Level;
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
		return "Prisoner [P_Id=" + P_Id + ", P_Image=" + P_Image + ", P_Name=" + P_Name + ", P_Gender=" + P_Gender
				+ ", P_Dob=" + P_Dob + ", P_Admit=" + P_Admit + ", P_Release=" + P_Release + ", P_Crime=" + P_Crime
				+ ", P_Security_Level=" + P_Security_Level + ", Created_At=" + Created_At + ", Update_At=" + Update_At
				+ "]";
	}
}
