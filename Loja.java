package principal;

public class Loja {
	private Funcionario funcionarios[];
	private Fornecedor fornecedores [];
	private Produto produtos[];
	private int codigo;
	
	public Loja(Funcionario[] funcionarios, Fornecedor[] fornecedores, Produto[] produtos, int codigo) {
		super();
		this.funcionarios = funcionarios;
		this.fornecedores = fornecedores;
		this.produtos = produtos;
		this.codigo = codigo;
	}

	public Loja() {
		super();
	}

	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Fornecedor[] getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedor[] fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
