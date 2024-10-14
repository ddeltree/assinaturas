package ufal;

import java.util.*;
import ufal.auth.*;

public class Main {
    static Map<ActionID, Action> actionMap = new HashMap<>();

    public static void main(String[] args) {
        initializeActions();

        var role = new Role("ADMIN");
        var permission = new Permission(Effect.EXECUTE, getAction(ActionID.LIST_USERS));
        role.setPermissions(permission);

        var user = new User("1", "Davi");
        user.getRoles().add(role);
        AuthorizationService authService = new AuthorizationService();

        boolean canRead = authService.hasPermission(user, Effect.EXECUTE, getAction(ActionID.LIST_USERS));

        System.out.println("User can list users: " + canRead);
    }

    static void initializeActions() {
        actionMap.put(ActionID.LIST_USERS, Sistema::listUsers);
    }

    static Action getAction(ActionID id) {
        return actionMap.get(id);
    }
}
