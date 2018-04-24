package Controller.buttons;

import Controller.Input.ViewController;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Inventory;
import Model.Items.TakeableItems.EquippableItems.EquippableItem;
import javafx.event.ActionEvent;

public class UnequipItemSelectable extends Selectable {

    private ViewController viewController;
    private Inventory inventory;
    private EquippableItem equippedItem;
    private CharacterEntity character;

    public UnequipItemSelectable(String name, ViewController viewController, EquippableItem equippedItem, CharacterEntity character) {
        super(name);
        this.viewController = viewController;
        this.character = character;
        this.inventory = character.getInventory();
        this.equippedItem = equippedItem;
    }

    @Override
    public void handle(ActionEvent event) {

        // TODO: add proper functionality
        inventory.unequipItem(equippedItem, character);
        System.out.println("Defense: " + character.getDefense());
        System.out.println("Mana: " + character.getMaxMana());
        viewController.switchToInventoryView();
    }

}
