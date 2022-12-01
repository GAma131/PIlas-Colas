package ColasVectores;

import javax.swing.JOptionPane;

public class ColasV {

  private int[] vector;
  private int tope;

  public ColasV(int tamanio) {
    vector = new int[tamanio];
    tope = vector.length - 1;
  }

  public int[] getVector() {
    return vector;
  }

  public void setVector(int[] vector) {
    this.vector = vector;
  }

  public void setTope(int tope) {
    this.tope = tope;
  }

  public int getTope() {
    return tope;
  }

  public boolean estaVacia() {
    return tope == -1;
  }

  public int llenarPila(int[] aux) {
    setVector(aux);
    for (int i = 0; i < aux.length; i++) {
      vector[i] = aux[i];
    }
    return tope;
  }

  public int pop() { //? Mandar tamaño? int tope
    tope--;
    if (tope < 0) {
      JOptionPane.showMessageDialog(null, "El tope ya no puede bajar más!");
      tope = 0;
    } else {
      setTope(tope);
    }
    return tope;
  }

  public int busquedaSecuencial(int valor) {
    for (int i = 0; i < vector.length; i++) {
      if (valor == vector[i]) {
        return i;
      }
    }
    return -1;
  }

  public int pValor(int valor) {
    for (int i = 0; i < vector.length; i++) {
      if (valor == vector[i]) {
        this.tope = i;
        pop();
        return this.tope;
      }
    }
    return -1;
  }

  public String imprimir(int tope) {
    String imp = "";
    if (estaVacia()) {
      JOptionPane.showMessageDialog(null, "La pila está vacia!");
    } else {
      int i = getTope();
      while (i >= 0) {
        imp += "  " + vector[i] + "←";
        i--;
      }
    }
    return imp;
  }
}
