package interpreter;

import java.io.IOException;

/**
 * This is the main program of the application
 * 
 * @author Francis
 *
 */
public class Interpreter {
	private ByteCodeLoader bcl;

	public Interpreter(String codeFile) {
		try {
			CodeTable.init();
			bcl = new ByteCodeLoader(codeFile);
		} catch (IOException e) {
			System.out.println("**** " + e);
		}
	}

	void run() {
		Program program = bcl.loadCodes();
		VirtualMachine vm = new VirtualMachine(program);
		vm.executeProgram();
	}

	public static void main(String args[]) {

		if (args.length == 0) {
			System.out.println("***Incorrect usage, try: java interpreter.Interpreter <file>");
			System.exit(1);
		}
		(new Interpreter(args[0])).run();
	}
}