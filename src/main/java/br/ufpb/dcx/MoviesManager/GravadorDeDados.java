package br.ufpb.dcx.MoviesManager;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    public static final String ARQUIVO_FILMES = "filmes.dat";

    public HashMap<String, Filme> recuperarFilmes() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_FILMES));
            return (HashMap<String, Filme>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os filmes");
            throw new IOException("Não foi possível recuperar os dados do arquivo " + ARQUIVO_FILMES);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }

    public void salvarFilmes(Map<String, Filme> filmes) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_FILMES));
            out.writeObject(filmes);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os filmes no arquivo " + ARQUIVO_FILMES);
        }
    }
}