package ufal;

import java.util.*;

public class Plano {
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
        this.servico = servico;
        this.nome = nome;
        this.precoEmReais = preco;
        this.intervaloPagamentoEmMeses = periodoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoEmReais() {
        return precoEmReais;
    }

    public void setPrecoEmReais(double preco) {
        this.precoEmReais = Math.max(0, preco);
    }

    public int getIntervaloPagamentoEmMeses() {
        return intervaloPagamentoEmMeses;
    }

    public void setIntervaloPagamentoEmMeses(int meses) {
        if (meses <= 0)
            throw new IllegalArgumentException("O período de pagamento não pode ser menor que 1 mês");
        this.intervaloPagamentoEmMeses = meses;
    }
}
