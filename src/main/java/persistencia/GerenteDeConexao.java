package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenteDeConexao {

	private Connection con; 
	private String driver = "com.mysql.jdbc.Driver"; 
	private String url = "jdbc:mysql://localhost:3306/sistemalocalizacao";

	private String usuario = "root"; 
	private String senha = "nunes"; //Alterar para senha root do mysql

	private void conectar() { 
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, senha);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConexao() {
		if (con == null) {
			conectar();
		}
		return con;
	}

	public void fechaConexao() {
		try {
			con.close();
			con = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
