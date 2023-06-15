package ficharios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import objetos.Produto;

public class FicharioProduto {

	private Scanner sc;
	private ArrayList<Produto> produtos = new ArrayList<>();

	public FicharioProduto(ArrayList<Produto> produtos) {
		sc = new Scanner(System.in);
		this.produtos = produtos;
	}

	public void incluir() {
		Produto prod;

		int menu = 0;
		do {
			System.out.println("--==[CADASTRO DE PRODUTOS]==--");
			System.out.println("Escolha uma opção: ");
			System.out.println("--==[1 - cadastro]==--");
			System.out.println("--==[2 - sair]==--");
			menu = sc.nextInt();

			if (menu == 1) {
				prod = new Produto();
				sc.nextLine();
				prod.setCodigo(produtos.size() + 1);
				System.out.println(": NOME                       :");
				prod.setNome(sc.nextLine());
				System.out.println(": INDENTIFICAÇÃO DA EMPRESA  :");
				prod.setIdEmpresa(sc.nextLine());
				System.out.println(": NUMERO DE REGISTRO         :");
				prod.setNumeroRegistro(sc.nextLine());
				System.out.println(": INFORMAÇÃO FARMACEUTICA    :");
				prod.setInformacaoFarmaceutica(sc.nextLine());
				System.out.println(": TELEFONE DO LABORARORIO    :");
				prod.setTelefoneFarmaceuticaRespnsavel(sc.nextLine());
				System.out.println(": TELEFONE DO SAG            :");
				prod.setTelefoneSag(sc.nextLine());
				System.out.println(": IDENTIFICAÇÃO DO LACRE     :");
				prod.setIdLacreSeguranca(sc.nextLine());
				System.out.println(": TARJA                      :");
				prod.setTarja(sc.nextLine());
				System.out.println(": MEDIDA DO MEDICAMENTO      :");
				prod.setMedidaMedicamento(sc.nextLine());
				System.out.println(": DESCRIÇÃO DO MEDICAMENTO   :");
				prod.setDescricaoMedicamento(sc.nextLine());
				System.out.println(": PREÇO                      :");
				prod.setPreco(sc.nextFloat());
				produtos.add(prod);
				System.out.println("Produto cadastrado!");
			}
		} while (menu != 2);

	}

	public void excluir() {
		if (produtos.isEmpty()) {
			System.out.println("ArreyList vazio");
			return;
		} else
			imprime();
		int resp;
		System.out.println("Esolha o codigo do produto que deseja excluir: ");
		resp = sc.nextInt();
		int ind = 0;
		boolean achou = false;

		for (int i = 0; i < produtos.size(); i++) {
			if (resp == produtos.get(i).getCodigo()) {
				achou = true;
				ind = i;
				break;
			}
		}
		if (achou) {
			produtos.remove(ind);
			System.out.println("produto excluído.");
		} else
			System.out.println("produto não encontrado");
	}

	public void alterar() {
		Produto prod;

		int menu = 0;
		do {
			System.out.println("--==[ALTERAÇÃO DE PRODUTOS]==--");
			System.out.println("Escolha uma opcao: ");
			System.out.println("--==[1 - alterar]==--");
			System.out.println("--==[2 - sair]==--");
			menu = sc.nextInt();
			if (menu == 1) {
				int resp;
				imprime();
				System.out.println("Escolha o codigo do produto que deseja Alterar: ");
				resp = sc.nextInt();
				int ind = 0;
				boolean achou = false;

				for (int i = 0; i < produtos.size(); i++) {
					if (resp == produtos.get(i).getCodigo()) {
						achou = true;
						ind = i;
						break;
					}
				}

				if (achou) {
					prod = produtos.get(ind);
					clearBuffer(sc);
					System.out.println(": NOME                       :");
					prod.setNome(sc.nextLine());
					System.out.println(": INDENTIFICAÇÃO DA EMPRESA  :");
					prod.setIdEmpresa(sc.nextLine());
					System.out.println(": NUMERO DE REGISTRO         :");
					prod.setNumeroRegistro(sc.nextLine());
					System.out.println(": INFORMAÇÃO FARMACEUTICA    :");
					prod.setInformacaoFarmaceutica(sc.nextLine());
					System.out.println(": TELEFONE DO LABORARORIO    :");
					prod.setTelefoneFarmaceuticaRespnsavel(sc.nextLine());
					System.out.println(": TELEFONE DO SAG            :");
					prod.setTelefoneSag(sc.nextLine());
					System.out.println(": IDENTIFICAÇÃO DO LACRE     :");
					prod.setIdLacreSeguranca(sc.nextLine());
					System.out.println(": TARJA                      :");
					prod.setTarja(sc.nextLine());
					System.out.println(": MEDIDA DO MEDICAMENTO      :");
					prod.setMedidaMedicamento(sc.nextLine());
					System.out.println(": DESCRIÇÃO DO MEDICAMENTO   :");
					prod.setDescricaoMedicamento(sc.nextLine());
					System.out.println(": PREÇO                      :");
					prod.setPreco(sc.nextFloat());
				} else
					System.out.println("Produto não encontrado");
			}
		} while (menu != 2);
	}

