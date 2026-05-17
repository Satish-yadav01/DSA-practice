package lld.tictactoev3.service;

import lld.tictactoev3.data.Move;
import lld.tictactoev3.model.Player;

import java.util.Optional;

public interface PlayerService {
    Move play();
    String getCurrentPlayerName();
    char getCurrentPlayerSymbol();
    int getCurrentPlayerId();
    Optional<Player> getPlayerById(int id);
    Player poll();
    boolean offer(Player player);
    Player getCurrentPlayer();
    void switchPlayer();
}
