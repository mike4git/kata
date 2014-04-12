package de.mike.popo;

import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

public class DirectoryScan {

	private Parser parser;
	private Set<PoPoData> presentations;
	
	public DirectoryScan(String directoryToScan) {
		parser = new Parser();
		
		presentations = new TreeSet<PoPoData>(new Comparator<PoPoData>() {
			public int compare(PoPoData p1, PoPoData p2) {
				return p1.getFilename().compareTo(p2.getFilename());
			}
		});
		
		Iterator<File> fileIterator = FileUtils.iterateFiles(new File(directoryToScan), new String[]{"pptx"}, true);
		while(fileIterator.hasNext()) {
			File currentPPTFile = (File) fileIterator.next();
			if (!currentPPTFile.getName().startsWith("~$")) {
				presentations
						.add(parser.parse(currentPPTFile.getAbsolutePath()));
			}
		}
	}

	public Set<PoPoData> findAllPoPos() {
		return presentations;
	}

	
}
