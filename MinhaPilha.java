public class MinhaPilha {

    private int [] pilha;
    private int nElementos;

    public MinhaPilha() {
        // capacidade de armazenamento da pilha
        pilha = new int[100];
        nElementos=0;
    }

    //push(e): insere o elemento e no topo da pilha
    public boolean push(int elemento){
        if(nElementos==pilha.length)
            return false;
        
        pilha[nElementos]=elemento;
        nElementos++;

        return true;
    }

    //pop(): remove e retorna o elemento do topo da pilha (erro se a pilha estiver vazia)
    public int pop(){
        int result=top();
        nElementos--;
        return result;
    }
    //top(): retorna, mas não remove, o elemento do topo pilha (erro se a pilha estiver vazia)
    public int top(){
        if(nElementos>0)
            return pilha[nElementos-1];
        
        throw new RuntimeException("Não existem elementos na pilha");

    }

    //size(): retorna o número de elementos da pilha
    public int size(){
        return nElementos;
    }

    //isEmpty(): retorna true se a pilha estiver vazia, e false caso contrário
    public boolean isEmpty(){
        return (nElementos==0);
    }

    //clear(): esvazia a pilha
    public void clear(){
        nElementos=0;
    }

    //método criado para facilitar a representação das pilhas na atividade
    //Talvez dê para ser implementado em outro local
    public String hanoi(){
        String hanoi ="";
        for (int i=0;i<size();i++){
            if(i!=size()-1){
                hanoi+= " ".repeat(size()-i)+"["+"-".repeat(i)+pilha[i]+"-".repeat(i)+"]\n";
            }
            else{
                hanoi+= " ".repeat(size()-i)+"["+"-".repeat(i)+pilha[i]+"-".repeat(i)+"]";
            }
        }
        return hanoi;
    }

}
