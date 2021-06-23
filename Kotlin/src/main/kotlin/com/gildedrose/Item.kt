package com.gildedrose

import kotlin.math.max
import kotlin.math.min

//I'd add a general "updateQuality" function here if I could
//but the requirements state we can't edit the Item class :(
open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

open class GeneralItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    open fun updateQuality() {
        if (this.sellIn < 0) this.quality = max(this.quality - 2, 0)
        else this.quality = max(this.quality - 1, 0)
        this.sellIn -= 1
    }
}

class AgedBrie(name: String, sellIn: Int, quality: Int) : GeneralItem(name, sellIn, quality) {
    override fun updateQuality() {
        this.quality = min(this.quality + 1, 50)
        if (this.sellIn < 0) this.quality = min(this.quality + 1, 50)
        this.sellIn -= 1
    }
}

class BackstagePasses(name: String, sellIn: Int, quality: Int) : GeneralItem(name, sellIn, quality) {
    override fun updateQuality() {
        this.quality = min(this.quality + 1, 50)
        if (this.sellIn < 11) this.quality = min(this.quality + 1, 50)
        if (this.sellIn < 6) this.quality = min(this.quality + 1, 50)
        if (this.sellIn < 0) this.quality = 0
        this.sellIn -= 1
    }
}

class Sulfuras(name: String, sellIn: Int, quality: Int) : GeneralItem(name, sellIn, quality) {
    override fun updateQuality() {
        this.sellIn -= 1
    }
}

class Conjured(name: String, sellIn: Int, quality: Int) : GeneralItem(name, sellIn, quality) {
    override fun updateQuality() {
        this.quality = max(this.quality - 2, 0)
        this.sellIn -= 1
    }
}

