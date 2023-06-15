package ficharios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import objetos.Cliente;
import objetos.Compra;
import objetos.Loja;
import objetos.Produto;
import java.util.Scanner;

public class FicharioCompra {

	public Scanner sc = new Scanner(System.in);
	private ArrayList<Compra> compras;
	private ArrayList<Loja> loja;
	private ArrayList<Produto> produtos;
	private ArrayList<Cliente> clientes;

	public FicharioCompra(ArrayList<Compra> compras, ArrayList<Loja> lojas, ArrayList<Produto> produto,
			ArrayList<Cliente> cliente) {
		this.produtos = produto;
		this.compras = compras;
		this.loja = lojas;
		this.clientes = cliente;
	}

	/* ##### METODO INCLUIR ##### */
	public void incluir() {

		Compra compra = new Compra();
		Produto p;
		System.out.println("--==[ Inclusão de compra ]==--");
		int opMenu = 0;
		int opProduto = 0;
		int indiceProduto = 0;
		int codigoProduto;
		int indLoja = 0;
		int indProduto = 0;
		int indCliente = 0;
		boolean achouLoja = false;
		boolean achouProduto = false;
		boolean achouCliente = false;
		boolean achou = false;
		do {

			System.out.println("--==[ 1 - Adicionar produtos ao carrinho ]==--");
			System.out.println("--==[ 2 - Remover produtos do carrinho   ]==--");
			System.out.println("--==[ 3 - Sair                           ]==--");
			opMenu = sc.nextInt();

			switch (opMenu) {
			case 1:
				if (!produtos.isEmpty()) {
					for (int y = 0; y < loja.size(); y++) {
						loja.get(y).mostrarDados();
					}
					System.out.println("Digite qual o codigo da loja que realizou a venda: ");
					int opLoja = sc.nextInt();

					for (int i = 0; i < loja.size(); i++) {
						if (opLoja == loja.get(i).getCodigo()) {
							achouLoja = true;
							indLoja = i;
							break;
						}
					}
					System.out.println("Loja selecionada!!!");
					System.out.println("");
					// Com a loja selecionada, vamos selecionar qual o produto dessa loja será
					// vendido!//
					if (!loja.get(indLoja).getProdutos().isEmpty()) {
						System.out.println("Exibindo todos os produtos dessa loja!");
						loja.get(indLoja).mostrarLojaComProdutos();
						System.out.println("");
						System.out.print("Selecione o codigo do produto que vai ser adicionado ao carrinho:   ");
						opProduto = sc.nextInt();
						for (int i = 0; i < loja.get(indLoja).getProdutos().size(); i++) {
							if (opProduto == loja.get(indLoja).getProdutos().get(i).getCodigo()) {
								achouProduto = true;
								indProduto = i;
								break;
							}
						}
						System.out.println("Produto selecionado!!!");
					} else {
						System.out.println("Não há produto cadastrado!");
						break;
					}
					// Com produto selecionado, vamos selecionar qual cliente que realizou a
					// compra!//
					System.out.println("Selecione o cliente");
					System.out.println("Exibindo todos os clientes!");
					System.out.println("");
					for (int x = 0; x < clientes.size(); x++) {
						System.out.println("Nome       :" + clientes.get(x).getNome());
						if (clientes.get(x).getCpf() == null) {
							System.out.println("CNPJ       :" + clientes.get(x).getCnpj());
						} else {
							System.out.println("CPF        :" + clientes.get(x).getCpf());
						}
						System.out.println("Código     :" + clientes.get(x).getCodigo());
						System.out.println("=-=-=-=-=-=-=-=-=--=-=");
					}
					System.out.println("Qual o código do cliente que realizou a compra?");
					int opCliente = 0;
					opCliente = sc.nextInt();
					for (int i = 0; i < clientes.size(); i++) {
						if (opCliente == clientes.get(i).getCodigo()) {
							achouCliente = true;
							indCliente = i;
							break;
						}
					}
					if (achouLoja) {
						System.out.println("Loja ok");
					}
					if (achouCliente) {
						System.out.println("Cliente ok");
					}
					if (achouProduto) {
						System.out.println("Produto ok");
					}
					if ((achouLoja) && (achouCliente) && (achouProduto)) {
						compra.setClientes(clientes.get(indCliente));
						compra.setLoja(loja.get(indLoja));
						compra.addProduto(produtos.get(indProduto));
						compra.somarValorTotal(produtos.get(indProduto));
						compras.add(compra);
						System.out.println("Compra Cadastrada");
					} else {
						System.out.println("Faltou algum dado para a realização da compra!");
					}
				} else {
					System.out.println("Sem produto cadastrado!!!");
				}
				break;
			case 2:
				if (!compra.getProdutos().isEmpty()) {
					System.out.println("Escolha o produto que deseja remover do carrinho: ");
					compra.mostrarItensDoCarrinho();
					codigoProduto = sc.nextInt();
					for (int i = 0; i <= compra.getProdutos().size(); i++) {
						if (compra.getProdutos().get(i).getCodigo() == codigoProduto) {
							achou = true;
							indiceProduto = i;
							break;
						}
					}
					if (!achou)
						System.out.println("Produto não encontrado !");
					else {
						Produto produto;
						produto = compra.getProdutos().get(indiceProduto);
						compra.removerProduto(indiceProduto);
						compra.diminuirValorTotal(produto);
						System.out.println("Produto retirado do carrinho com sucesso!!!");
					}
				} else {
					System.out.println("Cadastre produtos no carrinho antes de excluir!");
				}
				break;
			case 3:
				System.out.println("Voltando ao menu de compra!!!");
				return;

			default:
				System.out.println("Opção invalida!");
			}

		} while (opProduto != 3);

	}

