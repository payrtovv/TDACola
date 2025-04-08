import org.w3c.dom.CDATASection;

import javax.swing.*;

public class Cola {
    public Nodo frente, final_cola;
    public int tam;

    public Cola() {
        frente = null;
        final_cola = null;
        tam = 0;
    }

    public boolean esta_vacia() {
        return frente == null;
    }

    public void Mostrar_cola(JTextArea txtCont) {
        if (esta_vacia()) {
            txtCont.setText("Esta vacia");
        } else {
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;
            while (actual != null) {
                colaStr.append(actual.dato)
                        .append("\n");
                actual = actual.sig;
            }
            txtCont.setText(colaStr.toString());
        }
    }

    public void Actualizar_contenedor(JTextArea txtCont) {
        Mostrar_cola(txtCont);
    }

    public void Encolar(int dato, JTextArea txtCont) {
        Nodo nuevo = new Nodo(dato);
        if (esta_vacia()) {
            frente = nuevo;
            final_cola = nuevo;
        } else {
            final_cola.sig = nuevo;
            final_cola = nuevo;
        }
        tam++;
        Actualizar_contenedor(txtCont);
    }

    public int Desencolar(JTextArea txtCont) {

        if (esta_vacia()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
            return -1;
        }
        int dato = frente.dato;
        frente = frente.sig;
        tam--;


        if (frente == null) {
            final_cola = null;
        }
        Actualizar_contenedor(txtCont);
        return dato;


    }

}
