/**
 * 
 */
package pontodeinteresse;

import java.io.Serializable;

/**
 * @author Gabriel Nunes
 *
 */
public class Restaurante extends PontoDeInteresse implements Serializable{

	/**
	 * 
	 */
	public Restaurante() {
		super();
	}

	/**
	 * @param nome
	 * @param descricao
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param tipo
	 * @param id
	 */
	public Restaurante(String nome, String descricao, double coordenadaX,
			double coordenadaY, String tipo, int id) {
		super(nome, descricao, coordenadaX, coordenadaY, tipo, id);
	}
	

	/**
	 * @param nome
	 * @param descricao
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param tipo
	 */
	public Restaurante(String nome, String descricao, double coordenadaX,
			double coordenadaY, String tipo) {
		super(nome, descricao, coordenadaX, coordenadaY, tipo);
	}
	

	public Restaurante(String tipo) {
		super(tipo);
	}

}
