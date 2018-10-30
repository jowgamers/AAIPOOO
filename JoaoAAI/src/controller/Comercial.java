package controller;

import java.util.ArrayList;

import model.ItemCompra;
import model.ItemVenda;
import model.Pessoa;
import model.Produto;


public class Comercial {

	
	private ArrayList<Produto> produto = new ArrayList<Produto>();
	private ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
	private ArrayList<ItemCompra> itemCompra = new ArrayList<ItemCompra>();
	private ArrayList<ItemVenda> itemVenda = new ArrayList<ItemVenda>();
	
	/**
	 * @author Joao Vitor
	 * @param produto
	 * @throws Exception
	 */
	public void cadastrarProduto(Produto produto) throws Exception {
		boolean adicionar = getProduto().add(produto);
		if (!adicionar) {
			throw new Exception("Erro ao cadastrar produto!!!");
		}
	}
	
	/**
	 * @author Joao Vitor
	 * @param pessoa
	 * @throws Exception
	 */
	public void cadastrarPessoa(Pessoa pessoa) throws Exception {
		boolean adicionar = getPessoa().add(pessoa);
		if (!adicionar) {
			throw new Exception("Erro ao cadastrar pessoa!!!");
		}
	}
	
	
	
	public ArrayList<Produto> getProduto() {
		return produto;
	}
	public void setProduto(ArrayList<Produto> produto) {
		this.produto = produto;
	}
	public ArrayList<Pessoa> getPessoa() {
		return pessoa;
	}
	public void setPessoa(ArrayList<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	public ArrayList<ItemCompra> getItemCompra() {
		return itemCompra;
	}
	public void setItemCompra(ArrayList<ItemCompra> itemCompra) {
		this.itemCompra = itemCompra;
	}
	public ArrayList<ItemVenda> getItemVenda() {
		return itemVenda;
	}
	public void setItemVenda(ArrayList<ItemVenda> itemVenda) {
		this.itemVenda = itemVenda;
	}
	
}
