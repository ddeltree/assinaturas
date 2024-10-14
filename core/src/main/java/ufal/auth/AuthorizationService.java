package ufal.auth;

import ufal.User;

public class AuthorizationService {
  public static boolean hasPermission(User user, Effect effect, Action action) {
    for (Role role : user.getRoles()) {
      for (Permission permission : role.getPermissions()) {
        if (permission.getEffect() == effect && permission.getAction() == action)
          return true;
      }
    }
    return false;
  }
}