	/* ##### METODO Excluir ##### */
	public void excluir() {
		System.out.println("--=[ Exclusão ]==--");
		int opExcluir = 0;
		clearBuffer(sc);
		int op;
	
			System.out.println("Qual compra deseja excluir?");
			System.out.println("");
			exibirCompra();
			System.out.println("Selecione a compra: ");
			opExcluir = sc.nextInt();

			System.out.println("Teste");
			Compra comp = new Compra();
			comp = compras.get(opExcluir);
			exibirCompra(comp);
				System.out.println("Esta é a compra que deseja excluir? (1- SIM / 2- NÃO / 3- Cancelar)");
				op = sc.nextInt();
			if (op == 1) {
				compras.remove(opExcluir);
				System.out.println("dados excluidos com sucesso!!!");
			} else if (op == 3) {
				System.out.println("Operação cancelada!!!");
				return;
			}
		
		System.out.println("--==[ Voltando ao menu de compra ]==--");
	}

	/* ##### METODO Alterar ##### */
	public void alterar() {
		int opMudar;
		int resp;
		int op;
		System.out.println("--=[ alteração ]==--");

		do {
			do {
				System.out.println("Qual compra deseja alterar?");
				exibirCompra();
				System.out.println("Selecione a compra: ");
				opMudar = sc.nextInt();
				if (opMudar < 0 || opMudar > compras.size())
					System.out.println("Compra não encontrada !");

			} while (opMudar < 0 || opMudar > compras.size());
			Compra comp = new Compra();
			comp = compras.get(opMudar);
			exibirCompra(comp);
			op = sc.nextInt();
			System.out.println("Esta é a compra que deseja alterar? (1-Sim\n2- Não\n3- Cancelar\n)");
		} while (op == 1 || op == 3);

		if (op == 1) {
			do {

				System.out.println("--=[ alteração ]==--");
				System.out.println("Selecione qual opção deseja alterar:");
				System.out.println("1 - Itens do carrinho: ");
				System.out.println("2 - Data da compra: ");
				System.out.println("3 - Voltar ao meno de compra.");
				resp = sc.nextInt();
				switch (resp) {
				case 1:

					System.out.println("Deseja adicionar ou excluir itens do carrinho? (1 - Adicionar / 2- Excluir");
					int respAdicionarOuExcluir = sc.nextInt();
					if (respAdicionarOuExcluir == 1) {
						System.out.println("Qual loja realizou a venda?");
						for (int y = 0; y < loja.size(); y++) {
							loja.get(y).mostrarDados();
						}
						int codigoDaLoja = sc.nextInt();
						mostrarProdutos(codigoDaLoja);
						System.out.println("Escolha o produto para adicionar no carrinho");
						int indiceProduto = sc.nextInt();
						Produto p = loja.get(opMudar).getProdutos().get(indiceProduto);
						compras.get(opMudar).addProduto(p);
					} else if (respAdicionarOuExcluir == 2) {
						System.out.println("Escolha o produto que deseja remover do carrinho: ");

						compras.get(opMudar).mostrarItensDoCarrinho();
						int posProduto = sc.nextInt();
						compras.get(opMudar).removerProduto(posProduto);
						Produto p = new Produto();
						p = compras.get(opMudar).getProdutos().get(opMudar);
						compras.get(opMudar).diminuirValorTotal(p);
					} else {
						System.out.println("Opção invalida!!!");
					}

					break;
				case 2:
					System.out.println("Por se tratar de nota fiscal, não é possivel alterar a data da compra!!!");
					break;
				case 3:
					System.out.println("Voltando ao menu principal!!!");
					break;
				default:
					System.out.println("Opção invalida!!!");
					break;
				}
			} while (resp != 3);

		} else if (op == 3) {
			System.out.println("--==[ Alteração cancelada ]==--");
			return;
		}
		System.out.println("--==[ Voltando ao menu de compra ]==--");
	}

