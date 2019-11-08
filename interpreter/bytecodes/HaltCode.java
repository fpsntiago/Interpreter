package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of HaltCode
 * 
 * @author Francis
 *
 */
public class HaltCode implements ByteCode {
	@Override
	public void init(List<String> args) {

	}

	@Override
	public void execute(VirtualMachine vm) {
		vm.stop();
	}

	@Override
	public String toString() {
		return "HALTCODE ";
	}
}
