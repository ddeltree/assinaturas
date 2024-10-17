package ufal.auth;

import ufal.Usuario;

public class AuthorizationService {
  public static boolean hasPermission(Usuario user, Action action) {
    for (Action permission : user.getRole().getPermissions()) {
      if (permission == action)
        return true;
    }
    return false;
  }
}