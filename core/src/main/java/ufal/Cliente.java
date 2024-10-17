package ufal;

import java.util.*;

public class Cliente extends Usuario {
  public final List<Plano> assinaturas = new ArrayList<>();
  public final String cadastroDePessoa;

  private Cliente(String email, String senha, String cadastro) {
    super(email, senha);
    cadastroDePessoa = cadastro;
  }

  public Cliente criarPorCPF(String email, String senha, String CPF) {
    if (!Utils.isCPFValido(CPF))
      throw new IllegalArgumentException("O CPF é inválido!");
    return new Cliente(email, senha, CPF);
  }

  public Cliente criarPorCNPJ(String email, String senha, String CNPJ) {
    if (!Utils.isCNPJValido(CNPJ))
      throw new IllegalArgumentException("O CNPJ é inválido!");
    return new Cliente(email, senha, CNPJ);
  }

  public boolean isPessoaFisica() {
    // TODO
    return true;
  }

  public boolean isPessoaJuridica() {
    // TODO
    return true;
  }

  public void assinarPlano(Plano plano) {
    plano.assinantes.add(this);
    assinaturas.add(plano);
  }

  public void cancelarAssinatura(Plano plano) throws Exception {
    if (plano.assinantes.contains(this)) {
      plano.assinantes.remove(this);
      assinaturas.remove(plano);
    } else {
      throw new Exception("Erro inesperado do sistema!");
    }
  }
}
