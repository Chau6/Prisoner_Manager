package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import dao.User_Dao;
import helper.RegexConst;

import javax.swing.event.AncestorEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class Users extends JInternalFrame {
	private JTabbedPane tabbedPane;
	private JPanel User_Index;
	private JPanel Insert;
	private JPanel Update;
	private JScrollPane scrollPane;
	private JTable table;

	Integer pageNumber = 1;
	Integer rowsOfPage = 10;
	Integer totalOfRows = 0;
	Double totalPage = 0.0;
	String imgPath = null;
	String oldImg = null;
	private JLabel lblStatusPage;
	private JLabel lblTotalOfRow;
	private JButton btnFirstButton;
	private JButton btnPreviusButton;
	private JComboBox comboBox;
	private JButton btnNextButton;
	private JButton btnLastButton;
	private JTextField txtPage;
	private JButton btnFindUser;
	private JTextField txtGetId;
	private JButton btnShowAll;
	private JButton btnDeleteUser;
	private JLabel lblNewLabel;
	private JLabel lblLevel;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUsername;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JComboBox txtLevel;
	private JButton btnNewButton;
	private JLabel lblupdateUser;
	private JLabel lblLevel_1;
	private JLabel lblEmail_1;
	private JLabel lblPhone_1;
	private JLabel lblUsername_1;
	private JLabel lblPassword_1;
	private JTextField txtUpdateUsername;
	private JTextField txtUpdatePhone;
	private JTextField txtUpdateEmail;
	private JPasswordField txtUpdatePassword;
	private JComboBox txtUpdateLevel;
	private JLabel lblUserId_1;
	private JTextField txtUpdateUserId;
	private JButton btnNewButton_1;
	private JLabel lblGender;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblAvatar;
	private JButton btnLoadImage;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_1;
	private JLabel lblGender_1;
	private JRadioButton rdbtnMale_1;
	private JRadioButton rdbtnFemale_1;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lblAvatar_1;
	private JButton btnLoadImage_1;
	private JScrollPane scrollPane_2;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users frame = new Users();
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
	public Users() {
		setFrameIcon(
				new ImageIcon(Users.class.getResource("/image/icon/7388_forum_friends_group_member_people_icon.png")));
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("User");
		setBounds(100, 100, 1100, 700);
		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1084, 670);
		getContentPane().add(tabbedPane);

		User_Index = new JPanel();
		User_Index.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				User_IndexAncestorAdded(event);
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		tabbedPane.addTab("List", new ImageIcon(Users.class.getResource("/image/icon/216422_list_th_icon.png")),
				User_Index, null);
		User_Index.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1079, 566);
		User_Index.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		lblStatusPage = new JLabel("Page 1 of 0");
		lblStatusPage.setBounds(20, 611, 100, 14);
		User_Index.add(lblStatusPage);

		lblTotalOfRow = new JLabel("Rows count: 0");
		lblTotalOfRow.setBounds(969, 611, 100, 14);
		User_Index.add(lblTotalOfRow);

		btnFirstButton = new JButton("First Button");
		btnFirstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstButtonActionPerformed(e);
			}
		});
		btnFirstButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnFirstButton.setBounds(10, 577, 100, 23);
		User_Index.add(btnFirstButton);

		btnPreviusButton = new JButton("Previus Button");
		btnPreviusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviusButtonActionPerformed(e);
			}
		});
		btnPreviusButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnPreviusButton.setBounds(450, 577, 120, 23);
		User_Index.add(btnPreviusButton);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActionPerformed(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "10", "20", "30" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(230, 578, 100, 21);
		User_Index.add(comboBox);

		btnNextButton = new JButton("Next Button");
		btnNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextButtonActionPerformed(e);
			}
		});
		btnNextButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNextButton.setBounds(340, 577, 100, 23);
		User_Index.add(btnNextButton);

		btnLastButton = new JButton("Last Button");
		btnLastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastButtonActionPerformed(e);
			}
		});
		btnLastButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnLastButton.setBounds(120, 577, 100, 23);
		User_Index.add(btnLastButton);

		txtPage = new JTextField();
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		txtPage.setBounds(340, 608, 329, 20);
		User_Index.add(txtPage);

		btnFindUser = new JButton("Find User");
		btnFindUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFindUserActionPerformed(e);
			}
		});
		btnFindUser.setBounds(580, 577, 89, 23);
		User_Index.add(btnFindUser);

		txtGetId = new JTextField();
		txtGetId.setBounds(679, 578, 140, 22);
		User_Index.add(txtGetId);
		txtGetId.setColumns(10);

		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowAllActionPerformed(e);
			}
		});
		btnShowAll.setBounds(928, 577, 100, 23);
		User_Index.add(btnShowAll);

		btnDeleteUser = new JButton("Delete");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteUserActionPerformed(e);
			}
		});
		btnDeleteUser.setBounds(829, 577, 89, 23);
		User_Index.add(btnDeleteUser);

		Insert = new JPanel();
		tabbedPane.addTab("Insert", new ImageIcon(Users.class.getResource("/image/icon/216490_add_user_icon.png")),
				Insert, null);
		Insert.setLayout(null);

		lblNewLabel = new JLabel(
				"<html><span color=red style='font-size:80px;'>&#10133;_Insert User_&#10133;</span></html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 11, 1000, 216);
		Insert.add(lblNewLabel);

		lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLevel.setBounds(210, 471, 141, 25);
		Insert.add(lblLevel);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(210, 396, 141, 25);
		Insert.add(lblEmail);

		lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhone.setBounds(210, 360, 141, 25);
		Insert.add(lblPhone);

		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(212, 251, 141, 25);
		Insert.add(lblUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(212, 287, 141, 25);
		Insert.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(346, 257, 225, 19);
		Insert.add(txtUsername);
		txtUsername.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(346, 366, 225, 19);
		Insert.add(txtPhone);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(346, 402, 225, 19);
		Insert.add(txtEmail);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(346, 292, 225, 19);
		Insert.add(txtPassword);

		txtLevel = new JComboBox();
		txtLevel.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		txtLevel.setBounds(346, 471, 225, 25);
		Insert.add(txtLevel);

		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnNewButton.setBounds(569, 591, 128, 34);
		Insert.add(btnNewButton);

		lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(211, 324, 141, 25);
		Insert.add(lblGender);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(346, 329, 56, 23);
		Insert.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(419, 329, 77, 23);
		Insert.add(rdbtnFemale);

		lblAvatar = new JLabel("Avatar:");
		lblAvatar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAvatar.setBounds(210, 432, 141, 25);
		Insert.add(lblAvatar);

		btnLoadImage = new JButton("Load Image");
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadImageActionPerformed(e);
			}
		});
		btnLoadImage.setBounds(346, 436, 225, 24);
		Insert.add(btnLoadImage);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(619, 205, 400, 350);
		Insert.add(scrollPane_1);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		scrollPane_1.setViewportView(lblNewLabel_1);

		Update = new JPanel();
		tabbedPane.addTab("Update",
				new ImageIcon(
						Users.class.getResource("/image/icon/7106354_reload_data_infographic_update_element_icon.png")),
				Update, null);
		Update.setLayout(null);

		lblupdateUser = new JLabel(
				"<html><span color=red style='font-size:80px;'>&#10133;_Update User_&#10133;</span></html>");
		lblupdateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblupdateUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblupdateUser.setBounds(39, 0, 1000, 216);
		Update.add(lblupdateUser);

		lblLevel_1 = new JLabel("Level:");
		lblLevel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLevel_1.setBounds(216, 492, 141, 25);
		Update.add(lblLevel_1);

		lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail_1.setBounds(216, 420, 141, 25);
		Update.add(lblEmail_1);

		lblPhone_1 = new JLabel("Phone:");
		lblPhone_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhone_1.setBounds(216, 384, 141, 25);
		Update.add(lblPhone_1);

		lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername_1.setBounds(216, 276, 141, 25);
		Update.add(lblUsername_1);

		lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword_1.setBounds(216, 312, 141, 25);
		Update.add(lblPassword_1);

		txtUpdateUsername = new JTextField();
		txtUpdateUsername.setColumns(10);
		txtUpdateUsername.setBounds(350, 282, 225, 19);
		Update.add(txtUpdateUsername);

		txtUpdatePhone = new JTextField();
		txtUpdatePhone.setColumns(10);
		txtUpdatePhone.setBounds(350, 390, 225, 19);
		Update.add(txtUpdatePhone);

		txtUpdateEmail = new JTextField();
		txtUpdateEmail.setColumns(10);
		txtUpdateEmail.setBounds(350, 426, 225, 19);
		Update.add(txtUpdateEmail);

		txtUpdatePassword = new JPasswordField();
		txtUpdatePassword.setBounds(350, 317, 225, 19);
		Update.add(txtUpdatePassword);

		txtUpdateLevel = new JComboBox();
		txtUpdateLevel.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		txtUpdateLevel.setBounds(350, 499, 225, 19);
		Update.add(txtUpdateLevel);

		lblUserId_1 = new JLabel("User Id:");
		lblUserId_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserId_1.setBounds(216, 246, 141, 25);
		Update.add(lblUserId_1);

		txtUpdateUserId = new JTextField();
		txtUpdateUserId.setColumns(10);
		txtUpdateUserId.setBounds(350, 252, 225, 19);
		Update.add(txtUpdateUserId);

		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(580, 591, 128, 34);
		Update.add(btnNewButton_1);

		lblGender_1 = new JLabel("Gender:");
		lblGender_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender_1.setBounds(216, 348, 141, 25);
		Update.add(lblGender_1);

		rdbtnMale_1 = new JRadioButton("Male");
		buttonGroup_1.add(rdbtnMale_1);
		rdbtnMale_1.setSelected(true);
		rdbtnMale_1.setBounds(350, 348, 56, 23);
		Update.add(rdbtnMale_1);

		rdbtnFemale_1 = new JRadioButton("Female");
		buttonGroup_1.add(rdbtnFemale_1);
		rdbtnFemale_1.setBounds(423, 348, 77, 23);
		Update.add(rdbtnFemale_1);

		lblAvatar_1 = new JLabel("Avatar:");
		lblAvatar_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAvatar_1.setBounds(216, 456, 141, 25);
		Update.add(lblAvatar_1);

		btnLoadImage_1 = new JButton("Load Image");
		btnLoadImage_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadImage_1ActionPerformed(e);
			}
		});
		btnLoadImage_1.setBounds(350, 460, 227, 24);
		Update.add(btnLoadImage_1);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(609, 230, 400, 350);
		Update.add(scrollPane_2);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		scrollPane_2.setViewportView(lblNewLabel_2);

	}

	protected void User_IndexAncestorAdded(AncestorEvent event) {
		// when start auto run
		// update
		txtUpdateUserId.setEnabled(false);
		txtUpdateUsername.setEnabled(false);
		txtUpdatePassword.setEnabled(false);
		rdbtnMale_1.setEnabled(false);
		rdbtnFemale_1.setEnabled(false);
		txtUpdatePhone.setEnabled(false);
		txtUpdateEmail.setEnabled(false);
		btnLoadImage_1.setEnabled(false);
		txtUpdateLevel.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnDeleteUser.setEnabled(false);

		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return ImageIcon.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				case 7:
					return Integer.class;
				case 8:
					return String.class;
				case 9:
					return String.class;
				default:
					return String.class;
				}
			}
		};

		model.addColumn("U_Id");
		model.addColumn("U_Image");
		model.addColumn("U_Username");
		model.addColumn("U_Password");
		model.addColumn("U_Gender");
		model.addColumn("U_Phone");
		model.addColumn("U_Email");
		model.addColumn("U_Level");
		model.addColumn("Created_At");
		model.addColumn("Update_At");

		User_Dao dao = new User_Dao();
		totalOfRows = dao.countUser();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		lblTotalOfRow.setText("Row count: " + totalOfRows);

		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getU_Id(), new ImageIcon(new ImageIcon(
//						JFrame1.class.getResource(pro.getPicture()) //chạy vào resource
						System.getProperty("user.dir") + i.getU_Image() // lấy img ngoài
				).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getU_Username(), i.getU_Password(),
						i.getU_Gender().equals(true) ? "Male" : "Female", i.getU_Phone(), i.getU_Email(),
						i.getU_Level(), i.getCreated_At().toString(),
						i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
		table.setModel(model);
		table.setRowHeight(60);
	}

	private void loadData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // xóa sạch data
		User_Dao dao = new User_Dao();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getU_Id(), new ImageIcon(new ImageIcon(
//						JFrame1.class.getResource(pro.getPicture()) //chạy vào resource
						System.getProperty("user.dir") + i.getU_Image() // lấy img ngoài
				).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getU_Username(), i.getU_Password(),
						i.getU_Gender().equals(true) ? "Male" : "Female", i.getU_Phone(), i.getU_Email(),
						i.getU_Level(), i.getCreated_At().toString(),
						i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));

		table.setModel(model);
	}

	protected void btnFirstButtonActionPerformed(ActionEvent e) {
		pageNumber = 1;
		txtPage.setText(pageNumber.toString());
		loadData();
	}

	protected void btnPreviusButtonActionPerformed(ActionEvent e) {
		if (pageNumber > 1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			loadData();
		}
	}

	protected void comboBoxActionPerformed(ActionEvent e) {
		if (table != null) {
			pageNumber = 1;
			txtPage.setText(pageNumber.toString());
			rowsOfPage = Integer.parseInt(comboBox.getSelectedItem().toString());
			loadData();
		}
	}

	protected void btnNextButtonActionPerformed(ActionEvent e) {
		if (pageNumber < totalPage.intValue()) {
			pageNumber++;
			txtPage.setText(pageNumber.toString());
			loadData();
		}
	}

	protected void btnLastButtonActionPerformed(ActionEvent e) {
		pageNumber = totalPage.intValue();
		txtPage.setText(pageNumber.toString());
		if (pageNumber != 0) {
			loadData();
		}
	}

	protected void txtPageActionPerformed(ActionEvent e) {
		int page = Integer.parseInt(txtPage.getText());
		if (page >= 1 && page <= totalPage.intValue()) {
			pageNumber = page;
			JOptionPane.showMessageDialog(null, "Successfully");
			loadData();
		} else {
			JOptionPane.showMessageDialog(null, "page must be 1 to " + totalPage.intValue());
			txtPage.setText(pageNumber.toString());
		}
	}

	public static PreparedStatement run(Connection con, int U_Id) throws Exception {
		String str = "select * from [User] where U_Id = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, U_Id);
		return ps;
	}

	protected void btnFindUserActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			int U_Id = Integer.parseInt(txtGetId.getText());

			btnFirstButton.setEnabled(false);
			btnPreviusButton.setEnabled(false);
			btnNextButton.setEnabled(false);
			btnLastButton.setEnabled(false);
			comboBox.setEnabled(false);
			txtPage.setEnabled(false);
			btnDeleteUser.setEnabled(true);
			// update
			txtUpdateUserId.setEnabled(true);
			txtUpdateUsername.setEnabled(true);
			txtUpdatePassword.setEnabled(true);
			rdbtnMale_1.setEnabled(true);
			rdbtnFemale_1.setEnabled(true);
			txtUpdatePhone.setEnabled(true);
			txtUpdateEmail.setEnabled(true);
			btnLoadImage_1.setEnabled(true);
			txtUpdateLevel.setEnabled(true);
			btnNewButton_1.setEnabled(true);

			DefaultTableModel model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column) {
					switch (column) {
					case 0:
						return Integer.class;
					case 1:
						return ImageIcon.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					case 5:
						return String.class;
					case 6:
						return String.class;
					case 7:
						return Integer.class;
					case 8:
						return String.class;
					case 9:
						return String.class;
					default:
						return String.class;
					}
				}
			};

			model.addColumn("U_Id");
			model.addColumn("U_Image");
			model.addColumn("U_Username");
			model.addColumn("U_Password");
			model.addColumn("U_Gender");
			model.addColumn("U_Phone");
			model.addColumn("U_Email");
			model.addColumn("U_Level");
			model.addColumn("Created_At");
			model.addColumn("Update_At");

			User_Dao dao = new User_Dao();
			totalOfRows = dao.countUser();
			totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
			lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
			lblTotalOfRow.setText("Row count: " + totalOfRows);

			dao.getListUserWhenSearch(Integer.parseInt(txtGetId.getText()))
					.forEach(i -> model.addRow(new Object[] { i.getU_Id(), new ImageIcon(new ImageIcon(
//							JFrame1.class.getResource(pro.getPicture()) //chạy vào resource
							System.getProperty("user.dir") + i.getU_Image() // lấy img ngoài
					).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getU_Username(), i.getU_Password(),
							i.getU_Gender().equals(true) ? "Male" : "Female", i.getU_Phone(), i.getU_Email(),
							i.getU_Level(), i.getCreated_At().toString(),
							i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
			table.setModel(model);
			table.setRowHeight(60);
			JOptionPane.showMessageDialog(null, "Find Successfully");

			String connect = "jdbc:sqlserver://BUFALER\\SQLEXPRESS:1433;" + "databaseName=Prisoner_Management_System;"
					+ "user=sa; password=1";
			try (var con = DriverManager.getConnection(connect);
					var ps = run(con, U_Id);
					ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					txtUpdateUserId.setText(txtGetId.getText());
					lblNewLabel_2.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + rs.getString(2)) // ảnh
																														// cũ
							.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
					txtUpdateUsername.setText(rs.getString(3));
					txtUpdatePassword.setText(rs.getString(4));
					if (rs.getString(5).equals("1")) {
						rdbtnMale_1.setSelected(true);
					} else {
						rdbtnFemale_1.setSelected(true);
					}
					txtUpdatePhone.setText(rs.getString(6));
					txtUpdateEmail.setText(rs.getString(7));
					txtUpdateLevel.setSelectedItem(rs.getInt(8));

					// lưu ảnh cũ lại vào biến
					oldImg = System.getProperty("user.dir") + rs.getString(2);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	protected void btnShowAllActionPerformed(ActionEvent e) {
		btnFirstButton.setEnabled(true);
		btnPreviusButton.setEnabled(true);
		btnNextButton.setEnabled(true);
		btnLastButton.setEnabled(true);
		comboBox.setEnabled(true);
		txtPage.setEnabled(true);
		btnDeleteUser.setEnabled(false);
		txtGetId.setText("");
		loadData();
	}

	protected void btnDeleteUserActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			// 0=yes, 1=no, 2=cancel
			int input = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THIS USER ? YOU CANNOT UNDO !!!",
					"Delete", JOptionPane.OK_CANCEL_OPTION);
			if (input == 0) {
				User_Dao user = new User_Dao();
				user.deleteData(Integer.parseInt(txtGetId.getText()));
				JOptionPane.showMessageDialog(null, "Delete Successfully");
				File f1 = new File(oldImg);
				f1.delete();
			}
			loadData();
		}
	}

	public static PreparedStatement runU_Username(Connection con, String U_Username) throws Exception {
		String str = "select * from [User] where U_Username = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setString(1, U_Username);
		return ps;
	}

	public static PreparedStatement runU_Phone(Connection con, String U_Phone) throws Exception {
		String str = "select * from [User] where U_Phone = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setString(1, U_Phone);
		return ps;
	}

	public static PreparedStatement runU_Email(Connection con, String U_Email) throws Exception {
		String str = "select * from [User] where U_Email = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setString(1, U_Email);
		return ps;
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		Boolean flag = true;
		Boolean flag1 = true;
		Boolean flag2 = true;
		Boolean flag3 = true;
		String gender = null;
		if (rdbtnMale.isSelected()) {
			gender = "true";
		}
		if (rdbtnFemale.isSelected()) {
			gender = "false";
		}
		if (!Pattern.compile(RegexConst.USERNAME).matcher(txtUsername.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Username must at least 6 and max 20 characters");
		}
		if (!Pattern.compile(RegexConst.PASSWORD).matcher(String.valueOf(txtPassword.getPassword())).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Password must at least 6 and max 20 characters");
		}
		if (!Pattern.compile(RegexConst.PHONE).matcher(txtPhone.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Phone is incorrect, phone must be ten numbers !!!");
		}
		if (!Pattern.compile(RegexConst.EMAIL).matcher(txtEmail.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Email is incorrect, email example: test1@gmail.com.vn !!!");
		}

		if (flag) {
			String connect = "jdbc:sqlserver://BUFALER\\SQLEXPRESS:1433;" + "databaseName=Prisoner_Management_System;"
					+ "user=sa; password=1";
			try (var con = DriverManager.getConnection(connect);
					var ps = runU_Username(con, txtUsername.getText());
					var ps1 = runU_Phone(con, txtPhone.getText());
					var ps2 = runU_Email(con, txtEmail.getText());
					ResultSet rs = ps.executeQuery();
					ResultSet rs1 = ps1.executeQuery();
					ResultSet rs2 = ps2.executeQuery();) {
				while (rs.next()) {
					if (rs.getString("U_Username").equals(txtUsername.getText())) {
						flag1 = false;
						JOptionPane.showMessageDialog(null, "Username already exists");
					}
				}
				while (rs1.next()) {
					if (rs1.getString("U_Phone").equals(txtPhone.getText())) {
						flag2 = false;
						JOptionPane.showMessageDialog(null, "Phone already exists");
					}
				}
				while (rs2.next()) {
					if (rs2.getString("U_Email").equals(txtEmail.getText())) {
						flag3 = false;
						JOptionPane.showMessageDialog(null, "Email already exists");
					}
				}
				if (flag1 && flag2 && flag3) {
					User_Dao user = new User_Dao();
					int ram = LocalTime.now().getNano();

					// save image = copy
					if (imgPath == null) {
						JOptionPane.showMessageDialog(null, "Image not null !!!");
					} else {
						File f_0 = new File(imgPath); // img gốc
						File f_0_copy = new File(System.getProperty("user.dir") + "\\image\\" + ram
								+ (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim())); // img copy
						try {
							Files.copy(f_0.toPath(), f_0_copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						user.insertData("/image/" + ram + (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim()),
								txtUsername.getText(), String.valueOf(txtPassword.getPassword()), gender,
								txtPhone.getText(), txtEmail.getText(),
								Integer.parseInt(txtLevel.getSelectedItem().toString()));
						JOptionPane.showMessageDialog(null, "Insert Successfully");
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		String gender = null;
		if (rdbtnMale_1.isSelected()) {
			gender = "true";
		}
		if (rdbtnFemale_1.isSelected()) {
			gender = "false";
		}
		User_Dao user = new User_Dao();
		int ram = LocalTime.now().getNano();

		// save image = copy
		File f_0 = new File(imgPath); // img gốc
		File f_0_copy = new File(System.getProperty("user.dir") + "\\image\\" + ram
				+ (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim())); // img copy
		try {
			Files.copy(f_0.toPath(), f_0_copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		user.UpdateData("/image/" + ram + (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim()),
				txtUpdateUsername.getText(), String.valueOf(txtUpdatePassword.getPassword()), gender,
				txtUpdatePhone.getText(), txtUpdateEmail.getText(),
				Integer.parseInt(txtUpdateLevel.getSelectedItem().toString()),
				Integer.parseInt(txtUpdateUserId.getText()));
		JOptionPane.showMessageDialog(null, "Update Successfully");
	}

	protected void btnLoadImageActionPerformed(ActionEvent e) {
		// load ảnh lên label
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("load image");
		chooser.setFileFilter(new FileNameExtensionFilter("image(jpg, png, gif)", "jpg", "png", "gif"));
		chooser.setAcceptAllFileFilterUsed(false); // chặn thuộc tính all file
		int result = chooser.showOpenDialog(null);
		if (result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile(); // lấy 1 file thôi
			lblNewLabel_1.setIcon(new ImageIcon(
					new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH)));
			imgPath = f.getAbsolutePath();
		}
	}

	protected void btnLoadImage_1ActionPerformed(ActionEvent e) {
		// load ảnh lên label
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("load image");
		chooser.setFileFilter(new FileNameExtensionFilter("image(jpg, png, gif)", "jpg", "png", "gif"));
		chooser.setAcceptAllFileFilterUsed(false); // chặn thuộc tính all file
		int result = chooser.showOpenDialog(null);
		if (result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile(); // lấy 1 file thôi
			lblNewLabel_2.setIcon(new ImageIcon(
					new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH)));
			// load ảnh mới lên xong thì xóa ảnh cũ
			File f1 = new File(oldImg);
			f1.delete();
			// lưu path ảnh mới
			imgPath = f.getAbsolutePath();
		}
	}
}
