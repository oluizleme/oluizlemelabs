package br.com.oluizlemelabs.javaconsole.patterns.memento;

import java.util.*;

public class Pedido {

	private UUID codigoPedido;
	private String descricao;
	private double valor;
	private EstadoPedido estado;
	private List<PedidoMemento> estadosAnteriores;
	private String mensagem;

	public Pedido(String descricao, double valor) {
		this.estadosAnteriores = new ArrayList<>();
		this.codigoPedido = UUID.randomUUID();
		this.descricao = descricao;
		this.valor = valor;
		this.estado = EstadoPedido.NOVO;
		this.mensagem = "Seu pedido se encontra no estado: " + this.estado;
		this.adicionarHistorico();
	}

	public void atualizarPedido(EstadoPedido estado) {
		this.estado = estado;
		this.mensagem = "Seu pedido se encontra no estado: " + this.estado;
		this.adicionarHistorico();
	}

	private void adicionarHistorico() {
		this.estadosAnteriores.add(new PedidoMemento(estado, mensagem));
	}

	public void restaurarEstadoAnterior() {
		if(estadosAnteriores.size() > 1) {
			PedidoMemento estadoAnterior = this.estadosAnteriores.get(this.estadosAnteriores.size() - 2);
			this.estadosAnteriores.remove(estadoAnterior);
			estado = estadoAnterior.getEstado();
			mensagem = estadoAnterior.getMensagem();
		}
	}

	public EstadoPedido getEstado() {
		return this.estado;
	}

	public String getMensagem() {
		return this.mensagem;
	}
}
