# SmartAdvisor 🎓
**Aplikasi Bimbingan Akademik Digital Berbasis Android (Offline Beta)**

SmartAdvisor adalah aplikasi mobile yang dirancang untuk mempermudah proses konsultasi akademik antara Mahasiswa dan Dosen Wali. Aplikasi ini dibangun dengan pendekatan **Local-First** menggunakan Room Database, memungkinkan akses data nilai dan jadwal konsultasi tanpa ketergantungan internet (Offline Support).

---

## 📱 Fitur Utama (Key Features)

### 👨‍🎓 Role Mahasiswa (Student)
* **Dashboard Akademik:** Melihat ringkasan IPK dan progres studi dengan tampilan grafis modern.
* **Pengajuan Konsultasi:** Mengirim permintaan jadwal bimbingan kepada dosen wali.
* **Input Data:** Formulir pengajuan topik dan tanggal konsultasi yang interaktif.

### 👨‍🏫 Role Dosen (Advisor)
* **Monitoring:** Melihat daftar mahasiswa bimbingan.
* **Approval System:** Menerima (Approve) atau Menolak (Reject) pengajuan konsultasi mahasiswa secara real-time (lokal).
* **Status Tracking:** Memantau status setiap pengajuan (Pending, Approved, Rejected).

---

## 🛠️ Teknologi (Tech Stack)

Project ini dibangun menggunakan **Modern Android Development (MAD)** standards:

* **Language:** Kotlin 100%
* **UI Framework:** Jetpack Compose (Material Design 3)
* **Database:** Room Database (SQLite Local Storage)
* **Architecture:** MVVM (Model-View-ViewModel) Pattern
* **Navigation:** Jetpack Navigation Compose
* **Concurrency:** Kotlin Coroutines & Flow
  
---

## 🚀 Cara Menjalankan Aplikasi (How to Run)

Karena aplikasi ini adalah versi **Offline Beta**, tidak diperlukan koneksi ke server backend. Ikuti langkah ini untuk simulasi:

1.  **Clone & Build:** Clone repository ini dan buka di Android Studio (Koala/Jellyfish). Build project.
2.  **Initial Setup (PENTING):**
    * Saat aplikasi pertama kali dibuka, **Klik tombol "Setup Data Beta"** di bagian bawah layar Login.
    * Ini akan mengisi database lokal dengan data dummy (Akun Mahasiswa, Dosen, dan Nilai).

3.  **Login Credentials:**
    Gunakan akun berikut untuk menguji kedua role:

| Role | Username (NIM/NIP) | Password |
| :--- | :--- | :--- |
| **Mahasiswa** | `2301` | `123` |
| **Dosen** | `1980` | `123` |

---

## 📂 Struktur Project

```text
com.example.smartadvisor
├── data             # Layer Data (Room Entity, DAO, Database)
│   ├── AcademicRecordEntity.kt
│   ├── UserEntity.kt
│   └── SmartAdvisorDao.kt
├── ui               # Layer UI (Jetpack Compose)
│   ├── LoginScreen.kt
│   ├── StudentDashboard.kt    # Dashboard Mahasiswa
│   ├── AdvisorDashboard.kt    # Dashboard Dosen
│   ├── BookingScreen.kt       # Form Konsultasi
│   └── theme/                 # Styling & Color Palettes
└── MainActivity.kt  # Entry Point & Navigation Graph
```

---
## 📸 Screenshots

![student_dash](https://github.com/user-attachments/assets/8043ffb1-425c-49c1-9aa8-e2d5072583de)
![login](https://github.com/user-attachments/assets/48ac4212-d801-4520-a26b-84a762384d86)
![booking](https://github.com/user-attachments/assets/1b19489c-42ee-4db4-8eb8-8a32ca8cf46a)
![advisor_dash](https://github.com/user-attachments/assets/7a693d5c-202f-43c9-beeb-18da08a90255)


*Lira Anggraini (230104040226) TI23A*
