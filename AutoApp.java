import java.util.Scanner;
class AutoApp{
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
    }
}