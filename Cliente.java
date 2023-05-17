package principal;

public class Cliente extends Pessoa {
	private String tipoCliente;
	public Cliente() {	
		super();
	}

	public Cliente(int codigo, String nome, String cpf, String telefone, String email, String estado, String cidade,
			String rua, String cep, String tipoCliente) {
		super(codigo, nome, cpf, telefone, email, estado, cidade, rua, cep, tipoCliente);
		
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
}
