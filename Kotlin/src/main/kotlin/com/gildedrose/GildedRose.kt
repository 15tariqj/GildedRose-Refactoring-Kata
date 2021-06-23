package com.gildedrose
import kotlin.math.max
import kotlin.math.min

class GildedRose(var items: Array<GeneralItem>) {

    fun updateQualities() {
        for (item in items) {
            item.updateQuality()
        }
    }

}

