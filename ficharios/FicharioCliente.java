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
		int ind = 0;
	
		if (clientes.isEmpty()) {
			System.out.println("ArreyList Vazio.");
			return;
		} else {
			System.out.println("--==[ C O N S U L T A R]==--");
			imprime();
			int resp;
			boolean achou = false;
			/* Metodo para pesquisar em um ArreyList */
			System.out.println("Digite o código do cliente");
			resp=sc.nextInt();
			for (int i = 0; i < clientes.size(); i++) {

				if (resp== clientes.get(i).getCodigo()) {
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
		if (clientes.isEmpty()) {
			System.out.println("Sem clientes cadastrados! Inclua antes de tentar gerar um relatório.");
		} else {
			Calendar c = Calendar.getInstance();
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println("--==[ R E L A T Ó R I O]==--");
				System.out.println("" + c.getTime());
				imprimeTodosOsDados();
				break;
			}
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
		int aleatorio = gerador.nextInt(100);
		cli.setCodigo(aleatorio);
		clientes.add(cli);
		System.out.println("Cliente cadastrado!!");
	}

	public void alterar() {
		Cliente cli;
		if (clientes.isEmpty()) {
			System.out.println("Sem clientes cadastrados! inclua antes de alterar!");
			return;
		} else
			imprime();
		System.out.println("Esolha o código do cliente que deseja Alterar: ");
		int resp = sc.nextInt();
		int ind = 0;
		boolean achou = false;

		for (int i = 0; i < clientes.size(); i++) {
			if (resp == clientes.get(i).getCodigo()) {
				achou = true;
				ind = i;
				break;

			}
		}

		if (achou) {
			int opPessoa;
			cli = clientes.get(ind);
			sc.nextLine();
			System.out.println("--==[ VAMOS ALTERAR]==--");
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
			System.out.println("Cliente  alterado.");
		} else
			System.out.println("cliente não encontrado");
	}

	public void excluir() {
		
		if (clientes.isEmpty()) {
			System.out.println("Sem clientes cadastrados! inclua antes de excluir!");
			return;
		} else
			imprime();
		System.out.println("Esolha o código do cliente que deseja excluir: ");
		int resp = sc.nextInt();
		int ind = 0;
		boolean achou = false;

		for (int i = 0; i < clientes.size(); i++) {
			if (resp == clientes.get(i).getCodigo()) {
				achou = true;
				ind = i;
				break;

			}
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
			System.out.println("CÓDIGO      :" + cliente.getCodigo());
			System.out.println("NOME        :" + cliente.getNome());
			if (cliente.getCpf() == null) {
				System.out.println("CPNJ        :" + cliente.getCnpj());
			} else {
				System.out.println("CPF        :" + cliente.getCpf());
			}
			System.out.println("=============");
		}
	}

	private void imprimeConsulata(Cliente cli) {

		System.out.println("CÓDIGO      :" + cli.getCodigo());
		System.out.println("NOME        :" + cli.getNome());
		if (cli.getCpf() == null) {
			System.out.println("CPNJ        :" + cli.getCnpj());
		} else {
			System.out.println("CPF        :" + cli.getCpf());
		}

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
			System.out.println("CÓDIGO      :" + cliente.getCodigo());
			System.out.println("NOME        :" + cliente.getNome());
			if (cliente.getCpf() == null) {
				System.out.println("CPNJ        :" + cliente.getCnpj());
			} else {
				System.out.println("CPF         :" + cliente.getCpf());
			}
			System.out.println("RUA         :" + cliente.getRua());
			System.out.println("BAIRRO      :" + cliente.getBairro());
			System.out.println("CIDADE      :" + cliente.getCidade());
			System.out.println("ESTADO      :" + cliente.getEstado());
			System.out.println("CEP         :" + cliente.getCep());
			System.out.println("TELEFONE    :" + cliente.getTelefone());
			System.out.println("=============");
		}
	}
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
