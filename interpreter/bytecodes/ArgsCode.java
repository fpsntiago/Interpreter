package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of ArgsCode
 * 
 * @author Francis
 *
 */
public class ArgsCode implements ByteCode {
	private int frame;

	@Override
	public void execute(VirtualMachine vm) {
		vm.createNewFrame(frame);
	}

	@Override
	public void init(List<String> args) {
		if (null != args && !args.isEmpty()) {
			try {
				frame = Integer.valueOf(args.get(0));
			} catch (Exception e) {
			}
		}

	}

	@Override
	public String toString() {
		return "Args " + frame;
	}
}
