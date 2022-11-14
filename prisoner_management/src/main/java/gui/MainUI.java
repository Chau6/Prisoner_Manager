package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel btn_Transfer;
	private JLabel lblNewLabel_6;
	private JLabel sdas;
	private JPanel btn_Feedback;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JPanel btn_Prisoners;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel btn_Prisonn;
	private JLabel lblNewLabel_2;
	private JLabel btn_Prison;
	private JPanel btn_Supervisions;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel btn_InteriorMinister;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JPanel btn_User;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JPanel btn_Logout;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JPanel panel_10;
	private JLabel lblNewLabel_16;
	private JSeparator separator;
	private JSeparator separator_1;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
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
	public MainUI() {
		setTitle("Main O v e r D o s e");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ACER\\Downloads\\8156567_network_connect_electricity_system_energy_icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(0, 0, 275, 761);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_Transfer = new JPanel();
		btn_Transfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_TransferMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_TransferMouseExited(e);
			}
		});
		btn_Transfer.setLayout(null);
		btn_Transfer.setBackground(new Color(64, 0, 128));
		btn_Transfer.setBounds(0, 389, 274, 68);
		panel.add(btn_Transfer);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\8550626_transition_conversion_convert_transfer_motion_icon.png"));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(12, 11, 55, 46);
		btn_Transfer.add(lblNewLabel_6);
		
		sdas = new JLabel("Transfer");
		sdas.setForeground(new Color(255, 255, 255));
		sdas.setHorizontalAlignment(SwingConstants.CENTER);
		sdas.setFont(new Font("Segoe UI", Font.BOLD, 17));
		sdas.setBounds(77, 11, 150, 46);
		btn_Transfer.add(sdas);
		
		btn_Feedback = new JPanel();
		btn_Feedback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_FeedbackMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_FeedbackMouseExited(e);
			}
		});
		btn_Feedback.setLayout(null);
		btn_Feedback.setBackground(new Color(64, 0, 128));
		btn_Feedback.setBounds(0, 456, 274, 68);
		panel.add(btn_Feedback);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\5740110_bookmark_favorite_feedback_rating_review_icon.png"));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(12, 11, 55, 46);
		btn_Feedback.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Feedback");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_9.setBounds(77, 11, 150, 46);
		btn_Feedback.add(lblNewLabel_9);
		
		btn_Prisoners = new JPanel();
		btn_Prisoners.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_PrisonersMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_PrisonersMouseExited(e);
			}
		});
		btn_Prisoners.setLayout(null);
		btn_Prisoners.setBackground(new Color(64, 0, 128));
		btn_Prisoners.setBounds(0, 255, 274, 68);
		panel.add(btn_Prisoners);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\7023964_anonymous_cyber crime_criminal_hack_hacker_icon.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 11, 55, 46);
		btn_Prisoners.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Prisoners");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(77, 11, 150, 46);
		btn_Prisoners.add(lblNewLabel_1);
		
		btn_Prisonn = new JPanel();
		btn_Prisonn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_PrisonnMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_PrisonnMouseExited(e);
			}
		});
		btn_Prisonn.setLayout(null);
		btn_Prisonn.setBackground(new Color(64, 0, 128));
		btn_Prisonn.setBounds(0, 322, 274, 68);
		panel.add(btn_Prisonn);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\9081366_prison_icon.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 11, 55, 46);
		btn_Prisonn.add(lblNewLabel_2);
		
		btn_Prison = new JLabel("Prison");
		btn_Prison.setForeground(new Color(255, 255, 255));
		btn_Prison.setBackground(new Color(240, 240, 240));
		btn_Prison.setHorizontalAlignment(SwingConstants.CENTER);
		btn_Prison.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_Prison.setBounds(77, 11, 150, 46);
		btn_Prisonn.add(btn_Prison);
		
		btn_Supervisions = new JPanel();
		btn_Supervisions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_SupervisionsMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_SupervisionsMouseExited(e);
			}
		});
		btn_Supervisions.setLayout(null);
		btn_Supervisions.setBackground(new Color(64, 0, 128));
		btn_Supervisions.setBounds(0, 121, 274, 68);
		panel.add(btn_Supervisions);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\809522_monitor_multimedia_technology_user_icon (1).png"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 11, 55, 46);
		btn_Supervisions.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Supervisions");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_5.setBounds(77, 11, 150, 46);
		btn_Supervisions.add(lblNewLabel_5);
		
		btn_InteriorMinister = new JPanel();
		btn_InteriorMinister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_InteriorMinisterMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_InteriorMinisterMouseExited(e);
			}
		});
		btn_InteriorMinister.setLayout(null);
		btn_InteriorMinister.setBackground(new Color(64, 0, 128));
		btn_InteriorMinister.setBounds(0, 188, 274, 68);
		panel.add(btn_InteriorMinister);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\4193104_aristocrat_british_gentlemen_man_sir_icon.png"));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(12, 11, 55, 46);
		btn_InteriorMinister.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Interior Minister");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_11.setBounds(77, 11, 150, 46);
		btn_InteriorMinister.add(lblNewLabel_11);
		
		btn_User = new JPanel();
		btn_User.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_UserMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_UserMouseExited(e);
			}
		});
		btn_User.setLayout(null);
		btn_User.setBackground(new Color(64, 0, 128));
		btn_User.setBounds(0, 523, 274, 68);
		panel.add(btn_User);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\172628_user_male_icon.png"));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(12, 11, 55, 46);
		btn_User.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("User");
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_13.setBounds(77, 11, 150, 46);
		btn_User.add(lblNewLabel_13);
		
		btn_Logout = new JPanel();
		btn_Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_LogoutMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_LogoutMouseExited(e);
			}
		});
		btn_Logout.setLayout(null);
		btn_Logout.setBackground(new Color(64, 0, 128));
		btn_Logout.setBounds(0, 684, 274, 53);
		panel.add(btn_Logout);
		
		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setForeground(new Color(255, 255, 255));
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\8679875_logout_circle_line_icon.png"));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(26, 0, 57, 53);
		btn_Logout.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Log Out");
		lblNewLabel_15.setForeground(new Color(255, 255, 255));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_15.setBounds(89, 0, 139, 53);
		btn_Logout.add(lblNewLabel_15);
		
		panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(0, 0, 64));
		panel_10.setBounds(0, 0, 274, 122);
		panel.add(panel_10);
		
		lblNewLabel_16 = new JLabel("O v e r D o s e");
		lblNewLabel_16.setForeground(new Color(192, 192, 192));
		lblNewLabel_16.setBackground(new Color(255, 255, 255));
		lblNewLabel_16.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel_16.setBounds(43, 48, 188, 26);
		panel_10.add(lblNewLabel_16);
		
		separator = new JSeparator();
		separator.setBounds(10, 85, 206, 2);
		panel_10.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(58, 96, 206, 2);
		panel_10.add(separator_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(273, 0, 1011, 761);
		contentPane.add(panel_1);
	}
	public void setColor(JPanel p) {
		p.setBackground(new Color (171,171,171));
	}
	public void resetColor(JPanel p1) {
		p1.setBackground(new Color (64,0,128));
	}
	
	protected void btn_SupervisionsMouseEntered(MouseEvent e) {
		setColor(btn_Supervisions);
	}
	protected void btn_SupervisionsMouseExited(MouseEvent e) {
		resetColor(btn_Supervisions);
	}
	protected void btn_InteriorMinisterMouseEntered(MouseEvent e) {
		setColor(btn_InteriorMinister);
	}
	protected void btn_InteriorMinisterMouseExited(MouseEvent e) {
		resetColor(btn_InteriorMinister);
	}
	protected void btn_PrisonersMouseEntered(MouseEvent e) {
		setColor(btn_Prisoners);
	}
	protected void btn_PrisonersMouseExited(MouseEvent e) {
		resetColor(btn_Prisoners);
	}
	protected void btn_PrisonnMouseEntered(MouseEvent e) {
		setColor(btn_Prisonn);
	}
	protected void btn_PrisonnMouseExited(MouseEvent e) {
		resetColor(btn_Prisonn);
	}
	protected void btn_TransferMouseEntered(MouseEvent e) {
		setColor(btn_Transfer);
	}
	protected void btn_TransferMouseExited(MouseEvent e) {
		resetColor(btn_Transfer);
	}
	protected void btn_FeedbackMouseEntered(MouseEvent e) {
		setColor(btn_Feedback);
	}
	protected void btn_FeedbackMouseExited(MouseEvent e) {
		resetColor(btn_Feedback);
	}
	protected void btn_UserMouseEntered(MouseEvent e) {
		setColor(btn_User);
	}
	protected void btn_UserMouseExited(MouseEvent e) {
		resetColor(btn_User);
	}
	protected void btn_LogoutMouseEntered(MouseEvent e) {
		setColor(btn_Logout);
	}
	protected void btn_LogoutMouseExited(MouseEvent e) {
		resetColor(btn_Logout);
	}
}
