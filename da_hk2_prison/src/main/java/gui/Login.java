package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JPanel panel_1;
	public JLabel lblNewLabel;
	public JLabel lblUserName;
	public JTextField txtUserName;
	public JLabel lblPass;
	public JButton btnSubmit;
	public JPasswordField txtPass;
	public JButton btnSignUp;

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
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(0, 0, 275, 442);
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(183, 62, 125));
		panel_1.setBounds(274, 0, 411, 442);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 10, 149, 57);
		panel_1.add(lblNewLabel);
		
		lblUserName = new JLabel("UserName");
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(40, 97, 76, 26);
		panel_1.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setForeground(new Color(255, 255, 255));
		txtUserName.setBackground(new Color(183, 62, 125));
		txtUserName.addKeyListener(new KeyAdapter() {
			
		});
		txtUserName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUserName.setBounds(40, 133, 306, 26);
		panel_1.add(txtUserName);
		txtUserName.setColumns(10);
		
		lblPass = new JLabel("PassWord");
		lblPass.setForeground(new Color(255, 255, 255));
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPass.setBounds(40, 191, 76, 26);
		panel_1.add(lblPass);
		
		btnSubmit = new JButton("Sign In");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnSubmit.setBackground(new Color(183, 62, 125));
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnSubmitActionPerformed(e);
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmit.setBounds(40, 291, 131, 39);
		panel_1.add(btnSubmit);
		
		txtPass = new JPasswordField();
		txtPass.setForeground(new Color(255, 255, 255));
		txtPass.setBackground(new Color(183, 62, 125));
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		txtPass.setBounds(40, 230, 306, 26);
		panel_1.add(txtPass);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnSignUp.setBackground(new Color(183, 62, 125));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignUp.setBounds(181, 291, 131, 39);
		panel_1.add(btnSignUp);
	}
	
	protected void btnSubmitActionPerformed(ActionEvent e) {
		ArrayList<String> show = new ArrayList<>();
	
		String username = txtUserName.getText();
		char[] pass = txtPass.getPassword();
		
		show.add(username);
		show.add(String.valueOf(pass));
		

		
//		if(show.isEmpty()) {
//			showUserInfo(username,String.valueOf(pass));
//		} else {
//			String errMess = show.stream(). map(String::toString).collect(Collectors.joining(""));
//			JOptionPane.showMessageDialog(null, errMess, "Lỗi", JOptionPane.ERROR_MESSAGE);
//		}
		
		showUserInfo(username, String.valueOf(pass));
	}

	private void showUserInfo(String username, String string) {
		JOptionPane.showMessageDialog(null, 
				"Name: " + username 
				+ "\nPass: " + string);
	}
}
