package factory_pattern.factories;

import factory_pattern.entities.BaseHero;

public interface HeroFactory {
    BaseHero createHero(String clazz, String name, int level);
}
