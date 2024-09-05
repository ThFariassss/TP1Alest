import java.util.Scanner;
class AutoApp{
    public static void main(String[] args) {
        Scanner teclado =new Scanner (System.in);
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

        //demais variáveis que podem ser utilizadas
        int segMenorT;
        int maior;
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
        for(int r=0;r<rodadas;r++){
            for(int i=1;i<=quantDiscos;i++){
                System.out.printf(torre1.elemento((quantDiscos-i))+"||"+torre2.elemento((quantDiscos-i))+"||"+torre3.elemento((quantDiscos-i))+"\n");
            }
            System.out.println("Rodada "+r+"\nAperte ENTER para continuar");
            teclado.nextLine();
            if(menorMoveu){
                
                switch (localizaTorre(torre1, torre2, torre3, 1)) {
                    case 1:
                        segMenorT=achaSegundoMenor(torre2,torre3);
                        maior=achaMaior(torre2, torre3);
                        if(localizaTorre(torre1, torre2, torre3, segMenorT)==3){
                            torre3.push(torre2.top());
                            torre2.pop();
                        }
                        else{
                            torre2.push(torre3.top());
                            torre3.pop();
                        }
                        break;
                    case 2:
                        segMenorT=achaSegundoMenor(torre1,torre3);
                        maior=achaMaior(torre1, torre3);
                        if(localizaTorre(torre1, torre2, torre3, segMenorT)==3){
                            torre1.push(torre3.top());
                            torre3.pop();
                        }
                        else{
                            torre3.push(torre1.top());
                            torre1.pop();
                        }
                        break;
                    case 3:
                        segMenorT=achaSegundoMenor(torre2,torre1);
                        maior=achaMaior(torre2, torre1);
                        if(localizaTorre(torre1, torre2, torre3, segMenorT)==2){
                            torre1.push(torre2.top());
                            torre2.pop();
                        }
                        else{
                            torre2.push(torre1.top());
                            torre1.pop();
                        }
                        break;
                
                    default:
                        break;
                }
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
        System.out.println();
        for(int i=1;i<=quantDiscos;i++){
            System.out.printf(torre1.elemento((quantDiscos-i))+"||"+torre2.elemento((quantDiscos-i))+"||"+torre3.elemento((quantDiscos-i))+"\n");
        }
        System.out.println(fim +" Jogadas");
        teclado.close();
    }
    public static int achaSegundoMenor(MinhaPilha torreA,MinhaPilha torreB){
        int segundoMenor;
        if(torreA.isEmpty()&&torreB.isEmpty()){
            return torreA.top();
        }
        if(torreA.isEmpty()){
            return torreB.top();
        }
        if(torreB.isEmpty()){
            return torreA.top();
        }
        if(torreA.top()>torreB.top()){
            segundoMenor=torreB.top();
        }
        else{
            segundoMenor=torreA.top();
        }
        return segundoMenor;
    }
    public static int achaMaior(MinhaPilha torreA,MinhaPilha torreB){
        int maior;
        if(torreA.isEmpty()&&torreB.isEmpty()){
            return 0;
        }
        if(torreA.isEmpty()){
            return torreB.top();
        }
        if(torreB.isEmpty()){
            return torreA.top();
        }
        if(torreA.top()>torreB.top()){
            maior=torreA.top();
        }
        else{
            maior=torreB.top();
        }
        return maior;
    }
    public static int localizaTorre(MinhaPilha torre1,MinhaPilha torre2,MinhaPilha torre3, int discoX){
        if((torre1.isEmpty()==false)&&(torre2.isEmpty()==false)&&(torre3.isEmpty())){
            if(torre1.top()==discoX){
                return 1;
            }
            else{
                if(torre2.top()==discoX){
                    return 2;
                }
                else{
                    return 3;
                }
            }
        }
        else{
            if(torre1.isEmpty()){
                if(torre2.isEmpty()){
                    return 3;
                }
                else{
                    if(torre2.top()==discoX){
                        return 2;
                    }
                    else{
                        return 3;
                    }
                }
            }else{
                if(torre2.isEmpty()){
                    if(torre3.isEmpty()){
                        return 1;
                    }
                    else{
                        if(torre3.top()==discoX){
                            return 3;
                        }
                        else{
                            return 1;
                        }
                    }
                }
                else{
                    if(torre2.top()==discoX){
                        return 2;
                    }
                    else{
                        return 1;
                    }
                }
            }
                }
    }
}
        
