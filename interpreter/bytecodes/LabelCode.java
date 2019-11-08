package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of LabelCode
 * 
 * @author Francis
 *
 */
public class LabelCode implements ByteCode {
	private String argument;

	@Override
	public void init(List<String> args) {
<<<<<<< HEAD
		argument = args.get(0);
=======
		if (null != args && !args.isEmpty())
			argument = args.get(0);
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

	public void execute(VirtualMachine vm) {
	}

	@Override
	public String toString() {
		return "LABEL ";
	}

}
