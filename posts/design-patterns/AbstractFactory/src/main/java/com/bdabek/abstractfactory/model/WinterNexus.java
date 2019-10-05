package com.bdabek.abstractfactory.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WinterNexus implements Nexus {
    @Override
    public void buildNexus() {
        log.debug("Building Winter Nexus");
    }
}
