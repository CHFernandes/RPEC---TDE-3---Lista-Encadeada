public class Main {
    public static void main (String[]args){

        Lista l = new Lista();

        l.insere_primeiro(5);
        l.insere_ultimo(6);
        l.insere_ultimo(7);

        l.mostra_lista();

        No no = retorna_no(l,4);

        imprime_dado(no);

        l.mostra_lista();
        System.out.println();

        l.insere_primeiro(2);
        l.mostra_lista();
        System.out.println();

        inserir_depois(l,6,9);
        l.mostra_lista();
        System.out.println();

        l.insere_ultimo(1);
        l.mostra_lista();
        System.out.println();

        ordenar(l);
        l.mostra_lista();
        System.out.println();

        l.retira_primeiro();
        System.out.println();

        l.mostra_lista();
        System.out.println();

        retirar_depois(l,6);
        l.mostra_lista();
        System.out.println();

        l.retira_ultimo();
        System.out.println();

        l.mostra_lista();
        System.out.println();

        System.out.println(l.retorna_ultimo());

        Lista o = new Lista();
        o.insere_ordenado(5);
        o.insere_ordenado(6);
        o.insere_ordenado(7);

        System.out.println();

        similaridade(l,o);

        Lista a = new Lista();
        a.insere_primeiro(5);
        a.insere_primeiro(3);
        a.insere_primeiro(6);
        a.insere_primeiro(4);
        a.insere_primeiro(6);


        Lista b = new Lista();
        b.insere_primeiro(4);
        b.insere_primeiro(5);
        b.insere_primeiro(3);

        Lista c = interseccao(a,b);
        System.out.println();

        c.mostra_lista();
        System.out.println();

        System.out.println("Tamanho lista: " + a.size(a.getprimeiro()));
        System.out.println();

        System.out.println("Tamanho lista: " + a.soma(0,a.getprimeiro()));
    }

    public static void imprime_dado(No n){
        try{
            System.out.println(n.getDado());
        }
        catch (NullPointerException e){
            System.out.println("Uso de referencia nula");
        }
    }

    public static No retorna_no(Lista l, int valor){
        No no = l.acha_no(valor);

        if (no.getDado() != -1){
            return no;
        }else {
            return null;
        }
    }

    public static void retirar_depois(Lista l, int info){
        No n;
        n = retorna_no(l, info);
        l.retira_depois(n);
    }

    public static void inserir_depois(Lista l, int info, int ins){
        No n;
        n = retorna_no(l, info);
        l.insere_depois(n, ins);
    }

    public static void ordenar(Lista l){
        Lista temp = new Lista();
        No i = l.getprimeiro();

        while (i != null){
            temp.insere_ordenado(i.getDado());
            i = i.getProximo();
        }

        l.nullify();

        No u = temp.getprimeiro();
        while (u != null){
            l.insere_ordenado(u.getDado());
            u = u.getProximo();
        }

        nullify(temp); // feito isso para não dar exceção de código duplicado, por alguma razão o IDE fica fazendo isso

    }

    public static void nullify(Lista temp){
        temp.nullify();
    }

    public static void similaridade(Lista a,Lista b){
        if (tamanho(a) == tamanho(b)){
            int sum1 = 0;
            double sum2 = 0;
            double sum3 = 0;
            No aa = a.getprimeiro();
            No bb = b.getprimeiro();
            while (aa != null && bb !=null){
                sum1 = sum1 + (aa.getDado() * bb.getDado());
                aa = aa.getProximo();
                bb = bb.getProximo();
            }
            aa = a.getprimeiro();
            while (aa!=null){
                System.out.println("a: " + aa.getDado());
                sum2 = sum2 + Math.pow(aa.getDado(),2);
                aa = aa.getProximo();
            }
            bb = b.getprimeiro();
            while (bb!=null){
                System.out.println("b: " + bb.getDado());
                sum3 = sum3 + Math.pow(bb.getDado(),2);
                bb = bb.getProximo();
            }
            double mul = sum2 * sum3;
            double root = Math.sqrt(mul);
            double s = sum1 / root;

            System.out.println("Similaridade :" + s);
        }else {
            System.out.println("Tamanhos Diferentes");
        }

    }

    public static int tamanho(Lista l){
        No p = l.getprimeiro();
        int i = 0;
        while (p != null){
            i = i + 1;
            p = p.getProximo();
        }
        return i;
    }

    public static Lista interseccao(Lista a, Lista b){
        ordenar(a);
        ordenar(b);

        No aa = a.getprimeiro();
        No bb = b.getprimeiro();

        Lista c = new Lista();

        while (aa != null){
            int dadoa = aa.getDado();
            while (bb != null){
                int dadob = bb.getDado();
                if (dadoa == dadob){
                    c.insere_ordenado(dadoa);
                }
                bb = bb.getProximo();
            }
            aa = aa.getProximo();
            bb = b.getprimeiro();
        }
        return c;
    }
}
