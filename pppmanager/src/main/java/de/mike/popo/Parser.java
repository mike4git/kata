package de.mike.popo;


import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import de.mike.popo.factory.XMLSlideShowFactory;

public class Parser {
	
	private static final Logger LOG = Logger.getLogger(Parser.class);

	public PoPoData parse(String filename) {
		PoPoData data = new PoPoData();
		data.setFilename(filename);
		XMLSlideShow ppt = null;
		try {
			ppt = XMLSlideShowFactory.getInstance().create(filename);
		} catch (IOException e) {
			LOG.error("Fehler beim Einlesen der PPP-Datei.", e);
			return data;
		}

		data.setFilename(filename);
		data.setName(ppt.getProperties().getCoreProperties().getTitle());
		data.setAuthor(ppt.getProperties().getCoreProperties().getCreator());
		
		Date created = ppt.getProperties().getCoreProperties().getCreated();
		data.setCreationTime(created);
		
		data.setNumberOfSlides(ppt.getSlides().length);
		return data;
	}

}
