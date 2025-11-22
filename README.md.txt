# NoteRemind

NoteRemind is a simple Android app built using **Kotlin + Jetpack Compose** that allows you to:

- Create notes (title + content)
- Set optional **reminders** that notify you after a delay
- Store notes locally using **Room Database**
- Use **WorkManager** to schedule background notification tasks
- Follow clean MVVM architecture

This project was built as a demonstration of Android fundamentals: Compose UI, Room, ViewModel, Repository pattern, WorkManager, and Notification handling (Android 13+).

---

## ✨ Features

- 📝 Add notes  
- 🔔 Set reminder in minutes  
- 💾 Offline persistence (Room)  
- 🔄 MVVM architecture  
- 🎨 Modern UI using Jetpack Compose (Material 3)  
- ⚙️ WorkManager one-time background tasks  
- 🗑 Delete notes  

---

## 🛠️ Tech Stack

- **Kotlin**
- **Jetpack Compose (Material3)**
- **Room (2.6.1)**
- **WorkManager (2.8.1)**
- **ViewModel + StateFlow**
- **Coroutines**

---

## 🚀 How to Run

1. Clone the repo  
2. Open in **Android Studio**  
3. Run `Sync Project with Gradle Files`  
4. Build & Run on emulator or device  
5. On Android 13+ → allow **Notification Permission**  

---

## 📸 Screenshots

### 📝 Notes List Screen
![List Screen](screenshots/list.png)

### ➕ Add Note Screen
![Add Screen](screenshots/add.png)

### 🔔 Reminder Notification
![Notification](screenshots/notification.png)

---

## 📂 Project Structure


com.khaja.noteremind
┣ data
┃ ┣ Note.kt
┃ ┣ NoteDao.kt
┃ ┣ NoteDatabase.kt
┃ ┗ NoteRepository.kt
┣ ui
┃ ┣ AddNoteScreen.kt
┃ ┣ NoteListScreen.kt
┃ ┗ AppNavHost.kt
┣ vm
┃ ┗ NoteViewModel.kt
┣ worker
┃ ┗ ReminderWorker.kt
┗ MainActivity.kt



---

## 📌 Notes

- Reminder Worker uses:
  - Input Data → title, content  
  - Delay → user-selected minutes  
- Notification icon: `res/drawable/ic_notification.xml`
- Works on Android 6.0+  
- Requires **POST_NOTIFICATIONS** on Android 13+  

---

## 🤝 Contributing

Feel free to fork, open issues, or submit PRs.

---

## 📄 License

This project is open-source and free to use for learning.