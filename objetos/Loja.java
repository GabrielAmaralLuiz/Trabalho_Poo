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
	public void mostrarDados(Loja lojas) {
		Loja m = lojas;
		System.out.println("Nome: " + m.getNome());
		System.out.println("Codigo: " + m.getCodigo());
		System.out.println();

	}

	public void mostrarLojaComProdutos() {
		for (int i = 0; i < produtos.size(); i++) {
			produtos.get(i).mostrarProduto();
		}

	}
	void mostrarProdutos() {
		Iterator<Produto> itr = produtos.iterator();
		while (itr.hasNext()) {
			Produto produto = (Produto) itr.next();
			System.out.println("----Produtos----");
			System.out.println("Código:    " + produto.getCodigo());
			System.out.println("Nome:    " + produto.getNome());
			System.out.println("Preço:    " + produto.getPreco());
			
		}

	}
	

	private void imprime() {

		System.out.println("--===[LOJAS]===--");
		System.out.println(": CODIGO                     :" + codigo);
		System.out.println(": NOME                       :" + nome);
		System.out.println("=============");

	}

}
