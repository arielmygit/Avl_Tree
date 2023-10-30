package org.example;

public class Nodo {
    int info;
    int altura;
    Nodo izq;
    Nodo der;

    Nodo(int data) {
        this.info = data;
        this.altura = 1;
    }
}
