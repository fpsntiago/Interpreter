package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of ReturnCode
 * 
 * @author Francis
 *
 */
public class ReturnCode implements ByteCode {
	private String id;
	private int prevPC;

	@Override
	public void init(List<String> args) {
<<<<<<< HEAD
		if (args.size() != 0)
=======
		if (!args.isEmpty())
>>>>>>> new
			id = args.get(0);

	}

	@Override
	public void execute(VirtualMachine vm) {
		vm.reset();
		prevPC = vm.getPrevPC();
		vm.changePC(prevPC);
<<<<<<< HEAD

=======
>>>>>>> new
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		String str = "RETURN " + id + " exit: " + prevPC;
		return str;
=======
		StringBuilder builder = new StringBuilder("RETURN ");
		builder.append(id);
		builder.append(" exit");
		builder.append(prevPC);
		return builder.toString();
>>>>>>> new

	}
}
