Readify 📚

Readify is a modern, high-performance e-book application built with **Jetpack Compose**. Developed as a showcase of professional Android engineering, it provides a seamless interface for students to access cloud-hosted educational resources.

🛠 Technical Architecture
This project is built using **Clean Architecture** and **SOLID principles** to ensure scalability and maintainability.
* **UI Layer**: 100% Jetpack Compose using the **MVVM (Model-View-ViewModel)** pattern for state-driven UI.
* **Domain Layer**: Clean separation of business logic, utilizing **Kotlin Coroutines and Flow** for reactive data streams.
* **Data Layer**: Abstracted through the **Repository Pattern**, handling data synchronization with **Firebase Realtime Database**.
* **Dependency Injection**: Powered by **Dagger Hilt** to manage object lifecycles and facilitate modularity.

🚀 Key Features
- **Dynamic Resource Fetching**: Real-time synchronization with Firebase for up-to-date book categories.
- **Optimized PDF Engine**: Integrated [Bouquet](https://github.com/Grizzi91/Bouquet) for smooth, high-resolution vertical reading.
- **Cloud-Asset Management**: Optimized APK size by offloading heavy PDF assets to Google Drive, fetched dynamically via secure direct links.
- **Dagger Hilt Integration**: Production-grade dependency management for better testability and cleaner code.
- **Async Image Loading**: Efficient book cover rendering using **Coil**.

🏗 Project Structure (Clean Architecture)
com.adarsh.readify
├── di              # Dagger Hilt Modules
├── data            # Repository implementations & Data Sources (Firebase)
├── domain          # Models & Business Logic
└── ui
    ├── theme       # Material 3 Design System
    ├── components  # Reusable UI elements
    └── screens     # Composable screens & ViewModels

📸 Screenshots
 <table style="width: 100%; border-collapse: collapse; border: none;">
  <tr>
    <td align="center" style="border: none;"><img src="![Home](https://github.com/user-attachments/assets/8308812c-0e30-4bae-9a30-3fc060911d4e)
" width="350px"/></td>
    <td align="center" style="border: none;"><img src="![CategoryMain](https://github.com/user-attachments/assets/dfbb3cbf-0635-4397-a4f9-ad3e64c448a1)
" width="350px"/></td>
  </tr>
  <tr>
    <td align="center" style="border: none;"><img src="![Books](https://github.com/user-attachments/assets/67a74caf-7ba3-440c-8e56-61687358441f)
" width="350px"/></td>
    <td align="center" style="border: none;"><img src="![Category](https://github.com/user-attachments/assets/15b8bbc4-c4af-4ce3-bae8-03f22131cb46)
" width="350px"/></td>
  </tr>
  <tr>
    <td align="center" style="border: none;"><img src="![Drawer](https://github.com/user-attachments/assets/05109804-b02a-445d-9144-0f7d012f7c74)
" width="350px"/></td>
   <td colspan="2" align="center" style="border: none;"><img src="![Welcom](https://github.com/user-attachments/assets/8f05bb87-2f23-444f-93f5-0bff1ba8871b)
" width="350px"/></td>
  </tr>
</table>
