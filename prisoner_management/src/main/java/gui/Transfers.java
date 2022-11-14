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
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import dao.InteriorMinister_Dao;
import dao.Transfer_Dao;

import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class Transfers extends JInternalFrame {
	Integer pageNumber = 1;
	Integer rowsOfPage = 10;
	Integer totalOfRows = 0;
	Double totalPage = 0.0;
	private JTabbedPane tabbedPane;
	private JPanel Transfer_Index;
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
	private JLabel lblP_Id;
	private JLabel lblBirthday;
	private JLabel lblFullname;
	private JTextField txtOldPrison;
	private JButton btnNewButton;
	private JPanel Update;
	private JLabel lblupdateUser;
	private JLabel lblT_Id;
	private JTextField txtT_Id;
	private JButton btnNewButton_1;
	private JTable table;
	private JTextField txtP_Id;
	private JLabel lblTransferDate;
	private JDateChooser dateChooser;
	private JTextArea txtReason;
	private JLabel lblFullname_1;
	private JLabel lblBirthday_1;
	private JLabel lblTransferDate_1;
	private JLabel lblP_Id_1;
	private JTextField txtUpdateOldPrison;
	private JTextField txtUpdateP_Id;
	private JTextArea txtUpdateReason;
	private JDateChooser dateChooser_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfers frame = new Transfers();
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
	public Transfers() {
		setIconifiable(true);
		setClosable(true);
		setFrameIcon(new ImageIcon(Transfers.class.getResource("/image/icon/9071382_transfer_icon.png")));
		setMaximizable(true);
		setTitle("Transfer");
		setBounds(100, 100, 1100, 700);
		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1084, 670);
		getContentPane().add(tabbedPane);

		Transfer_Index = new JPanel();
		Transfer_Index.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				Transfer_IndexAncestorAdded(event);
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		Transfer_Index.setLayout(null);
		tabbedPane.addTab("List", new ImageIcon(Transfers.class.getResource("/image/icon/216422_list_th_icon.png")),
				Transfer_Index, null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1079, 566);
		Transfer_Index.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		lblStatusPage = new JLabel("Page 1 of 0");
		lblStatusPage.setBounds(20, 611, 100, 14);
		Transfer_Index.add(lblStatusPage);

		lblTotalOfRow = new JLabel("Rows count: 0");
		lblTotalOfRow.setBounds(969, 611, 100, 14);
		Transfer_Index.add(lblTotalOfRow);

		btnFirstButton = new JButton("First Button");
		btnFirstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstButtonActionPerformed(e);
			}
		});
		btnFirstButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnFirstButton.setBounds(10, 577, 100, 23);
		Transfer_Index.add(btnFirstButton);

		btnPreviusButton = new JButton("Previus Button");
		btnPreviusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviusButtonActionPerformed(e);
			}
		});
		btnPreviusButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnPreviusButton.setBounds(450, 577, 120, 23);
		Transfer_Index.add(btnPreviusButton);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActionPerformed(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "10", "20", "30" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(230, 578, 100, 21);
		Transfer_Index.add(comboBox);

		btnNextButton = new JButton("Next Button");
		btnNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextButtonActionPerformed(e);
			}
		});
		btnNextButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNextButton.setBounds(340, 577, 100, 23);
		Transfer_Index.add(btnNextButton);

		btnLastButton = new JButton("Last Button");
		btnLastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastButtonActionPerformed(e);
			}
		});
		btnLastButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnLastButton.setBounds(120, 577, 100, 23);
		Transfer_Index.add(btnLastButton);

		txtPage = new JTextField();
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		txtPage.setBounds(340, 608, 329, 20);
		Transfer_Index.add(txtPage);

		btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFindActionPerformed(e);
			}
		});
		btnFind.setBounds(829, 577, 140, 23);
		Transfer_Index.add(btnFind);

		txtGetId = new JTextField();
		txtGetId.setColumns(10);
		txtGetId.setBounds(679, 578, 140, 22);
		Transfer_Index.add(txtGetId);

		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowAllActionPerformed(e);
			}
		});
		btnShowAll.setBounds(689, 607, 100, 23);
		Transfer_Index.add(btnShowAll);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setBounds(580, 577, 89, 23);
		Transfer_Index.add(btnDelete);
		
				Insert = new JPanel();
				Insert.setLayout(null);
				tabbedPane.addTab("Insert", new ImageIcon(Transfers.class.getResource("/image/icon/216490_add_user_icon.png")),
						Insert, null);
				
						lblNewLabel = new JLabel(
								"<html><span color=red style='font-size:60px;'>&#10133;_Insert Transfer_&#10133;</span></html>");
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblNewLabel.setBounds(36, 11, 1000, 216);
						Insert.add(lblNewLabel);
						
								lblP_Id = new JLabel("Prisoner Id:");
								lblP_Id.setFont(new Font("Tahoma", Font.BOLD, 20));
								lblP_Id.setBounds(212, 395, 141, 25);
								Insert.add(lblP_Id);
								
										lblBirthday = new JLabel("Reason:");
										lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 20));
										lblBirthday.setBounds(212, 287, 141, 25);
										Insert.add(lblBirthday);
										
												lblFullname = new JLabel("Old Prison:");
												lblFullname.setFont(new Font("Tahoma", Font.BOLD, 20));
												lblFullname.setBounds(212, 251, 141, 25);
												Insert.add(lblFullname);
												
														txtOldPrison = new JTextField();
														txtOldPrison.setColumns(10);
														txtOldPrison.setBounds(346, 257, 225, 19);
														Insert.add(txtOldPrison);
														
																btnNewButton = new JButton("Submit");
																btnNewButton.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		btnNewButtonActionPerformed(e);
																	}
																});
																btnNewButton.setBounds(575, 431, 128, 34);
																Insert.add(btnNewButton);
																
																txtP_Id = new JTextField();
																txtP_Id.setColumns(10);
																txtP_Id.setBounds(346, 401, 225, 19);
																Insert.add(txtP_Id);
																
																lblTransferDate = new JLabel("Transfer:");
																lblTransferDate.setFont(new Font("Tahoma", Font.BOLD, 20));
																lblTransferDate.setBounds(212, 359, 141, 25);
																Insert.add(lblTransferDate);
																
																dateChooser = new JDateChooser();
																dateChooser.setBounds(346, 364, 225, 20);
																Insert.add(dateChooser);
																
																txtReason = new JTextArea();
																txtReason.setLineWrap(true);
																txtReason.setBounds(348, 291, 223, 56);
																Insert.add(txtReason);

		Update = new JPanel();
		Update.setLayout(null);
		tabbedPane.addTab("Update",
				new ImageIcon(Transfers.class
						.getResource("/image/icon/7106354_reload_data_infographic_update_element_icon.png")),
				Update, null);

		lblupdateUser = new JLabel(
				"<html><span color=red style='font-size:60px;'>&#10133;_Update Transfer_&#10133;</span></html>");
		lblupdateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblupdateUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblupdateUser.setBounds(0, 0, 1079, 216);
		Update.add(lblupdateUser);

		lblT_Id = new JLabel("Id:");
		lblT_Id.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblT_Id.setBounds(216, 246, 141, 25);
		Update.add(lblT_Id);

		txtT_Id = new JTextField();
		txtT_Id.setColumns(10);
		txtT_Id.setBounds(350, 252, 225, 19);
		Update.add(txtT_Id);

		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(612, 553, 128, 34);
		Update.add(btnNewButton_1);
		
		lblFullname_1 = new JLabel("Old Prison:");
		lblFullname_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFullname_1.setBounds(216, 282, 141, 25);
		Update.add(lblFullname_1);
		
		lblBirthday_1 = new JLabel("Reason:");
		lblBirthday_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBirthday_1.setBounds(216, 318, 141, 25);
		Update.add(lblBirthday_1);
		
		lblTransferDate_1 = new JLabel("Transfer:");
		lblTransferDate_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTransferDate_1.setBounds(216, 390, 141, 25);
		Update.add(lblTransferDate_1);
		
		lblP_Id_1 = new JLabel("Prisoner Id:");
		lblP_Id_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP_Id_1.setBounds(216, 426, 141, 25);
		Update.add(lblP_Id_1);
		
		txtUpdateOldPrison = new JTextField();
		txtUpdateOldPrison.setColumns(10);
		txtUpdateOldPrison.setBounds(350, 282, 225, 19);
		Update.add(txtUpdateOldPrison);
		
		txtUpdateP_Id = new JTextField();
		txtUpdateP_Id.setColumns(10);
		txtUpdateP_Id.setBounds(350, 432, 225, 19);
		Update.add(txtUpdateP_Id);
		
		txtUpdateReason = new JTextArea();
		txtUpdateReason.setLineWrap(true);
		txtUpdateReason.setBounds(352, 318, 223, 56);
		Update.add(txtUpdateReason);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(350, 395, 225, 20);
		Update.add(dateChooser_1);

	}

	protected void Transfer_IndexAncestorAdded(AncestorEvent event) {
		// when start auto run
		// update
		txtT_Id.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		txtUpdateOldPrison.setEnabled(false);
		txtUpdateReason.setEnabled(false);
		txtUpdateP_Id.setEnabled(false);
		btnDelete.setEnabled(false);
		dateChooser_1.setEnabled(false);

		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return Integer.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				default:
					return String.class;
				}
			}
		};

		model.addColumn("T_Id");
		model.addColumn("T_Old_Prison");
		model.addColumn("T_Reason");
		model.addColumn("T_Transfer_Date");
		model.addColumn("P_Id");
		model.addColumn("Created_At");
		model.addColumn("Update_At");

		Transfer_Dao dao = new Transfer_Dao();
		totalOfRows = dao.countTransfer();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		lblTotalOfRow.setText("Row count: " + totalOfRows);
