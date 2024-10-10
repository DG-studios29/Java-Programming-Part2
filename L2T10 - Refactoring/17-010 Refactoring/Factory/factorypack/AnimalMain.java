package factorypack;

public class AnimalMain {
	public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();

        Animal kangaroo = animalFactory.createAnimal("Kangaroo");
        kangaroo.create();

        Animal cheetah = animalFactory.createAnimal("Cheetah");
        cheetah.create();

        Animal lion = animalFactory.createAnimal("Lion");
        lion.create();
    }
}
