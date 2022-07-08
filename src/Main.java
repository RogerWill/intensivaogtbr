import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner opt = new Scanner(System.in);
        int escolha;

        System.out.println("======MENU======");
        System.out.printf(" [1] Calculadora %n [2] IMC %n [3] Forca%n [4] Sair%n");
        System.out.print("Selecione a função desejada: ");

        escolha = opt.nextInt();
        switch (escolha) {
            case 1 -> calculadora();
            case 2 -> calculoImc();
            case 3 -> forca();
            case 4 -> System.exit(0);
        }
    }


    public static void calculadora(){
        int x, y, total;
        String operacao;

        Scanner sc = new Scanner(System.in);

        System.out.print("solta o numero pra calcular: ");
        x = sc.nextInt();

        System.out.print("solta o segundo: ");
        y = sc.nextInt();

        System.out.print("qual operação? ");
        operacao = sc.next();

        switch (operacao) {
            case "+" -> {
                total = x + y;
                System.out.println("segura essa soma ai: " + total);
            }
            case "-" -> {
                total = x - y;
                System.out.println("segura essa subtração ai: " + total);
            }
            case "*" -> {
                total = x * y;
                System.out.println("segura essa multiplicação ai: " + total);
            }
            case "/" -> {
                total = x / y;
                System.out.println("segura essa divisão ai: " + total);
            }
        }
    }

    public static void calculoImc() {
        float altura, peso;
        double imc;
        char sexo;
        Scanner sc = new Scanner(System.in);


        System.out.println("Calculadora de IMC");

        System.out.print("informe seu sexo: ");
        sexo = sc.next().charAt(0);

        System.out.print("informe sua altura: ");
        altura = sc.nextFloat();

        System.out.print("informe seu peso: ");
        peso = sc.nextFloat();

        imc = peso / Math.pow(altura, 2);

        System.out.printf("seu imc é: %.2f%n", imc);

        switch (sexo) {

            case 'm':
                if (imc < 20) {
                    System.out.println("você está abaixo do peso");
                } else if (imc >= 20.0 && imc <= 24.9) {
                    System.out.println("você está no peso ideal");
                } else if (imc >= 25.0 && imc <= 29.9) {
                    System.out.println("você está levemente acima do peso");
                } else if (imc >= 30.0 && imc <= 34.9) {
                    System.out.println("você está com Obesidade grau I");
                } else if (imc >= 35.0 && imc <= 39.9) {
                    System.out.println("você está com Obesidade grau II(severa)");
                } else if (imc >= 40) {
                    System.out.println("você está com Obesidade grau III (morbida)");
                }
                break;

            case 'f':
                if (imc < 20.0) {
                    System.out.println("você está abaixo do peso");
                } else if (imc >= 19 && imc <= 23.9) {
                    System.out.println("você está no peso ideal");
                } else if (imc >= 24.0 && imc <= 28.9) {
                    System.out.println("você está levemente acima do peso");
                } else if (imc >= 29.0 && imc <= 33.9) {
                    System.out.println("você está com Obesidade grau I");
                } else if (imc >= 34.0 && imc <= 38.9) {
                    System.out.println("você está com Obesidade grau II(severa)");
                } else if (imc >= 39) {
                    System.out.println("você está com Obesidade grau III (morbida)");
                }
                break;

        }
    }

    public static void forca() throws FileNotFoundException {

            StringBuilder letrasUsadas = new StringBuilder();
            StringBuilder palavraAdivinhada = new StringBuilder();
            int vida = 6;
            int round = 1;

            File arquivo = new File("C:\\Users\\Roger\\IdeaProjects\\Intensivao1\\palavra.txt");
            Scanner sc = new Scanner(arquivo);
            List<String> palavras = new ArrayList<>();
            while(sc.hasNextLine()){
                palavras.add(sc.nextLine());
            }

        Collections.shuffle(palavras);

           while(vida > 0){

                String palavraEscolhida = palavras.get(0);
               System.out.printf("Rodada %d.%n %s Qual a proxima letra?%n ", round, palavraAdivinhada);


               char letraDigitada = new Scanner(System.in).next().charAt(0);
               if(letrasUsadas.toString().indexOf(letraDigitada) >=0){
                   System.out.printf("Voce ja tentou a letra %c%n", letraDigitada);
               } else{
                   letrasUsadas.append(letraDigitada);

                   if(palavras.get(0).indexOf(letraDigitada) >=0){
                        palavraAdivinhada = new StringBuilder();

                        for(int i = 0; i < palavraEscolhida.length(); i++){
                            palavraAdivinhada.append(letrasUsadas.toString().indexOf(palavraEscolhida.charAt(i)) >= 0 ? palavraEscolhida.charAt(i) : "_");
                        }

                        if(palavraAdivinhada.toString().contains("_")){
                            System.out.printf("Boa! Mas ainda faltam letras%n");
                        } else {
                            System.out.printf("Olokinho meu! tu é bom. A palavra era %s", palavraAdivinhada);
                            System.exit(0);
                        }

                   } else {
                       System.out.printf("Que pena, a palavra não contem a letra %c%n", letraDigitada);
                       vida--;
                   }
                   System.out.printf("Vida Restante: %d%n", vida);

               }

               if(vida == 0){
                   System.out.println("Voce Perdeu, a palavra era: " + palavraEscolhida);
               }
               round++;
           }



        }

}

