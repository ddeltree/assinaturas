package ufal.auth;

import ufal.Usuario;

public class AuthorizationService {
  public static boolean hasPermission(Usuario user, Effect effect, Action action) {
    for (Permission permission : user.getRole().getPermissions()) {
      if (permission.getEffect() == effect && permission.getAction() == action)
        return true;
    }
    return false;
  }
}