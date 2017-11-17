/**
 * 
 */
package pontodeinteresse;

import java.io.Serializable;

/**
 * @author Gabriel Nunes
 *
 */
public class Supermercado extends PontoDeInteresse implements Serializable {

	/**
	 * 
	 */
	public Supermercado() {
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
	public Supermercado(String nome, String descricao, double coordenadaX,
			double coordenadaY,String tipo, int id) {
		super(nome, descricao, coordenadaX, coordenadaY,tipo, id);
	}
		

	/**
	 * @param nome
	 * @param descricao
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param tipo
	 */
	public Supermercado(String nome, String descricao, double coordenadaX,
			double coordenadaY,String tipo) {
		super(nome, descricao, coordenadaX, coordenadaY,tipo);
	}
	

	public Supermercado(String tipo) {
		super(tipo);
	}
	
}