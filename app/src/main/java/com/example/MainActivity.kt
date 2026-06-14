package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Attachment
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          containerColor = MaterialTheme.colorScheme.background,
          bottomBar = { BottomNavBar() }
        ) { innerPadding ->
          Box(modifier = Modifier.fillMaxSize()) {
            Column(
              modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            ) {
              TopAppBar()
              UsagePill()
              ChatArea(modifier = Modifier.weight(1f))
              InputArea()
            }
          }
        }
      }
    }
  }
}

@Composable
fun TopAppBar() {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(64.dp)
      .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4f))
      .padding(horizontal = 20.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Box(
        modifier = Modifier
          .size(32.dp)
          .clip(RoundedCornerShape(8.dp))
          .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.Default.Psychology,
          contentDescription = "Logo",
          tint = MaterialTheme.colorScheme.onPrimaryContainer,
          modifier = Modifier.size(20.dp)
        )
      }
      Spacer(modifier = Modifier.width(12.dp))
      Text(
        text = "PSYCHO AI",
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 2.sp,
        color = MaterialTheme.colorScheme.primary
      )
    }

    Box(
      modifier = Modifier
        .size(32.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.primaryContainer)
        .border(1.dp, Color.White.copy(alpha = 0.2f), CircleShape),
      contentAlignment = Alignment.Center
    ) {
      Icon(
        imageVector = Icons.Default.Person,
        contentDescription = "Profile",
        tint = MaterialTheme.colorScheme.onPrimaryContainer,
        modifier = Modifier.size(20.dp)
      )
    }
  }
}

@Composable
fun UsagePill() {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 16.dp, bottom = 8.dp),
    horizontalArrangement = Arrangement.Center
  ) {
    Row(
      modifier = Modifier
        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f), CircleShape)
        .border(1.dp, Color.White.copy(alpha = 0.05f), CircleShape)
        .padding(horizontal = 16.dp, vertical = 6.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(8.dp)
          .clip(CircleShape)
          .background(MaterialTheme.colorScheme.secondary)
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "2 OF 5 FREE CHATS REMAINING",
        fontFamily = FontFamily.Monospace,
        fontSize = 12.sp,
        letterSpacing = 1.sp,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
  }
}

@Composable
fun ChatArea(modifier: Modifier = Modifier) {
  val listState = rememberLazyListState()
  
  LazyColumn(
    state = listState,
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp),
    contentPadding = PaddingValues(vertical = 16.dp),
    verticalArrangement = Arrangement.spacedBy(24.dp)
  ) {
    item {
      AiMessageBubble(
        text = "Greetings. I am your neural assistant, optimized for complex problem-solving and psychological insight. How shall we expand your perspective today?"
      )
    }
    item {
      UserMessageBubble(
        text = "Analyze the correlation between creative blocks and digital over-saturation."
      )
    }
    item {
      AiMessageBubble(
        text = "Digital over-saturation creates a \"cognitive noise floor\" that prevents the default mode network from engaging in divergent thinking. By bombarding the visual cortex with pre-rendered stimuli, we outsource the imagination.",
        showActions = true
      )
    }
  }
}

@Composable
fun AiMessageBubble(text: String, showActions: Boolean = false) {
  Column(
    modifier = Modifier.fillMaxWidth(0.85f),
    horizontalAlignment = Alignment.Start
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(start = 4.dp, bottom = 8.dp)
    ) {
      Icon(
        imageVector = Icons.Default.Psychology,
        contentDescription = "AI",
        tint = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.size(16.dp)
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "PSYCHO AI",
        fontFamily = FontFamily.Monospace,
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.secondary
      )
    }
    
    Box(
      modifier = Modifier
        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 16.dp, bottomEnd = 16.dp, bottomStart = 16.dp))
        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
        .border(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), RoundedCornerShape(topStart = 4.dp, topEnd = 16.dp, bottomEnd = 16.dp, bottomStart = 16.dp))
        .padding(24.dp)
    ) {
      Column {
        Text(
          text = text,
          color = MaterialTheme.colorScheme.onSurface,
          fontSize = 16.sp,
          lineHeight = 24.sp
        )
        if (showActions) {
          Spacer(modifier = Modifier.height(16.dp))
          HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
          Spacer(modifier = Modifier.height(16.dp))
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ActionButton("Deep Dive", true)
            ActionButton("Practical Solutions", false)
          }
        }
      }
    }
  }
}

