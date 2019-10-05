package com.bdabek.abstractfactory.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StandardNexus implements Nexus {
    @Override
    public void buildNexus() {
        log.debug("Building Standard Nexus");
    }
}
