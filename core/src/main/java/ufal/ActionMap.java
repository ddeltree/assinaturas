package ufal;

import java.util.*;

import ufal.auth.Action;
import ufal.auth.ActionID;
import ufal.auth.Role;
import ufal.auth.RoleNames;

public class ActionMap {
  static Map<ActionID, Action> actionMap = new HashMap<>();

  static void initialize() {
    actionMap.put(ActionID.LISTAR_USUARIOS, Sistema::listarUsuarios);
    actionMap.put(ActionID.LISTAR_SERVICOS, Sistema::listarServicos);

    actionMap.put(ActionID.SIGNUP_USER, Sistema::signupUser);
    actionMap.put(ActionID.LOGIN_USER, Sistema::loginUser);
    actionMap.put(ActionID.DOES_USER_EXIST, Sistema::doesUserExist);
    actionMap.put(ActionID.DOES_USER_EXIST, Sistema::doesUserExist);
    actionMap.put(ActionID.ALTERAR_DADOS_CADASTRAIS, Sistema::alterarDadosCadastrais);
    actionMap.put(ActionID.BUSCAR_USUARIO, Sistema::buscarUsuario);
    actionMap.put(ActionID.IS_CLIENTE, Sistema::isCliente);
    actionMap.put(ActionID.CRIAR_SERVICO, Sistema::criarServico);
    actionMap.put(ActionID.BUSCAR_SERVICO, Sistema::buscarServico);
    actionMap.put(ActionID.ATUALIZAR_SERVICO, Sistema::atualizarServico);
    actionMap.put(ActionID.EXCLUIR_SERVICO, Sistema::excluirServico);
    actionMap.put(ActionID.CRIAR_PLANO, Sistema::criarPlano);
    actionMap.put(ActionID.BUSCAR_PLANO, Sistema::buscarPlano);
    actionMap.put(ActionID.ATUALIZAR_PLANO, Sistema::atualizarPlano);
    actionMap.put(ActionID.EXCLUIR_PLANO, Sistema::excluirPlano);
    actionMap.put(ActionID.ASSINAR_PLANO, Sistema::assinarPlano);
    actionMap.put(ActionID.LISTAR_SERVICOS_DISPONIVEIS, Sistema::listarServicosDisponiveis);
    actionMap.put(ActionID.CANCELAR_ASSINATURA, Sistema::cancelarAssinatura);
    var adminRole = new Role(RoleNames.ADMIN);
    var clienteRole = new Role(RoleNames.CLIENTE);
  }

  static Action get(ActionID id) {
    return actionMap.get(id);
  }
}
