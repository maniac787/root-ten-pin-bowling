package ec.org.jobcity.bowling.core;

import ec.org.jobcity.bowling.core.util.ScoreReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BowlingApp {
    public static void main(String[] args) throws IOException {
        /*
         * Initializes the list of players and welcomes the first player to the app
         */
        final BowlingSystem bowlingSystem = new BowlingSystem();
        List<Player> playerList = new ArrayList<Player>(); // A list of players

        String selection = "";
        String name;

        playerList.addAll(ScoreReader.instance().readScore());
        /*
         * Processes menu choices
         */

        bowlingSystem.mainMenu(); // Prints menu

        bowlingSystem.printPlayerInfo(playerList);

        Set<String> playerName = playerList.stream().map(Player::getName).collect(Collectors.toSet());
        /*
         * The game begins!
         * The final frame is executed separately because of special scoring requirements.
         */
        for (int i = 0; i < 9; i++) {
            System.out.println("\n>>> Frame " + (i + 1) + " begins now! <<<");

            for (Player player : playerList) {
                bowlingSystem.bowlFrame(player, i);
            }
        }

        // Play final frame
        System.out.println("\n>>> The Final Frame begins now! <<<");
        for (Player player : playerList) {
            bowlingSystem.bowlLastFrame(player, 9);
        }


        /*
         * Prints the final scoreboard
         */
        final ScoreBoard scoreboard = new ScoreBoard();
        scoreboard.printScores(playerList);
    }
}
