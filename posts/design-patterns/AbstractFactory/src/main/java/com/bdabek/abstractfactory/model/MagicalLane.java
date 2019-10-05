package com.bdabek.abstractfactory.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MagicalLane implements Lane {
    @Override
    public void buildLane() {
        log.debug("Building Magical Lane");
    }
}
