package com.first.junit.selenium.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTester {
	
	@Rule
	public TemporaryFolder temp = new TemporaryFolder();
	
	@Test
	public void testUsingTempFolder() throws IOException {
		File createdFolder = temp.newFolder("newfolder");
		File createdFile = temp.newFile("newfile.txt");
		assertTrue(createdFile.exists());
	}
	
}