//String.valueOf(i.getG_Dob()).equals("0")?"Male":"Female"
		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getT_Id(), i.getT_Old_Prison(), i.getT_Reason(),
						i.getT_Transfer_Date(), i.getP_Id(), i.getCreated_At(), i.getUpdate_At()==null?"Invalid Date":i.getUpdate_At() }));
		table.setModel(model);
		table.setRowHeight(60);
	}

	private void loadData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // xóa sạch data
		Transfer_Dao dao = new Transfer_Dao();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getT_Id(), i.getT_Old_Prison(), i.getT_Reason(),
						i.getT_Transfer_Date(), i.getP_Id(), i.getCreated_At(), i.getUpdate_At()==null?"Invalid Date":i.getUpdate_At() }));

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

	protected void btnDeleteActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			// 0=yes, 1=no, 2=cancel
			int input = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THIS TRANSFER ? YOU CANNOT UNDO !!!",
					"Delete", JOptionPane.OK_CANCEL_OPTION);
			if (input == 0) {
				Transfer_Dao tra = new Transfer_Dao();
				tra.deleteData(Integer.parseInt(txtGetId.getText()));
				JOptionPane.showMessageDialog(null, "Delete Successfully");
			}
			loadData();
		}
	}
	public static PreparedStatement run(Connection con, int T_Id) throws Exception {
		String str = "select * from Transfer_Detail where T_Id = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, T_Id);
		return ps;
	}
	protected void btnFindActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			int T_Id = Integer.parseInt(txtGetId.getText());
			//list
			btnFirstButton.setEnabled(false);
			btnPreviusButton.setEnabled(false);
			btnNextButton.setEnabled(false);
			btnLastButton.setEnabled(false);
			comboBox.setEnabled(false);
			txtPage.setEnabled(false);
			btnDelete.setEnabled(true);
			//update
			txtT_Id.setEnabled(true);
			btnNewButton_1.setEnabled(true);
			txtUpdateOldPrison.setEnabled(true);
			txtUpdateReason.setEnabled(true);
			txtUpdateP_Id.setEnabled(true);
			dateChooser_1.setEnabled(true);
			btnDelete.setEnabled(true);

			DefaultTableModel model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column) {
					switch (column) {
					case 0:
						return Integer.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return Integer.class;
					case 5:
						return String.class;
					case 6:
						return String.class;
					default:
						return String.class;
					}
				}
			};

			model.addColumn("T_Id");
			model.addColumn("T_Old_Prison");
			model.addColumn("T_Reason");
			model.addColumn("T_Transfer_Date");
			model.addColumn("P_Id");
			model.addColumn("Created_At");
			model.addColumn("Update_At");

			Transfer_Dao dao = new Transfer_Dao();
			totalOfRows = dao.countTransfer();
			totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
			lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
			lblTotalOfRow.setText("Row count: " + totalOfRows);

			dao.getListTransferWhenSearch(Integer.parseInt(txtGetId.getText())).forEach(
					i -> model.addRow(new Object[] { i.getT_Id(), i.getT_Old_Prison(), i.getT_Reason(),
							i.getT_Transfer_Date(), i.getP_Id(), i.getCreated_At(), i.getUpdate_At()==null?"Invalid Date":i.getUpdate_At() }));
			table.setModel(model);
			table.setRowHeight(60);
			JOptionPane.showMessageDialog(null, "Find Successfully");
			
			String connect = "jdbc:sqlserver://BUFALER\\SQLEXPRESS:1433;" 
					+ "databaseName=Prisoner_Management_System;" 
					+ "user=sa; password=1";
			try (var con = DriverManager.getConnection(connect);
					var ps = run(con,T_Id);
					ResultSet rs = ps.executeQuery();
			) {
				while(rs.next()) {
					txtT_Id.setText(txtGetId.getText());
					txtUpdateOldPrison.setText(rs.getString(2));
					txtUpdateReason.setText(rs.getString(3));
					dateChooser_1.setDate(Date.valueOf(rs.getString(4)));
					txtUpdateP_Id.setText(rs.getString(5));
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		Boolean flag = true;
		if(dateChooser.getDate()==null) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Transfer date incorrect !!! [yyyy-mm-dd | yyyy/mm/dd]");
		}
		if(flag) {
			Transfer_Dao tra = new Transfer_Dao();
			SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
			String date = dcn.format(dateChooser.getDate() );
			tra.insertData(txtOldPrison.getText(),txtReason.getText(),date,Integer.parseInt(txtP_Id.getText()));
			JOptionPane.showMessageDialog(null, "Insert Successfully");
		}
	}
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		Transfer_Dao tra = new Transfer_Dao();
		SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
		String date = dcn.format(dateChooser_1.getDate() );

		tra.UpdateData(txtUpdateOldPrison.getText(),txtUpdateReason.getText(),date,Integer.parseInt(txtUpdateP_Id.getText()),Integer.parseInt(txtT_Id.getText()));
		JOptionPane.showMessageDialog(null, "Update Successfully");
	}
	protected void btnShowAllActionPerformed(ActionEvent e) {
		btnFirstButton.setEnabled(true);
		btnPreviusButton.setEnabled(true);
		btnNextButton.setEnabled(true);
		btnLastButton.setEnabled(true);
		comboBox.setEnabled(true);
		btnDelete.setEnabled(false);
		txtPage.setEnabled(true);
		txtGetId.setText("");
		loadData();
	}
}
