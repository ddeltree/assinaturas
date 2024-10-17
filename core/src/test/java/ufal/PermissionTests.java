package ufal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ufal.auth.*;

public class PermissionTests {

  @Test
  public void basic() {
    Main.initialize();

    var user = new Usuario("1", "Davi", RoleNames.CLIENTE);
    user.getRole().setPermissions(
        new Permission(
            Effect.EXECUTE,
            Main.getAction(ActionID.LISTAR_USUARIOS)));

    boolean canExecute = AuthorizationService
        .hasPermission(user, Effect.EXECUTE, Main.getAction(ActionID.LISTAR_USUARIOS));

    assertEquals(true, canExecute);
  }
}