// ------------------------------------------------------------------------
// Node.cs
// Nó da fila, representando uma disciplina.
// ------------------------------------------------------------------------
public class Node
{
    private string codigoDisciplina;
    private string nomeDisciplina;
    private int cargaHoraria;
    private Node next;

    // ---------------------------------------------------------------------
    // Construtor
    // ---------------------------------------------------------------------
    public Node(string codigoDisciplina, string nomeDisciplina, int cargaHoraria)
    {
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.next = null;
    }

    // ---------------------------------------------------------------------
    // Getters e Setters
    // ---------------------------------------------------------------------
    public string CodigoDisciplina
    {
        get { return codigoDisciplina; }
        set { codigoDisciplina = value; }
    }

    public string NomeDisciplina
    {
        get { return nomeDisciplina; }
        set { nomeDisciplina = value; }
    }

    public int CargaHoraria
    {
        get { return cargaHoraria; }
        set { cargaHoraria = value; }
    }

    public Node Next
    {
        get { return next; }
        set { next = value; }
    }

    // ---------------------------------------------------------------------
    public override string ToString()
    {
        return $"[codigo:{codigoDisciplina} | nome:{nomeDisciplina} | carga:{cargaHoraria}]";
    }
}
