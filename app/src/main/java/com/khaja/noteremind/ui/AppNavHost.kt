package com.khaja.noteremind.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khaja.noteremind.vm.NoteViewModel

@Composable
fun AppNavHost(vm: NoteViewModel) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "list") {
        composable("list") { NoteListScreen(vm = vm, onAdd = { nav.navigate("add") }) }
        composable("add") { AddNoteScreen(vm = vm, onBack = { nav.popBackStack() }) }
    }
}