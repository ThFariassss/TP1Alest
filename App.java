/**
 * App
 */
import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        Scanner teclado =new Scanner (System.in);

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
        for(int i=1; i<=quantDiscos; i++){
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
        System.out.println(torre1.hanoi());
    }
}
