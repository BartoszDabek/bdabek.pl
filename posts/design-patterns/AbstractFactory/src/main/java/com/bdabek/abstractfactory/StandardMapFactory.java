package com.bdabek.abstractfactory;

import com.bdabek.abstractfactory.model.*;

public class StandardMapFactory implements MapFactory {
    @Override
    public Nexus createNexus() {
        return new StandardNexus();
    }

    @Override
    public Forest createForest() {
        return new StandardForest();
    }

    @Override
    public Lane createLane() {
        return new StandardLane();
    }
}
