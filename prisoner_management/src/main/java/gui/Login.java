package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import helper.RegexConst;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final int U_Id = 1;
	private JPanel contentPane;
	public JPanel panel;
	public JTextField txtEmail;
	public JButton btnSubmit;
	public JLabel lblNewLabel;
	public JLabel lblPassword;
	public JButton btnForgot;
	public JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 346, 416);
		contentPane.add(panel);

		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(238, 238, 238));
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setBounds(382, 126, 314, 37);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(0, 128, 192));
		btnSubmit.setBounds(421, 280, 231, 47);
		contentPane.add(btnSubmit);

		lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(382, 100, 142, 27);
		contentPane.add(lblNewLabel);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(382, 184, 142, 27);
		contentPane.add(lblPassword);

		btnForgot = new JButton("Forgot Pass?");
//		btnForgot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnForgotActionPerformed(e);
//			}
//		});
		btnForgot.setForeground(new Color(0, 0, 255));
		btnForgot.setHorizontalAlignment(SwingConstants.LEFT);
		btnForgot.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnForgot.setBackground(new Color(238, 238, 238));
		btnForgot.setBounds(382, 354, 101, 27);
		contentPane.add(btnForgot);

		txtPass = new JPasswordField();
		txtPass.setBackground(new Color(238, 238, 238));
		txtPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPass.setBounds(382, 210, 314, 37);
		contentPane.add(txtPass);
	}

//	public static PreparedStatement run(Connection con, int U_Id) throws SQLException {
//		String str = "select * from [User] where U_Id=?";
//		CallableStatement cs = con.prepareCall(str);
//		cs.setInt(1, U_Id);
//		return cs;
//	}
	public static PreparedStatement runU_Email(Connection con, String U_Email) throws Exception {
		String str = "select * from [User] where U_Email = ?"; //email k tồn tại -> db trả về null
		PreparedStatement ps = con.prepareStatement(str);
		ps.setString(1, U_Email);
		return ps;
	}

//	kiểm tra điều kiện trước khi vào
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		ArrayList<String> error = new ArrayList<>();
		String pass = String.valueOf(txtPass.getPassword());
		String email = txtEmail.getText();

		if (email.isBlank()) {
			error.add("Email not be empty\n");
		} else {
			if (!Pattern.compile(RegexConst.EMAIL).matcher(email).matches()) {
				error.add("Email is wrong (abc@abc.com)\n");
			}
		}

		if (String.valueOf(pass).isBlank()) {
			error.add("Password not be empty\n");
		} else {
			if (!Pattern.compile(RegexConst.PASS).matcher(pass).matches()) {
				error.add("Password must lenght 6 character\n");
			}
		}
		String connect = "jdbc:sqlserver://BUFALER\\SQLEXPRESS:1433;" + "databaseName=Prisoner_Management_System;"
				+ "user=sa; password=1";

		try (var con = DriverManager.getConnection(connect);
//				var ps = run(con,U_Id);
				var ps1 = runU_Email(con, txtEmail.getText());
//				ResultSet rs = ps.executeQuery();
				ResultSet rs1 = ps1.executeQuery()) {
			while (rs1.next()) {//nếu db null thì bỏ qua
				if (rs1.getString("U_Email").equals(txtEmail.getText())) {
					error.add("Email already exists");
				}
			}
			if(error.isEmpty()) {
				error.add("Email not exists");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

//		check Login
		if (error.isEmpty()) {
			showUserInfo(email, pass);
			Main main = new Main();

			this.setVisible(false);
			main.setVisible(true);
		} else {
			String errMess = error.stream().map(String::toString).collect(Collectors.joining(""));
			JOptionPane.showMessageDialog(null, errMess, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

//		protected void btnForgotActionPerformed(ActionEvent e) {
//			ForgotPass fpas = new ForgotPass();
//			fpas.setVisible(true);
//			this.setVisible(false);
//		}

	protected void showUserInfo(String user, String pass) {
		JOptionPane.showMessageDialog(null, "hello " + user + "\n" + "pass is: " + pass);
	}
}
