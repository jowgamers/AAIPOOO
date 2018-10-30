package model;

public class SisComException {

	
	private String nomeProduto;
	private int estoque;
	private String mensagemErro;
	
	public SisComException () {
		
	}
	
	public SisComException(String nomeProduto, int estoque, String mensagemErro) {
		super();
		this.nomeProduto = nomeProduto;
		this.estoque = estoque;
		this.mensagemErro = mensagemErro;
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
