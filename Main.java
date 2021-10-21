/*package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Introduza um valor para o tamanho da tabela: ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int []tabela = new int[N];

        for(int i=0;i<N;i++){
            System.out.println("Introduza um valor para tabela: ");
            tabela[i] = scanner.nextInt();
        }

        //verifica valores repetidos
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                if(tabela[i]==tabela[k] && i!=k){
                    System.out.println("A sua tabela tem valores repetidos, o programa vai encerrar.");
                    System.exit(1);
                }
            }
        }

        boolean flag = false;
        //verifica se a tabela está ordenada
        for(int i=0;i<N;i++) {
            for(int k=0;k<N;k++) {
                if(i>k){
                    break;
                }
                if (tabela[i] > tabela[k]) {
                    flag = true;
                }
            }
        }

        int pos = 0;
        if(flag){
            //tabela desordenada
            for(int i=N-1;i>=0;i--) {
              if(i!=0 && tabela[i]<tabela[i-1]){
                  pos = i;
                  break;
              }
            }

            //copiar sub-tabela
            int []subtabela = new int[pos+1];
            for(int i=0;i<pos+1;i++) {
                subtabela[i]  = tabela[i];
            }

            System.out.println("Sub-tabela: ");
            for(int i=0;i<pos+1;i++) {
                System.out.println(subtabela[i] + " " );
            }
            System.exit(1);
        }else{
            System.out.println("A sua tabela está ordenada.");
            System.exit(1);
        }

    }
}
*/

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Introduza um valor para o tamanho da tabela: ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N <= 2){
            System.out.println("O tamanho mínimo permitido de N é 2");
            System.exit(0);
        }
        int []tabela = new int[N];
        System.out.println("\nIntroduza um valor para a tabela: ");
        for(int i=0;i<N;i++){
            tabela[i] = scanner.nextInt();
        }

        //verifica valores repetidos - atraves de um ciclo duplo
        //onde se numa posição diferente o num na pos i for igual ao num da pos k
        // entao o programa encerra
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                if(tabela[i]==tabela[k] && i!=k){
                    System.out.println("A sua tabela tem valores repetidos, o programa vai encerrar.");
                    System.exit(0);
                }
            }
        }

        boolean flag = false;
        //verifica se a tabela está ORDENADA
        //copiamos a tab OG para a auxiliar
        int [] aux_tab = Arrays.copyOf(tabela, N);
        //vamos atraves da array.sort meter os numeros por ordem
        Arrays.sort(aux_tab);
        //se um n da tabela OG for igual à aux entao ADD 1 ao contador
        //com o objectivo de ??????
        int count  = 0;
        for(int i=0; i<N ;i++) {
            if(tabela[i] == aux_tab[i]){
                count++;
            }
        }
        //se o contador for diferente de N ent a flag fica TRUE o que significa que esta desordenada
        if (count != N){
            flag = true;
        }

        int pos = 0;
        int posini = 0;
        System.out.println("");

        //flag é true
        if(flag){
            //tabela DESORDENADA, vamos percorrer do fim para o inicio
            //se i for dif de 0 e se i for menor do que i-1 entao a posiçao é igual a i
            //que é a posição q ocorre desodenação
            for(int i=N-1;i>=0;i--) {
                if(i!=0 && tabela[i]<tabela[i-1]){
                    pos = i;
                    break;
                }
            }
            //System.out.println(pos); posiçao de erro de desordenação

            //obter a posição INICIAL, para saber onde começa a desordenaçao abaixo****
            //tbm percorremos do fim para o inicio
            for(int j = N-1; j>=0; j--){
                if(tabela[j] != aux_tab[j]){
                    posini = j;
                }
            }
            //copiar sub-tabela
            int count1 = 0;
            int []subtabela = new int[pos-posini+1];
            for(int i=0;i<pos+1;i++) {
                //System.out.println(i);
                //****sabemos a pos inicial, enato agr damos print so da parte desordenada
                if(i>=posini && i<=pos+1){
                    //System.out.println(tabela[i]);
                    subtabela[count1] = tabela[i];
                    count1++;
                }

            }

            System.out.println("Sub-tabela: ");
            System.out.println(Arrays.toString(subtabela));
            System.exit(0);
        }else{
            System.out.println("A sua tabela está ordenada.");
            System.exit(0);
        }

    }

}
