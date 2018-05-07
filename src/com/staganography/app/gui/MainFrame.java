package com.staganography.app.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.staganography.app.common.ImageFilter;
import com.staganography.app.model.AES;
import com.staganography.app.model.Steganography;

public class MainFrame extends JFrame {
	
	private File fileImageInput;
	private File fileImageDecode;
	private Steganography model;

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
		
		model = new Steganography();
		
		
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
				fileImageInput = chooseImage(lbInput);
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
				fileImageDecode = chooseImage(lb_image_decode);
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
		String image = fileImageDecode.getPath();
		String stat_name = fileImageDecode.getName();
		String stat_path = fileImageDecode.getPath();
		stat_path = stat_path.substring(0,stat_path.length()-stat_name.length()-1);
		stat_name = stat_name.substring(0, stat_name.length()-4);
		String message = model.decode(stat_path, stat_name);
		
		String key = tf_password_decode.getText();
		String encrypted = "";
		encrypted = AES.decrypt(message, key);
		
		tf_hide_message.setText(encrypted);
		
		/*if(!message.equals(""))
		{
			JOptionPane.showMessageDialog(this, "The Image was decoded Successfully!", 
						"Success!", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else
		{
			JOptionPane.showMessageDialog(this, "The Image could not be decoded!", 
						"Error!", JOptionPane.INFORMATION_MESSAGE);
		}*/
	}

	protected void encode() {
		String text = tf_message.getText();
        String key = tf_password_encode.getText();
        String encrypted = "";
        try{
        	encrypted = AES.encrypt(text, key);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Mã hóa AES lỗi");
        }
		String ext  = ImageFilter.getExtension(fileImageInput);
		String name = fileImageInput.getName();
		String path = fileImageInput.getPath();
		path = path.substring(0,path.length()-name.length()-1);
		name = name.substring(0, name.length()-4);
		
		String stegan = JOptionPane.showInputDialog(this,
						"Enter output file name:", "File name",
						JOptionPane.PLAIN_MESSAGE);
		
		if(model.encode(path,name,ext,stegan,encrypted))
		{
			JOptionPane.showMessageDialog(this, "The Image was encoded Successfully!", 
				"Success!", JOptionPane.INFORMATION_MESSAGE);
			
			try {
				String fileName = path + "/" + stegan + ".png";
				showImage(lbOutput, fileName);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "The Image could not be encoded!", 
				"Error!", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	
	public File chooseImage(JLabel lbShow) {
		JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File f = fc.getSelectedFile();
        String filename = f.getAbsolutePath();
        showImage(lbShow, filename);
        return f;
	}
	
	public void showImage(JLabel lbShow, String path) {
		ImageIcon icon = new ImageIcon(path);
        Image newImg = icon.getImage();
        Image img = newImg.getScaledInstance(lbShow.getWidth(), lbShow.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        lbShow.setIcon(image);
	}
}
