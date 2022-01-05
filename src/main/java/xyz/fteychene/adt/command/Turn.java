package xyz.fteychene.adt.command;

import xyz.fteychene.adt.Direction;
import xyz.fteychene.adt.state.Idle;

public record Turn(Direction direction) implements Command<Idle, Idle> {

    public static Turn Turn(Direction direction) {
        return new Turn(direction);
    }
}
