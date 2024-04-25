package br.ufpb.dcx.MoviesManager;

import javax.swing.*;
import java.awt.*;

public class GUIv1 extends JFrame {
    JLabel linhaCentral;
    ImageIcon logoImg = new ImageIcon("./imgs/logo.jpg");
    SistemaFilmes sistema = new SistemaFilmes_Leticia_Iran_Wendell();
    JMenuBar barraDeMenu = new JMenuBar();

     public GUIv1() {
         setTitle("Meu Cinema");
         centralizarCaixa(800, 600);
         setResizable(false);
         setBackground(Color.WHITE);
         setLayout(new GridLayout(3, 1));
         linhaCentral = new JLabel(logoImg, JLabel.CENTER);
         add(new JLabel());
         add(linhaCentral);
         add(new JLabel());
         JMenu menuCadastrar = new JMenu("Cadastrar");
         JMenuItem menuCadastrarFilme = new JMenuItem(
                 "Cadastrar Filme");
         menuCadastrar.add(menuCadastrarFilme);
         JMenu menuFilmes = new JMenu("Filmes");
         JMenuItem menuTodosOsFilmes = new JMenuItem(
                 "Todos os Filmes");
         JMenuItem menuFilmesBemAvaliados = new JMenuItem(
                 "Bem avaliados");
         menuFilmes.add(menuTodosOsFilmes);
         menuFilmes.add(menuFilmesBemAvaliados);
         JMenu menuPesquisar = new JMenu("Pesquisar");
         JMenuItem menuPesquisaFilmePorNome = new JMenuItem(
                 "Pesquisa por nome");
         JMenuItem menuPesquisaFilmePorGenero = new JMenuItem(
                 "Pesquisa por gênero");
         JMenuItem menuPesquisaMaisInformacoesPorCodigo = new JMenuItem(
                 "Pesquisa mais informações por código");
         JMenuItem menuFilmesDoAnoTal = new JMenuItem(
                 "PesquisaFilmesPorAno");
         menuPesquisar.add(menuPesquisaFilmePorNome);
         menuPesquisar.add(menuPesquisaFilmePorGenero);
         menuPesquisar.add(menuPesquisaMaisInformacoesPorCodigo);
         menuPesquisar.add(menuFilmesDoAnoTal);
     }

     private void centralizarCaixa(int width, int height) {
         Toolkit t = Toolkit.getDefaultToolkit();
         Dimension d = t.getScreenSize();
         setSize(width, height);
         int x = (d.width - getWidth()) / 2;
         int y = (d.height - getHeight()) / 2;
         setLocation(x, y);
     }

    public static void main(String[] args) {
        JFrame janela = new br.ufpb.dcx.MoviesManager.GUIv1();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
