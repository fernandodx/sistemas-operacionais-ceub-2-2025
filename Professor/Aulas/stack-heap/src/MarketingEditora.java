public class MarketingEditora {

   public static void main(String[] args) {
        //1- Criar a editora
        EditoraBroadcast editoraBroadcast = new EditoraBroadcast();
        //2 - Criar os assinates
        UsuarioJanela usuarioBernado = new UsuarioJanela("Bernado");
        UsuarioJanela usuarioDayane = new UsuarioJanela("Dayane");
        //3 - Fazer a assinatura da revista (registra)
        editoraBroadcast.registrarAssinate(usuarioBernado); 
        editoraBroadcast.registrarAssinate(usuarioDayane);
        //4 - editora publica a nova Edição
       // editoraBroadcast.publicarRevista("Java é muito doido!");
        processarRevista(editoraBroadcast, "Publicando uma edição escondido");

        //Estou cancelando o contrato de recebimento da revista;
        editoraBroadcast.cancelarAssinatura(usuarioBernado);

        //5 - Processar uma nova edição 
        processarRevista(editoraBroadcast, "Nova Edição JS");

        editoraBroadcast.cancelarAssinatura(usuarioDayane);
   }

   public static void processarRevista(EditoraBroadcast editoraBroadcast, String nome){
        System.out.println("Processando a revista");
       try {
           Thread.sleep(3000);
       } catch (InterruptedException ex) {
       }
       editoraBroadcast.publicarRevista(nome);
   }




}
