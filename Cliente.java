package objetos;

public class Cliente extends Pessoa {
	private String tipoCliente;
	public Cliente() {	
		super();
	}
	public Cliente(int codigo, String nome, String cpf, String cnpj, String telefone, String email, String estado,
			String cidade, String rua, String cep, String bairro) {
		super(codigo, nome, cpf, cnpj, telefone, email, estado, cidade, rua, cep, bairro);
		// TODO Auto-generated constructor stub
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	
}
