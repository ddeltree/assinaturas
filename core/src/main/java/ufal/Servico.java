package ufal;

import java.util.*;

public class Servico {
  public final String id;
  private String nome;
  public final List<Plano> planos = new ArrayList<>();
  public static final List<Servico> servicos = new ArrayList<>();

  public Servico(String nome) {
    super();
    this.id = UUID.randomUUID().toString();
    this.nome = nome;
    servicos.add(this);
  }

  public Servico atualizarNome(String nome) {
    if (nome.isEmpty())
      throw new IllegalArgumentException("O nome de serviço não pode ser vazio.");
    this.nome = nome;
    return this;
  }

  public String getNome() {
    return nome;
  }
}
