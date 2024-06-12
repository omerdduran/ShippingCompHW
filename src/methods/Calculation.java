package methods;

import items.Item;
import containers.Container;
import containers.SmallContainer;
import containers.BigContainer;
import java.util.List;

public class Calculation {

    public double totalVolume(List<Item> items) {
        double totalVolume = 0;
        for (Item item : items) {
            totalVolume += item.calculateVolume();
        }
        return totalVolume;
    }

    public double totalWeight(List<Item> items) {
        double totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public void bestShipping(List<Item> items) {
        double totalVolume = totalVolume(items);
        double totalWeight = totalWeight(items);
        
        Container smallContainer = new SmallContainer();
        Container bigContainer = new BigContainer();

        int smallContainersNeeded = (int) Math.ceil(totalVolume / smallContainer.calculateVolume());
        int bigContainersNeeded = (int) Math.ceil(totalVolume / bigContainer.calculateVolume());

        double smallContainerCost = (totalWeight > 500) ? 1200 * smallContainersNeeded : 1000 * smallContainersNeeded;
        double bigContainerCost = 1800 * bigContainersNeeded;

        // Kombinasyonları kontrol edelim
        double combinedCost = 0;
        int combinedBigContainers = (int) Math.floor(totalVolume / bigContainer.calculateVolume());
        double remainingVolume = totalVolume - (combinedBigContainers * bigContainer.calculateVolume());
        int combinedSmallContainers = (int) Math.ceil(remainingVolume / smallContainer.calculateVolume());

        if (totalWeight > 500) {
            combinedCost = (1800 * combinedBigContainers) + (1200 * combinedSmallContainers);
        } else {
            combinedCost = (1800 * combinedBigContainers) + (1000 * combinedSmallContainers);
        }

        System.out.println(smallContainersNeeded + " Small Containers: " + smallContainerCost + " Euros");
        System.out.println(bigContainersNeeded + " Big Containers: " + bigContainerCost + " Euros");
        System.out.println(combinedBigContainers + " Big Containers and " + combinedSmallContainers + " Small Containers: " + combinedCost + " Euros");

        double minCost = Math.min(smallContainerCost, Math.min(bigContainerCost, combinedCost));
        if (minCost == smallContainerCost) {
            System.out.println("Best Option: " + smallContainersNeeded + " Small Containers");
        } else if (minCost == bigContainerCost) {
            System.out.println("Best Option: " + bigContainersNeeded + " Big Containers");
        } else {
            System.out.println("Best Option: " + combinedBigContainers + " Big Containers and " + combinedSmallContainers + " Small Containers");
        }
    }

    public double shippingPrice(List<Item> items, String containerType) {
        double totalWeight = totalWeight(items);
        double totalCost = 0;

        if (containerType.contains("Small")) {
            int smallContainersNeeded = (int) Math.ceil(totalVolume(items) / new SmallContainer().calculateVolume());
            totalCost = (totalWeight > 500) ? 1200 * smallContainersNeeded : 1000 * smallContainersNeeded;
        } else if (containerType.contains("Big") && containerType.contains("Small")) {
            String[] parts = containerType.split(" and ");
            int bigContainersNeeded = Integer.parseInt(parts[0].split(" ")[0]);
            int smallContainersNeeded = Integer.parseInt(parts[1].split(" ")[0]);

            totalCost = (1800 * bigContainersNeeded) + ((totalWeight > 500) ? 1200 * smallContainersNeeded : 1000 * smallContainersNeeded);
        } else {
            int bigContainersNeeded = (int) Math.ceil(totalVolume(items) / new BigContainer().calculateVolume());
            totalCost = 1800 * bigContainersNeeded;
        }

        return totalCost;
    }

    public void printOrder(List<Item> items, String containerType) {
        System.out.println("Order Details:");
        for (Item item : items) {
            item.printItemInfo();
        }
        System.out.println("Shipping Method: " + containerType);
        System.out.println("Total Shipping Cost: " + shippingPrice(items, containerType));
    }
}
