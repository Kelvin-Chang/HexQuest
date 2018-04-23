package View.Menu;

import Controller.Input.ViewController;
import Controller.buttons.*;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Inventory;
import Model.Entity.Character.Player;
import Model.Entity.Character.ShopKeep;
import Model.Items.TakeableItems.TakeableItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ShopkeeperView extends AbstractView {

    private ViewController viewController;
    private Inventory playerInventory;
    private Inventory shopkeeperInventory;
    private Button buyButton;
    private Button sellButton;
    private BorderPane borderPane;
    private TakeableItem playerItem;
    private TakeableItem shopkeeperItem;

    public ShopkeeperView(ViewController viewController, Player player, ShopKeep shopkeeper) {
        this.viewController = viewController;
        this.playerInventory = player.getInventory();
        this.shopkeeperInventory = shopkeeper.getInventory();

        borderPane = borderPane(player, shopkeeper);
    }

    private BorderPane borderPane(Player player, ShopKeep shopkeeper) {
        BorderPane bp = new BorderPane();

        bp.setTop(topPane());
        bp.setCenter(centerPane());
        bp.setBottom(bottomPane());
        bp.setLeft(leftPane());
        bp.setRight(rightPane());

        return bp;
    }



    private Text topPaneText() {
        Text t = new Text();
        t.setText("Inventory");
        t.setFont(Font.font("Elephant", 50));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }

    private Text topPaneBuySellText() {
        Text t = new Text();
        t.setText("Sell                                                                Buy");
        t.setFont(Font.font("Elephant", 16));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }

    private VBox topPane() {
        VBox vbox = new VBox();
        vbox.setPrefSize(1000,130);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().add(topPaneText());
        vbox.getChildren().add(topPaneBuySellText());

        return vbox;
    }

    private ArrayList<RadioButton> leftPaneRadioButtons() {

        ToggleGroup playerToggleGroup = new ToggleGroup();

        ArrayList<RadioButton> playerItemsButtons = new ArrayList<RadioButton>();

        TakeableItem[] playerItemsArray = playerInventory.getUnequippedItems();

        int numberOfPlayerItems = 0;

        for (int i = 0; i < playerInventory.getUnequippedItemBagSize(); i++) {
            if (playerItemsArray[i] != null) {
                numberOfPlayerItems++;
            }
        }

        int playerItemsArrayPosition = 0;

        for (int i = 0; i < numberOfPlayerItems; i++) {
            // create radio button
            RadioButton rb = new RadioButton();

            // give the radio button the item that is selected
            TakeableItem item = playerInventory.getItemAtSlot(i);
            rb.setUserData(item);
            rb.setText(playerItemsArray[i].getName());

            // set the button to the togglegroup to ensure that only one thing can be selected at a time
            rb.setToggleGroup(playerToggleGroup);

            // add the button to the arraylist to display them later
            playerItemsButtons.add(rb);
        }


        playerToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(newValue != null){
                    // TODO: see if it is possible to avoid casting
                    playerItem = (TakeableItem) playerToggleGroup.getSelectedToggle().getUserData();
                    refresh();
                    sellButton.setDisable(false);
                    System.out.println(playerItem.getName());
                }
            }
        });

        // No initially selected item

        return playerItemsButtons;
    }

    private VBox leftPane() {
        ArrayList<RadioButton> options = leftPaneRadioButtons();
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

    private ArrayList<RadioButton> rightPaneRadioButtons() {

        ToggleGroup shopkeeperToggleGroup = new ToggleGroup();

        ArrayList<RadioButton> shopkeeperItemsButtons = new ArrayList<RadioButton>();

        TakeableItem[] shopkeeperItemsArray = shopkeeperInventory.getUnequippedItems();

        int numberOfShopKeeperItems = 0;

        for (int i = 0; i < playerInventory.getUnequippedItemBagSize(); i++) {
            if (shopkeeperItemsArray[i] != null) {
                numberOfShopKeeperItems++;
            }
        }

        int shopkeeperItemsArrayPosition = 0;

        for (int i = 0; i < numberOfShopKeeperItems; i++) {
            // create radio button
            RadioButton rb = new RadioButton();

            // give the radio button the item that is selected
            TakeableItem item = shopkeeperInventory.getItemAtSlot(i);
            rb.setUserData(item);
            rb.setText(shopkeeperItemsArray[i].getName());

            // set the button to the togglegroup to ensure that only one thing can be selected at a time
            rb.setToggleGroup(shopkeeperToggleGroup);

            // add the button to the arraylist to display them later
            shopkeeperItemsButtons.add(rb);
        }


        shopkeeperToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(newValue != null){
                    // TODO: see if it is possible to avoid casting
                    playerItem = (TakeableItem) shopkeeperToggleGroup.getSelectedToggle().getUserData();
                    refresh();
                    buyButton.setDisable(false);
                    System.out.println(playerItem.getName());
                }
            }
        });

        // No initially selected item

        return shopkeeperItemsButtons;
    }

    private VBox rightPane() {
        ArrayList<RadioButton> options = rightPaneRadioButtons();
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

    private StackPane centerPane() {
        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(0);

        return stackPane;
    }

    private ArrayList<Selectable> bottomPaneButtons() {
        ArrayList<Selectable> options = new ArrayList<Selectable>() {{

            // TODO: ADD FUNCTIONALITY TO THE SELECTABLES AND CHANGE THE CONSTRUCTORS
            add(new BuyItemSelectable("Buy Item"));
            add(new SellItemSelectable("Sell Item"));

            add(new GameplayViewSelectable("Back to Game", viewController));
        }};

        return options;
    }



    private HBox bottomPane() {
        ArrayList<Selectable> options = bottomPaneButtons();

        HBox hbox = new HBox();
        hbox.setMaxHeight(300);

        hbox.setSpacing(20);
        hbox.setPrefSize(1000,72);
        hbox.setAlignment(Pos.TOP_CENTER);


        // doing all this manually instead of looping through the arraylist to temporarily disable the buttons until something is clicked
        buyButton = new Button(options.get(0).getName());
        buyButton.getStyleClass().add("button4");
        buyButton.setOnAction(options.get(0));
        buyButton.setDisable(true);

        sellButton = new Button(options.get(1).getName());
        sellButton.getStyleClass().add("button4");
        sellButton.setOnAction(options.get(1));
        sellButton.setDisable(true);

        Button exitButton = new Button(options.get(2).getName());
        exitButton.getStyleClass().add("button4");
        exitButton.setOnAction(options.get(2));


        hbox.getChildren().add(buyButton);
        hbox.getChildren().add(sellButton);
        hbox.getChildren().add(exitButton);

        return hbox;
    }











    private void refresh() {
        borderPane.setLeft(null);
        borderPane.setRight(null);
        borderPane.setBottom(null);

        borderPane.setLeft(leftPane());
        borderPane.setRight(rightPane());
        borderPane.setBottom(bottomPane());
    }


}
