# ------------------------------------------------------------------------
# TestePilha.py
# Programa principal que demonstra todas as operações básicas da pilha.
# Usa a variável pilha_disciplinas e as disciplinas fornecidas.
# ------------------------------------------------------------------------
from Node import Node
from Pilha import Pilha

def main():
   # Cria a pilha
   pilhaDisciplinas = Pilha()

   # Inserções
   print("Inserindo elementos na pilha...")
   pilhaDisciplinas.push(Node("TEC.0007", "Programação de Computadores", 120))
   pilhaDisciplinas.push(Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80))
   pilhaDisciplinas.push(Node("TEC.0142", "Programação para Redes", 120))
   pilhaDisciplinas.push(Node("TEC.0022", "Bancos de Dados", 80))
   pilhaDisciplinas.imprimirLista()
   print("Tamanho após inserções:", pilhaDisciplinas.tamanho(), "\n")

   # Peek
   print("Peek (topo atual):", pilhaDisciplinas.peek())
   print("Tamanho permanece:", pilhaDisciplinas.tamanho(), "\n")

   # Pop
   print("Removendo (pop) elemento do topo...")
   removido = pilhaDisciplinas.pop()
   print("Elemento removido:", removido)
   print("Tamanho após pop:", pilhaDisciplinas.tamanho(), "\n")

   # Busca por código
   codigo_busca = "TEC.0027"
   print(f"Buscando código {codigo_busca}...")
   encontrado = pilhaDisciplinas.buscarPorCodigo(codigo_busca)
   print("Encontrado:" if encontrado else "Não encontrado:", encontrado, "\n")

   # Atualização
   print("Atualizando TEC.0027 (novo nome e nova carga)...")
   atualizado = pilhaDisciplinas.atualizar(
      "TEC.0027",
      "Estrutura de Dados Não-Lineares - Avançado",
      96
   )
   print("Atualizado com sucesso?", atualizado)
   pilhaDisciplinas.imprimirLista()
   print("Tamanho:", pilhaDisciplinas.tamanho(), "\n")

   # Remoção por código
   print("Removendo por código TEC.0007...")
   removido_codigo = pilhaDisciplinas.removerPorCodigo("TEC.0007")
   print("Removido TEC.0007?", removido_codigo)
   pilhaDisciplinas.imprimirLista()
   print("Tamanho:", pilhaDisciplinas.tamanho(), "\n")

   # Verificação contains
   print("Verificando se existe TEC.0022:", pilhaDisciplinas.contains("TEC.0022"))
   print("Verificando se existe TEC.0007:", pilhaDisciplinas.contains("TEC.0007"), "\n")

   # Limpar pilha
   print("Esvaziando a pilha...")
   pilhaDisciplinas.clear()
   print("Pilha vazia?", pilhaDisciplinas.isEmpty())
   print("Tamanho final:", pilhaDisciplinas.tamanho())

if __name__ == "__main__":
   main()
