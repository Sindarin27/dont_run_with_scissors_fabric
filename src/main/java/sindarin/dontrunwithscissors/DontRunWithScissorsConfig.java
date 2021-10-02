package sindarin.dontrunwithscissors;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = DontRunWithScissors.MOD_ID)
public class DontRunWithScissorsConfig implements ConfigData {
    public boolean runningDamage = false;
    public float damageAmount = 1.0f;

    @Override
    public void validatePostLoad() {
        damageAmount = Math.max(damageAmount, 0);
    }
}
