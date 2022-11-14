package gui;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.entity_Supervision;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupervisionsUI extends JInternalFrame {
	private JPanel panel;
	private JTable table;
	private JTextField textID;
	private JTextField textImage;
	private JTextField textDob;
	private JTextField textGender;
	private JTextField textName;
	private JLabel lblNewLabel;
	private JLabel lblImage;
	private JLabel lblName;
	private JLabel lblDob;
	private JLabel lblGender;
	private JLabel lblLevel;
	private JComboBox comboBoxlLevel;
	private JButton btnXacnhan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupervisionsUI frame = new SupervisionsUI();
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
	public SupervisionsUI() {
		setBounds(100, 100, 1020, 791);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1011, 761);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		
		DefaultTableModel data = new DefaultTableModel();
		data.addColumn("ID");
		data.addColumn("Image");
		data.addColumn("Name");
		data.addColumn("Gender");
		data.addColumn("Dob");
		data.addColumn("Level");
		
		Vector hangX = new Vector<>();
		
		entity_Supervision sp = new entity_Supervision("1","anh1","Toan","1","19/05/2003","3");
		
		hangX.add(sp.getID());
		hangX.add(sp.getImage());
		hangX.add(sp.getName());
		hangX.add(sp.getGender());
		hangX.add(sp.getDob());
		hangX.add(sp.getLevel());
		data.addRow(hangX);
		
		hangX = new Vector<>();
		sp = new entity_Supervision("2","anh2","Chau","1","13/02/2003","1");
		
		hangX.add(sp.getID());
		hangX.add(sp.getImage());
		hangX.add(sp.getName());
		hangX.add(sp.getGender());
		hangX.add(sp.getDob());
		hangX.add(sp.getLevel());
		data.addRow(hangX);
		
		table.setModel(data);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.setBounds(0, 48, 1001, 343);
		panel.add(table);
		
		textID = new JTextField();
		textID.setBounds(47, 435, 170, 41);
		panel.add(textID);
		textID.setColumns(10);
		
		textImage = new JTextField();
		textImage.setColumns(10);
		textImage.setBounds(293, 435, 170, 41);
		panel.add(textImage);
		
		textDob = new JTextField();
		textDob.setColumns(10);
		textDob.setBounds(47, 596, 170, 41);
		panel.add(textDob);
		
		textGender = new JTextField();
		textGender.setColumns(10);
		textGender.setBounds(293, 517, 170, 41);
		panel.add(textGender);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(47, 517, 170, 41);
		panel.add(textName);
		
		lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(81, 402, 104, 21);
		panel.add(lblNewLabel);
		
		lblImage = new JLabel("Image");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(328, 402, 104, 21);
		panel.add(lblImage);
		
		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(81, 487, 104, 21);
		panel.add(lblName);
		
		lblDob = new JLabel("Dob");
		lblDob.setHorizontalAlignment(SwingConstants.CENTER);
		lblDob.setBounds(81, 569, 104, 21);
		panel.add(lblDob);
		
		lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(328, 487, 104, 21);
		panel.add(lblGender);
		
		lblLevel = new JLabel("Level");
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setBounds(328, 569, 104, 21);
		panel.add(lblLevel);
		
		comboBoxlLevel = new JComboBox();
		comboBoxlLevel.setModel(new DefaultComboBoxModel(new String[] {"1 đại ca", "2 đàn em", "3 lính lác"}));
		comboBoxlLevel.setBounds(293, 596, 170, 41);
		panel.add(comboBoxlLevel);
		
		btnXacnhan = new JButton("Xác nhận");
		btnXacnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacnhanActionPerformed(e);
			}
		});
		btnXacnhan.setFont(new Font("MV Boli", Font.BOLD, 15));
		btnXacnhan.setBounds(163, 669, 164, 54);
		panel.add(btnXacnhan);

	}
	protected void btnXacnhanActionPerformed(ActionEvent e) {
		String id = textID.getText();
		String image = textImage.getText();
		String name = textName.getText();
		String gender = textGender.getText();
		String dob = textDob.getText();
		Toolkit level = comboBoxlLevel.getToolkit();
		Vector hangX = new Vector<>();
		hangX.add(id);
		hangX.add(image);
		hangX.add(name);
		hangX.add(gender);
		hangX.add(dob);
		hangX.add(level);
		
		data.addRow(hangX);
	}
}
