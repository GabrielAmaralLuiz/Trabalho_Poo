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
	private ArrayList<Funcionario> funcionarios;

	public FicharioLoja(ArrayList<Produto> produtos, ArrayList<Loja> lojas, ArrayList<Funcionario> funcionario) {
		lojas = new ArrayList<>();
		sc = new Scanner(System.in);
		produtosCadastrados = produtos;
		this.lojas = lojas;
		this.funcionarios = funcionario;
	}

	public void incluir() {

		int menu = 0;
		do {
			System.out.println("--===[CADASTRO DE LOJA]===--");
			System.out.println("-=[ 1 - CADASTRAR LOJA     ]=-");
			System.out.println("-=[ 2 - INCLUIR PRODUTO    ]=-");
			System.out.println("-=[ 3 - REMOVER PRODUTO    ]=-");
			System.out.println("-=[ 4 - INCLUIR FUNCIONARIO]=-");
			System.out.println("-=[ 5 - REMOVER FUNCIONARIO]=-");
			System.out.println("-=[ 6 - RELATÓRIO      =]=-");
			System.out.println("-=[ 7 - SAIR      =]=-");
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
			case 4:
				int codigoFunc = 0;
				int posFunc = 0;
				boolean achouFunc = false;
				do {
					if (lojas.isEmpty()) {
						System.out.println("lista de lojas vazia");
					} else {
						mostraLojas();
						System.out.println("Digite o codigo da loja que deseja adicionar um funcionario.");
						codigoLoja = sc.nextInt();
						for (int i = 0; i < lojas.size(); i++) {
							if (lojas.get(i).getCodigo() == codigoFunc) {
								achouFunc = true;
								posFunc = i;
								break;
							}
						}
						if (achouFunc) {
							System.out.println("Loja errada ou inexistente.");
						}
						else {
							Loja loja = lojas.get(posFunc);
							if(funcionarios.isEmpty()) {
								System.out.println("Lista de funcionarios vazia.");
								break;
							}
							escolhaFuncionario(loja);
						}
					}
				} while (!achouFunc);
				break;
			case 5:
				break;
			case 6:
				lojas.forEach(l -> l.mostrarLojaComProdutos());
				break;
			default:
				break;
			}

		} while (menu != 6);
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
				if (consulta) {

				} else
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

		} while (menu != 2);
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

	private void escolhaFuncionario(Loja loja) {
		ArrayList<Funcionario> cadastrofuncionario = new ArrayList<>();
		int posicao = 0;
		int menu = 0;
		int codigo;
		boolean achouFuncionario = false;
		do {
			mostraFuncionario(cadastrofuncionario);

			System.out.println("-=[ 1 - Adicionar funcionario ]=-");
			System.out.println("-=[ 2 - Remover funcionario   ]=-");
			System.out.println("-=[ 3 - Sair                  ]=-");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				mostraFuncionario(cadastrofuncionario);
				System.out.println("Digite o codigo do funcionario.");
				codigo = sc.nextInt();
				for (int i = 0; i < funcionarios.size(); i++) {
					if (funcionarios.get(i).getCodigo() == codigo) {
						achouFuncionario = true;
						posicao = i;
						break;
					}
				}
				if(!achouFuncionario) {
					System.out.println("Digite uma posição valida.");
				}
				else {
					funcionarios.add(cadastrofuncionario.get(posicao));
					System.out.println("Funcionario Cadastrado.");
				}
				break;
			case 2:

				break;

			default:
				break;
			}
		} while (menu != 3);
	}

	private void mostraProdutos(ArrayList<Produto> produtos) {
		for (int i = 0; i < produtos.size(); i++) {
			System.out.println(": CODIGO                     :" + produtos.get(i).getCodigo());
			System.out.println(": NOME                       :" + produtos.get(i).getNome());
			System.out.println(": PREÇO                      :" + produtos.get(i).getPreco());
			System.out.println("=============");

		}
	}

	private void mostraFuncionario(ArrayList<Funcionario> funcionarios) {
		for (int i = 0; i < funcionarios.size(); i++) {
			System.out.println("CODIGO      :" + funcionarios.get(i).getCodigo());
			System.out.println("NOME        :" + funcionarios.get(i).getNome());
			System.out.println("CPF         :" + funcionarios.get(i).getCpf());
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
