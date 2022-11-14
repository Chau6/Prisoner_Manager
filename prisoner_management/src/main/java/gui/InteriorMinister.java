package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
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
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
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
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import dao.InteriorMinister_Dao;
import dao.Supervision_Dao;
import helper.RegexConst;

import javax.swing.event.AncestorEvent;
import com.toedter.calendar.JDateChooser;

public class InteriorMinister extends JInternalFrame {
	Integer pageNumber = 1;
	Integer rowsOfPage = 10;
	Integer totalOfRows = 0;
	Double totalPage = 0.0;
	String imgPath = null;
	String oldImg = null;
	private JTabbedPane tabbedPane;
	private JPanel InteriorMinister_Index;
	private JScrollPane scrollPane;
	private JLabel lblStatusPage;
	private JLabel lblTotalOfRow;
	private JButton btnFirstButton;
	private JButton btnPreviusButton;
	private JComboBox comboBox;
	private JButton btnNextButton;
	private JButton btnLastButton;
	private JTextField txtPage;
	private JButton btnFind;
	private JTextField txtGetId;
	private JButton btnShowAll;
	private JButton btnDelete;
	private JPanel Insert;
	private JLabel lblNewLabel;
	private JLabel lblBirthday;
	private JLabel lblFullname;
	private JLabel lblGender;
	private JTextField txtFullname;
	private JButton btnNewButton;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JButton btnLoadImage;
	private JLabel lblAvatar;
	private JScrollPane scrollPane_1;
	private JPanel Update;
	private JLabel lblupdateUser;
	private JLabel lblUserId;
	private JTextField txtUpdateId;
	private JLabel lblFullname_1;
	private JTextField txtUpdateFullname;
	private JLabel lblGender_1;
	private JRadioButton rdbtnMale_1;
	private JRadioButton rdbtnFemale_1;
	private JLabel lblBirthday_1;
	private JButton btnNewButton_1;
	private JLabel lblAvatar_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane_2;
	private JLabel lblNewLabel_1;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InteriorMinister frame = new InteriorMinister();
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
	public InteriorMinister() {
		setIconifiable(true);
		setFrameIcon(new ImageIcon(InteriorMinister.class.getResource("/image/icon/4715005_avatar_guard_people_person_profile_icon.png")));
		setClosable(true);
		setMaximizable(true);
		setTitle("Interior Minister");
		setBounds(100, 100, 1100, 700);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1084, 670);
		getContentPane().add(tabbedPane);
		
		InteriorMinister_Index = new JPanel();
		InteriorMinister_Index.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				InteriorMinister_IndexAncestorAdded(event);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		InteriorMinister_Index.setLayout(null);
		tabbedPane.addTab("List", new ImageIcon(InteriorMinister.class.getResource("/image/icon/216422_list_th_icon.png")), InteriorMinister_Index, null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1079, 566);
		InteriorMinister_Index.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblStatusPage = new JLabel("Page 1 of 0");
		lblStatusPage.setBounds(20, 611, 100, 14);
		InteriorMinister_Index.add(lblStatusPage);
		
		lblTotalOfRow = new JLabel("Rows count: 0");
		lblTotalOfRow.setBounds(969, 611, 100, 14);
		InteriorMinister_Index.add(lblTotalOfRow);
		
