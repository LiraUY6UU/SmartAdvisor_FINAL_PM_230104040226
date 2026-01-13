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

## 📸 Screenshots

| Login Screen | Student Dashboard | Booking Form | Advisor Dashboard |
|:---:|:---:|:---:|:---:|
| <img src=![login](https://github.com/user-attachments/assets/dec02894-6c2f-4e42-9067-1f2f43ccf92a) width="220" /> | <img src=![student_dash](https://github.com/user-attachments/assets/2ec97c36-1841-4dfb-8954-96a965d03184) width="220" /> | <img src=![booking](https://github.com/user-attachments/assets/b226138e-8aae-42da-a52e-9dcfff8b59af) width="220" /> | <img src=![advisor_dash](https://github.com/user-attachments/assets/8e0f637e-b8ad-421d-9fc2-357b4d91b106) width="220" /> |

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
*Lira Anggraini (230104040226) TI23A*
