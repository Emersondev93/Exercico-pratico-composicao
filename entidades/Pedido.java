package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entidadesEnum.StatusPedido;

public class Pedido {
	private LocalDateTime momento;
	private StatusPedido status;
	private Cliente cliente;

	private List<ItemPedido> lista = new ArrayList<>();

	public Pedido(LocalDateTime momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<ItemPedido> getLista() {
		return lista;
	}

	public void adicionarItem(ItemPedido item) {
		lista.add(item);
	}

	public void removerItem(ItemPedido item) {
		lista.remove(item);
	}

	public double total() {
		double total = 0.0;
		for (ItemPedido item : lista) {
			total += item.subTotal();
		}
		return total;
	}

}
