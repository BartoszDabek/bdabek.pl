package com.bdabek.abstractfactory.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MagicalForest implements Forest {
    @Override
    public void buildForest() {
        log.debug("Building Magical Forest");
    }
}
