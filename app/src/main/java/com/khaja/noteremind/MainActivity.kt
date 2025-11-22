package com.khaja.noteremind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khaja.noteremind.ui.AppNavHost
import com.khaja.noteremind.ui.theme.NoteRemindTheme
import com.khaja.noteremind.vm.NoteViewModel
import android.Manifest
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // inside onCreate() before setContent { ... }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val requestPermissionLauncher = registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                // optional: you can log or show a toast if you want
            }
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        setContent {
            NoteRemindTheme {
                // obtain the AndroidViewModel from Compose
                val vm: NoteViewModel = viewModel()
                AppNavHost(vm = vm)
            }
        }
    }
}
