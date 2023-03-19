import org.junit.jupiter.api.*;

public class GameTest {
    Game manager = new Game();
    Player item1 = new Player("MOV", 40);
    Player item2 = new Player("LED", 75);
    Player item3 = new Player("GRO", 60);
    Player item4 = new Player("BJS", 60);
    Player item5 = new Player("FOL", 45);
    Player item6 = new Player("NYC", 30);

    @BeforeEach
    public void setup() {
        manager.register(item1);
        manager.register(item2);
        manager.register(item3);
        manager.register(item4);
        manager.register(item5);
        manager.register(item6);
    }

    @Test
    public void roundMOVToLEDTest() {

        int expected = 2;
        int actual = manager.round("MOV", "LED");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundLEDToMOVTest() {

        int expected = 1;
        int actual = manager.round("LED", "MOV");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundGROToBJSTest() {

        int expected = 0;
        int actual = manager.round("GRO", "BJS");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundNoFirstTORTest() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("TOR", "FOL");
        });
    }

    @Test
    public void roundNoSecondBTKTest() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("NYC", "BTK");
        });
    }

    @Test
    public void roundNoTORAndBTKTest() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("TOR", "BTK");
        });
    }

}