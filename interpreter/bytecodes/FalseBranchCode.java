package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of FalseBranchCode
 * 
 * @author Francis
 *
 */
public class FalseBranchCode implements ByteCode {
	private String argument;

	@Override
	public void init(List<String> args) {
<<<<<<< HEAD
		argument = args.get(0);
=======
		if (null != args && !args.isEmpty()) {
			try {
				Integer.valueOf(args.get(0));
				argument = args.get(0);
			} catch (Exception e) {
			}
		}
>>>>>>> new
	}

	/**
	 * @return the argument
	 */
	public String getArgument() {
		return argument;
	}

	/**
	 * @param argument the argument to set
	 */
	public void setArgument(String argument) {
		this.argument = argument;
	}

	@Override
	public void execute(VirtualMachine vm) {
		int top = vm.pop();
		if (top == 0) {
<<<<<<< HEAD
			vm.changePC(Integer.parseInt(argument));
=======
			vm.changePC(Integer.valueOf(argument));
>>>>>>> new
		}
	}

	@Override
	public String toString() {
		return "FALSEBRANCH " + argument;
	}
}
