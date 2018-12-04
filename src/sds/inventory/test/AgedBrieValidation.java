package sds.inventory.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sds.inventory.QualityUpdater;

public class AgedBrieValidation {

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
		Assert.assertEquals("Test Sell-In 1", 1, qU.items.get(1).sellIn);
		Assert.assertEquals("Test Quality 1", 1, qU.items.get(1).quality);
	}
	
	@Test
	public void testFiveCycles() {
		for(int i = 0; i < 5; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 5", -3, qU.items.get(1).sellIn);
		Assert.assertEquals("Test Quality 5", 8, qU.items.get(1).quality);
	}
	
	@Test
	public void testTwentyCycles() {
		for(int i = 0; i < 20; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 20", -18, qU.items.get(1).sellIn);
		Assert.assertEquals("Test Quality 20", 38, qU.items.get(1).quality);
	}
	
	@Test
	public void testFiftyCycles() {
		for(int i = 0; i < 50; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 50", -48, qU.items.get(1).sellIn);
		Assert.assertEquals("Test Quality 50", 50, qU.items.get(1).quality);
	}

}
