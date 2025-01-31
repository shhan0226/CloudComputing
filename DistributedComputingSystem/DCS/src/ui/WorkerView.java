package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import def.viewData;
import management.WorkerResManager;

public class WorkerView extends JPanel implements ActionListener {
	private static WorkerView workerView = new WorkerView();
	private MainStatusView mainStatusView;
	private WorkerResManager workerResManager;

	private JButton connect_btn, cancel_btn;
	private JLabel ip_lb, port_lb;
	private JTextField iP_tf, port_tf;

	public WorkerView() {
		System.out.println("[WorkerView.java] WorkerView()");
		this.setLayout(null);
		this.setLocation(150, 10);
		this.setSize(viewData.SUB_WIDTH, viewData.SUB_HEIGHT);

		initializeComponent();

	}

	public void initializeComponent() {
		workerResManager = WorkerResManager.getInstance();	
		mainStatusView = MainStatusView.getInstance();	

		ip_lb = new JLabel("Server IP : ");
		ip_lb.setBounds(0, 50, 80, 25);
		this.add(ip_lb);

		iP_tf = new JTextField(workerResManager.getIP());
		iP_tf.setBounds(80, 50, 100, 25);
		iP_tf.setFocusable(true);
		this.add(iP_tf);

		port_lb = new JLabel("Server Port : ");
		port_lb.setBounds(0, 80, 80, 25);
		this.add(port_lb);

		port_tf = new JTextField("32000");
		port_tf.setBounds(80, 80, 100, 25);
		port_tf.setFocusable(true);
		this.add(port_tf);

		connect_btn = new JButton("Connect");
		connect_btn.setBounds(180, 50, 100, 25);
		connect_btn.addActionListener(this);
		connect_btn.setFocusable(false);
		this.add(connect_btn);

		cancel_btn = new JButton("Cancel..");
		cancel_btn.setBounds(180, 80, 100, 25);
		cancel_btn.addActionListener(this);
		cancel_btn.setFocusable(false);
		cancel_btn.setEnabled(false);
		this.add(cancel_btn);

	}

	public static WorkerView getInstance() {
		return workerView;
	}

	public void WorkerViewOn(){			
		mainStatusView.setVisible(true);
		mainStatusView.setLocation(200,120);		
	}
	
	public void WorkerViewOff(){				
		ip_lb.setVisible(false);
		iP_tf.setVisible(false);
		port_lb.setVisible(false);
		port_tf.setVisible(false);
		connect_btn.setVisible(false);
		cancel_btn.setVisible(false);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(connect_btn)) {
			System.out.println("[WorkerView.java] Connet Server !");
			connect_btn.setEnabled(false);
			cancel_btn.setEnabled(true);			
			workerResManager.ConnectToServer();
			
			
		} else if (e.getSource().equals(cancel_btn)) {
			System.out.println("[WorkerView.java] Connet Cancel...");
			connect_btn.setEnabled(true);
			cancel_btn.setEnabled(false);
			workerResManager.disconnectServer();
			
		}

	}

}
