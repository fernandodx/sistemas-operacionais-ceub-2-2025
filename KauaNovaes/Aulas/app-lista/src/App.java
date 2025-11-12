public class App {
    public static void main(String[] args) throws Exception {
        //List<String> lista = Collections.synchronizedList(new ArrayList<>());

        Lista lista = new Lista();

        for (int i=0;i<100;i++) {
            new Thread(new TarefaAdicional(lista, i)).start();
        }

        Thread.sleep(2000);

        for (int i=0;i<lista.size();i++){
            System.out.println(i + " - " + lista.getElemento(i));
        }
    }

}
