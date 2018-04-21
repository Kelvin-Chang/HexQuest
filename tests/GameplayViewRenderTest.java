//import Controller.Input.ViewController;
//import Controller.Renderer;
//import Model.Zone.World;
//import javafx.stage.Stage;
//import org.junit.Test;
//import org.testfx.framework.junit.ApplicationTest;
//
//
//public class GameplayViewRenderTest extends ApplicationTest {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        // Set up window and view
//        ViewController viewController = new ViewController();
//        viewController.displayStage(primaryStage);
//        viewController.switchToGamePlayView();
//
//        // Establish world
//        World world = new World();
//
//        // Create renderer
////        Renderer renderer = new Renderer(world);
//
//        // create map, 0's are grass, 1's are mountain, initialized with all 0's
//        int[][] map = new int[10][10];
//
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                map[i][j] = 0;
//            }
//        }
//
//        // renders the map
//        // EXPECTED: 10 x 10 set of grass tiles
////        renderer.render(map);
//
//        threadSleep();
//
//        map[5][5] = 1;
//
//        // re-renders the map
//        // EXPECTED: 10 x 10 set of tiles, all grass except point(5,5)
////        renderer.render(map);
//
//        threadSleep();
//
//    }
//
//
//    // Used for leaving the view up to see results
//
//    @Test
//    public void threadSleep() throws InterruptedException {
//        sleep(5000);
//    }
//}
