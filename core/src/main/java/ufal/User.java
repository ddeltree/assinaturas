package ufal;

import java.util.HashSet;
import java.util.Set;

import ufal.auth.Role;

public class User {
  private String uid;
  private String name;
  private final Set<Role> roles = new HashSet<>();

  public User(String userId, String userName) {
    super();
    uid = userId;
    name = userName;
  }

  public Set<Role> getRoles() {
    return roles;
  }
}
