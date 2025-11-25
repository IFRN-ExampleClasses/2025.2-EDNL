import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GeradorDeNumeros {

   private final List<Integer> listaDeNumeros;

   /**
    * Construtor que executa a lógica de geração.
    * @throws IllegalArgumentException se o intervalo for menor que a quantidade solicitada.
    */
   public GeradorDeNumeros(int quantidade, int limiteInferior, int limiteSuperior) {
      
      // Validação: Garante que o range (max - min) é suficiente
      long intervaloPossivel = (long) limiteSuperior - limiteInferior + 1;
      
      if (quantidade > intervaloPossivel) {
         throw new IllegalArgumentException("Intervalo insuficiente para gerar " + quantidade + " números distintos.");
      }
      
      if (limiteInferior > limiteSuperior) {
         throw new IllegalArgumentException("O limite inferior não pode ser maior que o superior.");
      }

      Set<Integer> numerosUnicos = new HashSet<>();
      Random random = new Random();

      // Loop de geração
      while (numerosUnicos.size() < quantidade) {
         // nextInt(n) retorna 0..n-1. Somamos o limiteInferior para ajustar o range.
         int numero = random.nextInt((limiteSuperior - limiteInferior) + 1) + limiteInferior;
         numerosUnicos.add(numero);
      }

      // Converte o Set para List
      this.listaDeNumeros = new ArrayList<>(numerosUnicos);
   }

   /**
    * Retorna a lista gerada.
    */
   public List<Integer> getResultado() {
      return new ArrayList<>(listaDeNumeros); // Retorna uma cópia por segurança
   }
}