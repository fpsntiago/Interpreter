package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of WriteCode
 * 
 * @author Francis
 *
 */
public class WriteCode implements ByteCode {
	@Override
	public void init(List<String> args) {

	}

	@Override
	public void execute(VirtualMachine vm) {
		int i = vm.peek();
		System.out.println(i);
	}

	@Override
	public String toString() {
		return "WRITE";
	}
}
