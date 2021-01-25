package factory_pattern.factories;

import factory_pattern.entities.BaseHero;
import factory_pattern.entities.Mage;
import factory_pattern.entities.Rogue;

public class HeroFactoryImpl implements HeroFactory{


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
