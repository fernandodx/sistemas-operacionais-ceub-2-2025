public class GerenciadorDeSessao {


    private Usuario usuario;

    public void login(String email, String senha){
        if(usuario == null){
            usuario = new Usuario();
        }
        this.usuario.carregarUsuario(email);
    }

    // boa prática
    public void logout(){
        this.usuario = null; // isso faz com que o objeto seja eletivo para o garbage collector
    }

    class Usuario{
        public void carregarUsuario(String email){
            System.out.println("Carregando usuário");
        }
    }
}
