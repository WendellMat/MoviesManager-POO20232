package br.ufpb.dcx.MoviesManager;

public interface SistemaFilmes {
    boolean cadastrarFilme(Filme filme);
    List<Filme> pesquisaFilme(String nome);
    List<Filme> pesquisaFilmesDoGenero(String genero);
    String pesquisaMaisInformacoesDoFilme(Filme nome);
    boolean existeFilmeDoGenero(String genero);
    List<Filme> listarTodosOsFilmes();
    List<Filme> filmesLancadosNoAno(int ano);
    int contarFilmes(List<Filme> filmes);
}