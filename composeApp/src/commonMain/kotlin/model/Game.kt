package model

class Game(
    private val board: Board,
    private val player1: Player,
    private val player2: Player,
) {

    private var player1Score: Int = 0
    private var player2Score: Int = 0

    private val history: MutableList<GameMove> = mutableListOf()
    private val lastMove: GameMove?
        get() {
            return history.lastOrNull()
        }

    fun move(move: GameMove) {
        if (move.player == player1) {
            player1Score += calculateScore(move.word)
        } else {
            player2Score += calculateScore(move.word)
        }
        history.add(move)
    }

    private fun calculateScore(word: Word): Int {
        return word.letters.fold(0) { acc, (cell, letter) ->
            acc + when (cell.type) {
                CellType.LetterTimes2 -> {
                    letter.score * 2
                }

                CellType.LetterTimes3 -> {
                    letter.score * 3
                }
                else -> letter.score
            }
        }.let { score ->
            when {
                word.letters.any {
                    it.first.type == CellType.WordTimes2 || it.first.type == CellType.Start
                } -> score * 2

                word.letters.any {
                    it.first.type == CellType.WordTimes3
                } -> score * 3

                else -> score
            }
        }
    }
}

data class Word(
    val letters: List<Pair<BoardCell, Letter>>,
)

data class GameMove(
    val player: Player,
    val word: Word,
)

data class Player(
    val name: String,
    val isFirstPlayer: Boolean,
)