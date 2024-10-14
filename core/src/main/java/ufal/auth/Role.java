package ufal.auth;

import java.util.*;

public class Role {
  final String name;
  private final Set<Permission> permissions = new HashSet<>();

  public Role(String name) {
    super();
    this.name = name;
  }

  public void setPermissions(Permission... permissions) {
    for (Permission p : permissions) {
      System.out.println(p.getAction());
      this.permissions.add(p);
    }
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }
}