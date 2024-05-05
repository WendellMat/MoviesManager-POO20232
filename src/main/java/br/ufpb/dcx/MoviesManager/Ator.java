package br.ufpb.dcx.MoviesManager;

import java.util.Objects;

public class Ator {
  private String nome;
  private String genero;
  private int idade;

  public Ator(String nome,String genero,int idade){
      this.nome = nome;
      this.genero = genero;
      this.idade = idade;
  }
  public Ator(){
      this("","",0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ator ator = (Ator) o;

        if (idade != ator.idade) return false;
        if (!Objects.equals(nome, ator.nome)) return false;
        return Objects.equals(genero, ator.genero);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + idade;
        return result;
    }

    public String toString(){
      return "Nome do Ator: "+this.nome+"Gênero: "+this.genero+"Idade: "+this.idade;
    }
}
