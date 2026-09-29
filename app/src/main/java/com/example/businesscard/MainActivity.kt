package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4) // ビジネスカードの薄緑色の背景
                ) {
                    CardApp()
                }
            }
        }
    }
}

@Composable
fun CardApp(modifier: Modifier = Modifier) {
    // 画面全体を縦に使い、中央にメイン情報、下部に連絡先を配置
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 中央：ロゴ・氏名・肩書（weight で中央領域を確保）
        MainCardContents(
            image = painterResource(R.drawable.android_logo),
            fullName = stringResource(R.string.full_name),
            title = stringResource(R.string.title),
            modifier = Modifier.weight(1f)
        )
//        // 下部：連絡先一覧
        DetailContents(
            modifier = Modifier.padding(bottom = 48.dp)
        )
    }
}

@Composable
fun MainCardContents(
    image: Painter,
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    val BrandNavy = Color(0xFF073042)
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        ImageContents(image = image)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .background(BrandNavy)
                .padding(12.dp)
                .size(100.dp)
        )
        Text(
            text = fullName,
            fontSize = 50.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006D3B)
        )
    }
}

//@Composable
//fun ImageContents(image: Painter, modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier
//            .background(color = Color(0xFF073042))
//            .padding(12.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = image,
//            contentDescription = null,
//            modifier = Modifier.size(100.dp)
//        )
//    }
//}

@Composable
fun DetailContents(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp) // 各行の上下間隔
    ) {
        PartsDetailContent(
            icon = Icons.Rounded.Phone,
            detail = "+81 (00) 000 0000"
        )
        PartsDetailContent(
            icon = Icons.Rounded.Share,
            detail = "@AndroidDev"
        )
        PartsDetailContent(
            icon = Icons.Rounded.Email,
            detail = "json@Android.Stadio"
        )
    }
}

@Composable
fun PartsDetailContent(
    icon: ImageVector,
    detail: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006D3B),
            modifier = Modifier.size(24.dp)
//            modifier = Modifier
//                .padding(16.dp)
        )
        Text(
            text = detail,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
//            color = Color(0xFFD2E8D4)
        ) {
            CardApp()
//            DetailContents()
        }
    }
}