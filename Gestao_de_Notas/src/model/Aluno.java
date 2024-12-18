package model;

public class Aluno {
    private String matricula;
    private String nome;
    private int portugues;
    private int matematica;
    private int estudoDoMeio;
    private int educacaoMusical;
    private int educacaoPlastica;

    public Aluno(String matricula, String nome, int portugues, int matematica, int estudoDoMeio, int educacaoMusical, int educacaoPlastica) {
        this.matricula = matricula;
        this.nome = nome;
        this.portugues = portugues;
        this.matematica = matematica;
        this.estudoDoMeio = estudoDoMeio;
        this.educacaoMusical = educacaoMusical;
        this.educacaoPlastica = educacaoPlastica;
    }

    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public int getPortugues() { return portugues; }
    public int getMatematica() { return matematica; }
    public int getEstudoDoMeio() { return estudoDoMeio; }
    public int getEducacaoMusical() { return educacaoMusical; }
    public int getEducacaoPlastica() { return educacaoPlastica; }
}
