package de.mike.popo.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

public class XMLSlideShowFactory {

	private XMLSlideShowFactory() {
		// nothing to do; just for singleton.
	}

	public static XMLSlideShowFactory getInstance() {
		return new XMLSlideShowFactory();
	}

	public XMLSlideShow create(String filename) throws IOException {
		XMLSlideShow ppt = null;
		final File file = new File(filename);

		final FileInputStream is = new FileInputStream(file);
		ppt = new XMLSlideShow(is);

		return ppt;
	}

}
