package sds.inventory.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sds.inventory.QualityUpdater;

public class ConjuredValidation {

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
		Assert.assertEquals("Test Sell-In 1", 2, qU.items.get(5).sellIn);
		Assert.assertEquals("Test Quality 1", 4, qU.items.get(5).quality);
	}
	
	@Test
	public void testThreeCycles() {
		for(int i = 0; i < 3; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 3", 0, qU.items.get(5).sellIn);
		Assert.assertEquals("Test Quality 3", 0, qU.items.get(5).quality);
	}

}
