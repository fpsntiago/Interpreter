package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of StoreCode
 * 
 * @author Francis
 *
 */
public class StoreCode implements ByteCode {
	private int num;
	private String var;
	private int printTop;

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
		vm.store(num);
		printTop = vm.peek();
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		String str = "STORE " + num + " " + var + "\t" + var + " = " + printTop;
		return str;
=======
		StringBuilder builder = new StringBuilder("STORE ");
		builder.append(num);
		builder.append(" ");
		builder.append(var);
		builder.append(" ");
		builder.append("\t");
		builder.append(var);
		builder.append("=");
		builder.append(printTop);
		return builder.toString();
>>>>>>> new
	}
}