	public void consultar() {
		Produto prod;
		if (produtos.isEmpty()) {
			System.out.println("ArreyList Vazio.");
			return;
		} else {
			System.out.println("--==[ C O N S U L T A R]==--");
			imprime();
			int resp;
			boolean achou = false;
			System.out.println("Escolha o código do produto que deseja consultar: ");
			resp = sc.nextInt();
			int ind = 0;
			for (int i = 0; i < produtos.size(); i++) {
				if (resp == produtos.get(i).getCodigo()) {
					achou = true;
					ind = i;
					break;

				}
			}
			if (achou) {
				prod = produtos.get(ind);
				System.out.println("--==[Dados de cadastro do produto]==--");
				System.out.println("--=====================================--");
				imprimeConsulata(prod);
			} else
				System.out.println("produto inválido ou não exite.");
		}
	}

	public void relatorio() {
		if (!produtos.isEmpty()) {

			for (int i = 0; i < produtos.size(); i++) {
				System.out.println("--==[ R E L A T O R I O]==--");
				imprimeTodosOsDados();
				break;
			}
		}
		else
			System.out.println("Sem produtos cadastrados! cadastre antes de imprimir relatório.");
	}

	private void imprime() {
		Iterator<Produto> iterator = produtos.iterator();

		while (iterator.hasNext()) {
			Produto produto = iterator.next();
			System.out.println(": CODIGO                     :" + produto.getCodigo());
			System.out.println(": NOME                       :" + produto.getNome());
			System.out.println(": INDENTIFICAÇÃO DA EMPRESA  :" + produto.getIdEmpresa());
			System.out.println("=============");
		}
	}

	private void imprimeTodosOsDados() {
		Iterator<Produto> iterator = produtos.iterator();

		while (iterator.hasNext()) {
			Produto prod = iterator.next();
			System.out.println(": CODIGO                     :" + prod.getCodigo());
			System.out.println(": NOME                       :" + prod.getNome());
			System.out.println(": INDENTIFICAÇÃO DA EMPRESA  :" + prod.getIdEmpresa());
			System.out.println(": NUMERO DE REGISTRO         :" + prod.getNumeroRegistro());
			System.out.println(": INFORMAÇÃO FARMACEUTICA    :" + prod.getInformacaoFarmaceutica());
			System.out.println(": TELEFONE DO LABORATÓRIO    :" + prod.getTelefoneFarmaceuticaRespnsavel());
			System.out.println(": TELEFONE DO SAG            :" + prod.getTelefoneSag());
			System.out.println(": IDENTIFICAÇÃO DO LACRE     :" + prod.getIdLacreSeguranca());
			System.out.println(": TARJA                      :" + prod.getTarja());
			System.out.println(": MEDIDA DO MEDICAMENTO      :" + prod.getMedidaMedicamento());
			System.out.println(": DESCRIÇÃO DO MEDICAMENTO   :" + prod.getDescricaoMedicamento());
			System.out.println(": PREÇO                      :" + prod.getPreco());
			System.out.println(":============================:");
		}
	}

	private void imprimeConsulata(Produto prod) {
		System.out.println(": CODIGO                     :" + prod.getCodigo());
		System.out.println(": NOME                       :" + prod.getNome());
		System.out.println(": INDENTIFICAÇÃO DA EMPRESA  :" + prod.getIdEmpresa());
		System.out.println(": NUMERO DE REGISTRO         :" + prod.getNumeroRegistro());
		System.out.println(": INFORMAÇÃO FARMACEUTICA    :" + prod.getInformacaoFarmaceutica());
		System.out.println(": TELEFONE DO LABORATÓRIO    :" + prod.getTelefoneFarmaceuticaRespnsavel());
		System.out.println(": TELEFONE DO SAG            :" + prod.getTelefoneSag());
		System.out.println(": IDENTIFICAÇÃO DO LACRE     :" + prod.getIdLacreSeguranca());
		System.out.println(": TARJA                      :" + prod.getTarja());
		System.out.println(": MEDIDA DO MEDICAMENTO      :" + prod.getMedidaMedicamento());
		System.out.println(": DESCRIÇÃO DO MEDICAMENTO   :" + prod.getDescricaoMedicamento());
		System.out.println(": PREÇO                      :" + prod.getPreco());
		System.out.println(":============================:");
	}
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
