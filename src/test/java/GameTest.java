import org.junit.jupiter.api.*;

public class GameTest {
    Game manager = new Game();
    Player item1 = new Player(1, "MOV", 40);
    Player item2 = new Player(2, "LED", 75);
    Player item3 = new Player(3, "GRO", 60);
    Player item4 = new Player(4, "BJS", 60);
    Player item5 = new Player(5, "FOL", 45);
    Player item6 = new Player(6, "NYC", 30);

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