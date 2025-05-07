package org.example;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.agregar(50);
        arbol.agregar(30);
        arbol.agregar(70);
        arbol.agregar(20);
        arbol.agregar(40);
        arbol.agregar(60);
        arbol.agregar(80);

        System.out.println("Inorden:");
        arbol.inorden();

        System.out.println("Preorden:");
        arbol.preorden();

        System.out.println("Postorden:");
        arbol.postorden();

        System.out.println("Existe 40: " + arbol.existe(40));
        System.out.println("Peso: " + arbol.obtenerPeso());
        System.out.println("Altura: " + arbol.obtenerAltura());
        System.out.println("Nivel de 40: " + arbol.obtenerNivel(40));
        System.out.println("Hojas: " + arbol.contarHojas());
        System.out.println("Menor: " + arbol.obtenerNodoMenor());
        System.out.println("Mayor: " + arbol.obtenerNodoMayor());

        System.out.println("Recorrido por amplitud:");
        arbol.imprimirAmplitud();

        System.out.println("Eliminando 70...");
        arbol.eliminar(70);
        arbol.inorden();

        System.out.println("Borrando todo el árbol...");
        arbol.borrarArbol();
        System.out.println("¿Está vacío?: " + arbol.estaVacio());
    }
}
