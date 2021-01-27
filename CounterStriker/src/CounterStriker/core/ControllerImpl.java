package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.PlayerImpl;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl extends ExceptionMessages implements Controller{
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {

        if(type.equals("Pistol")) {
            guns.add(new Pistol(name, bulletsCount));
        } else if (type.equals("Rifle")) {
            guns.add(new Rifle(name, bulletsCount));
        } else {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        return String.format("Successfully added gun %s.", name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        if(type.equals("Terrorist")) {
            players.add(new Terrorist(username, health, armor, findGunByName(gunName)));
        } else if (type.equals("CounterTerrorist")) {
            players.add(new CounterTerrorist(username, health, armor, findGunByName(gunName)));
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        return String.format("Successfully added player %s.", username);
    }

    @Override
    public String startGame() {
        return field.start(players.getModels());
    }

    @Override
    public String report() {

        return players.getModels().toString();
    }

    private Gun findGunByName(String gunName) {
        Gun gun = (Gun) guns.findByName(gunName);
        if(gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        return gun;
    }
}
