package ficharios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import objetos.Cliente;

public class FicharioCliente {
	Scanner sc = new Scanner(System.in);
	private ArrayList<Cliente> clientes = new ArrayList<>();

	public FicharioCliente(ArrayList<Cliente> clientes) {
		this.clientes = clientes;

	}

	public void consultar() {
		Cliente cli;
		if (clientes.isEmpty()) {
			System.out.println("ArreyList Vazio.");
			return;
		} else {
			System.out.println("--==[ C O N S U L T A R]==--");
			imprime();
			String resp;
			boolean achou = false;
			/* Metodo para pesquisar em um ArreyList */
			System.out.println("Esolha o CNPJ do cliente que deseja consultar: ");
			resp = sc.nextLine();
			int ind = 0;
			for (int i = 0; i < clientes.size(); i++) {
				if (resp.equals(clientes.get(i).getCpf())) {
					achou = true;
					ind = i;
					break;

				}
			}
			if (achou) {
				cli = clientes.get(ind);
				System.out.println("--==[Dados de cadastro do cliente]==--");
				System.out.println("--=====================================--");
				imprimeConsulata(cli);
			} else
				System.out.println("cliente invalido ou não exite.");
		}
	}

	public void relatorio() {
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println("--==[ R E L A T O R I O]==--");
			System.out.println("" + c.getTime());
			imprimeTodosOsDados();
			break;
		}
	}

	public void incluir() {
		int opPessoa = 0;
		Cliente cli = new Cliente();
		System.out.println("--==[DIGITE OS CAMPOS A BAIXO]==--");
		System.out.println("NOME        :");
		cli.setNome(sc.nextLine());

		do {
			System.out.println("[DIGITE 1 PARA PESSOA FISICA OU 2 PARA PESSOA JURIDICA]");
			opPessoa = sc.nextInt();

		} while (opPessoa != 1 && opPessoa != 2);
		sc.nextLine();
		if (opPessoa == 1) {
			System.out.println("CPF        :");
			cli.setCpf(sc.nextLine());

		} else {
			System.out.println("CNPJ        :");
			cli.setCnpj(sc.nextLine());
		}

		System.out.println("RUA         :");
		cli.setRua(sc.nextLine());
		System.out.println("BAIRRO      :");
		cli.setBairro(sc.nextLine());
		System.out.println("CIDADE      :");
		cli.setCidade(sc.nextLine());
		System.out.println("ESTADO      :");
		cli.setEstado(sc.nextLine());
		System.out.println("CEP         :");
		cli.setCep(sc.nextLine());
		System.out.println("TELEFONE         :");
		cli.setTelefone(sc.nextLine());
		Random gerador = new Random();
		int aleatorio = gerador.nextInt(30);
		cli.setCodigo(aleatorio);
		clientes.add(cli);
	}

	public void alterar() {
		Cliente cli;
		if (clientes.isEmpty()) {
			System.out.println("ArreyList vazio");
			return;
		} else
			imprime();
		System.out.println("Esolha o codigo do cliente que deseja Alterar: ");
		int resp = sc.nextInt();
		int ind = 0;
		boolean achou = false;

		for (int i = 0; i < clientes.size(); i++) {
			achou = true;
			ind = i;
			break;
		}

		if (achou) {
			cli = clientes.get(ind);
			sc.nextLine();
			System.out.println("--==[ VAMOS ALTERAR]==--");
			System.out.println("--==[DIGITE OS CAMPOS A BAIXO]==--");
			System.out.println("NOME        :");
			cli.setNome(sc.nextLine());
			System.out.println("[DIGITE 1 PARA PESSOA FISICA OU 2 PARA PESSOA JURIDICA]");
			System.out.println("CPF         :");
			cli.setCpf(sc.nextLine());

			System.out.println("RUA         :");
			cli.setRua(sc.nextLine());
			System.out.println("BAIRRO      :");
			cli.setBairro(sc.nextLine());
			System.out.println("CIDADE      :");
			cli.setCidade(sc.nextLine());
			System.out.println("ESTADO      :");
			cli.setEstado(sc.nextLine());
			System.out.println("CEP         :");
			cli.setCep(sc.nextLine());
			System.out.println("TELEFONE         :");
			System.out.println("Cliente  alterado.");
		} else
			System.out.println("cliente não encontrado");
	}

	public void excluir() {
		Cliente cli;
		if (clientes.isEmpty()) {
			System.out.println("ArreyList vazio");
			return;
		} else
			imprime();
		System.out.println("Esolha o codigo do cliente que deseja Alterar: ");
		int resp = sc.nextInt();
		int ind = 0;
		boolean achou = false;

		for (int i = 0; i < clientes.size(); i++) {
			achou = true;
			ind = i;
			break;
		}
		if (achou) {
			clientes.remove(ind);
			System.out.println("cliente  removido");

		} else
			System.out.println("cliente nao removido");

	}

	private void imprime() {
		Iterator<Cliente> iterator = clientes.iterator();

		while (iterator.hasNext()) {
			Cliente cliente = iterator.next();
			System.out.println("CODIGO      :" + cliente.getCodigo());
			System.out.println("NOME        :" + cliente.getNome());
			System.out.println("CPF        :" + cliente.getCpf());
			System.out.println("=============");
		}
	}

	private void imprimeConsulata(Cliente cli) {

		System.out.println("CODIGO      :" + cli.getCodigo());
		System.out.println("NOME        :" + cli.getNome());
		System.out.println("CPF        :" + cli.getCpf());
		System.out.println("RUA         :" + cli.getRua());
		System.out.println("BAIRRO      :" + cli.getBairro());
		System.out.println("CIDADE      :" + cli.getCidade());
		System.out.println("ESTADO      :" + cli.getEstado());
		System.out.println("CEP         :" + cli.getCep());
		System.out.println("TELEFONE    :" + cli.getTelefone());
		System.out.println("=============");
	}

	private void imprimeTodosOsDados() {
		Iterator<Cliente> iterator = clientes.iterator();

		while (iterator.hasNext()) {
			Cliente cliente = iterator.next();
			System.out.println("CODIGO      :" + cliente.getCodigo());
			System.out.println("NOME        :" + cliente.getNome());
			System.out.println("CPF         :" + cliente.getCpf());
			System.out.println("RUA         :" + cliente.getRua());
			System.out.println("BAIRRO      :" + cliente.getBairro());
			System.out.println("CIDADE      :" + cliente.getCidade());
			System.out.println("ESTADO      :" + cliente.getEstado());
			System.out.println("CEP         :" + cliente.getCep());
			System.out.println("TELEFONE    :" + cliente.getTelefone());
			System.out.println("=============");
		}
	}
}
