package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data.Contants;
import management.PerformanceUsage;

public class MainView extends JFrame {

	private JPanel jp = null;

	private StatusView statusView;

	public MainView() {

		this.setContentPane(getJContentPane());
		this.setBounds(0, 0, Contants.FRAME_WIDTH, Contants.FRAME_HEIGHT);
		this.setTitle("GUI Performance");

		initializeComponent();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

		this.setResizable(false); // 사용자가 사이즈 크기 재설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		PerformanceUsage update = new PerformanceUsage();
		update.startUpdate();
	}

	public JPanel getJContentPane() {
		if (jp == null) {
			jp = new JPanel();
			jp.setLayout(null);
		}

		return jp;
	}

	public void initializeComponent() {
		statusView = StatusView.getInstance();
		this.add(statusView);

	}

}
