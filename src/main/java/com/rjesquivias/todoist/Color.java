package com.rjesquivias.todoist;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Color {
    BERRY_RED("berry_red"),
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    OLIVE_GREEN("olive_green"),
    LIME_GREEN("lime_green"),
    GREEN("green"),
    MINT_GREEN("mint_green"),
    TEAL("teal"),
    SKY_BLUE("sky_blue"),
    LIGHT_BLUE("light_blue"),
    BLUE("blue"),
    GRAPE("grape"),
    VIOLET("violet"),
    LAVENDER("lavender"),
    MAGENTA("magenta"),
    SALMON("salmon"),
    CHARCOAL("charcoal"),
    GREY("grey"),
    TAUPE("taupe");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    static Color fromName(String name) {
        return Stream.of(Color.values())
            .filter(color -> color.name.equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Unknown color: " + name));
    }
}
