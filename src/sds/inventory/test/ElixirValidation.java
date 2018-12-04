package sds.inventory.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sds.inventory.QualityUpdater;

public class ElixirValidation {

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
		Assert.assertEquals("Test Sell-In 1", 4, qU.items.get(2).sellIn);
		Assert.assertEquals("Test Quality 1", 6, qU.items.get(2).quality);
	}
	
	@Test
	public void testFiveCycles() {
		for(int i = 0; i < 5; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 5 times", 0, qU.items.get(2).sellIn);
		Assert.assertEquals("Test Quality 5 times", 2, qU.items.get(2).quality);
	}
	
	@Test
	public void testTenCycles() {
		for(int i = 0; i < 10; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test Sell-In 10 times", -5, qU.items.get(2).sellIn);
		Assert.assertEquals("Test Quality 10 times", 0, qU.items.get(2).quality);
	}
}
