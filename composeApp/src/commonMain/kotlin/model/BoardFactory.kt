package model

object BoardFactory {

    val emptyBoard: Board by lazy {
        Board(
            cells = let {
                (1..15).map { y ->
                    (1..15).map { x ->
                        BoardCell(
                            x = x,
                            y = y,
                            type = when (x to y) {
                                8 to 8 -> CellType.Start
                                in listOf(
                                    1 to 1, 1 to 8, 1 to 15,
                                    8 to 1, 8 to 15,
                                    15 to 1, 15 to 8, 15 to 15,
                                ) -> CellType.WordTimes3
                                in listOf(
                                    2 to 2, 3 to 3, 4 to 4, 5 to 5,
                                    2 to 14, 3 to 13, 4 to 12, 5 to 11,
                                    14 to 2, 13 to 3, 12 to 4, 11 to 5,
                                    14 to 14, 13 to 13, 12 to 12, 11 to 11,
                                ) -> CellType.WordTimes2
                                in listOf(
                                    2 to 6, 2 to 10,
                                    6 to 2, 6 to 6, 6 to 10, 6 to 14,
                                    10 to 2, 10 to 6, 10 to 10, 10 to 14,
                                    14 to 6, 14 to 10,
                                ) -> CellType.LetterTimes3
                                in listOf(
                                    1 to 4, 1 to 12,
                                    3 to 7, 3 to 9,
                                    4 to 1, 4 to 8, 4 to 15,
                                    7 to 3, 7 to 7, 7 to 9, 7 to 13,
                                    8 to 4, 8 to 12,
                                    9 to 3, 9 to 7, 9 to 9, 9 to 13,
                                    12 to 1, 12 to 8, 12 to 15,
                                    13 to 7, 13 to 9,
                                    15 to 4, 15 to 12,
                                ) -> CellType.LetterTimes2

                                else -> CellType.Normal
                            }
                        )
                    }
                }
            }
        )
    }
}