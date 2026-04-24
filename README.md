# <img src="./release/logo.png" width="40" height="40"> MinatKu
**Sistem Personalisasi & Pengembangan Minat Mahasiswa**

## 📱 App Preview
Berikut adalah tampilan antarmuka aplikasi MinatKu:

<p align="center">
  <img src="./release/mockup_splash.png" width="250" />
  <img src="./release/mockup_form.png" width="250" />
</p>

MinatKu adalah aplikasi Android modern yang dirancang untuk membantu mahasiswa mengenali, mengelola, dan mengembangkan minat serta hobi mereka. Dengan pendekatan *data-driven*, aplikasi ini memberikan rekomendasi aktivitas dan jalur pengembangan yang dipersonalisasi untuk setiap individu.

## ✨ Fitur Utama

### 🧠 Core Intelligence
- **🎯 Recommendation Engine** — Saran aktivitas (Workshop, Komunitas, Lomba) yang relevan dengan minat & tujuan Anda.
- **🚀 Development Path Engine** — Panduan langkah-demi-langkah untuk mencapai potensi maksimal di bidang yang Anda pilih.
- **📝 Intelligent Summary** — Ringkasan profil otomatis menggunakan bahasa natural yang profesional.
- **📊 Insight Analyzer** — Analisis real-time tren minat di lingkungan mahasiswa.

### 📊 Visualisasi Data
- **Pie Chart** — Grafik distribusi minat mahasiswa yang interaktif dengan warna unik per kategori.
- **Bar Chart** — Statistik horizontal per semester untuk melihat pola akademik.
- Powered by [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart).

### ✨ Animasi & Transisi
- **Lottie Animations** — Animasi premium di Splash Screen dan Empty State.
- **Shared Element Transition** — Avatar & nama "terbang" secara mulus dari daftar ke halaman detail.
- **Slide Transitions** — Transisi slide halus untuk semua navigasi antar layar.

### 🏷️ Modern UX
- **Material Chips** — Filter Minat & Tujuan menggunakan chip yang bisa di-tap, menggantikan Spinner konvensional.
- **Dynamic Avatars** — Warna avatar berubah otomatis sesuai kategori minat (💻 Indigo, 🎨 Pink, 💼 Amber, 🤝 Green, 🏥 Red, 🔬 Cyan).
- **Emoji Indicators** — Ikon visual per minat untuk identifikasi cepat.

### ✅ Gamifikasi
- **Checklist Interaktif** — Centang setiap langkah di Jalur Pengembangan yang sudah Anda selesaikan.
- **Progress Bar** — Visualisasi progres "3/4 Langkah Selesai" secara real-time.
- **Persistensi** — Progres tersimpan permanen via SharedPreferences, tetap ada walau aplikasi ditutup.
- **Reset Progress** — Tombol reset untuk memulai ulang jejak pengembangan Anda.

### 🌙 Dark Mode
- **Palet Slate/Deep Blue** — Dark mode resmi dengan warna gelap yang elegan dan kohesif.
- **Auto-Switch** — Otomatis berubah mengikuti pengaturan sistem (DayNight theme).
- **Custom Drawables** — Semua elemen visual (card, gradient, avatar, badge) memiliki varian dark mode.

## 🎨 Color Palette

| Token | Light Mode | Dark Mode |
|---|---|---|
| Primary | `#6366F1` Indigo | `#818CF8` Indigo-400 |
| Background | `#F8FAFC` Slate-50 | `#0F172A` Slate-900 |
| Card | `#FFFFFF` White | `#1E293B` Slate-800 |
| Text Primary | `#0F172A` Slate-900 | `#F1F5F9` Slate-100 |
| Accent | `#0D9488` Teal | `#14B8A6` Teal-400 |

## 📥 Instalasi
Anda dapat mengunduh aplikasi MinatKu secara langsung melalui tautan di bawah ini:

| Sumber | Tautan Unduhan |
| --- | --- |
| **MediaFire (Latest)** | [Unduh Minatku.apk](https://www.mediafire.com/file/d9hw44cduoz7pem/Minatku.apk/file) |
| **GitHub Release** | [Minatku.apk](./release/Minatku.apk) |

## 🛠️ Tech Stack & Arsitektur

### Dependencies
| Library | Versi | Fungsi |
|---|---|---|
| Material Design 3 | 1.10.0 | UI Components, Chips, Cards |
| MPAndroidChart | v3.1.0 | Pie Chart & Bar Chart |
| Lottie | 6.4.0 | Animasi JSON Premium |
| AndroidX AppCompat | 1.6.1 | Backward Compatibility |

### Architecture
```
├── SplashActivity        → Animated splash screen (Lottie)
├── MainActivity          → Menu utama + data count
├── FormActivity          → Input/Edit profil mahasiswa
├── ListActivity          → Dashboard + Charts + Chips + List
└── DetailActivity        → Profil detail + Checklist gamifikasi

├── DataModel             → Model data mahasiswa
├── DataRepository        → File I/O & CRUD operations
├── FileHelper            → Low-level file management
├── InsightAnalyzer       → Statistik & distribusi data (chart-ready)
├── RecommendationEngine  → Rekomendasi berbasis minat × tujuan
└── DevelopmentPathEngine → Jalur pengembangan step-by-step
```

---
*Dikembangkan oleh [ShinZeleo](https://github.com/ShinZeleo) sebagai proyek Pemrograman Mobile.*
