package com.oracle.csc342.team3.problems;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class MainWindow extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JButton goButton;
	JTextArea resultsArea;
	JScrollPane scrollPane;
	JComboBox<String> reportSelector;
	
	private		TableManagementPanel	tableManagementPanel;
	private		JPanel		runReportsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setHostname("localhost");
		setPort("1521");
		setSid("CSC342");
		setId("system");
		setPwrd("9872598725");
		
		try {
			getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String hostname;
	static String port;
	static String sid;
	static String id;
	static String pwrd;

	public String getHostname() {
		return hostname;
	}

	public static void setHostname(String inHostname) {
		hostname = inHostname;
	}

	public String getPort() {
		return port;
	}

	public static void setPort(String inPort) {
		port = inPort;
	}

	public String getSid() {
		return sid;
	}

	public static void setSid(String inSid) {
		sid = inSid;
	}

	public String getId() {
		return id;
	}

	public static void setId(String inId) {
		id = inId;
	}

	public String getPwrd() {
		return pwrd;
	}

	public static void setPwrd(String inPwrd) {
		pwrd = inPwrd;
	}
	
	public static void getConnection() throws SQLException, Exception{
		Connection conn;
		conn = DBConnect.getConnection(hostname, port, sid, id, pwrd);
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		createTableManagementPanel();
		createRunReportsPanel();
		
		tabbedPane.addTab("Reports", runReportsPanel);
		tabbedPane.addTab("Table Management", tableManagementPanel);
	}
	
	public void createTableManagementPanel(){
		tableManagementPanel = new TableManagementPanel();
	}
	
	public void createRunReportsPanel(){
		
		runReportsPanel = new JPanel();
		runReportsPanel.setLayout( new FlowLayout( 3, 2, 2 ) );

		String[] reportNames = {"Report 1", "Report 2", "Salary By Skills", "Complaint Count By Product"};
		reportSelector = new JComboBox<String>(reportNames);
		runReportsPanel.add(reportSelector);
		
		goButton = new JButton("GO!");
		goButton.addActionListener(this);
		runReportsPanel.add(goButton);
		
		resultsArea = new JTextArea(30,50);
		scrollPane = new JScrollPane (resultsArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		runReportsPanel.add(scrollPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == goButton){
			// if "Report 1" is selected
			if(reportSelector.getSelectedIndex() == 0){
				ReportsDAO report = new ReportsDAO();
				String results = null;
				try {
					results = (report.getSkillSummary()).toString();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultsArea.setText(results);
			}
			
			// if "Report 2" is selected
			else if (reportSelector.getSelectedIndex() == 1){
				Reports2DAO report = new Reports2DAO();
				String results = null;
				try {
					results = (report.getSkillSummary()).toString();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultsArea.setText(results);
			}
			
			// if "Salary By Skills" is selected
			else if (reportSelector.getSelectedIndex() == 2){
				ReportSalaryBySkillDAO report = new ReportSalaryBySkillDAO();
				String results = null;
				try {
					results = (report.getSkillSummary()).toString();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultsArea.setText(results);	
			}
			// if "Complaint Count By Product" is selected
			else if (reportSelector.getSelectedIndex() == 3){
				ReportProductComplaintsDAO report = new ReportProductComplaintsDAO();
				String results = null;
				try {
					results = (report.getSkillSummary()).toString();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultsArea.setText(results);	
			}
		}
		
	}

}
