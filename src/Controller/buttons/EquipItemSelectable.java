package Controller.buttons;

import Controller.Input.ViewController;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Inventory;
import javafx.event.ActionEvent;

public class EquipItemSelectable extends Selectable{

    private ViewController viewController;
    private Inventory inventory;
    private int unequipItem;
    private CharacterEntity character;

    public EquipItemSelectable(String name, ViewController viewController, int unequipItem, CharacterEntity character) {
        super(name);
        this.viewController = viewController;
        this.character = character;
        this.inventory = character.getInventory();
        this.unequipItem = unequipItem;
    }

    @Override
    public void handle(ActionEvent event) {

        // TODO: functionality


        viewController.switchToInventoryView();
    }

}
