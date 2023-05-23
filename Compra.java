package objetos;

import java.util.ArrayList;
import java.util.Iterator;

public class Compra {

	private int codigo;
	private Cliente clientes[];

	private ArrayList<Produto> produtos;
	private float preco;
	private float desconto;
	private String nomeDoFuncionario;
	private String codigoDoFuncionario;
	private Loja lojas;

	public Compra() {
		super();
	}

	public Compra(int codigo, Cliente[] clientes, ArrayList<Produto> produtos, float preco, float desconto,
			String nomeDoFuncionario, String codigoDoFuncionario, Loja lojas) {
		super();
		this.codigo = codigo;
		this.clientes = clientes;
		this.produtos = produtos;
		this.preco = preco;
		this.desconto = desconto;
		this.nomeDoFuncionario = nomeDoFuncionario;
		this.codigoDoFuncionario = codigoDoFuncionario;
		this.lojas = lojas;
	}

	public Loja getLoja() {
		return lojas;
	}

	public void setLoja(Loja loja) {
		this.lojas = loja;
	}

	public String getNomeDoFuncionario() {
		return nomeDoFuncionario;
	}

	public void setNomeDoFuncionario(String nomeDoFuncionario) {
		this.nomeDoFuncionario = nomeDoFuncionario;
	}

	public String getCodigoDoFuncionario() {
		return codigoDoFuncionario;
	}

	public void setCodigoDoFuncionario(String codigoDoFuncionario) {
		this.codigoDoFuncionario = codigoDoFuncionario;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}

	public void removerProduto(int x) {
		this.produtos.remove(x);
	}

	public void mostrarItensDoCarrinho() {
		Iterator<Produto> i = produtos.iterator();
		while (i.hasNext()) {
			Produto p = i.next();
			p.mostrarProduto();
		}
	}

	public void mostrarVendedor() {
		System.out.println("Nome do vendedor: " + nomeDoFuncionario);
		System.out.println("Codigo do vendedor: " + codigoDoFuncionario);
	}

	public void somarValorTotal(Produto p) {
		float valor = p.getPreco();
		this.preco += valor;
	}

	public void diminuirValorTotal(Produto p) {
		float valor = p.getPreco();
		this.preco -= valor;
	}

}
