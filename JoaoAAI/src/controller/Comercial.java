package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Fornecedor;
import model.ItemCompra;
import model.ItemVenda;
import model.Pessoa;
import model.Produto;
import model.SisComException;
import model.Vendedor;

public class Comercial {

	private ArrayList<Produto> produto = new ArrayList<Produto>();
	private ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
	private ArrayList<ItemCompra> itemCompra = new ArrayList<ItemCompra>();
	private ArrayList<ItemVenda> itemVenda = new ArrayList<ItemVenda>();

	/**
	 * @author Joao Vitor Franco Resende
	 * @param  produto
	 * @throws SisComException
	 */
	public void cadastrarProduto(Produto produto) throws SisComException {
		boolean adicionar = getProduto().add(produto);
		if (!adicionar) {
			throw new SisComException("Erro ao cadastrar produto!!!");
		}
	}

	/**
	 * @author Joao Vitor Franco Resende
	 * @param  pessoa
	 * @throws SisComException
	 * 
	 */
	public void cadastrarPessoa(Pessoa pessoa) throws SisComException {
		try {
			Pessoa pessoaTemp = validaPessoa(pessoa);
			//Mensagem de erro
		} catch (Exception e) {
			//pessoa.setCodigo(pessoa.size() + 1); //Não ta reconhecendo o metodo SIZE da array
			boolean adicionar = getPessoa().add(pessoa);
			if (!adicionar) {
				throw new SisComException("Erro ao cadastrar pessoa!!!");
				// TODO: handle exception
			}
		}
	}
	/**
	 * DUVIDA -- DELETAR PASSARA PARAMETRO PESSOA OU IDENTIFICACAO
	 * @param identificacao
	 * @throws SisComException
	 * @return void
	 */
	public void deletarPessoa(String identificacao) throws SisComException {
		boolean deletar = getPessoa().remove(consultarCliente(identificacao));
		
	}

	/**
	 * 	 
	 * @author Joao Vitor Franco Resende
	 * @param  cpf
	 * @return pessoa
	 * @throws SisComException
	 */
	public Pessoa consultarCliente(String cpf) throws SisComException{
		for (Pessoa pessoa : getPessoa()) {
			if (cpf.equals(((Cliente) pessoa).getCpf())) {
				return pessoa;
			}
		}
		throw new SisComException("CPF não encontrado");
	}

	/**
	 * 
	 * @author Joao Vitor Franco Resende
	 * @param pessoaParam
	 * @return pessoa
	 * @throws SisComException
	 */
	public Pessoa validaPessoa(Pessoa pessoaParam) throws SisComException {
		for (Pessoa pessoa : pessoa) {
			if (pessoa instanceof Vendedor && pessoaParam instanceof Vendedor) {
				if (((Vendedor) pessoaParam).getCnpj().equals(((Vendedor) pessoa).getCnpj())) {
					return pessoa;
				}
			} else if (pessoa instanceof Cliente && pessoaParam instanceof Cliente) {
				if (((Cliente) pessoaParam).getCpf().equals(((Cliente) pessoa).getCpf())) {
					return pessoa;
				}
			} else if (pessoa instanceof Fornecedor && pessoaParam instanceof Fornecedor) {
				if (((Cliente) pessoaParam).getCpf().equals(((Cliente) pessoa).getCpf())) {
					return pessoa;
				}
			}

		}
		throw new SisComException("Falha ao cadastrar pessoa");
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
