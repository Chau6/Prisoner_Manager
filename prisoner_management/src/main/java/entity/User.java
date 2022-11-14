package entity;

import java.time.LocalDate;

public class User {
	private int U_Id;
	private String U_Image;
	private String U_Username;
	private String U_Password;
	private Boolean U_Gender;
	private String U_Phone;
	private String U_Email;
	private int U_Level;
	private LocalDate Created_At;
	private LocalDate Update_At;

	public User() {
	};

	public User(int u_Id, String u_Image, String u_Username, String u_Password, Boolean u_Gender, String u_Phone, String u_Email, int u_Level,
			LocalDate created_At, LocalDate update_At) {
		super();
		U_Id = u_Id;
		U_Image = u_Image;
		U_Username = u_Username;
		U_Password = u_Password;
		U_Gender = u_Gender;
		U_Phone = u_Phone;
		U_Email = u_Email;
		U_Level = u_Level;
		Created_At = created_At;
		Update_At = update_At;
	}

	public int getU_Id() {
		return U_Id;
	}

	public void setU_Id(int u_Id) {
		U_Id = u_Id;
	}

	public String getU_Image() {
		return U_Image;
	}

	public void setU_Image(String u_Image) {
		U_Image = u_Image;
	}

	public Boolean getU_Gender() {
		return U_Gender;
	}

	public void setU_Gender(Boolean u_Gender) {
		U_Gender = u_Gender;
	}

	public String getU_Username() {
		return U_Username;
	}

	public void setU_Username(String u_Username) {
		U_Username = u_Username;
	}

	public String getU_Password() {
		return U_Password;
	}

	public void setU_Password(String u_Password) {
		U_Password = u_Password;
	}

	public String getU_Phone() {
		return U_Phone;
	}

	public void setU_Phone(String u_Phone) {
		U_Phone = u_Phone;
	}

	public String getU_Email() {
		return U_Email;
	}

	public void setU_Email(String u_Email) {
		U_Email = u_Email;
	}

	public int getU_Level() {
		return U_Level;
	}

	public void setU_Level(int u_Level) {
		U_Level = u_Level;
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
		return "User [U_Id=" + U_Id + ", U_Image=" + U_Image + ", U_Username=" + U_Username + ", U_Password="
				+ U_Password + ", U_Gender=" + U_Gender + ", U_Phone=" + U_Phone + ", U_Email=" + U_Email + ", U_Level="
				+ U_Level + ", Created_At=" + Created_At + ", Update_At=" + Update_At + "]";
	}

	
}
