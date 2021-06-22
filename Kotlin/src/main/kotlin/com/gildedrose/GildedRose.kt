package com.gildedrose
import kotlin.math.max
import kotlin.math.min

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            when (items[i].name) {
                "Aged Brie" -> {
                    items[i].quality = min(items[i].quality + 1, 50)
                }
                "Backstage passes to a TAFKAL80ETC concert" -> {
                    items[i].quality = min(items[i].quality + 1, 50)
                    if (items[i].sellIn < 11) items[i].quality = min(items[i].quality + 1, 50)
                    if (items[i].sellIn < 6) items[i].quality = min(items[i].quality + 1, 50)
                    if (items[i].sellIn < 0) items[i].quality = 0
                }
                "Sulfuras, Hand of Ragnaros" -> {}
                "Conjured" -> {
                    items[i].quality = max(items[i].quality - 2, 0)
                }
                else -> {
                    if (items[i].sellIn < 0) items[i].quality = max(items[i].quality - 2, 0)
                    else items[i].quality = max(items[i].quality - 1, 0)
                }
            }
            items[i].sellIn -= 1
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

