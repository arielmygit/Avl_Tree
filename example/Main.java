package org.example;

public class Main {
    public static void main(String[] args) {
        Arbol tree = new Arbol();

        tree.raiz = tree.insertar(tree.raiz, 10);
        tree.raiz = tree.insertar(tree.raiz, 20);
        tree.raiz = tree.insertar(tree.raiz, 30);
        tree.raiz = tree.insertar(tree.raiz, 40);
        tree.raiz = tree.insertar(tree.raiz, 50);
        tree.raiz = tree.insertar(tree.raiz, 25);

        tree.Orden(tree.raiz);
    }
}