import java.util.Scanner;

public class VetorFuncoes {

    public static void bubbleSort(int[] vetor) {
        boolean troca = true;

        while (troca) {
            troca = false;

            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    troca = true;
                }
            }
        }
    }

    public static void empurrarMenosUmParaFim(int[] vetor) {
        int n = vetor.length;
        for (int passo = 0; passo < n; passo++) {
            for (int i = 0; i < n - 1; i++) {
                if (vetor[i] == -1 && vetor[i + 1] != -1) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                }
            }
        }
    }

    public static int[] preencherVetor(int n, Scanner sc) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }
        return vetor;
    }

    public static void imprimirVetor(int[] v) {
        System.out.print("{ ");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]);
            if (i < v.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

    public static void imprimirMaiorImpar(int[] v) {
        int maiorImpar = -1;
        boolean achou = false;

        for (int valor : v) {
            if (valor % 2 != 0) {
                if (!achou || valor > maiorImpar) {
                    maiorImpar = valor;
                    achou = true;
                }
            }
        }

        if (achou) {
            System.out.println("O maior número ímpar é: " + maiorImpar);
        } else {
            System.out.println("Não há números ímpares no vetor");
        }
    }

    public static void criarParesImpares(int[] v, int[] pares, int[] impares) {
        int indexPar = 0;
        int indexImpar = 0;

        for (int valor : v) {
            if (valor % 2 == 0) {
                pares[indexPar++] = valor;
            } else {
                impares[indexImpar++] = valor;
            }
        }

        while (indexPar < pares.length) {
            pares[indexPar++] = -1;
        }

        while (indexImpar < impares.length) {
            impares[indexImpar++] = -1;
        }

        bubbleSort(pares);
        bubbleSort(impares);

        empurrarMenosUmParaFim(pares);
        empurrarMenosUmParaFim(impares);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos valores vai colocar no vetor? ");
        int n = sc.nextInt();

        int[] vetor = preencherVetor(n, sc);
        bubbleSort(vetor);

        // Contar pares e ímpares
        int qtdPar = 0;
        int qtdImpar = 0;
        for (int num : vetor) {
            if (num % 2 == 0) qtdPar++;
            else qtdImpar++;
        }

        int maxTam = Math.max(qtdPar, qtdImpar);
        int[] pares = new int[maxTam];
        int[] impares = new int[maxTam];

        criarParesImpares(vetor, pares, impares);

        System.out.print("Vetor original ordenado: ");
        imprimirVetor(vetor);

        imprimirMaiorImpar(vetor);

        System.out.print("Vetor de pares: ");
        imprimirVetor(pares);

        System.out.print("Vetor de ímpares: ");
        imprimirVetor(impares);

        sc.close();
    }
}
