package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import interpreter.codes.ByteCode;

/**
 * 
 * This class is used to load the byte codes from the file
 * 
 * @author Francis
 *
 */
public class ByteCodeLoader {
	private BufferedReader br = null;

	/**
	 * Constructor to initialize the BufferedReader
	 * 
	 * @throws IOException
	 */
	public ByteCodeLoader(String fileName) throws IOException {
		init(fileName);
	}

	/**
	 * Initialize the BufferedReader
	 * 
	 * @param fileName - Name of the file which has byte code
	 * @throws IOException
	 */
	private void init(String fileName) throws IOException {
		FileReader fileReader = null;
		fileReader = new FileReader(fileName);
		br = new BufferedReader(fileReader);
	}

	/**
	 * This method is used to load the byte codes from a file
	 * 
	 * @return Program Instance
	 * 
	 */
	public Program loadCodes() {
		StringTokenizer tokenizer = null;
		Program program = null;
		String line = null;
		// Read a line by line
		try {
			while (null != (line = br.readLine())) {
				line = line.trim();
				if (!line.isEmpty()) {
					tokenizer = new StringTokenizer(line);
					String className = CodeTable.getClassName(tokenizer.nextToken());
					program = getProgram(tokenizer, className);
				}
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
		}
		return program;
	}

	/**
	 * Get Program Instance
	 * 
	 * @param tokenizer - String tokenizer
	 * @param className - Byte code implementation class
	 * @return Program Instance
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	private Program getProgram(StringTokenizer tokenizer, String className)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Program program = new Program();
		ByteCode byteCode = (ByteCode) Class.forName("interpreter.codes." + className).newInstance();
		List<String> arguments = new ArrayList<>();
		while (tokenizer.hasMoreElements())
			arguments.add(tokenizer.nextToken());
		byteCode.init(arguments);
		program.add(byteCode);
		program.resolveAddrs(program);
		return program;
	}
}
