package pontodeinteresse;

public class FactoryPonto {

	public PontoDeInteresse getPonto(String tipo, String nome, 
			String descricao, double x, double y) {
		if (tipo.equalsIgnoreCase("ESCOLA"))
			return new Escola(nome, descricao, x, y, tipo);
		if (tipo.equalsIgnoreCase("RESTAURANTE"))
			return new Restaurante(nome, descricao, x, y, tipo);
		if (tipo.equalsIgnoreCase("HOSPITAL"))
			return new Hospital(nome, descricao, x, y, tipo);
		if (tipo.equalsIgnoreCase("SUPERMERCADO"))
			return new Supermercado(nome, descricao, x, y, tipo);
		else {
			System.out.println("Tipo invalido!\n");
			return null;
		}
	}
	
	public PontoDeInteresse getTipo(String tipo) {
		if (tipo.equalsIgnoreCase("ESCOLA"))
			return new Escola(tipo);
		if (tipo.equalsIgnoreCase("RESTAURANTE"))
			return new Restaurante(tipo);
		if (tipo.equalsIgnoreCase("HOSPITAL"))
			return new Hospital(tipo);
		if (tipo.equalsIgnoreCase("SUPERMERCADO"))
			return new Supermercado(tipo);
		else {
			System.out.println("Tipo invalido!\n");
			return null;
		}
	}
}
