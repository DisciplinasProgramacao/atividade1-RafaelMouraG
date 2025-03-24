import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Insercao<T extends Comparable<T>> implements IOrdenador<T>  {
    
    private long comparacoes;
    private long movimentacoes;
    private LocalDateTime inicio, fim;



    @Override
    public T[] ordenar(T[] dados){
       T[] copiaDados = Arrays.copyOf(dados, dados.length);
       int tamanho = copiaDados.length;
       comparacoes = movimentacoes = 0;
       inicio = LocalDateTime.now();
      for (int posReferencia  = 1; posReferencia <= tamanho-1; posReferencia++) {
        T valor = copiaDados[posReferencia];
        int j = posReferencia-1;
        comparacoes++;
        while (j>= 0 && valor.compareTo(copiaDados[j])<0) {
            j--;
            comparacoes++;
            
        
        copiaDados(j+1,posReferencia,copiaDados);
        copiaDados[j+1]=valor;
      }
    }
       fim = LocalDateTime.now();
       return copiaDados;
}

    private void trocar(int p1, int p2, T[] dados){
        movimentacoes+=3;
        T temp = dados[p1];
        dados[p1]= dados[p2];
        dados[p2] = temp;
    }

    private void copiaDados(int inicio, int fim, T[]vet){
        for (int i =fim;i>inicio;i++){
            movimentacoes++;
            vet[i] = vet[i-1];  
              }
    }

    @Override
    public long getComparacoes() {
       return comparacoes;
    }

    @Override
    public long getMovimentacoes() {
        return movimentacoes;
       
    }

    @Override
    public double getTempoOrdenacao() {
        return Duration.between(inicio, fim).toMillis();
    }

}