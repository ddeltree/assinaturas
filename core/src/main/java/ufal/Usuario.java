package ufal;

import java.util.*;

import ufal.auth.Role;
import ufal.auth.RoleNames;

public class Usuario {
  private final String uid;
  private String nome;
  private String email;
  private String senha;
  private final Role role;

  public Usuario(String email, String senha, RoleNames roleName) {
    super();
    this.email = email; // TODO validar
    this.senha = senha; // TODO validar
    this.uid = UUID.randomUUID().toString();
    this.role = new Role(roleName);
  }

  public Role getRole() {
    return role;
  }

  public boolean verificarLogin(String email, String senha) {
    return this.email.equals(email) && this.senha.equals(senha);
  }

  public String getNome() {
    return nome;
  }

  public String getUID() {
    return uid;
  }

  public Usuario atualizarNome(String novoNome) {
    if (novoNome.isEmpty())
      throw new IllegalArgumentException("O nome de usuário não pode ser vazio!");
    this.nome = novoNome;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Usuario atualizarEmail(String email) {
    // TODO validar email
    this.email = email;
    return this;
  }

  public void mudarSenha(String novaSenha) {
    // TODO validar senha
    this.senha = novaSenha;
  }

  private boolean isSenhaValida(String senha) {
    // TODO
    return true;
  }

  private boolean isEmailValido(String email) {
    // TODO
    return true;
  }
}
