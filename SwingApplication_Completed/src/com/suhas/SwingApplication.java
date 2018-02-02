package com.suhas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwingApplication {

	private JFrame frame;
	private JTextField txtGrandTotal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtGrandTotal() {
		return txtGrandTotal;
	}

	public void setTxtGrandTotal(JTextField txtGrandTotal) {
		this.txtGrandTotal = txtGrandTotal;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	/**
	 * Launch the application.
	 */
	
	private Timer t = null;
	private int count = 0;
	
	
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApplication window = new SwingApplication();
					window.frame.setVisible(true);
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setText("0");
		editorPane.setBounds(386, 37, 43, 16);
		frame.getContentPane().add(editorPane);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setText("0");
		editorPane_2.setBounds(387, 103, 42, 16);
		frame.getContentPane().add(editorPane_2);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setText("0");
		editorPane_1.setBounds(386, 77, 43, 16);
		frame.getContentPane().add(editorPane_1);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setText("0");
		editorPane_3.setBounds(386, 138, 43, 16);
		frame.getContentPane().add(editorPane_3);
		
		
		// Progress bar Begin	
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(47, 27, 334, 38);
		frame.getContentPane().add(progressBar);
		
	
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(47, 68, 334, 29);
		frame.getContentPane().add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(47, 103, 334, 23);
		frame.getContentPane().add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(47, 138, 334, 32);
		frame.getContentPane().add(progressBar_3);		
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(6, 226, 97, 29);
		
		

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnStart);
		
		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(99, 226, 89, 29);
		frame.getContentPane().add(btnPause);
		
		
		JButton btnResume = new JButton("Resume");
		btnResume.setBounds(184, 226, 97, 29);
		frame.getContentPane().add(btnResume);
		
		
		JEditorPane dtrpnThreadTestApplication = new JEditorPane();
		dtrpnThreadTestApplication.setBounds(122, 6, 170, 16);
		dtrpnThreadTestApplication.setText("Thread Test Application");
		frame.getContentPane().add(dtrpnThreadTestApplication);
		
		txtGrandTotal = new JTextField();
		txtGrandTotal.setBounds(279, 226, 130, 26);
		txtGrandTotal.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				
				
			}
		});
		txtGrandTotal.setText("Grand Total:");
		frame.getContentPane().add(txtGrandTotal);
		txtGrandTotal.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(6, 27, 29, 26);
		textField.setText("1");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 68, 29, 23);
		textField_1.setText("2");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(6, 100, 29, 26);
		textField_2.setText("3");
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(6, 144, 29, 23);
		textField_3.setText("4");
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
	 MyThread1 t1 = new MyThread1(10, progressBar, editorPane, txtGrandTotal);
	 MyThread1 t2 = new MyThread1(20, progressBar_1, editorPane_1, txtGrandTotal);
	 MyThread1 t3 = new MyThread1(30, progressBar_2,editorPane_2, txtGrandTotal);
	 MyThread1 	 t4 = new MyThread1(40, progressBar_3,editorPane_3,  txtGrandTotal);
	
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setStart();
				t2.setStart();
				t3.setStart();
				t4.setStart();
				btnStart.setEnabled(false);
				
				
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setPause();
				t2.setPause();
				t3.setPause();
				t4.setPause();
			}
		});
		
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setResume();
				t2.setResume();
				t3.setResume();
				t4.setResume();
			}
		});
	}
	
	
}


