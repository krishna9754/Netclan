import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assign.ui.screen.explore.component.EditText

@Composable
fun BusinessesCard() {
    Box(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 8.dp)
            .background(color = Color.White)
    ) {
        Text(
            text = "TG",
            modifier = Modifier
                .background(color = Color(0xffb8c5cd), shape = RoundedCornerShape(10.dp))
                .padding(12.dp),
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xff113e5c)
        )
        Column(
            modifier = Modifier
                .padding(start = 30.dp, top = 3.dp)
                .border(width = 1.dp, color = Color(0xffb8c5cd), shape = RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 55.dp, end = 20.dp, top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Tivoli Grand Resort Hotel",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color(0xff22333d)
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "Panipat, within 4.9 KM",
                    modifier = Modifier.padding(start = 36.dp, top = 2.dp),
                    color = Color(0xff445e6d),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .width(100.dp)
                            .padding(start = 36.dp, top = 3.dp),
                        progress = .25f,
                        color = Color(0xff74838f),
                        strokeCap = StrokeCap.Square
                    )
                    Text(text = "Profile Score - 18%", fontSize = 12.sp, color = Color(0xff7c8489))
                }
                Row(
                    modifier = Modifier.padding(start = 36.dp, top = 3.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "",
                        modifier = Modifier
                            .background(color = Color.Black, shape = CircleShape)
                            .size(25.dp)
                            .padding(5.dp),
                        tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.Person, contentDescription = "",
                        modifier = Modifier
                            .background(color = Color.Black, shape = CircleShape)
                            .size(25.dp)
                            .padding(5.dp),
                        tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.LocationOn, contentDescription = "",
                        modifier = Modifier
                            .background(color = Color.Black, shape = CircleShape)
                            .size(25.dp)
                            .padding(5.dp),
                        tint = Color.White
                    )
                }
                Text(
                    text = "Hi community! we have great deals for you Check us out!!",
                    modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
                    color = Color(0xff4e616f),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}