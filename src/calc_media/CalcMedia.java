package calc_media;

import java.util.Scanner;

public class CalcMedia {

    static double[] notas = new double[8];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 8; i++) {
            System.out.print("Digite a nota " + i + ": ");
            double nota = scanner.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida. Digite uma nota entre 0 e 10.");
                i--; 
                continue;
            }
            notas[i - 1] = nota;
        }
        double mediaB1 = calcularMediaBimestral(notas[0], notas[1], notas[2], notas[3]);
        double mediaB2 = calcularMediaBimestral(notas[4], notas[5], notas[6], notas[7]);

        double mediaSemestre1 = calcularMediaSemestral(mediaB1, mediaB2);

        double mediaAnual = calcularMediaAnual(
            notas[0], notas[1], notas[2], notas[3],
            notas[4], notas[5], notas[6], notas[7]
        );

        System.out.println("\n--- Resultados ---");
        System.out.println("Média 1º Bimestre: " + mediaB1);
        System.out.println("Média 2º Bimestre: " + mediaB2);
        System.out.println("Média do 1º Semestre: " + mediaSemestre1);
        System.out.println("Média Anual: " + mediaAnual);
        System.out.println("--------" + (mediaAnual >= 7 ? " Aprovado" : " Reprovado") + "----------");

        scanner.close();
    }

    public static double calcularMediaBimestral(double n1, double n2, double n3, double n4) {
        return (n1 + n2 + n3 + n4) / 4;
    }

    public static double calcularMediaSemestral(double n1, double n2) {
        return (n1 + n2) / 2;
    }

    public static double calcularMediaAnual(double n1, double n2, double n3, double n4, double n5, double n6, double n7, double n8) {
        return (calcularMediaBimestral(n1, n2, n3, n4) + calcularMediaBimestral(n5, n6, n7, n8)) / 2;
    }
}