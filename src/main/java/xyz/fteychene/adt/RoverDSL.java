package xyz.fteychene.adt;

import xyz.fteychene.adt.command.*;
import xyz.fteychene.adt.state.Idle;

public class RoverDSL<A, B> {

    private final Command<A, B> current;

    public RoverDSL(Command<A, B> command) {
        this.current = command;
    }

    public <C> RoverDSL<A, C> then(Command<B, C> with) {
        return new RoverDSL<>(new Chain<>(current, with));
    }

    public Command<A, B> command() {
        return current;
    }

}
