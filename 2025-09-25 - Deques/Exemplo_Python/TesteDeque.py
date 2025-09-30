# ------------------------------------------------------------------------
# testeDeque.py
# Programa principal que demonstra todas as operações da Deque
# ------------------------------------------------------------------------
from Deque import Deque

def main():
   deque = Deque()

   print("=== Inserções iniciais ===")
   try:
      deque.inserirNoFim("TEC.0007", "Programação de Computadores", 120)
      print("Inserido TEC.0007 no fim.")
      deque.inserirNoFim("TEC.0027", "Estrutura de Dados Não-Lineares", 80)
      print("Inserido TEC.0027 no fim.")
      deque.inserirNoInicio("TEC.0142", "Programação para Redes", 120)
      print("Inserido TEC.0142 no início.")
      deque.inserirNoFim("TEC.0022", "Bancos de Dados", 80)
      print("Inserido TEC.0022 no fim.")
   except Exception as e:
      print("Erro:", e)

   print()
   deque.imprimirDeque()
   print("Tamanho:", deque.tamanho())
   print()

   print("=== Tentativa de duplicado TEC.0027 ===")
   try:
      deque.inserirNoFim("TEC.0027", "Duplicado", 90)
   except ValueError as e:
      print("Erro:", e)
   print()

   print("=== Busca TEC.0142 ===")
   try:
      n = deque.buscarPorCodigo("TEC.0142")
      print("Encontrado:", n)
   except KeyError as e:
      print("Erro:", e)
   print()

   print("=== Atualização TEC.0022 ===")
   try:
      deque.atualizarPorCodigo("TEC.0022", "Bancos de Dados Avançados", 90)
      print("Atualizado TEC.0022 com sucesso.")
   except KeyError as e:
      print("Erro:", e)
   print()

   deque.imprimirDeque()
   print("Tamanho:", deque.tamanho())
   print()

   print("=== Remoções início e fim ===")
   try:
      deque.removerDoInicio()
      print("Removido do início.")
      deque.removerDoFim()
      print("Removido do fim.")
   except IndexError as e:
      print("Erro:", e)
   print()

   deque.imprimirDeque()
   print("Tamanho:", deque.tamanho())
   print()

   print("=== Remoção por código TEC.0027 ===")
   try:
      deque.removerPorCodigo("TEC.0027")
      print("Removido TEC.0027 com sucesso.")
   except KeyError as e:
      print("Erro:", e)
   print()

   deque.imprimirDeque()
   print("Tamanho:", deque.tamanho())
   print()

   print("=== Esvaziamento total ===")
   while not deque.estaVazio():
      try:
         deque.removerDoInicio()
      except IndexError as e:
         print("Erro:", e)
   print("Deque esvaziada. Tamanho:", deque.tamanho())
   deque.imprimirDeque()

if __name__ == "__main__":
   main()
