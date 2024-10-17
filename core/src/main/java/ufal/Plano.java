package ufal;

import java.util.*;

public class Plano {
    public final String id;
    private String nome;
    private double precoEmReais;
    private int intervaloPagamentoEmMeses;
    public final Servico servico;
    public final List<Usuario> assinantes = new ArrayList<>();

    public Plano(Servico servico, String nome, double preco, int periodoPagamento) {
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do plano não pode ser vazio.");
        }
        if (servico != null)
            servico.planos.add(this);
        this.id = UUID.randomUUID().toString();
        this.servico = servico;
        this.nome = nome;
        this.precoEmReais = preco;
        this.intervaloPagamentoEmMeses = periodoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public Plano setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public double getPrecoEmReais() {
        return precoEmReais;
    }

    public Plano setPrecoEmReais(double preco) {
        this.precoEmReais = Math.max(0, preco);
        return this;
    }

    public int getIntervaloPagamentoEmMeses() {
        return intervaloPagamentoEmMeses;
    }

    public Plano setIntervaloPagamentoEmMeses(int meses) {
        if (meses <= 0)
            throw new IllegalArgumentException("O período de pagamento não pode ser menor que 1 mês");
        this.intervaloPagamentoEmMeses = meses;
        return this;
    }
}
