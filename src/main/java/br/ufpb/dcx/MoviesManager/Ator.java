package br.ufpb.dcx.MoviesManager;

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
    public String toString(){
      return "Nome do Ator: "+this.nome+"Gênero: "+this.genero+"Idade: "+this.idade;
    }
}
