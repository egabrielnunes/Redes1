package pontodeinteresse;

import persistencia.PontoDAO;
import persistencia.UsuarioDAO;

import java.io.IOException;
import java.util.ArrayList;

public class Facade {

	private static Facade instancia = new Facade();

	UsuarioDAO usuario;
	PontoDAO ponto;

	public Facade() {
		usuario = UsuarioDAO.getInstance();
		ponto = PontoDAO.getInstance();
	}

	public static Facade getInstancia() {
		return instancia;
	}
	
	public boolean autorizarUsuario(String login, String senha) throws IOException {
		return usuario.autorizaUsuario(login, senha); // retorno do banco se for true pode entrar no sistema
	}

	public boolean cadastrarUsuarios(String login, String senha) {

		try {
			usuario.cadastrarUsuario(login, senha);
		} catch (Exception e2) {
			e2.printStackTrace();
			return false;
		}
		
		return true;
	}
			
	public void listarUsuarios() {

		try {
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios =  usuario.localizarUsuarios();
			
			for (Usuario u : usuarios) {
				System.out.println("Login: " + u.getLogin());
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void localizarPontos() {

		try {
			ArrayList<PontoDeInteresse> pontos = new ArrayList<PontoDeInteresse>();
			pontos = ponto.localizarPontos();

			for (PontoDeInteresse p : pontos) {
				System.out.println("ID do ponto: " + p.getId());
				System.out.println("Nome do ponto: " + p.getNome());
				System.out.println("Tipo do topico: " + p.getTipo());
				System.out.println("Descri��o: " + p.getDescricao());
				System.out.println("Coordenada X: " + p.getCoordenadaX() + "\nCoordenada Y:" + p.getCoordenadaY());
				System.out.println("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void localizarPontoPorTopico(PontoDeInteresse pi) {

		try {
			ArrayList<PontoDeInteresse> pontos = new ArrayList<PontoDeInteresse>();
			pontos = ponto.localizarPontosPorTopico(pi.getTipo());

			for (PontoDeInteresse p : pontos) {
				System.out.println("ID do ponto: " + p.getId());
				System.out.println("Nome do ponto: " + p.getNome());
				System.out.println("Tipo do topico: " + p.getTipo());
				System.out.println("Descri��o: " + p.getDescricao());
				System.out.println("Coordenada X: " + p.getCoordenadaX() + "\nCoordenada Y:" + p.getCoordenadaY());
				System.out.println("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean removerPonto(int id) {

		try {
			ponto.removerPonto(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public <E> boolean cadastrarPonto(E e) {

		try {
			ponto.cadastrarPonto(e);
		} catch (Exception e2) {
			e2.printStackTrace();
			return false;
		}
		
		return true;
	}

	public void listarPontoPorLocalizacao(double coordXUsuario, double coordYUsuario, int raio) {
		
		ArrayList<PontoDeInteresse> pontos = new ArrayList<PontoDeInteresse>();

		PontoDAO p = new PontoDAO();
		pontos = p.localizarPontos();
		
		if(pontos.isEmpty()) {
			System.out.println("Nenhum ponto de interesse perto de voc�.");
		} else {
			System.out.println("Pontos interesse perto de voc�: \n");
		}
		
		for (PontoDeInteresse ponto : pontos) {
			
			double coordXPonto = ponto.getCoordenadaX();
			double coordYPonto = ponto.getCoordenadaY();
			double distancia = (Math.sqrt(Math.pow(coordXPonto - coordXUsuario, (2))) * (Math.pow(coordYPonto - coordYUsuario, (2))));
		
			if(distancia <= raio){
				
				System.out.println("ID do ponto: " + ponto.getId());
				System.out.println("Nome do ponto: " + ponto.getNome());
				System.out.println("Tipo do topico: " + ponto.getTipo());
				System.out.println("Descri��o: " + ponto.getDescricao());
				System.out.println("Coordenada X: " + ponto.getCoordenadaX() + "\nCoordenada Y:" + ponto.getCoordenadaY());
				System.out.println("");

			}
		}
	}
}
