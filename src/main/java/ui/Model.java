package ui;

import pontodeinteresse.Facade;
import pontodeinteresse.FactoryPonto;
import pontodeinteresse.PontoDeInteresse;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Model {

	private Scanner scanner = new Scanner(System.in);
	
	public void CadastroPontoMenu(Socket socket){

		System.out.println("Cadastro de ponto de interesse selecionada!\n"
				+ "Digite o Nome do ponto de interesse:");
		String nome = (scanner.nextLine()).toUpperCase();

		System.out.println("Digite a descri��o do ponto de interesse:");
		String descricao = (scanner.nextLine()).toUpperCase();

		System.out.println("Digite a qual topico o ponto de interesse pertence: ESCOLA | RESTAURANTE | SUPERMERCADO | HOSPITAL");
		String tipo = scanner.nextLine().toUpperCase();

		System.out.println("Digite a coordenada X do ponto de interesse:");
		double coordX = Double.parseDouble((scanner.nextLine()));

		System.out.println("Digite a coordenada Y do ponto de interesse:");
		double coordY = Double.parseDouble((scanner.nextLine()));
		
		try {

			if(socket.isClosed()){
				socket = new Socket("localhost", 6788);
			}

			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

			outToServer.writeBytes(1 + ",");
			outToServer.writeBytes(tipo + ",");
			outToServer.writeBytes(nome + ",");
			outToServer.writeBytes(descricao + ",");
			outToServer.writeBytes(String.valueOf(coordX) + ",");
			outToServer.writeBytes(String.valueOf(coordY));

			outToServer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ExcluirPontoMenu(Socket socket){
		System.out.println("Exclus�o de ponto de interesse selecionada!\n"
				+ "Digite o ID do ponto de interesse que deseja excluir:");

		int id = Integer.parseInt((scanner.nextLine()));

		try {

			if(socket.isClosed()){
				socket = new Socket("localhost", 6788);
			}

			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

			outToServer.writeBytes(2 + ",");
			outToServer.writeBytes(id + "");

			outToServer.close();

			System.out.println("Ponto removido com sucesso!\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ListarPontosMenu(Socket socket){
	
		System.out.println("Listagem de todos os ponto de interesse selecionada!\n Segue a lista:\n");

		try {
			Facade.getInstancia().localizarPontos();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ListarPontosPorTopicoMenu(Socket socket){
		
		System.out.println("Listagem de ponto de interesse por interesse por topico selecionada!\n"
						+ "Digite o topico do ponto de interesse, que vc deseja buscar:\n"
						+ " ESCOLA | RESTAURANTE | SUPERMERCADO | HOSPITAL:\n");
		String topico = (scanner.nextLine()).toUpperCase();

		FactoryPonto factory = new FactoryPonto();
		PontoDeInteresse obj = factory.getTipo(topico);
		try {

			if(socket.isClosed()){
				socket = new Socket("localhost", 6788);
			}

			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

			outToServer.writeBytes(4 + ",");
			outToServer.writeBytes(topico);

			outToServer.close();
			Facade.getInstancia().localizarPontoPorTopico(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void ListarPontosPorLocalizacaoMenu(int raio, Socket socket){
		
		System.out.println("Listagem de ponto de interesse por localiza��o selecionada!\n"
					+ "Informe a sua localiza��o:\n"
					+ "Coordenada X:\n");
		double x = Double.parseDouble((scanner.nextLine()));
		
		System.out.println("Coordenada Y:\n");
		double y = Double.parseDouble(scanner.nextLine());
		
		try {

			if(socket.isClosed()){
				socket = new Socket("localhost", 6788);
			}

			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

			outToServer.writeBytes(5 + ",");
			outToServer.writeBytes(x  + ",");
			outToServer.writeBytes(y  + ",");
			outToServer.writeBytes(raio  + "");

			outToServer.close();
			Facade.getInstancia().listarPontoPorLocalizacao(x, y, raio);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CadastrarUsuariosMenu(Socket socket){

		System.out.println("Cadastro de novo usuario selecionad!\n"
				+ "Digite o Login do usaurio:");
		String login = (scanner.nextLine()).toUpperCase();

		System.out.println("Digite a senha do usuario:");
		String senha = (scanner.nextLine()).toUpperCase();

		try {

			if(socket.isClosed()){
				socket = new Socket("localhost", 6788);
			}

			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

			outToServer.writeBytes(6 + ",");
			outToServer.writeBytes(login  + ",");
			outToServer.writeBytes(senha  + "");

			outToServer.close();
			System.out.println("Cadastro realizado com sucesso!\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ListarUsuariosMenu(){
		System.out.println("Usuarios cadastrados no sistema: \n");
		try {

			Facade.getInstancia().listarUsuarios();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
