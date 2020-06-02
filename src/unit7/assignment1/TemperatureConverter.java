package unit7.assignment1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;

//@formatter:off

/*
* Jacob Klimczak
* Text Fields Assignment, Converter Question
* May 29, 2020
* ICS4U0
* 
* This program represents my own program code.
* I have not received any help in designing, writing, or debugging this program.
*/

//@formatter:on

public class TemperatureConverter {

	private JFrame m_frame;
	private JTextField m_inputTemperature;
	private JSplitPane m_unitSelector;
	private JLabel m_inputLabel;
	private Component m_topStrut;
	private Component m_bottomStrut;
	private JButton m_celsiusButton;
	private JButton m_farenheightButton;
	private JLabel m_output;

	private boolean m_convertToCelsius = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemperatureConverter window = new TemperatureConverter();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TemperatureConverter() {
		// Setup JFrame
		m_frame = new JFrame();
		m_frame.setBounds(100, 100, 450, 300);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_frame.getContentPane().setLayout(new BoxLayout(m_frame.getContentPane(), BoxLayout.Y_AXIS));

		// Setup Temperature Input Instructions
		m_inputLabel = new JLabel(getInputString());
		m_inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_frame.getContentPane().add(m_inputLabel);

		// Setup Temperature Input Field
		m_inputTemperature = new JTextField();
		m_frame.getContentPane().add(m_inputTemperature);
		m_inputTemperature.setColumns(10);

		// Temperature Input Field Input Listener
		m_inputTemperature.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent event) {

			}

			@Override
			public void keyReleased(KeyEvent event) {

			}

			@Override
			public void keyTyped(KeyEvent event) {
				try {
					double inputTemperature = Double.parseDouble(m_inputTemperature.getText() + event.getKeyChar());
					double outputTemperature = (m_convertToCelsius ? (inputTemperature - 32d) * (5d/9d) : inputTemperature * (9d/5d) + 32d);
					m_output.setText(outputTemperature + " Degrees " + (m_convertToCelsius ? "Celsius" : "Farenheight"));	
				} catch (NumberFormatException e) {
					m_output.setText("PLEASE ENTER A VALID TEMPERATURE");	
				}
			}
		});

		// Setup Celsius Button
		m_celsiusButton = new JButton("Celsius");
		m_celsiusButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Celsius Button Click Listener
		m_celsiusButton.addActionListener((performedAction) -> {
			m_convertToCelsius = false;
			m_inputLabel.setText(getInputString());
			try {
				double inputTemperature = Double.parseDouble(m_inputTemperature.getText());
				double outputTemperature = (m_convertToCelsius ? (inputTemperature - 32d) * (5d/9d) : inputTemperature * (9d/5d) + 32d);
				m_output.setText(outputTemperature + " Degrees " + (m_convertToCelsius ? "Celsius" : "Farenheight"));	
			} catch (NumberFormatException e) {
				m_output.setText("PLEASE ENTER A VALID TEMPERATURE");	
			}
		});

		// Setup Farenheight Button
		m_farenheightButton = new JButton("Farenheight");
		m_farenheightButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Farenheight Button Click Listener
		m_farenheightButton.addActionListener((performedAction) -> {
			m_convertToCelsius = true;
			m_inputLabel.setText(getInputString());
			try {
				double inputTemperature = Double.parseDouble(m_inputTemperature.getText());
				double outputTemperature = (m_convertToCelsius ? (inputTemperature - 32d) * (5d/9d) : inputTemperature * (9d/5d) + 32d);
				m_output.setText(outputTemperature + " Degrees " + (m_convertToCelsius ? "Celsius" : "Farenheight"));	
			} catch (NumberFormatException e) {
				m_output.setText("PLEASE ENTER A VALID TEMPERATURE");	
			}
		});

		// Setup Unit Selector Split Pane, Anonymously Extend JSplitPane
		// Overriding `validate` Method For Automatic JSplitPane Resizing
		m_unitSelector = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, m_celsiusButton, m_farenheightButton) {
			@Override
			public void validate() {
				super.validate(); // Call superclass validate
				setDividerLocation(0.5); // Set Divider To 50%
			}
		};
		m_unitSelector.setAlignmentY(Component.CENTER_ALIGNMENT);
		m_unitSelector.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_frame.getContentPane().add(m_unitSelector);
		m_unitSelector.setEnabled(false);

		// Setup Top Strut
		m_topStrut = Box.createVerticalStrut(20);
		m_frame.getContentPane().add(m_topStrut);

		// Setup Output Label
		m_output = new JLabel("PLEASE ENTER A VALID TEMPERATURE");
		m_output.setFont(new Font("Tahoma", Font.PLAIN, 18));
		m_output.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_frame.getContentPane().add(m_output);

		// Setup Bottom Strut
		m_bottomStrut = Box.createVerticalStrut(20);
		m_frame.getContentPane().add(m_bottomStrut);

		// Show Frame
		m_frame.setVisible(true);

		// Set Initial Divider Width
		m_unitSelector.setDividerLocation(0.5);
	}

	/**
	 * 
	 * @return The {@link String} to display in the input {@link JLabel}
	 */
	private String getInputString() {
		return "Input A Temperature In " + (m_convertToCelsius ? "Farenheight" : "Celsius");
	}

}
