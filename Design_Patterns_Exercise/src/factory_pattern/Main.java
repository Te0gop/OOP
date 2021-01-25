package factory_pattern;

import factory_pattern.factories.HeroFactoryImpl;

public class Main {
    public static void main(String[] args) {
        HeroFactoryImpl factory = new HeroFactoryImpl();
        factory.createHero("Rogue", "Luke", 10);
    }
}
