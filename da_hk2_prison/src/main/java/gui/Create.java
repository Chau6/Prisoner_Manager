package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import dao.Prisoner_Dao;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Create extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JPanel panel_1;
	public JPanel home;
	public JPanel list;
	public JPanel create;
	public JPanel panel_5;
	public JPanel panel_6;
	public JPanel panel_7;
	public JPanel logout;
	public JLabel lblNewLabel;
	public JLabel lblLogout;
	public JLabel lblCreate;
	public JLabel lblList;
	public JPanel listbody;
	public JScrollPane scrollPane;
	public JTable table;
	public JTextField textField;
	public JButton btnNewButton;
	public JLabel lblNewLabel_1;
	public JPanel createbody;
	public JPanel listtop;
	public JPanel homebody;

	Integer pageNumber = 1; // ở trang thứ mấy
	Integer rowsOfPage = 10; // 1 trang hiển thị 10 hàng
	Integer totalOfRows = 0; // tổng số hàng có trong table trong db
	Double totalPage = 0.0; // có bao nhiêu trang
	private JLabel lblStatusPage;
	private JLabel lblTotalOfRow;
	private JTextField txtPage;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create frame = new Create();
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
	public Create() {
		setResizable(false);
		setTitle("Create");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		listbody = new JPanel();
		listbody.setBounds(253, 138, 803, 440);
		contentPane.add(listbody);
		listbody.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		listbody.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		// loadData();
		scrollPane.setViewportView(table);
		listbody.setVisible(false);

		listtop = new JPanel();
		listtop.setBounds(253, 0, 803, 139);
		contentPane.add(listtop);
		listtop.setLayout(null);

		textField = new JTextField();
		textField.setBounds(0, 99, 313, 30);
		listtop.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);

		btnNewButton = new JButton("Search");
		btnNewButton.setBounds(325, 98, 97, 30);
		listtop.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblStatusPage = new JLabel("Page 1 of 0");
		lblStatusPage.setBounds(10, 11, 75, 14);
		listtop.add(lblStatusPage);

		lblTotalOfRow = new JLabel("Rows count: 0");
		lblTotalOfRow.setBounds(122, 11, 90, 14);
		listtop.add(lblTotalOfRow);
		
		txtPage = new JTextField();
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		txtPage.setBounds(20, 36, 387, 20);
		listtop.add(txtPage);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActionPerformed(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "5"}));
		comboBox.setBounds(426, 35, 139, 21);
		listtop.add(comboBox);

		listtop.setVisible(false);

		homebody = new JPanel();
		homebody.setBackground(new Color(240, 240, 240));
		homebody.setBounds(253, 10, 803, 568);
		contentPane.add(homebody);
		homebody.setLayout(null);

		createbody = new JPanel();
		createbody.setBackground(new Color(0, 0, 128));
		createbody.setBounds(253, 247, 803, 331);
		contentPane.add(createbody);

		panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(0, 0, 243, 588);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(0, -11, 243, 143);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_1 = new JLabel("OverDose");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(67, 50, 110, 50);
		panel_1.add(lblNewLabel_1);

		home = new JPanel();
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homeMouseClicked(e);
			}
		});
		home.setBackground(new Color(128, 0, 128));
		home.setBounds(0, 142, 243, 44);
		panel.add(home);
		home.setLayout(null);

		lblNewLabel = new JLabel("HOME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(82, 10, 75, 29);
		home.add(lblNewLabel);

		list = new JPanel();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listMouseClicked(e);
			}
		});
		list.setBackground(new Color(128, 0, 128));
		list.setBounds(0, 185, 243, 44);
		panel.add(list);
		list.setLayout(null);

		lblList = new JLabel("LIST");
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(Color.WHITE);
		lblList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblList.setBounds(82, 10, 75, 29);
		list.add(lblList);

		create = new JPanel();
		create.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createMouseClicked(e);
			}
		});
		create.setBackground(new Color(128, 0, 128));
		create.setBounds(0, 227, 243, 44);
		panel.add(create);
		create.setLayout(null);

		lblCreate = new JLabel("CREATE");
		lblCreate.setBounds(80, 10, 75, 29);
		create.add(lblCreate);
		lblCreate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreate.setForeground(Color.WHITE);
		lblCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 0, 128));
		panel_5.setBounds(0, 270, 243, 44);
		panel.add(panel_5);
		panel_5.setLayout(null);

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(128, 0, 128));
		panel_6.setBounds(0, 313, 243, 44);
		panel.add(panel_6);
		panel_6.setLayout(null);

		panel_7 = new JPanel();
		panel_7.setBackground(new Color(128, 0, 128));
		panel_7.setBounds(0, 357, 243, 44);
		panel.add(panel_7);
		panel_7.setLayout(null);

		logout = new JPanel();
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logoutMouseClicked(e);
			}
		});
		logout.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(255, 255, 255)));
		logout.setBackground(new Color(128, 0, 128));
		logout.setBounds(0, 401, 243, 44);
		panel.add(logout);
		logout.setLayout(null);

		lblLogout = new JLabel("LOGOUT");
		lblLogout.setBounds(86, 10, 75, 29);
		logout.add(lblLogout);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		createbody.setVisible(false);
	}

	protected void createMouseClicked(MouseEvent e) {
		listbody.setVisible(false);
		listtop.setVisible(false);
		create.setBackground(new Color(110, 0, 160));
		list.setBackground(new Color(128, 0, 128));
		home.setBackground(new Color(128, 0, 128));
		homebody.setVisible(true);
		createbody.setVisible(true);
		
		createe f1 = new createe().getMyInstance();
		if(!f1.isVisible()) { //singleton
			f1.setVisible(true);
			homebody.add(f1);
		}
	}

	protected void homeMouseClicked(MouseEvent e) {
		listbody.setVisible(false);
		listtop.setVisible(false);
		home.setBackground(new Color(110, 0, 160));
		list.setBackground(new Color(128, 0, 128));
		create.setBackground(new Color(128, 0, 128));
		createbody.setVisible(false);
		homebody.setVisible(false);
	}

	protected void listMouseClicked(MouseEvent e) {
		listbody.setVisible(true);
		listtop.setVisible(true);
		list.setBackground(new Color(110, 0, 160));
		create.setBackground(new Color(128, 0, 128));
		home.setBackground(new Color(128, 0, 128));
		homebody.setVisible(false);
		createbody.setVisible(false);

//		DefaultTableModel model = new DefaultTableModel() {
//			public Class<?> getColumnClass(int column) {
//				switch (column) {
//				case 0:
//					return Integer.class; // prisoner_id
//				case 1:
//					return String.class; // fullname
//				case 2:
//					return Boolean.class; // gender
//				case 3:
//					return String.class; // birthday
//				case 4:
//					return String.class; // day_in
//				case 5:
//					return String.class; // update_time
//				case 6:
//					return Integer.class; // prison_id
//				case 7:
//					return Integer.class; // case_id
//				case 8:
//					return Integer.class; // dayout_id
//				default:
//					return String.class;
//				}
//			}
//		};
//
//		model.addColumn("prisoner_id");
//		model.addColumn("fullname");
//		model.addColumn("gender");
//		model.addColumn("birthday");
//		model.addColumn("day_in");
//		model.addColumn("update_time");
//		model.addColumn("prison_id");
//		model.addColumn("case_id");
//		model.addColumn("dayout_id");
//
//		Prisoner_Dao dao = new Prisoner_Dao();
//		totalOfRows = dao.countPrisoner();
//		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue()); //ceil làm tròn lên. Ex: 5.1 -> 6
//		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
//		lblTotalOfRow.setText("Row count: " + totalOfRows);
//
//		dao.getList(pageNumber, rowsOfPage)
//				.forEach(pro -> model.addRow(new Object[] { 
//						pro.getPrisoner_id(), 
//						pro.getFullname(), 
//						pro.isGender(),
//						pro.getBirthday().toString(), 
//						pro.getDay_in().toString(), 
//						pro.getUpdate_time().toString(),
//						pro.getPrison_id(), 
//						pro.getCase_id(), 
//						pro.getDayout_id() }));
//
//		table.setModel(model);
//		table.setRowHeight(60);
	}

	protected void comboBoxActionPerformed(ActionEvent e) {
		if (table != null) {
			pageNumber = 1;
			txtPage.setText(pageNumber.toString());
			rowsOfPage = Integer.parseInt(comboBox.getSelectedItem().toString());
			loadData();
		}
	}

	private void loadData() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0); // xóa sạch data
		Prisoner_Dao dao = new Prisoner_Dao();
		totalPage = Math.ceil(totalOfRows.doubleValue() / rowsOfPage.doubleValue());
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.getList(pageNumber, rowsOfPage).forEach(pri -> model
				.addRow(new Object[] { 
						pri.getPrisoner_id(), 
						pri.getFullname(), 
						pri.isGender(),
						pri.getBirthday().toString(), 
						pri.getDay_in().toString(), 
						pri.getUpdate_time().toString(),
						pri.getPrison_id(), 
						pri.getCase_id(), 
						pri.getDayout_id() }));

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
		loadData();
	}

	protected void btnPreviusButtonActionPerformed(ActionEvent e) {
		if (pageNumber > 1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
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

	protected void txtPageActionPerformed(ActionEvent e) {
		int page = Integer.parseInt(txtPage.getText());
		if (page >= 1 && page <= totalPage.intValue()) {
			pageNumber = page;
			loadData();
		} else {
			JOptionPane.showMessageDialog(null, "page must be 1 to " + totalPage.intValue());
			txtPage.setText(pageNumber.toString());
		}
	}

	protected void logoutMouseClicked(MouseEvent e) {

	}
}
