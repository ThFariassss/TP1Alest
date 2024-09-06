import java.util.Scanner;
class AutoAppV2{
    private static MinhaPilha [] lista=new MinhaPilha[4];
    private static int quantDiscos;
    private static Scanner teclado =new Scanner (System.in);
    private static int numJogadas=0;
    public static void main(String [] args){
        //Criação das torres em que os discos vão ser postos
        MinhaPilha torre1 = new MinhaPilha();
        MinhaPilha torre2 = new MinhaPilha();
        MinhaPilha torre3 = new MinhaPilha();
        
        lista[1]=torre1;
        lista[2]=torre2;
        lista[3]=torre3;
        
        //Definindo a quantidade de discos
        System.out.println("Com quantos discos você gostaria de jogar?");
        quantDiscos=teclado.nextInt();
        
        //Definindo qual das torres vai ser a primeira
        System.out.println("Em qual torre você gostaria de começar a jogar?");
        System.out.println("Direita (1) - Meio (2) - Esquerda (3)");
        int torreInicial=teclado.nextInt();
        
        for(int i=quantDiscos; i>=1; i--){
            switch(torreInicial){
                case 1:
                    lista[1].push(i);
                    break;
                case 2:
                    lista[2].push(i);
                    break;
                case 3:
                    lista[3].push(i);
                    break;
            }
        }
        teclado.nextLine();
        for(int i=1;i<=quantDiscos;i++){
            System.out.printf(lista[1].elemento((quantDiscos-i))+"||"+lista[2].elemento((quantDiscos-i))+"||"+lista[3].elemento((quantDiscos-i))+"\n");
        }
        System.out.println("Aperte ENTER para começar");
        teclado.nextLine();
        switch(torreInicial){
            case 1:
                movimentacao(quantDiscos, 1, 2, 3);
                break;
            case 2:
                movimentacao(quantDiscos, 2, 3, 1);
                break;
            case 3:
                movimentacao(quantDiscos, 3, 1, 2);
                break;
        }
        teclado.close();
    }
    public static void movimentacao(int numDiscosL, int torreA, int torreB, int torreC){
        if(numDiscosL>0){
            movimentacao(numDiscosL-1, torreA, torreC, torreB);
            int disco = lista[torreA].pop();
            lista[torreC].push(disco);
            for(int i=1;i<=quantDiscos;i++){
                System.out.printf(lista[1].elemento((quantDiscos-i))+"||"+lista[2].elemento((quantDiscos-i))+"||"+lista[3].elemento((quantDiscos-i))+"\n");
            }
            numJogadas++;
            System.out.println("Movimento "+numJogadas);
            System.out.println("Mova a peça da torre "+torreA+" para a torre "+torreC);
            System.out.println("Aperte ENTER para continuar");
            teclado.nextLine();
            movimentacao(numDiscosL-1, torreB, torreA, torreC);
        }
    }
}