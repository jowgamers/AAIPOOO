package model;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
	private int numCompra;
	private Fornecedor fornecedor;
	private Date dataCompra;
	private ArrayList<ItemCompra> compraItens = new ArrayList<ItemCompra>();
	
	public Compra () {
		
	}
	
	public Compra(int numCompra, Fornecedor fornecedor, Date dataCompra, ArrayList<ItemCompra> compraItens) {
		super();
		this.numCompra = numCompra;
		this.fornecedor = fornecedor;
		this.dataCompra = dataCompra;
		this.compraItens = compraItens;
	}


	public int getNumCompra() {
		return numCompra;
	}


	public void setNumCompra(int numCompra) {
		this.numCompra = numCompra;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public Date getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}


	public ArrayList<ItemCompra> getCompraItens() {
		return compraItens;
	}


	public void setCompraItens(ArrayList<ItemCompra> compraItens) {
		this.compraItens = compraItens;
	}


	@Override
	public String toString() {
		return "Compra [numCompra=" + numCompra + ", fornecedor=" + fornecedor + ", dataCompra=" + dataCompra
				+ ", compraItens=" + compraItens + "]";
	}

	
	
}
