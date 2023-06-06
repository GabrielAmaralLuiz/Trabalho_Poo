package ficharios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import objetos.Funcionario;
import objetos.Loja;
import objetos.Produto;

public class FicharioLoja {
	private List<Loja> lojas;
	private Scanner sc;
	private ArrayList<Produto> produtosCadastrados;

	public FicharioLoja(ArrayList<Produto> produtos, ArrayList<Loja> lojas) {
		
		sc = new Scanner(System.in);
		produtosCadastrados = produtos;
		this.lojas = lojas;
	}

	public void incluir() {

		int menu = 0;
		do {
			System.out.println("--===[CADASTRO DE LOJA]===--");
			System.out.println("-=[ 1 - CADASTRAR LOJA     ]=-");
			System.out.println("-=[ 2 - INCLUIR PRODUTO    ]=-");
			System.out.println("-=[ 3 - REMOVER PRODUTO    ]=-");
			System.out.println("-=[ 4 - RELATÓRIO      =]=-");
			System.out.println("-=[ 5 - SAIR      =]=-");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				Loja novaLoja = new Loja();
				System.out.println(": CODIGO DA LOJA  :");
				novaLoja.setCodigo(sc.nextInt());
				sc.nextLine();
				System.out.println(": RAZÃO SOCIAL  :");
				novaLoja.setNome(sc.nextLine());
				lojas.add(novaLoja);
				System.out.println("Loja cadastrada");
				break;
			case 2:

				int codigoLoja;
				int posLoja = 0;
				boolean achou = false;
				do {
					if (lojas.isEmpty()) {
						System.out.println("Lista de lojas vazia !");
						break;
					} else {
						mostraLojas();
						System.out.println("Digite o codigo da loja que deseja adicionar um produto.");
						codigoLoja = sc.nextInt();

						for (int i = 0; i < lojas.size(); i++) {
							if (lojas.get(i).getCodigo() == codigoLoja) {
								achou = true;
								posLoja = i;
								break;
							}
						}

						if (!achou)
							System.out.println("Loja errada ou inexistente.");
						else {
							Loja loja = lojas.get(posLoja);
							if (produtosCadastrados.isEmpty()) {
								System.out.println("Lista de produtos vazia !");
								break;
							}
							escolhaProduto(loja);

						}
					}
				} while (!achou);

				break;
			case 3:
				int posicaoLojaExcluirP;
				boolean achouRemover = false;
				int indRemove = 0;
				do {
					if (lojas.isEmpty()) {
						System.out.println("lista de lojas vazia");
						break;
					} else {
						mostraLojas();
						System.out.println("lista de lojas vazia");
						posicaoLojaExcluirP = sc.nextInt();
						for (int i = 0; i < lojas.size(); i++) {
							if (lojas.get(i).getCodigo() == posicaoLojaExcluirP) {
								achouRemover = true;
								indRemove = i;
								break;
							}
						}
						if (!achouRemover)
							System.out.println("Loja errada ou inexistente.");
						else {
							Loja loja = lojas.get(posicaoLojaExcluirP);
							removerProduto(produtosCadastrados);
							System.out.println("produto removido.");
							break;
						}
					}
				} while (!achouRemover);
				break;

			}

		} while (menu != 5);
	}

	public void excluir() {

		if (lojas.isEmpty()) {
			System.out.println("Lista de lojas vazia !");
			return;
		} else {
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
					if (!removida) {
						System.out.println("Loja com código " + resp + " excluída com sucesso.");
						return;
					} else {
						System.out.println("Loja não encontrada ou não excluída.");
					}
				}
			} while (menu != 2);
		}
	}

	public void consultar() {
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
				sc.nextLine();
				boolean consulta = false;
				for (Loja loja : lojas) {
					if (loja.getCodigo() == resp) {
						consulta = true;
						loja.mostrarDados();
						break;
					}
				}
				if (!consulta)
					System.out.println("Loja não encontrada.");
			}
		} while (menu != 2);
	}

	public void altera() {
		Loja loja;
		int menu = 0;
		do {
			System.out.println("--===[ALTERAR DE LOJA]===--");
			System.out.println("-=[ 1 - ALTERAR    ]=-");
			System.out.println("-=[ 2 - SAIR       ]=-");
			menu = sc.nextInt();
			if (menu == 1) {
				imprime();
				System.out.println("--===[ALTERAR DE LOJA]===--");
				System.out.println("Digite o código da loja que deseja ALTERA:");
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
				if (alteracao) {
					loja = lojas.get(ind);

					System.out.println(": RAZÃO SOCIAL  :");
					loja.setNome(sc.nextLine());
					lojas.add(loja);
					System.out.println("Loja alterada");
				}

			}

		} while (menu != 2);
	}

	public void relatorio() {
		if (lojas.isEmpty()) {
			System.out.println("Nenhuma loja cadastrada.");
		} else {
			System.out.println("--===[RELATÓRIO DE LOJAS]===--");
			for (Loja loja : lojas) {
				loja.mostrarLojaComProdutos();
				System.out.println("==============================");
			}
		}
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

	private void escolhaProduto(Loja loja) {

		ArrayList<Produto> carrinhoProdutos = new ArrayList<Produto>();
		int posicao = 0;
		int coidgo;
		int menu = 0;
		do {
			System.out.println("-=[ 1 - adicionar produto ]=-");
			System.out.println("-=[ 2 - Remover produto   ]=-");
			System.out.println("-=[ 3 - sair              ]=-");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				boolean achou = false;
				do {
					mostraProdutos(produtosCadastrados);
					System.out.println("Digite o codigo do produto.");
					coidgo = sc.nextInt();

					for (int i = 0; i < produtosCadastrados.size(); i++) {
						if (produtosCadastrados.get(i).getCodigo() == coidgo) {
							achou = true;
							posicao = i;
							break;
						}
					}

					if (!achou) {
						System.out.println("Digite uma posição valida.");
					} else {
						carrinhoProdutos.add(produtosCadastrados.get(posicao));
						System.out.println("Produto cadastrado.");
					}
				} while (!achou && menu != 3);
				break;
			case 2:
				boolean achouRemove = false;
				do {
					mostraProdutos(produtosCadastrados);
					System.out.println("Digite o codigo do produto.");
					coidgo = sc.nextInt();
					for (int i = 0; i < produtosCadastrados.size(); i++) {
						if (produtosCadastrados.get(i).getCodigo() == coidgo) {
							achouRemove = true;
							posicao = i;
							break;
						}
					}
					if (!achouRemove) {
						System.out.println("digite uma posição valida");
					} else {
						produtosCadastrados.remove(posicao);
						System.out.println("produto removido da loja");
					}
				} while (!achouRemove && menu != 3);
				break;
			case 3:
				loja.setProdutos(carrinhoProdutos);

				break;
			}
		} while ((menu != 3));
	}

	private void mostraProdutos(ArrayList<Produto> produtos) {
		for (int i = 0; i < produtos.size(); i++) {
			System.out.println(": CODIGO                     :" + produtos.get(i).getCodigo());
			System.out.println(": NOME                       :" + produtos.get(i).getNome());
			System.out.println(": PREÇO                      :" + produtos.get(i).getPreco());
			System.out.println("=============");

		}
	}

	private void mostraLojas() {
		for (int i = 0; i < lojas.size(); i++) {
			lojas.get(i).mostrarDados();

		}
	}

	private void removerProduto(ArrayList<Produto> produtos) {
		int posicao;
		for (int i = 0; i < produtos.size(); i++) {
			produtos.get(i).mostrarProduto();
		}
		System.out.println("Didite a posição do produto.");
		posicao = sc.nextInt();
		if (posicao < 0 || posicao > produtos.size())
			System.out.println("Loja não encontrada ou não excluída.");
		else {
			produtos.remove(posicao);
		}
	}
}
