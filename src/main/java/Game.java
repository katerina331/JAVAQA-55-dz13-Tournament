import java.util.*;

class Game {
    List<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player pl1 = null;
        Player pl2 = null;
        for (Player temp : playerList) {
            if (temp.getName().equals(playerName1)) {
                pl1 = temp;
            }
            if (temp.getName().equals(playerName2)) {
                pl2 = temp;
            }
        }
        if ((pl1 == null) && (pl2 == null)) {
            throw new NotRegisteredException(
                    playerName1 + " и " + playerName1 + " - Не зарегестрированы");
        }
        if (pl1 == null) {
            throw new NotRegisteredException(playerName1 + " - Не зарегестрирован");
        }
        if (pl2 == null) {
            throw new NotRegisteredException(playerName2 + " - Не зарегестрирован");
        }

        if (pl1.getStrength() > pl2.getStrength()) {
            return 1;
        } else if (pl1.getStrength() < pl2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}