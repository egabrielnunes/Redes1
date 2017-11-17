/**
 * 
 */
package pontodeinteresse;

import java.io.Serializable;

/**
 * @author Gabriel Nunes
 *
 */
public class Escola extends PontoDeInteresse implements Serializable {

	public Escola() {
		super();
	}

	/**
	 * Construtor Escola
	 * 
	 * @param nome
	 * @param descricao
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param tipo
	 * @param id
	 */
	public Escola(String nome, String descricao, double coordenadaX,
			double coordenadaY, String tipo, int id) {
		super(nome, descricao, coordenadaX, coordenadaY, tipo, id);
	}
	
	/**
	 * Construtor Escola
	 * 
	 * @param nome
	 * @param descricao
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param tipo
	 */
	public Escola(String nome, String descricao, double coordenadaX,
			double coordenadaY, String tipo) {
		super(nome, descricao, coordenadaX, coordenadaY, tipo);
	}

	public Escola(String tipo) {
		super(tipo);
	}
		
}
