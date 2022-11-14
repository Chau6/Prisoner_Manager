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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import dao.Prisoner_Dao;
import helper.RegexConst;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class Prisoners extends JInternalFrame {
	private JTabbedPane tabbedPane;
	private JPanel Prisoner_Index;
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
	private JButton btnFindPrisoner;
	private JTextField txtGetId;
	private JButton btnShowAll;
	private JButton btnDelete;
	private JPanel Insert;
	private JLabel lblinsertPrisoner;
	private JLabel lblLevel;
	private JLabel lblBirthday;
	private JLabel lblFullname;
	private JLabel lblGender;
	private JTextField txtFullname;
	private JComboBox txtLevel;
	private JButton btnNewButton;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JPanel Update;
	private JLabel lblupdatePrisoner;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblAvatar;
	private JLabel lblAdmit;
	private JLabel lblRelease;
	private JLabel lblCrimes;
	private JTextArea txtCrime;
	private JLabel lblLevel_1;
	private JLabel lblBirthday_1;
	private JLabel lblFullname_1;
	private JLabel lblGender_1;
	private JTextField txtUpdateFullname;
	private JComboBox txtUpdateLevel;
	private JButton btnNewButton_1;
	private JRadioButton rdbtnMale_1;
	private JRadioButton rdbtnFemale_1;
	private JLabel lblId_1;
	private JTextField txtUpdateId;
	private JLabel lblAvatar_1;
	private JLabel lblAdmit_1;
	private JLabel lblRelease_1;
	private JLabel lblCrimes_1;
	private JTextArea txtUpdateCrime;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnNewButton_2;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel;
	private JButton btnNewButton_3;
	private JScrollPane scrollPane_2;
	private JLabel lblNewLabel_1;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JDateChooser dateChooser_2;
	private JDateChooser dateChooser_3;
	private JDateChooser dateChooser_4;
	private JDateChooser dateChooser_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prisoners frame = new Prisoners();
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
	public Prisoners() {
		setMaximizable(true);
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setFrameIcon(new ImageIcon(Prisoners.class.getResource("/image/icon/379420_prisoner_icon.png")));
		setTitle("Prisoner");
		setBounds(100, 100, 1100, 700);
		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1084, 670);
		getContentPane().add(tabbedPane);

		Prisoner_Index = new JPanel();
		Prisoner_Index.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				Prisoner_IndexAncestorAdded(event);
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		Prisoner_Index.setLayout(null);
		tabbedPane.addTab("List", new ImageIcon(Prisoners.class.getResource("/image/icon/216422_list_th_icon.png")),
				Prisoner_Index, null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1079, 566);
		Prisoner_Index.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		lblStatusPage = new JLabel("Page 1 of 0");
		lblStatusPage.setBounds(20, 611, 100, 14);
		Prisoner_Index.add(lblStatusPage);

		lblTotalOfRow = new JLabel("Rows count: 0");
		lblTotalOfRow.setBounds(969, 611, 100, 14);
		Prisoner_Index.add(lblTotalOfRow);

		btnFirstButton = new JButton("First Button");
		btnFirstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstButtonActionPerformed(e);
			}
		});
		btnFirstButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnFirstButton.setBounds(10, 577, 100, 23);
		Prisoner_Index.add(btnFirstButton);

		btnPreviusButton = new JButton("Previus Button");
		btnPreviusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviusButtonActionPerformed(e);
			}
		});
		btnPreviusButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnPreviusButton.setBounds(450, 577, 120, 23);
		Prisoner_Index.add(btnPreviusButton);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActionPerformed(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "10", "20", "30" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(230, 578, 100, 21);
		Prisoner_Index.add(comboBox);

		btnNextButton = new JButton("Next Button");
		btnNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextButtonActionPerformed(e);
			}
		});
		btnNextButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNextButton.setBounds(340, 577, 100, 23);
		Prisoner_Index.add(btnNextButton);

		btnLastButton = new JButton("Last Button");
		btnLastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastButtonActionPerformed(e);
			}
		});
		btnLastButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnLastButton.setBounds(120, 577, 100, 23);
		Prisoner_Index.add(btnLastButton);

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
		Prisoner_Index.add(txtPage);

		btnFindPrisoner = new JButton("Find Prisoner");
		btnFindPrisoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFindPrisonerActionPerformed(e);
			}
		});
		btnFindPrisoner.setBounds(829, 577, 140, 23);
		Prisoner_Index.add(btnFindPrisoner);

		txtGetId = new JTextField();
		txtGetId.setColumns(10);
		txtGetId.setBounds(679, 578, 140, 22);
		Prisoner_Index.add(txtGetId);

		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowAllActionPerformed(e);
			}
		});
		btnShowAll.setBounds(689, 607, 100, 23);
		Prisoner_Index.add(btnShowAll);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteSupervisionActionPerformed(e);
			}
		});
		btnDelete.setBounds(580, 577, 89, 23);
		Prisoner_Index.add(btnDelete);

		Insert = new JPanel();
		Insert.setLayout(null);
		tabbedPane.addTab("Insert", new ImageIcon(Prisoners.class.getResource("/image/icon/216490_add_user_icon.png")),
				Insert, null);

		lblinsertPrisoner = new JLabel(
				"<html><span color=red style='font-size:60px;'>&#10133;_Insert Prisoner_&#10133;</span></html>");
		lblinsertPrisoner.setHorizontalAlignment(SwingConstants.CENTER);
		lblinsertPrisoner.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblinsertPrisoner.setBounds(36, 11, 1000, 216);
		Insert.add(lblinsertPrisoner);

		lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLevel.setBounds(212, 530, 141, 25);
		Insert.add(lblLevel);

		lblBirthday = new JLabel("Birthday:");
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBirthday.setBounds(212, 359, 141, 25);
		Insert.add(lblBirthday);

		lblFullname = new JLabel("Fullname: ");
		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFullname.setBounds(212, 287, 141, 25);
		Insert.add(lblFullname);

		lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(212, 323, 141, 25);
		Insert.add(lblGender);

		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBounds(346, 293, 225, 19);
		Insert.add(txtFullname);

		txtLevel = new JComboBox();
		txtLevel.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		txtLevel.setBounds(346, 537, 225, 19);
		Insert.add(txtLevel);

		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnNewButtonActionPerformed(e);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(581, 591, 128, 34);
		Insert.add(btnNewButton);

		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(346, 319, 63, 33);
		Insert.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(426, 319, 79, 33);
		Insert.add(rdbtnFemale);

		lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblId.setBounds(212, 215, 141, 25);
		Insert.add(lblId);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(346, 221, 225, 19);
		Insert.add(txtId);

		lblAvatar = new JLabel("Avatar:");
		lblAvatar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAvatar.setBounds(212, 251, 141, 25);
		Insert.add(lblAvatar);

		lblAdmit = new JLabel("Admit:");
		lblAdmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmit.setBounds(212, 395, 141, 25);
		Insert.add(lblAdmit);

		lblRelease = new JLabel("Release:");
		lblRelease.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRelease.setBounds(212, 431, 141, 25);
		Insert.add(lblRelease);

		lblCrimes = new JLabel("Crimes:");
		lblCrimes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCrimes.setBounds(212, 467, 141, 25);
		Insert.add(lblCrimes);

		txtCrime = new JTextArea();
		txtCrime.setLineWrap(true);
		txtCrime.setBounds(346, 470, 225, 49);
		Insert.add(txtCrime);

		btnNewButton_2 = new JButton("Load Image");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnNewButton_2ActionPerformed(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(346, 251, 225, 31);
		Insert.add(btnNewButton_2);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(635, 215, 400, 350);
		Insert.add(scrollPane_1);

		lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		scrollPane_1.setViewportView(lblNewLabel);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(346, 364, 225, 20);
		Insert.add(dateChooser);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(346, 400, 225, 20);
		Insert.add(dateChooser_1);

		dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(346, 436, 225, 20);
		Insert.add(dateChooser_2);

		Update = new JPanel();
		Update.setLayout(null);
		tabbedPane.addTab("Update",
				new ImageIcon(Prisoners.class
						.getResource("/image/icon/7106354_reload_data_infographic_update_element_icon.png")),
				Update, null);

		lblupdatePrisoner = new JLabel(
				"<html><span color=red style='font-size:60px;'>&#10133;_Update Prisoner_&#10133;</span></html>");
		lblupdatePrisoner.setHorizontalAlignment(SwingConstants.CENTER);
		lblupdatePrisoner.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblupdatePrisoner.setBounds(0, 0, 1079, 216);
		Update.add(lblupdatePrisoner);

		lblLevel_1 = new JLabel("Level:");
		lblLevel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLevel_1.setBounds(279, 530, 141, 25);
		Update.add(lblLevel_1);

		lblBirthday_1 = new JLabel("Birthday:");
		lblBirthday_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBirthday_1.setBounds(279, 359, 141, 25);
		Update.add(lblBirthday_1);

		lblFullname_1 = new JLabel("Fullname: ");
		lblFullname_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFullname_1.setBounds(279, 287, 141, 25);
		Update.add(lblFullname_1);

		lblGender_1 = new JLabel("Gender:");
		lblGender_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender_1.setBounds(279, 323, 141, 25);
		Update.add(lblGender_1);

		txtUpdateFullname = new JTextField();
		txtUpdateFullname.setColumns(10);
		txtUpdateFullname.setBounds(413, 293, 225, 19);
		Update.add(txtUpdateFullname);

		txtUpdateLevel = new JComboBox();
		txtUpdateLevel.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		txtUpdateLevel.setBounds(413, 537, 225, 19);
		Update.add(txtUpdateLevel);

		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(648, 591, 128, 34);
		Update.add(btnNewButton_1);

		rdbtnMale_1 = new JRadioButton("Male");
		buttonGroup_1.add(rdbtnMale_1);
		rdbtnMale_1.setSelected(true);
		rdbtnMale_1.setBounds(413, 319, 63, 33);
		Update.add(rdbtnMale_1);

		rdbtnFemale_1 = new JRadioButton("Female");
		buttonGroup_1.add(rdbtnFemale_1);
		rdbtnFemale_1.setBounds(493, 319, 79, 33);
		Update.add(rdbtnFemale_1);

		lblId_1 = new JLabel("Id:");
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblId_1.setBounds(279, 215, 141, 25);
		Update.add(lblId_1);

		txtUpdateId = new JTextField();
		txtUpdateId.setColumns(10);
		txtUpdateId.setBounds(413, 221, 225, 19);
		Update.add(txtUpdateId);

		lblAvatar_1 = new JLabel("Avatar:");
		lblAvatar_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAvatar_1.setBounds(279, 251, 141, 25);
		Update.add(lblAvatar_1);

		lblAdmit_1 = new JLabel("Admit:");
		lblAdmit_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmit_1.setBounds(279, 395, 141, 25);
		Update.add(lblAdmit_1);

		lblRelease_1 = new JLabel("Release:");
		lblRelease_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRelease_1.setBounds(279, 431, 141, 25);
		Update.add(lblRelease_1);

		lblCrimes_1 = new JLabel("Crimes:");
		lblCrimes_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCrimes_1.setBounds(279, 467, 141, 25);
		Update.add(lblCrimes_1);

		txtUpdateCrime = new JTextArea();
		txtUpdateCrime.setLineWrap(true);
		txtUpdateCrime.setBounds(413, 470, 225, 49);
		Update.add(txtUpdateCrime);

		btnNewButton_3 = new JButton("Load Image");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_3ActionPerformed(e);
			}
		});
		btnNewButton_3.setBounds(413, 251, 225, 31);
		Update.add(btnNewButton_3);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(657, 215, 400, 350);
		Update.add(scrollPane_2);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		scrollPane_2.setViewportView(lblNewLabel_1);

		dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(413, 364, 225, 20);
		Update.add(dateChooser_3);

		dateChooser_4 = new JDateChooser();
		dateChooser_4.setBounds(413, 400, 225, 20);
		Update.add(dateChooser_4);

		dateChooser_5 = new JDateChooser();
		dateChooser_5.setBounds(413, 436, 225, 20);
		Update.add(dateChooser_5);

	}

	protected void Prisoner_IndexAncestorAdded(AncestorEvent event) {
		// when start auto run
		// update
		txtUpdateId.setEnabled(false);
		btnNewButton_3.setEnabled(false);
		txtUpdateFullname.setEnabled(false);
		rdbtnMale_1.setEnabled(false);
		rdbtnFemale_1.setEnabled(false);
		dateChooser_3.setEnabled(false);
		dateChooser_4.setEnabled(false);
		dateChooser_5.setEnabled(false);
		txtUpdateCrime.setEnabled(false);
		txtUpdateLevel.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnDelete.setEnabled(false);

		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) { //set kiểu dữ liệu của từng field
				switch (column) { //Int - String - imageIcon
				case 0:
					return Integer.class; //id
				case 1:
					return ImageIcon.class; //image
				case 2:
					return String.class; //P_Name
				case 3:
					return String.class;//P_Gender
				case 4:
					return String.class;//P_Dob
				case 5:
					return String.class;//P_Admit
				case 6:
					return String.class;//P_Release
				case 7:
					return String.class;//P_Crime
				case 8:
					return Integer.class;//P_Security_Level
				case 9:
					return String.class;//Created_At
				case 10:
					return String.class;//Update_At
				default:
					return String.class;
				}
			}
		};

		model.addColumn("P_Id"); //set tên field
		model.addColumn("P_Image");
		model.addColumn("P_Name");
		model.addColumn("P_Gender");
		model.addColumn("P_Dob");
		model.addColumn("P_Admit");
		model.addColumn("P_Release");
		model.addColumn("P_Crime");
		model.addColumn("P_Security_Level");
		model.addColumn("Created_At");
		model.addColumn("Update_At");

		Prisoner_Dao dao = new Prisoner_Dao();
		totalOfRows = dao.countUser();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		lblTotalOfRow.setText("Row count: " + totalOfRows);

		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getP_Id(), new ImageIcon(new ImageIcon(
//						JFrame1.class.getResource(pro.getPicture()) //chạy vào resource
						System.getProperty("user.dir") + i.getP_Image() // lấy img ngoài
				).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getP_Name(),
						i.getP_Gender().equals(true) ? "Male" : "Female", i.getP_Dob(), i.getP_Admit(),
						i.getP_Release(), i.getP_Crime(), i.getP_Security_Level(), i.getCreated_At().toString(),
						i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
		table.setModel(model); //thực thi
		table.setRowHeight(60);
	}

	private void loadData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // xóa sạch data
		Prisoner_Dao dao = new Prisoner_Dao();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getP_Id(), new ImageIcon(new ImageIcon(
//						JFrame1.class.getResource(pro.getPicture()) //chạy vào resource
						System.getProperty("user.dir") + i.getP_Image() // lấy img ngoài
				).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getP_Name(),
						i.getP_Gender().equals(true) ? "Male" : "Female", i.getP_Dob(), i.getP_Admit(),
						i.getP_Release(), i.getP_Crime(), i.getP_Security_Level(), i.getCreated_At().toString(),
						i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));

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
					"ARE YOU SURE TO DELETE THIS PRISONER ? YOU CANNOT UNDO !!!", "Delete",
					JOptionPane.OK_CANCEL_OPTION);
			if (input == 0) {
				Prisoner_Dao pri = new Prisoner_Dao();
				pri.deleteData(Integer.parseInt(txtGetId.getText()));
				JOptionPane.showMessageDialog(null, "Delete Successfully");
				File f1 = new File(oldImg);
				f1.delete();
			}
			loadData();
		}
	}

	public static PreparedStatement run(Connection con, int P_Id) throws Exception {
		String str = "select * from Prisoner_Info where P_Id = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, P_Id);
		return ps;
	}

	protected void btnFindPrisonerActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			int P_Id = Integer.parseInt(txtGetId.getText());
			// list
			btnFirstButton.setEnabled(false);
			btnPreviusButton.setEnabled(false);
			btnNextButton.setEnabled(false);
			btnLastButton.setEnabled(false);
			comboBox.setEnabled(false);
			txtPage.setEnabled(false);
			btnDelete.setEnabled(true);
			// update
			txtUpdateId.setEnabled(true);
			btnNewButton_3.setEnabled(true);
			txtUpdateFullname.setEnabled(true);
			rdbtnMale_1.setEnabled(true);
			rdbtnFemale_1.setEnabled(true);
			dateChooser_3.setEnabled(true);
			dateChooser_4.setEnabled(true);
			dateChooser_5.setEnabled(true);
			txtUpdateCrime.setEnabled(true);
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
						return String.class;
					case 8:
						return Integer.class;
					case 9:
						return String.class;
					case 10:
						return String.class;
					default:
						return String.class;
					}
				}
			};

			model.addColumn("P_Id");
			model.addColumn("P_Image");
			model.addColumn("P_Name");
			model.addColumn("P_Gender");
			model.addColumn("P_Dob");
			model.addColumn("P_Admit");
			model.addColumn("P_Release");
			model.addColumn("P_Crime");
			model.addColumn("P_Security_Level");
			model.addColumn("Created_At");
			model.addColumn("Update_At");

			Prisoner_Dao dao = new Prisoner_Dao();
			totalOfRows = dao.countUser();
			totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
			lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
			lblTotalOfRow.setText("Row count: " + totalOfRows);
			dao.getListPrisonerWhenSearch(Integer.parseInt(txtGetId.getText()))
					.forEach(i -> model.addRow(new Object[] { i.getP_Id(), new ImageIcon(new ImageIcon(
//							JFrame1.class.getResource(pro.getPicture()) //chạy vào resource
							System.getProperty("user.dir") + i.getP_Image() // lấy img ngoài
					).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getP_Name(),
							i.getP_Gender().equals(true) ? "Male" : "Female", i.getP_Dob(), i.getP_Admit(),
							i.getP_Release(), i.getP_Crime(), i.getP_Security_Level(), i.getCreated_At().toString(),
							i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
			table.setModel(model);
			table.setRowHeight(60);
			JOptionPane.showMessageDialog(null, "Find Successfully");

			String connect = "jdbc:sqlserver://BUFALER\\SQLEXPRESS:1433;" + "databaseName=Prisoner_Management_System;"
					+ "user=sa; password=1";
			try (var con = DriverManager.getConnection(connect);
					var ps = run(con, P_Id);
					ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					txtUpdateId.setText(txtGetId.getText());
					lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + rs.getString(2)) // ảnh
																														// cũ
							.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
					txtUpdateFullname.setText(rs.getString(3));
					if (rs.getString(4).equals("1")) {
						rdbtnMale_1.setSelected(true);
					} else {
						rdbtnFemale_1.setSelected(true);
					}
					dateChooser_3.setDate(Date.valueOf(rs.getString(5)));
					dateChooser_4.setDate(Date.valueOf(rs.getString(6)));
					dateChooser_5.setDate(Date.valueOf(rs.getString(7)));
					txtUpdateCrime.setText(rs.getString(8));
					txtUpdateLevel.setSelectedItem(rs.getInt(9));

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
		txtGetId.setText("");
		btnDelete.setEnabled(false);
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

	public static PreparedStatement runP_Id(Connection con, int P_Id) throws Exception {
		String str = "select * from Prisoner_Info where P_Id = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, P_Id);
		return ps;
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) throws NumberFormatException, Exception {
		Boolean flag = true;
		Boolean flag1 = true;
		String gender = null;
		if (rdbtnMale.isSelected()) {
			gender = "true";
		}
		if (rdbtnFemale.isSelected()) {
			gender = "false";
		}
		if (!Pattern.compile(RegexConst.ID).matcher(txtId.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "ID must at least 4 characters");
		}
		if (!Pattern.compile(RegexConst.FULLNAME).matcher(txtFullname.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Fullname must at least 1 and max 50 characters");
		}
		if(dateChooser.getDate()==null) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Birthday incorrect !!! [yyyy-mm-dd | yyyy/mm/dd]");
		}
		if(dateChooser_1.getDate()==null) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Admit incorrect !!! [yyyy-mm-dd | yyyy/mm/dd]");
		}
		if(dateChooser_2.getDate()==null) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Release incorrect !!! [yyyy-mm-dd | yyyy/mm/dd]");
		}
		if (flag) {
			String connect = "jdbc:sqlserver://BUFALER\\SQLEXPRESS:1433;" + "databaseName=Prisoner_Management_System;"
					+ "user=sa; password=1";
			try (var con = DriverManager.getConnection(connect);
					var ps = runP_Id(con, Integer.parseInt(txtId.getText()));
					ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					if (String.valueOf(rs.getInt("P_Id")).equals(txtId.getText())) {
						flag1 = false;
						JOptionPane.showMessageDialog(null, "ID already exists");
					}
				}
				if (flag1) {
					Prisoner_Dao pri = new Prisoner_Dao();
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
						SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
						String date = dcn.format(dateChooser.getDate());
						String date1 = dcn.format(dateChooser_1.getDate());
						String date2 = dcn.format(dateChooser_2.getDate());
						pri.insertData(Integer.parseInt(txtId.getText()),
								"/image/" + ram + (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim()),
								txtFullname.getText(), gender, date, date1, date2, txtCrime.getText(),
								Integer.parseInt(txtLevel.getSelectedItem().toString()));
						JOptionPane.showMessageDialog(null, "Insert Successfully");
//					Prisoners.copyAll(f_0, f_0_copy);
					}
				}
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
		Prisoner_Dao pri = new Prisoner_Dao();
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
		SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
		String date3 = dcn.format(dateChooser_3.getDate());
		String date4 = dcn.format(dateChooser_4.getDate());
		String date5 = dcn.format(dateChooser_5.getDate());
		pri.UpdateData("/image/" + ram + (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim()),
				txtUpdateFullname.getText(), gender, date3, date4, date5, txtUpdateCrime.getText(),
				Integer.parseInt(txtUpdateLevel.getSelectedItem().toString()), Integer.parseInt(txtUpdateId.getText()));
		JOptionPane.showMessageDialog(null, "Update Successfully");
	}

//	public static void copyAll(File f1, File f2) { //use for copy all folder
//		try {
//			// Copy ban than no
//			Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(f1.isDirectory()){
//			// Copy cac tap tin va thu muc con
//			File[] mangCon = f1.listFiles();
//			for (File file : mangCon) {
//				File file_new = new File(f2.getAbsoluteFile()+"/"+file.getName());
//				copyAll(file, file_new);
//			}
//		}
//	}
	protected void btnNewButton_2ActionPerformed(ActionEvent e) throws IOException {
		// load ảnh lên label
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("load image");
		chooser.setFileFilter(new FileNameExtensionFilter("image(jpg, png, gif)", "jpg", "png", "gif"));
		chooser.setAcceptAllFileFilterUsed(false); // chặn thuộc tính all file
		int result = chooser.showOpenDialog(null);
		if (result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile(); // lấy 1 file thôi
			lblNewLabel.setIcon(new ImageIcon(
					new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH)));
			imgPath = f.getAbsolutePath();
		}
	}

	protected void btnNewButton_3ActionPerformed(ActionEvent e) {
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
			// load ảnh mới lên xong thì xóa ảnh cũ
			File f1 = new File(oldImg);
			f1.delete();
			// lưu path ảnh mới
			imgPath = f.getAbsolutePath();
		}
	}
}
