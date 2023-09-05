package com.github.bohunn.multiplestatestores.config;

import avro.ch.tkb.bde.*;

import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Helper {

    // constants
    public static final String TXT_JA = "ja";
    public static final String TXT_NEIN = "nein";
    public static final String PERSON_ADDR_TOPIC = "person-addr-joiner-input-topic";
    public static final String BP_ADDR_TOPIC = "bp-addr-joiner-input-topic";
    public static final String OBJECT_UPDATE_EVENT_TOPIC = "object-update-event-output-topic";
    public static final String PERSON_STATE_STORE_NAME = "person-state-store";
    public static final String BP_STATE_STORE_NAME = "bp-state-store";

    // helper methods

    public static boolean isEmittent(JoinedBpAddrV2 value) {
        long emittentCount = value.getRelationList().stream()
                .filter(relationItem -> relationItem.getRelationType().equals(RelationType.IO))
                .count();

        return emittentCount > 0;
    }

    public static boolean isRegisteredOwnerId(JoinedBpAddrV2 value, String key) {
        Long registeredOwnerId = value.getRelationList().stream()
                .filter(relationItem -> relationItem.getRelationType().equals(RelationType.RO))
                .map(RelationItem::getPersonObjId)
                .collect(toSingleton());

        return Objects.equals(registeredOwnerId, Long.valueOf(key));
    }

    public static ObjectUpdateEvent createObjectUpdateEvent(JoinedPersonAddrV2 personAddrV2, JoinedBpAddrV2 bpAddrV2) {
        return new ObjectUpdateEvent(
                (bpAddrV2 != null) ? EventObjType.FULL : EventObjType.PERSON_ONLY,
                (bpAddrV2 != null) ? bpAddrV2.getBpObjId() : null,
                (bpAddrV2 != null) ? bpAddrV2.getMainAddrId() : null,
                (bpAddrV2 != null) ? bpAddrV2.getMainAddresse() : null,
                (bpAddrV2 != null) ? bpAddrV2.getBpName() : null,
                (bpAddrV2 != null) ? bpAddrV2.getBpNr() : null,
                (bpAddrV2 != null) ? bpAddrV2.getCloseDate() : null,
                personAddrV2.getPersonName(),
                personAddrV2.getPersonNr(),
                personAddrV2.getCloseDate(),
                (personAddrV2.getNarilo()) ? TXT_JA : TXT_NEIN,
                (personAddrV2.getLegalHold()) ? TXT_JA : TXT_NEIN,
                (bpAddrV2 != null && bpAddrV2.getIsMa()) ? TXT_JA : TXT_NEIN,
                personAddrV2.getDomiAddrId(),
                personAddrV2.getAddrFull(),
                (bpAddrV2 != null && bpAddrV2.getIsBanklagernd()) ? TXT_JA : TXT_NEIN,
                (bpAddrV2 != null && bpAddrV2.getIsVip()) ? TXT_JA : TXT_NEIN,
                (personAddrV2.getIsBoeko()) ? TXT_JA : TXT_NEIN
        );
    }

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.isEmpty()) {
                        return null;
                    }
                    return list.get(0);
                }
        );
    }
}
