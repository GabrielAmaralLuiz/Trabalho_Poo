package objetos;

import java.util.ArrayList;
import java.util.Iterator;

public class Loja {
	private int codigo;
	private String nome;

	ArrayList<Produto> produtos;
	ArrayList<Funcionario> funcionarios;

	public Loja(int codigo, ArrayList<Produto> produtos, String nome, ArrayList<Funcionario> funcionarios) {
		this.codigo = codigo;
		this.funcionarios = funcionarios;
		this.produtos = produtos;
		this.nome = nome;

	}

	public Loja() {
		this.produtos = new ArrayList<>();
		this.funcionarios = new ArrayList<>();
	}

	void mostrarProdutos() {
		Iterator<Produto> itr = produtos.iterator();
		while (itr.hasNext()) {
			Produto produto = (Produto) itr.next();
			System.out.println("----Produtos----");
		}

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void mostrarDados() {
		System.out.println("Nome: " + nome);
		System.out.println("Codigo: " + codigo);
		System.out.println();

	}

	public void mostrarLojaComProdutos() {
		mostrarDados();
		for (int i = 0; i < produtos.size(); i++) {
			produtos.get(i).mostrarProduto();
		}

	}

	private void imprime() {

		System.out.println("--===[LOJAS]===--");
		System.out.println(": CODIGO                     :" + codigo);
		System.out.println(": NOME                       :" + nome);
		System.out.println("=============");

	}

}
