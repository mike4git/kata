package de.mike.popo;

import java.util.Set;

import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import de.mike.popo.DirectoryScan;
import de.mike.popo.PoPoData;

public class DirectoryScanTest {

	private static final Logger LOG = Logger.getLogger(DirectoryScanTest.class);
	
	@Test
	public void testExistingDirectory() {
		DirectoryScan scanner = new DirectoryScan("D:\\kata\\pppmanager\\src\\test\\resources\\test");
		Set<PoPoData> pptFiles = scanner.findAllPoPos();
		Assert.assertThat(pptFiles, Matchers.hasSize(2));
		for (PoPoData popo : pptFiles) {
			LOG.info(popo.toString());
		}
	}

}
