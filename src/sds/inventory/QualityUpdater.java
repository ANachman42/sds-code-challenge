package sds.inventory;

import java.util.ArrayList;
import java.util.List;

public class QualityUpdater {

	// Create our inventory of products
	public List<Item> items = new ArrayList<Item>() {
		{
			add(new Item("+5 Dexterity Vest", 10, 20));
			add(new Item("Aged Brie", 2, 0));
			add(new Item("Elixir of the Mongoose", 5, 7));
			add(new Item("Sulfuras", 0, 80));
			add(new Item("Backstage Passes", 15, 20));
			add(new Item("Conjured", 3, 6));
		}
	};

	public void updateQuality() {

		/*
		 * My code
		 * I refactored the given code into something I think will be easier to read and maintain
		 * I believe that it functions identically to the original code
		 * And I added in the additional code to make Conjured items behave correctly
		 */
		for (int i = 0; i < items.size(); i++) {
			// If it's Sulfuras, just skip it entirely
			if (!items.get(i).name.equals("Sulfuras")) {
				// All items reduce sell date by 1
				items.get(i).sellIn -= 1;
				// We'll do standard items here (skip Brie and Passes for now)
				if (!items.get(i).name.equals("Aged Brie") && !items.get(i).name.equals("Backstage Passes")) {
					if (items.get(i).quality > 0) {
						if (items.get(i).sellIn >= 0) {
							items.get(i).quality -= 1;
							if (items.get(i).name.equals("Conjured")) {
								items.get(i).quality -= 1;
							}
						} else {
							items.get(i).quality -= 2;
							if (items.get(i).name.equals("Conjured")) {
								items.get(i).quality -= 2;
							}
							// Corner case
							if (items.get(i).quality < 0) {
								items.get(i).quality = 0;
							}
						}
					}
				} // End If
					// Time for cheese
				else if (items.get(i).name.equals("Aged Brie")) {
					if (items.get(i).quality < 50) {
						if (items.get(i).sellIn >= 0) {
							items.get(i).quality += 1;
						} else {
							items.get(i).quality += 2;
							// Corner case
							if (items.get(i).quality > 50) {
								items.get(i).quality = 50;
							}
						}
					}
				} // End else-if
				else if (items.get(i).name.equals("Backstage Passes")) {
					if (items.get(i).sellIn >= 0) {
						if (items.get(i).quality < 50) {
							if (items.get(i).sellIn < 6) {
								items.get(i).quality += 3;
							} else if (items.get(i).sellIn < 11) {
								items.get(i).quality += 2;
							} else {
								items.get(i).quality += 1;
							}
							// Corner case
							if (items.get(i).quality > 50) {
								items.get(i).quality = 50;
							}
						}
					} else {
						items.get(i).quality = 0;
					}
				} // End else-if
			}
		}
	}
}
