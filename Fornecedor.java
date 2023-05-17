package principal;

public class Fornecedor extends Pessoa {
	
	private String cnpj;
	private String inscricaoEstadual;
	public Fornecedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fornecedor(int codigo, String nome, String cpf, String telefone, String email, String estado, String cidade,
			String rua, String cep, String cnpj, String inscricaoEstadual) {
		super(codigo, nome, cpf, telefone, email, estado, cidade, rua, cep, inscricaoEstadual);
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		// TODO Auto-generated constructor stub
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
}
