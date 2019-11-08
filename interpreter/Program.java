package interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interpreter.codes.ByteCode;
import interpreter.codes.CallCode;
import interpreter.codes.FalseBranchCode;
import interpreter.codes.GotoCode;
import interpreter.codes.LabelCode;

/**
 * Implementation of Program
 * 
 * @author Francis
 *
 */
public class Program {
	private List<ByteCode> byteCodes;

	public Program() {
		byteCodes = new ArrayList<>();
	}

	protected ByteCode getCode(int pc) {
		return this.byteCodes.get(pc);
	}

	public int getSize() {
		return this.byteCodes.size();
	}

	public void add(ByteCode byteCode) {
		this.byteCodes.add(byteCode);
	}

	/**
	 * Resolve the address
	 * 
	 * @param program
	 */
	public void resolveAddrs(Program program) {
		Map<String, Integer> ads = new HashMap<>();
		loadLabelCode(program, ads);
		int i = 0;
		while (i < program.getSize()) {
			ByteCode adrs = program.getCode(i);
			if (adrs instanceof CallCode) {
				CallCode callCode = (CallCode) adrs;
				String args = callCode.getArgument();
				if (ads.containsKey(args))
					callCode.setArgument(String.valueOf((ads.get(args))));
			} else if (adrs instanceof GotoCode) {
				GotoCode gotoCode = (GotoCode) adrs;
				String argument = gotoCode.getArgument();
				if (ads.containsKey(argument))
					gotoCode.setArgument(String.valueOf(ads.get(argument)));
			} else if (adrs instanceof FalseBranchCode) {
				FalseBranchCode falseBranchCode = (FalseBranchCode) adrs;
				String argument = falseBranchCode.getArgument();
				if (ads.containsKey(argument))
					falseBranchCode.setArgument(String.valueOf(ads.get(argument)));
			}
			i++;
		}

	}

	/**
	 * Load label codes
	 * 
	 * @param program
	 * @param ads
	 * @return
	 */
	private int loadLabelCode(Program program, Map<String, Integer> ads) {
		int i = 1;
		while (i < program.getSize()) {
			ByteCode addrs = program.getCode(i);
			if (addrs instanceof LabelCode) {
				ads.put(((LabelCode) addrs).getArgument(), i);
			}
			i++;

		}
		return i;
	}

}
