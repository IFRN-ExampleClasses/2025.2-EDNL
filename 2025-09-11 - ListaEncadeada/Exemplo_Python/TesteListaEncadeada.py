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
   lista.inserirNoInicio("MAT101", "Matemática", 60)
   lista.inserirNoFim("FIS101", "Física", 45)
   lista.inserirNoFim("QUI101", "Química", 50)
   lista.inserirNoInicio("POR101", "Português", 40)

   # Inserção em posição
   print("--- Inserindo disciplina em posição 2 ---")
   lista.inserirNaPosicao(2, "BIO101", "Biologia", 55)

   # Impressão da lista
   lista.imprimirLista()
   print("Tamanho após inserções:", lista.tamanho(), "\n")

   # Busca
   print("--- Buscando disciplina MAT101 ---")
   encontrado = lista.buscarPorCodigo("MAT101")
   print("Encontrado?", encontrado)
   print("Tamanho atual:", lista.tamanho(), "\n")

   # Atualização
   print("--- Atualizando carga horária de FIS101 ---")
   atualizado = lista.atualizarDisciplina("FIS101", "Física", 60)
   print("Atualizado?", atualizado)
   lista.imprimirLista()
   print("Tamanho após atualização:", lista.tamanho(), "\n")

   # Remoção
   print("--- Removendo disciplina QUI101 ---")
   removido = lista.removerPorCodigo("QUI101")
   print("Removido?", removido)
   lista.imprimirLista()
   print("Tamanho após remoção:", lista.tamanho(), "\n")

   # Remover outra disciplina
   print("--- Removendo disciplina POR101 ---")
   lista.removerPorCodigo("POR101")
   lista.imprimirLista()
   print("Tamanho final da lista:", lista.tamanho())
