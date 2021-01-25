package command_pattern.factories;

import command_pattern.entities.BaseHero;
import command_pattern.entities.Mage;
import command_pattern.entities.Rogue;

public class HeroFactoryImpl implements HeroFactory {


    @Override
    public BaseHero createHero(String clazz, String name, int level) {
        switch (clazz) {
            case "Rogue":
                return new Rogue(name, level);
            case "Mage":
                return new Mage(name, level);
            default:
                throw new IllegalArgumentException("Unknown hero");
        }

    }
}
