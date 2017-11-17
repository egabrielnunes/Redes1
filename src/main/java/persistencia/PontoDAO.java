package persistencia;

import pontodeinteresse.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PontoDAO {

	GerenteDeConexao g = new GerenteDeConexao();
	ArrayList<PontoDeInteresse> lista = new ArrayList<PontoDeInteresse>();
	private static PontoDAO instance = null;

	public static PontoDAO getInstance() {

		if (instance == null) {
			instance = new PontoDAO();
		}
		return instance;
	}

	public <E> boolean cadastrarPonto(E e) {

		try {
			String inserir = "insert into pontos(nome, descricao, coordX, coordY, tipo) values (?,?,?,?,?)";
			PreparedStatement stm = g.getConexao().prepareStatement(inserir);
			PontoDeInteresse r = (PontoDeInteresse) e;

			stm.setString(1, r.getNome());
			stm.setString(2, r.getDescricao());
			stm.setDouble(3, r.getCoordenadaX());
			stm.setDouble(4, r.getCoordenadaY());
			stm.setString(5, r.getTipo());

			stm.executeUpdate();
			g.fechaConexao();

			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<PontoDeInteresse> localizarPontos() {

		lista.removeAll(lista);
		
		String nome = null;
		String descricao = null;
		String tipo = null;
		double coordX = 0;
		double coordY = 0;
		int id = 0;

		try {
			String sql = "select * from pontos";
			PreparedStatement stm = g.getConexao().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				id = (rs.getInt("id"));
				nome = (rs.getString("nome"));
				descricao = (rs.getString("descricao"));
				tipo = (rs.getString("tipo"));
				coordX = (rs.getDouble("coordX"));
				coordY = (rs.getDouble("coordY"));
			
				lista = criarPonto(id, nome, tipo, descricao, coordX, coordY);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<PontoDeInteresse> localizarPontosPorTopico(String topico) { 

		lista.removeAll(lista);
	
		String nome = null;
		String descricao = null;
		String tipo = null;
		double coordX = 0;
		double coordY = 0;
		int id = 0;

		try {
			String sql = "select * from pontos where tipo = ?";
			PreparedStatement stm = g.getConexao().prepareStatement(sql);

			stm.setString(1, topico);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
			
				id = (rs.getInt("id"));
				nome = (rs.getString("nome"));
				descricao = (rs.getString("descricao"));
				tipo = (rs.getString("tipo"));
				coordX = (rs.getDouble("coordX"));
				coordY = (rs.getDouble("coordY"));

				lista = criarPonto(id, nome, tipo, descricao, coordX, coordY);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public boolean removerPonto(int id) {

		try {
			String deletar = "delete from pontos where id = ?";
			PreparedStatement stm = g.getConexao().prepareStatement(deletar);// cria

			stm.setInt(1, id);
			stm.executeUpdate();
			g.fechaConexao();

			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<PontoDeInteresse> criarPonto(int id, String nome,
			String tipo, String descricao, double x, double y) {

		if (tipo.toUpperCase().equals("ESCOLA")) {

			try {
				Escola escola = new Escola(nome, descricao, x, y, tipo, id);
				lista.add(escola);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.toUpperCase().equals("RESTAURANTE")) {

			try {
				Restaurante restaurante = new Restaurante(nome, descricao, x,
						y, tipo, id);
				lista.add(restaurante);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.toUpperCase().equals("SUPERMERCADO")) {

			try {
				Supermercado supermercado = new Supermercado(nome, descricao, x, y, tipo,id);
				lista.add(supermercado);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.toUpperCase().equals("HOSPITAL")) {

			try {
				Hospital hospital = new Hospital(nome, descricao, x, y, tipo, id);
				lista.add(hospital);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}