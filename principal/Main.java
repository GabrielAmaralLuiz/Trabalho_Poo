package principal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ficharios.FicharioCliente;
import ficharios.FicharioCompra;
import ficharios.FicharioFuncionario;
import ficharios.FicharioLoja;
import ficharios.FicharioProduto;

import objetos.Cliente;
import objetos.Compra;
import objetos.Funcionario;
import objetos.Loja;
import objetos.Produto;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Produto> produtos = new ArrayList<>();
		ArrayList<Cliente> cliente = new ArrayList<>();
		ArrayList<Funcionario> funcionario = new ArrayList<>();
		ArrayList<Loja> lojas = new ArrayList<>();
		ArrayList<Compra> compras = new ArrayList<>();

		FicharioFuncionario ficharioFuncionario = new FicharioFuncionario(funcionario);
		FicharioCliente ficharioCliente = new FicharioCliente(cliente);
		FicharioProduto ficharioProduto = new FicharioProduto(produtos);
		FicharioLoja ficharioLoja = new FicharioLoja(produtos, lojas);
		FicharioCompra ficharioCompra = new FicharioCompra();
		int opMenu = 0, opFuncionario = 0, opLoja = 0, opCliente = 0, opProduto = 0, opCompra = 0;
		do {
			System.out.println("-----=====[F A R M  C I A]=====--------");
			System.out.println("--==[ 1 - CADASTRO DE LOJAS       ]==--");
			System.out.println("--==[ 2 - CADASTRO DE FUNCIONARIOS]==--");
			System.out.println("--==[ 3 - CADASTRO DE CLIENTES    ]==--");
			System.out.println("--==[ 4 - CADASTRO DE PRODUTOS    ]==--");
			System.out.println("--==[ 5 - COMPRAS                 ]==--");
			System.out.println("--==[ 6 - SAIR                    ]==--");
			opMenu = sc.nextInt();
			switch (opMenu) {
			case 1:
				Loja loja = new Loja();
				do {
					System.out.println("-----====[LOJA]===----");
					mostraMenu();
					opLoja = sc.nextInt();
					switch (opLoja) {
					case 1:
						ficharioLoja.incluir();
						break;
					case 2:
						ficharioLoja.excluir();
						break;
					case 3:
						ficharioLoja.altera();
						break;
					case 4:
						ficharioLoja.consultar();
						break;
					case 5:
						ficharioLoja.relatorio();
						break;
					case 6:
						break;
					}
				} while (opLoja != 6);
				break;
			case 2:
				do {

					System.out.println("-----====[F U N C I O N A R I O]===----");
					mostraMenu();

					opFuncionario = sc.nextInt();
					switch (opFuncionario) {
					case 1:
						ficharioFuncionario.incluir();
						break;
					case 2:
						ficharioFuncionario.excluir();
						break;
					case 3:
						ficharioFuncionario.alterar();
						break;
					case 4:
						ficharioFuncionario.consultar();
						break;
					case 5:
						ficharioFuncionario.relatorio();
						break;
					case 6:
						break;
					}
				} while (opFuncionario != 6);
				break;
			case 3:
				do {
					System.out.println("---====[C L I E N T E S]===----");
					mostraMenu();
					opCliente = sc.nextInt();
					switch (opCliente) {
					case 1:
						ficharioCliente.incluir();
						break;
					case 2:
						ficharioCliente.excluir();
						break;
					case 3:
						ficharioCliente.alterar();
						break;
					case 4:
						ficharioCliente.consultar();
						break;
					case 5:
						ficharioCliente.relatorio();
						break;
					case 6:
						break;
					}
				} while (opCliente != 6);
				break;

			case 4:
				do {
					System.out.println("-==[P R O D U T O S]===--");
					mostraMenu();
					opProduto = sc.nextInt();
					switch (opProduto) {
					case 1:
						ficharioProduto.incluir();
						break;
					case 2:
						ficharioProduto.excluir();
						break;
					case 3:
						ficharioProduto.alterar();
						break;
					case 4:
						ficharioProduto.consultar();
						;
						break;
					case 5:
						ficharioProduto.relatorio();
						break;
					case 6:
						break;
					}
				} while (opProduto != 6);
				break;
			case 5:
				do {
					System.out.println("-===[C O M P R A S]===--");
					mostraMenu();
					opCompra = sc.nextInt();
					switch (opCompra) {
					case 1:
						if(!lojas.isEmpty()) {
						ficharioCompra.incluir();
						}else {
							System.out.println("Cadastre loja antes de entrar");
						}

						break;
					case 2:
						if (compras.isEmpty()) {
							System.out.println("Não a compra registrada! efetue uma antes de tentar excluir");
						} else {
							/* Caso tenha venda cadastrados, irá chamar o metodo excluir !!! */
							ficharioCompra.excluir();
						}

						break;
					/* Verificando se tem compra cadastrado antes de tentar alterar */
					case 3:
						if (compras.isEmpty()) {
							System.out.println("Não a compra registrada! efetue uma antes de tentar alterar");
						} else {
							/* Caso tenha venda cadastrados, irá chamar o metodo alterar !!! */
							ficharioCompra.alterar();
						}
						break;
					case 4:
						/* Verificando se tem compra cadastrado antes de tentar consultar */
						if (compras.isEmpty()) {
							System.out.println("Não a compra registrada! efetue uma antes de consultar");
						} else {
							/* Caso tenha venda cadastrados, irá chamar o metodo consultar !!! */
							ficharioCompra.consultar();
						}

						break;
					case 5:
						if (!compras.isEmpty()) {
							ficharioCompra.relatorio();
						} else {
							System.out.println(
									"Não a compras registradas, inclua compras antes de tentar realizar um relatorio!!!!");
						}
						break;
					
					}
				} while (opCompra != 6);
				break;
			case 6: 
				System.out.println("Muito obrigado por usar o software!!!");
				break;

			}
		} while (opMenu != 6);
		sc.close();
	}

	private static void mostraMenu() {
		System.out.println("--==[ 1 - INCLUIR    ]==--");
		System.out.println("--==[ 2 - EXCLUIR    ]==--");
		System.out.println("--==[ 3 - ALTERAR    ]==--");
		System.out.println("--==[ 4 - CONSULTAR  ]==--");
		System.out.println("--==[ 5 - RELATORIO  ]==--");
		System.out.println("--==[ 6 - VOLTAR     ]==--");
	}

	private static int escolherLoja(Scanner sc, ArrayList<Loja> lojas) {
		int op = 0;
		do {
			System.out.println("Escolha a loja: ");
			Iterator<Loja> itr = lojas.iterator();
			for (int i = 0; i < lojas.size(); i++) {
				System.out.println("loja: " + "" + (i + 1));
				lojas.get(i).mostrarDados();
			}
			op = sc.nextInt();

		} while (op < 0 || op > lojas.size());
		return op;
	}

}
