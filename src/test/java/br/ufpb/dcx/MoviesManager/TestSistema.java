package br.ufpb.dcx.MoviesManager;

import static org.junit.jupiter.api.Assertions.*;

import br.ufpb.dcx.MoviesManager.SistemaFilmes;
import br.ufpb.dcx.MoviesManager.SistemaFilmes_Leticia_Iran_Wendell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class TestSistema {

    SistemaFilmes sistema;
    List<Filme> filmesDoTeste;
    List<Ator> atoresDoFilme;

    @BeforeEach
    public void setup() {
        sistema = new SistemaFilmes_Leticia_Iran_Wendell();
    }

    @Test
    public void testaCadastro() {
        atoresDoFilme = new ArrayList<>();
        boolean cadastrou = sistema.cadastrarFilme("#001", "127 Horas", 2010,
                "syfhdbfhubyeui", 7.5, GeneroFilme.ACAO, atoresDoFilme);
        assertEquals(true, cadastrou);
    }

    @Test
    public void testaPesquisaFilmePorNome() {
        atoresDoFilme = new ArrayList<>();
        sistema.cadastrarFilme("#001", "Vingadores: guerra Infinita", 2010,
                "syfhdbfhubyeui", 7.5, GeneroFilme.ACAO, atoresDoFilme);
        String nomeFilme = "Vingadores";
        assertTrue(sistema.pesquisaFilme(nomeFilme).contains(new Filme("#001", "Vingadores: guerra Infinita", 2010,
                "syfhdbfhubyeui", 7.5, GeneroFilme.ACAO, atoresDoFilme)));
    }

    @Test
    public void testaExisteFilme() {
        sistema.cadastrarFilme("0001","0007",2017,"jjjjj",5.0,GeneroFilme.ACAO,atoresDoFilme);
        boolean g = sistema.existeFilmeDoGenero(GeneroFilme.ACAO);
        assertTrue(g);

    }

    @Test
    public void testaPesquisaTodosOsFilmesCadastrados() {
        sistema.cadastrarFilme("0005","top gun",2017,"jjjjj",5.0,GeneroFilme.ACAO,atoresDoFilme);
        assertTrue(sistema.listarTodosOsFilmes().size() == 1);

    }

    @Test
    public void testaGetFilmesLancadosNoAno() {
        sistema.cadastrarFilme("0006","top gun 2",2018,"jjjjj",5.0,GeneroFilme.ACAO,atoresDoFilme);
        assertTrue(sistema.filmesLancadosNoAno(2018).size() == 1);

    }
}
