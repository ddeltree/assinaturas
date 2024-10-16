package ufal;

public class Plano {
    private String nome;
    private double preco;
    private String periodoPagamento;

    public Plano(String nome, double preco, String periodoPagamento) {
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do plano não pode ser vazio.");
        }
        this.nome = nome;
        this.preco = preco;
        this.periodoPagamento = periodoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getPeriodoPagamento() {
        return periodoPagamento;
    }

    public void setPeriodoPagamento(String periodoPagamento) {
        this.periodoPagamento = periodoPagamento;
    }
}

