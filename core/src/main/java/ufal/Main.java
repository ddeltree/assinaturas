package ufal;

import java.util.*;

public class Main {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            var user = askCredentials();
            if (user == null)
                return;
            System.out.println(user.getRole().getPermissions());
        } finally {
            sc.close();
        }
    }

    static Usuario askCredentials() {
        int option = 0;
        Usuario user = null;
        boolean isSignedIn = false;
        do {
            System.out.println("* (1) - LOGIN");
            System.out.println("* (2) - CADASTRO");
            System.out.println("* (0) - sair");
            option = sc.nextInt();
            if (option == 1) {
                user = loginScreen();
                isSignedIn = true;
            } else if (option == 2) {
                user = signupScreen();
            }
        } while (!isSignedIn && option != 0);
        return user;
    }

    static Usuario signupScreen() {
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
        var user = Sistema.signupUser(email, senha, "abc", false);
        return user;
    }

    static Usuario loginScreen() {
        System.out.println("--- LOGIN ---");
        Usuario user = null;
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
}
