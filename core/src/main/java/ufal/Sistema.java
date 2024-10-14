package ufal;

import java.util.*;

public final class Sistema {
  private static final Map<String, User> userMap = new HashMap<>();

  static List<User> listUsers() {
    return userMap.values().stream().toList();
  }

  static User signupUser(String email, String password) {
    // TODO: validar entrada
    if (!userMap.containsKey(email))
      userMap.put(email, new User(email, password));
    return userMap.get(email);
  }

  static User loginUser(String email, String password) {
    if (!userMap.containsKey(email))
      return null;
    var user = userMap.get(email);
    if (!user.verifyLogin(email, password))
      return null;
    return user;
  }

  static boolean doesUserExist(String email) {
    return userMap.containsKey(email);
  }

  static boolean doesUserExist(User user) {
    return userMap.containsValue(user);
  }
}
