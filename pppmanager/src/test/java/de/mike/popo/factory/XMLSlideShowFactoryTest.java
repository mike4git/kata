package de.mike.popo.factory;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.mike.popo.factory.XMLSlideShowFactory;



public class XMLSlideShowFactoryTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testExceptionByNonExistingFile() throws Exception {
		exception.expect(IOException.class);
		XMLSlideShowFactory.getInstance().create("doesNotExist.ppt");
	}
}
