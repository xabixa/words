package model

object LetterFactory {

    val startPool = listOf(
        Letter('k', 10),
        Letter('w', 10),
        Letter('x', 10),
        Letter('y', 10),
        Letter('z', 10),
        Letter('j', 8),
        Letter('q', 8),
    ) + (1..2).map {
        listOf(
            Letter('f', 4),
            Letter('h', 4),
            Letter('v', 4),
            Letter('b', 3),
            Letter('c', 3),
            Letter('p', 3),
            Letter('g', 2),
            Letter('J', 2),
        )
    } + (1..3).map {
        listOf(
            Letter('d', 2),
            Letter('m', 2),
        )
    } + (1..5).map {
        listOf(
            Letter('l', 1),
        )
    } + (1..6).map {
        listOf(
            Letter('n', 1),
            Letter('o', 1),
            Letter('r', 1),
            Letter('s', 1),
            Letter('t', 1),
            Letter('u', 1),
        )
    } + (1..8).map {
        listOf(
            Letter('i', 1),
        )
    } + (1..9).map {
        listOf(
            Letter('a', 1),
        )
    } + (1..15).map {
        listOf(
            Letter('e', 1),
        )
    }
}
