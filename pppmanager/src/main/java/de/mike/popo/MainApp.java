package de.mike.popo;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.log4j.Logger;

public class MainApp {

	private static final Logger LOG = Logger.getLogger(MainApp.class);
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Options options = new Options();
		options.addOption("dir", true, "which directory should be parsed by MainApp");
		
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = parser.parse( options, args);
		
		String directoryToScan = cmd.getOptionValue("dir");
		DirectoryScan scanner = new DirectoryScan(directoryToScan);
		
		for (PoPoData popo : scanner.findAllPoPos()) {
			LOG.info(popo);
		}
	}

}
