public class GerenciadorDeSessao {

    private Usuario usuario;

    public void login(String email, String senha) {
        if(usuario == null){
            usuario = new Usuario();
        }
        this.usuario.carregarUsuario(email);
    }

    //Boa prática 
    public void logout() {
        this.usuario = null; //Isso faz com que o objeto seja eletivo para GC
    }
   
   
    class Usuario {
        public void carregarUsuario(String email){
            System.out.println("carregando usuário");
        }
    }

}
