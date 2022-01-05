package xyz.fteychene.adt.command;

import xyz.fteychene.adt.state.Idle;
import xyz.fteychene.adt.state.Moving;

public record Start() implements Command<Idle, Moving> {

    public static final Start object = new Start();

    public static Start Start() {
        return object;
    }
}