	/* ##### METODO Consultar ##### */
	public void consultar() {
		System.out.println("--==[ Consulta ]==--");
		System.out.println("Digite a posição da compra que quer ver as informações: ");
		int respConsulta = sc.nextInt();
		Compra consulta = compras.get(respConsulta);
		exibirCompra(consulta);
		System.out.println("Qual o desconto da compra?");
		compras.get(respConsulta).setDesconto(sc.nextFloat());
		float valorFinal = (compras.get(respConsulta).getDesconto() * compras.get(respConsulta).getPreco() / 100);
		System.out.print("Valor final da compra: " + valorFinal);
		System.out.println("Consulta bem sucedida, voltando ao menu.");

	}

	/* ##### METODO Relatorio ##### */
	public void relatorio() {
		System.out.println("--== Relatorio ]==--");
		exibirCompra();
		System.out.println("Voltando ao menu");
	}

	/* METODO para exibir todos os produtos cadastrados na CLASSE produto */
	public void mostrarProdutos(int cod) {
		int x = 0;
		x = cod;
		Iterator<Produto> p = loja.get(x).getProdutos().iterator();
		while (p.hasNext()) {
			Produto produto = p.next();
			produto.mostrarProduto();
			System.out.println("-=-=-=-=-=-=-=-=-=-=");
		}
	}

	/* Exibir todas as compras */
	public void exibirCompra() {
		int x = 0;
		Iterator<Compra> i = compras.iterator();
		do {
			Compra exibir = i.next();
			System.out.print("Produtos do carrinho: " + x);
			System.out.println("");
			System.out.println("--==[ Informações da Loja ]==-- ");
			System.out.println("Nome da Loja: " + loja.get(x).getNome());
			System.out.println("Código da Loja: " + exibir.getLoja().getCodigo());
			System.out.println("--==[ Informaçãos da venda ]==--");
			exibir.mostrarItensDoCarrinho();
			System.out.println("Valor da compra (Já com desconto aplicado): " + exibir.getPreco());
			System.out.println("-=-=-=-=-=-=-=-=-=-=");
			x++;
		} while (i.hasNext());
	}

	/* Exibir a compra que foi passada como parametro (usado no metodo alterar) */
	public void exibirCompra(Compra compra) {
		Compra exibir = compra;

		System.out.println("--==[ Informações da Loja ]==-- ");
		exibir.getLoja().getNome();
		exibir.getLoja().getCodigo();
		System.out.println("--==[ Informaçãos da venda ]==--");
		exibir.mostrarItensDoCarrinho();
		System.out.println("--==[ Informações do vendedor ]==--");

		System.out.print("Valor da compra (Já com desconto aplicado): " + exibir.getPreco());
		System.out.println("-=-=-=-=-=-=-=-=-=-=");
	}

	private static void clearBuffer(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
	}

}