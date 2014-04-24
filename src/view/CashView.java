package view;

import java.awt.Dimension;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class CashView {
	private JPanel cashPanel;
	private JTextField cashField;
	private JButton btnEnter;
	private JComboBox currencyBox;

	public CashView(){
		JFrame jframe = new JFrame();
		jframe.setSize(new Dimension(250,150));
		jframe.setVisible(true);
		jframe.getContentPane().setLayout(null);
		
		cashPanel = new JPanel();
		cashPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enter Amount", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		cashPanel.setBounds(10, 11, 214, 90);
		jframe.getContentPane().add(cashPanel);
		cashPanel.setLayout(null);
		
		cashField = new JTextField();
		cashField.setBounds(81, 21, 123, 20);
		cashPanel.add(cashField);
		cashField.setColumns(10);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(61, 52, 89, 23);
		cashPanel.add(btnEnter);
		
		Object[] currencies = {"PHP", "USD", "SGD", "YEN"};
		Arrays.sort(currencies);
		currencyBox = new JComboBox(currencies);
		currencyBox.setBounds(10, 21, 61, 20);
		cashPanel.add(currencyBox);
		
	}
	
	public JButton getBtnEnter(){
		return btnEnter;
	}
	
	public JPanel getCashPanel(){
		return cashPanel;
	}
	
	public JTextField getCashField(){
		return cashField;
	}
}
