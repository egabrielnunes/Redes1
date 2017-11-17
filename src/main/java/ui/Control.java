package ui;

import pontodeinteresse.Facade;
import java.io.IOException;

public class Control {

	public boolean validacao(String login, String senha){
		try {
			return Facade.getInstancia().autorizarUsuario(login, senha);
		} catch (IOException e) {
			System.out.println("Usuario Invalido!");
			return false;
		}
	}
}