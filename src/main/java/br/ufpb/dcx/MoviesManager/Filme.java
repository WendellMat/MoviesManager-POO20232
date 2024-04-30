package br.ufpb.dcx.MoviesManager;

import java.io.Serializable;
import java.util.List;

public class Filme implements Serializable{
    private String codigo;
    private String nome;
    private int anoDeLancamento;
    private String sinopse;
    private double notaIMDB;
    private GeneroFilme genero;
    private List<Ator> atores;

    public Filme(String codigo, String nome, int anoDeLancamento, String sinopse,
                 double notaIMDB, GeneroFilme genero, List<Ator> atores) {
        this.codigo = codigo;
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.sinopse = sinopse;
        this.notaIMDB = notaIMDB;
        this.genero = genero;
        this.atores = atores;
    }
    public Filme() {

    }
    public boolean ehDoTipo (GeneroFilme genero){
        return this.genero == genero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public double getNotaIMDB() {
        return notaIMDB;
    }

    public void setNotaIMDB(double notaIMDB) {
        this.notaIMDB = notaIMDB;
    }

    public GeneroFilme getGenero() {
        return genero;
    }

    public void setGenero(GeneroFilme genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "\ncodigo= " + codigo +
                "\nnome= " + nome +
                "\nanoDeLancamento= " + anoDeLancamento +
                "\nsinopse= " + sinopse +
                "\nnotaIMDB= " + notaIMDB +
                "\ngenero= " + genero +
                "\natores= " + atores +
                "\n}";
    }
}
