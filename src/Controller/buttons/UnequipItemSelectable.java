package Controller.buttons;

import Controller.Input.ViewController;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Inventory;
import javafx.event.ActionEvent;

public class UnequipItemSelectable extends Selectable {

    private ViewController viewController;
    private Inventory inventory;
    private int unequipItem;
    private CharacterEntity character;

    public UnequipItemSelectable(String name, ViewController viewController, int unequipItem, CharacterEntity character) {
        super(name);
        this.viewController = viewController;
        this.character = character;
        this.inventory = character.getInventory();
        this.unequipItem = unequipItem;
    }

    @Override
    public void handle(ActionEvent event) {

        // TODO: add proper functionality
        inventory.equipItem(inventory.getItemAtSlot(unequipItem), character);


        viewController.switchToInventoryView();
    }

}
