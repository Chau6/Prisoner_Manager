package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.Supervision_Dao;
import dao.User_Dao;
import helper.RegexConst;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.AncestorEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class Supervisions extends JInternalFrame {
	private JTabbedPane tabbedPane;
	private JPanel Supervision_Index;
	private JScrollPane scrollPane;

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
	private JButton btnFindSupervision;
	private JTextField txtGetId;
	private JButton btnShowAll;
	private JButton btnDeleteSupervision;
	private JPanel Insert;
	private JLabel lblNewLabel;
	private JLabel lblLevel;
	private JLabel lblBirthday;
	private JLabel lblFullname;
	private JLabel lblGender;
	private JTextField txtFullname;
	private JComboBox txtLevel;
	private JButton btnNewButton;
	private JPanel Update;
	private JLabel lblupdateUser;
	private JLabel lblUserId;
	private JTextField txtGetUpdateId;
	private JTable table;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblFullname_1;
	private JLabel lblGender_1;
	private JRadioButton rdbtnMale_1;
	private JRadioButton rdbtnFemale_1;
	private JLabel lblBirthday_1;
	private JLabel lblLevel_1;
	private JComboBox txtUpdateLevel;
	private JButton btnNewButton_1;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnLoadImage;
	private JLabel lblAvatar;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_1;
	private JLabel lblAvatar_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane_2;
	private JLabel lblNewLabel_2;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JTextField txtUpdateFullname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supervisions frame = new Supervisions();
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
	public Supervisions() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setFrameIcon(new ImageIcon(Supervisions.class
				.getResource("/image/icon/473778_business_hierarchy_leadership_management_organization_icon.png")));
		setTitle("Supervison");
		setBounds(100, 100, 1100, 700);
		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1084, 670);
		getContentPane().add(tabbedPane);

		Supervision_Index = new JPanel();
		Supervision_Index.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				Supervision_IndexAncestorAdded(event);
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		Supervision_Index.setLayout(null);
		tabbedPane.addTab("List", new ImageIcon(Supervisions.class.getResource("/image/icon/216422_list_th_icon.png")),
				Supervision_Index, null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1079, 566);
		Supervision_Index.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		lblStatusPage = new JLabel("Page 1 of 0");
		lblStatusPage.setBounds(20, 611, 100, 14);
		Supervision_Index.add(lblStatusPage);

		lblTotalOfRow = new JLabel("Rows count: 0");
		lblTotalOfRow.setBounds(969, 611, 100, 14);
		Supervision_Index.add(lblTotalOfRow);

		btnFirstButton = new JButton("First Button");
		btnFirstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstButtonActionPerformed(e);
			}
		});
		btnFirstButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnFirstButton.setBounds(10, 577, 100, 23);
		Supervision_Index.add(btnFirstButton);

		btnPreviusButton = new JButton("Previus Button");
		btnPreviusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviusButtonActionPerformed(e);
			}
		});
		btnPreviusButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnPreviusButton.setBounds(450, 577, 120, 23);
		Supervision_Index.add(btnPreviusButton);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActionPerformed(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "10", "20", "30" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(230, 578, 100, 21);
		Supervision_Index.add(comboBox);

		btnNextButton = new JButton("Next Button");
		btnNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextButtonActionPerformed(e);
			}
		});
		btnNextButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNextButton.setBounds(340, 577, 100, 23);
		Supervision_Index.add(btnNextButton);

		btnLastButton = new JButton("Last Button");
		btnLastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastButtonActionPerformed(e);
			}
		});
		btnLastButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnLastButton.setBounds(120, 577, 100, 23);
		Supervision_Index.add(btnLastButton);

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
		Supervision_Index.add(txtPage);

		btnFindSupervision = new JButton("Find Supervision");
		btnFindSupervision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFindSupervisionActionPerformed(e);
			}
		});
		btnFindSupervision.setBounds(829, 577, 140, 23);
		Supervision_Index.add(btnFindSupervision);

		txtGetId = new JTextField();
		txtGetId.setColumns(10);
		txtGetId.setBounds(679, 578, 140, 22);
		Supervision_Index.add(txtGetId);

		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowAllActionPerformed(e);
			}
		});
		btnShowAll.setBounds(689, 607, 100, 23);
		Supervision_Index.add(btnShowAll);

		btnDeleteSupervision = new JButton("Delete");
		btnDeleteSupervision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteSupervisionActionPerformed(e);
			}
		});
		btnDeleteSupervision.setBounds(580, 577, 89, 23);
		Supervision_Index.add(btnDeleteSupervision);

		Insert = new JPanel();
		Insert.setLayout(null);
		tabbedPane.addTab("Insert",
				new ImageIcon(Supervisions.class.getResource("/image/icon/216490_add_user_icon.png")), Insert, null);

		lblNewLabel = new JLabel(
				"<html><span color=red style='font-size:60px;'>&#10133;_Insert Supervision_&#10133;</span></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(36, 11, 1000, 216);
		Insert.add(lblNewLabel);

		lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLevel.setBounds(212, 401, 141, 25);
		Insert.add(lblLevel);

		lblBirthday = new JLabel("Birthday:");
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBirthday.setBounds(212, 323, 141, 25);
		Insert.add(lblBirthday);

		lblFullname = new JLabel("Fullname: ");
		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFullname.setBounds(212, 251, 141, 25);
		Insert.add(lblFullname);

		lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(212, 287, 141, 25);
		Insert.add(lblGender);

		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBounds(346, 257, 225, 19);
		Insert.add(txtFullname);

		txtLevel = new JComboBox();
		txtLevel.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		txtLevel.setBounds(346, 408, 225, 19);
		Insert.add(txtLevel);

		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnNewButton.setBounds(506, 591, 128, 34);
		Insert.add(btnNewButton);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(346, 283, 63, 33);
		Insert.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(426, 283, 79, 33);
		Insert.add(rdbtnFemale);

		btnLoadImage = new JButton("Load Image");
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadImageActionPerformed(e);
			}
		});
		btnLoadImage.setBounds(346, 359, 225, 31);
		Insert.add(btnLoadImage);

		lblAvatar = new JLabel("Avatar:");
		lblAvatar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAvatar.setBounds(212, 359, 141, 25);
		Insert.add(lblAvatar);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(636, 230, 400, 350);
		Insert.add(scrollPane_1);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setOpaque(true);
		scrollPane_1.setViewportView(lblNewLabel_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(346, 323, 225, 25);
		Insert.add(dateChooser);

		Update = new JPanel();
		Update.setLayout(null);
		tabbedPane.addTab("Update",
				new ImageIcon(Supervisions.class
						.getResource("/image/icon/7106354_reload_data_infographic_update_element_icon.png")),
				Update, null);

		lblupdateUser = new JLabel(
				"<html><span color=red style='font-size:60px;'>&#10133;_Update Supervision_&#10133;</span></html>");
		lblupdateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblupdateUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblupdateUser.setBounds(0, 0, 1079, 216);
		Update.add(lblupdateUser);

		lblUserId = new JLabel("Id:");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserId.setBounds(216, 246, 141, 25);
		Update.add(lblUserId);

		txtGetUpdateId = new JTextField();
		txtGetUpdateId.setColumns(10);
		txtGetUpdateId.setBounds(350, 252, 225, 19);
		Update.add(txtGetUpdateId);

		lblFullname_1 = new JLabel("Fullname: ");
		lblFullname_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFullname_1.setBounds(216, 318, 141, 25);
		Update.add(lblFullname_1);

		lblGender_1 = new JLabel("Gender:");
		lblGender_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender_1.setBounds(216, 354, 141, 25);
		Update.add(lblGender_1);

		rdbtnMale_1 = new JRadioButton("Male");
		buttonGroup_1.add(rdbtnMale_1);
		rdbtnMale_1.setBounds(350, 350, 63, 33);
		Update.add(rdbtnMale_1);

		rdbtnFemale_1 = new JRadioButton("Female");
		buttonGroup_1.add(rdbtnFemale_1);
		rdbtnFemale_1.setBounds(430, 350, 79, 33);
		Update.add(rdbtnFemale_1);

		lblBirthday_1 = new JLabel("Birthday:");
		lblBirthday_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBirthday_1.setBounds(216, 390, 141, 25);
		Update.add(lblBirthday_1);

		lblLevel_1 = new JLabel("Level:");
		lblLevel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLevel_1.setBounds(216, 426, 141, 25);
		Update.add(lblLevel_1);

		txtUpdateLevel = new JComboBox();
		txtUpdateLevel.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		txtUpdateLevel.setBounds(350, 433, 225, 19);
		Update.add(txtUpdateLevel);

		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(612, 553, 128, 34);
		Update.add(btnNewButton_1);

		lblAvatar_1 = new JLabel("Avatar:");
		lblAvatar_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAvatar_1.setBounds(216, 282, 141, 25);
		Update.add(lblAvatar_1);

		btnNewButton_2 = new JButton("Load Image");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2ActionPerformed(e);
			}
		});
		btnNewButton_2.setBounds(350, 282, 225, 31);
		Update.add(btnNewButton_2);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(612, 192, 400, 350);
		Update.add(scrollPane_2);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		scrollPane_2.setViewportView(lblNewLabel_2);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(350, 390, 225, 25);
		Update.add(dateChooser_1);
		
		txtUpdateFullname = new JTextField();
		txtUpdateFullname.setBounds(350, 323, 225, 20);
		Update.add(txtUpdateFullname);
		txtUpdateFullname.setColumns(10);

	}

	protected void Supervision_IndexAncestorAdded(AncestorEvent event) {
		// when start auto run
		// update
		txtGetUpdateId.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		txtUpdateFullname.setEnabled(false);
		rdbtnMale_1.setEnabled(false);
		rdbtnFemale_1.setEnabled(false);
		dateChooser_1.setEnabled(false);
		txtUpdateLevel.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnDeleteSupervision.setEnabled(false);

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
					return Integer.class;
				case 6:
					return String.class;
				case 7:
					return String.class;
				default:
					return String.class;
				}
			}
		};

		model.addColumn("S_Id");
		model.addColumn("S_Image");
		model.addColumn("S_Name");
		model.addColumn("S_Gender");
		model.addColumn("S_Dob");
		model.addColumn("S_Level");
		model.addColumn("Created_At");
		model.addColumn("Update_At");

		Supervision_Dao dao = new Supervision_Dao();
		totalOfRows = dao.countSupervision();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		lblTotalOfRow.setText("Row count: " + totalOfRows);

		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getS_Id(), new ImageIcon(new ImageIcon(
//			JFrame1.class.getResource(pro.getPicture()) //cha??y va??o resource
						System.getProperty("user.dir") + i.getS_Image() // l????y img ngoa??i
				).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getS_Name(), i.getS_Gender().equals(true) ? "Male" : "Female",
						i.getS_Dob(), i.getS_Level(), i.getCreated_At().toString(), i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
		table.setModel(model);
		table.setRowHeight(60);
	}

	private void loadData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // xo??a sa??ch data
		Supervision_Dao dao = new Supervision_Dao();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getS_Id(), new ImageIcon(new ImageIcon(
//			JFrame1.class.getResource(pro.getPicture()) //cha??y va??o resource
						System.getProperty("user.dir") + i.getS_Image() // l????y img ngoa??i
				).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getS_Name(), i.getS_Gender().equals(true) ? "Male" : "Female",
						i.getS_Dob(), i.getS_Level(), i.getCreated_At().toString(), i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));

		table.setModel(model);
	}

	protected void btnFirstButtonActionPerformed(ActionEvent e) {
		pageNumber = 1;
		txtPage.setText(pageNumber.toString());
		loadData();
	}

	protected void btnLastButtonActionPerformed(ActionEvent e) {
		pageNumber = totalPage.intValue();
		txtPage.setText(pageNumber.toString());
		if (pageNumber != 0) {
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

	protected void btnPreviusButtonActionPerformed(ActionEvent e) {
		if (pageNumber > 1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			loadData();
		}
	}

	protected void btnDeleteSupervisionActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			// 0=yes, 1=no, 2=cancel
			int input = JOptionPane.showConfirmDialog(null,
					"ARE YOU SURE TO DELETE THIS SUPERVISIONOR ? YOU CANNOT UNDO !!!", "Delete",
					JOptionPane.OK_CANCEL_OPTION);
			if (input == 0) {
				Supervision_Dao sup = new Supervision_Dao();
				sup.deleteData(Integer.parseInt(txtGetId.getText()));
				JOptionPane.showMessageDialog(null, "Delete Successfully");
				File f1 = new File(oldImg);
				f1.delete();
			}
			loadData();
		}
	}

	public static PreparedStatement run(Connection con, int S_Id) throws Exception {
		String str = "select * from Supervision_Info where S_Id = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, S_Id);
		return ps;
	}

	protected void btnFindSupervisionActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			int S_Id = Integer.parseInt(txtGetId.getText());
			// list
			btnFirstButton.setEnabled(false);
			btnPreviusButton.setEnabled(false);
			btnNextButton.setEnabled(false);
			btnLastButton.setEnabled(false);
			comboBox.setEnabled(false);
			txtPage.setEnabled(false);
			btnDeleteSupervision.setEnabled(true);
			// update
			txtGetUpdateId.setEnabled(true);
			btnNewButton_2.setEnabled(true);
			txtUpdateFullname.setEnabled(true);
			rdbtnMale_1.setEnabled(true);
			rdbtnFemale_1.setEnabled(true);
			dateChooser_1.setEnabled(true);
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
						return Integer.class;
					case 6:
						return String.class;
					case 7:
						return String.class;
					default:
						return String.class;
					}
				}
			};

			model.addColumn("S_Id");
			model.addColumn("S_Image");
			model.addColumn("S_Name");
			model.addColumn("S_Gender");
			model.addColumn("S_Dob");
			model.addColumn("S_Level");
			model.addColumn("Created_At");
			model.addColumn("Update_At");

			Supervision_Dao dao = new Supervision_Dao();
			totalOfRows = dao.countSupervision();
			totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
			lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
			lblTotalOfRow.setText("Row count: " + totalOfRows);

			dao.getListSupervisionWhenSearch(Integer.parseInt(txtGetId.getText()))
					.forEach(i -> model.addRow(new Object[] { i.getS_Id(), new ImageIcon(new ImageIcon(
//							JFrame1.class.getResource(pro.getPicture()) //cha??y va??o resource
							System.getProperty("user.dir") + i.getS_Image() // l????y img ngoa??i
					).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getS_Name(), i.getS_Gender().equals(true) ? "Male" : "Female",
							i.getS_Dob(), i.getS_Level(), i.getCreated_At().toString(), i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
			table.setModel(model);
			table.setRowHeight(60);
			JOptionPane.showMessageDialog(null, "Find Successfully");

			String connect = "jdbc:sqlserver://BUFALER\\SQLEXPRESS:1433;" + "databaseName=Prisoner_Management_System;"
					+ "user=sa; password=1";
			try (var con = DriverManager.getConnection(connect);
					var ps = run(con, S_Id);
					ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					txtGetUpdateId.setText(txtGetId.getText());
					lblNewLabel_2.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + rs.getString(2)) // a??nh
																														// cu??
							.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
					txtUpdateFullname.setText(rs.getString(3));
					if (rs.getString(4).equals("1")) {
						rdbtnMale_1.setSelected(true);
					} else {
						rdbtnFemale_1.setSelected(true);
					}
					dateChooser_1.setDate(Date.valueOf(rs.getString(5)));
					txtUpdateLevel.setSelectedItem(rs.getInt(6));

					// l??u a??nh cu?? la??i va??o bi????n
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
		btnDeleteSupervision.setEnabled(false);
		txtGetId.setText("");
		loadData();
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

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		Boolean flag = true;
		String gender = null;
		if (rdbtnMale.isSelected()) {
			gender = "true";
		}
		if (rdbtnFemale.isSelected()) {
			gender = "false";
		}

		if (!Pattern.compile(RegexConst.FULLNAME).matcher(txtFullname.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Fullname must at least 1 and max 50 characters");
		}
		if(dateChooser.getDate()==null) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Birthday incorrect !!! [yyyy-mm-dd | yyyy/mm/dd]");
		}
		if (flag) {
			Supervision_Dao sup = new Supervision_Dao();
			int ram = LocalTime.now().getNano();

			// save image = copy
			if (imgPath == null) {
				JOptionPane.showMessageDialog(null, "Image not null !!!");
			} else {
				File f_0 = new File(imgPath); // img g????c
				File f_0_copy = new File(System.getProperty("user.dir") + "\\image\\" + ram
						+ (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim())); // img copy
				try {
					Files.copy(f_0.toPath(), f_0_copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
				String date = dcn.format(dateChooser.getDate());
				sup.insertData("/image/" + ram + (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim()),
						txtFullname.getText(), gender, date,
						Integer.parseInt(txtLevel.getSelectedItem().toString()));
				JOptionPane.showMessageDialog(null, "Insert Successfully");
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
		Supervision_Dao sup = new Supervision_Dao();
		int ram = LocalTime.now().getNano();

		// save image = copy
		File f_0 = new File(imgPath); // img g????c
		File f_0_copy = new File(System.getProperty("user.dir") + "\\image\\" + ram
				+ (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim())); // img copy
		try {
			Files.copy(f_0.toPath(), f_0_copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
		String date = dcn.format(dateChooser_1.getDate());
		sup.UpdateData("/image/" + ram + (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim()),
				txtUpdateFullname.getText(), gender, date,
				Integer.parseInt(txtUpdateLevel.getSelectedItem().toString()),
				Integer.parseInt(txtGetUpdateId.getText()));
		JOptionPane.showMessageDialog(null, "Update Successfully");
	}

	protected void btnLoadImageActionPerformed(ActionEvent e) {
		// load a??nh l??n label
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("load image");
		chooser.setFileFilter(new FileNameExtensionFilter("image(jpg, png, gif)", "jpg", "png", "gif"));
		chooser.setAcceptAllFileFilterUsed(false); // ch????n thu????c ti??nh all file
		int result = chooser.showOpenDialog(null);
		if (result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile(); // l????y 1 file th??i
			lblNewLabel_1.setIcon(new ImageIcon(
					new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH)));
			imgPath = f.getAbsolutePath();
		}
	}

	protected void btnNewButton_2ActionPerformed(ActionEvent e) {
		// load a??nh l??n label
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("load image");
		chooser.setFileFilter(new FileNameExtensionFilter("image(jpg, png, gif)", "jpg", "png", "gif"));
		chooser.setAcceptAllFileFilterUsed(false); // ch????n thu????c ti??nh all file
		int result = chooser.showOpenDialog(null);
		if (result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile(); // l????y 1 file th??i
			lblNewLabel_2.setIcon(new ImageIcon(
					new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH)));
			// load a??nh m????i l??n xong thi?? xo??a a??nh cu??
			File f1 = new File(oldImg);
			f1.delete();
			// l??u path a??nh m????i
			imgPath = f.getAbsolutePath();
		}
	}
}
