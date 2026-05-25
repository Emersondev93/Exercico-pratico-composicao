package programa;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidadesEnum.StatusPedido;

public class Principal {
	public static String buscarNegativo(int quantidade) {
		if (quantidade <= 0) {
			return "Quantidade de itens deve ser maior que zero ! ";
		}
		return null;
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		try {
			System.out.println("DIGITE OS DADOS DO CLIENTE: ");
			System.out.print("Nome: ");
			String nome = sc.nextLine();

			System.out.print("Email: ");
			String email = sc.nextLine();

			System.out.print("Data nascimento (dd/MM/aaaa): ");
			String data = sc.nextLine();

			LocalDate dataNascimento = LocalDate.parse(data, fmt);

			Cliente cliente = new Cliente(nome, email, dataNascimento);

			System.out.println();

			System.out.println("DIGITE OS DADOS DO PEDIDO: ");
			System.out.print("Status: ");
			String status = sc.nextLine();

			int quantidadeItens;
			String negativo;
			do {
				System.out.print("Quantos itens possui o pedido: ");
				quantidadeItens = sc.nextInt();
				sc.nextLine();
				negativo = buscarNegativo(quantidadeItens);
				if (negativo != null) {
					System.out.println(negativo);
				}

			} while (negativo != null);

			LocalDateTime momento = LocalDateTime.now();
			Pedido pedido = new Pedido(momento, StatusPedido.valueOf(status.toUpperCase()), cliente);

			for (int i = 0; i < quantidadeItens; i++) {
				System.out.print("Nome do produto: ");
				String nomeProduto = sc.nextLine();

				boolean valPreco = false;
				double preco;
				do {
					System.out.print("Preço: ");
					preco = sc.nextDouble();
					valPreco = false;

					if (preco <= 0) {
						System.out.println("Valor inválido !");
						valPreco = true;
					}
				} while (valPreco);
				
				Produto produto = new Produto(nomeProduto, preco);

				int quantidade;
				do {
					System.out.print("Quantidade: ");
					quantidade = sc.nextInt();
					sc.nextLine();
					negativo = buscarNegativo(quantidade);
					if (negativo != null) {
						System.out.println(negativo);
					}
				} while (negativo != null);
				ItemPedido itemPedido = new ItemPedido(quantidade, produto);
				pedido.adicionarItem(itemPedido);

				System.out.println();
			}

			System.out.println("RESUMO DO PEDIDO: ");
			System.out.println("Momento do pedido: " + pedido.getMomento().format(fmt1));
			System.out.println("Status: " + pedido.getStatus());
			System.out.println("Cliente: " + pedido.getCliente());
			System.out.println();

			System.out.println("ITENS DO PEDIDO: ");
			for (ItemPedido item : pedido.getLista()) {
				System.out.println(item.toString());
				System.out.println();
			}

			System.out.println();

			System.out.println("TOTAL: R$ " + String.format("%.2f", pedido.total()));

		} catch (InputMismatchException erro) {
			System.out.println("Formato de digito inválido !");
		} catch (DateTimeException erro) {
			System.out.println("Digite a data corretamente.");
		}

	}

}
