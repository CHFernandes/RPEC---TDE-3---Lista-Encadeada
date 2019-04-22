public class No {

    private int dado;
    private No proximo;

    public No(int dado){
        this.dado = dado;
        this.proximo = null;
    }

    public void alteraproximo(No proximo){
        this.proximo = proximo;
    }

    public No getProximo (){
        return this.proximo;
    }

    public int getDado(){
        return this.dado;
    }
}