		btnFirstButton = new JButton("First Button");
		btnFirstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstButtonActionPerformed(e);
			}
		});
		btnFirstButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnFirstButton.setBounds(10, 577, 100, 23);
		InteriorMinister_Index.add(btnFirstButton);
		
		btnPreviusButton = new JButton("Previus Button");
		btnPreviusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviusButtonActionPerformed(e);
			}
		});
		btnPreviusButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnPreviusButton.setBounds(450, 577, 120, 23);
		InteriorMinister_Index.add(btnPreviusButton);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActionPerformed(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(230, 578, 100, 21);
		InteriorMinister_Index.add(comboBox);
		
		btnNextButton = new JButton("Next Button");
		btnNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextButtonActionPerformed(e);
			}
		});
		btnNextButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNextButton.setBounds(340, 577, 100, 23);
		InteriorMinister_Index.add(btnNextButton);
		
		btnLastButton = new JButton("Last Button");
		btnLastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastButtonActionPerformed(e);
			}
		});
		btnLastButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnLastButton.setBounds(120, 577, 100, 23);
		InteriorMinister_Index.add(btnLastButton);
		
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
		InteriorMinister_Index.add(txtPage);
		
		btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFindActionPerformed(e);
			}
		});
		btnFind.setBounds(829, 577, 140, 23);
		InteriorMinister_Index.add(btnFind);
		
		txtGetId = new JTextField();
		txtGetId.setColumns(10);
		txtGetId.setBounds(679, 578, 140, 22);
		InteriorMinister_Index.add(txtGetId);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowAllActionPerformed(e);
			}
		});
		btnShowAll.setBounds(689, 607, 100, 23);
		InteriorMinister_Index.add(btnShowAll);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setBounds(580, 577, 89, 23);
		InteriorMinister_Index.add(btnDelete);
		
		Insert = new JPanel();
		Insert.setLayout(null);
		tabbedPane.addTab("Insert", new ImageIcon(InteriorMinister.class.getResource("/image/icon/216490_add_user_icon.png")), Insert, null);
		
		lblNewLabel = new JLabel("<html><span color=red style='font-size:40px;'>&#10133;_Insert Interior Minister_&#10133;</span></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(36, 11, 1000, 216);
		Insert.add(lblNewLabel);
		
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
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnNewButton.setBounds(506, 591, 128, 34);
		Insert.add(btnNewButton);
		
		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setSelected(true);
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
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		scrollPane_1.setViewportView(lblNewLabel_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(346, 323, 225, 25);
		Insert.add(dateChooser);
		
		Update = new JPanel();
		Update.setLayout(null);
		tabbedPane.addTab("Update", new ImageIcon(InteriorMinister.class.getResource("/image/icon/7106354_reload_data_infographic_update_element_icon.png")), Update, null);
		
		lblupdateUser = new JLabel("<html><span color=red style='font-size:40px;'>&#10133;_Update Interior Minister_&#10133;</span></html>");
		lblupdateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblupdateUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblupdateUser.setBounds(0, 0, 1079, 216);
		Update.add(lblupdateUser);
		
		lblUserId = new JLabel("Id:");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserId.setBounds(216, 246, 141, 25);
		Update.add(lblUserId);
		
		txtUpdateId = new JTextField();
		txtUpdateId.setColumns(10);
		txtUpdateId.setBounds(350, 252, 225, 19);
		Update.add(txtUpdateId);
		
		lblFullname_1 = new JLabel("Fullname: ");
		lblFullname_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFullname_1.setBounds(216, 318, 141, 25);
		Update.add(lblFullname_1);
		
		txtUpdateFullname = new JTextField();
		txtUpdateFullname.setColumns(10);
		txtUpdateFullname.setBounds(350, 324, 225, 19);
		Update.add(txtUpdateFullname);
		
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

	}
	protected void InteriorMinister_IndexAncestorAdded(AncestorEvent event) {
		// when start auto run
		// update
		txtUpdateId.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		txtUpdateFullname.setEnabled(false);
		rdbtnMale_1.setEnabled(false);
		rdbtnFemale_1.setEnabled(false);
		dateChooser_1.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnDelete.setEnabled(false);
		
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class; //set kiểu data
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
				default:
					return String.class;
				}
			}
		};

		model.addColumn("G_Id"); //set field name
		model.addColumn("G_Image");
		model.addColumn("G_Name");
		model.addColumn("G_Gender");
		model.addColumn("G_Dob");
		model.addColumn("Created_At");
		model.addColumn("Update_At");

		InteriorMinister_Dao dao = new InteriorMinister_Dao();
		totalOfRows = dao.countInteriorMinister();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		lblTotalOfRow.setText("Row count: " + totalOfRows);
