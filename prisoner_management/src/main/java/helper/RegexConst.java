package helper;

public class RegexConst {
//	public final static String USERNAME = "^([a-zA-Z0-9]\\s*){6,20}$";
//	public final static String PASSWORD = "^([a-zA-Z0-9]\\s*){6,20}$";
//	public final static String PHONE = "^(84|0[3|5|7|8|9])+([0-9]{8,9})\\b$";
//	public final static String EMAIL = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
//	public final static String FULLNAME = "^([a-zA-Z]\\s*){1,50}$";
//	public final static String DATE = "\\d{4}[-|/]\\d{2}[-]\\d{2}";
//	public final static String ID = "^\\d{4,}$";
	public final static String ID_1 = "^\\d{1,}$";

	public final static String USERNAME = "^([a-zA-Z0-9]\\s*){6,20}$";
	public final static String PASSWORD = "^([a-zA-Z0-9]\\s*){6,20}$";
	public final static String PHONE = "^(84|0[3|5|7|8|9])+([0-9]{8,9})\\b$";
	public final static String FULLNAME = "^([a-zA-Z]\\s*){1,50}$";
	public final static String DATE = "\\d{4}[-|/]\\d{2}[-]\\d{2}";
	public final static String ID = "^\\d{4,}$";

	public final static String NUM = "^([0-9]\\s*){7,11}$";
	public final static String CHARS = "^([a-zA-Z]\\s*){1,25}$";
	public final static String ACC = "^([a-zA-Z0-9]\\s*){1,25}$";
	public final static String PASS = "^([a-zA-Z0-9]\\s*){1,25}$";
	public final static String EMAIL = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

}
