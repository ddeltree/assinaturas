package ufal;

import java.util.*;

public class Servico {
  private String nome;
  public final List<Plano> planos = new ArrayList<>();

  public Servico(String nome) {
    super();
    this.nome = nome;
  }

  public void atualizarNome(String nome) {
    if (nome.isEmpty())
      throw new IllegalArgumentException("O nome de serviço não pode ser vazio.");
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }
}
