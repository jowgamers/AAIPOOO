package model;
/**
 * 
 * 
 * @author Joao Vitor
 *
 */
public class Cliente extends Pessoa {
	
	//Atributos
	private String cpf;
	private double limiteCredito;
	
	
	//
	public Cliente () {
		
	}
	
	public Cliente(String cpf, double limiteCredito) {
		super();
		this.cpf = cpf;
		this.limiteCredito = limiteCredito;
	}
	
	//

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	
	//
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", limiteCredito=" + limiteCredito + "]";
	}

	
	

}
