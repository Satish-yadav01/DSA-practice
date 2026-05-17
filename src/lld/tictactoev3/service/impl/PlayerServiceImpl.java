package lld.tictactoev3.service.impl;

import lld.tictactoev3.data.Move;
import lld.tictactoev3.model.Player;
import lld.tictactoev3.service.PlayerService;

import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

public class PlayerServiceImpl implements PlayerService {
    private final Queue<Player> players;
    private final Scanner scanner;

    public PlayerServiceImpl(Queue<Player> players) {
        this.players = players;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move play() {
        try {
            Thread.sleep(1000);
            System.out.printf("Player %s is Playing with Symbol %s%n", players.peek().getName(), players.peek().getSymbol());
            System.out.print("Please enter the x-coordinate : ");
            int x = scanner.nextInt();
            System.out.print("Please enter the y-coordinate : ");
            int y = scanner.nextInt();
            return new Move(x,y);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getCurrentPlayerName() {
        return players.peek().getName();
    }

    @Override
    public char getCurrentPlayerSymbol() {
        return players.peek().getSymbol();
    }

    @Override
    public int getCurrentPlayerId() {
        return players.peek().getId();
    }

    @Override
    public Optional<Player> getPlayerById(int id) {
        return players.stream()
                .filter(player -> player.getId() == id)
                .findFirst();
    }

    @Override
    public Player poll(){
        return players.poll();
    }

    @Override
    public boolean offer(Player player){
        return players.offer(player);
    }

    @Override
    public Player getCurrentPlayer(){
        return players.peek();
    }

    @Override
    public void switchPlayer() {
        try {
            Player polledPlayer = poll();
            offer(polledPlayer);
            System.out.printf("\nPlayer has switched now with %s with symbol %s\n",
                                getCurrentPlayerName(),getCurrentPlayerSymbol());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
