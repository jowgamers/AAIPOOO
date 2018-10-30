package model;

import java.util.Date;

public class Produto {

	private int codigo;
	private String nome;
	private double precoUnitario;
	private int estoque;
	private int estoqueminimo;
	private Date dataCad;
	
	
	public Produto () {
		
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
	
	
	
}
