package ficharios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import objetos.Compra;
import objetos.Loja;
import objetos.Produto;

public class FicharioCompra {

	private Scanner sc;
	private Produto produto[];
	private ArrayList<Compra> compras = new ArrayList<>();
	private Loja loja = new Loja();;

	public FicharioCompra(ArrayList<Compra> compra) {
		sc = new Scanner(System.in);
	}

	/* ##### METODO INCLUIR ##### */
	public void incluir() {
		Compra compra = new Compra();
		Produto p;
		System.out.println("--==[ Inclusão de compra ]==--");

		int opProduto = 0;
		int indiceProduto = 0;
		do {
			System.out.println("1 - Adicionar");
			System.out.println("2 - Remover");
			System.out.println("3 - Sair");
			int resp = sc.nextInt();
			if (resp == 1) {
				System.out.println("Escolha o produto para adicionar no carrinho");
				mostrarProdutos();
				indiceProduto = sc.nextInt();
				p = loja.getProdutos().get(indiceProduto);
				compra.somarValorTotal(p);
				compra.addProduto(p);
				System.out.println("Produto adicionado ao carrinho com sucesso!!!");
			} else if ((resp == 2) && (!compra.getProdutos().isEmpty())) {
				System.out.println("Escolha o produto que deseja remover do carrinho: ");
				compra.mostrarItensDoCarrinho();
				int posProduto = sc.nextInt();
				compra.removerProduto(posProduto);
				Produto produto = new Produto();
				produto = compra.getProdutos().get(indiceProduto);
				compra.diminuirValorTotal(produto);
				System.out.println("Produto retirado do carrinho com sucesso!!!");
			}

		} while (opProduto != 3);
		System.out.println("Digite o nome do funcionario que realizou a venda.");
		compra.setNomeDoFuncionario(sc.next());
		System.out.println("Digite o codigo do funcionario que realizou a venda.");
		compra.setCodigoDoFuncionario(sc.next());
		System.out.println("Dados do funcionario registrado com sucesso!!!");
		System.out.println("--==[ Voltando ao menu de compra ]==--");
	}

	/* ##### METODO Excluir ##### */
	public void excluir() {
		System.out.println("--=[ Exclusão ]==--");
		System.out.println("Qual compra deseja alterar?");
		exibirCompra();
		System.out.println("Selecione a compra: ");
		int opMudar = sc.nextInt();
		Compra comp = new Compra();
		comp = compras.get(opMudar);
		exibirCompra(comp);
		System.out.println("Esta é a compra que deseja excluir? (1-Sim/2- Não)");
		int op = sc.nextInt();
		if (op == 1) {
			compras.remove(opMudar);
			System.out.println("dados excluidos com sucesso!!!");
		} else {
			System.out.println("Operação cancelada!!!");
		}
		System.out.println("--==[ Voltando ao menu de compra ]==--");

	}

	/* ##### METODO Alterar ##### */
	public void alterar() {
		System.out.println("--=[ alteração ]==--");
		int resp;
		System.out.println("Qual compra deseja alterar?");
		exibirCompra();
		System.out.println("Selecione a compra: ");
		int opMudar = sc.nextInt();
		Compra comp = new Compra();
		comp = compras.get(opMudar);
		exibirCompra(comp);
		System.out.println("Esta é a compra que deseja alterar? (1-Sim/2- Não)");
		int op = sc.nextInt();
		if (op == 1) {
			do {

				System.out.println("--=[ alteração ]==--");
				System.out.println("Selecione qual opção deseja alterar:");
				System.out.println("1 - Itens do carrinho: ");
				System.out.println("2 - Funcionario que realizou a venda: ");
				System.out.println("3 - Data da compra: ");
				System.out.println("4 - Voltar ao meno de compra.");
				resp = sc.nextInt();
				switch (resp) {
				case 1:

					System.out.println("Deseja adicionar ou excluir itens do carrinho? (1 - Adicionar / 2- Excluir");
					int respAdicionarOuExcluir = sc.nextInt();
					if (respAdicionarOuExcluir == 1) {
						System.out.println("Escolha o produto para adicionar no carrinho");
						mostrarProdutos();
						int indiceProduto = sc.nextInt();
						Produto p = loja.getProdutos().get(indiceProduto);
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
					System.out.println("Exibindo funcionario que realizou a venda: ");
					compras.get(opMudar).mostrarVendedor();
					System.out.println("Deseja continuar a troca? (1-Sim / 2-Não");
					int confirmacao = sc.nextInt();

					if (confirmacao == 1) {
						System.out.print("Digite o nome do funcionario que realizou a venda: ");
						compras.get(opMudar).setNomeDoFuncionario(sc.next());
						System.out.println("Digite o codigo do funcionario que realizou a venda");
						compras.get(opMudar).setCodigoDoFuncionario(sc.next());
					} else {
						System.out.println("Troca do funcionario cancelada!!!");
					}
					break;
				case 3:
            /* #########@@@@@@@@@@@@@@@        FINALIZAR ESSA OPÇÃO (MUDAR A DATA DA COMPRA) #########@@@@@@@@@@@@@@@@@@     */
					break;
				case 4:
					System.out.println("Voltando ao menu principal!!!");
					break;
				default:
					System.out.println("Opção invalida!!!");
					break;
				}
			} while (resp != 4);

		}
		System.out.println("--==[ Voltando ao menu de compra ]==--");
	}

	/* ##### METODO Consultar ##### */
	public void consultar() {
		System.out.println("--==[ Consulta ]==--");
		System.out.println("Digite a posição da compra que quer ver as informações: ");
		int respConsulta= sc.nextInt();
		Compra consulta = compras.get(respConsulta);
		exibirCompra(consulta);
		System.out.println("Consulta bem sucedida, voltando ao menu.");
		
	}

	/* ##### METODO Relatorio #####*/
	public void relatorio() {
		System.out.println("--== Relatorio ]==--");
		exibirCompra();
		System.out.println("Voltando ao menu");
	}

	/* METODO para exibir todos os produtos cadastrados na CLASSE produto */
	public void mostrarProdutos() {
		Iterator<Produto> p = loja.getProdutos().iterator();
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
			System.out.print("Produtos do carrinho: "+x);
			System.out.println("--==[ Informações da Loja ]==-- ");
			exibir.getLoja().getNome();
			exibir.getLoja().getCodigo();
			System.out.println("--==[ Informaçãos da venda ]==--");
			exibir.mostrarItensDoCarrinho();
			System.out.println("--==[ Informações do vendedor ]==--");
			exibir.mostrarVendedor();
			System.out.print("Valor da compra (Já com desconto aplicado): " + exibir.getPreco());
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
		exibir.mostrarVendedor();
		System.out.print("Valor da compra (Já com desconto aplicado): " + exibir.getPreco());
		System.out.println("-=-=-=-=-=-=-=-=-=-=");
	}

}
