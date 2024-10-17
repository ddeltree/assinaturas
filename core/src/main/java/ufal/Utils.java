package ufal;

public class Utils {

  public static boolean isCPFValido(String value) {
    // TODO
    boolean isCPF = value != null && value.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    return true;
  }

  public static boolean isCNPJValido(String value) {
    // TODO
    boolean isCNPJ = value != null && value.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");
    return true;
  }
}
