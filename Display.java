/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Program;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author timot
 */
public class Display extends Application 
{
    public static StringBuilder displayText;
    public static TextArea displayArea;
    public static Button newButton;
    public static Button editButton;
    public static Button deleteButton;
    public static Button loadButton;
    public static Button saveButton;
    public static Button backButton;
    public static Button addButton;
    public static Button subtractButton;
    public static Button descriptionButton;
    public static Button showButton;
    public static Button exitButton;
    public static Button submitButton;
    public static TextField userInput;
    public static Label infoLabel;
    public static Program run;
    public static int menuNumber;
    
    @Override
    public void start(Stage primaryStage) throws IOException 
    {
        
        BorderPane mainPane = new BorderPane();
        mainPane = createMainPane(mainPane);
        
        Scene mainView = new Scene(mainPane);
        menuNumber = 0;
        
        primaryStage.setTitle("Inventory System!");
        primaryStage.setResizable(false);
        primaryStage.setScene(mainView);
        primaryStage.show();
        run = new Program();
    }

    /**
     * @param args the command line arguments
     */
    
    public BorderPane createMainPane(BorderPane mainPane)
    {
        mainPane.setMinSize(600, 250);
        
        GridPane buttonPane = new GridPane();
        createGridPane(buttonPane);
        
        FlowPane userPane = new FlowPane();
        createFlowPane(userPane);
        
        displayText = new StringBuilder("");
        
        displayArea = new TextArea();
        displayArea.setPrefHeight(300);
        displayArea.setMaxWidth(400);
        displayArea.setEditable(false);
        
        mainPane.setLeft(buttonPane);
        mainPane.setCenter(displayArea);
        mainPane.setBottom(userPane);
        
        return mainPane;
    }
    
    public GridPane createGridPane(GridPane buttonPane)
    {
        buttonPane.setPadding(new Insets(1, 1, 1, 1));
        buttonPane.setHgap(10);
        buttonPane.setVgap(10);
        
        newButton = new Button("New");
        editButton = new Button("Edit");
        deleteButton = new Button("Delete");
        loadButton = new Button("Load");
        saveButton = new Button("Save");
        backButton = new Button("Back");
        addButton = new Button("Add amount");
        subtractButton = new Button("Subtract amount");
        descriptionButton = new Button("Description");
        showButton = new Button("Show inventories");
        exitButton = new Button("Exit program");
        
        buttonPane.add(newButton, 0, 0);
        buttonPane.add(editButton, 1, 0);
        buttonPane.add(deleteButton, 2, 0);
        buttonPane.add(saveButton, 0, 1);
        buttonPane.add(loadButton, 1, 1);
        buttonPane.add(showButton, 2, 1);
        
        buttonPane.add(backButton, 0, 2);
        buttonPane.add(addButton, 1, 2);
        buttonPane.add(subtractButton, 2, 2);
        buttonPane.add(descriptionButton, 0, 3);
        buttonPane.add(exitButton, 1, 3);
        
//        editButton.setVisible(false);
//        saveButton.setVisible(false);
//        deleteButton.setVisible(false);
//        backButton.setVisible(false);
//        addButton.setVisible(false);
//        subtractButton.setVisible(false);
//        descriptionButton.setVisible(false);
        
        
        
        return buttonPane;
    }
    
    public FlowPane createFlowPane(FlowPane userPane)
    {
        submitButton = new Button("Submit");
        infoLabel = new Label("\nEnter your selection: ");
        infoLabel.setPrefWidth(300);
        infoLabel.setAlignment(Pos.CENTER_RIGHT);
        userInput = new TextField();
        userInput.setPrefWidth(300);
        
        userPane.getChildren().add(infoLabel);
        userPane.getChildren().add(userInput);
        userPane.getChildren().add(submitButton);
        
        return userPane;
    }
    
    public static void increaseMenuNumber()
    {
        menuNumber++;
    }
    
    public static void decreaseMenuNumber()
    {
        menuNumber--;
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
