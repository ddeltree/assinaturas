package ufal;

import java.util.*;
import ufal.auth.*;

public class Main {
    static Map<ActionID, Action> actionMap = new HashMap<>();

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        initialize();
        askCredentials(sc);
    }

    static void askCredentials(Scanner sc) {
        int option = 0;
        do {
            System.out.println("* (1) - LOGIN");
            System.out.println("* (2) - CADASTRO");
            System.out.println("* (0) - sair");
            option = sc.nextInt();
            if (option == 1)
                loginScreen(sc);
            else if (option == 2)
                signupScreen(sc);
        } while (option != 0);
    }

    static User signupScreen(Scanner sc) {
        System.out.println("--- CADASTRO ---");
        String email;
        do {
            System.out.print("Email: ");
            email = sc.next();
            if (Sistema.doesUserExist(email)) {
                System.out.println("Um usuário com esse email já existe!");
            }
        } while (Sistema.doesUserExist(email));
        System.out.print("Senha: ");
        var senha = sc.next();
        var user = Sistema.signupUser(email, senha);
        return user;
    }

    static User loginScreen(Scanner sc) {
        System.out.println("--- LOGIN ---");
        User user = null;
        do {
            System.out.print("Email: ");
            var email = sc.next();
            System.out.print("Senha: ");
            var senha = sc.next();
            user = Sistema.loginUser(email, senha);
            if (user == null)
                System.out.println("Usuário inexistente ou dados incorretos!");
        } while (user == null);
        return user;
    }

    static void initialize() {
        actionMap.put(ActionID.LIST_USERS, Sistema::listUsers);
        var adminRole = new Role("ADMIN");
        var clienteRole = new Role("CLIENTE");
    }

    static Action getAction(ActionID id) {
        return actionMap.get(id);
    }
}
