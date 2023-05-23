package objetos;

import java.util.ArrayList;
import java.util.Iterator;

public class Loja {
	private int codigo;
	private String nome;

	ArrayList<Produto> produtos;

	public Loja(int codigo, ArrayList<Produto> produtos, String nome) {
		this.codigo = codigo;

		this.produtos = produtos;
		this.nome = nome;
	}

	public Loja() {
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

	public void mostrarDados() {
		System.out.println("Nome: " + nome);
		System.out.println("Codigo: " + codigo);
		System.out.println();

	}

	public void mostrarLojaComProdutos() {
		mostrarDados();
		produtos.forEach(p -> p.mostrarProduto());
		
	}
	
	
	private void imprime() {

		System.out.println("--===[LOJAS]===--");
		System.out.println(": CODIGO                     :" + codigo);
		System.out.println(": NOME                       :" + nome);
		System.out.println("=============");

	}

}
