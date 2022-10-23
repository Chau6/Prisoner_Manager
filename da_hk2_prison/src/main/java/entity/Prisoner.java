package entity;

import java.time.LocalDate;

public class Prisoner {
	private int prisoner_id;
	private String fullname;
	private boolean gender;
	private LocalDate birthday;
	private LocalDate day_in;
	private LocalDate update_time;
	private int prison_id;
	private int case_id;
	private int dayout_id;

	public Prisoner() {
	};

	public Prisoner(int prisoner_id, String fullname, boolean gender, LocalDate birthday, LocalDate day_in,
			LocalDate update_time, int prison_id, int case_id, int dayout_id) {
		super();
		this.prisoner_id = prisoner_id;
		this.fullname = fullname;
		this.gender = gender;
		this.birthday = birthday;
		this.day_in = day_in;
		this.update_time = update_time;
		this.prison_id = prison_id;
		this.case_id = case_id;
		this.dayout_id = dayout_id;
	}

	public int getPrisoner_id() {
		return prisoner_id;
	}

	public void setPrisoner_id(int prisoner_id) {
		this.prisoner_id = prisoner_id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public LocalDate getDay_in() {
		return day_in;
	}

	public void setDay_in(LocalDate day_in) {
		this.day_in = day_in;
	}

	public LocalDate getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(LocalDate update_time) {
		this.update_time = update_time;
	}

	public int getPrison_id() {
		return prison_id;
	}

	public void setPrison_id(int prison_id) {
		this.prison_id = prison_id;
	}

	public int getCase_id() {
		return case_id;
	}

	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}

	public int getDayout_id() {
		return dayout_id;
	}

	public void setDayout_id(int dayout_id) {
		this.dayout_id = dayout_id;
	}

	@Override
	public String toString() {
		return "Prisoner [prisoner_id=" + prisoner_id + ", fullname=" + fullname + ", gender=" + (gender == true ? "nữ" : "nam") + ", birthday="
				+ birthday + ", day_in=" + day_in + ", update_time=" + update_time + ", prison_id=" + prison_id
				+ ", case_id=" + case_id + ", dayout_id=" + dayout_id + "]";
	}

}
