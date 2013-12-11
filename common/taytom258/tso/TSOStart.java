package taytom258.tso;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import taytom258.window.Window2;

public class TSOStart {
	
	public static void buildPanel(){
		
		JPanel action = Window2.getPanel_Action();
		
		JPanel panel_Start = new JPanel();
		panel_Start.setLayout(null);
		action.add(panel_Start, "panel_Start");
		
		JCheckBox checkBox_Sams = new JCheckBox("Sams?");
		checkBox_Sams.setBounds(8, 33, 65, 24);
		panel_Start.add(checkBox_Sams);
		
		JCheckBox checkBox_Analog = new JCheckBox("Analog?");
		checkBox_Analog.setBounds(8, 61, 71, 24);
		panel_Start.add(checkBox_Analog);
		
		JCheckBox checkBox_Pass = new JCheckBox("Passthrough?");
		checkBox_Pass.setBounds(8, 89, 105, 24);
		panel_Start.add(checkBox_Pass);
		
		JToggleButton toggleButton_Chf = new JToggleButton("CHF Creation Active");
		toggleButton_Chf.setBounds(140, 47, 145, 26);
		panel_Start.add(toggleButton_Chf);
		
		final JTextField textField_DataRate = new JTextField();
		textField_DataRate.setColumns(10);
		textField_DataRate.setBounds(171, 125, 114, 20);
		panel_Start.add(textField_DataRate);
		textField_DataRate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == 1){
					e.getComponent().requestFocus();
					textField_DataRate.selectAll();
				}else if(e.isPopupTrigger()){
					e.getComponent().requestFocus();
					Window2.popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		JLabel label_DataRate = new JLabel("Data Rate");
		label_DataRate.setBounds(12, 127, 55, 16);
		panel_Start.add(label_DataRate);
		
		final JTextField textField_SvcAvail = new JTextField();
		textField_SvcAvail.setColumns(10);
		textField_SvcAvail.setBounds(171, 157, 114, 20);
		panel_Start.add(textField_SvcAvail);
		textField_SvcAvail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == 1){
					e.getComponent().requestFocus();
					textField_SvcAvail.selectAll();
				}else if(e.isPopupTrigger()){
					e.getComponent().requestFocus();
					Window2.popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		JLabel label_SvcAvail = new JLabel("Service Availability");
		label_SvcAvail.setBounds(12, 159, 106, 16);
		panel_Start.add(label_SvcAvail);
		
		JLabel label_Tsp = new JLabel("TSP");
		label_Tsp.setBounds(12, 189, 23, 16);
		panel_Start.add(label_Tsp);
		
		JComboBox comboBox_Tsp = new JComboBox();
		comboBox_Tsp.setBounds(171, 185, 114, 25);
		String[] list = {"TSP 1", "TSP 2", "TSP 3", "TSP 4", "TSP 5", "NA"};
		for(String element : list){
			comboBox_Tsp.addItem(element);
		}
		panel_Start.add(comboBox_Tsp);
		
		JLabel label_Tsr = new JLabel("TSR Number");
		label_Tsr.setBounds(12, 222, 71, 16);
		panel_Start.add(label_Tsr);
		
		JLabel label_RptDate = new JLabel("Report Date");
		label_RptDate.setBounds(12, 252, 67, 16);
		panel_Start.add(label_RptDate);
		
		final JTextField textField_Tsr = new JTextField();
		textField_Tsr.setColumns(10);
		textField_Tsr.setBounds(171, 220, 114, 20);
		panel_Start.add(textField_Tsr);
		textField_Tsr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == 1){
					e.getComponent().requestFocus();
					textField_Tsr.selectAll();
				}else if(e.isPopupTrigger()){
					e.getComponent().requestFocus();
					Window2.popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		final JTextField textField_RptDate = new JTextField();
		textField_RptDate.setColumns(10);
		textField_RptDate.setBounds(171, 250, 114, 20);
		panel_Start.add(textField_RptDate);
		textField_RptDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == 1){
					e.getComponent().requestFocus();
					textField_RptDate.selectAll();
				}else if(e.isPopupTrigger()){
					e.getComponent().requestFocus();
					Window2.popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		JPanel panel_TsoState = new JPanel();
		panel_TsoState.setLayout(null);
		panel_TsoState.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "TSO Statement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TsoState.setBounds(8, 282, 283, 113);
		panel_Start.add(panel_TsoState);
		
		final JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setToolTipText("Enter Extra Comments Here");
		textArea.setLineWrap(true);
		textArea.setBounds(12, 23, 259, 78);
		panel_TsoState.add(textArea);
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == 1){
					e.getComponent().requestFocus();
					textArea.selectAll();
				}else if(e.isPopupTrigger()){
					e.getComponent().requestFocus();
					Window2.popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		JCheckBox checkBox_1539 = new JCheckBox("1539 Circuit?");
		checkBox_1539.setBounds(8, 8, 112, 24);
		panel_Start.add(checkBox_1539);	
	}
}
