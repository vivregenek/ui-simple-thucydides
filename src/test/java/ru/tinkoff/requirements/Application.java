package ru.tinkoff.requirements;

import net.thucydides.core.annotations.Feature;

public class Application {
    @Feature
    public class Payments {
        @Feature
        public class CommunalPayments{
            public class LocationAutoDetectTest {}
            @Feature
            public class ZkuMoscow{
                public class InvalidPayerCodeDDT{}
            }
        }
    }

    @Feature
    public class Cards {
    }
}