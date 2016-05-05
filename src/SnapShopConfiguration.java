/**
 * SnapShopConfiguration
 * A class to configure the SnapShop application
 * 
 * @author Chloe Kuhar 
 * @version  21 Mar 2016
 * 
 */
public class SnapShopConfiguration {
    /**
     * configure
     * Method to configure the SnapShop.  
     * Call methods like addFilter
     * and setDefaultFilename in this method.
     * @param theShop   The SnapShop application
     */
    public static void configure(SnapShop theShop) {
        // set default directory
        theShop.setDefaultDirectory("./Images/");
     
        theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
        theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
        theShop.addFilter(new DemosaicFilter(), "Demosaic");
        theShop.addFilter(new DarkenFilter(), "Darken");
        theShop.addFilter(new ShiftRightFilter(), "Shift Right");
        theShop.addFilter(new EdgeFilter(), "Edge");
        theShop.addFilter(new CrazyFilter(), "Crazy");

    }
    
    /** 
     * main
     * creates a new SnapShop object
     */
    public static void main(String args[]) {
      SnapShop theShop = new SnapShop();
    }  
}
