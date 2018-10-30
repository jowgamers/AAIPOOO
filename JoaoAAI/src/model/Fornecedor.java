package model;

public class Fornecedor extends Pessoa{
	
	private String cnpj;
	private String nomeContato;
	

	public Fornecedor(String cnpj, String nomeContato) {
		super();
		this.cnpj = cnpj;
		this.nomeContato = nomeContato;
	}
	
	public Fornecedor () {
		
	}
	
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeContato() {
		return nomeContato;
	}
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	@Override
	public String toString() {
		return "Fornecedor [cnpj=" + cnpj + ", nomeContato=" + nomeContato + "]";
	}
	
	
	
}

