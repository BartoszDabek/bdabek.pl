package com.bdabek.abstractfactory;

import com.bdabek.abstractfactory.model.*;

public class MagicalMapFactory implements MapFactory {
    @Override
    public Nexus createNexus() {
        return new MagicalNexus();
    }

    @Override
    public Forest createForest() {
        return new MagicalForest();
    }

    @Override
    public Lane createLane() {
        return new MagicalLane();
    }
}