//String.valueOf(i.getG_Dob()).equals("0")?"Male":"Female"
		
		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getG_Id(), new ImageIcon(new ImageIcon(
//				JFrame1.class.getResource(pro.getPicture()) //chạy vào resource
						System.getProperty("user.dir") + i.getG_Image() // lấy img ngoài
				).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getG_Name(),
						i.getG_Gender().equals(true) ? "Male" : "Female", i.getG_Dob(),
						i.getCreated_At().toString(), i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
		table.setModel(model);
		table.setRowHeight(60);
	}
	private void loadData() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0); // xóa sạch data
		InteriorMinister_Dao dao = new InteriorMinister_Dao();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.getList(pageNumber, rowsOfPage).forEach(
				i -> model.addRow(new Object[] { i.getG_Id(), new ImageIcon(new ImageIcon(
//						JFrame1.class.getResource(pro.getPicture()) //chạy vào resource
								System.getProperty("user.dir") + i.getG_Image() // lấy img ngoài
						).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getG_Name(),
								i.getG_Gender().equals(true) ? "Male" : "Female", i.getG_Dob(),
								i.getCreated_At().toString(), i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));

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
		if(pageNumber != 0) {
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
	protected void btnDeleteActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			// 0=yes, 1=no, 2=cancel
			int input = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THIS GUARD ? YOU CANNOT UNDO !!!", "Delete", JOptionPane.OK_CANCEL_OPTION);
			if(input == 0) {
				InteriorMinister_Dao gua = new InteriorMinister_Dao();
				gua.deleteData(Integer.parseInt(txtGetId.getText()));
				JOptionPane.showMessageDialog(null, "Delete Successfully");
				File f1 = new File(oldImg);
				f1.delete();
			}
			loadData();
		}
	}
	public static PreparedStatement run(Connection con, int G_Id) throws Exception {
		String str = "select * from Interior_Minister where G_Id = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, G_Id);
		return ps;
	}
	protected void btnFindActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			int G_Id = Integer.parseInt(txtGetId.getText());
			//list
			btnFirstButton.setEnabled(false);
			btnPreviusButton.setEnabled(false);
			btnNextButton.setEnabled(false);
			btnLastButton.setEnabled(false);
			comboBox.setEnabled(false);
			txtPage.setEnabled(false);
			btnDelete.setEnabled(true);
			//update
			txtUpdateId.setEnabled(true);
			btnNewButton_2.setEnabled(true);
			txtUpdateFullname.setEnabled(true);
			rdbtnMale_1.setEnabled(true);
			rdbtnFemale_1.setEnabled(true);
			dateChooser_1.setEnabled(true);
			btnNewButton_1.setEnabled(true);

			DefaultTableModel model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column) {
					switch (column) {
					case 0:
						return Integer.class; //set kiểu data
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
					default:
						return String.class;
					}
				}
			};

			model.addColumn("G_Id"); //set field name
			model.addColumn("G_Image");
			model.addColumn("G_Name");
			model.addColumn("G_Gender");
			model.addColumn("G_Dob");
			model.addColumn("Created_At");
			model.addColumn("Update_At");

			InteriorMinister_Dao dao = new InteriorMinister_Dao();
			totalOfRows = dao.countInteriorMinister();
			totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
			lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
			lblTotalOfRow.setText("Row count: " + totalOfRows);

			dao.getListInteriorMinisterWhenSearch(Integer.parseInt(txtGetId.getText())).forEach(
					i -> model.addRow(new Object[] { i.getG_Id(), new ImageIcon(new ImageIcon(
//							JFrame1.class.getResource(pro.getPicture()) //chạy vào resource
							System.getProperty("user.dir") + i.getG_Image() // lấy img ngoài
					).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)), i.getG_Name(),
							i.getG_Gender().equals(true) ? "Male" : "Female", i.getG_Dob(),
							i.getCreated_At().toString(), i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
			table.setModel(model);
			table.setRowHeight(60);
			JOptionPane.showMessageDialog(null, "Find Successfully");
			
			String connect = "jdbc:sqlserver://BUFALER\\SQLEXPRESS:1433;" 
					+ "databaseName=Prisoner_Management_System;" 
					+ "user=sa; password=1";
			try (var con = DriverManager.getConnection(connect);
					var ps = run(con,G_Id);
					ResultSet rs = ps.executeQuery();
			) {
				while(rs.next()) {
					txtUpdateId.setText(txtGetId.getText());
					lblNewLabel_2.setIcon(
							new ImageIcon(new ImageIcon(System.getProperty("user.dir") + rs.getString(2)) //ảnh cũ
							.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
					txtUpdateFullname.setText(rs.getString(3));
					if(rs.getString(4).equals("1")) {
						rdbtnMale_1.setSelected(true);
					}else {
						rdbtnFemale_1.setSelected(true);
					}
					dateChooser_1.setDate(Date.valueOf(rs.getString(5)));
					
					//lưu ảnh cũ lại vào biến 
					oldImg = System.getProperty("user.dir") + rs.getString(2);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		Boolean flag = true;
		String gender = null;
		if(rdbtnMale.isSelected()) {
			gender = "true";
		}
		if(rdbtnFemale.isSelected()) {
			gender = "false";
		}
		
		if(!Pattern.compile(RegexConst.FULLNAME).matcher(txtFullname.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Fullname must at least 1 and max 50 characters");
		}
		if(dateChooser.getDate()==null) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Birthday incorrect !!! [yyyy-mm-dd | yyyy/mm/dd]");
		}
		if(flag) {
			InteriorMinister_Dao gua = new InteriorMinister_Dao();
			int ram = LocalTime.now().getNano();

			//save image = copy
			if(imgPath==null) {
				JOptionPane.showMessageDialog(null, "Image not null !!!");
			}else {
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
				gua.insertData("/image/" + ram + (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim()),
						txtFullname.getText(), 
						gender, 
						date);
				JOptionPane.showMessageDialog(null, "Insert Successfully");
			}
		}
	}
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		String gender = null;
		if(rdbtnMale_1.isSelected()) {
			gender = "true";
		}
		if(rdbtnFemale_1.isSelected()) {
			gender = "false";
		}
		InteriorMinister_Dao gua = new InteriorMinister_Dao();
		int ram = LocalTime.now().getNano();

		//save image = copy
		File f_0 = new File(imgPath); // img gốc
		File f_0_copy = new File(System.getProperty("user.dir") + "\\image\\" + ram
				+ (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim())); // img copy
		try {
			Files.copy(f_0.toPath(), f_0_copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
		String date = dcn.format(dateChooser_1.getDate() );
		gua.UpdateData("/image/" + ram + (imgPath.substring(imgPath.lastIndexOf("\\") + 1).trim()),
				txtUpdateFullname.getText(), 
				gender, 
				date, 
				Integer.parseInt(txtUpdateId.getText()));
		JOptionPane.showMessageDialog(null, "Update Successfully");
	}
	protected void btnLoadImageActionPerformed(ActionEvent e) {
		//load ảnh lên label
		JFileChooser chooser = new JFileChooser();//195 kỳ đồng q3 bùi thị xuân
		chooser.setDialogTitle("load image");
		chooser.setFileFilter(
				new FileNameExtensionFilter("image(jpg, png, gif)", 
						"jpg", "png", "gif" )
		);
		chooser.setAcceptAllFileFilterUsed(false); //chặn thuộc tính all file
		int result = chooser.showOpenDialog(null);
		if(result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile(); //lấy 1 file thôi
			lblNewLabel_1.setIcon(
					new ImageIcon(new ImageIcon(f.getAbsolutePath())
					.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH))
			);
			imgPath = f.getAbsolutePath();
		}
	}
	protected void btnNewButton_2ActionPerformed(ActionEvent e) {
		//load ảnh lên label Update
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("load image");
		chooser.setFileFilter(
				new FileNameExtensionFilter("image(jpg, png, gif)", 
						"jpg", "png", "gif" )
		);
		chooser.setAcceptAllFileFilterUsed(false); //chặn thuộc tính all file
		int result = chooser.showOpenDialog(null);
		if(result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile(); //lấy 1 file thôi
			lblNewLabel_2.setIcon(
					new ImageIcon(new ImageIcon(f.getAbsolutePath())
					.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH))
			);
			//load ảnh mới lên xong thì xóa ảnh cũ
			File f1 = new File(oldImg);
			f1.delete();
			//lưu path ảnh mới
			imgPath = f.getAbsolutePath();
		}
	}
}
