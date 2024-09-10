/**
 * App
 */
import java.util.Scanner;
public class App {
    private static int numJogadas=0;
    public static void main(String[] args) {
        Scanner teclado =new Scanner (System.in);
        int discoMovido=0;
        int novaTorre=0;
        //Criação das torres em que os discos vão ser postos
        MinhaPilha torre1 = new MinhaPilha();
        MinhaPilha torre2 = new MinhaPilha();
        MinhaPilha torre3 = new MinhaPilha();

        //Definindo a quantidade de discos
        System.out.println("Com quantos discos você gostaria de jogar?");
        int quantDiscos=teclado.nextInt();

        //Definindo qual das torres vai ser a primeira
        System.out.println("Em qual torre você gostaria de começar a jogar?");
        System.out.println("Direita (1) - Meio (2) - Esquerda (3)");
        int torreInicial=teclado.nextInt();
        
        //Preenchendo a torre inicial
        for(int i=quantDiscos; i>=1; i--){
            switch(torreInicial){
                case 1:
                    torre1.push(i);
                    break;
                case 2:
                    torre2.push(i);
                    break;
                case 3:
                    torre3.push(i);
                    break;
            }
        }
        boolean jogo=true;
        while(jogo){
            //Esse laço imprime os elementos das torres para visualizar o jogo
            for(int i=1;i<=quantDiscos;i++){
                System.out.printf(torre1.elemento((quantDiscos-i))+"||"+torre2.elemento((quantDiscos-i))+"||"+torre3.elemento((quantDiscos-i))+"\n");
            }
            System.out.printf("\nDe qual torre você quer mover o disco?\n");
            discoMovido=teclado.nextInt();
            System.out.printf("\nPara qual torre você quer mover o disco?\n");
            novaTorre=teclado.nextInt();
            switch (discoMovido) {
                case 1:
                    int disco1=torre1.top();
                    if(novaTorre==2){
                        if(verificaJogada(torre2,disco1)){
                            torre1.pop();
                            torre2.push(disco1);
                        }
                    }
                    else {
                        if(verificaJogada(torre3,disco1)){
                            torre1.pop();
                            torre3.push(disco1);
                        }
                        
                    }
                    break;
                case 2:
                    int disco2=torre2.top();
                    if(novaTorre==1){
                        if(verificaJogada(torre1,disco2)){
                            torre2.pop();
                            torre1.push(disco2);
                        }
                        
                    }
                    else {
                        if(verificaJogada(torre3,disco2)){
                            torre2.pop();
                            torre3.push(disco2);
                        }
                                                
                    }
                    break;
                case 3:
                    int disco3=torre3.top();   
                    if(novaTorre==2){
                        if(verificaJogada(torre2,disco3)){
                            torre3.pop();
                            torre2.push(disco3);
                        }
                         
                    }
                    else {
                        if(verificaJogada(torre1,disco3)){
                            torre3.pop();
                            torre1.push(disco3);
                        }
                        
                    }
                    break;
            
                default:
                    System.out.println("Torre inválida!!");
                    numJogadas--;
                    break;
            }
            numJogadas++;
            switch (torreInicial) {
                case 1:
                    if(torre1.isEmpty()&&((torre2.size()==quantDiscos)||(torre3.size()==quantDiscos))){
                        jogo=false;
                    }
                    break;
                case 2:
                    if(torre2.isEmpty()&&((torre1.size()==quantDiscos)||(torre3.size()==quantDiscos))){
                        jogo=false;
                    }
                    break;
                case 3:
                    if(torre3.isEmpty()&&((torre2.size()==quantDiscos)||(torre1.size()==quantDiscos))){
                        jogo=false;
                    }
                default:
                    break;
            }
        }
        System.out.print("\nParabéns, você resolveu em "+numJogadas+" movimentos\n");
        for(int i=1;i<=quantDiscos;i++){
            System.out.printf(torre1.elemento((quantDiscos-i))+"||"+torre2.elemento((quantDiscos-i))+"||"+torre3.elemento((quantDiscos-i))+"\n");
        }
        teclado.close();
    }
    public static boolean verificaJogada(MinhaPilha torreX, int discoX){
        if(torreX.isEmpty()||torreX.top()>discoX){
            return true;
        }
        else{
            System.out.printf("Jogada Inválida!! Tente novamente\n");
            numJogadas--;
            return false;
        }
    }
}
