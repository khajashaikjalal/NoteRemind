package com.khaja.noteremind.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.khaja.noteremind.worker.ReminderWorker
import com.khaja.noteremind.vm.NoteViewModel
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(vm: NoteViewModel, onBack: () -> Unit) {

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var minutesStr by remember { mutableStateOf("") }

    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Add Note") }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Content") },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 100.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = minutesStr,
                onValueChange = { minutesStr = it },
                label = { Text("Reminder Minutes (optional)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val mins = minutesStr.toLongOrNull()

                    vm.addNote(
                        title = title,
                        content = content,
                        reminderMinutes = mins
                    )

                    if (mins != null && mins > 0) {
                        val data = Data.Builder()
                            .putString("title", title)
                            .putString("content", content)
                            .build()

                        val req = OneTimeWorkRequestBuilder<ReminderWorker>()
                            .setInitialDelay(mins, TimeUnit.MINUTES)
                            .setInputData(data)
                            .build()

                        WorkManager.getInstance(context).enqueue(req)
                    }

                    onBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save")
            }
        }
    }
}
