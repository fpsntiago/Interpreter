package interpreter.codes;

import java.util.List;

import interpreter.VirtualMachine;

/**
 * Implementation of ArgsCode
 * 
 * @author Francis
 *
 */
public class BopCode implements ByteCode {
	private String operator;

	@Override
	public void init(List<String> args) {

		operator = args.get(0);

		if (null != args && !args.isEmpty())
			operator = args.get(0);

	}

	@Override
	public void execute(VirtualMachine vm) {
		int secondArg = vm.pop();
		int firstArg = vm.pop();
		switch (operator) {
		case "+":
			vm.push(firstArg + secondArg);
			break;
		case "-":
			vm.push(firstArg - secondArg);
			break;
		case "*":
			vm.push(firstArg * secondArg);
			break;
		case "/":
			vm.push(firstArg / secondArg);
			break;
		case "==":
			if (firstArg == secondArg)
				vm.push(1);
			else
				vm.push(0);

			break;
		case "!=":
			if (firstArg != secondArg)
				vm.push(1);
			else
				vm.push(0);

			break;
		case "<=":

			if (firstArg <= secondArg)
				vm.push(1);
			else
				vm.push(0);

			break;
		case "<":

			if (firstArg < secondArg)
				vm.push(1);
			else
				vm.push(0);

			break;
		case ">=":

			if (firstArg >= secondArg)
				vm.push(1);
			else
				vm.push(0);

			break;
		case ">":

			if (firstArg > secondArg)
				vm.push(1);
			else
				vm.push(0);

			break;
		case "|":
			if (firstArg == 1 || secondArg == 1)
				vm.push(1);
			else
				vm.push(0);

			break;
		case "&":

			if (firstArg == 1 && secondArg == 1)
				vm.push(1);
			else
				vm.push(0);

			break;
		default:
			break;
		}

	}

	@Override
	public String toString() {
		return "BOP ";
	}
}
