package objetos;

public class Funcionario extends Pessoa {

	private String cargo;
	private float salario;

	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(int codigo, String nome, String cpf, String telefone, String email, String estado, String cidade,
			String rua, String cep, String cargo, float salario) {
		super(codigo, nome, cpf, telefone, email, estado, cidade, rua, cep, cargo, cargo);
		this.cargo = cargo;
		this.salario = salario;

	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public void mostrarDados() {
		System.out.println("Nome: " + getNome());
		System.out.println("Cargo: " + getCargo());

	}

}
