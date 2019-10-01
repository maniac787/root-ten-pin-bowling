package ec.org.jobcity.bowling.core.util;

import com.opencsv.CSVReader;
import ec.org.jobcity.bowling.core.Player;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:maniac787@gmail.com">Roberto Chasipanta</a>
 */
public class ScoreReader {

    private static final ScoreReader SCORE_READER = new ScoreReader();

    public List<Player> readScore() throws IOException {
        List<Player> playerList = new ArrayList<Player>();
        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(getClass().getClassLoader().getResource("score.csv").getFile());

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                Arrays.stream(nextRecord).map(cell -> cell.trim().split(" ")).forEach(nameScore -> {
                    try {
                        playerList.add(new Player(nameScore[0], new Integer(nameScore[1].trim())));
                    } catch (Exception e) {
                        playerList.add(new Player(nameScore[0], new Integer(0)));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return playerList;
    }

    public static ScoreReader instance() {
        return SCORE_READER;
    }
}
