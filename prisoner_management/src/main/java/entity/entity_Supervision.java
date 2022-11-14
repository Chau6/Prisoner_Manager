package entity;

public class entity_Supervision {
	private String ID;
	private String Image;
	private String Name;
	private String Gender;
	private String Dob;
	private String Level;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	public String getLevel() {
		return Level;
	}
	public void setLevel(String level) {
		Level = level;
	}
	public entity_Supervision() {
		super();
	}
	public entity_Supervision(String iD, String image, String name, String gender, String dob, String level) {
		super();
		ID = iD;
		Image = image;
		Name = name;
		Gender = gender;
		Dob = dob;
		Level = level;
	}
	

}
