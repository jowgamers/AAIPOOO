package model;

public class SisComException extends Exception{

	
	private String nomeProduto;
	private int estoque;
	private String mensagemErro;
	
	/**
	 * 
	 * @param nomeProduto
	 */
	public SisComException (String nomeProduto) {
		super();
	}
	
	public SisComException (String nomeProduto, int estoque) {
		super();
	}
	

	public SisComException (String nomeProduto, int estoque, String mensagemErro) {
		super();
	}
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	
	
	
	
}
