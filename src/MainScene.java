import ColasVectores.ColasV;
import PilasVectores.PilasVectores;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class MainScene {

  private int[] numero;
  private int[] numeroCola;
  private int tope;

  public int[] getNumeroCola() {
    return numeroCola;
  }

  public void setNumeroCola(int tamano) {
    numeroCola = new int[tamano];
  }

  public void setNumeroC(int[] vector) {
    this.numeroCola = vector;
  }

  public int[] getNumero() {
    return numero;
  }

  public void setNumero(int tamano) {
    numero = new int[tamano];
  }

  public int getTope() {
    return tope;
  }

  public void setTope(int tope) {
    this.tope = tope;
  }

  public void vaciarCajas() {
    txtTope.setText(null);
    txtTamano.setText(null);
    txtTopeV.setText(null);
    txtPila.setText(null);
    txtTopeValor.setText(null);
    txtNValor.setText(null);

    txtTope.setEditable(false);
    txtTopeV.setEditable(false);
    txtTamano.setEditable(true);
    txtPila.setEditable(false);
  }

  public void vaciarCajasCola() {
    txtTamanoCola.setText(null);
    txtValorCola.setText(null);
    txtNValorCola.setText(null);
    txtCola.setText(null);
    txtInicioCola.setText(null);
    txtFinalCola.setText(null);

    txtInicioCola.setEditable(false);
    txtFinalCola.setEditable(false);
    txtTamanoCola.setEditable(true);
    txtCola.setEditable(false);
  }

  // * .......................................

  @FXML
  private Button btnAgregarValor;

  @FXML
  private Button btnAgregarValorCola;

  @FXML
  private Button btnDesencolar;

  @FXML
  private Button btnPop;

  @FXML
  private Button btnPopValor;

  @FXML
  private Button btnPopValorCola;

  @FXML
  private Button btnTamano;

  @FXML
  private Button btnTamanoCola;

  @FXML
  private Button btnVaciar;

  @FXML
  private Button btnVaciarCola;

  @FXML
  private TextArea txtCola;

  @FXML
  private TextField txtFinalCola;

  @FXML
  private TextField txtInicioCola;

  @FXML
  private TextField txtNValor;

  @FXML
  private TextField txtNValorCola;

  @FXML
  private TextArea txtPila;

  @FXML
  private TextField txtTamano;

  @FXML
  private TextField txtTamanoCola;

  @FXML
  private TextField txtTope;

  @FXML
  private TextField txtTopeV;

  @FXML
  private TextField txtTopeValor;

  @FXML
  private TextField txtValorCola;

  // * ........... PILAS .....................

  @FXML
  private void btnAsignarTamano(ActionEvent event) {
    int tamano = Integer.parseInt(txtTamano.getText());
    setNumero(tamano);
    PilasVectores pila = new PilasVectores(tamano);

    int valor = 0;
    for (int i = 0; i < this.numero.length; i++) {
      int dato = Integer.parseInt(
        JOptionPane.showInputDialog("Insertar Valor " + (i + 1))
      );
      this.numero[i] = valor = dato;
    }

    txtTope.setText(Integer.toString(pila.llenarPila(numero)));
    txtTopeV.setText(Integer.toString(valor));
    txtPila.setText(pila.imprimir());

    txtPila.setEditable(false);
    txtTope.setEditable(false);
    txtTopeV.setEditable(false);
    txtTamano.setEditable(false);
  }

  @FXML
  void btnDoAgregarValor(ActionEvent event) {
    int valor = 0;
    int[] aux = new int[Integer.parseInt(txtTamano.getText())];
    for (int i = 0; i < aux.length; i++) {
      aux[i] = this.numero[i];
    }

    int tamano = Integer.parseInt(txtTamano.getText()) + 1;
    setNumero(tamano);
    PilasVectores pila = new PilasVectores(tamano);

    int dato = Integer.parseInt(txtNValor.getText());

    for (int i = 0; i < aux.length; i++) {
      this.numero[i] = aux[i];
    }

    this.numero[tamano - 1] = valor = dato;

    txtTope.setText(Integer.toString(pila.llenarPila(numero)));
    txtTamano.setText(Integer.toString(tamano));
    txtTopeV.setText(Integer.toString(valor));
    txtPila.setText(pila.imprimir());

    txtNValor.setText(null);
  }

  @FXML
  private void btnDoPop(ActionEvent event) {
    int tamano = Integer.parseInt(txtTamano.getText());
    PilasVectores pila = new PilasVectores(tamano);

    txtTope.setText(Integer.toString(pila.llenarPila(this.numero)));
    txtTopeV.setText(Integer.toString(this.numero[tamano - 2]));
    txtTope.setText(Integer.toString(pila.pop()));
    txtTamano.setText(Integer.toString(tamano - 1));

    if (tamano <= 1) {
      txtTamano.setText(Integer.toString(1));
      vaciarCajas();
    }
    txtPila.setText(pila.imprimir());
  }

  @FXML
  void btnDoPopValor(ActionEvent event) {
    int tamano = Integer.parseInt(txtTamano.getText());
    PilasVectores pila = new PilasVectores(tamano);
    int valor = Integer.parseInt(txtTopeValor.getText());
    pila.llenarPila(numero);

    if (valor == this.numero[0]) {
      vaciarCajas();
      JOptionPane.showMessageDialog(null, "La pila se ha vaciado!");
    } else {
      txtTope.setText(Integer.toString(pila.pValor(valor)));
      txtTamano.setText(
        Integer.toString(Integer.parseInt(txtTope.getText()) + 1)
      );
      txtTopeV.setText(
        Integer.toString(this.numero[Integer.parseInt(txtTope.getText())])
      );
      pila.pValor(Integer.parseInt(txtTopeValor.getText()));
      txtPila.setText(pila.imprimir());
    }

    txtTopeValor.setText(null);
  }

  @FXML
  void btnDoVaciar(ActionEvent event) {
    PilasVectores pila = new PilasVectores(0);
    vaciarCajas();
  }

  // * ........... COLAS .....................

  @FXML
  void btnAsignarTamanoCola(ActionEvent event) {
    int tamano = Integer.parseInt(txtTamanoCola.getText());
    setNumeroCola(tamano);
    ColasV cola = new ColasV(tamano);

    int j = 0;
    for (int i = this.numeroCola.length - 1; i >= 0; i--) {
      int dato = Integer.parseInt(
        JOptionPane.showInputDialog("Insertar Valor " + (j + 1))
      );
      this.numeroCola[i] = dato;
      j++;
    }

    cola.llenarPila(numeroCola);
    txtFinalCola.setText(
      Integer.toString(this.numeroCola[numeroCola.length - 1])
    );
    txtInicioCola.setText(Integer.toString(this.numeroCola[0]));
    txtCola.setText(cola.imprimir(this.numeroCola.length - 1));

    txtInicioCola.setEditable(false);
    txtFinalCola.setEditable(false);
    txtTamanoCola.setEditable(false);
    txtCola.setEditable(false);
  }

  @FXML
  void btnDoAgregarValorCola(ActionEvent event) {
    int valor = 0;
    int[] aux = new int[Integer.parseInt(txtTamanoCola.getText())];

    for (int i = this.numeroCola.length - 1; i >= 0; i--) {
      aux[i] = this.numeroCola[i];
    }

    int tamano = getNumeroCola().length + 1;
    setNumeroCola(tamano);
    ColasV cola = new ColasV(tamano);

    int dato = Integer.parseInt(txtNValorCola.getText());

    for (int i = this.numeroCola.length - 1; i > 0; i--) {
      this.numeroCola[i] = aux[i - 1];
    }
    this.numeroCola[0] = valor = dato;

    cola.llenarPila(numeroCola);
    txtTamanoCola.setText(Integer.toString(tamano));
    txtFinalCola.setText(
      Integer.toString(this.numeroCola[numeroCola.length - 1])
    );
    txtInicioCola.setText(Integer.toString(this.numeroCola[0]));
    txtCola.setText(cola.imprimir(this.numeroCola.length - 1));

    txtNValorCola.setText(null);
  }

  @FXML
  void btnDoDesencolar(ActionEvent event) {
    int tamano = Integer.parseInt(txtTamanoCola.getText());
    ColasV cola = new ColasV(tamano);

    int[] aux = new int[Integer.parseInt(txtTamanoCola.getText())];
    for (int i = this.numeroCola.length - 1; i >= 0; i--) {
      aux[i] = this.numeroCola[i];
    }

    cola.llenarPila(this.numeroCola);
    txtFinalCola.setText(Integer.toString(this.numeroCola[tamano - 2]));
    txtInicioCola.setText(Integer.toString(this.numeroCola[0]));
    cola.pop();
    txtTamanoCola.setText(Integer.toString(tamano - 1));
    setNumeroCola(tamano - 1);

    for (int i = this.numeroCola.length - 1; i >= 0; i--) {
      this.numeroCola[i] = aux[i];
    }

    if (tamano <= 1) {
      txtTamanoCola.setText(Integer.toString(1));
    }
    txtCola.setText(cola.imprimir(tamano));
  }

  @FXML
  void btnDoPopValorCola(ActionEvent event) {
    int[] aux = new int[Integer.parseInt(txtTamanoCola.getText())];
    for (int i = this.numeroCola.length - 1; i >= 0; i--) {
      aux[i] = this.numeroCola[i];
    }
    int tamano = this.numeroCola.length;
    setNumeroCola(tamano);
    ColasV cola = new ColasV(tamano);
    int valor = Integer.parseInt(txtValorCola.getText());

    if (valor == this.numeroCola[0]) {
      vaciarCajasCola();
      JOptionPane.showMessageDialog(null, "La cola se ha vaciado!");
    } else {
      int tope = Integer.parseInt(txtTamanoCola.getText()) - 1;

      setNumeroCola(tope);

      for (int i = this.numeroCola.length - 1; i >= 0; i--) {
        this.numeroCola[i] = aux[i];
      }

      tope = this.numeroCola.length - 1;
      cola.llenarPila(this.numeroCola);
      // setNumeroCola(tope + 1);
      // setNumeroC(this.numeroCola);

      txtTamanoCola.setText(Integer.toString(tope + 1));
      txtFinalCola.setText(Integer.toString(this.numeroCola[tope]));
      txtInicioCola.setText(Integer.toString(this.numeroCola[0]));
      cola.pValor(Integer.parseInt(txtValorCola.getText()));
      txtCola.setText(cola.imprimir(tamano));
    }

    txtValorCola.setText(null);
  }

  @FXML
  void btnDoVaciarCola(ActionEvent event) {
    PilasVectores pila = new PilasVectores(0);
    vaciarCajasCola();
  }
}
