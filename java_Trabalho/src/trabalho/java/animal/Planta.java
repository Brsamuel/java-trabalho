package trabalho.java.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Planta {
    private String nome;
    private int saude;

        public Planta(String nome, int saude) {
            this.nome = nome;
            this.saude = saude;
        }

        public String getName() {
            return this.nome;
        }

        public int getSaude() {
            return saude;
        }

        public static List<Planta> cPlantas(int numPlantas) {
            List<Planta> plantas = new ArrayList<>();
            String[] nomesDePlantas = {"Alecrim", "Coentro", "Capim", "Erva-doce", "Manjericão", "Samambaia", "Salsa", "Sálvia", "Tomilho", "Endro", "grama", "Arbusto", "galhos"};
            Random random = new Random();

            for (int i = 0; i < numPlantas; i++) {
                int saude = random.nextInt(31) + 10;
                int randomIndex = random.nextInt(nomesDePlantas.length);
                String nomePlanta = nomesDePlantas[randomIndex];
                plantas.add(new Planta(nomePlanta, saude));
            }

            return plantas;
        }
}

