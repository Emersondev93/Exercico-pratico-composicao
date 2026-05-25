package entidades;

public class ItemPedido {
	private int quantidade;
	private Produto produto;

	public ItemPedido(int quantidade,Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public double subTotal() {
		return quantidade * produto.getPreco();
	}

	@Override
	public String toString() {
		return produto.getNome() 
				+ produto 
				+ "\nPreço: " 
				+ String.format("%.2f", produto.getPreco()) 
				+ "\nQuantidade: " 
				+ quantidade;
	}

}
