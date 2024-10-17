package ufal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ufal.auth.*;

public class PermissionTests {

  @Test
  public void basic() {
    var user = new Usuario("1", "Davi", RoleNames.CLIENTE);
    user.getRole().setPermissions(Action.LISTAR_USUARIOS);

    boolean canExecute = AuthorizationService
        .hasPermission(user, Action.LISTAR_USUARIOS);

    assertEquals(true, canExecute);
  }
}