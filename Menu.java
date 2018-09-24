import java.util.Scanner;

// -------------------------------------------------------
// Assignment 4
// Written by: Daphné Augier #40036123
// For COMP 248 Section Q 2162 – Fall 2016
// --------------------------------------------------------

public class Menu {

	private String opening_message = null;
	private String closing_message = null;
	private String top_prompt      = null;
	private String bottom_prompt   = null;
	private String prompt          = null;
	private String[] option_list   = null;

	// Default constructor
	public Menu() {
		this.opening_message = null;
		this.closing_message = null;
		this.top_prompt      = null;
		this.bottom_prompt   = null;
		this.prompt          = "?-> ";
		this.option_list     = null;
	}

	// Constructor
	public Menu(String[] option_list) {
		this.opening_message = null;
		this.closing_message = null;
		this.top_prompt      = "Choose an option";
		this.bottom_prompt   = "Enter an option number";
		this.prompt          = "?-> ";
		this.option_list     = option_list;
	}

	// Called by default if no method specified
	public String toString() {

		String menu_text = "";

		menu_text = getTopMessage() + getTopPrompt();

		if (!this.isEmpty()) {
			int option_max = this.option_list.length;
			int j = 1;
			for(int i=0;i<option_max;i++){
					menu_text += "\t(" + j++ + ") " + this.option_list[i] +  "\n";
			}
		}

		menu_text += getBottomMessage() + this.prompt + getBottomPrompt();

		return menu_text;
 	}

	// Facilitator
	public boolean isEmpty() {
		if (this.option_list == null)
			return true;
		else
			return false;
	}

	// Facilitator
	public int length() {
		if (this.isEmpty())
			return 0;
		else
			return this.option_list.length;
	}

	public void setTopPrompt(String message) {
		this.top_prompt = message;
	}

	public void setBottomPrompt(String message) {
		this.bottom_prompt = message;
	}

	public void setTopMessage(String message) {
		this.opening_message = message;
	}

	public void setBottomMessage(String message) {
		this.closing_message = message;
	}

	public String getTopPrompt() {
		if (this.top_prompt != null)
			return this.top_prompt + "\n";
		else
			return "";
	}

	public String getBottomPrompt() {
		if (this.bottom_prompt != null)
			return this.bottom_prompt;
		else
			return "";
	}

	public String getTopMessage() {
		if (this.opening_message != null)
			return this.opening_message + "\n";
		else
			return "";
	}

	public String getBottomMessage() {
		if (this.closing_message != null)
			return this.closing_message + "\n";
		else
			return "";
	}


	public int getOptionNumber() {

		Scanner keyboard = new Scanner(System.in);
		int choice = 0 ;

		while (true) {
			System.out.print(this.toString());
			choice = keyboard.nextInt();
			if (this.length() == 0) {
				break;
			} else if (choice <0 || choice > this.length()) {
				System.out.println("Sorry, I didn't catch that. Please try again\n");
			} else {
				System.out.println();
				break;
			}
		}
		return choice;
	}
}
