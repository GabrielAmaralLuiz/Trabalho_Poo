package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FicharioLoja {
	private List<Loja> lojas;
	private Scanner sc;

	FicharioLoja() {
		lojas = new ArrayList<>();
		sc = new Scanner(System.in);
	}

	public void incluir() {
		int menu = 0;
		do {
			System.out.println("--===[CADASTRO DE LOJA]===--");
			System.out.println("-=[ 1 - CADASTRAR =]=-");
			System.out.println("-=[ 2 - SAIR      =]=-");
			menu = sc.nextInt();
			if (menu == 1) {
				Loja novaLoja = new Loja();
				System.out.println(": CODIGO DA LOJA  :");
				novaLoja.setCodigo(sc.nextInt());
				sc.nextLine();
				System.out.println(": RAZÃO SOCIAL  :");
				novaLoja.setNome(sc.nextLine());
				lojas.add(novaLoja);
			}
		} while (menu != 2);
	}

	public void excluir() {
		int menu = 0;
		do {
			System.out.println("--===[EXCLUSÃO DE LOJA]===--");
			System.out.println("-=[ 1 - EXCLUIR =]=-");
			System.out.println("-=[ 2 - SAIR      =]=-");
			menu = sc.nextInt();
			if (menu == 1) {
				imprime();
				System.out.println("--===[EXCLUSÃO DE LOJA]===--");
				System.out.println("Digite o código da loja que deseja excluir:");
				int resp = sc.nextInt();
				boolean removida = false;
				for (Loja loja : lojas) {
					if (loja.getCodigo() == resp) {
						lojas.remove(loja);
						removida = true;
						break;
					}
				}
				if (removida) {
					System.out.println("Loja com código " + resp + " excluída com sucesso.");
				} else {
					System.out.println("Loja não encontrada ou não excluída.");
				}
			}
		} while (menu != 2);
	}

	public void alterar() {
		Loja loja;
		int menu = 0;
		do {
			System.out.println("--===[CONSULTA DE LOJA]===--");
			System.out.println("-=[ 1 - CONSULTA ]=-");
			System.out.println("-=[ 2 - SAIR     ]=-");
			menu = sc.nextInt();
			if (menu == 1) {
				imprime();
				System.out.println("--===[CONSULTA DE LOJA]===--");
				System.out.println("Digite o código da loja que deseja CONSULTAR:");
				int resp = sc.nextInt();
				int ind = 0;
				boolean consulta = false;
				for (int i = 0; i < lojas.size(); i++) {
					if (resp == lojas.get(i).getCodigo()) {
						consulta = true;
						ind = i;
						break;
					}
				}
				sc.nextLine();
				if(consulta) {
				
				}
				else
					System.out.println("Loja não alterada");
			}
		} while (menu != 2);
	}

	public void consultar() {
		Loja loja;
		int menu = 0;
		do {
			System.out.println("--===[CONSULTAR DE LOJA]===--");
			System.out.println("-=[ 1 - ALTERAR    ]=-");
			System.out.println("-=[ 2 - SAIR       ]=-");
			menu = sc.nextInt();
			if (menu == 1) {
				imprime();
				System.out.println("--===[EXCLUSÃO DE LOJA]===--");
				System.out.println("Digite o código da loja que deseja excluir:");
				int resp = sc.nextInt();
				int ind = 0;
				boolean alteracao = false;
				for (int i = 0; i < lojas.size(); i++) {
					if (resp == lojas.get(i).getCodigo()) {
						alteracao = true;
						ind = i;
						break;
					}
				}
			}
			
		}while(menu!=2);
	}

	public void relatorio() {
		// TODO: Implementar
	}

	private void imprime() {
		if (lojas.isEmpty()) {
			System.out.println("Nenhuma loja cadastrada.");
		} else {
			System.out.println("--===[LOJAS]===--");
			for (Loja loja : lojas) {
				System.out.println(": CODIGO                     :" + loja.getCodigo());
				System.out.println(": NOME                       :" + loja.getNome());
				System.out.println("=============");
			}
		}
	}
	private void consultaLoja() {
		
	}

}
