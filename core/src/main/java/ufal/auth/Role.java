package ufal.auth;

import java.util.*;

public class Role {
  public static final Map<RoleNames, Role> roles = Map.of(
      RoleNames.CLIENTE, new Role(RoleNames.CLIENTE).setPermissions(),
      RoleNames.ADMIN, new Role(RoleNames.ADMIN).setPermissions());
  public final RoleNames name;
  private final Set<Action> permissions = new HashSet<>();

  public Role(RoleNames name) {
    super();
    this.name = name;
  }

  public Role setPermissions(Action... permissions) {
    for (Action p : permissions)
      this.permissions.add(p);
    return this;
  }

  public Set<Action> getPermissions() {
    return permissions;
  }
}