package sds.inventory.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sds.inventory.QualityUpdater;

public class DexterityVestValidation {

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
		Assert.assertEquals("Test 1", 9, qU.items.get(0).sellIn);
		Assert.assertEquals("Test 1", 19, qU.items.get(0).quality);
	}
	
	@Test
	public void testFiveCycles() {
		for(int i = 0; i < 5; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test 5 times", 5, qU.items.get(0).sellIn);
		Assert.assertEquals("Test 5 times", 15, qU.items.get(0).quality);
	}
	
	@Test
	public void testTwentyOneCycles() {
		for(int i = 0; i < 21; i++) {
			qU.updateQuality();
		}
		Assert.assertEquals("Test 5 times", -11, qU.items.get(0).sellIn);
		Assert.assertEquals("Test 5 times", 0, qU.items.get(0).quality);
	}

}
