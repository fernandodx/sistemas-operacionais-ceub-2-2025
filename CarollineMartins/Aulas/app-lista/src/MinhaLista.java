public class MinhaLista {

    private String [] elementos = new String [100];
    private int indice = 0;

    int tamanho() {
        return elementos.length;
    }

    String getElemento(int indice){
        return elementos[indice];
    }

    public void addElemento(String valor){
        synchronized (this) {
            this.elementos[indice] = valor;
            this.indice++;
        }
        
    }

}
