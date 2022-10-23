package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class createe extends JInternalFrame {
	private static createe myInstance;
	
	public static createe getMyInstance() {
		if(myInstance == null) {
			myInstance = new createe(); //singleton
		}
		return myInstance;
	}

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JLabel lblNewLabel_1;
	private JPanel inforuser_Thongtintunhan;
	private JLabel lblDOB;
	private JTextField textDOB;
	private JLabel lblName;
	private JTextField textName;
	private JLabel lblGender;
	private JRadioButton btnMale;
	private JRadioButton btnFemale;
	private JLabel lblThngTinC;
	private JLabel lblcimNhn;
	private JTextField textId;
	private JPanel inforuser_HanhViToiPham;
	private JLabel lblHnhViTi;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnDelete;
	private JButton btnSubmit;
	private JLabel lblThuAn;
	private JLabel lblMDNH;
	private JLabel lblTienPhat;
	private JLabel lblHanhVi;
	private JTextField textMDNH;
	private JTextField textTienPhat;
	private JTextField textHanhVi;
	private JTextField textThuAn;
	private JLabel lblNgayVao;
	private JTextField textNgayVao;
	private JLabel lblNgayRa;
	private JTextField textNgayRa;
	private JPanel inforuser_SucKhoe;
	private JLabel lblChieuCao;
	private JLabel lblScKhe;
	private JLabel lblCanNang;
	private JLabel lblGhiCh;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblTnhTrngSc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createe frame = new createe();
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
	public createe() {
		setTitle("Create");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		lblNewLabel_1 = new JLabel("Thêm tù nhân");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		inforuser_HanhViToiPham = new JPanel();
		tabbedPane.addTab("Hành vi tội phạm", null, inforuser_HanhViToiPham, null);
		inforuser_HanhViToiPham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblHnhViTi = new JLabel("Hành vi tội phạm");
		lblHnhViTi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblThuAn = new JLabel("Thụ Án :");
		lblThuAn.setHorizontalAlignment(SwingConstants.LEFT);
		lblThuAn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblMDNH = new JLabel("Mức Độ Nguy Hiểm :");
		lblMDNH.setHorizontalAlignment(SwingConstants.LEFT);
		lblMDNH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblTienPhat = new JLabel("Tiền Phạt :");
		lblTienPhat.setHorizontalAlignment(SwingConstants.LEFT);
		lblTienPhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblHanhVi = new JLabel("Hành Vi :");
		lblHanhVi.setHorizontalAlignment(SwingConstants.LEFT);
		lblHanhVi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textMDNH = new JTextField();
		textMDNH.setColumns(10);
		
		textTienPhat = new JTextField();
		textTienPhat.setColumns(10);
		
		textHanhVi = new JTextField();
		textHanhVi.setColumns(10);
		
		textThuAn = new JTextField();
		textThuAn.setColumns(10);
		
		lblNgayVao = new JLabel("Ngày Vào :");
		lblNgayVao.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayVao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textNgayVao = new JTextField();
		textNgayVao.setColumns(10);
		
		lblNgayRa = new JLabel("Ngày Ra :");
		lblNgayRa.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayRa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textNgayRa = new JTextField();
		textNgayRa.setColumns(10);
		GroupLayout gl_inforuser_HanhViToiPham = new GroupLayout(inforuser_HanhViToiPham);
		gl_inforuser_HanhViToiPham.setHorizontalGroup(
			gl_inforuser_HanhViToiPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
					.addGap(342)
					.addComponent(lblHnhViTi, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
					.addGap(34)
					.addComponent(lblHanhVi, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(textHanhVi, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
					.addGap(34)
					.addComponent(lblTienPhat, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(textTienPhat, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
					.addGap(34)
					.addComponent(lblMDNH, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(textMDNH, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
					.addGap(34)
					.addComponent(lblThuAn, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(textThuAn, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNgayVao, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(textNgayVao, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNgayRa, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(textNgayRa, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
		);
		gl_inforuser_HanhViToiPham.setVerticalGroup(
			gl_inforuser_HanhViToiPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
					.addGap(11)
					.addComponent(lblHnhViTi)
					.addGap(51)
					.addGroup(gl_inforuser_HanhViToiPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHanhVi)
						.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
							.addGap(1)
							.addComponent(textHanhVi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_inforuser_HanhViToiPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTienPhat)
						.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
							.addGap(1)
							.addComponent(textTienPhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_inforuser_HanhViToiPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMDNH)
						.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
							.addGap(1)
							.addComponent(textMDNH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_inforuser_HanhViToiPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblThuAn)
						.addGroup(gl_inforuser_HanhViToiPham.createSequentialGroup()
							.addGap(1)
							.addComponent(textThuAn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_inforuser_HanhViToiPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNgayVao)
						.addComponent(textNgayVao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_inforuser_HanhViToiPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNgayRa)
						.addComponent(textNgayRa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		inforuser_HanhViToiPham.setLayout(gl_inforuser_HanhViToiPham);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnSubmit = new JButton("Gửi");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		inforuser_Thongtintunhan = new JPanel();
		tabbedPane.addTab("Thông tin tù nhân", null, inforuser_Thongtintunhan, null);
		inforuser_Thongtintunhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblDOB = new JLabel("Ngày Sinh:");
		lblDOB.setHorizontalAlignment(SwingConstants.LEFT);
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textDOB = new JTextField();
		textDOB.setColumns(10);
		
		lblName = new JLabel("Họ Và Tên:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textName = new JTextField();
		textName.setColumns(10);
		
		lblGender = new JLabel("Giới Tính:");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnMale = new JRadioButton("Nam");
		buttonGroup.add(btnMale);
		btnMale.setSelected(true);
		btnMale.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		btnFemale = new JRadioButton("Nữ");
		buttonGroup.add(btnFemale);
		btnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblThngTinC = new JLabel("Thông tin cá nhân tù nhân");
		lblThngTinC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblcimNhn = new JLabel("ID :");
		lblcimNhn.setHorizontalAlignment(SwingConstants.LEFT);
		lblcimNhn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textId = new JTextField();
		textId.setColumns(10);
		GroupLayout gl_inforuser_Thongtintunhan = new GroupLayout(inforuser_Thongtintunhan);
		gl_inforuser_Thongtintunhan.setHorizontalGroup(
			gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inforuser_Thongtintunhan.createSequentialGroup()
					.addGroup(gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_inforuser_Thongtintunhan.createSequentialGroup()
							.addGap(0)
							.addGroup(gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_inforuser_Thongtintunhan.createSequentialGroup()
									.addGap(71)
									.addGroup(gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblDOB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
										.addComponent(lblcimNhn, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
									.addGap(74)
									.addGroup(gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textId)
										.addComponent(textDOB)
										.addComponent(textName, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)))
								.addGroup(gl_inforuser_Thongtintunhan.createSequentialGroup()
									.addGap(350)
									.addComponent(lblThngTinC, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_inforuser_Thongtintunhan.createSequentialGroup()
							.addGap(133)
							.addComponent(lblGender)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMale, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFemale, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_inforuser_Thongtintunhan.setVerticalGroup(
			gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inforuser_Thongtintunhan.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThngTinC)
					.addGap(36)
					.addGroup(gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.BASELINE)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDOB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDOB, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblcimNhn, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_inforuser_Thongtintunhan.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMale)
						.addComponent(btnFemale, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		inforuser_Thongtintunhan.setLayout(gl_inforuser_Thongtintunhan);
		
		inforuser_SucKhoe = new JPanel();
		tabbedPane.addTab("Tình trạng sức khỏe", null, inforuser_SucKhoe, null);
		inforuser_SucKhoe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblChieuCao = new JLabel("Chiều Cao :");
		lblChieuCao.setHorizontalAlignment(SwingConstants.LEFT);
		lblChieuCao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblScKhe = new JLabel("Sức Khỏe :");
		lblScKhe.setHorizontalAlignment(SwingConstants.LEFT);
		lblScKhe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblCanNang = new JLabel("Cân Nặng :");
		lblCanNang.setHorizontalAlignment(SwingConstants.LEFT);
		lblCanNang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblGhiCh = new JLabel("Ghi Chú :");
		lblGhiCh.setHorizontalAlignment(SwingConstants.LEFT);
		lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		lblTnhTrngSc = new JLabel("Tình trạng sức khỏe");
		lblTnhTrngSc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_inforuser_SucKhoe = new GroupLayout(inforuser_SucKhoe);
		gl_inforuser_SucKhoe.setHorizontalGroup(
			gl_inforuser_SucKhoe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inforuser_SucKhoe.createSequentialGroup()
					.addGroup(gl_inforuser_SucKhoe.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_inforuser_SucKhoe.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_inforuser_SucKhoe.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_inforuser_SucKhoe.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblChieuCao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblScKhe, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
									.addComponent(lblCanNang, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
								.addComponent(lblGhiCh, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
							.addGap(74)
							.addGroup(gl_inforuser_SucKhoe.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
								.addComponent(textField_1)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_inforuser_SucKhoe.createSequentialGroup()
							.addGap(347)
							.addComponent(lblTnhTrngSc, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(278, Short.MAX_VALUE))
		);
		gl_inforuser_SucKhoe.setVerticalGroup(
			gl_inforuser_SucKhoe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inforuser_SucKhoe.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTnhTrngSc)
					.addGap(36)
					.addGroup(gl_inforuser_SucKhoe.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblScKhe))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_inforuser_SucKhoe.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChieuCao, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_inforuser_SucKhoe.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCanNang, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_inforuser_SucKhoe.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGhiCh, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		inforuser_SucKhoe.setLayout(gl_inforuser_SucKhoe);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(286)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(398)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
