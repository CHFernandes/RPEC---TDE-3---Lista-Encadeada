public class Lista {

    private No primeiro;
    private No ultimo;
    private int tamanho;

    public Lista(){
        this.tamanho = 0;
    }

    public boolean vazia(){
        if (this.primeiro == null && this.ultimo == null){
            return true;
        }else {
            return false;
        }
    }

    public void insere_primeiro(int info){
        No novo = new No(info);
        if (vazia()){
            this.primeiro = novo;
            this.ultimo = novo;
        }else {
            novo.alteraproximo(this.primeiro);
            this.primeiro = novo;
        }

    }

    public void insere_depois(No no, int info){
        No novo = new No(info);
        novo.alteraproximo(no.getProximo());
        no.alteraproximo(novo);
    }

    public void insere_ultimo(int info){
        No novo = new No(info);
        this.ultimo.alteraproximo(novo);
        this.ultimo = novo;
    }

    public void insere_ordenado(int info){
        if (vazia()){
            insere_primeiro(info);
        }else {
            if(this.primeiro.getDado() >= info){
                insere_primeiro(info);
            }else {
                if (info >= this.ultimo.getDado()){
                    insere_ultimo(info);
                }else {
                    No p = this.primeiro;
                    while (p.getProximo().getDado() < info){
                        p = p.getProximo();
                    }
                    insere_depois(p,info);
                }
            }
        }
    }

    public void mostra_lista(){
        No p = this.primeiro;

        while (p != null){
            System.out.println(p.getDado());
            p = p.getProximo();
        }
    }

    public No acha_no(int info){
        No p = this.primeiro;
        while (p != null){
            if(p.getDado() == info){
                return p;
            }
            p = p.getProximo();
        }
        return new No(-1);
    }

    public void retira_primeiro(){
        System.out.println(this.primeiro.getDado());
        this.primeiro = this.primeiro.getProximo();
    }

    public void retira_depois(No no){

        No retirar, atual;
        retirar = no.getProximo();
        atual = this.primeiro;

        while (atual != null){
            if (atual.getProximo() == retirar){
                atual.alteraproximo(retirar.getProximo());
            }
            atual = atual.getProximo();
        }
    }

    public No getprimeiro(){
        return this.primeiro;
    }

    public void nullify(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public void retira_ultimo(){
        No p = this.primeiro;

        while (p.getProximo() != this.ultimo){
            p = p.getProximo();
        }

        System.out.println(this.ultimo.getDado());
        this.ultimo = p;
        p.alteraproximo(null);
    }

    public int retorna_ultimo(){
        return this.ultimo.getDado();
    }

    public int size(No p){
        if (p != null){
            return  size(p.getProximo()) + 1;
        }else {
            return  0;
        }
    }

    public int soma(int contador, No p){
        if (p != null){
            contador = contador + 1;
           return soma(contador, p.getProximo());
        }
        return contador;
    }

}
