package br.ufpb.dcx.MoviesManager;

        import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.ArrayList;
        import java.util.List;

public class CadastrarFilmesController implements ActionListener {
    private SistemaFilmes sistema;
    private JFrame janelaPrincipal;

    public CadastrarFilmesController(SistemaFilmes sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Filme> todosOsFilmesRecuperados = sistema.listarTodosOsFilmes();
        List<Filme> todosOsFilmesCadastrados = new ArrayList<>();
        for (Filme f : todosOsFilmesRecuperados) {
            todosOsFilmesCadastrados.add(f);
        }
        for (Filme f : todosOsFilmesCadastrados) {
            JOptionPane.showMessageDialog(this.janelaPrincipal, f.toString());
        }
    }
}