package interpreter.codes;

import java.util.List;
import java.util.Scanner;

import interpreter.VirtualMachine;

/**
 * Implementation of ReadCode
 * 
 * @author Francis
 *
 */
public class ReadCode implements ByteCode {
	@Override
	public void init(List<String> args) {

	}

	@Override
	public void execute(VirtualMachine vm) {
		Scanner scanner = new Scanner(System.in);
<<<<<<< HEAD
		System.out.println("Enter an integer: ");
		int val = scanner.nextInt();
		vm.push(val);
=======
		boolean isVaid = false;
		System.out.println("Enter an integer: ");
		while (!isVaid) {
			try {
				int val = Integer.valueOf(scanner.next());
				vm.push(val);
				isVaid = true;
			} catch (NumberFormatException e) {
			}
			if (!isVaid)
				System.out.println("Invalid number");
		}
>>>>>>> new
		scanner.close();
	}

	@Override
	public String toString() {
		return "READ";
	}
}
