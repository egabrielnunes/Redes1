/**
 * 
 */
package pontodeinteresse;

/**
 * @author Gabriel Nunes
 *
 */

public abstract class PontoDeInteresse {
	
	private int id;
	private String nome;
	private String descricao;
	private String tipo;
	private double coordenadaX;
	private double coordenadaY;
	private double coordenadaXUsuario;
	private double coordenadaYUsuario;
		
	public PontoDeInteresse(){}

	/**
	 * @param coordenadaY
	 * @param coordenadaX 
	 * @param descricao
	 * @param nome
	 * 
	 */
	public PontoDeInteresse(String nome, String descricao,
			double coordenadaX, double coordenadaY) {
		this.nome = nome;
		this.descricao = descricao;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	/**
	 * Construtor de ponto de interrese
	 * 
	 * @param nome
	 * @param descricao
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param id
	 * @param tipo
	 */
	public PontoDeInteresse(String nome, String descricao, double coordenadaX, double coordenadaY, String tipo, int id) {
		this.nome = nome;
		this.descricao = descricao;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.tipo = tipo;
		this.id = id;
	}

	/**
	 * Construtor de ponto de interrese
	 * 
	 * @param nome
	 * @param descricao
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param tipo
	 */
	public PontoDeInteresse(String nome, String descricao, double coordenadaX, double coordenadaY, String tipo) {
		this.nome = nome;
		this.descricao = descricao;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.tipo = tipo;
	}
	
	public PontoDeInteresse(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/** 
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return the coordenadaX
	 */
	public double getCoordenadaX() {
		return coordenadaX;
	}

	/**
	 * @return the coordenadaY
	 */
	public double getCoordenadaY() {
		return coordenadaY;
	}

	/**
	 * @return the coordenadaXUsuario
	 */
	public double getCoordenadaXUsuario() {
		return coordenadaXUsuario;
	}

	/**
	 * @return the coordenadaYUsuario
	 */
	public double getCoordenadaYUsuario() {
		return coordenadaYUsuario;
	}
}
