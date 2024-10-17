package ufal;

import java.util.*;

public final class Sistema {
    private static final Map<String, Usuario> userMap = new HashMap<>();
    private static final Map<String, Plano> planoMap = new HashMap<>();

    // CADASTRO

    static Usuario signupUser(String email, String password) {
        if (!userMap.containsKey(email))
            userMap.put(email, new Usuario(email, password));
        return userMap.get(email);
    }

    static Usuario loginUser(String email, String password) {
        if (!userMap.containsKey(email))
            return null;
        var user = userMap.get(email);
        if (!user.verificarLogin(email, password))
            return null;
        return user;
    }

    static boolean doesUserExist(String email) {
        return userMap.containsKey(email);
    }

    static boolean doesUserExist(Usuario user) {
        return userMap.containsValue(user);
    }

    // ADMINISTRADOR

    static List<Usuario> listarUsuarios() {
        return userMap.values().stream().toList();
    }

    //

    static Servico criarServico(String nome) {
        return new Servico(nome);
    }

    static Servico buscarServico(String id) {
        var servico = listarServicos().stream().filter(s -> s.id.equals(id)).findFirst();
        if (!servico.isPresent())
            throw new IllegalArgumentException("Serviço inexistente!");
        return servico.get();
    }

    static List<Servico> listarServicos() {
        return Servico.servicos;
    }

    static void atualizarServico(String id, String novoNome) {
        buscarServico(id).atualizarNome(novoNome);
    }

    static void excluirServico(String id) {
        listarServicos().remove(buscarServico(id));
    }

    //

    static Plano criarPlano(String idServico, String nome, double preco, int periodoPagamento) {
        return new Plano(buscarServico(idServico), idServico, preco, periodoPagamento);
    }

    static Plano buscarPlano(String idServico, String idPlano) {
        var plano = buscarServico(idServico).planos.stream().filter(p -> p.id.equals(idPlano)).findFirst();
        return plano.isPresent() ? plano.get() : null;
    }

    static void atualizarPlano(String idServico, String idPlano, String nome, double preco, int periodoPagamento) {
        buscarPlano(idServico, idPlano).setNome(nome).setPrecoEmReais(preco)
                .setIntervaloPagamentoEmMeses(periodoPagamento);
    }

    static void excluirPlano(String idServico, String idPlano) {
        var servico = buscarServico(idServico);
        var plano = buscarPlano(idPlano);
        if (plano != null && servico != null && servico.planos.contains(plano))
            servico.planos.remove(plano);
    }

    // CLIENTE

    public static void criarPlano(Servico servico, String nome, double preco, int periodoPagamento) {
        if (planoMap.containsKey(nome)) {
            throw new IllegalArgumentException("Plano com esse nome já existe.");
        }
        planoMap.put(nome, new Plano(servico, nome, preco, periodoPagamento));
        System.out.println("Plano criado com sucesso: " + nome);
    }

    public static List<Plano> listarPlanos() {
        return new ArrayList<>(planoMap.values());
    }

    public static void atualizarPlano(String nome, double novoPreco, int novoPeriodoPagamento) {
        Plano plano = planoMap.get(nome);
        if (plano == null) {
            throw new IllegalArgumentException("Plano não encontrado.");
        }
        plano.setPrecoEmReais(novoPreco);
        plano.setIntervaloPagamentoEmMeses(novoPeriodoPagamento);
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
