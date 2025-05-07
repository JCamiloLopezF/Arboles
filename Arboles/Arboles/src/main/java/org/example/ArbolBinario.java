package org.example;


public class ArbolBinario {

        private class Nodo {
            int dato;
            Nodo izquierdo, derecho;

            Nodo(int dato) {
                this.dato = dato;
            }
        }

        private Nodo raiz;

        // 1. Está vacío?
        public boolean estaVacio() {
            return raiz == null;
        }

        // 2. Agregar dato
        public void agregar(int dato) {
            raiz = agregarRec(raiz, dato);
        }

        private Nodo agregarRec(Nodo actual, int dato) {
            if (actual == null) {
                return new Nodo(dato);
            }
            if (dato < actual.dato) {
                actual.izquierdo = agregarRec(actual.izquierdo, dato);
            } else if (dato > actual.dato) {
                actual.derecho = agregarRec(actual.derecho, dato);
            }
            return actual;
        }

        // 3. Recorridos
        public void inorden() {
            inordenRec(raiz);
            System.out.println();
        }

        private void inordenRec(Nodo nodo) {
            if (nodo != null) {
                inordenRec(nodo.izquierdo);
                System.out.print(nodo.dato + " ");
                inordenRec(nodo.derecho);
            }
        }

        public void preorden() {
            preordenRec(raiz);
            System.out.println();
        }

        private void preordenRec(Nodo nodo) {
            if (nodo != null) {
                System.out.print(nodo.dato + " ");
                preordenRec(nodo.izquierdo);
                preordenRec(nodo.derecho);
            }
        }

        public void postorden() {
            postordenRec(raiz);
            System.out.println();
        }

        private void postordenRec(Nodo nodo) {
            if (nodo != null) {
                postordenRec(nodo.izquierdo);
                postordenRec(nodo.derecho);
                System.out.print(nodo.dato + " ");
            }
        }

        // 4. Existe dato
        public boolean existe(int dato) {
            return existeRec(raiz, dato);
        }

        private boolean existeRec(Nodo nodo, int dato) {
            if (nodo == null) return false;
            if (nodo.dato == dato) return true;
            return dato < nodo.dato ? existeRec(nodo.izquierdo, dato) : existeRec(nodo.derecho, dato);
        }

        // 5. Obtener peso (cantidad de nodos)
        public int obtenerPeso() {
            return contarNodos(raiz);
        }

        private int contarNodos(Nodo nodo) {
            if (nodo == null) return 0;
            return 1 + contarNodos(nodo.izquierdo) + contarNodos(nodo.derecho);
        }

        // 6. Obtener altura
        public int obtenerAltura() {
            return obtenerAlturaRec(raiz);
        }

        private int obtenerAlturaRec(Nodo nodo) {
            if (nodo == null) return -1; // Altura de árbol vacío
            return 1 + Math.max(obtenerAlturaRec(nodo.izquierdo), obtenerAlturaRec(nodo.derecho));
        }

        // 7. Obtener nivel de un dato
        public int obtenerNivel(int dato) {
            return obtenerNivelRec(raiz, dato, 0);
        }

        private int obtenerNivelRec(Nodo nodo, int dato, int nivel) {
            if (nodo == null) return -1;
            if (nodo.dato == dato) return nivel;
            if (dato < nodo.dato) return obtenerNivelRec(nodo.izquierdo, dato, nivel + 1);
            else return obtenerNivelRec(nodo.derecho, dato, nivel + 1);
        }

        // 8. Contar hojas
        public int contarHojas() {
            return contarHojasRec(raiz);
        }

        private int contarHojasRec(Nodo nodo) {
            if (nodo == null) return 0;
            if (nodo.izquierdo == null && nodo.derecho == null) return 1;
            return contarHojasRec(nodo.izquierdo) + contarHojasRec(nodo.derecho);
        }

        // 9. Obtener menor
        public int obtenerNodoMenor() {
            if (estaVacio()) throw new RuntimeException("Árbol vacío");
            Nodo actual = raiz;
            while (actual.izquierdo != null) {
                actual = actual.izquierdo;
            }
            return actual.dato;
        }

        // 10. Obtener mayor
        public int obtenerNodoMayor() {
            if (estaVacio()) throw new RuntimeException("Árbol vacío");
            Nodo actual = raiz;
            while (actual.derecho != null) {
                actual = actual.derecho;
            }
            return actual.dato;
        }

        // 11. Imprimir por amplitud (nivel por nivel)
        public void imprimirAmplitud() {
            if (raiz == null) return;
            java.util.Queue<Nodo> cola = new java.util.LinkedList<>();
            cola.add(raiz);
            while (!cola.isEmpty()) {
                Nodo actual = cola.poll();
                System.out.print(actual.dato + " ");
                if (actual.izquierdo != null) cola.add(actual.izquierdo);
                if (actual.derecho != null) cola.add(actual.derecho);
            }
            System.out.println();
        }

        // 12. Eliminar un dato
        public void eliminar(int dato) {
            raiz = eliminarRec(raiz, dato);
        }

        private Nodo eliminarRec(Nodo nodo, int dato) {
            if (nodo == null) return null;
            if (dato < nodo.dato) {
                nodo.izquierdo = eliminarRec(nodo.izquierdo, dato);
            } else if (dato > nodo.dato) {
                nodo.derecho = eliminarRec(nodo.derecho, dato);
            } else {
                // Nodo encontrado
                if (nodo.izquierdo == null) return nodo.derecho;
                if (nodo.derecho == null) return nodo.izquierdo;
                // Nodo con dos hijos
                nodo.dato = obtenerMinimo(nodo.derecho);
                nodo.derecho = eliminarRec(nodo.derecho, nodo.dato);
            }
            return nodo;
        }

        private int obtenerMinimo(Nodo nodo) {
            while (nodo.izquierdo != null) {
                nodo = nodo.izquierdo;
            }
            return nodo.dato;
        }

        // 13. Borrar el árbol completo
        public void borrarArbol() {
            raiz = null;
        }
}