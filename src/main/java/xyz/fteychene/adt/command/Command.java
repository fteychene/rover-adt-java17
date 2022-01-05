package xyz.fteychene.adt.command;

public sealed interface Command<From, To> permits Move, Turn, Start, Stop, Chain {
}
