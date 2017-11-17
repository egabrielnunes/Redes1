/**
 * 
 */
package pontodeinteresse;

import java.io.Serializable;

/**
 * @author Gabriel Nunes
 *
 */
public class Hospital extends PontoDeInteresse implements Serializable{

	/**
	 * 
	 */
	public Hospital() {
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

	public Hospital(String nome, String descricao, double coordenadaX, double coordenadaY, String tipo, int id) {
		super(nome, descricao, coordenadaX, coordenadaY, tipo, id);
	}

	/**
	 * @param nome
	 * @param descricao
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param tipo
	 */
	public Hospital(String nome, String descricao, double coordenadaX,
			double coordenadaY, String tipo) {
		super(nome, descricao, coordenadaX, coordenadaY, tipo);
	}

	public Hospital(String tipo) {
		super(tipo);
	}
}