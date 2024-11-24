import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.Board
import model.BoardCell
import model.CellType

@Composable
fun BoardView(
    board: Board,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.then(Modifier.fillMaxSize().border(
            border = BorderStroke(1.dp, BoardStyle.Colors.border)
        ).padding(1.dp))
    ) {
        board.cells.forEach { row ->
            Row(Modifier.weight(1f)) {
                row.forEach {
                    BoardCellView(it)
                }
            }
        }
    }
}

@Composable
fun RowScope.BoardCellView(boardCell: BoardCell) {
    Box(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(boardCell.toStyle())
            .border(border = BorderStroke(1.dp, BoardStyle.Colors.border)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = boardCell.toText(),
            fontSize = 10.sp
        )
    }
}

fun BoardCell.toStyle() = when (type) {
    CellType.Normal -> BoardStyle.Colors.normal
    CellType.LetterTimes2 -> BoardStyle.Colors.letterTimes2
    CellType.LetterTimes3 -> BoardStyle.Colors.letterTimes3
    CellType.WordTimes2 -> BoardStyle.Colors.wordTimes2
    CellType.WordTimes3 -> BoardStyle.Colors.wordTimes3
    CellType.Start -> BoardStyle.Colors.start
}

fun BoardCell.toText() = when (type) {
    CellType.Normal -> ""
    CellType.LetterTimes2 -> "Letter x2"
    CellType.LetterTimes3 -> "Letter x3"
    CellType.WordTimes2 -> "Word x2"
    CellType.WordTimes3 -> "Word x3"
    CellType.Start -> "*"
}

object BoardStyle {

    object Colors {
        val border = Color(0xff757575)
        val start = Color(0xffffeb3b)
        val normal = Color(0xfff0f4c3)
        val letterTimes2 = Color(0xffafb42b)
        val letterTimes3 = Color(0xff03a9f4)
        val wordTimes2 = Color(0xffff9800)
        val wordTimes3 = Color(0xffd32f2f)
    }
}
