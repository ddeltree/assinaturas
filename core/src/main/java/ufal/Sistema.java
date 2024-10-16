package ufal;

import java.util.*;

public final class Sistema {
    private static final Map<String, User> userMap = new HashMap<>();
    private static final Map<String, Plano> planoMap = new HashMap<>();

    static List<User> listUsers() {
        return userMap.values().stream().toList();
    }

    static User signupUser(String email, String password) {
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

    public static void criarPlano(String nome, double preco, String periodoPagamento) {
        if (planoMap.containsKey(nome)) {
            throw new IllegalArgumentException("Plano com esse nome já existe.");
        }
        planoMap.put(nome, new Plano(nome, preco, periodoPagamento));
        System.out.println("Plano criado com sucesso: " + nome);
    }

    public static List<Plano> listarPlanos() {
        return new ArrayList<>(planoMap.values());
    }

    public static void atualizarPlano(String nome, double novoPreco, String novoPeriodoPagamento) {
        Plano plano = planoMap.get(nome);
        if (plano == null) {
            throw new IllegalArgumentException("Plano não encontrado.");
        }
        plano.setPreco(novoPreco);
        plano.setPeriodoPagamento(novoPeriodoPagamento);
        System.out.println("Plano atualizado com sucesso: " + nome);
    }

    public static void removerPlano(String nome) {
        if (!planoMap.containsKey(nome)) {
            throw new IllegalArgumentException("Plano não encontrado.");
        }
        planoMap.remove(nome);
        System.out.println("Plano removido com sucesso: " + nome);
    }

    public static Plano buscarPlano(String nome) {
        return planoMap.get(nome);
    }
}
