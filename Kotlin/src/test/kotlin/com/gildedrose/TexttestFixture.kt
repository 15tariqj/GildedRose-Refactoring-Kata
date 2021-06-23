package com.gildedrose

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayOf(GeneralItem("+5 Dexterity Vest", 10, 20), //
            GeneralItem("Aged Brie", 2, 0), //
            GeneralItem("Elixir of the Mongoose", 5, 7), //
            GeneralItem("Sulfuras, Hand of Ragnaros", 0, 80), //
            GeneralItem("Sulfuras, Hand of Ragnaros", -1, 80),
            GeneralItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            GeneralItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            GeneralItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            GeneralItem("Conjured Mana Cake", 3, 6))

    val app = GildedRose(items)

    var days = 2
    if (args.size > 0) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0..days - 1) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQualities()
    }


}
