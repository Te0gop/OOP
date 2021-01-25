package command_pattern.factories;

import command_pattern.entities.BaseHero;

public interface HeroFactory {
    BaseHero createHero(String clazz, String name, int level);
}
