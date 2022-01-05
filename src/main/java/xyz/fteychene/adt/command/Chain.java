package xyz.fteychene.adt.command;

public record Chain<A, B, C>(Command<A, B> a, Command<B, C> b) implements Command<A, C> {
}
