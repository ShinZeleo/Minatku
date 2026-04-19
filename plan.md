1. Project Identity

Project Name:
CaseBased3

Package Name:
com.example.casebased3

Platform:
Android (Native)

Language:
Java

Minimum SDK:
API 25 (Android 7.1.1)

Build System:
Gradle (Groovy DSL)

2. Objective (Technical Scope)

Aplikasi harus mengimplementasikan seluruh konsep berikut:

UI Components:
TextView
EditText
Button
CheckBox
RadioGroup
Spinner
Data & Logic:
Array (in-memory storage)
ListView (data display)
ArrayAdapter (binding data)
File (internal storage read/write)
Navigation:
Multi-Activity navigation
3. Hard Constraints (Non-Negotiable)

AI Agent WAJIB mengikuti:

Minimal 5 file Java:
MainActivity
FormActivity
ListActivity
FileHelper
DataModel
Minimal 5 file XML:
activity_main.xml
activity_form.xml
activity_list.xml
item_list.xml
dialog_result.xml
Tidak boleh:
Menggunakan Kotlin
Menggunakan RecyclerView (kecuali diminta)
Menggabungkan semua logic dalam 1 file
Mengubah struktur tanpa instruksi
4. System Architecture
4.1 Package Structure
com.example.casebased3
│
├── MainActivity.java
├── FormActivity.java
├── ListActivity.java
├── FileHelper.java
├── DataModel.java
4.2 Resource Structure
res/
 ├── layout/
 │    ├── activity_main.xml
 │    ├── activity_form.xml
 │    ├── activity_list.xml
 │    ├── item_list.xml
 │    ├── dialog_result.xml
4.3 Activity Flow
MainActivity
   ↓
FormActivity
   ↓
ListActivity
4.4 Data Flow (Detailed)
User Input (FormActivity)
    ↓
Validasi Input
    ↓
DataModel Object
    ↓
Convert ke String
    ↓
Simpan ke File (FileHelper)
    ↓
Ambil dari File
    ↓
ArrayList<String>
    ↓
ListView (ArrayAdapter)
5. Data Design
5.1 DataModel Structure
class DataModel {
    String nama;
    String gender;
    String hobi; // bisa multiple (gabung string)
}
5.2 Format Penyimpanan File

Gunakan format:

nama|gender|hobi

Contoh:

Zell|Laki-laki|Makan, Tidur
6. Detailed Feature Specification
6.1 MainActivity

Fungsi:

Entry point aplikasi
Navigasi ke FormActivity & ListActivity

Komponen UI:

TextView (judul)
Button:
"Input Data"
"Lihat Data"

Behavior:

Button → Intent ke activity lain
6.2 FormActivity

Komponen UI WAJIB:

EditText → input nama
RadioGroup → pilih gender
CheckBox → pilih hobi (minimal 2)
Spinner → tambahan pilihan (opsional tapi direkomendasikan)
Button → submit

Logic Detail:

1. Ambil Input
getText()
getCheckedRadioButtonId()
checkbox.isChecked()
2. Validasi
Nama tidak boleh kosong
Gender harus dipilih
3. Proses Data
Gabungkan hobi jadi string
Buat objek DataModel
Convert ke string format file
4. Simpan
Kirim ke FileHelper
5. Feedback
Tampilkan dialog / toast
6.3 ListActivity

Komponen UI:

ListView

Logic Detail:

Ambil data dari file
Simpan ke ArrayList
Set adapter:
ArrayAdapter<String>
Tampilkan ke ListView
6.4 FileHelper

Fungsi:

writeFile(context, data)
readFile(context)

Detail Implementasi:

Write:
MODE_APPEND
Gunakan FileOutputStream
Read:
BufferedReader
Return ArrayList<String>
6.5 DataModel

Fungsi:

Menyimpan struktur data
Optional: method toString()
7. AI Agent Execution Protocol
RULE 1 — Output Granularity

Setiap response:

Hanya 1 atau beberapa file (tidak semua sekaligus)
Harus lengkap
RULE 2 — Output Format (WAJIB)
File Name:
Path:
Code:
Explanation:
RULE 3 — No Assumption

AI tidak boleh:

Menebak ID komponen
Menghilangkan import
Memberikan pseudo-code
RULE 4 — Code Quality
Harus compile
Tidak ada syntax error
Import lengkap
8. Step-by-Step Execution Plan
STEP 1 — Generate Base Structure

Prompt:

Buat semua file Java dan XML kosong sesuai struktur plan.md
STEP 2 — MainActivity UI + Logic

Output:

activity_main.xml
MainActivity.java
STEP 3 — Form UI

Output:

activity_form.xml
STEP 4 — Form Logic

Output:

FormActivity.java
STEP 5 — DataModel

Output:

DataModel.java
STEP 6 — FileHelper

Output:

FileHelper.java
STEP 7 — List UI

Output:

activity_list.xml
item_list.xml
STEP 8 — List Logic

Output:

ListActivity.java
STEP 9 — Integration
Intent navigation
Manifest update
STEP 10 — Testing & Debugging
9. Error Handling Strategy

Jika error:

AI hanya fokus bagian error
Tidak rewrite semua file
Jelaskan:
Penyebab
Lokasi error
Solusi spesifik
10. Quality Checklist

Sebelum selesai:

Semua activity jalan
Tidak crash
Data tersimpan
Data tampil di ListView
Semua komponen UI muncul
11. Strict Enforcement Rules

AI DILARANG:

Skip step
Overengineering
Menggunakan library tambahan
Mengubah arsitektur

AI WAJIB:

Ikut urutan step
Konsisten
Detail
Tidak ambigu
12. Master Prompt (Untuk AI Agent)

Gunakan ini:

Ikuti plan.md ini secara ketat.

Rules:
- Jangan lompat step
- Jangan ubah struktur
- Output harus lengkap per file
- Tidak boleh ada error

Mulai dari STEP 1.