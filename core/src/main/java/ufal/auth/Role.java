package ufal.auth;

import java.util.*;

public class Role {
  public static final Map<RoleNames, Role> roles = Map.of(
      RoleNames.CLIENTE, new Role(RoleNames.CLIENTE).setPermissions(Action.ASSINAR_PLANO,
          Action.LISTAR_SERVICOS_DISPONIVEIS,
          Action.CANCELAR_ASSINATURA),
      RoleNames.ADMIN, new Role(RoleNames.ADMIN).setPermissions(Action.BUSCAR_USUARIO, Action.CRIAR_SERVICO,
          Action.BUSCAR_SERVICO, Action.ATUALIZAR_SERVICO, Action.EXCLUIR_SERVICO, Action.CRIAR_PLANO,
          Action.BUSCAR_PLANO, Action.ATUALIZAR_PLANO, Action.EXCLUIR_PLANO));
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