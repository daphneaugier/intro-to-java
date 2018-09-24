// -------------------------------------------------------
// Assignment 4
// Written by: Daphné Augier #40036123
// For COMP 248 Section Q 2162 – Fall 2016
// --------------------------------------------------------
import java.text.DecimalFormat;

public class IceCreamOrder {

  private String flavor;
  private String vessel;
  private String amount;
  private double unitPrice;
  private int quantity;

  public IceCreamOrder() {

    double[][] unitPriceTable = new double[3][3];

    unitPriceTable[0][0] = 2.99;
    unitPriceTable[0][1] = 3.49;
    unitPriceTable[0][2] = 4.25;

    unitPriceTable[1][0] = 3.99;
    unitPriceTable[1][1] = 4.49;
    unitPriceTable[1][2] = 5.25;

    unitPriceTable[2][0] = 4.99;
    unitPriceTable[2][1] = 5.49;
    unitPriceTable[2][2] = 6.25;

    String[] flavorList = {"Avocado", "Banana", "Chocolate", "Coffee", "Hazelnut", "Lemon", "Mango", "Mocha", "Vanilla"};
    Menu flavorMenu = new Menu(flavorList);//no messages, default prompts
    // introduce messages
    flavorMenu.setTopMessage("Placing an order is as easy as ABC, and D.");
    flavorMenu.setTopPrompt("Step A: Select your favorite flavour");
    // reset prompts
    flavorMenu.setBottomPrompt("Enter an option number: ");
    // display the menu and then read an option number
    int choice = flavorMenu.getOptionNumber();
    choice -= 1;
    this.flavor = flavorList[choice];

    String[] vesselList = {"Cone", "Cup", "Sundae"};
    Menu vesselMenu = new Menu(vesselList);//no messages, default prompts
    // introduce messages
    vesselMenu.setTopPrompt("Step B: Select a vessel for your ice cream");
    // reset prompts
    vesselMenu.setBottomPrompt("Enter an option number: ");
    // display the menu and then read an option number
    int choiceVessel = vesselMenu.getOptionNumber();
    choiceVessel -= 1;
    this.vessel = vesselList[choiceVessel];

    String[] amountList = {"Single Scoop", "Double Scoop", "Triple Scoop"};
    Menu amountMenu = new Menu(amountList);//no messages, default prompts
    // introduce messages
    amountMenu.setTopPrompt("Step C: How much ice cream?");
    // reset prompts
    amountMenu.setBottomPrompt("Enter an option number: ");
    // display the menu and then read an option number
    int choiceAmount = amountMenu.getOptionNumber();
    choiceAmount -= 1;
    this.amount = amountList[choiceAmount];

    String[] quantityList = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    Menu quantityMenu = new Menu(quantityList);//no messages, default prompts
    // introduce messages
    quantityMenu.setTopPrompt("Step D: how many orders of your current selection?");
    // reset prompts
    quantityMenu.setBottomPrompt("Enter how many orders: ");
    // display the menu and then read an option number
    choice = quantityMenu.getOptionNumber();
    this.quantity  = choice;

    this.unitPrice = unitPriceTable[choiceAmount][choiceVessel];
  }


  public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice, int quantity) {
    this.flavor = flavor;
    this.vessel = vessel;
    this.amount = amount;
    this.unitPrice = unitPrice;
    this.quantity  = quantity;
  }

   public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice) {
     this(flavor, vessel, amount, unitPrice, 1);
   }

  public String toString() {
    DecimalFormat df = new DecimalFormat("####0.00");
    return getQuantity() + " orders of " + getAmount() + " of " +
     getFlavor() + " ice cream in a " + getVessel() +
     " for $" + df.format(price()) + " = " + getQuantity() + " x " + getUnitPrice();
  }

  public double price() {
    return this.quantity*this.unitPrice;
  }

  // Setter and Getter methods
  public String getFlavor() {
    return this.flavor;
  }

  public void setFlavor(String flavor) {
    this.flavor = flavor;
  }

  public String getVessel() {
    return this.vessel;
  }

  public void setVessel(String vessel) {
    this.vessel = vessel;
  }

  public String getAmount() {
    return this.amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getUnitPrice() {
    return this.unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

}
