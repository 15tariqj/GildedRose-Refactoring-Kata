package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<GeneralItem>(GeneralItem("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun normalItemsDecreaseQualityBeforeSellIn() {
        val items = arrayOf<GeneralItem>(GeneralItem(name = "foo", sellIn = 4, quality = 10))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun qualityDegradesTwiceAsFastAfterSellByDate() {
        val items = arrayOf<GeneralItem>(GeneralItem(name = "foo", sellIn = -1, quality = 10))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun qualityIsNeverNegative() {
        val items = arrayOf<GeneralItem>(GeneralItem(name = "foo", sellIn = 1, quality = 0))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBrieIncreasesInQualityWithAge() {
        val items = arrayOf<GeneralItem>(AgedBrie(name = "Aged Brie", sellIn = 2, quality = 10))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun agedBrieIncreasesTwiceAsFastAfterSellIn() {
        val items = arrayOf<GeneralItem>(AgedBrie(name = "Aged Brie", sellIn = -1, quality = 10))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun qualityOfItemNeverMoreThanFifty() {
        val items = arrayOf<GeneralItem>(AgedBrie(name = "Aged Brie", sellIn = 4, quality = 50), BackstagePasses(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 3, quality = 50))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(50, app.items[0].quality)
        assertEquals(50, app.items[1].quality)
    }

    @Test
    fun sulfurasNeverDecreasesQuality() {
        val items = arrayOf<GeneralItem>(Sulfuras(name = "Sulfuras, Hand of Ragnaros", sellIn = 0, quality = 80))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun backstagePassesIncreaseInQualityWithAge() {
        val items = arrayOf<GeneralItem>(BackstagePasses(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 11, quality = 10), BackstagePasses(name ="Backstage passes to a TAFKAL80ETC concert", sellIn = 9, quality = 10), BackstagePasses(name ="Backstage passes to a TAFKAL80ETC concert", sellIn = 3, quality = 10), BackstagePasses(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = -1, quality = 10))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(11, app.items[0].quality)
        assertEquals(12, app.items[1].quality)
        assertEquals(13, app.items[2].quality)
        assertEquals(0, app.items[3].quality)
    }

    @Test
    fun conjuredItemsDecreaseTwiceAsFast() {
        val items = arrayOf<GeneralItem>(Conjured(name = "Conjured Mana Cake", sellIn = 5, quality = 10))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(8, items[0].quality)
    }

    @Test
    fun conjuredItemsDecreaseTwiceAsFastAfterSellIn() {
        val items = arrayOf<GeneralItem>(Conjured(name = "Conjured Mana Cake", sellIn = -1, quality = 10))
        val app = GildedRose(items)
        app.updateQualities()
        assertEquals(6, items[0].quality)
    }


}


