package ui;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Gabriel Nunes
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		System.out.println("Servidor rodando na porta 6788");
		ServerSocket socket = new ServerSocket(6788);

		while(true) {
			Socket socket1 = socket.accept();
			Thread t = new Thread(new Threads(socket1));
			t.start();
		}
	}
}