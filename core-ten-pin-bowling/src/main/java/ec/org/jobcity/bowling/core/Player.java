package ec.org.jobcity.bowling.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:maniac787@gmail.com">Roberto Chasipanta</a>
 */
public class Player {
    private String _playerName;
    private List<Integer> _firstBall = new ArrayList<Integer>();
    private List<Integer> _secondBall = new ArrayList<Integer>();
    private int _bonusBall;
    private int _playerScore;
    private int _bonusCounter;

    private Integer _score;

    // Sets player name
    public Player(String name) {
        _playerName = name;
    }


    public Player(String name, int score) {
        _playerName = name;
        _score = score;
    }

    // Gets player name
    public String getName() {
        return _playerName;
    }

    // Sets the first ball of a frame
    public void setFirstBall(int frame, int score) throws IOException {
        _firstBall.add(score);
    }

    // Gets the first ball of a frame
    public int checkFirstBall(int frame) {
        return _firstBall.get(frame);
    }

    // Sets the second ball of a frame
    public void setSecondball(int frame, int score) throws IOException {
        _secondBall.add(score);
    }

    // Gets the second ball of a frame
    public int checkSecondBall(int frame) {
        return _secondBall.get(frame);
    }

    // Sets the bonus balls for the last frame
    public void setBonusBall(int score) {
        _bonusBall = score;
    }

    // Gets the bonus ball of the last frame
    public int checkBonusBall() {
        return _bonusBall;
    }

    // Updates the player's total score
    public void setPlayerScore(int score) {
        _playerScore = _playerScore + score;
    }

    // Gets a player's total score
    public int checkPlayerScore() {
        return _playerScore;
    }

    // Sets a player's bonus counter
    public void setBonusCounter(int bonusCounter) {
        _bonusCounter = bonusCounter;
    }

    // Gets a player's bonus counter
    public int checkBonusCounter() {
        return _bonusCounter;
    }

    public Integer get_score() {
        return _score;
    }

    public void set_score(Integer _score) {
        this._score = _score;
    }
}
