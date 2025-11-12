public class UsuarioJanela implements ContratoRevistaListener {

    private String nome;

    public UsuarioJanela(String nome) {
        this.nome = nome;
    }
    

    @Override
    public void entregarRevistaEvent(String conteudo) {
       System.out.println("Eu "+nome+ " vou ler a revista com o conteúdo: "+conteudo);
    }


}
