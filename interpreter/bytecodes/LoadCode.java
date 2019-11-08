package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of LoadCode
 * 
 * @author Francis
 *
 */
public class LoadCode implements ByteCode {
	private int num;
	String var;

	@Override
	public void init(List<String> args) {
<<<<<<< HEAD
		num = Integer.parseInt(args.get(0));
		var = args.get(1);
=======
		if (null != args && !args.isEmpty() && args.size() >= 2) {
			try {
				num = Integer.parseInt(args.get(0));
				var = args.get(1);
			} catch (Exception e) {
			}
		}

>>>>>>> new
	}

	@Override
	public void execute(VirtualMachine vm) {
		vm.load(num);
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		String str = "LOAD" + num + " ";
		if (var != null)
			str += var + " " + "<load " + var + ">";
		return str;
=======
		StringBuilder builder = new StringBuilder("LOAD" + num + " ");
		if (var != null)
			builder.append(var + " " + "<load " + var + ">");
		return builder.toString();
>>>>>>> new
	}
}
