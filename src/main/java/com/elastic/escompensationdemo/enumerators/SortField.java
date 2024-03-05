package com.elastic.escompensationdemo.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortField {
    ID("id"),
    TIMESTAMP("timeStamp");

    private final String databaseFieldName;
}
