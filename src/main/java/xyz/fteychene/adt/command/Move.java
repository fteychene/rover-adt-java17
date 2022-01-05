package xyz.fteychene.adt.command;

import xyz.fteychene.adt.state.Moving;

public record Move(Integer steps) implements Command<Moving, Moving> {

    public static Move Move(Integer steps) {
        return new Move(steps);
    }
}
