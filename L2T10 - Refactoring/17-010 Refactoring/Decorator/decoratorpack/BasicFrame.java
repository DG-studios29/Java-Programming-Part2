package decoratorpack;

public class BasicFrame implements Frame{
	@Override
    public void render() {
        System.out.println("If this were a real GUI, it'd display the frame");
    }
}
