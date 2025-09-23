# ------------------------------------------------------------------------
# TesteFila.py
# Demonstra todas as operações básicas da fila.
# ------------------------------------------------------------------------
from Node import Node
from Fila import Fila

def main():
   filaDisciplinas = Fila()

   # Inserções
   print("Enfileirando disciplinas...")
   filaDisciplinas.enqueue(Node("TEC.0007", "Programação de Computadores", 120))
   filaDisciplinas.enqueue(Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80))
   filaDisciplinas.enqueue(Node("TEC.0142", "Programação para Redes", 120))
   filaDisciplinas.enqueue(Node("TEC.0022", "Bancos de Dados", 80))
   filaDisciplinas.imprimirLista()
   print("Tamanho após inserções:", filaDisciplinas.tamanho(), "\n")

   # Frente da fila
   print("Elemento da frente:", filaDisciplinas.front())
   print("Tamanho permanece:", filaDisciplinas.tamanho(), "\n")

   # Dequeue
   print("Desenfileirando elemento da frente...")
   removido = filaDisciplinas.dequeue()
   print("Removido:", removido)
   filaDisciplinas.imprimirLista()
   print("Tamanho após dequeue:", filaDisciplinas.tamanho(), "\n")

   # Busca
   print("Buscando TEC.0027...")
   encontrado = filaDisciplinas.buscarPorCodigo("TEC.0027")
   print("Encontrado:" if encontrado else "Não encontrado:", encontrado, "\n")

   # Atualizar
   print("Atualizando TEC.0027...")
   ok = filaDisciplinas.atualizar("TEC.0027",
      "Estrutura de Dados Não-Lineares - Avançado", 96)
   print("Atualizado?", ok)
   filaDisciplinas.imprimirLista()
   print("Tamanho:", filaDisciplinas.tamanho(), "\n")

   # Remover por código
   print("Removendo por código TEC.0142...")
   ok = filaDisciplinas.removerPorCodigo("TEC.0142")
   print("Removido TEC.0142?", ok)
   filaDisciplinas.imprimirLista()
   print("Tamanho:", filaDisciplinas.tamanho(), "\n")

   # Contains
   print("Fila contém TEC.0022?", filaDisciplinas.contains("TEC.0022"))
   print("Fila contém TEC.0142?", filaDisciplinas.contains("TEC.0142"), "\n")

   # Limpar
   print("Esvaziando fila...")
   filaDisciplinas.clear()
   print("Fila vazia?", filaDisciplinas.isEmpty())
   print("Tamanho final:", filaDisciplinas.tamanho())

if __name__ == "__main__":
   main()
