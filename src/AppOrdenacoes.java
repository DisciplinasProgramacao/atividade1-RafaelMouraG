import java.util.Random;

public class AppOrdenacoes {
  static Random aleatorio = new Random(42);

  static Integer[] gerarVetor(int tamanho) {

    Integer[] vetor = new Integer[tamanho];
    for (int i = 0; i < tamanho; i++) {
      vetor[i] = aleatorio.nextInt(1, tamanho / 2);
    }
    return vetor;
  }

  public static void main(String[] args) {
    Integer[] vetor = gerarVetor(100_000);
    Bubblesort<Integer> ordenador = new Bubblesort<Integer>();
    Integer[] vetorOrdenado = ordenador.ordenar(vetor);

    System.out.println("Tamanho do vetor: " + vetor.length);
    System.out.println("Comparações: " + ordenador.getComparacoes());
    System.out.println("Movimentações: " + ordenador.getMovimentacoes());
    System.out.println("Tempo: " + ordenador.getTempoOrdenacao());
  }
}
