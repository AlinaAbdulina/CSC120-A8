/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    /** 
     * The number of ounces of coffee remaining in inventory
     * The number of sugar packets remaining in inventory
     * The number of "splashes" of cream remaining in inventory
     * The number of cups remaining in inventory 
    */

    private int nCoffeeOunces; 
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Construct a Cafe
     * @param name cafe name
     * @param address cafe address
     * @param nFloors number of floors
     * @param nCoffeeOunces initial coffee ounces
     * @param nSugarPackets initial sugar
     * @param nCreams initial cream
     * @param nCups initial cups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕️");
    }

    /**
     * Overloaded constructor - default inventory amounts
     * @param name cafe name
     * @param address cafe address
     * @param nFloors number of floors
     */
    public Cafe(String name, String address, int nFloors) {
        this(name, address, nFloors, 200, 100, 100, 50);
    }
    
    /**
     * Sell a cup of coffee
     * Decrease the inventory by the ordered amounts
     * @param size ounces of coffee
     * @param nSugarPackets number of sugar
     * @param nCreams number of cream
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(100, 100, 100, 100); // Restocking default amounts
        }
        
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * Overloaded sellCoffee - black coffee only (no sugar or cream)
     * @param size ounces of coffee
     */
    public void sellCoffee(int size) {
        sellCoffee(size, 0, 0);
    }

    /**
     * Add to inventory
     * @param nCoffeeOunces ounces of coffee
     * @param nSugarPackets number of sugar
     * @param nCreams number of cream
     * @param nCups number of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Override showOptions to include Cafe-specific methods
     */
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(int, int, int)");
    }

    /**
     * Override goToFloor - cafes only allow access to first floor (rest is storage/employee only)
     * @param floorNum floor to go to
     */
    @Override
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum != 1) {
            throw new RuntimeException("Only the first floor is accessible to customers. Other floors are for storage and employees only.");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass Cafe", "7 Neilson Drive", 1, 100, 50, 50, 20);
        myCafe.sellCoffee(12, 2, 1);
        System.out.println("Coffee sold!");
    }
    
}
