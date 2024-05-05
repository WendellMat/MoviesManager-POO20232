package br.ufpb.dcx.MoviesManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
                 "Pesquisa filmes por ano");
         menuPesquisar.add(menuPesquisaFilmePorNome);
         menuPesquisar.add(menuPesquisaFilmePorGenero);
         menuPesquisar.add(menuPesquisaMaisInformacoesPorCodigo);
         menuPesquisar.add(menuFilmesDoAnoTal);

         menuCadastrarFilme.addActionListener(
                 (f) -> {
                     String codigo = JOptionPane.showInputDialog(this,
                             "Qual o código do filme?");
                     String nome = JOptionPane.showInputDialog(this,
                             "Qual o nome do filme?");
                     int anoDeLancamento = Integer.parseInt(JOptionPane.showInputDialog(this,
                             "Qual o ano de lançamento do filme?"));;
                     String sinopse = JOptionPane.showInputDialog(this,
                             "Qual a sinopse do filme?");;
                     double notaIMDB = Double.parseDouble(JOptionPane.showInputDialog(this,
                             "Qual a nota do filme, de acordo com o IMDB?"));
                     String generoVelho = JOptionPane.showInputDialog(this,
                             "Qual o gênero do filme?");
                     GeneroFilme genero = converteGeneroDoFilmeParaENUM(generoVelho);
                     List<Ator> atores = perguntaElenco();
                     sistema.cadastrarFilme(codigo, nome, anoDeLancamento, sinopse, notaIMDB, genero, atores);
                 }
         );

         menuTodosOsFilmes.addActionListener(new CadastrarFilmesController(sistema, this));

         menuFilmesBemAvaliados.addActionListener(
                 (ae) -> {
                     List<Filme> filmesBemAvaliadosRecuperados = sistema.getFilmesBemAvaliados();
                     List<Filme> filmesBemAvaliados = new ArrayList<>();
                     for (Filme f : filmesBemAvaliadosRecuperados) {
                         filmesBemAvaliados.add(f);
                     }
                     for (Filme f : filmesBemAvaliados) {
                         JOptionPane.showMessageDialog(this, f.toString());
                     }
                 }
         );

         menuPesquisaFilmePorNome.addActionListener(
                 (ae) -> {
                     String nomeDoFilmeAProcurar = JOptionPane.showInputDialog(
                             "Qual o nome do filme que deseja procurar?");
                     for (Filme f : sistema.pesquisaFilme(nomeDoFilmeAProcurar)) {
                         JOptionPane.showMessageDialog(this, f.toString());
                     }
                 }
         );

         menuPesquisaFilmePorGenero.addActionListener(
                 (ae) -> {
                     String generoVelho = JOptionPane.showInputDialog(
                             "Qual gênero você deseja buscar?");
                     GeneroFilme genero = converteGeneroDoFilmeParaENUM(generoVelho);
                     for (Filme f : sistema.pesquisaFilmesDoGenero(genero)) {
                         JOptionPane.showMessageDialog(this, f.toString());
                     }
                 }
         );

         menuPesquisaMaisInformacoesPorCodigo.addActionListener(
                 (ae) -> {
                     String codigoDesejado = JOptionPane.showInputDialog(
                             "Qual o código do filme que deseja procurar?");
                     JOptionPane.showMessageDialog(this,
                             sistema.pesquisaMaisInformacoesDoFilme(codigoDesejado));
                 }
         );

         menuFilmesDoAnoTal.addActionListener(
                 (ae) -> {
                     int anoDesejado = Integer.parseInt(JOptionPane.showInputDialog(
                             "Você procura os filmes de qual ano?"));
                     List<Filme> filmesDeTalAno = new ArrayList<>();
                     for (Filme f : sistema.filmesLancadosNoAno(anoDesejado)) {
                         filmesDeTalAno.add(f);
                     }
                     for (Filme f : filmesDeTalAno) {
                         JOptionPane.showMessageDialog(this, f.toString());
                     }
                 }
         );

         barraDeMenu.add(menuCadastrar);
         barraDeMenu.add(menuFilmes);
         barraDeMenu.add(menuPesquisar);
         setJMenuBar(barraDeMenu);
     }

     private void centralizarCaixa(int width, int height) {
         Toolkit t = Toolkit.getDefaultToolkit();
         Dimension d = t.getScreenSize();
         setSize(width, height);
         int x = (d.width - getWidth()) / 2;
         int y = (d.height - getHeight()) / 2;
         setLocation(x, y);
     }

     public GeneroFilme converteGeneroDoFilmeParaENUM(String genero) {
         if (genero.equalsIgnoreCase("ação") || genero.equalsIgnoreCase("acao")) {
             return GeneroFilme.ACAO;
         } else if (genero.equalsIgnoreCase("drama")) {
             return GeneroFilme.DRAMA;
         } else if (genero.equalsIgnoreCase("comedia") || genero.equalsIgnoreCase("comédia")) {
            return GeneroFilme.COMEDIA;
         } else if (genero.equalsIgnoreCase("ficção científica") || genero.equalsIgnoreCase("sci-fi")) {
             return GeneroFilme.SCIFI;
         } else if (genero.equalsIgnoreCase("terror") || genero.equalsIgnoreCase("horror")) {
             return GeneroFilme.TERROR;
         }
         return null;
     }

     public List<Ator> perguntaElenco() {
         List<Ator> elenco = new ArrayList<>();
         int quantAtores = Integer.parseInt(JOptionPane.showInputDialog(this,
                 "Quantos atores você deseja cadastrar?"));
         for (int i=0; i<quantAtores; i++) {
             String nome = JOptionPane.showInputDialog(this,
                     "Qual o nome do ator?");
             String genero = JOptionPane.showInputDialog(this,
                     "Qual o gênero do ator? (M/F)");;
             int idade = Integer.parseInt(JOptionPane.showInputDialog(this,
                     "Qual a idade do ator?"));
             Ator ator = new Ator(nome, genero, idade);
             elenco.add(ator);
         }
         return elenco;
     }


    public static void main(String[] args) {
        JFrame janela = new br.ufpb.dcx.MoviesManager.GUIv1();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
