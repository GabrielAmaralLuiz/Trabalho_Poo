package principal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class FicharioFonecedor {
	private Scanner sc;
	private ArrayList<Fornecedor> fornecedores = new ArrayList<>();

	public FicharioFonecedor(ArrayList<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
		sc = new Scanner(System.in);
	}

	public void incluir() {
		Fornecedor forn;
		int menu = 0;
		// boolean achou = false;
		do {

			System.out.println("--==[CADASTRO DE FORNECEDOR]==--");
			System.out.println("Escolha uma opcao: ");
			System.out.println("--==[1 - cadastro]==--");
			System.out.println("--==[2 - sair]==--");
			menu = sc.nextInt();
			if (menu == 1) {
				forn = new Fornecedor();
				sc.nextLine();
				System.out.println("--==[DIGITE OS CAMPOS A BAIXO]==--");
				System.out.println("NOME        :");
				forn.setNome(sc.nextLine());
				System.out.println("CNPJ         :");
				forn.setCnpj(sc.nextLine());
				System.out.println("I.E         :");
				forn.setInscricaoEstadual(sc.nextLine());
				System.out.println("RUA         :");
				forn.setRua(sc.nextLine());
				System.out.println("BAIRRO      :");
				forn.setBairro(sc.nextLine());
				System.out.println("CIDADE      :");
				forn.setCidade(sc.nextLine());
				System.out.println("ESTADO      :");
				forn.setEstado(sc.nextLine());
				System.out.println("CEP         :");
				forn.setCep(sc.nextLine());
				System.out.println("TELEFONE         :");
				forn.setTelefone(sc.nextLine());
				Random gerador = new Random();
				int aleatorio = gerador.nextInt(30);
				forn.setCodigo(aleatorio);
				fornecedores.add(forn);

			}
		} while (menu != 2);

	}

	public void excluir() {
		if (fornecedores.isEmpty()) {
			System.out.println("ArreyList vazio");
			return;
		} else
			imprime();
		String resp;
		System.out.println("Esolha o CNPJ do fornecedor que deseja excluir: ");
		resp = sc.nextLine();
		int ind = 0;
		boolean achou = false;

		for (int i = 0; i < fornecedores.size(); i++) {
			if (resp.equals(fornecedores.get(i).getCnpj())) {
				achou = true;
				ind = i;
				break;
			}
		}

		if (achou) {
			fornecedores.remove(ind);
			System.out.println("forencedor excluido.");
		} else
			System.out.println("Fornecedor não encontrado");
	}

	public void alterar() {
		Fornecedor forn;
		if (fornecedores.isEmpty()) {
			System.out.println("ArreyList vazio");
			return;
		}

		int menu = 0;
		// boolean achou = false;
		do {

			System.out.println("--==[ALTERAÇÃO DE FORNECEDOR]==--");
			System.out.println("Escolha uma opcao: ");
			System.out.println("--==[1 - cadastro]==--");
			System.out.println("--==[2 - sair]==--");
			menu = sc.nextInt();
			if (menu == 1) {
				String resp;
				imprime();
				System.out.println("Esolha o CNPJ do fornecedor que deseja Alterar: ");
				resp = sc.next();
				int ind = 0;
				boolean achou = false;

				for (int i = 0; i < fornecedores.size(); i++) {
					if (resp.equals(fornecedores.get(i).getCnpj())) {
						achou = true;
						ind = i;
						break;
					}
				}

				if (achou) {

					forn = fornecedores.get(ind);
					sc.nextLine();
					System.out.println("--==[ VAMOS ALTERAR]==--");
					System.out.println("--==[DIGITE OS CAMPOS A BAIXO]==--");
					System.out.println("NOME        :");
					forn.setNome(sc.nextLine());
					System.out.println("CNPJ         :");
					forn.setCnpj(sc.nextLine());
					System.out.println("I.E         :");
					forn.setInscricaoEstadual(sc.nextLine());
					System.out.println("RUA         :");
					forn.setRua(sc.nextLine());
					System.out.println("BAIRRO      :");
					forn.setBairro(sc.nextLine());
					System.out.println("CIDADE      :");
					forn.setCidade(sc.nextLine());
					System.out.println("ESTADO      :");
					forn.setEstado(sc.nextLine());
					System.out.println("CEP         :");
					forn.setCep(sc.nextLine());
					System.out.println("TELEFONE         :");
					forn.setTelefone(sc.nextLine());
					System.out.println("forencedor alterado.");
				} else
					System.out.println("Fornecedor não encontrado");
			}
		} while (menu != 2);
	}

	public void consultar() {
		Fornecedor forn;
		if (fornecedores.isEmpty()) {
			System.out.println("ArreyList Vazio.");
			return;
		} else {
			System.out.println("--==[ C O N S U L T A R]==--");
			imprime();
			String resp;
			boolean achou = false;
			/* Metodo para pesquisar em um ArreyList */
			System.out.println("Esolha o CNPJ do fornecedor que deseja consultar: ");
			resp = sc.nextLine();
			int ind = 0;
			for (int i = 0; i < fornecedores.size(); i++) {
				if (resp.equals(fornecedores.get(i).getCnpj())) {
					achou = true;
					ind = i;
					break;

				}
			}
			if (achou) {
				forn = fornecedores.get(ind);
				System.out.println("--==[Dados de cadastro do fornecedor]==--");
				System.out.println("--=====================================--");
				imprimeConsulata(forn);
			} else
				System.out.println("Fornecedor invalido ou não exite.");
		}
	}

	public void relatorio() {
		for (int i = 0; i < fornecedores.size(); i++) {
			System.out.println("--==[ R E L A T O R I O]==--");
			imprimeTodosOsDados();
			break;
		}
	}

	private void imprime() {
		Iterator<Fornecedor> iterator = fornecedores.iterator();

		while (iterator.hasNext()) {
			Fornecedor fornecedor = iterator.next();
			System.out.println("CODIGO      :" + fornecedor.getCodigo());
			System.out.println("NOME        :" + fornecedor.getNome());
			System.out.println("CNPJ        :" + fornecedor.getCnpj());
			System.out.println("=============");
		}
	}

	private void imprimeConsulata(Fornecedor forn) {

		System.out.println("CODIGO      :" + forn.getCodigo());
		System.out.println("NOME        :" + forn.getNome());
		System.out.println("CNPJ        :" + forn.getCnpj());
		System.out.println("I.E         :" + forn.getInscricaoEstadual());
		System.out.println("RUA         :" + forn.getRua());
		System.out.println("BAIRRO      :" + forn.getBairro());
		System.out.println("CIDADE      :" + forn.getCidade());
		System.out.println("ESTADO      :" + forn.getEstado());
		System.out.println("CEP         :" + forn.getCep());
		System.out.println("TELEFONE    :" + forn.getTelefone());
		System.out.println("=============");
	}

	private void imprimeTodosOsDados() {
		Iterator<Fornecedor> iterator = fornecedores.iterator();

		while (iterator.hasNext()) {
			Fornecedor fornecedor = iterator.next();
			System.out.println("CODIGO      :" + fornecedor.getCodigo());
			System.out.println("NOME        :" + fornecedor.getNome());
			System.out.println("CNPJ        :" + fornecedor.getCnpj());
			System.out.println("I.E         :" + fornecedor.getInscricaoEstadual());
			System.out.println("RUA         :" + fornecedor.getRua());
			System.out.println("BAIRRO      :" + fornecedor.getBairro());
			System.out.println("CIDADE      :" + fornecedor.getCidade());
			System.out.println("ESTADO      :" + fornecedor.getEstado());
			System.out.println("CEP         :" + fornecedor.getCep());
			System.out.println("TELEFONE    :" + fornecedor.getTelefone());
			System.out.println("=============");
		}
	}
}
