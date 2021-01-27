package CounterStriker.models.players;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

public abstract class PlayerImpl extends ExceptionMessages implements Player {

    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    public PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        isAlive = true;
        setGun(gun);
    }

    public void setUsername(String username) {
        if(username == null || username.trim().equals("")) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if(health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    public void setArmor(int armor) {
        if(armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setGun(Gun gun) {
        if(gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public Gun getGun() {
        return gun;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void takeDamage(int points) {

        if(armor - points < 0) {
            armor = 0;
            health -= points;
        } else {
            armor -= points;
        }
        if(health <= 0) {
            setAlive(false);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(": ")
                .append(getUsername())
                .append(System.lineSeparator())
                .append("--Health: ")
                .append(getHealth())
                .append(System.lineSeparator())
                .append("--Armor: ")
                .append(getArmor())
                .append(System.lineSeparator())
                .append("--Gun: ")
                .append(getGun())
                .append(System.lineSeparator());

        return sb.toString();
    }
}
