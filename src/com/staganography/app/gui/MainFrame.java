package com.staganography.app.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelEncode;
	private JPanel panelDecode;
	private JPanel panelImage;
	private JButton btn_choose_decode;
	private JLabel lblnhGiu;
	private JLabel lblMtKhu;
	private JTextField tf_password_decode;
	private JTextField tf_hide_message;
	private JButton btnDecode;
	private JLabel lb_image_decode;
	private JLabel lblTincGiu;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblnhInput;
	private JLabel lblnhOutput;
	private JButton btn_choose_encode;
	private JLabel lblTin;
	private JLabel lblMtKhu_1;
	private JTextField tf_message;
	private JTextField tf_password_encode;
	private JButton btnEncode;
	private JLabel lbInput;
	private JLabel lbOutput;

	public MainFrame() {
		setTitle("Ứng Dụng Giấu Tin Trong Ảnh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 684, 461);
		contentPane.add(tabbedPane);
		
		panelEncode = new JPanel();
		tabbedPane.addTab("Encode", null, panelEncode, null);
		panelEncode.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 11, 322, 256);
		panelEncode.add(panel);
		panel.setLayout(null);
		
		lbInput = new JLabel("");
		lbInput.setBounds(0, 0, 322, 256);
		panel.add(lbInput);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBounds(347, 11, 322, 256);
		panelEncode.add(panel_1);
		panel_1.setLayout(null);
		
		lbOutput = new JLabel("");
		lbOutput.setBounds(0, 0, 322, 256);
		panel_1.add(lbOutput);
		
		lblnhInput = new JLabel("Ảnh Input");
		lblnhInput.setBounds(135, 278, 60, 14);
		panelEncode.add(lblnhInput);
		
		lblnhOutput = new JLabel("Ảnh Output");
		lblnhOutput.setBounds(493, 278, 60, 14);
		panelEncode.add(lblnhOutput);
		
		btn_choose_encode = new JButton("Chọn ảnh");
		btn_choose_encode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseImageEncode();
			}
		});
		btn_choose_encode.setBounds(113, 303, 89, 23);
		panelEncode.add(btn_choose_encode);
		
		lblTin = new JLabel("Tin:");
		lblTin.setBounds(10, 357, 46, 14);
		panelEncode.add(lblTin);
		
		lblMtKhu_1 = new JLabel("Mật khẩu:");
		lblMtKhu_1.setBounds(10, 388, 60, 14);
		panelEncode.add(lblMtKhu_1);
		
		tf_message = new JTextField();
		tf_message.setBounds(77, 354, 255, 20);
		panelEncode.add(tf_message);
		tf_message.setColumns(10);
		
		tf_password_encode = new JTextField();
		tf_password_encode.setColumns(10);
		tf_password_encode.setBounds(77, 385, 255, 20);
		panelEncode.add(tf_password_encode);
		
		btnEncode = new JButton("Giấu tin");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				encode();
			}
		});
		btnEncode.setBounds(471, 353, 89, 49);
		panelEncode.add(btnEncode);
		
		panelDecode = new JPanel();
		panelDecode.setToolTipText("Nhập mật khẩu");
		tabbedPane.addTab("Decode", null, panelDecode, null);
		panelDecode.setLayout(null);
		
		panelImage = new JPanel();
		panelImage.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelImage.setBounds(10, 11, 414, 262);
		panelDecode.add(panelImage);
		panelImage.setLayout(null);
		
		lb_image_decode = new JLabel("");
		lb_image_decode.setBounds(0, 0, 414, 262);
		panelImage.add(lb_image_decode);
		
		btn_choose_decode = new JButton("Chọn ảnh");
		btn_choose_decode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseImageDecode();
			}
		});
		btn_choose_decode.setBounds(165, 309, 89, 23);
		panelDecode.add(btn_choose_decode);
		
		lblnhGiu = new JLabel("Ảnh đã giấu tin");
		lblnhGiu.setBounds(175, 284, 89, 14);
		panelDecode.add(lblnhGiu);
		
		lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setBounds(10, 378, 62, 14);
		panelDecode.add(lblMtKhu);
		
		tf_password_decode = new JTextField();
		tf_password_decode.setBounds(74, 375, 180, 20);
		panelDecode.add(tf_password_decode);
		tf_password_decode.setColumns(10);
		
		tf_hide_message = new JTextField();
		tf_hide_message.setEditable(false);
		tf_hide_message.setBounds(479, 11, 190, 262);
		panelDecode.add(tf_hide_message);
		tf_hide_message.setColumns(10);
		
		btnDecode = new JButton("Lấy tin giấu");
		btnDecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decode();
			}
		});
		btnDecode.setBounds(335, 374, 89, 23);
		panelDecode.add(btnDecode);
		
		lblTincGiu = new JLabel("Tin được giấu");
		lblTincGiu.setBounds(550, 284, 64, 14);
		panelDecode.add(lblTincGiu);
	}

	protected void decode() {
		
	}

	protected void chooseImageDecode() {
		
	}

	protected void encode() {
		
	}

	protected void chooseImageEncode() {
		
		
	}
}
