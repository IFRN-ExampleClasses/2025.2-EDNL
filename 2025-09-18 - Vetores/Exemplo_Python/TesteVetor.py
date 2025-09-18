# ------------------------------------------------------------------------
# teste_vetor.py
# Programa principal para demonstrar todas as operações da estrutura Vetor
# ------------------------------------------------------------------------
from Vetor import Vetor
from Node import Node

def main():
   vetor = Vetor()
   print("=== Teste da estrutura Vetor ===")

   # Inserções iniciais
   vetor.inserir(Node("TEC.0007", "Programação de Computadores", 120))
   vetor.inserir(Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80))
   vetor.inserir(Node("TEC.0142", "Programação para Redes", 120))
   vetor.inserir(Node("TEC.0022", "Bancos de Dados", 80))
   vetor.imprimirVetor()

   # Inserção duplicada
   print("\n-- Inserção duplicada --")
   print(vetor.inserir(Node("TEC.0027", "Duplicado", 30)))
   vetor.imprimirVetor()

   # Inserção em posição específica
   print("\n-- Inserir em posição 1 --")
   vetor.inserirEm(Node("TEC.0014", "Programação Orientada a Objetos", 80), 1)
   vetor.imprimirVetor()

   # Atualização válida
   print("\n-- Atualização válida --")
   vetor.atualizarPorCodigo("TEC.0014", Node("TEC.0014", "Programação Orientada a Objetos", 120))
   vetor.imprimirVetor()

   # Remoção por código
   print("\n-- Remoção por código TEC.0022 --")
   vetor.removerPorCodigo("TEC.0022")
   vetor.imprimirVetor()

   # Remoção por posição
   print("\n-- Remoção por posição 1 --")
   vetor.removerPorPosicao(1)
   vetor.imprimirVetor()

   print(f"\nTamanho final: {vetor.tamanho()}")
   print(f"Está vazio? {vetor.estaVazio()}")

if __name__ == "__main__":
   main()
