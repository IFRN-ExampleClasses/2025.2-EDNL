# ------------------------------------------------------------------------
# Implementação Completa de Lista Simplesmente Encadeada em Java
# Inclui inserções, remoções, buscas, atualizações e impressão
# ------------------------------------------------------------------------


# ------------------------------------------------------------------------
# Classe Nó
class Node:
   def __init__(self, data):
      self.data = data
      self.next = None


# ------------------------------------------------------------------------
# Classe Lista Simplesmente Encadeada Completa
class LinkedList:
   def __init__(self):
      self.head = None

   # --------------------------------------------------------------------- 
   # Inserções
   def insert_at_head(self, value):
      new_node = Node(value)
      new_node.next = self.head
      self.head = new_node

   def insert_at_tail(self, value):
      new_node = Node(value)
      if self.head is None:
         self.head = new_node
         return
      current = self.head
      while current.next is not None:
         current = current.next
      current.next = new_node

   def insert_at_position(self, value, position):
      if position < 0:
         print("Posição inválida")
         return
      if position == 0:
         self.insert_at_head(value)
         return

      current = self.head
      index = 0
      while current is not None and index < position - 1:
         current = current.next
         index += 1

      if current is None:
         print("Posição fora do alcance")
         return

      new_node = Node(value)
      new_node.next = current.next
      current.next = new_node

   # --------------------------------------------------------------------- 
   # Remoções
   def remove_head(self):
      if self.head is not None:
         self.head = self.head.next

   def remove_by_value(self, value):
      if self.head is None:
         return
      if self.head.data == value:
         self.head = self.head.next
         return
      current = self.head
      while current.next is not None and current.next.data != value:
         current = current.next
      if current.next is not None:
         current.next = current.next.next

   def remove_at_position(self, position):
      if self.head is None or position < 0:
         return
      if position == 0:
         self.head = self.head.next
         return
      current = self.head
      index = 0
      while current.next is not None and index < position - 1:
         current = current.next
         index += 1
      if current.next is not None:
         current.next = current.next.next

   # --------------------------------------------------------------------- 
   # Buscas
   def search_by_value(self, value):
      current = self.head
      while current is not None:
         if current.data == value:
            return True
         current = current.next
      return False

   def get_at_position(self, position):
      if position < 0:
         return None
      current = self.head
      index = 0
      while current is not None and index < position:
         current = current.next
         index += 1
      if current is None:
         return None
      return current.data

   # --------------------------------------------------------------------- 
   # Atualizações
   def update_by_value(self, old_value, new_value):
      current = self.head
      while current is not None:
         if current.data == old_value:
            current.data = new_value
            return
         current = current.next
      print(f"Valor {old_value} não encontrado.")

   def update_at_position(self, position, new_value):
      if position < 0:
         print("Posição inválida")
         return
      current = self.head
      index = 0
      while current is not None and index < position:
         current = current.next
         index += 1
      if current is None:
         print("Posição fora do alcance")
         return
      current.data = new_value

   # --------------------------------------------------------------------- 
   # Impressão
   def print_list(self):
      current = self.head
      while current is not None:
         print(f"{current.data} -> ", end="")
         current = current.next
      print("None")


# ------------------------------------------------------------------------
# Testando a lista
if __name__ == "__main__":
   list = LinkedList()

   # Inserções
   list.insert_at_head(10)
   list.insert_at_tail(5)
   list.insert_at_position(20, 1)  # insere na posição 1
   list.print_list()  # 10 -> 20 -> 5 -> None

   # Atualizações
   list.update_by_value(20, 25)
   list.print_list()  # 10 -> 25 -> 5 -> None

   list.update_at_position(2, 15)
   list.print_list()  # 10 -> 25 -> 15 -> None

   # Remoções
   list.remove_head()
   list.print_list()  # 25 -> 15 -> None

   list.remove_by_value(25)
   list.print_list()  # 15 -> None

   list.remove_at_position(0)
   list.print_list()  # None
