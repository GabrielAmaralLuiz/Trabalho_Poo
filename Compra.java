package principal;

public class Compra {
	
	private int codigo;
	private Cliente clientes[];
	private Produto produtos[];
	private Loja lojas[];
	private float preco;
	private float desconto;
	public Compra(int codigo, Cliente[] clientes, Produto[] produtos, Loja[] lojas, float preco, float desconto) {
		super();
		this.codigo = codigo;
		this.clientes = clientes;
		this.produtos = produtos;
		this.lojas = lojas;
		this.preco = preco;
		this.desconto = desconto;
	}
	public Compra() {
		super();
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
	public Produto[] getProdutos() {
		return produtos;
	}
	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}
	public Loja[] getLojas() {
		return lojas;
	}
	public void setLojas(Loja[] lojas) {
		this.lojas = lojas;
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
	
	
}
