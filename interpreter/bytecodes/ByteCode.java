package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Interface for ByteCode
 * 
 * @author Francis
 *
 */
public interface ByteCode {
	/**
	 * Initialize the arguments
	 * 
	 * @param arguments - Arguments list
	 */
	void init(List<String> arguments);

	/**
	 * Execute byte code in given vm
	 * 
	 * @param vm - Instance of virtual machine
	 */
	void execute(VirtualMachine vm);

	/**
	 * String representation of byte code
	 * 
	 * @return String representation of byte code
	 */
	String toString();
}
