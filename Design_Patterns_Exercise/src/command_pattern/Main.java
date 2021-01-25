package command_pattern;

import command_pattern.entities.BaseHero;
import command_pattern.factories.HeroFactoryImpl;
import command_pattern.skills.Invoker;

public class Main {
    public static void main(String[] args) {
        HeroFactoryImpl factory = new HeroFactoryImpl();
        BaseHero rogue = factory.createHero("Rogue", "Luke", 10);

        Invoker invoker = new Invoker();
        invoker.castSpell("Rogue");
        invoker.castSpell("Mage");
    }
}
