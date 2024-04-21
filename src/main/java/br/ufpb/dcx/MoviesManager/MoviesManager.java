package br.ufpb.dcx.MoviesManager;

import java.util.ArrayList;
import java.util.HashMap;

public class MoviesManager implements SistemaFilmes{
    private Map<String, Filme> filmes;

    public MoviesManager() {
        this.filmes = new HashMap<>();
    }

    @Override
    public boolean cadastrarFilme(Filme filme) {
        if (!this.filmes.containsKey(filme.getCodigo)) {
            this.filmes.put(filme.getCodigo, filme.getNome,
                    filme.getAnoDeLancamento, filme.getSinopse,
                    filme.getNotaIMDB);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Filme> pesquisaFilme(String nome) {
        ArrayList<Filme> filmesEncontrados = new ArrayList<>();
        for (Filme f : this.filmes.values()) {
            if(f.getNome.startsWith(nome)) {
                filmesEncontrados.add(f);
            }
        }
        return filmesEncontrados;
    }

    @Override
    public List<Filme> pesquisaFilmesDoGenero(String genero) {
        ArrayList<Filme> filmesDeTalGenero = new ArrayList<>();
        for (Filme f : this.filmes.values()) {
            if(f.getGenero.equals(genero)) {
                filmesDeTalGenero.add(f);
            }
        }
        return filmesDeTalGenero;
    }

    @Override
    public String pesquisaMaisInformacoesDoFilme(Filme filme) {
        if (this.filmes.containsKey(filme.getCodigo)) {
            Filme filmeEncontrado = this.filmes.get(filme.getCodigo);
            return filmeEncontrado.toString();
        } else {
            return null;
        }
    }

    @Override
    public boolean existeFilmeDoGenero(String genero) {
        for (Filme f : this.filmes.values()) {
            if (f.getGenero().equals(genero)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Filme> listarTodosOsFilmes() {
        return this.filmes.values();
    }

    @Override
    public List<Filme> filmesLancadosNoAno(int ano) {
        ArrayList<Filme> filmesDeTalAno = new ArrayList<>();
        for (Filme f : this.filmes.values()) {
            if (f.getAnoDeLancamento().equals(ano)) {
                filmesDeTalAno.add(f);
            }
        }
        return filmesDeTalAno;
    }

    @Override
    public int contarFilmes(List<Filme> listaDeFilmes) {
        int cont = 0;
        for (Filme f : listaDeFilmes) {
            cont++;
        }
        return cont;
    }
}
