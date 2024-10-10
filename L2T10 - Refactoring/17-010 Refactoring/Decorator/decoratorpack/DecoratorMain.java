package decoratorpack;

public class DecoratorMain {
	public static void main(String[] args) {
		System.out.println("The basic frame");
		Frame basicFrame = new BasicFrame();
		basicFrame.render();
		System.out.println("");

		Frame scrollFrame = new ScrollingFrameDecorator(basicFrame, 2);
		scrollFrame.render();
		System.out.println("");

		Frame scaleFrame = new ScalingFrameDecorator(scrollFrame, 7.0);
		scaleFrame.render();

	}
}
