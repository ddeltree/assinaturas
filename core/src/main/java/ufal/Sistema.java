package ufal;

import java.util.*;

import ufal.auth.RoleNames;

public final class Sistema {
    private static final Map<String, Usuario> userMap = new HashMap<>();

    // CADASTRO

    static Usuario signupUser(String email, String password, String cadastro, boolean asAdm) {
        if (!Utils.isCNPJValido(cadastro) && !Utils.isCPFValido(cadastro))
            throw new IllegalArgumentException("O cadastro de pessoa não é válido!");
        Usuario user = asAdm
                ? new Usuario(email, password, RoleNames.ADMIN)
                : Utils.isCPFValido(cadastro)
                        ? Cliente.criarPorCPF(email, password, cadastro)
                        : Cliente.criarPorCNPJ(email, password, cadastro);
        if (!userMap.containsKey(email)) {
            userMap.put(email, user);
        }
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

    static void alterarDadosCadastrais(String uid, String nome, String email, String senha) {
        var user = buscarUsuario(uid);
        user.atualizarNome(nome).atualizarEmail(email).mudarSenha(senha);
    }

    // ADMINISTRADOR

    static List<Usuario> listarUsuarios() {
        return userMap.values().stream().toList();
    }

    static Usuario buscarUsuario(String uid) {
        return listarUsuarios().stream().filter(u -> u.getUID().equals(uid)).findFirst().get();
    }

    static boolean isCliente(String uid) {
        var user = buscarUsuario(uid);
        if (user.getRole().name == RoleNames.CLIENTE || user instanceof Cliente) {
            assert user instanceof Cliente;
            assert user.getRole().name == RoleNames.CLIENTE;
            return true;
        } else {
            return false;
        }
    }

    static Servico criarServico(String nome, TipoServico tipo) {
        return new Servico(nome, tipo);
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
        var plano = buscarPlano(idServico, idPlano);
        if (plano != null && plano.servico.planos.contains(plano))
            plano.servico.planos.remove(plano);
    }

    // CLIENTE

    static void assinarPlano(String uid, String idServico, String idPlano) {
        if (!isCliente(uid))
            return;
        var cliente = ((Cliente) buscarUsuario(uid));
        cliente.assinarPlano(buscarPlano(idServico, idPlano));
    }

    static List<Servico> listarServicosDisponiveis(String uid) {
        var user = (Cliente) buscarUsuario(uid);
        var servicos = listarServicos().stream()
                .filter(s -> s.tipoServico == TipoServico.AMBOS ||
                        (s.tipoServico == TipoServico.CPF) && user.isPessoaFisica() ||
                        (s.tipoServico == TipoServico.CNPJ) && user.isPessoaJuridica());
        return servicos.toList();
    }

    static void cancelarAssinatura(String uid, String idServico, String idPlano) {
        var user = (Cliente) buscarUsuario(uid);
        var plano = buscarPlano(idServico, idPlano);
        user.cancelarAssinatura(plano);
    }
}
