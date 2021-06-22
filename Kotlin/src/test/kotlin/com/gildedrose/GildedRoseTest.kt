package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun qualityDegradesTwiceAsFastAfterSellByDate() {
        val items = arrayOf<Item>(Item(name = "foo", sellIn = 1, quality = 10))
        val app = GildedRose(items)
        app.updateQuality()
        app.updateQuality()
        assertEquals(7, app.items[0].quality)
    }

    @Test
    fun qualityIsNeverNegative() {
        val items = arrayOf<Item>(Item(name = "foo", sellIn = 1, quality = 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBrieIncreasesInQualityWithAge() {
        val items = arrayOf<Item>(Item(name = "Aged Brie", sellIn = 2, quality = 10))
        val app = GildedRose(items)
        app.updateQuality()
        assert(app.items[0].quality > 10)
    }

    @Test
    fun qualityOfItemNeverMoreThanFifty() {
        val items = arrayOf<Item>(Item(name = "Aged Brie", sellIn = 4, quality = 50), Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 3, quality = 50))
        val app = GildedRose(items)
        app.updateQuality()
        assert(app.items[0].quality <= 50)
        assert(app.items[1].quality <= 50)
    }

    @Test
    fun sulfurasNeverDecreasesQuality() {
        val items = arrayOf<Item>(Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 0, quality = 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun backstagePassesIncreaseInQualityWithAge() {
        val items = arrayOf<Item>(Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 11, quality = 10), Item(name ="Backstage passes to a TAFKAL80ETC concert", sellIn = 9, quality = 10), Item(name ="Backstage passes to a TAFKAL80ETC concert", sellIn = 3, quality = 10), Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = -1, quality = 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
        assertEquals(12, app.items[1].quality)
        assertEquals(13, app.items[2].quality)
        assertEquals(0, app.items[3].quality)
    }

    @

}


