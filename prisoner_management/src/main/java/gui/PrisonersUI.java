package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;

public class PrisonersUI extends JInternalFrame {
	private JPanel contentPane;
	private JPanel panel;
	private JPanel btn_Transfer;
	private JLabel lblNewLabel;
	private JLabel sdas;
	private JPanel btn_Feedback;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel btn_Prisoners;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel btn_Prisonn;
	private JLabel lblNewLabel_5;
	private JLabel btn_Prison;
	private JPanel btn_Supervisions;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JPanel btn_InteriorMinister;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JPanel btn_User;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JPanel btn_Logout;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JPanel panel_1;
	private JLabel lblNewLabel_14;
	private JSeparator separator;
	private JSeparator separator_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrisonersUI frame = new PrisonersUI();
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
	public PrisonersUI() {
		setTitle("Prisoners");
		setFrameIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\379420_prisoner_icon (1).png"));
		setBounds(100, 100, 1300, 800);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(102, 102, 179));
		contentPane.setBounds(0, 0, 1284, 761);
		getContentPane().add(contentPane);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(0, 0, 275, 761);
		contentPane.add(panel);
		
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
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\8550626_transition_conversion_convert_transfer_motion_icon.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 11, 55, 46);
		btn_Transfer.add(lblNewLabel);
		
		sdas = new JLabel("Transfer");
		sdas.setHorizontalAlignment(SwingConstants.CENTER);
		sdas.setForeground(Color.WHITE);
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
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\5740110_bookmark_favorite_feedback_rating_review_icon.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 11, 55, 46);
		btn_Feedback.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Feedback");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_2.setBounds(77, 11, 150, 46);
		btn_Feedback.add(lblNewLabel_2);
		
		btn_Prisoners = new JPanel();
		btn_Prisoners.setLayout(null);
		btn_Prisoners.setBackground(new Color(171, 181, 181));
		btn_Prisoners.setBounds(0, 255, 274, 68);
		panel.add(btn_Prisoners);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\7023964_anonymous_cyber crime_criminal_hack_hacker_icon.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 11, 55, 46);
		btn_Prisoners.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Prisoners");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_4.setBounds(77, 11, 150, 46);
		btn_Prisoners.add(lblNewLabel_4);
		
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
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\9081366_prison_icon.png"));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(12, 11, 55, 46);
		btn_Prisonn.add(lblNewLabel_5);
		
		btn_Prison = new JLabel("Prison");
		btn_Prison.setHorizontalAlignment(SwingConstants.CENTER);
		btn_Prison.setForeground(Color.WHITE);
		btn_Prison.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_Prison.setBackground(SystemColor.menu);
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
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\809522_monitor_multimedia_technology_user_icon (1).png"));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(12, 11, 55, 46);
		btn_Supervisions.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Supervisions");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_7.setBounds(77, 11, 150, 46);
		btn_Supervisions.add(lblNewLabel_7);
		
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
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\4193104_aristocrat_british_gentlemen_man_sir_icon.png"));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(12, 11, 55, 46);
		btn_InteriorMinister.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Interior Minister");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_9.setBounds(77, 11, 150, 46);
		btn_InteriorMinister.add(lblNewLabel_9);
		
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
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\172628_user_male_icon.png"));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(12, 11, 55, 46);
		btn_User.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("User");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_11.setBounds(77, 11, 150, 46);
		btn_User.add(lblNewLabel_11);
		
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
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\8679875_logout_circle_line_icon.png"));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBounds(26, 0, 57, 53);
		btn_Logout.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Log Out");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_13.setBounds(89, 0, 139, 53);
		btn_Logout.add(lblNewLabel_13);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 64));
		panel_1.setBounds(0, 0, 274, 122);
		panel.add(panel_1);
		
		lblNewLabel_14 = new JLabel("O v e r D o s e");
		lblNewLabel_14.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_14.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel_14.setBackground(Color.WHITE);
		lblNewLabel_14.setBounds(43, 48, 188, 26);
		panel_1.add(lblNewLabel_14);
		
		separator = new JSeparator();
		separator.setBounds(10, 85, 206, 2);
		panel_1.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(58, 96, 206, 2);
		panel_1.add(separator_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(274, 121, 1010, 640);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

	}
	public void setColor(JPanel p) {
		p.setBackground(new Color (171,171,171));
	}
	public void resetColor(JPanel p1) {
		p1.setBackground(new Color (64,0,128));
	}
	
//	1protected void btn_SupervisionsMouseEntered(MouseEvent e) {
//		setColor(btn_Supervisions);
//	}
//	2protected void btn_SupervisionsMouseExited(MouseEvent e) {
//		resetColor(btn_Supervisions);
//	}
//	3protected void btn_InteriorMinisterMouseEntered(MouseEvent e) {
//		setColor(btn_InteriorMinister);
//	}
//	4protected void btn_InteriorMinisterMouseExited(MouseEvent e) {
//		resetColor(btn_InteriorMinister);
//	}
//	5protected void btn_PrisonersMouseEntered(MouseEvent e) {
//		setColor(btn_Prisoners);
//	}
//	6protected void btn_PrisonersMouseExited(MouseEvent e) {
//		resetColor(btn_Prisoners);
//	}
//	p7rotected void btn_PrisonnMouseEntered(MouseEvent e) {
//		setColor(btn_Prisonn);
//	}
//	pr8otected void btn_PrisonnMouseExited(MouseEvent e) {
//		resetColor(btn_Prisonn);
//	}
//	pro9tected void btn_TransferMouseEntered(MouseEvent e) {
//		setColor(btn_Transfer);
//	}
//	prot10ected void btn_TransferMouseExited(MouseEvent e) {
//		resetColor(btn_Transfer);
//	}
//	protec11ted void btn_FeedbackMouseEntered(MouseEvent e) {
//		setColor(btn_Feedback);
//	}
//	protecte12d void btn_FeedbackMouseExited(MouseEvent e) {
//		resetColor(btn_Feedback);
//	}
//	protected 13void btn_UserMouseEntered(MouseEvent e) {
//		setColor(btn_User);
//	}
//	protected vo14id btn_UserMouseExited(MouseEvent e) {
//		resetColor(btn_User);
//	}
//	protected void15 btn_LogoutMouseEntered(MouseEvent e) {
//		setColor(btn_Logout);
//	}
//	protected void b16tn_LogoutMouseExited(MouseEvent e) {
//		resetColor(btn_Logout);
//	}

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
