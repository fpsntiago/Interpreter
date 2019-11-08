package interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implementation of runtime stack
 * 
 * @author Francis
 *
 */
public class RunTimeStack {
	private List<Integer> runTimeStack;
	private Stack<Integer> framePointer;

	/**
	 * Default constructor
	 */
	public RunTimeStack() {
		runTimeStack = new ArrayList<>();
		framePointer = new Stack<>();
		// Add initial Frame Pointer, main is the entry
		// point of our language, so its frame pointer is 0.
		framePointer.add(0);
	}

	/**
	 * Get the peek
	 * 
	 * @return
	 */
	public int peek() {
		return runTimeStack.get(runTimeStack.size() - 1);
	}

	/**
	 * Create new frame
	 * 
	 * @param frame
	 */
	public void createNewFrameAt(int frame) {
		int newFrame = runTimeStack.size() - frame;
		framePointer.push(newFrame);
	}

	/**
	 * Get stack size
	 * 
	 * @return
	 */
	public int size() {
		return runTimeStack.size();
	}

	/**
	 * Pop the value
	 * 
	 * @return
	 */
	public int pop() {
		return runTimeStack.remove(runTimeStack.size() - 1);
	}

	/**
	 * Push the value
	 * 
	 * @param val
	 */
	public void push(int val) {
		runTimeStack.add(val);
	}

	/**
	 * Store data
	 * 
	 * @param num
	 * @return
	 */
	public int store(int num) {
		int val = runTimeStack.remove(runTimeStack.size() - 1);
		runTimeStack.set(num + framePointer.peek(), val);
		return val;
	}

	/**
	 * Load data at give number
	 * 
	 * @param num
	 * @return
	 */
	public int load(int num) {
		int data = runTimeStack.get(num + framePointer.peek());
		runTimeStack.add(data);
		return data;
	}

	/**
	 * Reset stack
	 */
	public void reset() {
		int data = runTimeStack.remove(runTimeStack.size() - 1);
		while (runTimeStack.size() > framePointer.peek()) {
			runTimeStack.remove(runTimeStack.size() - 1);
		}
		framePointer.pop();
		runTimeStack.add(data);
	}

	/**
	 * Dump the runtime stack
	 */
	public void dump() {
		if (runTimeStack.isEmpty())
			return;

		List<Integer> frames = new ArrayList<>();
		getFrames(frames);
		StringBuilder builder = new StringBuilder("[");
		int index = 0;
		boolean comma = true;
		int j = 0;
		for (Integer i : frames) {
			if (!frames.isEmpty() && index < frames.size()) {
				if (frames.get(index) == j) {
					builder.append("] [");
				}
				if (frames.get(index) == j + 1) {
					comma = false;
				}
			}
			builder.append(i);
			if ((runTimeStack.size() != 1) && ((runTimeStack.size() - 1) != j) && comma) {
				builder.append(",");
			}

			if (!comma) {
				comma = true;
			}
			j++;
		}
		builder.append("]");
		System.out.println(builder.toString());

	}

	/**
	 * Get frames
	 * 
	 * @param frames
	 */
	private void getFrames(List<Integer> frames) {
		for (Integer frame : framePointer) {
			if (null != frame && frame.intValue() > 0) {
				frames.add(frame);
			}
		}
	}

}
