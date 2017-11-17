package ui;

import pontodeinteresse.Facade;
import pontodeinteresse.FactoryPonto;
import pontodeinteresse.PontoDeInteresse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Threads implements Runnable {

	private Socket connectionSocket;

	public Threads(Socket s) {
		this.connectionSocket = s;
	}

	public void run() {
		String mensagem;

		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			mensagem = in.readLine();
			String[] array = mensagem.split(",");

			if (array[0].equals("1")) {
				FactoryPonto factory = new FactoryPonto();
				Object obj = factory.getPonto(array[1], array[2], array[3], Double.parseDouble(array[4]), Double.parseDouble(array[5]));
				Facade.getInstancia().cadastrarPonto(obj);
				System.out.println("Ponto cadastrado!");
			} else if(array[0].equals("2")) {
				Facade.getInstancia().removerPonto(Integer.parseInt(array[1]));
				System.out.println("Ponto removido!");
			} else if(array[0].equals("4")) {
				FactoryPonto factory = new FactoryPonto();
				PontoDeInteresse obj = factory.getTipo(array[1]);
				System.out.println("Listado!");
			} else if(array[0].equals("5")) {
				System.out.println("Listado!");
//				Facade.getInstancia().listarPontoPorLocalizacao(Double.parseDouble(array[1]), Double.parseDouble(array[2]), Integer.parseInt(array[3]));
			} else if(array[0].equals("6")) {
				Facade.getInstancia().cadastrarUsuarios(array[1], array[2]);
				System.out.println("Cadastrado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
