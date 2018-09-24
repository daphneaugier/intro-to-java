// -------------------------------------------------------
// Assignment 4
// Written by: Daphné Augier #40036123
// For COMP 248 Section Q 2162 – Fall 2016
// --------------------------------------------------------
import java.text.DecimalFormat;

public class IceCreamStore {

  private ShoppingCart myShoppingCart;

  public IceCreamStore() {
    this.myShoppingCart = new ShoppingCart();
  }

  public void run() {
    String[] shoppingMenuList = {"Place an order", "Delete an order", "Price the cart", "List the cart", "Proceed to checkout", "Exit this menu"};
    Menu shoppingMenu = new Menu(shoppingMenuList);//no messages, default prompts
    // reset prompts
    shoppingMenu.setBottomPrompt("Enter an option number: ");

    boolean loop =  true;
    while (loop) {
      // introduce messages
      if (this.myShoppingCart.isEmpty()) {
        shoppingMenu.setTopMessage("Your Shopping Cart is empty.");
        shoppingMenu.setBottomMessage("Please enter 1 or 6");
        shoppingMenu.setTopPrompt("You have only two options: 1 or 6");
      }
      else if (this.myShoppingCart.isFull()) {
        shoppingMenu.setTopMessage("Your shopping is full with " + this.myShoppingCart.size()  + " ice cream orders.");
        shoppingMenu.setBottomMessage("Please select option 2, 3, 4, 5, or 6");
        shoppingMenu.setTopPrompt("Cannot place orders! what would you like to do?");
      } else {
        shoppingMenu.setTopMessage("Your shopping cart contains " + this.myShoppingCart.size()  + " ice cream orders.");
        shoppingMenu.setBottomMessage(null);
        shoppingMenu.setTopPrompt("What would you like to do?");
      }
      // display the menu and then read an option number
      int choice = shoppingMenu.getOptionNumber();

      switch (choice) {
        case 1: placeOrder();
          break;
        case 2: deleteOrder();
          break;
        case 3: printTotalPrice();
          break;
        case 4: reviewOrders();
          break;
        case 5: checkout();
          break;
        case 6:
          System.out.println("Cheers!\n");
          loop = false;
          break;
      }
    }

  }

  public void placeOrder() {
    IceCreamOrder myOrder = new IceCreamOrder();
    this.myShoppingCart.add(myOrder);
  }

  public void deleteOrder() {
    String[] deleteOrderMenuList = new String [this.myShoppingCart.size()+1];
    int i;
    for (i=0;i<this.myShoppingCart.size();i++){
      deleteOrderMenuList[i] = this.myShoppingCart.get(i).toString();
    }
    int exitOption = i;
    deleteOrderMenuList[exitOption] = "Exit this menu";
    Menu deleteOrderMenu = new Menu(deleteOrderMenuList);
    deleteOrderMenu.setBottomPrompt("Enter an option number: ");
    // display the menu and then read an option number
    int choice = deleteOrderMenu.getOptionNumber();
    choice -= 1;
    if (choice != exitOption) {
      this.myShoppingCart.remove(choice);
      System.out.println("The order you selected was deleted\n");
    }
  }

  public double computeTotalPrice() {
    return this.myShoppingCart.totalPrice();
  }

  public void printTotalPrice() {
    DecimalFormat df = new DecimalFormat("####0.00");
    System.out.println("-----------------------------------------------------");
    System.out.println("Total price of all your orders in the cart: " + df.format(computeTotalPrice()));
    System.out.println("-----------------------------------------------------\n");
  }

  public void reviewOrders() {
    System.out.println("Your current selections of our scrumptious ice creams");
    System.out.println("-----------------------------------------------------");
    System.out.println(this.myShoppingCart.toString());
    System.out.println("-----------------------------------------------------\n");
  }

  public void checkout() {
    this.reviewOrders();
    this.printTotalPrice();
    this.myShoppingCart.removeAll();
  }

}
