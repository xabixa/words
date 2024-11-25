package model

data class Board(
    val cells : List<List<BoardCell>>
) {

    fun getCellAt(position: Position): BoardCell {
        return cells.flatten().first { it.position == position }
    }
}

data class BoardCell(
    val position: Position,
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