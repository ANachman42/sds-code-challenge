package sds.inventory.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sds.inventory.QualityUpdater;

public class BackstagePassesValidation {

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
		Assert.assertEquals("Test Sell-In 1", 14, qU.items.get(4).sellIn);
		Assert.assertEquals("Test Quality 1", 21, qU.items.get(4).quality);
	}
	
	@Test
	public void testSevenCycles() {
		for(int i = 0; i < 7; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 7", 8, qU.items.get(4).sellIn);
		Assert.assertEquals("Test Quality 7", 30, qU.items.get(4).quality);
	}
	
	@Test
	public void testTwelveCycles() {
		for(int i = 0; i < 12; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 12", 3, qU.items.get(4).sellIn);
		Assert.assertEquals("Test Quality 12", 43, qU.items.get(4).quality);
	}
	
	@Test
	public void testSixteenCycles() {
		for(int i = 0; i < 16; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 16", -1, qU.items.get(4).sellIn);
		Assert.assertEquals("Test Quality 16", 0, qU.items.get(4).quality);
	}

}
