package View.Menu;

import Controller.Input.ViewController;
import Controller.buttons.EquipItemSelectable;
import Controller.buttons.GameplayViewSelectable;
import Controller.buttons.Selectable;
import Controller.buttons.UnequipItemSelectable;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Inventory;
import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.EquippableItems.EquippableItem;
import Model.Items.TakeableItems.TakeableItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class InventoryView extends AbstractView{

    // TODO: fix OOP violations by making separate controllers for each view or something
    private ViewController viewController;
    private Inventory inventory;
    private EquippableItem unequippedItem;
    private EquippableItem equippedItem;
    private Button equipButton;
    private Button unequipButton;

    // TODO: find a way to pass playerEntity to this view
    public InventoryView(ViewController viewController, CharacterEntity character) {
        this.viewController = viewController;

        // TODO: make inventory not global if possible
        inventory = character.getInventory();

        this.getChildren().add(borderPane(character));
    }


    private StackPane centerPane() {
        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(0);

        return stackPane;
    }


    private Text topPaneText() {
        Text t = new Text();
        t.setText("Inventory");
        t.setFont(Font.font("Elephant", 50));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }


    private StackPane topPane() {
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1000,100);
        stackPane.setPadding(new Insets(10,10,10,10));
        stackPane.setAlignment(Pos.BOTTOM_CENTER);
        stackPane.getChildren().add(topPaneText());

        return stackPane;
    }

    private ArrayList<RadioButton> leftPaneRadioButtons(CharacterEntity character) {

        // togglegroup for equipped items
        ToggleGroup unequippedToggleGroup = new ToggleGroup();

        // Arraylist of buttons for inventory
        ArrayList<RadioButton> unequippedItemsButtons = new ArrayList<RadioButton>();

        TakeableItem[] unequippedItemsArray = inventory.getUnequippedItems();
        int numberOfUnequippedItems = 0;

        for (int i = 0; i < inventory.getUnequippedItemBagSize(); i++) {
            if (unequippedItemsArray[i] != null) {
                numberOfUnequippedItems++;
            }
        }


        int unequippedItemsArrayPosition = 0;

        for (int i = 0; i < numberOfUnequippedItems; i++) {
            // TODO: pass in image and/or item name to display

            // create radio button

            // TODO: give the radio button the name of the item and stuff to identify which one it is
            RadioButton rb = new RadioButton();

            if (unequippedItemsArray[i] == null) {
                unequippedItemsArrayPosition++;
            }

            // give the radio button the item that is selected
            rb.setUserData(inventory.getItemAtSlot(unequippedItemsArrayPosition));

            // set the button to the togglegroup to ensure that only one thing can be selected at a time
            rb.setToggleGroup(unequippedToggleGroup);

            // add the button to the arraylist to display them later
            unequippedItemsButtons.add(rb);
        }


        unequippedToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(newValue != null){
                    // TODO: see if it is possible to avoid casting
                    equippedItem = (EquippableItem) unequippedToggleGroup.getSelectedToggle().getUserData();
                    equipButton.setDisable(false);
                }
            }
        });

        // No initially selected item

        return unequippedItemsButtons;
    }

    private VBox leftPane(CharacterEntity character) {
        ArrayList<RadioButton> options = leftPaneRadioButtons(character);
        VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setPrefSize(400,628);
        vbox.setAlignment(Pos.TOP_CENTER);

        for(RadioButton clickable: options) {

            // sets selectable style
            clickable.getStyleClass().add("button2");

            // add to vbox
            vbox.getChildren().add(clickable);
        }

        return vbox;
    }


    private ArrayList<RadioButton> rightPaneRadioButtons(CharacterEntity character) {

        // togglegroup for unequipped items
        ToggleGroup equippedToggleGroup = new ToggleGroup();

        // Arraylist of buttons for inventory
        ArrayList<RadioButton> equippedItemsButtons = new ArrayList<RadioButton>();


        HashMap<ItemSlot, EquippableItem> equippedItemsHashMap = inventory.getEquippedItems();
        Set<ItemSlot> equippedItemsKeys = inventory.getEquippedItems().keySet();


        for (ItemSlot key : equippedItemsKeys) {
            // TODO: pass in image and/or item name to display

            // create radio button

            // TODO: give the radio button the name of the item and stuff to identify which one it is
            RadioButton rb = new RadioButton();

            // give the radio button the item that is selected
            rb.setUserData(equippedItemsHashMap.get(key));

            // set the button to the togglegroup to ensure that only one thing can be selected at a time
            rb.setToggleGroup(equippedToggleGroup);

            // add the button to the arraylist to display them later
            equippedItemsButtons.add(rb);
        }


        equippedToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(newValue != null){
                    // TODO: see if it is possible to avoid casting
                    unequippedItem = (EquippableItem) equippedToggleGroup.getSelectedToggle().getUserData();
                    unequipButton.setDisable(false);
                }
            }
        });

        // No initially selected item

        return equippedItemsButtons;
    }


    private VBox rightPane(CharacterEntity character) {
        ArrayList<RadioButton> options = rightPaneRadioButtons(character);
        VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setPrefSize(400,628);
        vbox.setAlignment(Pos.TOP_CENTER);

        for(RadioButton clickable: options) {

            // sets selectable style
            clickable.getStyleClass().add("button2");

            // add to vbox
            vbox.getChildren().add(clickable);
        }

        return vbox;
    }


    private ArrayList<Selectable> bottomPaneButtons(ViewController viewController, CharacterEntity character) {
        ArrayList<Selectable> options = new ArrayList<Selectable>() {{

            add(new EquipItemSelectable("Equip Item", viewController, equippedItem, character));
            add(new UnequipItemSelectable("Unequip Item", viewController, unequippedItem, character));

            add(new GameplayViewSelectable("Back to Game", viewController));
        }};

        return options;
    }

    private HBox bottomPane(CharacterEntity character) {

        ArrayList<Selectable> options = bottomPaneButtons(viewController, character);

        HBox hbox = new HBox();
        hbox.setMaxHeight(300);

        hbox.setSpacing(20);
        hbox.setPrefSize(1000,72);
        hbox.setAlignment(Pos.TOP_CENTER);


        // doing all this manually instead of looping through the arraylist to temporarily disable the buttons until something is clicked
        equipButton = new Button(options.get(0).getName());
        equipButton.getStyleClass().add("button4");
        equipButton.setOnAction(options.get(0));
        equipButton.setDisable(true);

        unequipButton = new Button(options.get(1).getName());
        unequipButton.getStyleClass().add("button4");
        unequipButton.setOnAction(options.get(1));
        unequipButton.setDisable(true);

        Button exitButton = new Button(options.get(2).getName());
        exitButton.getStyleClass().add("button4");
        exitButton.setOnAction(options.get(2));


        hbox.getChildren().add(equipButton);
        hbox.getChildren().add(unequipButton);
        hbox.getChildren().add(exitButton);

        return hbox;
    }

    private BorderPane borderPane(CharacterEntity character) {

        // create new borderpane for formatting
        BorderPane bp = new BorderPane();

        bp.setTop(topPane());
        bp.setCenter(centerPane());

        bp.setBottom(bottomPane(character));
        bp.setLeft(leftPane(character));
        bp.setRight(rightPane(character));

        return bp;
    }

}
