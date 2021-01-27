package CounterStriker.models.field;

import CounterStriker.models.players.Player;
import CounterStriker.repositories.PlayerRepository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FieldImpl implements Field{

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = new LinkedList<>();
        List<Player> counterTerrorists = new LinkedList<>();

        for (Player p : players) {
            if (p.getClass().getSimpleName().equals("Terrorist")) {
                terrorists.add(p);
            } else {
                counterTerrorists.add(p);
            }
        }

        while (true) {

            for (Player terrorist : terrorists) {
                for (Player counterTerrorist : counterTerrorists) {
                    if (counterTerrorist.isAlive()) {
                        counterTerrorist.takeDamage(terrorist.getGun().fire());
                    }
                }
            }
            for (Player counterTerrorist : counterTerrorists) {
                for (Player terrorist : terrorists) {
                    if (terrorist.isAlive()) {
                        terrorist.takeDamage(counterTerrorist.getGun().fire());
                    }
                }
            }


            int sumTerrorist = terrorists.stream().filter(i -> i.getHealth() >= 0).mapToInt(Player::getHealth).sum();
            int sumCounterTerrorist = counterTerrorists.stream().filter(i -> i.getHealth() >= 0).mapToInt(Player::getHealth).sum();

            if (sumTerrorist == 0) {
                return "Counter Terrorist wins!";
            } else if(sumCounterTerrorist == 0) {
                break;
            }
        }
        return "Terrorist wins!";
    }
}
