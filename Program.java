package Controller;

import java.util.ArrayList;
import Model.Inventory;
import Model.Item;
import View.Display;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Program 
{
    int invNumber;
    // temp variable using for inventory number
    int number;
    // temp variable using for item number
    int number2;
    // temp variable using for attribute number
    int number3;
    
    private ArrayList<Inventory> inventories;
    Scanner in = new Scanner(System.in);
    
    public Program() throws IOException
    {
        inventories = new ArrayList<>();
        number = 0;
        mainMenu();
    }
    
    public void newInv() throws IOException
    {
        Inventory inv = new Inventory();
        addInv(inv);
        //menu code
        Display.infoLabel.setText("Please enter the name of your inventory: ");
        inv.setName(Display.userInput.getText());
        //call show inv
        showInv(inventories.size() - 1);
        Display.increaseMenuNumber();
    }
    
    public void addInv(Inventory inv){
        inventories.add(inv);
    }
    
    public void showInv(int num) throws IOException
    {
        //print items and give options
        Display.infoLabel.setText("Inventory: " + inventories.get(num).getName());
        Display.displayArea.setText("\tItems (enter item number to view/edit/delete the item):");
        int selector = 1;
        for(Item item: inventories.get(num).getItems())
        {
            Display.displayArea.appendText("\t#" + selector + ": " + item.getName());
            selector++;
        }
        Display.displayArea.appendText("\n\t#" + selector + ": New item");
        selector++;
        Display.displayArea.appendText("\n\t#" + selector + ": Edit inventory");
        selector++;
        Display.displayArea.appendText("\n\t#" + selector + ": Delete inventory");
        selector++;
        Display.displayArea.appendText("\n\t#" + selector + ": Save inventory");
        selector++;
        Display.displayArea.appendText("\n\t#0: Go back to the previous menu");
        Display.displayArea.appendText("\nPlease enter your choice: ");
}
    
    public void newItem() throws IOException
    {
        number = inventories.size() - 1;
        
        //prompt for name and call show item
        Item item = new Item();
        inventories.get(number).getItems().add(item);

        item.setName(Display.userInput.getText());

        item.plus(1);
        //call show inv
        showItem();
        Display.increaseMenuNumber();
    }
    
    public void showItem() throws IOException
    {
        number2 = inventories.get(number).getItems().size() - 1;
        //print items and give options

            Display.displayArea.setText("\tItem: " + inventories.get(number).getItems().get(number2).getName() + "\nQuantity: " + inventories.get(number).getItems().get(number2).getQuantity());
            Display.displayArea.appendText("\n\tAttributes (enter attribute number to view/edit/delete the item):");
            int selector = 1;
            for(String att: inventories.get(number).getItems().get(number2).getAttributes()){
                System.out.println("\t\t#" + selector + ": " + att);
                selector++;
            }
            Display.displayArea.appendText("\n\t#" + selector + ": New attribute");
            selector++;
            Display.displayArea.appendText("\n\t#" + selector + ": Edit item name");
            selector++;
            Display.displayArea.appendText("\n\t#" + selector + ": Add amount to quantity");
            selector++;
            Display.displayArea.appendText("\n\t#" + selector + ": Subtract amount from quantity");
            selector++;
            Display.displayArea.appendText("\n\t#" + selector + ": Delete item");
            selector++;
            Display.displayArea.appendText("\n\t#0: Go back to the previous menu");
            Display.displayArea.appendText("Please enter your choice: ");
            
            //if/else to determine choice
//            if(option == 0)
//                showInv(invNum);
//            else if(option < inventories.get(invNum).getItems().get(itemNum).getAttributes().size() + 1)
//                showAtt(invNum, itemNum, option - 1);
//            else if(option == inventories.get(invNum).getItems().get(itemNum).getAttributes().size() + 1)
//                newAtt(invNum, itemNum);
//            else if(option == inventories.get(invNum).getItems().get(itemNum).getAttributes().size() + 2){
//                System.out.print("Please enter the new name of the item: ");
//                inventories.get(invNum).getItems().get(itemNum).setName(in.next());
//            }
//            else if(option == inventories.get(invNum).getItems().get(itemNum).getAttributes().size() + 3){
//                System.out.print("Please enter the amount you wish to add to the quantity: ");
//                inventories.get(invNum).getItems().get(itemNum).plus(in.nextInt());
//            }
//            else if(option == inventories.get(invNum).getItems().get(itemNum).getAttributes().size() + 4){
//                System.out.print("Please enter the amount you wish to subtract from the quantity: ");
//                inventories.get(invNum).getItems().get(itemNum).minus(in.nextInt());
//            }
//            else if(option == inventories.get(invNum).getItems().get(itemNum).getAttributes().size() + 5){
//                inventories.get(invNum).getItems().remove(itemNum);
//                showInv(invNum);

        
    }
    
    public void newAtt() throws IOException{
        
        //prompt for name and call show item
        String att;
        
        //menu code
        att = Display.userInput.getText();
        inventories.get(number).getItems().get(number2).getAttributes().add(att);
        //call show inv
        showAtt(number, number2, inventories.get(number).getItems().get(number2).getAttributes().size()-1);
    }
    
    public void showAtt(int invNum, int itemNum, int attNum) throws IOException{
        //print items and give options

            Display.displayArea.setText("\n\tAttribute: " + inventories.get(invNum).getItems().get(itemNum).getAttributes().get(attNum));
            Display.displayArea.appendText("\n\t\t#1: Edit item");
            Display.displayArea.appendText("\n\t\t#2: Delete item");
            Display.displayArea.appendText("\n\t\t#0: Go back to the previous menu");
            Display.displayArea.appendText("Please enter your choice: ");
            System.out.println(Display.menuNumber);
            
            //if/else to determine choice
//            if(option == 0)
//                showItem(invNum, itemNum);
//            else if(option == 1){
//                System.out.print("Please enter the new attribute: ");
//                inventories.get(invNum).getItems().get(itemNum).getAttributes().set(attNum, in.next());
//            }
//            else if(option == 2){
//                inventories.get(invNum).getItems().get(itemNum).getAttributes().remove(attNum);
//                showInv(invNum);
}

    
    public void save(Inventory inv) throws FileNotFoundException
    {
    		//print invs and ask to select one to save
        SaveFile save = new SaveFile(inv);
    }
    
    public Inventory load() throws IOException
    {
        LoadFile load = new LoadFile();
        Inventory inv = load.getInv();
        return inv;
    }
    
    public void mainMenu() throws IOException
    {        
        Display.displayText.delete(0, Display.displayText.length());
        Display.displayText.append("Welcome to the inventory management system.\n"
                + "Please enter your selection based on the following menu.\n\n");

        Display.displayText.append("Available inventories:\n");
        invNumber = 1;
        for(Inventory inv: inventories){
            Display.displayText.append("\t#" + (invNumber) + ": " + inv.getName() + "\n");
            invNumber++;
        }
        textInstructions();
        
        //hide unnesecary buttons
        Display.saveButton.setVisible(false);
        Display.backButton.setVisible(false);
        Display.descriptionButton.setVisible(false);
        Display.editButton.setVisible(false);
        Display.deleteButton.setVisible(false);
        Display.addButton.setVisible(false);
        Display.subtractButton.setVisible(false);
        Display.showButton.setVisible(false);
        
        //set button actions
        Display.newButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                try {
                    if(Display.menuNumber == 0)
                        newInv();
                    else if(Display.menuNumber == 1)
                        newItem();
                    else if(Display.menuNumber == 2)
                        newAtt();
                        
                } catch (IOException ex) {
                    Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Display.loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                try {
                    load();
                } catch (IOException ex) {
                    Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Display.exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });
        
        Display.submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                if(Integer.parseInt(Display.userInput.getText()) < invNumber){
                    try {
                        showInv(Integer.parseInt(Display.userInput.getText()) - 1);
                    } catch (IOException ex) {
                        Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
            }
        });
        
        Display.backButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override 
            public void handle(ActionEvent e) 
            {
                if(Integer.parseInt(Display.userInput.getText()) < invNumber)
                {
                    Display.decreaseMenuNumber();
                }
            }
            
        });
    }  
    
    public void textInstructions(){
        Display.displayText.append("\n\nPlease enter your selection in the text field below\nand then press the button on the left that\ncorresponds with what you want to do\n");
        Display.displayArea.setText(Display.displayText.toString());
    }
}
