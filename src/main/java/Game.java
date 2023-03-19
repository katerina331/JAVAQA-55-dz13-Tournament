import java.util.*;

class Game {
    List<String> playerList = new ArrayList<>();
    Player[] players = new Player[0];

    public void register(Player player) {
        Player[] addPlayer = new Player[players.length + 1];

        for (int i = 0; i < players.length; i++) {
            addPlayer[i] = players[i];
        }
        playerList.add(player.getName());
        addPlayer[addPlayer.length - 1] = new Player(playerList.indexOf(player.getName()), player.getName(), player.getStrength());
        players = addPlayer;
    }

    public int round(String playerName1, String playerName2) {
        Player pl1 = null;
        Player pl2 = null;
        for (Player temp : players) {
            if (temp.getName().contains(playerName1))
                pl1 = temp;
            if (temp.getName().contains(playerName2))
                pl2 = temp;
        }
        if ((pl1 == null) && (pl2 == null))
            throw new NotRegisteredException(
                    playerName1 + " и " + playerName1 + " - Не зарегестрированы");
        if (pl1 == null)
            throw new NotRegisteredException(playerName1 + " - Не зарегестрирован");
        if (pl2 == null)
            throw new NotRegisteredException(playerName2 + " - Не зарегестрирован");

        if (pl1.getStrength() > pl2.getStrength()) return 1;
        else if (pl1.getStrength() < pl2.getStrength()) return 2;
        else return 0;
    }
}