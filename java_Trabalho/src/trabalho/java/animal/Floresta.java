package trabalho.java.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floresta {
     private List<Animal> animais;
	 private List<Planta> plantas;
	 
	 private List<Animal> coelhos; 

	    public Floresta() {
	        this.animais = new ArrayList<>();
	        this.plantas = new ArrayList<>();
	        this.coelhos = new ArrayList<>();
	    }

	    public void adicionarAnimal(Animal animal) {
	        this.animais.add(animal);
	        if (animal.geteEspecies().equals("Coelhos")) {
	            this.coelhos.add(animal);
	        }
	 }
	    
	    public void removerAnimalMorto(Animal animal) {
	        animais.remove(animal);
	        if (animal.geteEspecies().equals("Coelhos")) {
	            coelhos.remove(animal);
	        }
	    }

	    public void iniciarSimulacao(int numPlantas) {
	        List<Planta> plantas = Planta.cPlantas(numPlantas);

	        for (Planta planta : plantas) {
	            adicionarPlanta(planta);
	        }
	    }
	    
	    public void adicionarPlanta(Planta planta) {
	        this.plantas.add(planta);
	    }

	    public List<Animal> getAnimais() {
	        return this.animais;
	    }

	    public List<Planta> getPlantas() {
	        return this.plantas;
	    }
	    
	    public List<Animal> getCoelhos() {
	        return this.coelhos;
	    }

	    public void simularInteracoes() {
	        Random random = new Random();

	        List<Animal> animaisRemover = new ArrayList<>();

	        for (Animal animal : animais) {
	            if (animal.geteEspecies().equals("Lobo")) {
	                int randomIndex = random.nextInt(animais.size());
	                Animal outraPresa = animais.get(randomIndex);
	                if (outraPresa.geteEspecies().equals("Coelho")) {
	                    animal.atacar(outraPresa);
	                }
	            } else if (animal.geteEspecies().equals("Coelho")) {
	                int shouldEat = random.nextInt(2);
	                if (shouldEat == 1) {
	                    animal.comerPlantaAleatoria(plantas);
	                } else {
	                    String identificador = animal.geteEspecies() + animal.getCount();
	                    System.out.println("" + identificador + " não encontrou planta para comer.");
	                }
	                if (animal.getVida() <= 0) {
	                    animaisRemover.add(animal);
	                }
	            }
	        }

	        for (Animal animal : animaisRemover) {
	            removerAnimalMorto(animal);
	        }
	    }
	    
	    public void listarAnimais() {
	        System.out.println("-------------------------------------------");
	        for (Animal animal : animais) {
	        	String identificador = animal.geteEspecies() + animal.getCount();
	            System.out.println(" Animal = " + identificador + ", Vida = " + animal.getVida() + addSpaces(animal.geteEspecies(), animal.getVida()) + "|");
	        }
	        System.out.println("---------------------------------------------");
	    }
	    
	    public String addSpaces(String especies, int vida) {
	        int totalSpaces = 43 - 16 - especies.length() - String.valueOf(vida).length();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < totalSpaces; i++) {
	            sb.append(" ");
	        }
	        return sb.toString();
	    }
	}