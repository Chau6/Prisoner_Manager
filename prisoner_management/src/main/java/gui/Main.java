package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	public JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_3;
	private JSeparator separator_1;
	private JMenuItem mntmNewMenuItem_4;
	private JSeparator separator_2;
	private JMenuItem mntmNewMenuItem_5;
	private JSeparator separator_3;
	private JMenuItem mntmNewMenuItem_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Dialog", Font.BOLD, 15));

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Main.class.getResource("/image/icon/339885_jail_prison_icon.png")));
		setTitle("Prisoner Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
//		contentPane.addAncestorListener(new AncestorListener() {
//			public void ancestorAdded(AncestorEvent event) {
//				contentPaneAncestorAdded(event);
//			}
//
//			public void ancestorMoved(AncestorEvent event) {
//			}
//
//			public void ancestorRemoved(AncestorEvent event) {
//			}
//		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 22, 1184, 739);
		contentPane.add(desktopPane);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1184, 22);
		contentPane.add(menuBar);

		mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem_1 = new JMenuItem("Supervisons");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItem_1ActionPerformed(e);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(Main.class
				.getResource("/image/icon/473778_business_hierarchy_leadership_management_organization_icon.png")));
		mnNewMenu.add(mntmNewMenuItem_1);

		mntmNewMenuItem = new JMenuItem("Interior Minister");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItemActionPerformed(e);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(
				Main.class.getResource("/image/icon/4715005_avatar_guard_people_person_profile_icon.png")));
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_2 = new JMenuItem("Prisoners");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItem_2ActionPerformed(e);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(Main.class.getResource("/image/icon/379420_prisoner_icon.png")));
		mnNewMenu.add(mntmNewMenuItem_2);

		separator = new JSeparator();
		mnNewMenu.add(separator);

		mntmNewMenuItem_3 = new JMenuItem("Prison");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItem_3ActionPerformed(e);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(
				Main.class.getResource("/image/icon/4059744_and_architecture_jail_police_prison_icon.png")));
		mnNewMenu.add(mntmNewMenuItem_3);

		separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);

		mntmNewMenuItem_6 = new JMenuItem("Transfer");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItem_6ActionPerformed(e);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(Main.class.getResource("/image/icon/9071382_transfer_icon.png")));
		mnNewMenu.add(mntmNewMenuItem_6);

		separator_3 = new JSeparator();
		mnNewMenu.add(separator_3);

		mntmNewMenuItem_4 = new JMenuItem("Feedback");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItem_4ActionPerformed(e);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(Main.class.getResource("/image/icon/3669434_feedback_ic_icon.png")));
		mnNewMenu.add(mntmNewMenuItem_4);

		separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);

		mntmNewMenuItem_5 = new JMenuItem("Users");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItem_5ActionPerformed(e);
			}
		});
		mntmNewMenuItem_5.setIcon(
				new ImageIcon(Main.class.getResource("/image/icon/7388_forum_friends_group_member_people_icon.png")));
		mnNewMenu.add(mntmNewMenuItem_5);
	}

	protected void mntmNewMenuItem_5ActionPerformed(ActionEvent e) {
		// users
		final JInternalFrame[] frames = desktopPane.getAllFrames(); // do getAllFrames trả về 1 cái mảng
		JInternalFrame jf = null; // khai báo entity = null
		jf = Arrays.asList(frames) // chuyển mảng -> list
				.stream().filter(x -> x.toString().contains("User")).findAny() // tìm bất kỳ cái nào có cái tên
																				// SubFrame -> thấy thì trả về, k
																				// thấy báo lỗi
				.orElse(null); // ngăn findAny báo lỗi

		if (jf == null) {
			Users f1 = new Users();
			desktopPane.add(f1);
			f1.setVisible(true);
		}
	}

	protected void mntmNewMenuItem_1ActionPerformed(ActionEvent e) {
		// supervision
		final JInternalFrame[] frames = desktopPane.getAllFrames(); // do getAllFrames trả về 1 cái mảng
		JInternalFrame jf = null; // khai báo entity = null
		jf = Arrays.asList(frames) // chuyển mảng -> list
				.stream().filter(x -> x.toString().contains("Supervision")).findAny().orElse(null); // ngăn findAny báo
																									// lỗi

		if (jf == null) {
			Supervisions f = new Supervisions();
			desktopPane.add(f);
			f.setVisible(true);
		}
	}

	protected void mntmNewMenuItem_2ActionPerformed(ActionEvent e) {
		// prisoner
		final JInternalFrame[] frames = desktopPane.getAllFrames(); // do getAllFrames trả về 1 cái mảng
		JInternalFrame jf = null; // khai báo entity = null
		jf = Arrays.asList(frames) // chuyển mảng -> list
				.stream().filter(x -> x.toString().contains("Prisoner")).findAny().orElse(null); // ngăn findAny báo
																									// lỗi

		if (jf == null) {
			Prisoners f = new Prisoners();
			desktopPane.add(f);
			f.setVisible(true);
		}
	}

	protected void mntmNewMenuItemActionPerformed(ActionEvent e) {
		// guard
		final JInternalFrame[] frames = desktopPane.getAllFrames(); // do getAllFrames trả về 1 cái mảng
		JInternalFrame jf = null; // khai báo entity = null
		jf = Arrays.asList(frames) // chuyển mảng -> list
				.stream().filter(x -> x.toString().contains("Interior_Minister")).findAny().orElse(null); // ngăn findAny báo lỗi

		if (jf == null) {
			InteriorMinister f = new InteriorMinister();
			desktopPane.add(f);
			f.setVisible(true);
		}
	}

	protected void mntmNewMenuItem_6ActionPerformed(ActionEvent e) {
		// transfer
		final JInternalFrame[] frames = desktopPane.getAllFrames(); // do getAllFrames trả về 1 cái mảng
		JInternalFrame jf = null; // khai báo entity = null
		jf = Arrays.asList(frames) // chuyển mảng -> list
				.stream().filter(x -> x.toString().contains("Transfer")).findAny().orElse(null); // ngăn findAny báo
																									// lỗi

		if (jf == null) {
			Transfers f = new Transfers();
			desktopPane.add(f);
			f.setVisible(true);
		}
	}

	protected void mntmNewMenuItem_4ActionPerformed(ActionEvent e) {
		final JInternalFrame[] frames = desktopPane.getAllFrames(); // do getAllFrames trả về 1 cái mảng
		JInternalFrame jf = null; // khai báo entity = null
		jf = Arrays.asList(frames) // chuyển mảng -> list
				.stream().filter(x -> x.toString().contains("Feedback")).findAny().orElse(null); // ngăn findAny báo
																									// lỗi

		if (jf == null) {
			Feedbacks f = new Feedbacks();
			desktopPane.add(f);
			f.setVisible(true);
		}
	}

