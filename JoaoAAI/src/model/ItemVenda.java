package model;

public class ItemVenda {
	
	private Produto produto;
	private int quantVenda;
	private double valorVenda;
	
	//
	
	public ItemVenda () {
		
	}
	
	public ItemVenda(Produto produto, int quantVenda, double valorVenda) {
		super();
		this.produto = produto;
		this.quantVenda = quantVenda;
		this.valorVenda = valorVenda;
	}
	
	//
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantVenda() {
		return quantVenda;
	}
	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	//
	@Override
	public String toString() {
		return "ItemVenda [produto=" + produto + ", quantVenda=" + quantVenda + ", valorVenda=" + valorVenda + "]";
	}
	
	

}
