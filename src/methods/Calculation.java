package methods;

import items.Item;
import containers.Container;
import containers.SmallContainer;
import containers.BigContainer;
import java.util.List;

public class Calculation {

    // Calculates the total volume of a list of items.
    public double totalVolume(List<Item> items) {
        double totalVolume = 0;
        for (Item item : items) {
            totalVolume += item.calculateVolume(); // Add each item's volume to the total.
        }
        return totalVolume;
    }

    // Calculates the total weight of a list of items.
    public double totalWeight(List<Item> items) {
        double totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight(); // Add each item's weight to the total.
        }
        return totalWeight;
    }

    // Determines the best shipping option based on total volume and weight of items.
    public void bestShipping(List<Item> items) {
        double totalVolume = totalVolume(items);
        double totalWeight = totalWeight(items);
        
        // Define small and big container types.
        Container smallContainer = new SmallContainer();
        Container bigContainer = new BigContainer();

        // Calculate the number of each type of container needed based on volume.
        int smallContainersNeeded = (int) Math.ceil(totalVolume / smallContainer.calculateVolume());
        int bigContainersNeeded = (int) Math.ceil(totalVolume / bigContainer.calculateVolume());

        // Calculate cost for small containers based on weight limit.
        double smallContainerCost = (totalWeight > 500) ? 1200 * smallContainersNeeded : 1000 * smallContainersNeeded;
        double bigContainerCost = 1800 * bigContainersNeeded; // Fixed cost for big containers.

        // Evaluate cost of using a combination of big and small containers.
        double combinedCost = 0;
        int combinedBigContainers = (int) Math.floor(totalVolume / bigContainer.calculateVolume());
        double remainingVolume = totalVolume - (combinedBigContainers * bigContainer.calculateVolume());
        int combinedSmallContainers = (int) Math.ceil(remainingVolume / smallContainer.calculateVolume());

        // Calculate combined cost based on weight thresholds.
        combinedCost = (1800 * combinedBigContainers) + ((totalWeight > 500 ? 1200 : 1000) * combinedSmallContainers);

        // Output the number of containers and their costs.
        System.out.println(smallContainersNeeded + " Small Containers: " + smallContainerCost + " Euros");
        System.out.println(bigContainersNeeded + " Big Containers: " + bigContainerCost + " Euros");
        
        if (combinedBigContainers > 0 && combinedSmallContainers > 0) {
            System.out.println(combinedBigContainers + " Big Containers and " + combinedSmallContainers + " Small Containers: " + combinedCost + " Euros");
        }

        // Determine and print the cheapest option.
        double minCost = Math.min(smallContainerCost, Math.min(bigContainerCost, combinedCost));
        if (minCost == smallContainerCost) {
            System.out.println("Best Option: " + smallContainersNeeded + " Small Containers");
        } else if (minCost == bigContainerCost) {
            System.out.println("Best Option: " + bigContainersNeeded + " Big Containers");
        } else {
        	// If one of the two container types is 0, there is no need to print
        	if (combinedBigContainers > 0 && combinedSmallContainers > 0) {
        	    System.out.println("Best Option: " + combinedBigContainers + " Big Containers and " + combinedSmallContainers + " Small Containers");
        	}
        }
    }

    // Calculate shipping price based on the selected container type.
    public double shippingPrice(List<Item> items, String containerType) {
        double totalWeight = totalWeight(items);
        double totalCost = 0;

        // Calculate cost based on container type specification.
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
}
