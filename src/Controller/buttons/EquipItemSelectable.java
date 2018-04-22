package Controller.buttons;

import Controller.Input.ViewController;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Inventory;
import Model.Items.TakeableItems.EquippableItems.EquippableItem;
import Model.Items.TakeableItems.TakeableItem;
import javafx.event.ActionEvent;

public class EquipItemSelectable extends Selectable{

    private ViewController viewController;
    private Inventory inventory;
    private EquippableItem unequippedItem;
    private CharacterEntity character;

    public EquipItemSelectable(String name, ViewController viewController, EquippableItem unequippedItem, CharacterEntity character) {
        super(name);
        this.viewController = viewController;
        this.character = character;
        this.inventory = character.getInventory();
        this.unequippedItem = unequippedItem;
    }

    @Override
    public void handle(ActionEvent event) {

        // TODO: csating issue?
        inventory.equipItem(unequippedItem, character);
        viewController.switchToInventoryView();
    }

}
