package com.kinggm.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kinggm.model.User;

public class MainFrm extends JFrame {

	private JPanel contentPane;
    private static User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm(user);
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
	public MainFrm(User user) {
		
		
		setResizable(false);
		setTitle("\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u767B\u5F55\u6210\u529F");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u60A8\u767B\u5F55\u7684\u7528\u6237\u540D\u4E3A:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblpassword = new JLabel("\u5BC6\u7801\u4E3A(\u53EA\u663E\u793Apassword):");
		lblpassword.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel mainName = new JLabel("\u7528\u6237\u540D");
		mainName.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel mainPassword = new JLabel("\u5BC6\u7801");
		mainPassword.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnLogout = new JButton("\u9000\u51FA\u767B\u5F55");
		btnLogout.setFont(new Font("宋体", Font.PLAIN, 20));
		
		
		//设置显示登录的用户名和密码
		if(user==null) {
			
		}else {
			mainName.setText(user.getName());
			mainPassword.setText(user.getPassword());
		}
		
		
		//退出登录
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				LogOut(e);
				
				
				
				
				
				
				
			}

		
		});
		
		JButton btnModifyCode = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnModifyCode.setFont(new Font("宋体", Font.PLAIN, 20));
		btnModifyCode.addActionListener(new ActionListener() {
			
			
			// 修改密码
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
			}
			
			
			
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(299)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(146)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblpassword)
									.addGap(34)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(mainName, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addComponent(mainPassword, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(136)
							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(btnModifyCode)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(mainName))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(mainPassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblpassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(93)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModifyCode, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//设置窗体居中显示
		this.setLocationRelativeTo(null);
	}

	
	//退出登录
	
	private void LogOut(ActionEvent e) {
		// TODO Auto-generated method stub
		
		dispose();
		new LogOnFrm().setVisible(true);;
		
	}
	
	
}
