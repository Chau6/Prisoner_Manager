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
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import com.toedter.calendar.JDateChooser;

import dao.Feedback_Dao;
import dao.Transfer_Dao;
import helper.RegexConst;

import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;

public class Feedbacks extends JInternalFrame {
	Integer pageNumber = 1;
	Integer rowsOfPage = 10;
	Integer totalOfRows = 0;
	Double totalPage = 0.0;
	private JTabbedPane tabbedPane;
	private JPanel Feedback_Index;
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
	private JLabel lblinsertFeedback;
	private JLabel lblP_Id;
	private JLabel lblFeedback;
	private JButton btnNewButton;
	private JTextField txtP_Id;
	private JTextArea txtFeedback;
	private JPanel Update;
	private JLabel lblupdateFeedback;
	private JLabel lblT_Id;
	private JTextField txtUpdateId;
	private JButton btnNewButton_1;
	private JLabel lblP_Id_2;
	private JTextField txtG_Id;
	private JLabel lblP_Id_1;
	private JLabel lblFeedback_1;
	private JTextField txtUpdateP_Id;
	private JTextArea txtUpdateFeedback;
	private JLabel lblP_Id_3;
	private JTextField txtUpdateG_Id;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedbacks frame = new Feedbacks();
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
	public Feedbacks() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setFrameIcon(new ImageIcon(
				Feedbacks.class.getResource("/image/icon/3669434_feedback_ic_icon.png")));
		setTitle("Feedback");
		setBounds(100, 100, 1100, 700);
		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1084, 670);
		getContentPane().add(tabbedPane);

		Feedback_Index = new JPanel();
		Feedback_Index.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				Feedback_IndexAncestorAdded(event);
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		Feedback_Index.setLayout(null);
		tabbedPane.addTab("List", new ImageIcon(
				Feedbacks.class.getResource("/image/icon/216422_list_th_icon.png")),
				Feedback_Index, null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1079, 566);
		Feedback_Index.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		lblStatusPage = new JLabel("Page 1 of 0");
		lblStatusPage.setBounds(20, 611, 100, 14);
		Feedback_Index.add(lblStatusPage);

		lblTotalOfRow = new JLabel("Rows count: 0");
		lblTotalOfRow.setBounds(969, 611, 100, 14);
		Feedback_Index.add(lblTotalOfRow);

		btnFirstButton = new JButton("First Button");
		btnFirstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstButtonActionPerformed(e);
			}
		});
		btnFirstButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnFirstButton.setBounds(10, 577, 100, 23);
		Feedback_Index.add(btnFirstButton);

		btnPreviusButton = new JButton("Previus Button");
		btnPreviusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviusButtonActionPerformed(e);
			}
		});
		btnPreviusButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnPreviusButton.setBounds(450, 577, 120, 23);
		Feedback_Index.add(btnPreviusButton);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActionPerformed(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(230, 578, 100, 21);
		Feedback_Index.add(comboBox);

		btnNextButton = new JButton("Next Button");
		btnNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextButtonActionPerformed(e);
			}
		});
		btnNextButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNextButton.setBounds(340, 577, 100, 23);
		Feedback_Index.add(btnNextButton);

		btnLastButton = new JButton("Last Button");
		btnLastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastButtonActionPerformed(e);
			}
		});
		btnLastButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnLastButton.setBounds(120, 577, 100, 23);
		Feedback_Index.add(btnLastButton);

		txtPage = new JTextField();
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		txtPage.setBounds(340, 608, 329, 20);
		Feedback_Index.add(txtPage);

		btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFindActionPerformed(e);
			}
		});
		btnFind.setBounds(829, 577, 140, 23);
		Feedback_Index.add(btnFind);

		txtGetId = new JTextField();
		txtGetId.setColumns(10);
		txtGetId.setBounds(679, 578, 140, 22);
		Feedback_Index.add(txtGetId);

		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowAllActionPerformed(e);
			}
		});
		btnShowAll.setBounds(689, 607, 100, 23);
		Feedback_Index.add(btnShowAll);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setBounds(580, 577, 89, 23);
		Feedback_Index.add(btnDelete);

		Insert = new JPanel();
		Insert.setLayout(null);
		tabbedPane.addTab("Insert", new ImageIcon(
				Feedbacks.class.getResource("/image/icon/1622831_bubble_chat_feedback_message_pencil_icon.png")),
				Insert, null);

		lblinsertFeedback = new JLabel(
				"<html><span color=red style='font-size:60px;'>&#10133;_Insert Feedback_&#10133;</span></html>");
		lblinsertFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblinsertFeedback.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblinsertFeedback.setBounds(36, 11, 1000, 216);
		Insert.add(lblinsertFeedback);

		lblP_Id = new JLabel("Prisoner Id:");
		lblP_Id.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP_Id.setBounds(212, 322, 141, 25);
		Insert.add(lblP_Id);

		lblFeedback = new JLabel("Feedback:");
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFeedback.setBounds(212, 251, 141, 25);
		Insert.add(lblFeedback);

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
		txtP_Id.setBounds(346, 328, 225, 19);
		Insert.add(txtP_Id);

		txtFeedback = new JTextArea();
		txtFeedback.setLineWrap(true);
		txtFeedback.setBounds(346, 255, 223, 56);
		Insert.add(txtFeedback);

		lblP_Id_2 = new JLabel("Guard Id:");
		lblP_Id_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP_Id_2.setBounds(212, 358, 141, 25);
		Insert.add(lblP_Id_2);

		txtG_Id = new JTextField();
		txtG_Id.setColumns(10);
		txtG_Id.setBounds(346, 364, 225, 19);
		Insert.add(txtG_Id);

		Update = new JPanel();
		Update.setLayout(null);
		tabbedPane.addTab("Update", new ImageIcon(
				Feedbacks.class.getResource("/image/icon/7106354_reload_data_infographic_update_element_icon.png")),
				Update, null);

		lblupdateFeedback = new JLabel(
				"<html><span color=red style='font-size:60px;'>&#10133;_Update Feedback_&#10133;</span></html>");
		lblupdateFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblupdateFeedback.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblupdateFeedback.setBounds(0, 0, 1079, 216);
		Update.add(lblupdateFeedback);

		lblT_Id = new JLabel("Id:");
		lblT_Id.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblT_Id.setBounds(216, 246, 141, 25);
		Update.add(lblT_Id);

		txtUpdateId = new JTextField();
		txtUpdateId.setColumns(10);
		txtUpdateId.setBounds(350, 252, 225, 19);
		Update.add(txtUpdateId);

		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(573, 455, 128, 34);
		Update.add(btnNewButton_1);

		lblP_Id_1 = new JLabel("Prisoner Id:");
		lblP_Id_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP_Id_1.setBounds(216, 353, 141, 25);
		Update.add(lblP_Id_1);

		lblFeedback_1 = new JLabel("Feedback:");
		lblFeedback_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFeedback_1.setBounds(216, 282, 141, 25);
		Update.add(lblFeedback_1);

		txtUpdateP_Id = new JTextField();
		txtUpdateP_Id.setColumns(10);
		txtUpdateP_Id.setBounds(350, 359, 225, 19);
		Update.add(txtUpdateP_Id);

		txtUpdateFeedback = new JTextArea();
		txtUpdateFeedback.setLineWrap(true);
		txtUpdateFeedback.setBounds(350, 286, 223, 56);
		Update.add(txtUpdateFeedback);

		lblP_Id_3 = new JLabel("Guard Id:");
		lblP_Id_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblP_Id_3.setBounds(216, 389, 141, 25);
		Update.add(lblP_Id_3);

		txtUpdateG_Id = new JTextField();
		txtUpdateG_Id.setColumns(10);
		txtUpdateG_Id.setBounds(350, 395, 225, 19);
		Update.add(txtUpdateG_Id);

	}

	protected void Feedback_IndexAncestorAdded(AncestorEvent event) {
		// when start auto run
		// update
		txtUpdateId.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		txtUpdateP_Id.setEnabled(false);
		txtUpdateG_Id.setEnabled(false);
		txtUpdateFeedback.setEnabled(false);
		btnDelete.setEnabled(false);

		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return Integer.class;
				case 3:
					return Integer.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				default:
					return String.class;
				}
			}
		};

		model.addColumn("F_Id");
		model.addColumn("F_CMT");
		model.addColumn("P_Id");
		model.addColumn("G_Id");
		model.addColumn("Created_At");
		model.addColumn("Update_At");

		Feedback_Dao dao = new Feedback_Dao();
		totalOfRows = dao.countFeedback();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		lblTotalOfRow.setText("Row count: " + totalOfRows);
		// String.valueOf(i.getG_Dob()).equals("0")?"Male":"Female"
		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getF_Id(), i.getF_CMT(), i.getP_Id(), i.getG_Id(),
						i.getCreated_At(), i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
		table.setModel(model);
		table.setRowHeight(60);
	}

	private void loadData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // xóa sạch data
		Feedback_Dao dao = new Feedback_Dao();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.getList(pageNumber, rowsOfPage)
				.forEach(i -> model.addRow(new Object[] { i.getF_Id(), i.getF_CMT(), i.getP_Id(), i.getG_Id(),
						i.getCreated_At(), i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));

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
			int input = JOptionPane.showConfirmDialog(null,
					"ARE YOU SURE TO DELETE THIS FEEDBACK ? YOU CANNOT UNDO !!!", "Delete",
					JOptionPane.OK_CANCEL_OPTION);
			if (input == 0) {
				Feedback_Dao fee = new Feedback_Dao();
				fee.deleteData(Integer.parseInt(txtGetId.getText()));
				JOptionPane.showMessageDialog(null, "Delete Successfully");
			}
			loadData();
		}
	}

	public static PreparedStatement run(Connection con, int F_Id) throws Exception {
		String str = "select * from Feedback where F_Id = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, F_Id);
		return ps;
	}

	protected void btnFindActionPerformed(ActionEvent e) {
		String id = txtGetId.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Please input ID");
		} else {
			int F_Id = Integer.parseInt(txtGetId.getText());
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
			btnNewButton_1.setEnabled(true);
			txtUpdateP_Id.setEnabled(true);
			txtUpdateG_Id.setEnabled(true);
			txtUpdateFeedback.setEnabled(true);

			DefaultTableModel model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column) {
					switch (column) {
					case 0:
						return Integer.class;
					case 1:
						return String.class;
					case 2:
						return Integer.class;
					case 3:
						return Integer.class;
					case 4:
						return String.class;
					case 5:
						return String.class;
					default:
						return String.class;
					}
				}
			};

			model.addColumn("F_Id");
			model.addColumn("F_CMT");
			model.addColumn("P_Id");
			model.addColumn("G_Id");
			model.addColumn("Created_At");
			model.addColumn("Update_At");

			Feedback_Dao dao = new Feedback_Dao();
			totalOfRows = dao.countFeedback();
			totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
			lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
			lblTotalOfRow.setText("Row count: " + totalOfRows);

			dao.getListFeedbackWhenSearch(Integer.parseInt(txtGetId.getText()))
					.forEach(i -> model.addRow(new Object[] { i.getF_Id(), i.getF_CMT(), i.getP_Id(), i.getG_Id(),
							i.getCreated_At(), i.getUpdate_At() == null ? "Invalid Date" : i.getUpdate_At() }));
			table.setModel(model);
			table.setRowHeight(60);
			JOptionPane.showMessageDialog(null, "Find Successfully");

			String connect = "jdbc:sqlserver://BUFALER\\SQLEXPRESS:1433;" + "databaseName=Prisoner_Management_System;"
					+ "user=sa; password=1";
			try (var con = DriverManager.getConnection(connect);
					var ps = run(con, F_Id);
					ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					txtUpdateId.setText(txtGetId.getText());
					txtUpdateFeedback.setText(rs.getString(2));
					txtUpdateP_Id.setText(rs.getString(3));
					txtUpdateG_Id.setText(rs.getString(4));
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		Boolean flag = true;
		if (!Pattern.compile(RegexConst.ID).matcher(txtP_Id.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "ID must at least 4 numbers");
		}
		if (txtFeedback.getText().isBlank()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Feedback not blank");
		}
		if (!Pattern.compile(RegexConst.ID_1).matcher(txtG_Id.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "Who is guard feedback ?");
		}
		if (flag) {
			Feedback_Dao fee = new Feedback_Dao();
			
			fee.insertData(txtFeedback.getText(), Integer.parseInt(txtP_Id.getText()), Integer.parseInt(txtG_Id.getText()));
			JOptionPane.showMessageDialog(null, "Insert Successfully");
		}
	}

	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		Boolean flag = true;
		if (!Pattern.compile(RegexConst.ID).matcher(txtUpdateP_Id.getText()).matches()) {
			flag = false;
			JOptionPane.showMessageDialog(null, "ID must at least 4 characters");
		}
		if(flag) {
			Feedback_Dao fee = new Feedback_Dao();
			fee.UpdateData(txtUpdateFeedback.getText(), Integer.parseInt(txtUpdateP_Id.getText()), Integer.parseInt(txtUpdateG_Id.getText()), Integer.parseInt(txtUpdateId.getText()));
			JOptionPane.showMessageDialog(null, "Update Successfully");
		}
	}
	protected void btnShowAllActionPerformed(ActionEvent e) {
		btnFirstButton.setEnabled(true);
		btnPreviusButton.setEnabled(true);
		btnNextButton.setEnabled(true);
		btnLastButton.setEnabled(true);
		comboBox.setEnabled(true);
		txtPage.setEnabled(true);
		btnDelete.setEnabled(false);
		txtGetId.setText("");
		loadData();
	}
}
