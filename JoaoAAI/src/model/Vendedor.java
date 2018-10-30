package model;

public class Vendedor extends Pessoa{
	
	//
	private String cnpj;
	private double metaMensal;
	
	//
	public Vendedor () {
		
	}
	public Vendedor(String cnpj, double metaMensal) {
		super();
		this.cnpj = cnpj;
		this.metaMensal = metaMensal;
	}
	
	//
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public double getNomeContato() {
		return metaMensal;
	}
	public void setNomeContato(double metaMensal) {
		this.metaMensal = metaMensal;
	}
	
	
	//
	@Override
	public String toString() {
		return "Vendedor [cnpj=" + cnpj + ", nomeContato=" + metaMensal + "]";
	}
	
	

}
