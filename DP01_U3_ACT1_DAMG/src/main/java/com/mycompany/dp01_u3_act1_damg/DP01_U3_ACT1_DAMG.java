
package com.mycompany.dp01_u3_act1_damg;

public class DP01_U3_ACT1_DAMG {
       static void imprimirMatriz(int[][] matriz) {
        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[y].length; x++) {
                System.out.printf("%d ", matriz[y][x]);
            }
            System.out.println();
        }
    }

    static void sumaFilas(int[][] matriz) {
        for (int y = 0; y < matriz.length; y++) {
            int suma = 0;
            for (int x = 0; x < matriz[y].length; x++) {
                System.out.printf("%d ", matriz[y][x]);
                suma += matriz[y][x];
            }
            System.out.printf("= %d\n", suma);
        }
    }

    static void sumaColumnas(int[][] matriz) {
        // Imprimir la matriz normalmente
        imprimirMatriz(matriz);
        // Debajo de ella imprimir una línea divisora
        for (int x = 0; x < matriz[0].length; x++) {
            System.out.print("____");
        }
        System.out.println();
        // Luego recorrer por columna y sumar
        for (int x = 0; x < matriz[0].length; x++) {
            int suma = 0;
            for (int y = 0; y < matriz.length; y++) {
                suma += matriz[y][x];
            }
            System.out.printf("%d ", suma);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Daniel Mendoza Gutierrez Matricula:ES231109257");
        int[][] matriz = {
                { 1, 20, 38, 44, 49, 29, 13},
                {14,  2, 21, 39, 28, 12, 30},
                {34, 15, 3, 22, 11, 31, 48},
                {47, 35, 16,  4, 23, 40, 45},
                {42, 27, 10, 17,  5, 24, 41},
                {26,  9, 32, 36, 18,  6, 25},
                { 8, 33, 43, 46, 37, 19,  7},
        };
        System.out.println("La matriz es: ");
        imprimirMatriz(matriz);
        System.out.println();
        System.out.println("Suma de filas:");
        sumaFilas(matriz);
        System.out.println();
        System.out.println("Suma de columnas:");
        sumaColumnas(matriz);}
}
