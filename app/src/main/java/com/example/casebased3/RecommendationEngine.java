package com.example.casebased3;

import java.util.Arrays;
import java.util.List;

public class RecommendationEngine {

    public static List<String> getRecommendations(DataModel user) {
        if (user == null) return Arrays.asList("Data tidak ditemukan.");

        String minat = user.getMinat() != null ? user.getMinat() : "";
        String tujuan = user.getTujuan() != null ? user.getTujuan() : "";

        switch (minat) {
            case "Teknologi":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur: Teknologi (Persiapan Karir)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat teknologi dengan tujuan akhir persiapan karir. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Pelajari dasar algoritma dan struktur data menggunakan Python atau Java.",
                            "Level 2: Kuasai framework populer seperti React, Flutter, atau Spring Boot.",
                            "Level 3: Bangun portofolio berupa 3 project berskala menengah.",
                            "Level 4: Persiapkan technical interview dan apply posisi Junior Developer.",
                            "Aktivitas: Selesaikan modul sertifikasi dari Coursera atau AWS.",
                            "Aktivitas: Bangun aplikasi manajemen tugas atau e-commerce sederhana.",
                            "Aktivitas: Buat repositori GitHub yang rapi beserta README yang jelas.",
                            "Aktivitas: Lakukan simulasi wawancara teknis (mock interview) bersama mentor.",
                            "Outcome: Siap melamar posisi Software Engineer atau IT Consultant dengan portofolio solid."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur: Teknologi (Pengembangan Skill)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat teknologi dengan tujuan akhir pengembangan skill. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Tentukan satu spesialisasi utama (misal: Backend, Frontend, Data).",
                            "Level 2: Pelajari arsitektur sistem dan konsep Clean Code.",
                            "Level 3: Eksplorasi teknologi mutakhir seperti Docker, CI/CD, atau AI.",
                            "Level 4: Refactor kode lama Anda agar sesuai standar industri.",
                            "Aktivitas: Terapkan design pattern pada kode yang sudah ada.",
                            "Aktivitas: Pelajari cara kerja REST API dan GraphQL.",
                            "Aktivitas: Publikasikan library atau package buatan sendiri ke npm/PyPI.",
                            "Aktivitas: Baca dokumentasi resmi dari teknologi yang sedang tren.",
                            "Outcome: Menguasai keterampilan teknis menengah hingga lanjutan untuk keunggulan teknis."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur: Teknologi (Sekadar Hobi)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat teknologi dengan tujuan akhir sekadar hobi. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Kenali dasar-dasar otomatisasi untuk mempermudah hidup.",
                            "Level 2: Buat skrip sederhana untuk mengatur file atau mengirim pesan otomatis.",
                            "Level 3: Eksperimen dengan perangkat keras seperti Raspberry Pi atau Arduino.",
                            "Level 4: Bangun proyek DIY (Do It Yourself) di rumah.",
                            "Aktivitas: Buat bot Telegram atau Discord sederhana.",
                            "Aktivitas: Pasang sistem smart home dasar menggunakan mikrokontroler.",
                            "Aktivitas: Kembangkan game indie 2D dengan Unity atau Godot.",
                            "Aktivitas: Coba rakit PC atau modifikasi perangkat keras lama.",
                            "Outcome: Mendapatkan hiburan yang produktif dan melatih logika tanpa tekanan kerja."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur: Teknologi (Mencari Komunitas)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat teknologi dengan tujuan akhir mencari komunitas. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Petakan komunitas teknologi lokal maupun daring (online) yang aktif.",
                            "Level 2: Rutin berpartisipasi dalam diskusi di forum atau grup Telegram/Discord.",
                            "Level 3: Mulai berkontribusi dalam proyek Open Source (repositori terbuka).",
                            "Level 4: Jadi pembicara atau relawan di acara teknologi (Tech Meetup).",
                            "Aktivitas: Bergabung dengan Google Developer Group (GDG) lokal.",
                            "Aktivitas: Ikuti ajang kompetisi Hackathon sebagai tim.",
                            "Aktivitas: Jawab pertanyaan pemula di StackOverflow atau grup Facebook.",
                            "Aktivitas: Adakan sesi belajar bareng sesama penggiat IT.",
                            "Outcome: Memiliki jaringan profesional dan pertemanan luas di dunia teknologi."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur: Teknologi (Umum)",
                            "Deskripsi: Anda belum menentukan tujuan spesifik. Panduan ini berfokus pada eksplorasi minat teknologi secara umum agar Anda bisa menemukan spesialisasi yang tepat.",
                            "Level 1: Pelajari wawasan dasar tentang teknologi secara luas.",
                            "Level 2: Kenali berbagai cabang atau spesialisasi di dalam bidang ini.",
                            "Level 3: Lakukan simulasi kegiatan dari satu cabang spesifik yang paling menarik.",
                            "Level 4: Tentukan satu tujuan utama (Karir, Hobi, Komunitas, atau Skill).",
                            "Aktivitas: Cari informasi mendasar dari artikel atau video edukasi kredibel.",
                            "Aktivitas: Evaluasi kekuatan dan kelemahan Anda di bidang teknologi.",
                            "Aktivitas: Berkonsultasilah dengan senior atau mentor yang berpengalaman.",
                            "Aktivitas: Susun daftar target spesifik yang ingin dicapai bulan ini.",
                            "Outcome: Mendapatkan gambaran besar dan kesiapan penuh untuk memilih spesialisasi teknologi."
                        );
                }
            case "Seni":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur: Seni (Persiapan Karir)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat seni dengan tujuan akhir persiapan karir. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Pahami prinsip dasar desain, nirmana, tipografi, dan komposisi warna.",
                            "Level 2: Kuasai perangkat lunak industri seperti Adobe Creative Suite atau Figma.",
                            "Level 3: Kerjakan proyek fiktif untuk melengkapi portofolio komersial.",
                            "Level 4: Tawarkan jasa freelance untuk membangun reputasi awal.",
                            "Aktivitas: Buat akun Behance atau Dribbble dan unggah 5 karya terbaik.",
                            "Aktivitas: Tawarkan desain logo atau banner gratis untuk UMKM lokal.",
                            "Aktivitas: Ikuti kursus UI/UX Design atau Graphic Design yang bersertifikat.",
                            "Aktivitas: Rapikan CV kreatif dan mulai kirimkan ke agensi periklanan.",
                            "Outcome: Siap bekerja secara profesional sebagai Desainer atau Art Director."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur: Seni (Pengembangan Skill)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat seni dengan tujuan akhir pengembangan skill. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Pelajari aliran seni yang belum pernah Anda coba sebelumnya.",
                            "Level 2: Analisis karya master dan coba replikasi tekniknya (Master Study).",
                            "Level 3: Eksperimen penggabungan teknik tradisional dan seni digital.",
                            "Level 4: Temukan gaya visual yang menjadi ciri khas (Signature Style) Anda.",
                            "Aktivitas: Lakukan tantangan menggambar 30 hari (misal: Inktober).",
                            "Aktivitas: Latih anatomi manusia dan perspektif ruang secara intensif.",
                            "Aktivitas: Minta kritik terbuka (constructive feedback) dari seniman senior.",
                            "Aktivitas: Ikuti kelas lanjutan mengenai teori warna dan pencahayaan.",
                            "Outcome: Peningkatan kualitas karya seni dengan teknik yang lebih matang dan berkarakter."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur: Seni (Sekadar Hobi)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat seni dengan tujuan akhir sekadar hobi. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Siapkan buku sketsa atau kanvas untuk corat-coret bebas tanpa aturan.",
                            "Level 2: Lakukan sesi menggambar santai sambil mendengarkan musik.",
                            "Level 3: Coba medium fisik seperti cat air, akrilik, atau tanah liat (pottery).",
                            "Level 4: Gunakan seni sebagai bentuk pelepasan stres (Art Therapy).",
                            "Aktivitas: Gambar pemandangan di taman kota atau kafe.",
                            "Aktivitas: Buat kerajinan tangan sederhana untuk dekorasi kamar.",
                            "Aktivitas: Ikuti sesi melukis santai (Sip and Paint) bersama teman.",
                            "Aktivitas: Tonton video restorasi karya seni atau proses melukis yang menenangkan.",
                            "Outcome: Mendapatkan ketenangan batin dan sarana ekspresi emosi yang positif."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur: Seni (Mencari Komunitas)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat seni dengan tujuan akhir mencari komunitas. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Cari organisasi seni kampus atau komunitas seniman lokal.",
                            "Level 2: Hadiri pameran seni, galeri, atau pertunjukan teater secara rutin.",
                            "Level 3: Berpartisipasi dalam proyek seni kolaboratif (misal: mural dinding kota).",
                            "Level 4: Jadilah inisiator pameran seni kolektif skala kecil.",
                            "Aktivitas: Bergabung dengan UKM Seni Rupa atau Teater.",
                            "Aktivitas: Ikut acara menggambar bersama di ruang publik (Urban Sketchers).",
                            "Aktivitas: Mengunjungi galeri lokal dan berdiskusi langsung dengan senimannya.",
                            "Aktivitas: Buat zine atau majalah seni independen bersama rekan sejawat.",
                            "Outcome: Tergabung dalam ekosistem kreatif yang saling mendukung dan menginspirasi."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur: Seni (Umum)",
                            "Deskripsi: Anda belum menentukan tujuan spesifik. Panduan ini berfokus pada eksplorasi minat seni secara umum agar Anda bisa menemukan spesialisasi yang tepat.",
                            "Level 1: Pelajari wawasan dasar tentang seni secara luas.",
                            "Level 2: Kenali berbagai cabang atau spesialisasi di dalam bidang ini.",
                            "Level 3: Lakukan simulasi kegiatan dari satu cabang spesifik yang paling menarik.",
                            "Level 4: Tentukan satu tujuan utama (Karir, Hobi, Komunitas, atau Skill).",
                            "Aktivitas: Cari informasi mendasar dari artikel atau video edukasi kredibel.",
                            "Aktivitas: Evaluasi kekuatan dan kelemahan Anda di bidang seni.",
                            "Aktivitas: Berkonsultasilah dengan senior atau mentor yang berpengalaman.",
                            "Aktivitas: Susun daftar target spesifik yang ingin dicapai bulan ini.",
                            "Outcome: Mendapatkan gambaran besar dan kesiapan penuh untuk memilih spesialisasi seni."
                        );
                }
            case "Bisnis":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur: Bisnis (Persiapan Karir)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat bisnis dengan tujuan akhir persiapan karir. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Pahami pilar bisnis: pemasaran, operasional, keuangan, dan SDM.",
                            "Level 2: Pelajari cara menyusun Business Model Canvas dan rencana bisnis yang solid.",
                            "Level 3: Terapkan ilmu melalui program magang di startup atau konsultan.",
                            "Level 4: Asah kemampuan presentasi bisnis (Pitching) untuk mencari pendanaan.",
                            "Aktivitas: Lakukan riset pasar mendalam untuk sebuah ide produk fiktif.",
                            "Aktivitas: Ikuti program Management Trainee atau inkubator bisnis.",
                            "Aktivitas: Bangun koneksi profesional di LinkedIn dengan para praktisi industri.",
                            "Aktivitas: Analisis studi kasus kegagalan dan kesuksesan perusahaan terkemuka.",
                            "Outcome: Siap menjadi Business Analyst, Entrepreneur, atau bekerja di ranah korporat."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur: Bisnis (Pengembangan Skill)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat bisnis dengan tujuan akhir pengembangan skill. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Pelajari dasar pemasaran digital (SEO, SEM, Social Media Ads).",
                            "Level 2: Kuasai teknik perhitungan proyeksi keuangan (Financial Modeling).",
                            "Level 3: Latih kemampuan negosiasi dan diplomasi dalam transaksi.",
                            "Level 4: Pelajari strategi manajemen risiko dan analisis data bisnis.",
                            "Aktivitas: Jalankan kampanye iklan kecil-kecilan di Facebook/Instagram Ads.",
                            "Aktivitas: Buat simulasi laporan laba-rugi untuk sebuah bisnis UMKM.",
                            "Aktivitas: Ikuti pelatihan public speaking dan negosiasi bisnis.",
                            "Aktivitas: Selesaikan sertifikasi Google Analytics atau HubSpot.",
                            "Outcome: Memiliki keterampilan manajerial dan teknis yang dapat diaplikasikan langsung ke bisnis."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur: Bisnis (Sekadar Hobi)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat bisnis dengan tujuan akhir sekadar hobi. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Biasakan membaca literatur bisnis ringan atau biografi pengusaha.",
                            "Level 2: Mulai jalankan usaha sampingan skala kecil (thrift shop, dropship).",
                            "Level 3: Dengarkan podcast bisnis saat sedang di perjalanan atau bersantai.",
                            "Level 4: Pelajari dasar investasi saham atau reksadana dengan modal minim.",
                            "Aktivitas: Baca buku seperti 'Atomic Habits' atau 'Rich Dad Poor Dad'.",
                            "Aktivitas: Buka toko kecil di marketplace e-commerce.",
                            "Aktivitas: Coba jual barang pre-loved di media sosial secara rutin.",
                            "Aktivitas: Investasikan sebagian kecil uang saku ke instrumen investasi aman.",
                            "Outcome: Mengisi waktu luang dengan aktivitas yang menghasilkan pendapatan tambahan dan literasi finansial."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur: Bisnis (Mencari Komunitas)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat bisnis dengan tujuan akhir mencari komunitas. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Tergabung dalam himpunan pengusaha muda atau BEM Kementerian Ekonomi.",
                            "Level 2: Rutin berdiskusi dengan sesama mahasiswa yang memiliki minat wirausaha.",
                            "Level 3: Ikuti kompetisi Business Plan nasional maupun internasional.",
                            "Level 4: Bentuk 'Mastermind Group' untuk saling memonitor progres bisnis masing-masing.",
                            "Aktivitas: Bergabung dengan HIPMI PT (Himpunan Pengusaha Muda Perguruan Tinggi).",
                            "Aktivitas: Sering mengunjungi co-working space untuk mencari jejaring (networking).",
                            "Aktivitas: Ajak teman sebaya untuk membentuk tim perlombaan inovasi bisnis.",
                            "Aktivitas: Adakan sharing session rutin mengenai kendala berbisnis.",
                            "Outcome: Mendapatkan lingkungan pergaulan yang mendukung ambisi dan memberikan pandangan bisnis baru."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur: Bisnis (Umum)",
                            "Deskripsi: Anda belum menentukan tujuan spesifik. Panduan ini berfokus pada eksplorasi minat bisnis secara umum agar Anda bisa menemukan spesialisasi yang tepat.",
                            "Level 1: Pelajari wawasan dasar tentang bisnis secara luas.",
                            "Level 2: Kenali berbagai cabang atau spesialisasi di dalam bidang ini.",
                            "Level 3: Lakukan simulasi kegiatan dari satu cabang spesifik yang paling menarik.",
                            "Level 4: Tentukan satu tujuan utama (Karir, Hobi, Komunitas, atau Skill).",
                            "Aktivitas: Cari informasi mendasar dari artikel atau video edukasi kredibel.",
                            "Aktivitas: Evaluasi kekuatan dan kelemahan Anda di bidang bisnis.",
                            "Aktivitas: Berkonsultasilah dengan senior atau mentor yang berpengalaman.",
                            "Aktivitas: Susun daftar target spesifik yang ingin dicapai bulan ini.",
                            "Outcome: Mendapatkan gambaran besar dan kesiapan penuh untuk memilih spesialisasi bisnis."
                        );
                }
            case "Sosial":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur: Sosial (Persiapan Karir)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat sosial dengan tujuan akhir persiapan karir. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Pahami dinamika masyarakat, sosiologi dasar, dan hukum publik.",
                            "Level 2: Tingkatkan kepekaan terhadap isu HAM, lingkungan, atau kesetaraan.",
                            "Level 3: Terlibat dalam program magang di Non-Governmental Organization (NGO).",
                            "Level 4: Pelajari penyusunan rancangan kebijakan publik (Policy Brief).",
                            "Aktivitas: Ikuti internship di lembaga swadaya masyarakat atau institusi pemerintah.",
                            "Aktivitas: Tulis artikel opini kritis mengenai isu sosial dan kirimkan ke media lokal.",
                            "Aktivitas: Pelajari manajemen proyek nirlaba secara komprehensif.",
                            "Aktivitas: Bangun koneksi dengan para aktivis dan pengambil kebijakan.",
                            "Outcome: Siap meniti karir berdampak luas seperti pekerja sosial, diplomat, atau analis kebijakan."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur: Sosial (Pengembangan Skill)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat sosial dengan tujuan akhir pengembangan skill. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Asah kemampuan mendengarkan aktif (active listening) dan empati.",
                            "Level 2: Pelajari teknik public speaking persuasif untuk mempengaruhi audiens.",
                            "Level 3: Kuasai metode resolusi konflik dan mediasi masalah kelompok.",
                            "Level 4: Pelajari metode penelitian kualitatif untuk riset fenomena sosial.",
                            "Aktivitas: Ikuti kelas pelatihan public speaking atau presentasi tingkat lanjut.",
                            "Aktivitas: Berlatih memfasilitasi Forum Group Discussion (FGD).",
                            "Aktivitas: Lakukan observasi lapangan dan wawancara mendalam dengan narasumber.",
                            "Aktivitas: Ikuti kompetisi debat mahasiswa untuk melatih argumentasi logis.",
                            "Outcome: Menguasai keterampilan komunikasi interpersonal dan pemecahan masalah sosial tingkat lanjut."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur: Sosial (Sekadar Hobi)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat sosial dengan tujuan akhir sekadar hobi. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Awali dengan berbuat baik pada lingkungan di sekitar Anda (kampus/asrama).",
                            "Level 2: Tonton film dokumenter kritis yang membahas isu kemanusiaan atau iklim.",
                            "Level 3: Lakukan kegiatan relawan (volunteer) lepas setiap akhir pekan.",
                            "Level 4: Edukasi lingkungan terdekat menggunakan platform media sosial pribadi.",
                            "Aktivitas: Bantu mengajar anak-anak jalanan atau panti asuhan.",
                            "Aktivitas: Inisiasi kegiatan bersih-bersih pantai atau taman kota (clean-up).",
                            "Aktivitas: Bagikan tautan petisi online yang valid dan terpercaya.",
                            "Aktivitas: Selenggarakan diskusi bedah buku bertema sosial di warung kopi.",
                            "Outcome: Memberikan dampak positif bagi lingkungan sekitar sekaligus mendapatkan kepuasan batin."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur: Sosial (Mencari Komunitas)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat sosial dengan tujuan akhir mencari komunitas. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Masuk ke jajaran pengurus Badan Eksekutif Mahasiswa (BEM) atau dewan mahasiswa.",
                            "Level 2: Aktif dalam organisasi pergerakan mahasiswa ekstra kampus.",
                            "Level 3: Jalin kolaborasi antar-organisasi untuk mengadakan aksi kemanusiaan berskala besar.",
                            "Level 4: Rintis komunitas baru jika isu yang Anda pedulikan belum memiliki wadah.",
                            "Aktivitas: Bergabung dengan organisasi penggiat lingkungan atau HAM.",
                            "Aktivitas: Terjun langsung membagikan bantuan logistik di lokasi bencana.",
                            "Aktivitas: Adakan kampanye kesadaran (awareness campaign) di area kampus.",
                            "Aktivitas: Kumpulkan massa untuk aksi damai atau audiensi kebijakan kampus.",
                            "Outcome: Membentuk kekuatan kolektif yang mampu membawa perubahan nyata di masyarakat."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur: Sosial (Umum)",
                            "Deskripsi: Anda belum menentukan tujuan spesifik. Panduan ini berfokus pada eksplorasi minat sosial secara umum agar Anda bisa menemukan spesialisasi yang tepat.",
                            "Level 1: Pelajari wawasan dasar tentang sosial secara luas.",
                            "Level 2: Kenali berbagai cabang atau spesialisasi di dalam bidang ini.",
                            "Level 3: Lakukan simulasi kegiatan dari satu cabang spesifik yang paling menarik.",
                            "Level 4: Tentukan satu tujuan utama (Karir, Hobi, Komunitas, atau Skill).",
                            "Aktivitas: Cari informasi mendasar dari artikel atau video edukasi kredibel.",
                            "Aktivitas: Evaluasi kekuatan dan kelemahan Anda di bidang sosial.",
                            "Aktivitas: Berkonsultasilah dengan senior atau mentor yang berpengalaman.",
                            "Aktivitas: Susun daftar target spesifik yang ingin dicapai bulan ini.",
                            "Outcome: Mendapatkan gambaran besar dan kesiapan penuh untuk memilih spesialisasi sosial."
                        );
                }
            case "Kesehatan":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur: Kesehatan (Persiapan Karir)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat kesehatan dengan tujuan akhir persiapan karir. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Pahami teori fundamental anatomi, fisiologi, dan gizi klinis secara mendalam.",
                            "Level 2: Cari peluang observasi atau magang di klinik, rumah sakit, maupun puskesmas.",
                            "Level 3: Dapatkan sertifikasi profesi atau keahlian tambahan yang diakui secara nasional.",
                            "Level 4: Pilih spesialisasi spesifik, misalnya kesehatan ibu anak atau kedokteran olahraga.",
                            "Aktivitas: Ikuti program magang administrasi atau asisten di fasilitas kesehatan.",
                            "Aktivitas: Hadiri simposium atau seminar medis tingkat nasional.",
                            "Aktivitas: Ambil sertifikasi Keselamatan dan Kesehatan Kerja (K3).",
                            "Aktivitas: Bangun jaringan dengan dokter, perawat, atau praktisi medis senior.",
                            "Outcome: Siap bekerja secara profesional di industri kesehatan dan fasilitas medis."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur: Kesehatan (Pengembangan Skill)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat kesehatan dengan tujuan akhir pengembangan skill. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Pelajari ilmu nutrisi terapan dan dietetika dasar.",
                            "Level 2: Kuasai teknik Pertolongan Pertama Pada Kecelakaan (P3K) dan Resusitasi Jantung Paru (CPR).",
                            "Level 3: Tingkatkan kesadaran akan kesehatan mental dan *psychological first aid*.",
                            "Level 4: Pelajari analisis epidemiologi dasar dan cara membaca rekam medis.",
                            "Aktivitas: Ikuti workshop P3K dari Palang Merah Indonesia (PMI).",
                            "Aktivitas: Buat perencanaan *meal-prep* (menu makanan harian) bergizi seimbang.",
                            "Aktivitas: Pelajari dasar-dasar fisioterapi ringan untuk pemulihan cedera olahraga.",
                            "Aktivitas: Selesaikan kursus singkat mengenai *Mental Health Awareness*.",
                            "Outcome: Memiliki keterampilan praktis yang sangat berguna untuk menyelamatkan nyawa dan menjaga kebugaran."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur: Kesehatan (Sekadar Hobi)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat kesehatan dengan tujuan akhir sekadar hobi. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Perbaiki ritme sirkadian dengan mengatur jam tidur dan bangun secara konsisten.",
                            "Level 2: Jadwalkan aktivitas fisik ringan seperti jogging atau yoga minimal 3 kali seminggu.",
                            "Level 3: Kurangi konsumsi gula harian dan mulai masak makanan utuh (whole foods) di rumah.",
                            "Level 4: Latih *mindfulness* (kesadaran penuh) dan meditasi untuk mengelola stres harian.",
                            "Aktivitas: Coba rutinitas lari pagi sejauh 3-5 km secara berkala.",
                            "Aktivitas: Eksplorasi resep masakan sehat, rendah kalori, dan tinggi protein.",
                            "Aktivitas: Ikuti sesi relaksasi, meditasi, atau *stretching* dari video YouTube.",
                            "Aktivitas: Tulis jurnal harian (journaling) untuk mendetoksifikasi beban emosional.",
                            "Outcome: Mendapatkan tubuh yang bugar, pikiran yang jernih, dan gaya hidup yang sangat prima."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur: Kesehatan (Mencari Komunitas)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat kesehatan dengan tujuan akhir mencari komunitas. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Temukan klub kebugaran atau komunitas olahraga lokal di daerah Anda.",
                            "Level 2: Ikuti *support group* atau komunitas peduli kesehatan mental terdekat.",
                            "Level 3: Ajak lingkungan kampus untuk mengadakan senam bersama atau gerakan donor darah.",
                            "Level 4: Ikuti perhelatan maraton massal (5K/10K) untuk merasakan antusiasme gaya hidup sehat.",
                            "Aktivitas: Bergabung dengan komunitas lari pagi (Runners Club) atau gowes sepeda.",
                            "Aktivitas: Menjadi panitia acara bakti sosial donor darah tahunan.",
                            "Aktivitas: Berpartisipasi dalam diskusi kelompok sebaya mengenai manajemen stres.",
                            "Aktivitas: Sosialisasikan bahaya merokok atau diet ekstrem di lingkungan pertemanan.",
                            "Outcome: Dikelilingi oleh orang-orang yang saling memotivasi untuk menjaga kebugaran fisik dan mental."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur: Kesehatan (Umum)",
                            "Deskripsi: Anda belum menentukan tujuan spesifik. Panduan ini berfokus pada eksplorasi minat kesehatan secara umum agar Anda bisa menemukan spesialisasi yang tepat.",
                            "Level 1: Pelajari wawasan dasar tentang kesehatan secara luas.",
                            "Level 2: Kenali berbagai cabang atau spesialisasi di dalam bidang ini.",
                            "Level 3: Lakukan simulasi kegiatan dari satu cabang spesifik yang paling menarik.",
                            "Level 4: Tentukan satu tujuan utama (Karir, Hobi, Komunitas, atau Skill).",
                            "Aktivitas: Cari informasi mendasar dari artikel atau video edukasi kredibel.",
                            "Aktivitas: Evaluasi kekuatan dan kelemahan Anda di bidang kesehatan.",
                            "Aktivitas: Berkonsultasilah dengan senior atau mentor yang berpengalaman.",
                            "Aktivitas: Susun daftar target spesifik yang ingin dicapai bulan ini.",
                            "Outcome: Mendapatkan gambaran besar dan kesiapan penuh untuk memilih spesialisasi kesehatan."
                        );
                }
            case "Sains":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur: Sains (Persiapan Karir)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat sains dengan tujuan akhir persiapan karir. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Kuasai metodologi penelitian, perancangan eksperimen, dan literasi ilmiah dasar.",
                            "Level 2: Tawarkan diri sebagai asisten riset (research assistant) di laboratorium dosen.",
                            "Level 3: Publikasikan makalah penelitian Anda di jurnal ilmiah nasional maupun internasional.",
                            "Level 4: Mulai persiapkan aplikasi beasiswa pascasarjana (S2/S3) atau program Fellowship.",
                            "Aktivitas: Terlibat penuh dalam proyek penelitian payung milik program studi.",
                            "Aktivitas: Pelajari cara menulis paper akademik (Scientific Writing) yang memenuhi standar IEEE/Scopus.",
                            "Aktivitas: Presentasikan hasil temuan Anda pada konferensi sains antar-universitas.",
                            "Aktivitas: Bangun koneksi dengan para pakar dan peneliti senior di bidang kajian Anda.",
                            "Outcome: Siap meniti karir akademis yang kokoh sebagai Ilmuwan, Peneliti, atau Dosen."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur: Sains (Pengembangan Skill)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat sains dengan tujuan akhir pengembangan skill. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Pelajari perangkat lunak pengolahan statistik mutakhir (SPSS, R, Python Pandas).",
                            "Level 2: Latih ketelitian dalam mengoperasikan instrumen dan alat laboratorium berat.",
                            "Level 3: Tingkatkan kemampuan *Journal Reading* dengan membedah paper dari jurnal bergengsi.",
                            "Level 4: Eksperimen dengan merancang model atau hipotesis pengujian secara mandiri.",
                            "Aktivitas: Ikuti kursus *Data Science* untuk mengolah dataset riset berskala besar.",
                            "Aktivitas: Biasakan membaca artikel dari jurnal Nature, Science, atau Elsevier secara kritis.",
                            "Aktivitas: Susun tinjauan literatur (Literature Review) tentang topik sains terkini.",
                            "Aktivitas: Lakukan simulasi komputasi atau pengujian teori dengan software spesifik.",
                            "Outcome: Menguasai keterampilan pengolahan data saintifik dan ketajaman analisa empiris tingkat tinggi."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur: Sains (Sekadar Hobi)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat sains dengan tujuan akhir sekadar hobi. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Ganti tontonan santai Anda dengan tayangan edukatif, seperti kanal YouTube sains populer.",
                            "Level 2: Belilah peralatan sederhana seperti teleskop portabel atau mikroskop saku.",
                            "Level 3: Lakukan percobaan kimia atau fisika skala rumahan yang dijamin aman.",
                            "Level 4: Jadikan topik fakta sains sebagai bahan obrolan pemecah kebekuan (*ice-breaker*) yang menarik.",
                            "Aktivitas: Menonton video dari Veritasium, Vsauce, atau seri Cosmos.",
                            "Aktivitas: Amati fenomena rasi bintang atau detail struktur daun di taman rumah.",
                            "Aktivitas: Baca buku sains yang ramah awam karya Carl Sagan atau Neil deGrasse Tyson.",
                            "Aktivitas: Kunjungi planetarium, kebun raya, atau museum sejarah alam terdekat.",
                            "Outcome: Memuaskan rasa ingin tahu intelektual (curiosity) yang mendalam secara menyenangkan."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur: Sains (Mencari Komunitas)",
                            "Deskripsi: Panduan komprehensif ini dirancang khusus untuk Anda yang memiliki minat sains dengan tujuan akhir mencari komunitas. Setiap tahapan disusun agar Anda dapat mencapai hasil yang realistis dan terukur.",
                            "Level 1: Bentuk Kelompok Studi Mahasiswa (KSM) khusus bagi pecinta teori dan riset.",
                            "Level 2: Daftarkan tim Anda pada ajang perlombaan akademik bergengsi (Olimpiade Sains, PKM).",
                            "Level 3: Seringlah mengunjungi seminar, diskusi panel, dan pameran inovasi teknologi sains.",
                            "Level 4: Ciptakan proyek kolaborasi interdisipliner dengan mahasiswa dari fakultas lain.",
                            "Aktivitas: Bergabung dengan Science Club kampus atau ikatan mahasiswa prodi.",
                            "Aktivitas: Ikuti Pekan Ilmiah Mahasiswa Nasional (PIMNAS).",
                            "Aktivitas: Adakan diskusi kelompok untuk membedah inovasi sains terbaru bersama pakar.",
                            "Aktivitas: Jalin jejaring pertukaran informasi dengan klub sains dari universitas lain.",
                            "Outcome: Menjadi bagian dari lingkaran akademisi cerdas yang saling menantang gagasan inovatif."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur: Sains (Umum)",
                            "Deskripsi: Anda belum menentukan tujuan spesifik. Panduan ini berfokus pada eksplorasi minat sains secara umum agar Anda bisa menemukan spesialisasi yang tepat.",
                            "Level 1: Pelajari wawasan dasar tentang sains secara luas.",
                            "Level 2: Kenali berbagai cabang atau spesialisasi di dalam bidang ini.",
                            "Level 3: Lakukan simulasi kegiatan dari satu cabang spesifik yang paling menarik.",
                            "Level 4: Tentukan satu tujuan utama (Karir, Hobi, Komunitas, atau Skill).",
                            "Aktivitas: Cari informasi mendasar dari artikel atau video edukasi kredibel.",
                            "Aktivitas: Evaluasi kekuatan dan kelemahan Anda di bidang sains.",
                            "Aktivitas: Berkonsultasilah dengan senior atau mentor yang berpengalaman.",
                            "Aktivitas: Susun daftar target spesifik yang ingin dicapai bulan ini.",
                            "Outcome: Mendapatkan gambaran besar dan kesiapan penuh untuk memilih spesialisasi sains."
                        );
                }
            default:
                return Arrays.asList(
                    "Jalur: Eksplorasi Minat Diri",
                    "Deskripsi: Peminatan utama Anda belum teridentifikasi. Panduan ini dirancang untuk memancing ketertarikan Anda pada berbagai bidang hingga Anda menemukan satu minat utama.",
                    "Level 1: Lakukan penilaian (assessment) mandiri mengenai ketertarikan Anda.",
                    "Level 2: Cobalah terlibat dalam berbagai acara lintas bidang yang diadakan di lingkungan sekitar.",
                    "Level 3: Evaluasi dan catat aktivitas mana yang paling membuat Anda merasa antusias.",
                    "Level 4: Mantapkan hati untuk fokus pada satu minat dominan bulan depan.",
                    "Aktivitas: Ikuti tes asesmen minat dan bakat secara daring yang tervalidasi.",
                    "Aktivitas: Kunjungi sesi open house dari Unit Kegiatan Mahasiswa (UKM) yang berbeda-beda.",
                    "Aktivitas: Ajukan diri sebagai panitia acara di bidang yang sebelumnya belum pernah Anda coba.",
                    "Aktivitas: Lakukan perenungan dan refleksikan pencapaian Anda selama beberapa minggu terakhir.",
                    "Outcome: Terbentuknya identitas minat yang jelas sehingga langkah pengembangan karir bisa dimulai."
                );
        }
    }
    
    public static String getExplanation(DataModel user) {
        return "Rekomendasi di atas bukan sekadar saran, melainkan modul langkah demi langkah (actionable framework) yang disesuaikan secara dinamis berdasarkan kalkulasi minat dan tujuan akhir Anda. Silakan ikuti fase-fasenya secara berurutan.";
    }
}
