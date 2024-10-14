package ufal.auth;

import java.util.*;

public class Role {
  final String name;
  private final Set<Permission> permissions = new HashSet<>();

  public Role(String name) {
    super();
    this.name = name;
  }

  public Role setPermissions(Permission... permissions) {
    for (Permission p : permissions)
      this.permissions.add(p);
    return this;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }
}