//	protected void contentPaneAncestorAdded(AncestorEvent event) {
//		mntmNewMenuItem.setEnabled(false);
//		mntmNewMenuItem_1.setEnabled(false);
//		mntmNewMenuItem_2.setEnabled(false);
//		mntmNewMenuItem_3.setEnabled(false);
//		mntmNewMenuItem_4.setEnabled(false);
//		mntmNewMenuItem_5.setEnabled(false);
//		mntmNewMenuItem_6.setEnabled(false);
//		// login
//		final JInternalFrame[] frames = desktopPane.getAllFrames(); // do getAllFrames trả về 1 cái mảng
//		JInternalFrame jf = null; // khai báo entity = null
//		jf = Arrays.asList(frames) // chuyển mảng -> list
//				.stream().filter(x -> x.toString().contains("Login")).findAny().orElse(null); // ngăn findAny báo
//																									// lỗi
//
//		if (jf == null) {
//			Login f = new Login();
////			mntmNewMenuItem,mntmNewMenuItem_1,mntmNewMenuItem_2,mntmNewMenuItem_3,mntmNewMenuItem_4,mntmNewMenuItem_5,mntmNewMenuItem_6
//			desktopPane.add(f);
//			f.setVisible(true);
//			f.btnNewButtonActionPerformed(null,mntmNewMenuItem,mntmNewMenuItem_1,mntmNewMenuItem_2,mntmNewMenuItem_3,mntmNewMenuItem_4,mntmNewMenuItem_5,mntmNewMenuItem_6);
//		}
//	}
	protected void mntmNewMenuItem_3ActionPerformed(ActionEvent e) {
		final JInternalFrame[] frames = desktopPane.getAllFrames(); // do getAllFrames trả về 1 cái mảng
		JInternalFrame jf = null; // khai báo entity = null
		jf = Arrays.asList(frames) // chuyển mảng -> list
				.stream().filter(x -> x.toString().contains("Block")).findAny().orElse(null); // ngăn findAny báo
																									// lỗi

		if (jf == null) {
			Blocks f = new Blocks();
			desktopPane.add(f);
			f.setVisible(true);
		}
	}
}
