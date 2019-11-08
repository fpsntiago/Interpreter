package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of LoadCode
 * 
 * @author Francis
 *
 */

public class LitCode implements ByteCode {
	private int arg;
	private String var;

	@Override
	public void init(List<String> args) {
<<<<<<< HEAD
		arg = Integer.parseInt(args.get(0));
=======
		arg = Integer.valueOf(args.get(0));
>>>>>>> new
		if (!args.isEmpty())
			var = args.get(1);

	}

	@Override
	public void execute(VirtualMachine vm) {
		vm.lit(arg);
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		String str = "LIT " + arg + " ";
		if (var != null)
			str += "int " + var;
		return str;
=======
		StringBuilder builder = new StringBuilder("LIT " + arg + " ");
		if (var != null)
			builder.append("int " + var);
		return builder.toString();
>>>>>>> new
	}
}
