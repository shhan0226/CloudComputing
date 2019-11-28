package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import data.Contants;
import management.Worker_Manager;

public class StatusView extends JComponent {

	private static StatusView statusView = new StatusView();
	private Worker_Manager worker_manager;

	public StatusView() {
		worker_manager = Worker_Manager.getInstance();
		this.setLocation(20, 20);
		this.setSize(Contants.STATUS_WIDHT, Contants.STATUS_HEIGHT);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		paintBackground(g);
	}

	private void paintBackground(Graphics g) {
		worker_manager.baseWorkerInfor();

		// 하얀색 사각형 그리기
		g.setColor(Color.WHITE);
		g.fillRect(10, 10, Contants.STATUS_WIDHT - 20, 60);

		// 하얀색 사각형 안에 글씨 넣기
		g.setColor(Color.BLACK);
		g.drawString("Host Name: " + worker_manager.getHostName(), 20, 30);
		g.drawString("Host IP: " + worker_manager.getIP(), 20, 60);

		g.setColor(Color.WHITE);
		g.fillRect(10, 90, Contants.STATUS_WIDHT - 20, 60);

		g.setColor(Color.BLACK);
		g.drawString("Host CPU: " + worker_manager.getCPU() + "%", 20, 110);
		g.drawString("Host Memory: " + worker_manager.getMemory() + "GB", 20, 140);

		this.repaint(); // 화면을 다시 그려주기
	}

	public static StatusView getInstance() {
		return statusView;
	}

}
