import java.util.Random;

public class Desafio3 {
    public static void main(String[] args) {
        double[] faturamentoDiario = gerarFaturamentoDiario(365);
        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0;
        int diasComFaturamento = 0;

        for (double faturamento : faturamentoDiario) {
            if (faturamento > 0) {
                if (faturamento < menorFaturamento) {
                    menorFaturamento = faturamento;
                }
                if (faturamento > maiorFaturamento) {
                    maiorFaturamento = faturamento;
                }
                somaFaturamento += faturamento;
                diasComFaturamento++;
            }
        }

        double mediaAnual = somaFaturamento / diasComFaturamento;
        int diasAcimaMedia = 0;

        for (double faturamento : faturamentoDiario) {
            if (faturamento > mediaAnual) {
                diasAcimaMedia++;
            }
        }

        System.out.printf("Menor faturamento: %.2f%n", menorFaturamento);
        System.out.printf("Maior faturamento: %.2f%n", maiorFaturamento);
        System.out.printf("Dias com faturamento acima da média: %d%n", diasAcimaMedia);
    }

    public static double[] gerarFaturamentoDiario(int dias) {
        Random random = new Random();
        double[] faturamento = new double[dias];

        for (int i = 0; i < dias; i++) {
            // Gera um faturamento entre 0 e 10000, com uma chance de 30% de ser 0
            if (random.nextInt(10) < 3) {
                faturamento[i] = 0; // 30% de chance de ser 0
            } else {
                faturamento[i] = random.nextDouble() * 10000; // Faturamento entre 0 e 10000
            }
        }
        return faturamento;
    }

}