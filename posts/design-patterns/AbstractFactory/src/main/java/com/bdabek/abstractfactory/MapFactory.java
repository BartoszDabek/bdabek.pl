package com.bdabek.abstractfactory;

import com.bdabek.abstractfactory.model.Forest;
import com.bdabek.abstractfactory.model.Lane;
import com.bdabek.abstractfactory.model.Nexus;

public interface MapFactory {
    Nexus createNexus();
    Forest createForest();
    Lane createLane();
}
