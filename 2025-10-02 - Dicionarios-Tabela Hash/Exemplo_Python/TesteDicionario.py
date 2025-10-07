# ------------------------------------------------------------------------
# TesteDicionario.py
# Programa principal que demonstra todas as operações básicas:
# - inserção
# - remoção
# - busca
# - atualização
# - impressão
# - tamanho
# Utiliza os dados fornecidos no enunciado.
# ------------------------------------------------------------------------

from Node import Node
from Dicionario import Dicionario

def main():
   # Criar dicionário
   d = Dicionario(capacidade=4)

   # ---------------------------------------------------------------------
   # Dados de exemplo (fornecidos)
   # TEC.0007 – Programação de Computadores (120h) - Período 1
   # TEC.0020 – Estrutura de Dados Lineares (80h) - Período 2
   # TEC.0027 – Estrutura de Dados Não-Lineares (80h) - Período 3
   # TEC.0142 – Programação para Redes (120h) - Período 3
   # TEC.0022 – Bancos de Dados (80h) - Período 1
   # ---------------------------------------------------------------------
   cursos = [
      Node("TEC.0007", "Programação de Computadores", 120, 1),
      Node("TEC.0020", "Estrutura de Dados Lineares", 80, 2),
      Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80, 3),
      Node("TEC.0142", "Programação para Redes", 120, 3),
      Node("TEC.0022", "Bancos de Dados", 80, 1),
   ]

   # Inserir todos
   print("\n>>> Inserindo disciplinas:")
   for curso in cursos:
      ok = d.inserir(curso)
      print(f"inserir({curso.getCodigoDisciplina()}) -> {ok}")

   # Tentativa de inserir duplicata
   print("\n>>> Tentando inserir duplicata (TEC.0020):")
   dup = Node("TEC.0020", "Estrutura de Dados Lineares - DUP", 80, 2)
   print(f"inserir(duplicata TEC.0020) -> {d.inserir(dup)}")

   # Imprimir tabela completa
   print("\n>>> Imprimindo tabela após inserções:")
   d.imprimirTabela()

   # Tamanho
   print(f"\n>>> Tamanho atual: {d.tamanho()}")
   
   # Buscar por código
   print("\n>>> Buscas:")
   for codigo in ["TEC.0007", "TEC.0022", "TEC.9999"]:
      resultado = d.buscarPorCodigo(codigo)
      print(f"buscarPorCodigo({codigo}) -> {resultado}")

   # Atualizar uma disciplina
   print("\n>>> Atualização (atualizar nome e carga de TEC.0142):")
   atualizado = d.atualizarPorCodigo("TEC.0142", novoNome="Prog. para Redes - Atualizado", novaCarga=100)
   print(f"atualizarPorCodigo(TEC.0142) -> {atualizado}")
   print("Buscar TEC.0142 depois da atualização ->", d.buscarPorCodigo("TEC.0142"))

   # Remover uma disciplina
   print("\n>>> Remoções:")
   rem = d.removerPorCodigo("TEC.0027")
   print(f"removerPorCodigo(TEC.0027) -> {rem}")
   rem2 = d.removerPorCodigo("TEC.9999")
   print(f"removerPorCodigo(TEC.9999) -> {rem2}")

   # Imprimir tabela após remoção
   print("\n>>> Imprimindo tabela após remoções:")
   d.imprimirTabela()
   print(f"\n>>> Tamanho final: {d.tamanho()}")

   # Verificar containsKey
   print("\n>>> containsKey exemplos:")
   print("containsKey(TEC.0027) ->", d.containsKey("TEC.0027"))
   print("containsKey(TEC.0020) ->", d.containsKey("TEC.0020"))

   # Limpar tabela
   print("\n>>> Limpando tabela:")
   d.clear()
   d.imprimirTabela()
   print(f"\n>>> Tamanho após clear: {d.tamanho()}")

if __name__ == "__main__":
   main()
