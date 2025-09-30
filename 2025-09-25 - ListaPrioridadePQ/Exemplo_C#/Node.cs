// ------------------------------------------------------------------------
// Node.cs
// Classe que representa um nó da lista de prioridade
// Todos os métodos e propriedades em camelCase
// ------------------------------------------------------------------------
public class Node
{
    // Campos privados
    private string codigoDisciplina;
    private string nomeDisciplina;
    private int cargaHoraria;
    private int semestre;

    // Construtor
    public Node(string codigoDisciplina, string nomeDisciplina, int cargaHoraria, int semestre)
    {
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.semestre = semestre;
    }

    // Propriedades públicas (camelCase)
    public string codigoDisciplinaProp
    {
        get { return codigoDisciplina; }
        set { codigoDisciplina = value; }
    }

    public string nomeDisciplinaProp
    {
        get { return nomeDisciplina; }
        set { nomeDisciplina = value; }
    }

    public int cargaHorariaProp
    {
        get { return cargaHoraria; }
        set { cargaHoraria = value; }
    }

    public int semestreProp
    {
        get { return semestre; }
        set { semestre = value; }
    }

    // Método toStringNode em camelCase
    public string toStringNode()
    {
        return $"{codigoDisciplina} – {nomeDisciplina} ({cargaHoraria}h) - Semestre {semestre}";
    }
}
