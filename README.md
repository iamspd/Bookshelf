# 📚 Bookshelf

Bookshelf is an Android application built with **Kotlin** and **Jetpack Compose** that fetches and displays book images using the **Google Books API**. The app utilizes **Retrofit** for network calls, **ViewModel** for state management, and **Coil** for image loading.

## ✨ Features
- Fetches book data from the [Google Books API](https://www.googleapis.com/books/v1/volumes?q=jazz+history).
- Displays book covers using **Coil**.
- Uses **ViewModel** for state management.
- Implements **manual dependency injection**.
- Two different approaches to API requests:
  - **Main branch**: One implementation.
  - **Feature_v1 branch**: Alternative approach.

## 📷 Screenshots
<img src="https://github.com/user-attachments/assets/6f242005-47d2-4f61-8957-2a3b7cb1702a" alt="loading screen" style="width:25%; height:auto;">
<img src="https://github.com/user-attachments/assets/fb188cca-a637-4ffe-8628-80f5b513ea01" alt="main screen" style="width:25%; height:auto;">

## 🛠️ Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Retrofit** (Networking)
- **Coil** (Image Loading)
- **ViewModel**
- **Manual Dependency Injection**

## 🚀 Setup & Installation
1. Clone the repository:
   
   ```sh
   git clone https://github.com/your-username/bookshelf.git
   ```
3. Open the project in **Android Studio**.
4. Build and run the app on an emulator or physical device.

## 📌 Branches
- **`main`** - Contains one approach for fetching API data.
- **`feature_v1`** - Implements an alternative approach.

## 📜 License
This project is licensed under the **Apache 2.0 License**.

