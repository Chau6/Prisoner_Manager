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

import dao.Block_Dao;
import entity.Block;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Blocks extends JInternalFrame {
	private JTabbedPane tabbedPane;
	private JPanel Block_Index;
	private JScrollPane scrollPane;
	private JLabel lblStatusPage;
	private JLabel lblTotalOfRow;
	private JButton btnFirstButton;
	private JButton btnPreviusButton;
	private JComboBox comboBox;
	private JButton btnNextButton;
	private JButton btnLastButton;
	private JTextField textField;
	private JButton btnFind;
	private JTextField txtGetId;
	private JButton btnShowAll;
	private JButton btnDelete;
	private JPanel Insert;
	private JLabel lblNewLabel;
	private JLabel lblGuardId;
	private JLabel lblPrisonerId;
	private JLabel lblName;
	private JLabel lblCellRoom;
	private JTextField txtName;
	private JTextField txtP_Id;
	private JTextField txtG_Id;
	private JButton btnNewButton;
	private JLabel lblSupervisionId;
	private JTextField txtS_Id;
	private JTextField txtCellRoom;
	private JTable table;
	private JButton btnDelete_1;
	private JLabel lblIdWhenDel;
	private JTextField txtId;
	private JPanel Insert_1;
	private JLabel lblupdateUser;
	private JLabel lblGuardId_1;
	private JLabel lblPrisonerId_1;
	private JLabel lblName_1;
	private JLabel lblCellRoom_1;
	private JTextField txtUpdateName;
	private JTextField txtUpdateP_Id;
	private JTextField txtUpdateG_Id;
	private JButton btnNewButton_1;
	private JLabel lblSupervisionId_1;
	private JTextField txtUpdateS_Id;
	private JTextField txtUpdateCellRoom;
	private JButton btnDelete_2;
	private JLabel lblIdUpdate;
	private JTextField txtUpdateId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Blocks frame = new Blocks();
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
	public Blocks() {
		setFrameIcon(new ImageIcon("D:\\Chau_folder\\java\\prisoner_management\\src\\main\\resources\\image\\icon\\339885_jail_prison_icon.png"));
		setTitle("Block");
		setBounds(100, 100, 1100, 800);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1084, 670);
		getContentPane().add(tabbedPane);
		
		Block_Index = new JPanel();
		Block_Index.setLayout(null);
		tabbedPane.addTab("List", new ImageIcon("D:\\Chau_folder\\java\\prisoner_management\\src\\main\\resources\\image\\icon\\216422_list_th_icon.png"), Block_Index, null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1079, 566);
		Block_Index.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblStatusPage = new JLabel("Page 1 of 0");
		lblStatusPage.setBounds(20, 611, 100, 14);
		Block_Index.add(lblStatusPage);
		
		lblTotalOfRow = new JLabel("Rows count: 0");
		lblTotalOfRow.setBounds(969, 611, 100, 14);
		Block_Index.add(lblTotalOfRow);
		
		btnFirstButton = new JButton("First Button");
		btnFirstButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnFirstButton.setBounds(10, 577, 100, 23);
		Block_Index.add(btnFirstButton);
		
		btnPreviusButton = new JButton("Previus Button");
		btnPreviusButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnPreviusButton.setBounds(450, 577, 120, 23);
		Block_Index.add(btnPreviusButton);
		
		comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(230, 578, 100, 21);
		Block_Index.add(comboBox);
		
		btnNextButton = new JButton("Next Button");
		btnNextButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNextButton.setBounds(340, 577, 100, 23);
		Block_Index.add(btnNextButton);
		
		btnLastButton = new JButton("Last Button");
		btnLastButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnLastButton.setBounds(120, 577, 100, 23);
		Block_Index.add(btnLastButton);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(340, 608, 329, 20);
		Block_Index.add(textField);
		
		btnFind = new JButton("Find User");
		btnFind.setBounds(580, 577, 89, 23);
		Block_Index.add(btnFind);
		
		txtGetId = new JTextField();
		txtGetId.setColumns(10);
		txtGetId.setBounds(679, 578, 140, 22);
		Block_Index.add(txtGetId);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.setBounds(928, 577, 100, 23);
		Block_Index.add(btnShowAll);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(829, 577, 89, 23);
		Block_Index.add(btnDelete);
		
		Insert = new JPanel();
		Insert.setLayout(null);
		tabbedPane.addTab("Insert", new ImageIcon("D:\\Chau_folder\\java\\prisoner_management\\src\\main\\resources\\image\\icon\\216490_add_user_icon.png"), Insert, null);
		
		lblNewLabel = new JLabel("<html><span color=red style='font-size:80px;'>&#10133;_Insert User_&#10133;</span></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(36, 11, 1000, 216);
		Insert.add(lblNewLabel);
		
		lblGuardId = new JLabel("Guard Id:");
		lblGuardId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGuardId.setBounds(210, 396, 141, 25);
		Insert.add(lblGuardId);
		
		lblPrisonerId = new JLabel("Prisoner Id:");
		lblPrisonerId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrisonerId.setBounds(210, 360, 141, 25);
		Insert.add(lblPrisonerId);
		
		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(212, 251, 141, 25);
		Insert.add(lblName);
		
		lblCellRoom = new JLabel("Cell Room:");
		lblCellRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCellRoom.setBounds(212, 287, 141, 25);
		Insert.add(lblCellRoom);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(346, 257, 225, 19);
		Insert.add(txtName);
		
		txtP_Id = new JTextField();
		txtP_Id.setColumns(10);
		txtP_Id.setBounds(346, 366, 225, 19);
		Insert.add(txtP_Id);
		
		txtG_Id = new JTextField();
		txtG_Id.setColumns(10);
		txtG_Id.setBounds(346, 402, 225, 19);
		Insert.add(txtG_Id);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnNewButton.setBounds(569, 591, 128, 34);
		Insert.add(btnNewButton);
		
		lblSupervisionId = new JLabel("Interior Minister Id:");
		lblSupervisionId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSupervisionId.setBounds(120, 432, 231, 25);
		Insert.add(lblSupervisionId);
		
		txtS_Id = new JTextField();
		txtS_Id.setColumns(10);
		txtS_Id.setBounds(346, 438, 225, 19);
		Insert.add(txtS_Id);
		
		txtCellRoom = new JTextField();
		txtCellRoom.setBounds(346, 293, 225, 19);
		Insert.add(txtCellRoom);
		txtCellRoom.setColumns(10);
		
		btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_1ActionPerformed(e);
			}
		});
		btnDelete_1.setBounds(719, 591, 128, 34);
		Insert.add(btnDelete_1);
		
		lblIdWhenDel = new JLabel("Id when Del:");
		lblIdWhenDel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIdWhenDel.setBounds(210, 323, 141, 25);
		Insert.add(lblIdWhenDel);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(344, 329, 225, 19);
		Insert.add(txtId);
		
		Insert_1 = new JPanel();
		Insert_1.setLayout(null);
		tabbedPane.addTab("Update", new ImageIcon("D:\\Chau_folder\\java\\prisoner_management\\src\\main\\resources\\image\\icon\\7106354_reload_data_infographic_update_element_icon.png"), Insert_1, null);
		
		lblupdateUser = new JLabel("<html><span color=red style='font-size:80px;'>&#10133;_Update User_&#10133;</span></html>");
		lblupdateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblupdateUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblupdateUser.setBounds(36, 11, 1000, 216);
		Insert_1.add(lblupdateUser);
		
		lblGuardId_1 = new JLabel("Guard Id:");
		lblGuardId_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGuardId_1.setBounds(210, 396, 141, 25);
		Insert_1.add(lblGuardId_1);
		
		lblPrisonerId_1 = new JLabel("Prisoner Id:");
		lblPrisonerId_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrisonerId_1.setBounds(210, 360, 141, 25);
		Insert_1.add(lblPrisonerId_1);
		
		lblName_1 = new JLabel("Name:");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName_1.setBounds(212, 251, 141, 25);
		Insert_1.add(lblName_1);
		
		lblCellRoom_1 = new JLabel("Cell Room:");
		lblCellRoom_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCellRoom_1.setBounds(212, 287, 141, 25);
		Insert_1.add(lblCellRoom_1);
		
		txtUpdateName = new JTextField();
		txtUpdateName.setColumns(10);
		txtUpdateName.setBounds(346, 257, 225, 19);
		Insert_1.add(txtUpdateName);
		
		txtUpdateP_Id = new JTextField();
		txtUpdateP_Id.setColumns(10);
		txtUpdateP_Id.setBounds(346, 366, 225, 19);
		Insert_1.add(txtUpdateP_Id);
		
		txtUpdateG_Id = new JTextField();
		txtUpdateG_Id.setColumns(10);
		txtUpdateG_Id.setBounds(346, 402, 225, 19);
		Insert_1.add(txtUpdateG_Id);
		
		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(569, 591, 128, 34);
		Insert_1.add(btnNewButton_1);
		
		lblSupervisionId_1 = new JLabel("Interior Minister Id:");
		lblSupervisionId_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSupervisionId_1.setBounds(120, 432, 231, 25);
		Insert_1.add(lblSupervisionId_1);
		
		txtUpdateS_Id = new JTextField();
		txtUpdateS_Id.setColumns(10);
		txtUpdateS_Id.setBounds(346, 438, 225, 19);
		Insert_1.add(txtUpdateS_Id);
		
		txtUpdateCellRoom = new JTextField();
		txtUpdateCellRoom.setColumns(10);
		txtUpdateCellRoom.setBounds(346, 293, 225, 19);
		Insert_1.add(txtUpdateCellRoom);
		
		btnDelete_2 = new JButton("Delete");
		btnDelete_2.setBounds(719, 591, 128, 34);
		Insert_1.add(btnDelete_2);
		
		lblIdUpdate = new JLabel("Id Update:");
		lblIdUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIdUpdate.setBounds(210, 323, 141, 25);
		Insert_1.add(lblIdUpdate);
		
		txtUpdateId = new JTextField();
		txtUpdateId.setColumns(10);
		txtUpdateId.setBounds(344, 329, 225, 19);
		Insert_1.add(txtUpdateId);

	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		Block_Dao b = new Block_Dao();
		b.insertData(txtName.getText(), Integer.parseInt(txtCellRoom.getText()), Integer.parseInt(txtP_Id.getText()), Integer.parseInt(txtG_Id.getText()), Integer.parseInt(txtS_Id.getText()));
		JOptionPane.showMessageDialog(null, "Insert Successfully");
	}
	protected void btnDelete_1ActionPerformed(ActionEvent e) {
		Block_Dao b = new Block_Dao();
		b.deleteData(Integer.parseInt(txtId.getText()));
		JOptionPane.showMessageDialog(null, "Delete Successfully");
	}
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {//update
		Block_Dao b = new Block_Dao();
		b.UpdateData(txtUpdateName.getText(), Integer.parseInt(txtUpdateCellRoom.getText()), Integer.parseInt(txtUpdateP_Id.getText()), Integer.parseInt(txtUpdateG_Id.getText()), Integer.parseInt(txtUpdateS_Id.getText()), Integer.parseInt(txtUpdateId.getText()));
		JOptionPane.showMessageDialog(null, "Update Successfully");
	}
}
