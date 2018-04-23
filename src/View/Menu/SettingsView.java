package View.Menu;

import Controller.Input.ViewController;
import Controller.LoadSave.ControllerConfigLoader;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Properties;

public class SettingsView extends AbstractView {

    private ViewController viewController;
    private final ControllerConfigLoader controllerConfigLoader = new ControllerConfigLoader();

    public SettingsView(ViewController viewController) {
        this.viewController = viewController;

        this.getChildren().add(borderPane(this));
    }

    private BorderPane borderPane(SettingsView settingsView) {
        BorderPane bp = new BorderPane();

        bp.setTop(topPane());
        bp.setCenter(gridPane(settingsView));

        //bp.setBottom(bottomPane());
        return bp;
    }

    private Text topPaneText() {
        Text t = new Text();
        t.setText("Settings");
        t.setFont(Font.font("Elephant", 50));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }

    private StackPane topPane() {
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1000,0);
        stackPane.setPadding(new Insets(10,10,10,10));
        stackPane.setAlignment(Pos.BOTTOM_CENTER);
        stackPane.getChildren().add(topPaneText());

        return stackPane;
    }

    private GridPane gridPane(SettingsView settingsView) {
        Properties properties = new Properties();
        try {
            properties = controllerConfigLoader.getControllerConfig();
        } catch (IOException e) {
            System.out.println(e);
        }
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10,10,10,10));
        for (int i = 0; i < 8; i++) {
            ColumnConstraints column = new ColumnConstraints(115);
            if (i == 0) {
                column = new ColumnConstraints(130);
            }
            gridpane.getColumnConstraints().add(column);
        }

        gridpane.add(new Label("Move Up Left: "), 0, 0);
        gridpane.add(generateTextField("MOVEUPLEFT", properties), 1, 0);
        gridpane.add(new Label("Move Up: "), 0, 1);
        gridpane.add(generateTextField("MOVEUP", properties), 1, 1);
        gridpane.add(new Label("Move Up Right: "), 0, 2);
        gridpane.add(generateTextField("MOVEUPRIGHT", properties), 1, 2);
        gridpane.add(new Label("Move Down Left: "), 0, 3);
        gridpane.add(generateTextField("MOVEDOWNLEFT", properties), 1, 3);
        gridpane.add(new Label("Move Down: "), 0, 4);
        gridpane.add(generateTextField("MOVEDOWN", properties), 1, 4);
        gridpane.add(new Label("Move Down Right: "), 0, 5);
        gridpane.add(generateTextField("MOVEDOWNRIGHT", properties), 1, 5);
        gridpane.add(new Label("Bind Wounds: "), 0, 6);
        gridpane.add(generateTextField("BINDWOUNDSSKILL", properties), 1, 6);
        gridpane.add(new Label("Bargain: "), 0, 7);
        gridpane.add(generateTextField("BARGAINSKILL", properties), 1, 7);
        gridpane.add(new Label("Observation: "), 0, 8);
        gridpane.add(generateTextField("OBSERVATIONSKILL", properties), 1, 8);
        gridpane.add(new Label("Toggle Camera: "), 0, 9);
        gridpane.add(generateTextField("TOGGLECAMERA", properties), 1, 9);
        gridpane.add(new Label("Camera Right: "), 0, 10);
        gridpane.add(generateTextField("CAMERARIGHT", properties), 1, 10);
        gridpane.add(new Label("Camera Up: "), 0, 11);
        gridpane.add(generateTextField("CAMERAUP", properties), 1, 11);
        gridpane.add(new Label("Camera Left: "), 0, 12);
        gridpane.add(generateTextField("CAMERALEFT", properties), 1, 12);
        gridpane.add(new Label("Camera Down: "), 0, 13);
        gridpane.add(generateTextField("CAMERADOWN", properties), 1, 13);
        Button setCommonCommands = new Button("Set Common Commands");
        setCommonCommands.setOnAction(new EventHandler() {
                @Override
                public void handle(Event event) {
                    Properties prop = new Properties();
                    try {
                        prop = controllerConfigLoader.getControllerConfig();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    ObservableList<Node> children = gridpane.getChildren();
                    for (int row = 0; row < 14; row++) {
                        for (Node node : children) {
                            if(gridpane.getRowIndex(node) == row && gridpane.getColumnIndex(node) == 1) {
                                TextField textField = (TextField) node;
                                prop.setProperty(textField.getPromptText(), textField.getText());
                            }
                        }
                    }
                    controllerConfigLoader.writeConfig(prop);
                }
        });
        gridpane.add(setCommonCommands, 0, 14, 2, 1);

        gridpane.add(new Label("Enchantment: "), 2, 0);
        gridpane.add(generateTextField("ENCHANTMENTSKILL", properties), 3, 0);
        gridpane.add(new Label("Boon: "), 2, 1);
        gridpane.add(generateTextField("BOONSKILL", properties), 3, 1);
        gridpane.add(new Label("Bane: "), 2, 2);
        gridpane.add(generateTextField("BANESKILL", properties), 3, 2);
        gridpane.add(new Label("Staff: "), 2, 3);
        gridpane.add(generateTextField("STAFFSKILL", properties), 3, 3);
        Button setSummonerCommands = new Button("Set Summoner Commands");
        setSummonerCommands.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Properties prop = new Properties();
                try {
                    prop = controllerConfigLoader.getControllerConfig();
                } catch (IOException e) {
                    System.out.println(e);
                }
                ObservableList<Node> children = gridpane.getChildren();
                for (int row = 0; row < 4; row++) {
                    for (Node node : children) {
                        if(gridpane.getRowIndex(node) == row && gridpane.getColumnIndex(node) == 3) {
                            TextField textField = (TextField) node;
                            prop.setProperty(textField.getPromptText(), textField.getText());
                        }
                    }
                }
                controllerConfigLoader.writeConfig(prop);
            }
        });
        gridpane.add(setSummonerCommands, 2, 14, 2, 1);

        gridpane.add(new Label("Brawl: "), 4, 0);
        gridpane.add(generateTextField("BRAWLSKILL", properties), 5, 0);
        gridpane.add(new Label("One Handed: "), 4, 1);
        gridpane.add(generateTextField("ONEHANDEDWEAPONSKILL", properties), 5, 1);
        gridpane.add(new Label("Two Handed: "), 4, 2);
        gridpane.add(generateTextField("TWOHANDEDWEAPONSKILL", properties), 5, 2);
        Button setSmasherCommands = new Button("Set Smasher Commands");
        setSmasherCommands.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Properties prop = new Properties();
                try {
                    prop = controllerConfigLoader.getControllerConfig();
                } catch (IOException e) {
                    System.out.println(e);
                }
                ObservableList<Node> children = gridpane.getChildren();
                for (int row = 0; row < 3; row++) {
                    for (Node node : children) {
                        if(gridpane.getRowIndex(node) == row && gridpane.getColumnIndex(node) == 5) {
                            TextField textField = (TextField) node;
                            prop.setProperty(textField.getPromptText(), textField.getText());
                        }
                    }
                }
                controllerConfigLoader.writeConfig(prop);
            }
        });
        gridpane.add(setSmasherCommands, 4, 14, 2, 1);

        gridpane.add(new Label("Pick-pocket: "), 6, 0);
        gridpane.add(generateTextField("PICKPOCKETSKILL", properties), 7, 0);
        gridpane.add(new Label("Remove Trap: "), 6, 1);
        gridpane.add(generateTextField("REMOVETRAPSKILL", properties), 7, 1);
        gridpane.add(new Label("Creep/Backstab: "), 6, 2);
        gridpane.add(generateTextField("CREEPSKILL", properties), 7, 2);
        gridpane.add(new Label("Ranged: "), 6, 3);
        gridpane.add(generateTextField("RANGEDWEAPONSKILL", properties), 7, 3);
        Button setSneakCommands = new Button("Set Sneak Commands");
        setSneakCommands.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Properties prop = new Properties();
                try {
                    prop = controllerConfigLoader.getControllerConfig();
                } catch (IOException e) {
                    System.out.println(e);
                }
                ObservableList<Node> children = gridpane.getChildren();
                for (int row = 0; row < 4; row++) {
                    for (Node node : children) {
                        if(gridpane.getRowIndex(node) == row && gridpane.getColumnIndex(node) == 7) {
                            TextField textField = (TextField) node;
                            prop.setProperty(textField.getPromptText(), textField.getText());
                        }
                    }
                }
                controllerConfigLoader.writeConfig(prop);
            }
        });
        gridpane.add(setSneakCommands, 6, 14, 2, 1);

        return gridpane;
    }

    private TextField generateTextField(String propertyName, Properties properties) {
        TextField textField = new TextField(properties.getProperty(propertyName));
        textField.setPromptText(propertyName);
        return textField;
    }
}
