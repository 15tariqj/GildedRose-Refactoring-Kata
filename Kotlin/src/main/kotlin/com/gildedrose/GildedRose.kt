package com.gildedrose
import kotlin.math.max
import kotlin.math.min

class GildedRose(var items: Array<GeneralItem>) {

    fun updateQualities() {
        for (item in items) {
            item.updateQuality()
            /*when (item.name) {
                "Aged Brie" -> {
                    item.quality = min(item.quality + 1, 50)
                }
                "Backstage passes to a TAFKAL80ETC concert" -> {
                    item.quality = min(item.quality + 1, 50)
                    if (item.sellIn < 11) item.quality = min(item.quality + 1, 50)
                    if (item.sellIn < 6) item.quality = min(item.quality + 1, 50)
                    if (item.sellIn < 0) item.quality = 0
                }
                "Sulfuras, Hand of Ragnaros" -> {}
                "Conjured" -> {
                    item.quality = max(item.quality - 2, 0)
                }
                else -> {
                    if (item.sellIn < 0) item.quality = max(item.quality - 2, 0)
                    else item.quality = max(item.quality - 1, 0)
                }
            }
            item.sellIn -= 1*/
        }

    //**LEGACY CODE**
    /*for (i in items.indices) {
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }*/
    }

}

