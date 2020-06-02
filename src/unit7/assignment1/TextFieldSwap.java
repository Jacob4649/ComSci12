package unit7.assignment1;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

//@formatter:off

/*
* Jacob Klimczak
* Text Fields Assignment, Swap Question
* May 29, 2020
* ICS4U0
* 
* This program represents my own program code.
* I have not received any help in designing, writing, or debugging this program.
*/

//@formatter:on

public class TextFieldSwap {

	private JFrame m_frame;
	private JTextField m_field1;
	private JTextField m_field2;
	private Component m_midStrut;
	private Component m_topStrut;
	private JButton m_swapButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextFieldSwap window = new TextFieldSwap();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TextFieldSwap() {
		// Setup JFrame
		m_frame = new JFrame();
		m_frame.setBounds(100, 100, 450, 300);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_frame.setTitle("Text Swap App");
		m_frame.getContentPane().setLayout(new BoxLayout(m_frame.getContentPane(), BoxLayout.Y_AXIS));

		// Setup Top Strut
		m_topStrut = Box.createVerticalStrut(20);
		m_frame.getContentPane().add(m_topStrut);

		// Setup First Text Field
		m_field1 = new JTextField("Text Field 1 - Press The Button To Swap The Content Of These Two Text Fields");
		m_frame.getContentPane().add(m_field1);
		m_field1.setColumns(10);

		// Setup Middle Strut
		m_midStrut = Box.createVerticalStrut(20);
		m_frame.getContentPane().add(m_midStrut);

		// Setup Second Text Field
		m_field2 = new JTextField("Text Field 2 - Press The Button To Swap The Content Of These Two Text Fields");
		m_frame.getContentPane().add(m_field2);
		m_field2.setColumns(10);

		// Setup Swap Button
		m_swapButton = new JButton("Swap");
		m_frame.getContentPane().add(m_swapButton);
		m_swapButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Swap Button Click Listener
		m_swapButton.addActionListener((performedAction) -> {
			// Swaps Strings
			String temp = m_field1.getText();
			m_field1.setText(m_field2.getText());
			m_field2.setText(temp);
		});

		// Show Frame
		m_frame.setVisible(true);
	}

}
