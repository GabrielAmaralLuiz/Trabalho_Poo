package ficharios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import objetos.Funcionario;

public class FicharioFuncionario {

	private Scanner sc;
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();

	public FicharioFuncionario(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
		sc = new Scanner(System.in);
	}

	public void incluir() {
		Funcionario funcionario;
		int menu = 0;
		do {
			System.out.println("--==[CADASTRO DE FUNCIONÁRIO]==--");
			System.out.println("Escolha uma opcao: ");
			System.out.println("--==[1 - cadastro]==--");
			System.out.println("--==[2 - sair]==--");
			menu = sc.nextInt();

			if (menu == 1) {
				funcionario = new Funcionario();
				sc.nextLine();
				System.out.println("--==[DIGITE OS CAMPOS A BAIXO]==--");
				System.out.println("NOME        :");
				funcionario.setNome(sc.nextLine());
				System.out.println("CPF         :");
				funcionario.setCpf(sc.nextLine());
				System.out.println("CARGO       :");
				funcionario.setCargo(sc.nextLine());
				System.out.println("SALÁRIO     :");
				funcionario.setSalario(sc.nextFloat());
				sc.nextLine();
				System.out.println("RUA         :");
				funcionario.setRua(sc.nextLine());
				System.out.println("BAIRRO      :");
				funcionario.setBairro(sc.nextLine());
				System.out.println("CIDADE      :");
				funcionario.setCidade(sc.nextLine());
				System.out.println("ESTADO      :");
				funcionario.setEstado(sc.nextLine());
				System.out.println("CEP         :");
				funcionario.setCep(sc.nextLine());
				System.out.println("TELEFONE    :");
				funcionario.setTelefone(sc.nextLine());
				funcionarios.add(funcionario);

			}

		} while (menu != 2);
	}

	public void excluir() {
		if (funcionarios.isEmpty()) {
			System.out.println("ArreyList vazio");
			return;
		} else
			imprime();
		sc.nextLine();
		String resp;
		System.out.println("Esolha o cpf do funcionário que deseja excluir: ");
		resp = sc.nextLine();
		int ind = 0;
		boolean achou = false;

		for (int i = 0; i < funcionarios.size(); i++) {
			if (resp.equals(funcionarios.get(i).getCpf())) {
				achou = true;
				ind = i;
				break;
			}
		}
		if (achou) {
			funcionarios.remove(ind);
			System.out.println("funcionário excluído.");
		} else
			System.out.println("Funcionário não encontrado");
	}

	public void alterar() {
		Funcionario funcionario;
		if (funcionarios.isEmpty()) {
			System.out.println("ArreyList vazio");
			return;
		}
		int menu = 0;
		// boolean achou = false;
		do {

			System.out.println("--==[ALTERAÇÃO DE FUNCIONÁRIO]==--");
			System.out.println("Escolha uma opcao: ");
			System.out.println("--==[1 - cadastro]==--");
			System.out.println("--==[2 - sair]==--");
			menu = sc.nextInt();
			sc.nextLine();
			if (menu == 1) {
				String resp;
				imprime();
				System.out.println("Esolha o cpf do funcionário que deseja Alterar: ");
				resp = sc.nextLine();
				int ind = 0;
				boolean achou = false;

				for (int i = 0; i < funcionarios.size(); i++) {
					if (resp.equals(funcionarios.get(i).getCpf())) {
						achou = true;
						ind = i;
						break;
					}
				}
				if (achou) {
					funcionario = funcionarios.get(ind);
					System.out.println("--==[DIGITE OS CAMPOS A BAIXO]==--");

					System.out.println("NOME        :");
					funcionario.setNome(sc.nextLine());
					System.out.println("CPF         :");
					funcionario.setCpf(sc.nextLine());
					System.out.println("CARGO        :");
					funcionario.setCargo(sc.nextLine());
					System.out.println("SALÁRIO     :");
					funcionario.setSalario(sc.nextFloat());
					sc.nextLine();
					System.out.println("RUA         :");
					funcionario.setRua(sc.nextLine());
					System.out.println("BAIRRO      :");
					funcionario.setBairro(sc.nextLine());
					System.out.println("CIDADE      :");
					funcionario.setCidade(sc.nextLine());
					System.out.println("ESTADO      :");
					funcionario.setEstado(sc.nextLine());
					System.out.println("CEP         :");
					funcionario.setCep(sc.nextLine());
					System.out.println("TELEFONE         :");
					funcionario.setTelefone(sc.nextLine());
				} else
					System.out.println("Funcionário não encontrado");
			}
		} while (menu != 2);
	}

