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

		setTitle("System Performance"); // 프레임 이름
		setSize(Main.SCREEEN_WIDTH, Main.SCREEEN_HIGHT); // 창크기
		setResizable(false); // 창 크기 재설정 금지
		setLocationRelativeTo(null); // 모니터 가운데 뜨기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 누를때 프로그램 종료
		setVisible(true); // 화면에 보이게 하기

		String str1 = "가나다";
		String str2 = "가나다";
		String str3 = "가나다";

		CPU_Label.setText(str1);
		Memory_Label.setText(str2);
		Storage_Label.setText(str3);

		Panel.add(CPU_Label);
		Panel.add(Memory_Label);
		Panel.add(Storage_Label);

		add(Panel);

	}

}
