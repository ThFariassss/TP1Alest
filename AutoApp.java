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
        double qD=quantDiscos;
        //rodadas totais
        double rodadas=Math.pow(2, qD);
        int fim=0;

        //Definindo qual das torres vai ser a primeira
        System.out.println("Em qual torre você gostaria de começar a jogar?");
        System.out.println("Direita (1) - Meio (2) - Esquerda (3)");
        int torreInicial=teclado.nextInt();
        
        //variaveis relacionadas ao menor disco
        int torreMenorDisco=torreInicial;
        int proxTorreMenorD=torreInicial+1;
        boolean menorMoveu=false;
        String espera;

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
        teclado.nextLine();
        for(int r=1;r<=rodadas;r++){
            for(int i=1;i<=quantDiscos;i++){
                System.out.printf(torre1.elemento((quantDiscos-i))+"||"+torre2.elemento((quantDiscos-i))+"||"+torre3.elemento((quantDiscos-i))+"\n");
            }
            System.out.println("Rodada "+r+"\nAperte ENTER para continuar");
            teclado.nextLine();
            if(menorMoveu){
                System.out.print("Falta implementar\n");
                menorMoveu=false;
            }
            else{
                switch (torreMenorDisco) {
                    case 1:
                        if(proxTorreMenorD==2){
                            torre2.push(torre1.top());
                            torre1.pop();
                        }
                        else{
                            torre3.push(torre1.top());
                            torre1.pop();
                        }
                        break;
                        
                    case 2:
                        if(proxTorreMenorD==3){
                            torre3.push(torre2.top());
                            torre2.pop();
                        }
                        else{
                            torre1.push(torre2.top());
                            torre2.pop();
                        }
                        break;
                        
                    case 3:
                        if(proxTorreMenorD==2){
                            torre2.push(torre3.top());
                            torre3.pop();
                        }
                        else{
                            torre1.push(torre3.top());
                            torre3.pop();
                        }
                        break;
                    default:
                        break;
                }
                torreMenorDisco=proxTorreMenorD;
                proxTorreMenorD++;
                menorMoveu=true;
                if(proxTorreMenorD>3){
                    proxTorreMenorD=1;
                }
            }
            fim=r;
        }
        System.out.print("Acabou "+fim);
        teclado.close();
    }
}