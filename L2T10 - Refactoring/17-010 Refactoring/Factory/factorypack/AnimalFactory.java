package factorypack;

public class AnimalFactory {
	public Animal createAnimal(String type) {
		if (type == null) {
			return null;
		}
		if (type.equalsIgnoreCase("Kangaroo")) {
			return new Kangaroo();
		} else if (type.equalsIgnoreCase("Cheetah")) {
			return new Cheetah();
		} else if (type.equalsIgnoreCase("Lion")) {
			return new Lion();
		}
		return null;
	}
}
