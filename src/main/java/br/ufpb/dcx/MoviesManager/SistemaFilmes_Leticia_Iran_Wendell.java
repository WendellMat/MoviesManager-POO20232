package br.ufpb.dcx.MoviesManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFilmes_Leticia_Iran_Wendell implements SistemaFilmes{
    private Map<String, Filme> filmes;
    private double notaDoIMDBParaSelecaoDosMelhoresFilmes = 8.5;

    private GravadorDeDados gravador = new GravadorDeDados();

    public SistemaFilmes_Leticia_Iran_Wendell() {

        this.filmes = new HashMap<>();
        recuperaDados();
    }
    public boolean salvarDados(){
        try {
            this.gravador.salvarFilmes(this.filmes);
            return true;
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    public void recuperaDados(){
        try {
            this.filmes = this.gravador.recuperarFilmes();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean cadastrarFilme(String codigo, String nome, int anoDeLancamento, String sinopse,
                                  double notaIMDB, GeneroFilme genero, List<Ator> atores) {
        if (!this.filmes.containsKey(codigo)) {
            this.filmes.put(codigo, (new Filme(codigo, nome, anoDeLancamento, sinopse,
                    notaIMDB, genero, atores)));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Filme> pesquisaFilme(String nome) {
        List<Filme> filmesEncontrados = new ArrayList<>();
        for (Filme f : this.filmes.values()) {
            if(f.getNome().startsWith(nome)) {
                filmesEncontrados.add(f);
            }
        }
        return filmesEncontrados;
    }

    @Override
    public List<Filme> pesquisaFilmesDoGenero(GeneroFilme genero) {
        ArrayList<Filme> filmesDeTalGenero = new ArrayList<>();
        for (Filme f : this.filmes.values()) {
            if(f.getGenero().equals(genero)) {
                filmesDeTalGenero.add(f);
            }
        }
        return filmesDeTalGenero;
    }

    @Override
    public String pesquisaMaisInformacoesDoFilme(String codigo) {
        if (this.filmes.containsKey(codigo)) {
            Filme filmeEncontrado = this.filmes.get(codigo);
            return filmeEncontrado.toString();
        } else {
            return null;
        }
    }

    @Override
    public boolean existeFilmeDoGenero(GeneroFilme genero) {
        for (Filme f : this.filmes.values()) {
            if (f.getGenero().equals(genero)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Filme> listarTodosOsFilmes() {
        List<Filme> todosOsFilmes = new ArrayList<>();
        for (Filme f : this.filmes.values()) {
            todosOsFilmes.add(f);
        }
        return todosOsFilmes;
    }

    @Override
    public List<Filme> filmesLancadosNoAno(int ano) {
        ArrayList<Filme> filmesDeTalAno = new ArrayList<>();
        for (Filme f : this.filmes.values()) {
            if (f.getAnoDeLancamento() == ano) {
                filmesDeTalAno.add(f);
            }
        }
        return filmesDeTalAno;
    }

    @Override
    public List<Filme> getFilmesBemAvaliados() {
        List<Filme> filmesBemAvaliados = new ArrayList<>();
        for (Filme f : this.filmes.values()) {
            if (f.getNotaIMDB() >= notaDoIMDBParaSelecaoDosMelhoresFilmes) {
                filmesBemAvaliados.add(f);
            }
        }
        return filmesBemAvaliados;
    }
}
