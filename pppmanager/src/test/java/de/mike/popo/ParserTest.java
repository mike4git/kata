package de.mike.popo;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import de.mike.popo.PoPoData;
import de.mike.popo.Parser;

import static org.junit.Assert.assertThat;

public class ParserTest {

	private static final String TEST_RESOURCE_FOLDER = "D:\\kata\\pppmanager\\src\\test\\resources\\test\\";

	@Test
	public void testFillPoPoDataWithFileInfo() throws Exception {
		Parser parser = new Parser();
		String filename = TEST_RESOURCE_FOLDER + "test.pptx";
		PoPoData data = parser.parse(filename);
		
		assertPoPoData(data, "Titel zur Testpräsentation", "Michael Albrecht", 3, DateUtils.parseDate("05.04.2014 17:13:28", new String[]{"dd.MM.yyyy hh:mm:ss"}));
	}

	@Test
	public void testFillPoPoDataWithoutDate() throws Exception {
		Parser parser = new Parser();
		String filename = TEST_RESOURCE_FOLDER + "SomePropsAreNull.pptx";
		PoPoData data = parser.parse(filename);
		
		assertPoPoData(data, "Test Titel Folie", null, 3, DateUtils.parseDate("05.04.2014 17:13:28", new String[]{"dd.MM.yyyy hh:mm:ss"}));
	}

	@Test
	public void testFillPoPoDataWithNonExistingFile() {
		Parser parser = new Parser();
		String filename = "doesNotExist.pptx";
		PoPoData data = parser.parse(filename);
		
		assertPoPoData(data, null, null, 0, null);
	}

	private void assertPoPoData(PoPoData data, String title, String author, int numberOfSlides, Date creationDate) {
		assertThat(data.getName(), CoreMatchers.is(title));
		assertThat(data.getAuthor(), CoreMatchers.is(author));
		assertThat(data.getNumberOfSlides(), CoreMatchers.is(numberOfSlides));
		if (creationDate != null) {
			assertThat(data.getCreationTime().getTime(),
					CoreMatchers.is(creationDate.getTime() / 1000 * 1000));
		}
	}
}

