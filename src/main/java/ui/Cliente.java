package ui;

import java.net.Socket;

class Cliente {

	public static void main(String argv[]) throws Exception {
		Socket socket = new Socket("localhost", 6788);
		App.run(socket);
	}
}