package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * 
 * Implementation of DumpCode
 * 
 * @author Francis
 *
 */
public class DumpCode implements ByteCode {
	private String arg;

	@Override
	public void init(List<String> args) {
		arg = args.get(0);
	}

	@Override
	public void execute(VirtualMachine vm) {
<<<<<<< HEAD
		if (arg.equals("ON"))
			vm.setDumping(true);
		if (arg.equals("OFF"))
			vm.setDumping(false);
=======
		switch (arg) {
		case "ON":
			vm.setDumping(true);
			break;
		case "OFF":
			vm.setDumping(false);
			break;
		default:
			break;
		}
>>>>>>> new
	}

	@Override
	public String toString() {
		return null;
	}

}
