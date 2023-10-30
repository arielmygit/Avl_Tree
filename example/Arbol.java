package org.example;

public class Arbol {
    Nodo raiz;

    int altu(Nodo node) {
        if (node == null)
            return 0;
        return node.altura;
    }

    int getBalance(Nodo node) {
        if (node == null)
            return 0;
        return altu(node.izq) - altu(node.der);
    }

    Nodo derRotacion(Nodo y) {
        Nodo x = y.izq;
        Nodo T2 = x.der;

        x.der = y;
        y.izq = T2;

        y.altura = Math.max(altu(y.izq), altu(y.der)) + 1;
        x.altura = Math.max(altu(x.izq), altu(x.der)) + 1;

        return x;
    }

    Nodo izqRotacion(Nodo x) {
        Nodo y = x.der;
        Nodo T2 = y.izq;

        y.izq = x;
        x.der = T2;

        x.altura = Math.max(altu(x.izq), altu(x.der)) + 1;
        y.altura = Math.max(altu(y.izq), altu(y.der)) + 1;

        return y;
    }

    Nodo insertar(Nodo node, int info) {
        if (node == null)
            return new Nodo(info);

        if (info < node.info)
            node.izq = insertar(node.izq, info);
        else if (info > node.info)
            node.der = insertar(node.der, info);
        else
            return node;

        node.altura = 1 + Math.max(altu(node.izq), altu(node.der));

        int balance = getBalance(node);

        if (balance > 1 && info < node.izq.info)
            return derRotacion(node);

        if (balance < -1 && info > node.der.info)
            return izqRotacion(node);

        if (balance > 1 && info > node.izq.info) {
            node.izq = izqRotacion(node.izq);
            return derRotacion(node);
        }

        if (balance < -1 && info < node.der.info) {
            node.der = derRotacion(node.der);
            return izqRotacion(node);
        }

        return node;
    }

    void Orden(Nodo node) {
        if (node != null) {
            System.out.print(node.info + " ");
            Orden(node.izq);
            Orden(node.der);
        }
    }

}
