package Controller.LoadSave;

import Controller.LoadSave.GameBuilder;
import Controller.LoadSave.GameLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLoaderTest {

    @Test
    void loadGame() {
        GameLoader gl = new GameLoader(new GameBuilder());

        gl.loadGame("resources/maps/map0.json");
    }

}