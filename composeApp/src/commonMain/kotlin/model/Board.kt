package model

data class Board(
    val cells : List<List<BoardCell>>
)

data class BoardCell(
    val x: Int,
    val y: Int,
    val type: CellType,
)

enum class CellType {
    Normal,
    LetterTimes2,
    LetterTimes3,
    WordTimes2,
    WordTimes3,
    Start,
}
