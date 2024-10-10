package decoratorpack;

// Create a ScrollingFrameDecorator class extending FrameDecorator
public class ScrollingFrameDecorator extends FrameDecorator {
	private int numScrollBars;

	public ScrollingFrameDecorator(Frame decoratedFrame, int numScrollBars) {
		super(decoratedFrame);
		this.numScrollBars = numScrollBars;
	}

	@Override
	public void render() {
		super.render();
		System.out.println(String.format("Imagine adding %d scroll bars to the frame!", numScrollBars));
	}

	public void addScrollBar() {
		numScrollBars++;
	}
}
