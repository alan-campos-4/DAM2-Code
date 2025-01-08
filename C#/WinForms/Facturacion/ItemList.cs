using System;

public class ItemList
{
    public Item[] items;

    public ItemList()
    {
        items = new Item[]
        {
            new Item(1, "Tornillo", 0.4),
            new Item(2, "Tuerca", 0.3),
            new Item(3, "Destornillador", 5.5),
            new Item(4, "Martillo", 12),
            new Item(5, "Cable", 2.4),
            new Item(6, "Linterna", 18.99),
            new Item(7, "Enchufe", 7.99),
            new Item(8, "...", 6.0),
            new Item(9, "...", 2.99),
            new Item(10, "...", 22.5)
        };
    }
}