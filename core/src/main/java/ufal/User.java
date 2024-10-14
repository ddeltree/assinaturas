package ufal;

import java.util.HashSet;
import java.util.Set;

import ufal.auth.Role;

public class User {
  private String uid;
  private String name;
  private String email;
  private String password;
  private final Set<Role> roles = new HashSet<>();

  public User(String email, String password) {
    super();
    this.email = email;
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public boolean verifyLogin(String email, String password) {
    return this.email.equals(email) && this.password.equals(password);
  }
}
