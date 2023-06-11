/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */
import java.util.List;

public class DrivableTrader extends Trader<Drivable> {
    /**
     * Construct a DrivableTrader, giving them the given inventory,
     * wishlist, and money.
     *
     * @param inventory Objects in this DrivableTrader's inventory
     * @param wishlist  Objects in this DrivableTrader's wishlist
     * @param money     The DrivableTrader's money
     */
    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist, int money) {
        super(inventory, wishlist, money);
    }

    /**
     * Construct a DrivableTrader with the given money and empty inventory and wishlist.
     *
     * @param money The DrivableTrader's money
     */
    public DrivableTrader(int money) {
        super(money);
    }

    /**
     * Get the selling price of a Drivable object.
     * If the object is Tradable, return its price (via getPrice()) plus its max speed.
     * If not, return Tradable.MISSING_PRICE.
     *
     * @param drivable The Drivable object to get the selling price for
     * @return The selling price if Tradable, otherwise Tradable.MISSING_PRICE
     */
    @Override
    public int getSellingPrice(Drivable drivable) {
        if (drivable instanceof Tradable) {
            int price = ((Tradable) drivable).getPrice();
            int maxSpeed = drivable.getMaxSpeed();
            return price + maxSpeed;
        }
        return Tradable.MISSING_PRICE;
    }

    // Additional methods specific to DrivableTrader...

}
