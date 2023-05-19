package principal;

import java.util.ArrayList;
import java.util.Iterator;

public class Loja {
int codigo;
String nome;
ArrayList<Funcionario> funcionarios;
ArrayList<Produto> produtos;
public Loja(int codigo, ArrayList<Funcionario> funcionarios, ArrayList<Produto> produtos,String nome) {
	this.codigo = codigo;
	this.funcionarios = funcionarios;
	this.produtos = produtos;
	this.nome = nome;
}

public Loja() {

}
	
void mostrarFuncionarios(){
	Iterator<Funcionario> itr = funcionarios.iterator();
	while (itr.hasNext()) {
		Funcionario funcionario =  itr.next();
		System.out.println("----Funcionarios----");
		funcionario.mostrarDados();
	}
}
void mostrarProdutos(){
	Iterator<Produto> itr = produtos.iterator();
while (itr.hasNext()) {
	Produto produto = (Produto) itr.next();
	System.out.println("----Produtos----");
	produto.mostrarDados();
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

public ArrayList<Funcionario> getFuncionarios() {
	return funcionarios;
}

public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
	this.funcionarios = funcionarios;
}

public ArrayList<Produto> getProdutos() {
	return produtos;
}

public void setProdutos(ArrayList<Produto> produtos) {
	this.produtos = produtos;
}

public void mostrarDados() {
System.out.println("Nome: "+nome);
System.out.println("Codigo: "+codigo);
System.out.println();

}


	
}
