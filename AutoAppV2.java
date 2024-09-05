import java.util.Scanner;
class AutoAppV2{
    public static void main(String [] args){
        Scanner teclado =new Scanner (System.in);
        //Criação das torres em que os discos vão ser postos
        MinhaPilha torre1 = new MinhaPilha();
        MinhaPilha torre2 = new MinhaPilha();
        MinhaPilha torre3 = new MinhaPilha();
        MinhaPilha [] lista=new MinhaPilha[4];
        lista[1]=torre1;
        lista[2]=torre2;
        lista[3]=torre3;
        
        //Definindo a quantidade de discos
        System.out.println("Com quantos discos você gostaria de jogar?");
        int quantDiscos=teclado.nextInt();
        double qD=quantDiscos;
        //rodadas totais
        int numJogadas=0;
        double rodadas=Math.pow(2, qD);
        int fim=0;

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
        //variaveis relacionadas ao menor disco
        int torreMenorDisco=torreInicial;
        int proxTorreMenorD=torreInicial+1;
        boolean menorMoveu=false;

        int maior=0;
        int segMenor=0;

        teclado.nextLine();
        boolean acabouJogo=true;
        while (acabouJogo) {
            for(int i=1;i<=quantDiscos;i++){
                System.out.printf(lista[1].elemento((quantDiscos-i))+"||"+lista[2].elemento((quantDiscos-i))+"||"+lista[3].elemento((quantDiscos-i))+"\n");
            }
            System.out.println("Rodada "+numJogadas+"\nAperte ENTER para continuar");
            teclado.nextLine();
            if(menorMoveu){
                
                menorMoveu=false;
            }
            else{
                lista[proxTorreMenorD].push(lista[torreMenorDisco].top());
                lista[torreMenorDisco].pop();
                torreMenorDisco++;
                proxTorreMenorD++;
                if(torreMenorDisco>3){
                    torreMenorDisco=1;
                }
                if(proxTorreMenorD>3){
                    proxTorreMenorD=1;
                }
                menorMoveu=true;
            }
            numJogadas++;
            switch (torreInicial) {

                case 1:
                    if(torre1.isEmpty()&&((torre2.size()==quantDiscos)||(torre3.size()==quantDiscos))){
                        acabouJogo=true;
                    }
                    break;
                case 2:
                    if(torre2.isEmpty()&&((torre1.size()==quantDiscos)||(torre3.size()==quantDiscos))){
                        acabouJogo=true;
                    }
                    break;
                case 3:
                    if(torre3.isEmpty()&&((torre2.size()==quantDiscos)||(torre1.size()==quantDiscos))){
                        acabouJogo=true;
                    }
                default:
                    break;
            }
        }
        for(int i=1;i<=quantDiscos;i++){
            System.out.printf(lista[1].elemento((quantDiscos-i))+"||"+lista[2].elemento((quantDiscos-i))+"||"+lista[3].elemento((quantDiscos-i))+"\n");
        }
    }
    public static int segundoMenor(MinhaPilha torreX, MinhaPilha torreY){
        int menor=torreX.top();
        if((torreX.isEmpty()==false)&&(torreY.isEmpty()==false)){
            if(torreY.top()<menor){
                return torreY.top();
            }
        }
        else{
            if(torreX.isEmpty()&&torreY.isEmpty()){
                return 4;
            }
            else{}
            if(torreY.isEmpty()&&(torreX.isEmpty()==false)){
                    return torreX.top();
            }
            else{
                menor=4;
            }
            if(torreX.isEmpty()&&(torreY.isEmpty()==false)){
                return torreY.top();
            }
            }
        return menor;
    }
    public static int retornaMaior(MinhaPilha torreX, MinhaPilha torreY){
        int maior=torreX.top();
        if((torreX.isEmpty()==false)&&(torreY.isEmpty()==false)){
            if(torreY.top()>maior){
                maior=torreY.top();
            }
        }else{
            if(torreX.isEmpty()&&torreY.isEmpty()){
                maior=4;
            }
            else{
                if(torreY.isEmpty()){
                    maior=torreX.top();
                }
                else{
                    maior=torreY.top();
                }
            }
        }
        return maior;
    }
}