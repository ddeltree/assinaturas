package ufal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ufal.auth.*;

public class PermissionTests {

  @Test
  public void basic() {
    Main.initialize();

    var user = new User("1", "Davi");
    var role = new Role("ADMIN")
        .setPermissions(new Permission(
            Effect.EXECUTE,
            Main.getAction(ActionID.LIST_USERS)));
    user.getRoles().add(role);

    boolean canExecute = AuthorizationService
        .hasPermission(user, Effect.EXECUTE, Main.getAction(ActionID.LIST_USERS));

    assertEquals(true, canExecute);
  }
}