package ufal;

import java.util.*;
import ufal.auth.*;

public class Main {
    static Map<ActionID, Action> actionMap = new HashMap<>();

    public static void main(String[] args) {
        initializeActions();
    }

    static void initializeActions() {
        actionMap.put(ActionID.LIST_USERS, Sistema::listUsers);
    }

    static Action getAction(ActionID id) {
        return actionMap.get(id);
    }
}