@Composable
fun ActionButton(text: String, isPrimary: Boolean) {
  Box(
    modifier = Modifier
      .clip(CircleShape)
      .border(
        1.dp,
        if (isPrimary) MaterialTheme.colorScheme.primary.copy(alpha = 0.4f) else Color.White.copy(alpha = 0.1f),
        CircleShape
      )
      .padding(horizontal = 12.dp, vertical = 6.dp)
  ) {
    Text(
      text = text,
      color = if (isPrimary) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
      fontFamily = FontFamily.Monospace,
      fontSize = 12.sp
    )
  }
}

@Composable
fun UserMessageBubble(text: String) {
  Box(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.CenterEnd
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.85f)
        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 4.dp, bottomEnd = 16.dp, bottomStart = 16.dp))
        .background(MaterialTheme.colorScheme.surfaceVariant)
        .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(topStart = 16.dp, topEnd = 4.dp, bottomEnd = 16.dp, bottomStart = 16.dp))
        .padding(24.dp)
    ) {
      Text(
        text = text,
        color = MaterialTheme.colorScheme.onSurface,
        fontSize = 16.sp,
        lineHeight = 24.sp
      )
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputArea() {
  var value by remember { mutableStateOf("") }
  
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 16.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.8f))
        .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
        .padding(8.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      IconButton(onClick = {}) {
        Icon(
          imageVector = Icons.Default.Attachment,
          contentDescription = "Attach",
          tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }
      
      TextField(
        value = value,
        onValueChange = { value = it },
        modifier = Modifier.weight(1f),
        placeholder = {
          Text(
            "TRANSMIT THOUGHT...",
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
            letterSpacing = 1.sp
          )
        },
        colors = TextFieldDefaults.colors(
          focusedContainerColor = Color.Transparent,
          unfocusedContainerColor = Color.Transparent,
          focusedIndicatorColor = Color.Transparent,
          unfocusedIndicatorColor = Color.Transparent,
          cursorColor = MaterialTheme.colorScheme.primary
        ),
        textStyle = androidx.compose.ui.text.TextStyle(
          fontFamily = FontFamily.Monospace,
          fontSize = 14.sp,
          color = MaterialTheme.colorScheme.onSurface
        ),
        singleLine = true
      )
      
      Box(
        modifier = Modifier
          .size(40.dp)
          .clip(RoundedCornerShape(8.dp))
          .background(MaterialTheme.colorScheme.primary)
          .shadow(15.dp, spotColor = MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.AutoMirrored.Filled.Send,
          contentDescription = "Send",
          tint = MaterialTheme.colorScheme.onPrimary,
          modifier = Modifier.size(20.dp)
        )
      }
    }
  }
}

@Composable
fun BottomNavBar() {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(64.dp)
      .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f))
      .border(1.dp, Color.White.copy(alpha = 0.05f)),
    horizontalArrangement = Arrangement.SpaceEvenly,
    verticalAlignment = Alignment.CenterVertically
  ) {
    BottomNavItem(icon = Icons.Default.ChatBubble, label = "CHAT", selected = true)
    BottomNavItem(icon = Icons.Outlined.History, label = "HISTORY", selected = false)
    BottomNavItem(icon = Icons.Outlined.Settings, label = "SETTINGS", selected = false)
  }
}

@Composable
fun BottomNavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, selected: Boolean) {
  val color = if (selected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Icon(
      imageVector = icon,
      contentDescription = label,
      tint = color,
      modifier = Modifier.size(24.dp)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
      text = label,
      fontFamily = FontFamily.Monospace,
      fontSize = 10.sp,
      color = color
    )
  }
}

