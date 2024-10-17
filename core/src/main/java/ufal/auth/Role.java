package ufal.auth;

import java.util.*;

public class Role {
  public static final Map<RoleNames, Role> roles = Map.of(
      RoleNames.CLIENTE, new Role(RoleNames.CLIENTE),
      RoleNames.ADMIN, new Role(RoleNames.ADMIN));
  public final RoleNames name;
  private final Set<Permission> permissions = new HashSet<>();

  public Role(RoleNames name) {
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