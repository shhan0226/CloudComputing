package ui;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import def.viewData;
import management.ServerResManager;
import management.WorkerResManager;

public class MainMenuBar extends JMenuBar implements ActionListener {

	private static MainMenuBar MenuBar = new MainMenuBar();

	private WorkerView workerView;
	private ServerView serverView;
	private ServerResManager serverResManager;
	private ServerTableView serverTableView;
	private WorkerResManager workerResManager;
	private MainStatusView mainStatusView;
	private MainView mainView;

	private JMenu BarFile;
	private JMenu BarHelp;

	private JMenuItem BarItemInit;
	private JMenuItem BarItemClose;
	private JMenuItem BarItemVersion;

	private JCheckBoxMenuItem temp;

	public MainMenuBar() {
		System.out.println("[MainMenuBar.java] MainMenuBar()");
		initialize();
	}

	private void initialize() {
		System.out.println("[MainMenuBar.java] initialize()");
		workerView = WorkerView.getInstance();
		serverView = ServerView.getInstance();
		mainView = MainView.getInstance();
		mainStatusView = MainStatusView.getInstance();
		
		// File Menu
		BarFile = new JMenu("Set(s)");
		BarFile.setMnemonic('S');

		BarItemInit = new JMenuItem("INIT (i)");
		BarItemInit.setMnemonic('I');
		BarItemInit.addActionListener(this);
		BarFile.add(BarItemInit);

		BarItemClose = new JMenuItem("Close (c)");
		BarItemClose.setMnemonic('C');
		BarItemClose.addActionListener(this);
		BarFile.add(BarItemClose);

		// Help Menu
		BarHelp = new JMenu("About (h)");
		BarHelp.setMnemonic('H');

		BarItemVersion = new JMenuItem("About DCS (a)");
		BarItemVersion.setMnemonic('A');
		BarItemVersion.addActionListener(this);
		BarHelp.add(BarItemVersion);

		this.add(BarFile);
		this.add(BarHelp);

		this.setSize(viewData.MENUBAR_WIDHT, viewData.MENUBAR_HEIGHT);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(BarItemClose)) {
			System.exit(0);

		} else if (e.getSource().equals(BarItemVersion)) {
			System.out.println("DCS Server");
			JOptionPane.showMessageDialog(this, "Distributed Computing System\nVersion 0.7", "by Seok-Hyeon Han",
					JOptionPane.INFORMATION_MESSAGE);

		} else if (e.getSource().equals(BarItemInit)) {
			workerView.WorkerViewOff();
			serverView.ServerViewOff();
			mainStatusView.setLocation(200, 300);
			mainView.viewOn();
		}

	}

	public static MainMenuBar getInstance() {
		return MenuBar;
	}

}
