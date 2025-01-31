package ui;

import javax.swing.JComponent;

import def.Worker;
import management.UsageCheck;

import java.awt.Color;
import java.awt.Graphics;
import management.WorkerResManager;

public class MainStatusView extends JComponent {
	private static MainStatusView mainStatusView = new MainStatusView();
	private WorkerResManager workerResManager;

	public MainStatusView() {
		System.out.println("[MainStatusView.java] MainStatusView()");
		workerResManager = WorkerResManager.getInstance();
		this.setLocation(200, 300);
		this.setSize(200, 200);
		this.setVisible(true);
	}

	public static MainStatusView getInstance() {
		return mainStatusView;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		paintBackground(g);
	}

	private void paintBackground(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 130);
		// 하얀색 네모칸

		g.setColor(Color.gray);
		g.drawRect(0, 0, 199, 129);
		// 회색 네모 테두리

		g.setColor(Color.BLACK);
		g.drawString("PC Name : " + workerResManager.getHOST_NAME(), 10, 20);
		g.drawString("Local IP : " + workerResManager.getIP(), 10, 40);
		g.drawString("CPU USAGE : " + workerResManager.getCPU_USAGE() + " %", 10, 60);
		g.drawString("CPU CAPA : " + workerResManager.getCPU_CAPA() + " ms", 10, 80);
		g.drawString("Memory USAGE : " + workerResManager.getMEMORY_USAGE() + " GB", 10, 100);
		g.drawString("Memory CAPA : " + workerResManager.getMEMORY_CAPA() + " GB", 10, 120);

		this.repaint();
	}

}
