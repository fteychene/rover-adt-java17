package xyz.fteychene.adt;

import xyz.fteychene.adt.command.*;
import xyz.fteychene.adt.state.Moving;

import static xyz.fteychene.adt.RoverCommands.*;
import static xyz.fteychene.adt.command.Move.Move;
import static xyz.fteychene.adt.command.Start.Start;
import static xyz.fteychene.adt.command.Stop.Stop;
import static xyz.fteychene.adt.command.Turn.Turn;

public class Main {

    private static void display(Command<?, ?> command) {
        switch (command) {
            case Turn t -> System.out.println("Turn on " + t.direction());
            case Move m -> System.out.println("Move of " + m.steps());
            case Chain chain -> {
                display(chain.a());
                display(chain.b());
            }
            case Start start -> System.out.println("Start");
            case Stop stop -> System.out.println("Stop");
        }
    }

    private static void displayMoving(Command<Moving, ?> command) {
        switch (command) {
            case Move m -> System.out.println("Move of " + m.steps());
            case Stop stop -> System.out.println("Stop");
            case Chain chain -> {
                display(chain.a());
                display(chain.b());
            }
            // Sad cause we can't know it at compile time but "pattern matching" can't tell it ATM
            default -> throw new UnsupportedOperationException("Unsupported value : " + command);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Display ===");
        display(Turn(Direction.NORTH));
        display(Move(5));

        System.out.println("=== Display moving ===");
        displayMoving(Move(5));
//        displayMoving(Turn(Direction.NORTH)); will not compile cause Turn is Command<Idle, Idle>


        System.out.println("=== Compose ===");
        display(new RoverDSL<>(Turn(Direction.NORTH))
                .then(Start())
                .then(Move(5))
//                .then(Turn(Direction.SOUTH)) will not compile cause previous Command is Command<Moving, Moving> and Turn is Command<Idle, Idle>
                .then(Stop())
                .command());

        System.out.println("=== Compose bis===");
        display(move(stop(move(start(Turn(Direction.NORTH)), 5)), Direction.SOUTH, 10));
    }
}
