package br.com.oluizlemelabs.javaconsole.patterns.memento;

public class Main {

	public static void main(String[] args) {
		var pedido = new Pedido("Um pedido de cem reais", 100.0);
		imprimirPedido(pedido);

		//Atualizando o pedido para processado
		pedido.atualizarPedido(EstadoPedido.PROCESSADO);
		imprimirPedido(pedido);

		//Atualizando o pedido para pago
		pedido.atualizarPedido(EstadoPedido.PAGO);
		imprimirPedido(pedido);

		//Atualizando o pedido para enviado
		pedido.atualizarPedido(EstadoPedido.ENVIADO);
		imprimirPedido(pedido);

		//Restaurando o pedido para pago
		pedido.restaurarEstadoAnterior();
		imprimirPedido(pedido);

		//Restaurando o pedido para processado
		pedido.restaurarEstadoAnterior();
		imprimirPedido(pedido);

	}

	private static void imprimirPedido(Pedido pedido) {
		System.out.println("Estado atual: " + pedido.getEstado());
		System.out.println("SMS enviado para o cliente: " + pedido.getMensagem());
	}
}
