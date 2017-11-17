package ui;

import java.net.Socket;
import java.util.Scanner;

/**
 * @author Gabriel Nunes
 *
 */
public class App {

    private static Scanner scanner;
    private static int raio;
    private static Model modelo = new Model();

    public static void run(Socket socket) {
        scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.println("Bem vindo!\n" + "----------\n"
                    + "Selecione o tipo de usuario: \n" + "1- Administrador\n"
                    + "2- Usuario Comun\n" + "3- Sair.\n");
            int opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("Login:");
                    String login = (scanner.nextLine()).toUpperCase();
                    System.out.println("Senha:");
                    String senha = (scanner.nextLine()).toUpperCase();

                    Control controle = new Control();
                    boolean validacao = controle.validacao(login,senha);

                    if(validacao == true){
                        MenuAdministrador(socket);
                    } else {
                        System.out.println("Usuario Invalido!");
                        break;
                    }
                    break;
                case 2:
                    MenuUsuario(socket);
                    break;

                case 3:
                    flag = false;
                    System.out.println("Saindo do Sistema..");
                    break;

                default:
                    break;
            }
        }
    }

    public static void MenuAdministrador(Socket socket) {

        System.out.println("Bem vindo ao Menu do Administrador!\n"
                + "-----------------------------------\n"
                + "Selecione a opcao desejada: \n"
                + "1- Cadastro de ponto de interesse\n"
                + "2- Exclusao de ponto de interesse\n"
                + "3- Listagem de todos os pontos de interesse\n"
                + "4- Listagem de pontos de interesse por topico\n"
                + "5- Listagem de pontos de interesse por localiza��o\n"
                + "6- Cadastrar novo usuario\n"
                + "7- Listar usuarios existentes\n"
                + "8- Mudar raio de abrang�ncia da busca\n"
                + "9- Sair\n");

        int opc1 = Integer.parseInt(scanner.nextLine());

        switch (opc1) {

            case 1:
                modelo.CadastroPontoMenu(socket);
                MenuAdministrador(socket);
                break;

            case 2:
                modelo.ExcluirPontoMenu(socket);
                MenuAdministrador(socket);
                break;

            case 3:
                modelo.ListarPontosMenu(socket);
                MenuAdministrador(socket);
                break;

            case 4:
                modelo.ListarPontosPorTopicoMenu(socket);
                MenuAdministrador(socket);
                break;

            case 5:
                modelo.ListarPontosPorLocalizacaoMenu(raio, socket);
                MenuAdministrador(socket);
                break;

            case 6:
                modelo.CadastrarUsuariosMenu(socket);
                MenuAdministrador(socket);
                break;

            case 7:
                modelo.ListarUsuariosMenu();
                MenuAdministrador(socket);
                break;

            case 8:
                System.out.println("O valor do raio padr�o � 5\n"
                        + "Informe o novo valor do raio:\n");
                int r = Integer.parseInt(scanner.nextLine());
                raio = r;
                MenuAdministrador(socket);
                break;

            case 9:
                break;


            default:
                break;
        }
    }

    public static void MenuUsuario(Socket socket) {

        System.out.println("Bem vindo ao Menu do Usuario Comum!\n"
                + "-----------------------------------\n"
                + "1- Listagem de todos os pontos de interesse\n"
                + "2- Listagem de pontos de interesse por topico\n"
                + "3- Listagem de pontos de interesse por localiza��o\n"
                + "4- Sair\n");

        int opc2 = Integer.parseInt(scanner.nextLine());

        switch (opc2) {
            case 1:
                modelo.ListarPontosMenu(socket);
                MenuUsuario(socket);
                break;

            case 2:
                modelo.ListarPontosPorTopicoMenu(socket);
                MenuUsuario(socket);
                break;

            case 3:
                modelo.ListarPontosPorLocalizacaoMenu(raio, socket);
                MenuUsuario(socket);
                break;

            case 4:
                break;

            default:
                break;
        }
    }
}
