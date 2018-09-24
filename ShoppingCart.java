// -------------------------------------------------------
// Assignment 4
// Written by: Daphné Augier #40036123
// For COMP 248 Section Q 2162 – Fall 2016
// --------------------------------------------------------

public class ShoppingCart {

  private IceCreamOrder[] cart;
  private int ordersNumber;
  private int MAX_ORDERS;

  public ShoppingCart() {
    this.MAX_ORDERS = 3;

    this.cart = new IceCreamOrder[this.MAX_ORDERS];
    this.ordersNumber = 0;
  }

  public void add(IceCreamOrder order) {
    if (this.size() < MAX_ORDERS) {
      this.cart[this.ordersNumber] = order;
      this.ordersNumber += 1;
    } else {
      System.out.println("Your Shopping Cart is full with " + this.ordersNumber + " ice cream orders.");
    }

  }

  public void removeAll() {
    for (int i= 0; i<ordersNumber; i++) {
        this.cart[i] = null;
    }
    this.ordersNumber = 0;
  }

  public void remove(int position) {
    for (int i= position; i<ordersNumber; i++) {
      if (i == MAX_ORDERS-1) {
        this.cart[i] = null;
      } else {
        this.cart[i] = this.cart[i+1];
      }
    }
    this.ordersNumber -= 1;
  }

  public String toString() {
      String tmp = "";
      for (int i=0; i<this.ordersNumber; i++) {
        tmp += this.get(i) + "\n";
      }
    return tmp;
  }

  public boolean isEmpty() {
    if (this.ordersNumber == 0)
      return true;
    else
      return false;
  }

  public boolean isFull() {
    if (this.ordersNumber == this.MAX_ORDERS)
      return true;
    else
      return false;
  }

  public IceCreamOrder get(int position) {
    if (position <0 || position > this.ordersNumber){
      System.out.println("There is no order available at this position");
      return null;
    }
      return this.cart[position];
  }

  public int size() {
    return this.ordersNumber;
  }

  public double totalPrice() {
    double totalPrice = 0.0;
    for (int i= 0; i<ordersNumber; i++) {
      totalPrice += this.cart[i].price();
    }
    return totalPrice;
  }

}