	public void consultar() {
		Funcionario func;
		if (funcionarios.isEmpty()) {
			System.out.println("ArreyList Vazio.");
			return;
		} else {
			System.out.println("--==[ C O N S U L T A R]==--");
			imprime();
			String resp;
			boolean achou = false;
			/* Metodo para pesquisar em um ArreyList */
			System.out.println("Esolha o cpf do funcionário que deseja consultar: ");
			resp = sc.nextLine();
			int ind = 0;
			for (int i = 0; i < funcionarios.size(); i++) {
				if (resp.equals(funcionarios.get(i).getCpf())) {
					achou = true;
					ind = i;
					break;

				}
			}
			if (achou) {
				func = funcionarios.get(ind);
				System.out.println("--==[Dados de cadastro do funcionário]==--");
				System.out.println("--=====================================--");
				imprimeConsulata(func);
			} else
				System.out.println("Funcionário inválido ou não exite.");
		}
	}

	public void relatorio() {
		for (int i = 0; i < funcionarios.size(); i++) {
			System.out.println("--==[ R E L A T Ó R I O]==--");
			imprimeTodosOsDados();
			break;
		}
	}

	private void imprime() {
		Iterator<Funcionario> iterator = funcionarios.iterator();

		while (iterator.hasNext()) {
			Funcionario funcionarios = iterator.next();
			System.out.println("CÓDIGO      :" + funcionarios.getCodigo());
			System.out.println("NOME        :" + funcionarios.getNome());
			System.out.println("CPF         :" + funcionarios.getCpf());
			System.out.println("=============");
		}
	}

	private void imprimeConsulata(Funcionario func) {

		System.out.println("CÓDIGO      :" + func.getCodigo());
		System.out.println("NOME        :" + func.getNome());
		System.out.println("CNPJ        :" + func.getCpf());
		System.out.println("CARGO       :" + func.getCargo());
		System.out.println("SALARIO     :" + func.getSalario());
		System.out.println("RUA         :" + func.getRua());
		System.out.println("BAIRRO      :" + func.getBairro());
		System.out.println("CIDADE      :" + func.getCidade());
		System.out.println("ESTADO      :" + func.getEstado());
		System.out.println("CEP         :" + func.getCep());
		System.out.println("TELEFONE    :" + func.getTelefone());
		System.out.println("=============");
	}

	private void imprimeTodosOsDados() {
		Iterator<Funcionario> iterator = funcionarios.iterator();

		while (iterator.hasNext()) {
			Funcionario funcionario = iterator.next();
			System.out.println("CÓDIGO      :" + funcionario.getCodigo());
			System.out.println("NOME        :" + funcionario.getNome());
			System.out.println("CNPJ        :" + funcionario.getCpf());
			System.out.println("CARGO       :" + funcionario.getCargo());
			System.out.println("SALÁRIO     :" + funcionario.getSalario());
			System.out.println("RUA         :" + funcionario.getRua());
			System.out.println("BAIRRO      :" + funcionario.getBairro());
			System.out.println("CIDADE      :" + funcionario.getCidade());
			System.out.println("ESTADO      :" + funcionario.getEstado());
			System.out.println("CEP         :" + funcionario.getCep());
			System.out.println("TELEFONE    :" + funcionario.getTelefone());
			System.out.println("=============");
		}
	}

}
