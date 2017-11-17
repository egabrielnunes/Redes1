package persistencia;

import pontodeinteresse.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
	
	ArrayList<Usuario> lista = new ArrayList<Usuario>();
	GerenteDeConexao g = new GerenteDeConexao();
	private static UsuarioDAO instance = null;

	public static UsuarioDAO getInstance() {

		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	public boolean cadastrarUsuario(String login, String senha) {

		try {
			String inserir = "insert into usuarios(login, senha) values (?,?)";
			PreparedStatement stm = g.getConexao().prepareStatement(inserir);
	
			stm.setString(1, login);
			stm.setString(2, senha);
		
			stm.executeUpdate();
			g.fechaConexao();

			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	public boolean autorizaUsuario(String login, String senha) { // verifica se usuario e senha s�o validos

		try {
			String sql = "select login, senha from usuarios where login = ? and senha = ? ";// consulta o banco o usuario e senha
			PreparedStatement stm = g.getConexao().prepareStatement(sql);

			stm.setString(1, login);
			stm.setString(2, senha);
			ResultSet rs = stm.executeQuery();
			return rs.isBeforeFirst(); // recebe retorno true ou false da presen�a do usuario e senha 
			//no banco e os transforma em string
		} catch (Exception e) {
			return false;
		}
	}
	
	public ArrayList<Usuario> localizarUsuarios() {

		lista.removeAll(lista);
		
		String login = null;
		
		try {
			String sql = "select * from usuarios";
			PreparedStatement stm = g.getConexao().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				login = (rs.getString("login"));
				Usuario usuario = new Usuario(login);

				lista.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return lista;
	}

}
