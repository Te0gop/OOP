package command_pattern.skills;

import java.util.HashMap;
import java.util.Map;

public class Invoker {

    private Map<String, ExecuteSkills> skills;

    public Invoker() {
        init();
    }

    public void castSpell(String clazz) {
        skills.get(clazz).execute();
    }
    private void init() {
        this.skills = new HashMap<>();
        this.skills.put("Rogue", new Ambush());
        this.skills.put("Mage", new Fireball());
    }
}
