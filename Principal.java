package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Fornecedor> fornecedores = new ArrayList<>();
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		ArrayList<Produto> produtos = new ArrayList<>();
		ArrayList<Cliente> cliente = new ArrayList<>();
		FicharioCliente ficharioCliente = new FicharioCliente(cliente);
		FicharioFonecedor fichario = new FicharioFonecedor(fornecedores);		
		FicharioFuncionario ficharioFuncionario = new FicharioFuncionario(funcionarios);
		FicharioProduto ficharioProduto = new FicharioProduto(produtos);
		for(int i=0;i<5;i++) {
			Fornecedor forne = new Fornecedor(i, "fornecedor "+i, "cpf "+i, "rua "+i,
					"telefone"+i, "eu "+i, "Estado "+i, "cidade "+i, " cep "+i, String.valueOf(i), "inscriçao estadual "+i);
			fornecedores.add(forne);
		}
		for(int a = 0;a<5;a++) {
			Funcionario func = new Funcionario(a, "funcionario "+a, String.valueOf(a), "telefone "+a,
					"email "+a, "estado "+a, "cidade "+a, "rua "+a, "cep "+a, "cargo "+a, a);
			funcionarios.add(func);
		}
		
		int opLoja = 0, opFuncionario = 0, opCliente = 0, opFornecedores = 0, opProduto = 0, opCompra = 0;
		do {
			System.out.println("-----=====[F A R M  C I A]=====--------");
			System.out.println("--==[ 1 - CADASTRO DE FUNCIONARIOS]==--");
			System.out.println("--==[ 2 - CADASTRO DE CLIENTES    ]==--");
			System.out.println("--==[ 3 - CADASTRO DE FORNECEDORES]==--");
			System.out.println("--==[ 4 - CADASTRO DE PRODUTOS    ]==--");
			System.out.println("--==[ 5 - COMPRAS                 ]==--");
			System.out.println("--==[ 6 - SAIR                    ]==--");
			opLoja = sc.nextInt();
			switch (opLoja) {
			case 1:
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
					}
				} while (opFuncionario != 6);
				break;
			case 2:
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
					}
				} while (opCliente != 6);
				break;
			case 3:
				do {
					System.out.println("-==[F O R N E C E D O R E S]===--");
					mostraMenu();
					opFornecedores = sc.nextInt();
					switch (opFornecedores) {
					case 1:
						fichario.incluir();
						break;
					case 2:
						fichario.excluir();
						break;
					case 3:
						fichario.alterar();
						break;
					case 4:
						fichario.consultar();
						break;
					case 5:
						fichario.relatorio();
						break;
					}
				} while (opFornecedores != 6);
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
						ficharioProduto.consultar();;
						break;
					case 5:
						ficharioProduto.relatorio();
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
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					}
				} while (opCompra != 6);
				break;
			}
		} while (opLoja != 6);
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

}
