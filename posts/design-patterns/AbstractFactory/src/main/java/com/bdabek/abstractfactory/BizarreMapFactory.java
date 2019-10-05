package com.bdabek.abstractfactory;

import com.bdabek.abstractfactory.model.*;

public class BizarreMapFactory implements MapFactory {
    @Override
    public Nexus createNexus() {
        return new MagicalNexus();
    }

    @Override
    public Forest createForest() {
        return new WinterForest();
    }

    @Override
    public Lane createLane() {
        return new StandardLane();
    }
}
