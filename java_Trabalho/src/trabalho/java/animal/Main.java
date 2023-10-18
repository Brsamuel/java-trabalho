package trabalho.java.animal;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║           Simulador de Ecossistema!          ║");
        System.out.println("║                                              ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        System.out.println("╔════════════════════════╗");
        System.out.print(  "║ Digite o número de     ║\n");
        System.out.print(  "║ plantas na floresta:");
        int numeroPlantas = scanner.nextInt();
        System.out.println("╚════════════════════════╝");

        System.out.println("╔════════════════════════╗");
        System.out.print("║ Digite o número de     ║\n");
        System.out.print("║ Lobos na floresta: ");
        int numeroLobos = scanner.nextInt();
        System.out.println("╚════════════════════════╝");

        System.out.println("╔════════════════════════╗");
        System.out.print("║ Digite o número de     ║\n");
        System.out.print("║ coelhos na floresta: ");
        int numeroCoelhos = scanner.nextInt();
        System.out.println("╚════════════════════════╝");

        Floresta floresta = new Floresta();

        String[] nomesReaisPlantas =  {"Alecrim", "Coentro", "Capim", "Erva-doce", "Manjericão", "Samambaia", "Salsa", "Sálvia", "Tomilho", "Endro", "grama", "Arbusto", "galhos"};

        for (int i = 0; i < numeroPlantas; i++) {
            int nutricao = 10;
            int randomIndex = (int) (Math.random() * nomesReaisPlantas.length);
            String nomePlanta = nomesReaisPlantas[randomIndex];
            floresta.adicionarPlanta(new Planta(nomePlanta, nutricao));
        }

        for (int i = 0; i < numeroLobos; i++) {
            Animal lobo = new Animal("Lobo", 5, 100);
            floresta.adicionarAnimal(lobo);
        }

        for (int i = 0; i < numeroCoelhos; i++) {
            Animal coelho = new Animal("Coelho", 3, 50);
            floresta.adicionarAnimal(coelho);
        }

        System.out.println("Simulação de Ecossistema iniciada...\n");

        int iteracao = 0;

        while (true) {
            iteracao++;
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║           ITERAÇÃO " + iteracao + "		       ║");
            System.out.println("╚══════════════════════════════════════╝");

            floresta.simularInteracoes();

            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║   ESTADO DOS ANIMAIS NA FLORESTA:    ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.println("\n");
            floresta.listarAnimais();
            System.out.println("\n");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            	
            }

            boolean todosCoelhosMortos = true;
            for (Animal animal : floresta.getAnimais()) {
                if (animal.geteEspecies().equals("Coelhos") && animal.estaVivo()) {
                    todosCoelhosMortos = false;
                    break;
                }
            }

            if (todosCoelhosMortos) {
                System.out.println("╔══════════════════════════════════════╗");
                System.out.println("║      TODAS OS COELHOS MORRERAM.      ║");
                System.out.println("║       SIMULAÇÃO ENCERRADA            ║");
                System.out.println("╚══════════════════════════════════════╝");
                break;
            }
        }

        scanner.close();
    }
}