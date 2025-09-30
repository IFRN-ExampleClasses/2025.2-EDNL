// ------------------------------------------------------------------------
// Deque.java
// Implementação de uma Deque (fila dupla) usando lista duplamente ligada
// Agora, métodos lançam exceções em vez de retornar booleanos
// ------------------------------------------------------------------------
import java.util.NoSuchElementException;

public class Deque implements DequeInterface {
   private Node inicio;
   private Node fim;
   private int tamanho;

   public Deque() {
      this.inicio = null;
      this.fim = null;
      this.tamanho = 0;
   }

   // Método utilitário
   private boolean existeCodigo(String codigoDisciplina) {
      Node atual = inicio;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) {
            return true;
         }
         atual = atual.getProximo();
      }
      return false;
   }

   @Override
   public void inserirNoInicio(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      if (existeCodigo(codigoDisciplina)) {
         throw new IllegalArgumentException("Código duplicado: " + codigoDisciplina);
      }
      Node novo = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      if (estaVazio()) {
         inicio = fim = novo;
      } else {
         novo.setProximo(inicio);
         inicio.setAnterior(novo);
         inicio = novo;
      }
      tamanho++;
   }

   @Override
   public void inserirNoFim(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      if (existeCodigo(codigoDisciplina)) {
         throw new IllegalArgumentException("Código duplicado: " + codigoDisciplina);
      }
      Node novo = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      if (estaVazio()) {
         inicio = fim = novo;
      } else {
         fim.setProximo(novo);
         novo.setAnterior(fim);
         fim = novo;
      }
      tamanho++;
   }

   @Override
   public void removerDoInicio() {
      if (estaVazio()) {
         throw new NoSuchElementException("Deque vazia, não é possível remover do início.");
      }
      if (inicio == fim) {
         inicio = fim = null;
      } else {
         inicio = inicio.getProximo();
         inicio.setAnterior(null);
      }
      tamanho--;
   }

   @Override
   public void removerDoFim() {
      if (estaVazio()) {
         throw new NoSuchElementException("Deque vazia, não é possível remover do fim.");
      }
      if (inicio == fim) {
         inicio = fim = null;
      } else {
         fim = fim.getAnterior();
         fim.setProximo(null);
      }
      tamanho--;
   }

   @Override
   public void removerPorCodigo(String codigoDisciplina) {
      if (estaVazio()) {
         throw new NoSuchElementException("Deque vazia, não é possível remover.");
      }
      Node atual = inicio;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) {
            if (atual == inicio) {
               removerDoInicio();
               return;
            }
            if (atual == fim) {
               removerDoFim();
               return;
            }
            Node ant = atual.getAnterior();
            Node prox = atual.getProximo();
            ant.setProximo(prox);
            prox.setAnterior(ant);
            tamanho--;
            return;
         }
         atual = atual.getProximo();
      }
      throw new NoSuchElementException("Código não encontrado: " + codigoDisciplina);
   }

   @Override
   public Node buscarPorCodigo(String codigoDisciplina) {
      Node atual = inicio;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) {
            return atual;
         }
         atual = atual.getProximo();
      }
      throw new NoSuchElementException("Código não encontrado: " + codigoDisciplina);
   }

   @Override
   public void atualizarPorCodigo(String codigoDisciplina, String novoNome, int novaCarga) {
      Node encontrado = buscarPorCodigo(codigoDisciplina);
      encontrado.setNomeDisciplina(novoNome);
      encontrado.setCargaHoraria(novaCarga);
   }

   @Override
   public void imprimirDeque() {
      System.out.println("Deque (inicio -> fim):");
      if (estaVazio()) {
         System.out.println("   [vazia]");
         return;
      }
      Node atual = inicio;
      while (atual != null) {
         System.out.println("   " + atual.toString());
         atual = atual.getProximo();
      }
   }

   @Override
   public int tamanho() {
      return tamanho;
   }

   @Override
   public boolean estaVazio() {
      return tamanho == 0;
   }
}
