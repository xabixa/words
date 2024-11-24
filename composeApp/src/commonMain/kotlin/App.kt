import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.BoardFactory

@Composable
fun App() {
    MaterialTheme {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                BoardView(BoardFactory.emptyBoard)
                Spacer(Modifier.height(32.dp))
                Row {
                    Spacer(Modifier.weight(1f))
                    PlayerView()
                    Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                        Spacer(Modifier.width(32.dp))
                        Button({

                        }) {
                            Text("Play")
                        }
                    }
                }

            }
        }
    }
}
