/* This is a stub for the Cafe class */
public class Cafe extends Building {

    // Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {

        super(name, address);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

        System.out.println("You have built a cafe: ☕");
    }

    // overload constructor 
    /**
     * @param name
     * @param address
     */
    public Cafe(String name, String address) {
        this(name, address, 50, 50, 50, 50 );
    }
    
    // Method any size, any sugar, any cream, 1 cup
    public void sellCoffee(int size, int nSugarPackets, int nCreams){

        // before sell, check if we need a restock 
        if (nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || 
        this.nCreams < nCreams || nCups < 1) {
        restock(50, 50, 50, 50);
        System.out.println("Restocked inventory!"); 
    }
        // sell coffee transcation 
        nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        nCups -= 1;
    }

    // Overload method any size, no cream, no sugar
    public void sellCoffee(int size) {
        sellCoffee(size, 0, 0);
    }

    // Overload method any size, any sugar, no cream
    public void sellCoffee(int size, int nSugarPackets) {
        sellCoffee(size, nSugarPackets, 0);
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;

    }        

    // Override showOptions()
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size) \n + sellCoffee(size, sugar) \n + sellCoffee(size, sugar, cream)");
    }

    // Override goToFloor(int n) to stay on the first floor
    @Override
    public void goToFloor(int floorNum) {
        if (floorNum != 1) {
            throw new RuntimeException("Employee only.");
        }
        super.goToFloor(floorNum);
    }


    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "7 College Lane, Northampton, MA", 12, 50, 50, 50);
        compass.enter(); //enter building
        compass.showOptions(); //see menu
        compass.sellCoffee(12, 2, 1); //any coffee they want
        compass.sellCoffee(8); // coffee no sugar no cream any size
        compass.sellCoffee(16, 3); // any size any sugar no cream

        
    }
    
}
