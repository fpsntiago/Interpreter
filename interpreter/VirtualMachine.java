package interpreter;

import java.util.Stack;

import interpreter.codes.ByteCode;

/**
 * Implementation of Virtual machine
 * 
 * @author Francis
 *
 */
public class VirtualMachine {
	private RunTimeStack runStack;
	private Stack<Integer> returnAddrs;
	private Program program;
	private int pc;
	private boolean isRunning;
	private boolean isDumping;

	public VirtualMachine(Program program) {
		this.program = program;
	}

	/**
	 * Execute the program
	 */
	public void executeProgram() {
		isRunning = true;
		pc = 0;
		runStack = new RunTimeStack();
		returnAddrs = new Stack<>();
		isRunning = true;
		while (isRunning) {
			ByteCode code = program.getCode(pc);
			code.execute(this);
			if (isDumping) {
				System.out.println(code);
				runStack.dump();
			}
			System.out.println("PC:" + pc);
			pc++;
			//reset().
		}
	}

	/**
	 * Set the dumping is true or not
	 * 
	 * @param isDumping
	 */
	public void setDumping(boolean isDumping) {
		this.isDumping = isDumping;
	}

	/**
	 * Create new frame
	 * 
	 * @param frame
	 */
	public void createNewFrame(int frame) {
		runStack.createNewFrameAt(frame);
	}

	/**
	 * Get peek from stack
	 * 
	 * @return
	 */
	public int peek() {
		return runStack.peek();
	}

	/**
	 * Store number
	 * 
	 * @param num
	 */
	public void store(int num) {
		runStack.store(num);
	}

	/**
	 * Reset stack
	 */
	public void reset() {
		runStack.reset();
	}

	/**
	 * Get previous codes
	 * 
	 * @return
	 */
	public int getPrevPC() {
		return returnAddrs.pop();
	}

	/**
	 * Change code
	 * 
	 * @param prevPC
	 */
	public void changePC(int prevPC) {
		pc = prevPC;
	}

	/**
	 * Push value
	 * 
	 * @param val
	 */
	public void push(int val) {
		runStack.push(val);
	}

	/**
	 * Pop n elements from stack
	 * 
	 * @param n
	 */
	public void popN(int n) {
		if (n < runStack.size()) {
			for (int i = 0; i < n; i++) {
				runStack.pop();
			}
		}

	}

	/**
	 * Load a number
	 * 
	 * @param num
	 */
	public void load(int num) {
		runStack.load(num);

	}

	/**
	 * Push to stack
	 * 
	 * @param n
	 */
	public void lit(int n) {
		runStack.push(n);
	}

	/**
	 * Stop the execution
	 */
	public void stop() {
		isRunning = false;
	}

	/**
	 * Pop
	 * 
	 * @return
	 */
	public int pop() {
		return returnAddrs.pop();
	}

	/**
	 * Save code
	 */
	public void savePC() {
		returnAddrs.push(pc);
	}

}
