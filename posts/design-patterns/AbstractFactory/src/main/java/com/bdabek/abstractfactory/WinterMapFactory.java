package com.bdabek.abstractfactory;

import com.bdabek.abstractfactory.model.*;

public class WinterMapFactory implements MapFactory {
    @Override
    public Nexus createNexus() {
        return new WinterNexus();
    }

    @Override
    public Forest createForest() {
        return new WinterForest();
    }

    @Override
    public Lane createLane() {
        return new WinterLane();
    }
}
