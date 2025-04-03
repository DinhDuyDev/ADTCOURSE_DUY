public class Main {
    public static void main(String[] args) {
        int totalCost = 0;
        BagInterface<Item> shoppingBag = new Bag<>();
        Item[] itemsBought = {
            new Item("Bird feeder", 2050),
            new Item("Squirrel guard", 1547),
            new Item("Bird bath", 4499),
            new Item("Sunflower seeds", 1295)
        };
        for (int i=0; i<itemsBought.length; i++) {
            shoppingBag.add(itemsBought[i]);
        }
        
        while (!shoppingBag.isEmpty()) {
            Item getItem = shoppingBag.remove();
            totalCost += getItem.price;
            System.out.println(
              getItem.itemName + "\t$" + getItem.price / 100 + "." + getItem.price % 100  
            );
        }
        System.out.println(
            "Total cost:" +"\t$" + totalCost / 100 + "." + totalCost % 100
        );
    }
}
