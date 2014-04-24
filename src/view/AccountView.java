package view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class AccountView {
	
	public AccountView(){
		initComponents();
	}
	
	public void initComponents(){
		JFrame jframe = new JFrame();
		jframe.setSize(new Dimension(250, 250));
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
}
