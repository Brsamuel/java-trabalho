package trabalho.java.animal;

import java.util.Random;
import java.util.List;

public class Animal {
    private String species;
    public int idade;
    private int vida;
    private int count;
    private String type;
    
    private static int coelhoCount = 0;
    private static int loboCount = 0;
    
    private static final Random random = new Random();

    public Animal(String species, int idade, int vida) {
        this.species = species;
        this.idade = idade;
        this.vida = vida;
        
        if (species.equals("Coelhos")) {
           coelhoCount++;
           count = coelhoCount;
        } else if (species.equals("Lobo")) {
            loboCount++;
            count = loboCount;
        }
        this.type = species + count;
    }
    
    public void comerPlantaAleatoria(List<Planta> plantas) {
        if (this.species.equals("Coelho")) {
            if (this.vida < 50) {
            	if (!plantas.isEmpty()) {
                    Random random = new Random();
                    int indexPlanta = random.nextInt(plantas.size());
                    Planta planta = plantas.get(indexPlanta);
                    System.out.println(this.type + " está comendo a planta " + planta.getName() + " e recuperou " + planta.getSaude() + " de vida.");
                    this.vida = Math.min(100, this.vida + planta.getSaude());
                    plantas.remove(indexPlanta);
                } else {
                    System.out.println("Não há plantas para a " + this.type + " comer.");
                }
            } else {
                System.out.println(this.type + " não está com fome. Sua vida está cheia.");
            }
            }
        }

    public void atacar(Animal outroAnimal) {
        if (this.species.equals("Lobo") && outroAnimal.species.equals("Coelho")) {
            System.out.println(this.type + " atacou " + outroAnimal.type);
            int randomDano = random.nextInt(11) + 5;
            outroAnimal.receberDano(randomDano);
        }
    }
    
    public void ataque() {
        if (this.species.equals("Lobo")) {
            System.out.println(this.type + " está atacando!");
        }
    }

    public String geteEspecies() {
        return species;
    }

    public int getVida() {
        return vida;
    }
    

    public void serComido(Animal animal) {
        if (this.species.equals("Coelho")) {
            System.out.println(this.type + " está sendo atacado por " + animal.type);
            this.vida -= 10;
            if (this.vida <= 0) {
                System.out.println(this.type + " morreu!");
            }
        } else {
            System.out.println(this.type + " está comendo " + animal.type);
        }
    }

    public void comerPlanta(Planta planta) {
        System.out.println(this.type + " está comendo a planta " + planta.getName());
        int randomRecuperacao = random.nextInt(16) + 5;
        this.vida = Math.min(100, this.vida + randomRecuperacao);
    }
    

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println(this.type + " morreu!");
        } else {
            if (this.species.equals("Coelho")) {
                System.out.println(this.type + " recebeu " + dano + " de dano.");
            }
        }
    }
    public boolean estaVivo() {
        return this.vida > 0;
    }
    
    public int getCount() {
        return count;
    }
}

