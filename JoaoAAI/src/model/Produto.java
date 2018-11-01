package model;

import java.util.Date;

public class Produto implements Comparable{

	private int codigo;
	private String nome;
	private double precoUnitario;
	private int estoque;
	private int estoqueminimo;
	private Date dataCad;
	
	//Decrementar estoque
	
	/**
	 * @Metodo não testado
	 * @param qntde
	 */
	private void addQntde (int qntde) {
		qntde += getEstoque();
		setEstoque(qntde);
	}
	
	/**
	 * @Metodo não testado
	 * @param qntde // Nao aceitar valores negativos -- Metodo não está pronto
	 */
	private void decreQntde (int qntde) throws SisComException{

		try {
			qntde -= getEstoque();
			setEstoque(qntde);
		} catch (Exception e) {
			throw new SisComException("Quantidade insuficiente");
		}
		
	}
	public Produto () {
		
	}
	/**
	 * 
	 */
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}
	
	
	public Produto(int codigo, String nome, double precoUnitario, int estoque, int estoqueminimo, Date dataCad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.estoque = estoque;
		this.estoqueminimo = estoqueminimo;
		this.dataCad = dataCad;
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
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public int getEstoqueminimo() {
		return estoqueminimo;
	}
	public void setEstoqueminimo(int estoqueminimo) {
		this.estoqueminimo = estoqueminimo;
	}
	public Date getDataCad() {
		return dataCad;
	}
	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}
	/**
	 * 
	 * 
	 */
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", precoUnitario=" + precoUnitario + ", estoque="
				+ estoque + ", estoqueminimo=" + estoqueminimo + ", dataCad=" + dataCad + "]";
	}

	
	
}
