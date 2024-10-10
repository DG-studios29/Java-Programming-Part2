package decoratorpack;

public class ScalingFrameDecorator extends FrameDecorator {
	private double scaleFactor;

	public ScalingFrameDecorator(Frame decoratedFrame, double scaleFactor) {
		super(decoratedFrame);
		this.scaleFactor = scaleFactor;
	}

	@Override
	public void render() {
		super.render();
		System.out.println(String.format("Imagine making the frame %.1f times bigger!", scaleFactor));
	}

	public void scale(double factor) {
		scaleFactor = factor;
	}
}