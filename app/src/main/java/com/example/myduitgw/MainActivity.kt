package com.example.myduitgw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myduitgw.navigation.AppNavigation
import com.example.myduitgw.ui.theme.MyDuitGwTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyDuitGwTheme {
                AppNavigation()
            }
        }
    }
}