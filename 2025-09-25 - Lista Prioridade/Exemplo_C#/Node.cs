// ------------------------------------------------------------------------
// Node.cs
// Classe que representa um nó da lista de prioridade
// ------------------------------------------------------------------------
public class Node
{
    // ---------------------------------------------------------------------
    // Atributos privados (usando _ para diferenciar dos públicos)
    // ---------------------------------------------------------------------
    private string _codigoDisciplina;
    private string _nomeDisciplina;
    private int _cargaHoraria;
    private int _semestre;
    private Node _proximo; // referência para o próximo nó

    // ---------------------------------------------------------------------
    // Construtor
    // ---------------------------------------------------------------------
    public Node(string codigoDisciplina, string nomeDisciplina, int cargaHoraria, int semestre)
    {
        this._codigoDisciplina = codigoDisciplina;
        this._nomeDisciplina = nomeDisciplina;
        this._cargaHoraria = cargaHoraria;
        this._semestre = semestre;
        this._proximo = null;
    }

    // ---------------------------------------------------------------------
    // Propriedades Públicas em camelCase
    // ---------------------------------------------------------------------
    public string codigoDisciplina
    {
        get { return _codigoDisciplina; }
        set { _codigoDisciplina = value; }
    }

    public string nomeDisciplina
    {
        get { return _nomeDisciplina; }
        set { _nomeDisciplina = value; }
    }

    public int cargaHoraria
    {
        get { return _cargaHoraria; }
        set { _cargaHoraria = value; }
    }

    public int semestre
    {
        get { return _semestre; }
        set { _semestre = value; }
    }

    public Node proximo
    {
        get { return _proximo; }
        set { _proximo = value; }
    }
}