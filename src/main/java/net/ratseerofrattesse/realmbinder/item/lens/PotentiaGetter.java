package net.ratseerofrattesse.realmbinder.item.lens;

import net.minecraft.core.Position;
import net.ratseerofrattesse.realmbinder.component.PotentiaComponent;

public record PotentiaGetter(PotentiaComponent potentiaComponent, Double entityPotentia, Double entityCapacity, Position position) {
    public PotentiaGetter getPotentia(){
        return new PotentiaGetter(potentiaComponent, entityPotentia, entityCapacity, position);
    }
}
