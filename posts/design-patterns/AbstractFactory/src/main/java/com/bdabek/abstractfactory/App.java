package com.bdabek.abstractfactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    private void createMap(final MapFactory factory) {
        factory.createNexus().buildNexus();
        factory.createForest().buildForest();
        factory.createLane().buildLane();
    }

    public static class FactoryMaker {

        public enum MapType {
            STANDARD, WINTER, MAGICAL, BIZARRE
        }

        static MapFactory makeFactory(MapType type) {
            return switch (type) {
                case STANDARD -> new StandardMapFactory();
                case WINTER -> new WinterMapFactory();
                case MAGICAL -> new MagicalMapFactory();
                case BIZARRE -> new BizarreMapFactory();
            };
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.createMap(FactoryMaker.makeFactory(FactoryMaker.MapType.STANDARD));
        app.createMap(FactoryMaker.makeFactory(FactoryMaker.MapType.WINTER));
        app.createMap(FactoryMaker.makeFactory(FactoryMaker.MapType.MAGICAL));
        app.createMap(FactoryMaker.makeFactory(FactoryMaker.MapType.BIZARRE));
    }
}
