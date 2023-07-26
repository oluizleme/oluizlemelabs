package br.com.oluizlemelabs.javaconsole.patterns.memento;

public class PedidoMemento implements Comparable<PedidoMemento> {

	private final EstadoPedido estado;
	private final String mensagem;

	public PedidoMemento(EstadoPedido estado, String mensagem) {
		this.estado = estado;
		this.mensagem = mensagem;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public String getMensagem() {
		return mensagem;
	}

	@Override
	public int compareTo(PedidoMemento o) {
		return 0;
	}
}
