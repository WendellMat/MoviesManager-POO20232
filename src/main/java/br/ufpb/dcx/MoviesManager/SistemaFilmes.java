package br.ufpb.dcx.MoviesManager;

import java.util.List;

public interface SistemaFilmes {
    boolean cadastrarFilme(String codigo, String nome, int anoDeLancamento, String sinopse,
                           double notaIMDB, GeneroFilme genero, List<Ator> atores);
    List<Filme> pesquisaFilme(String nome);
    List<Filme> pesquisaFilmesDoGenero(GeneroFilme genero);
    String pesquisaMaisInformacoesDoFilme(String codigo);
    boolean existeFilmeDoGenero(GeneroFilme genero);
    List<Filme> listarTodosOsFilmes();
    List<Filme> filmesLancadosNoAno(int ano);
    List<Filme> getFilmesBemAvaliados();

    public boolean salvarDados();
    public void recuperaDados();
}