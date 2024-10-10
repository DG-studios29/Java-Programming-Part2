package decoratorpack;

// Create an abstract FrameDecorator class implementing the Frame interface
public abstract class FrameDecorator implements Frame {
	private Frame decoratedFrame;

	public FrameDecorator(Frame decoratedFrame) {
		this.decoratedFrame = decoratedFrame;
	}

	@Override
	public void render() {
		decoratedFrame.render();
	}
}