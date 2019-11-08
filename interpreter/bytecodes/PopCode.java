package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of PopCode
 * 
 * @author Francis
 *
 */
public class PopCode implements ByteCode {
	private int n;

	@Override
	public void init(List<String> args) {
<<<<<<< HEAD
		n = Integer.parseInt(args.get(0));
=======

		if (null != args && !args.isEmpty()) {
			try {
				n = Integer.parseInt(args.get(0));
			} catch (Exception e) {
			}
		}

>>>>>>> new
	}

	@Override
	public void execute(VirtualMachine vm) {
		vm.popN(n);
	}

	@Override
	public String toString() {
		return "POP";
	}
}
