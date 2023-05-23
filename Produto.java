package objetos;

public class Produto {
	private int codigo;
	private String nome;
	private String idEmpresa;
	private String numeroRegistro;
	private String informacaoFarmaceutica;
	private String telefoneFarmaceuticaRespnsavel;
	private String telefoneSag;
	private String idLacreSeguranca;
	private String tarja;
	private String medidaMedicamento;
	private String descricaoMedicamento;
	private float preco;
	
	public Produto(int codigo, String nome, String idEmpresa, String numeroRegistro, String informacaoFarmaceutica,
			String telefoneFarmaceuticaRespnsavel, String telefoneSag, String idLacreSeguranca, String tarja,
			String medidaMedicamento, String descricaoMedicamento, float preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.idEmpresa = idEmpresa;
		this.numeroRegistro = numeroRegistro;
		this.informacaoFarmaceutica = informacaoFarmaceutica;
		this.telefoneFarmaceuticaRespnsavel = telefoneFarmaceuticaRespnsavel;
		this.telefoneSag = telefoneSag;
		this.idLacreSeguranca = idLacreSeguranca;
		this.tarja = tarja;
		this.medidaMedicamento = medidaMedicamento;
		this.descricaoMedicamento = descricaoMedicamento;
		this.preco = preco;
	}
	public Produto() {
		super();
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
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public String getInformacaoFarmaceutica() {
		return informacaoFarmaceutica;
	}
	public void setInformacaoFarmaceutica(String informacaoFarmaceutica) {
		this.informacaoFarmaceutica = informacaoFarmaceutica;
	}
	public String getTelefoneFarmaceuticaRespnsavel() {
		return telefoneFarmaceuticaRespnsavel;
	}
	public void setTelefoneFarmaceuticaRespnsavel(String telefoneFarmaceuticaRespnsavel) {
		this.telefoneFarmaceuticaRespnsavel = telefoneFarmaceuticaRespnsavel;
	}
	public String getTelefoneSag() {
		return telefoneSag;
	}
	public void setTelefoneSag(String telefoneSag) {
		this.telefoneSag = telefoneSag;
	}
	public String getIdLacreSeguranca() {
		return idLacreSeguranca;
	}
	public void setIdLacreSeguranca(String idLacreSeguranca) {
		this.idLacreSeguranca = idLacreSeguranca;
	}
	public String getTarja() {
		return tarja;
	}
	public void setTarja(String tarja) {
		this.tarja = tarja;
	}
	public String getMedidaMedicamento() {
		return medidaMedicamento;
	}
	public void setMedidaMedicamento(String medidaMedicamento) {
		this.medidaMedicamento = medidaMedicamento;
	}
	public String getDescricaoMedicamento() {
		return descricaoMedicamento;
	}
	public void setDescricaoMedicamento(String descricaoMedicamento) {
		this.descricaoMedicamento = descricaoMedicamento;
	}
	public float getPreco() {
		return preco;	
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void mostrarProduto() {
		System.out.println("Nome do produto: "+nome);
		System.out.println("Numero do registro do produto: "+numeroRegistro);
		System.out.println("Codigo do produto: "+codigo);
		
	}
	
}
