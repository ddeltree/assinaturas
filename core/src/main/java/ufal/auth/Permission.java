package ufal.auth;

public class Permission {
  private Effect effect; // e.g., "READ", "WRITE", "DELETE"
  private Action action;

  public Permission(Effect name, Action action) {
    super();
    this.effect = name;
    this.action = action;
  }

  public Effect getEffect() {
    return effect;
  }

  public Action getAction() {
    return action;
  }
}