# ------------------------------------------------------------------------
# Programa principal para testar todas as operações da lista encadeada
# Inclui inserção em posição específica
# ------------------------------------------------------------------------
from ListaEncadeada import ListaEncadeada

if __name__ == "__main__":
   lista = ListaEncadeada()

   print("A lista está vazia?", lista.estaVazia())
   print("Tamanho inicial:", lista.tamanho(), "\n")

   # Inserções
   print("--- Inserindo disciplinas ---")
   lista.inserirNoInicio("TEC.0007", "Programação de Computadores", 120)
   lista.inserirNoFim("TEC.0027", "Estrutura de Dados Não-Lineares", 80)
   lista.inserirNoFim("TEC.0142", "Programação para Redes", 120)
   lista.inserirNoInicio("TEC.0022", "Bancos de Dados", 80)

   # Inserção em posição
   print("--- Inserindo disciplina em posição 2 ---")
   lista.inserirNaPosicao(2, "TEC.0014", "Programação Orientada a Objetos", 80)

   # Impressão da lista
   lista.imprimirLista()
   print("Tamanho após inserções:", lista.tamanho(), "\n")

   # Busca
   print("--- Buscando disciplina TEC.0027 ---")
   encontrado = lista.buscarPorCodigo("TEC.0027")
   print("Encontrado?", encontrado)
   print("Tamanho atual:", lista.tamanho(), "\n")

   # Atualização
   print("--- Atualizando carga horária de TEC.0014 ---")
   atualizado = lista.atualizarDisciplina("TEC.0014", "Programação Orientada a Objetos", 120)
   print("Atualizado?", atualizado)
   lista.imprimirLista()
   print("Tamanho após atualização:", lista.tamanho(), "\n")

   # Remoção
   print("--- Removendo disciplina TEC.0022 ---")
   removido = lista.removerPorCodigo("TEC.0022")
   print("Removido?", removido)
   lista.imprimirLista()
   print("Tamanho após remoção:", lista.tamanho(), "\n")

   # Remover outra disciplina
   print("--- Removendo disciplina TEC.0015 ---")
   removido = lista.removerPorCodigo("TEC.0015")
   print("Removido?", removido)
   lista.imprimirLista()
   print("Tamanho final da lista:", lista.tamanho())
