package gui_v1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RunProgram extends JFrame {
	public static JPanel Panel = new JPanel();
	public static JLabel CPU_Label = new JLabel();
	public static JLabel Memory_Label = new JLabel();
	public static JLabel Storage_Label = new JLabel();

	public RunProgram() {

		setTitle("System Performance"); // ������ �̸�
		setSize(Main.SCREEEN_WIDTH, Main.SCREEEN_HIGHT); // âũ��
		setResizable(false); // â ũ�� �缳�� ����
		setLocationRelativeTo(null); // ����� ��� �߱�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x ������ ���α׷� ����
		setVisible(true); // ȭ�鿡 ���̰� �ϱ�

		String str1 = "������";
		String str2 = "������";
		String str3 = "������";

		CPU_Label.setText(str1);
		Memory_Label.setText(str2);
		Storage_Label.setText(str3);

		Panel.add(CPU_Label);
		Panel.add(Memory_Label);
		Panel.add(Storage_Label);

		add(Panel);

	}

}
