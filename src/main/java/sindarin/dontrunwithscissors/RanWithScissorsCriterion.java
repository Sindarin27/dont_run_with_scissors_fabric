package sindarin.dontrunwithscissors;

import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class RanWithScissorsCriterion extends AbstractCriterion<RanWithScissorsCriterion.Conditions> {
    public final Identifier id;

    public RanWithScissorsCriterion(Identifier id) {
        this.id = id;
    }

    @Override
    protected Conditions conditionsFromJson(JsonObject obj, EntityPredicate.Extended playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        return new Conditions(this.id, playerPredicate);
    }

    @Override
    public Identifier getId() {
        return id;
    }

    public void trigger(ServerPlayerEntity player) {
        this.trigger(player, conditions -> true);
    }

    public static class Conditions extends AbstractCriterionConditions {

        public Conditions(Identifier id, EntityPredicate.Extended playerPredicate) {
            super(id, playerPredicate);
        }

        public static Conditions create() {
            return new Conditions(DontRunWithScissors.RAN_WITH_SCISSORS, EntityPredicate.Extended.EMPTY);
        }
    }

}
