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
    List<Ator> filmesDoTeste;

    @BeforeEach
    public void setup() {
        sistema = new SistemaFilmes_Leticia_Iran_Wendell();
        filmesDoTeste = new ArrayList<>();
    }

    @Test
    public void testaCadastro() {
        boolean cadastrou = sistema.cadastrarFilme("#001", "127 Horas", 2010,
                "syfhdbfhubyeui", 7.5, GeneroFilme.ACAO, filmesDoTeste);
        assertEquals(true, cadastrou);
    }

    @Test
    public void testaPesquisaFilmePorNome() {

    }

    @Test
    public void testaExisteFilme() {

    }

    @Test
    public void testaPesquisaTodosOsFilmesCadastrados() {

    }

    @Test
    public void testaGetFilmesLancadosNoAno() {

    }
}
