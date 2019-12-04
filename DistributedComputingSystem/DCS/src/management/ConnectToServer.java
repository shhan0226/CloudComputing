package management;

import java.net.Socket;

public class ConnectToServer {
	Socket socket;
	String IP = "";
	int PORT = 32000;
	Heartbeat hb;

	public ConnectToServer(String IP) {
		System.out.println("[ConnectToServer.java] ConnectToServer() (IP:" + IP + ")");
		this.IP = IP;
		Init();
	}

	public void Init() {

		try {
			System.out.println("[ConnectToServer.java] Server connection Start !");
			socket = new Socket(this.IP, this.PORT);
			hb = new Heartbeat(socket);
			hb.start();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ConnectToServer.java] Server connection Err");
			e.printStackTrace();
		}
	}

	public void disconnectServer() {
		System.out.println("[ConnectToServer.java] Server connection cancel...");
		hb.stop();
		try {
			if (socket != null)
				socket.close();
		} catch (Exception e) {
			System.out.println("[ConnectToServer.java] Server connection cancel Err");
			e.printStackTrace();
		}

	}

}
