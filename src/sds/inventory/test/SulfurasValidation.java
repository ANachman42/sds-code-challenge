package sds.inventory.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sds.inventory.QualityUpdater;

public class SulfurasValidation {

	private QualityUpdater qU;
	
	@Before
	public void setup() {
		qU = new QualityUpdater();
	}
	
	@After
	public void teardown() {
		qU = null;
	}
	
	@Test
	public void testOneCycle() {
		qU.updateQuality();
		Assert.assertEquals("Test Sell-In 1", 0, qU.items.get(3).sellIn);
		Assert.assertEquals("Test Quality 1", 80, qU.items.get(3).quality);
	}
	
	@Test
	public void testOneHundredCycles() {
		for(int i = 0; i < 100; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 100", 0, qU.items.get(3).sellIn);
		Assert.assertEquals("Test Quality 100", 80, qU.items.get(3).quality);
	}

}
