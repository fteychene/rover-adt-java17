package xyz.fteychene.adt.command;

import xyz.fteychene.adt.state.Idle;
import xyz.fteychene.adt.state.Moving;

public record Stop() implements Command<Moving, Idle> {

    public static final Stop object = new Stop();

    public static Stop Stop() {
        return object;
    }
}
