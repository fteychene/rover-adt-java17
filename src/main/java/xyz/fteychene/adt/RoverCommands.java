package xyz.fteychene.adt;

import xyz.fteychene.adt.command.*;
import xyz.fteychene.adt.state.Idle;
import xyz.fteychene.adt.state.Moving;

// Another way to have more flexibility but more verbose
public class RoverCommands {

    private static <A, B, C> Command<A, C> chain(Command<A, B> cmd1, Command<B, C> cmd2) {
        return new Chain<>(cmd1, cmd2);
    }

    public static <A> Command<A, Idle> turn(Command<A, Idle> cmd1, Direction direction) {
        return chain(cmd1, Turn.Turn(direction));
    }

    public static <A> Command<A, Moving> move(Command<A, Moving> cmd1, Integer steps) {
        return chain(cmd1, Move.Move(steps));
    }

    public static <A> Command<A, Moving> start(Command<A, Idle> cmd1) {
        return chain(cmd1, Start.Start());
    }

    public static <A> Command<A, Idle> stop(Command<A, Moving> cmd1) {
        return chain(cmd1, Stop.Stop());
    }

    public static <A> Command<A, Idle> move(Command<A, Idle> cmd1, Direction direction, Integer steps) {
        return stop(move(start(turn(cmd1, direction)), steps));
    }
}
