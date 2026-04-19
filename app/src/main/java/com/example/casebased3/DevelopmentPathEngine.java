package com.example.casebased3;

import java.util.Arrays;
import java.util.List;

public class DevelopmentPathEngine {

    public static List<String> getPath(String minat, String tujuan) {
        if (minat == null) minat = "";
        if (tujuan == null) tujuan = "";

        switch (minat) {
            case "Teknologi":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Teknologi untuk Persiapan Karir",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres teknologi Anda terekam dengan matang.",
                            "Fase 1: Pelajari dasar algoritma dan struktur data menggunakan Python atau Java.",
                            "Fase 2: Kuasai framework populer seperti React, Flutter, atau Spring Boot.",
                            "Fase 3: Bangun portofolio berupa 3 project berskala menengah.",
                            "Fase 4: Persiapkan technical interview dan apply posisi Junior Developer.",
                            "Tindakan Wajib 1: Selesaikan modul sertifikasi dari Coursera atau AWS.",
                            "Tindakan Wajib 2: Bangun aplikasi manajemen tugas atau e-commerce sederhana.",
                            "Tindakan Wajib 3: Buat repositori GitHub yang rapi beserta README yang jelas.",
                            "Tindakan Wajib 4: Lakukan simulasi wawancara teknis (mock interview) bersama mentor.",
                            "Proyeksi Akhir: Siap melamar posisi Software Engineer atau IT Consultant dengan portofolio solid."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Teknologi untuk Pengembangan Skill",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres teknologi Anda terekam dengan matang.",
                            "Fase 1: Tentukan satu spesialisasi utama (misal: Backend, Frontend, Data).",
                            "Fase 2: Pelajari arsitektur sistem dan konsep Clean Code.",
                            "Fase 3: Eksplorasi teknologi mutakhir seperti Docker, CI/CD, atau AI.",
                            "Fase 4: Refactor kode lama Anda agar sesuai standar industri.",
                            "Tindakan Wajib 1: Terapkan design pattern pada kode yang sudah ada.",
                            "Tindakan Wajib 2: Pelajari cara kerja REST API dan GraphQL.",
                            "Tindakan Wajib 3: Publikasikan library atau package buatan sendiri ke npm/PyPI.",
                            "Tindakan Wajib 4: Baca dokumentasi resmi dari teknologi yang sedang tren.",
                            "Proyeksi Akhir: Menguasai keterampilan teknis menengah hingga lanjutan untuk keunggulan teknis."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Teknologi untuk Sekadar Hobi",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres teknologi Anda terekam dengan matang.",
                            "Fase 1: Kenali dasar-dasar otomatisasi untuk mempermudah hidup.",
                            "Fase 2: Buat skrip sederhana untuk mengatur file atau mengirim pesan otomatis.",
                            "Fase 3: Eksperimen dengan perangkat keras seperti Raspberry Pi atau Arduino.",
                            "Fase 4: Bangun proyek DIY (Do It Yourself) di rumah.",
                            "Tindakan Wajib 1: Buat bot Telegram atau Discord sederhana.",
                            "Tindakan Wajib 2: Pasang sistem smart home dasar menggunakan mikrokontroler.",
                            "Tindakan Wajib 3: Kembangkan game indie 2D dengan Unity atau Godot.",
                            "Tindakan Wajib 4: Coba rakit PC atau modifikasi perangkat keras lama.",
                            "Proyeksi Akhir: Mendapatkan hiburan yang produktif dan melatih logika tanpa tekanan kerja."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Teknologi untuk Mencari Komunitas",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres teknologi Anda terekam dengan matang.",
                            "Fase 1: Petakan komunitas teknologi lokal maupun daring (online) yang aktif.",
                            "Fase 2: Rutin berpartisipasi dalam diskusi di forum atau grup Telegram/Discord.",
                            "Fase 3: Mulai berkontribusi dalam proyek Open Source (repositori terbuka).",
                            "Fase 4: Jadi pembicara atau relawan di acara teknologi (Tech Meetup).",
                            "Tindakan Wajib 1: Bergabung dengan Google Developer Group (GDG) lokal.",
                            "Tindakan Wajib 2: Ikuti ajang kompetisi Hackathon sebagai tim.",
                            "Tindakan Wajib 3: Jawab pertanyaan pemula di StackOverflow atau grup Facebook.",
                            "Tindakan Wajib 4: Adakan sesi belajar bareng sesama penggiat IT.",
                            "Proyeksi Akhir: Memiliki jaringan profesional dan pertemanan luas di dunia teknologi."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur Pengembangan: Transisi Bidang Teknologi",
                            "Deskripsi: Peta jalan umum ini bertugas menuntun transisi awal Anda ke dalam ranah teknologi secara bertahap dan sistematis.",
                            "Fase 1: Mulai dari riset pustaka dan observasi lingkungan.",
                            "Fase 2: Identifikasi peluang pengembangan diri yang tersedia.",
                            "Fase 3: Ikuti sesi pengantar dasar atau pelatihan perkenalan.",
                            "Fase 4: Deklarasikan tujuan utama (Karir/Skill/Hobi/Komunitas) secara tegas.",
                            "Tindakan Wajib 1: Pelajari silabus umum dari bidang terkait.",
                            "Tindakan Wajib 2: Tanyakan pengalaman orang-orang yang sudah lebih dulu terjun.",
                            "Tindakan Wajib 3: Dedikasikan setidaknya 2 jam per minggu untuk fokus.",
                            "Tindakan Wajib 4: Tetapkan tenggat waktu kapan Anda akan memilih fokus spesifik.",
                            "Proyeksi Akhir: Transisi yang lancar tanpa hambatan teknis menuju fase pendalaman spesialisasi."
                        );
                }
            case "Seni":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Seni untuk Persiapan Karir",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres seni Anda terekam dengan matang.",
                            "Fase 1: Pahami prinsip dasar desain, nirmana, tipografi, dan komposisi warna.",
                            "Fase 2: Kuasai perangkat lunak industri seperti Adobe Creative Suite atau Figma.",
                            "Fase 3: Kerjakan proyek fiktif untuk melengkapi portofolio komersial.",
                            "Fase 4: Tawarkan jasa freelance untuk membangun reputasi awal.",
                            "Tindakan Wajib 1: Buat akun Behance atau Dribbble dan unggah 5 karya terbaik.",
                            "Tindakan Wajib 2: Tawarkan desain logo atau banner gratis untuk UMKM lokal.",
                            "Tindakan Wajib 3: Ikuti kursus UI/UX Design atau Graphic Design yang bersertifikat.",
                            "Tindakan Wajib 4: Rapikan CV kreatif dan mulai kirimkan ke agensi periklanan.",
                            "Proyeksi Akhir: Siap bekerja secara profesional sebagai Desainer atau Art Director."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Seni untuk Pengembangan Skill",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres seni Anda terekam dengan matang.",
                            "Fase 1: Pelajari aliran seni yang belum pernah Anda coba sebelumnya.",
                            "Fase 2: Analisis karya master dan coba replikasi tekniknya (Master Study).",
                            "Fase 3: Eksperimen penggabungan teknik tradisional dan seni digital.",
                            "Fase 4: Temukan gaya visual yang menjadi ciri khas (Signature Style) Anda.",
                            "Tindakan Wajib 1: Lakukan tantangan menggambar 30 hari (misal: Inktober).",
                            "Tindakan Wajib 2: Latih anatomi manusia dan perspektif ruang secara intensif.",
                            "Tindakan Wajib 3: Minta kritik terbuka (constructive feedback) dari seniman senior.",
                            "Tindakan Wajib 4: Ikuti kelas lanjutan mengenai teori warna dan pencahayaan.",
                            "Proyeksi Akhir: Peningkatan kualitas karya seni dengan teknik yang lebih matang dan berkarakter."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Seni untuk Sekadar Hobi",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres seni Anda terekam dengan matang.",
                            "Fase 1: Siapkan buku sketsa atau kanvas untuk corat-coret bebas tanpa aturan.",
                            "Fase 2: Lakukan sesi menggambar santai sambil mendengarkan musik.",
                            "Fase 3: Coba medium fisik seperti cat air, akrilik, atau tanah liat (pottery).",
                            "Fase 4: Gunakan seni sebagai bentuk pelepasan stres (Art Therapy).",
                            "Tindakan Wajib 1: Gambar pemandangan di taman kota atau kafe.",
                            "Tindakan Wajib 2: Buat kerajinan tangan sederhana untuk dekorasi kamar.",
                            "Tindakan Wajib 3: Ikuti sesi melukis santai (Sip and Paint) bersama teman.",
                            "Tindakan Wajib 4: Tonton video restorasi karya seni atau proses melukis yang menenangkan.",
                            "Proyeksi Akhir: Mendapatkan ketenangan batin dan sarana ekspresi emosi yang positif."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Seni untuk Mencari Komunitas",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres seni Anda terekam dengan matang.",
                            "Fase 1: Cari organisasi seni kampus atau komunitas seniman lokal.",
                            "Fase 2: Hadiri pameran seni, galeri, atau pertunjukan teater secara rutin.",
                            "Fase 3: Berpartisipasi dalam proyek seni kolaboratif (misal: mural dinding kota).",
                            "Fase 4: Jadilah inisiator pameran seni kolektif skala kecil.",
                            "Tindakan Wajib 1: Bergabung dengan UKM Seni Rupa atau Teater.",
                            "Tindakan Wajib 2: Ikut acara menggambar bersama di ruang publik (Urban Sketchers).",
                            "Tindakan Wajib 3: Mengunjungi galeri lokal dan berdiskusi langsung dengan senimannya.",
                            "Tindakan Wajib 4: Buat zine atau majalah seni independen bersama rekan sejawat.",
                            "Proyeksi Akhir: Tergabung dalam ekosistem kreatif yang saling mendukung dan menginspirasi."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur Pengembangan: Transisi Bidang Seni",
                            "Deskripsi: Peta jalan umum ini bertugas menuntun transisi awal Anda ke dalam ranah seni secara bertahap dan sistematis.",
                            "Fase 1: Mulai dari riset pustaka dan observasi lingkungan.",
                            "Fase 2: Identifikasi peluang pengembangan diri yang tersedia.",
                            "Fase 3: Ikuti sesi pengantar dasar atau pelatihan perkenalan.",
                            "Fase 4: Deklarasikan tujuan utama (Karir/Skill/Hobi/Komunitas) secara tegas.",
                            "Tindakan Wajib 1: Pelajari silabus umum dari bidang terkait.",
                            "Tindakan Wajib 2: Tanyakan pengalaman orang-orang yang sudah lebih dulu terjun.",
                            "Tindakan Wajib 3: Dedikasikan setidaknya 2 jam per minggu untuk fokus.",
                            "Tindakan Wajib 4: Tetapkan tenggat waktu kapan Anda akan memilih fokus spesifik.",
                            "Proyeksi Akhir: Transisi yang lancar tanpa hambatan teknis menuju fase pendalaman spesialisasi."
                        );
                }
            case "Bisnis":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Bisnis untuk Persiapan Karir",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres bisnis Anda terekam dengan matang.",
                            "Fase 1: Pahami pilar bisnis: pemasaran, operasional, keuangan, dan SDM.",
                            "Fase 2: Pelajari cara menyusun Business Model Canvas dan rencana bisnis yang solid.",
                            "Fase 3: Terapkan ilmu melalui program magang di startup atau konsultan.",
                            "Fase 4: Asah kemampuan presentasi bisnis (Pitching) untuk mencari pendanaan.",
                            "Tindakan Wajib 1: Lakukan riset pasar mendalam untuk sebuah ide produk fiktif.",
                            "Tindakan Wajib 2: Ikuti program Management Trainee atau inkubator bisnis.",
                            "Tindakan Wajib 3: Bangun koneksi profesional di LinkedIn dengan para praktisi industri.",
                            "Tindakan Wajib 4: Analisis studi kasus kegagalan dan kesuksesan perusahaan terkemuka.",
                            "Proyeksi Akhir: Siap menjadi Business Analyst, Entrepreneur, atau bekerja di ranah korporat."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Bisnis untuk Pengembangan Skill",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres bisnis Anda terekam dengan matang.",
                            "Fase 1: Pelajari dasar pemasaran digital (SEO, SEM, Social Media Ads).",
                            "Fase 2: Kuasai teknik perhitungan proyeksi keuangan (Financial Modeling).",
                            "Fase 3: Latih kemampuan negosiasi dan diplomasi dalam transaksi.",
                            "Fase 4: Pelajari strategi manajemen risiko dan analisis data bisnis.",
                            "Tindakan Wajib 1: Jalankan kampanye iklan kecil-kecilan di Facebook/Instagram Ads.",
                            "Tindakan Wajib 2: Buat simulasi laporan laba-rugi untuk sebuah bisnis UMKM.",
                            "Tindakan Wajib 3: Ikuti pelatihan public speaking dan negosiasi bisnis.",
                            "Tindakan Wajib 4: Selesaikan sertifikasi Google Analytics atau HubSpot.",
                            "Proyeksi Akhir: Memiliki keterampilan manajerial dan teknis yang dapat diaplikasikan langsung ke bisnis."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Bisnis untuk Sekadar Hobi",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres bisnis Anda terekam dengan matang.",
                            "Fase 1: Biasakan membaca literatur bisnis ringan atau biografi pengusaha.",
                            "Fase 2: Mulai jalankan usaha sampingan skala kecil (thrift shop, dropship).",
                            "Fase 3: Dengarkan podcast bisnis saat sedang di perjalanan atau bersantai.",
                            "Fase 4: Pelajari dasar investasi saham atau reksadana dengan modal minim.",
                            "Tindakan Wajib 1: Baca buku seperti 'Atomic Habits' atau 'Rich Dad Poor Dad'.",
                            "Tindakan Wajib 2: Buka toko kecil di marketplace e-commerce.",
                            "Tindakan Wajib 3: Coba jual barang pre-loved di media sosial secara rutin.",
                            "Tindakan Wajib 4: Investasikan sebagian kecil uang saku ke instrumen investasi aman.",
                            "Proyeksi Akhir: Mengisi waktu luang dengan aktivitas yang menghasilkan pendapatan tambahan dan literasi finansial."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Bisnis untuk Mencari Komunitas",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres bisnis Anda terekam dengan matang.",
                            "Fase 1: Tergabung dalam himpunan pengusaha muda atau BEM Kementerian Ekonomi.",
                            "Fase 2: Rutin berdiskusi dengan sesama mahasiswa yang memiliki minat wirausaha.",
                            "Fase 3: Ikuti kompetisi Business Plan nasional maupun internasional.",
                            "Fase 4: Bentuk 'Mastermind Group' untuk saling memonitor progres bisnis masing-masing.",
                            "Tindakan Wajib 1: Bergabung dengan HIPMI PT (Himpunan Pengusaha Muda Perguruan Tinggi).",
                            "Tindakan Wajib 2: Sering mengunjungi co-working space untuk mencari jejaring (networking).",
                            "Tindakan Wajib 3: Ajak teman sebaya untuk membentuk tim perlombaan inovasi bisnis.",
                            "Tindakan Wajib 4: Adakan sharing session rutin mengenai kendala berbisnis.",
                            "Proyeksi Akhir: Mendapatkan lingkungan pergaulan yang mendukung ambisi dan memberikan pandangan bisnis baru."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur Pengembangan: Transisi Bidang Bisnis",
                            "Deskripsi: Peta jalan umum ini bertugas menuntun transisi awal Anda ke dalam ranah bisnis secara bertahap dan sistematis.",
                            "Fase 1: Mulai dari riset pustaka dan observasi lingkungan.",
                            "Fase 2: Identifikasi peluang pengembangan diri yang tersedia.",
                            "Fase 3: Ikuti sesi pengantar dasar atau pelatihan perkenalan.",
                            "Fase 4: Deklarasikan tujuan utama (Karir/Skill/Hobi/Komunitas) secara tegas.",
                            "Tindakan Wajib 1: Pelajari silabus umum dari bidang terkait.",
                            "Tindakan Wajib 2: Tanyakan pengalaman orang-orang yang sudah lebih dulu terjun.",
                            "Tindakan Wajib 3: Dedikasikan setidaknya 2 jam per minggu untuk fokus.",
                            "Tindakan Wajib 4: Tetapkan tenggat waktu kapan Anda akan memilih fokus spesifik.",
                            "Proyeksi Akhir: Transisi yang lancar tanpa hambatan teknis menuju fase pendalaman spesialisasi."
                        );
                }
            case "Sosial":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Sosial untuk Persiapan Karir",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres sosial Anda terekam dengan matang.",
                            "Fase 1: Pahami dinamika masyarakat, sosiologi dasar, dan hukum publik.",
                            "Fase 2: Tingkatkan kepekaan terhadap isu HAM, lingkungan, atau kesetaraan.",
                            "Fase 3: Terlibat dalam program magang di Non-Governmental Organization (NGO).",
                            "Fase 4: Pelajari penyusunan rancangan kebijakan publik (Policy Brief).",
                            "Tindakan Wajib 1: Ikuti internship di lembaga swadaya masyarakat atau institusi pemerintah.",
                            "Tindakan Wajib 2: Tulis artikel opini kritis mengenai isu sosial dan kirimkan ke media lokal.",
                            "Tindakan Wajib 3: Pelajari manajemen proyek nirlaba secara komprehensif.",
                            "Tindakan Wajib 4: Bangun koneksi dengan para aktivis dan pengambil kebijakan.",
                            "Proyeksi Akhir: Siap meniti karir berdampak luas seperti pekerja sosial, diplomat, atau analis kebijakan."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Sosial untuk Pengembangan Skill",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres sosial Anda terekam dengan matang.",
                            "Fase 1: Asah kemampuan mendengarkan aktif (active listening) dan empati.",
                            "Fase 2: Pelajari teknik public speaking persuasif untuk mempengaruhi audiens.",
                            "Fase 3: Kuasai metode resolusi konflik dan mediasi masalah kelompok.",
                            "Fase 4: Pelajari metode penelitian kualitatif untuk riset fenomena sosial.",
                            "Tindakan Wajib 1: Ikuti kelas pelatihan public speaking atau presentasi tingkat lanjut.",
                            "Tindakan Wajib 2: Berlatih memfasilitasi Forum Group Discussion (FGD).",
                            "Tindakan Wajib 3: Lakukan observasi lapangan dan wawancara mendalam dengan narasumber.",
                            "Tindakan Wajib 4: Ikuti kompetisi debat mahasiswa untuk melatih argumentasi logis.",
                            "Proyeksi Akhir: Menguasai keterampilan komunikasi interpersonal dan pemecahan masalah sosial tingkat lanjut."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Sosial untuk Sekadar Hobi",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres sosial Anda terekam dengan matang.",
                            "Fase 1: Awali dengan berbuat baik pada lingkungan di sekitar Anda (kampus/asrama).",
                            "Fase 2: Tonton film dokumenter kritis yang membahas isu kemanusiaan atau iklim.",
                            "Fase 3: Lakukan kegiatan relawan (volunteer) lepas setiap akhir pekan.",
                            "Fase 4: Edukasi lingkungan terdekat menggunakan platform media sosial pribadi.",
                            "Tindakan Wajib 1: Bantu mengajar anak-anak jalanan atau panti asuhan.",
                            "Tindakan Wajib 2: Inisiasi kegiatan bersih-bersih pantai atau taman kota (clean-up).",
                            "Tindakan Wajib 3: Bagikan tautan petisi online yang valid dan terpercaya.",
                            "Tindakan Wajib 4: Selenggarakan diskusi bedah buku bertema sosial di warung kopi.",
                            "Proyeksi Akhir: Memberikan dampak positif bagi lingkungan sekitar sekaligus mendapatkan kepuasan batin."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Sosial untuk Mencari Komunitas",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres sosial Anda terekam dengan matang.",
                            "Fase 1: Masuk ke jajaran pengurus Badan Eksekutif Mahasiswa (BEM) atau dewan mahasiswa.",
                            "Fase 2: Aktif dalam organisasi pergerakan mahasiswa ekstra kampus.",
                            "Fase 3: Jalin kolaborasi antar-organisasi untuk mengadakan aksi kemanusiaan berskala besar.",
                            "Fase 4: Rintis komunitas baru jika isu yang Anda pedulikan belum memiliki wadah.",
                            "Tindakan Wajib 1: Bergabung dengan organisasi penggiat lingkungan atau HAM.",
                            "Tindakan Wajib 2: Terjun langsung membagikan bantuan logistik di lokasi bencana.",
                            "Tindakan Wajib 3: Adakan kampanye kesadaran (awareness campaign) di area kampus.",
                            "Tindakan Wajib 4: Kumpulkan massa untuk aksi damai atau audiensi kebijakan kampus.",
                            "Proyeksi Akhir: Membentuk kekuatan kolektif yang mampu membawa perubahan nyata di masyarakat."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur Pengembangan: Transisi Bidang Sosial",
                            "Deskripsi: Peta jalan umum ini bertugas menuntun transisi awal Anda ke dalam ranah sosial secara bertahap dan sistematis.",
                            "Fase 1: Mulai dari riset pustaka dan observasi lingkungan.",
                            "Fase 2: Identifikasi peluang pengembangan diri yang tersedia.",
                            "Fase 3: Ikuti sesi pengantar dasar atau pelatihan perkenalan.",
                            "Fase 4: Deklarasikan tujuan utama (Karir/Skill/Hobi/Komunitas) secara tegas.",
                            "Tindakan Wajib 1: Pelajari silabus umum dari bidang terkait.",
                            "Tindakan Wajib 2: Tanyakan pengalaman orang-orang yang sudah lebih dulu terjun.",
                            "Tindakan Wajib 3: Dedikasikan setidaknya 2 jam per minggu untuk fokus.",
                            "Tindakan Wajib 4: Tetapkan tenggat waktu kapan Anda akan memilih fokus spesifik.",
                            "Proyeksi Akhir: Transisi yang lancar tanpa hambatan teknis menuju fase pendalaman spesialisasi."
                        );
                }
            case "Kesehatan":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Kesehatan untuk Persiapan Karir",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres kesehatan Anda terekam dengan matang.",
                            "Fase 1: Pahami teori fundamental anatomi, fisiologi, dan gizi klinis secara mendalam.",
                            "Fase 2: Cari peluang observasi atau magang di klinik, rumah sakit, maupun puskesmas.",
                            "Fase 3: Dapatkan sertifikasi profesi atau keahlian tambahan yang diakui secara nasional.",
                            "Fase 4: Pilih spesialisasi spesifik, misalnya kesehatan ibu anak atau kedokteran olahraga.",
                            "Tindakan Wajib 1: Ikuti program magang administrasi atau asisten di fasilitas kesehatan.",
                            "Tindakan Wajib 2: Hadiri simposium atau seminar medis tingkat nasional.",
                            "Tindakan Wajib 3: Ambil sertifikasi Keselamatan dan Kesehatan Kerja (K3).",
                            "Tindakan Wajib 4: Bangun jaringan dengan dokter, perawat, atau praktisi medis senior.",
                            "Proyeksi Akhir: Siap bekerja secara profesional di industri kesehatan dan fasilitas medis."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Kesehatan untuk Pengembangan Skill",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres kesehatan Anda terekam dengan matang.",
                            "Fase 1: Pelajari ilmu nutrisi terapan dan dietetika dasar.",
                            "Fase 2: Kuasai teknik Pertolongan Pertama Pada Kecelakaan (P3K) dan Resusitasi Jantung Paru (CPR).",
                            "Fase 3: Tingkatkan kesadaran akan kesehatan mental dan *psychological first aid*.",
                            "Fase 4: Pelajari analisis epidemiologi dasar dan cara membaca rekam medis.",
                            "Tindakan Wajib 1: Ikuti workshop P3K dari Palang Merah Indonesia (PMI).",
                            "Tindakan Wajib 2: Buat perencanaan *meal-prep* (menu makanan harian) bergizi seimbang.",
                            "Tindakan Wajib 3: Pelajari dasar-dasar fisioterapi ringan untuk pemulihan cedera olahraga.",
                            "Tindakan Wajib 4: Selesaikan kursus singkat mengenai *Mental Health Awareness*.",
                            "Proyeksi Akhir: Memiliki keterampilan praktis yang sangat berguna untuk menyelamatkan nyawa dan menjaga kebugaran."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Kesehatan untuk Sekadar Hobi",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres kesehatan Anda terekam dengan matang.",
                            "Fase 1: Perbaiki ritme sirkadian dengan mengatur jam tidur dan bangun secara konsisten.",
                            "Fase 2: Jadwalkan aktivitas fisik ringan seperti jogging atau yoga minimal 3 kali seminggu.",
                            "Fase 3: Kurangi konsumsi gula harian dan mulai masak makanan utuh (whole foods) di rumah.",
                            "Fase 4: Latih *mindfulness* (kesadaran penuh) dan meditasi untuk mengelola stres harian.",
                            "Tindakan Wajib 1: Coba rutinitas lari pagi sejauh 3-5 km secara berkala.",
                            "Tindakan Wajib 2: Eksplorasi resep masakan sehat, rendah kalori, dan tinggi protein.",
                            "Tindakan Wajib 3: Ikuti sesi relaksasi, meditasi, atau *stretching* dari video YouTube.",
                            "Tindakan Wajib 4: Tulis jurnal harian (journaling) untuk mendetoksifikasi beban emosional.",
                            "Proyeksi Akhir: Mendapatkan tubuh yang bugar, pikiran yang jernih, dan gaya hidup yang sangat prima."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Kesehatan untuk Mencari Komunitas",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres kesehatan Anda terekam dengan matang.",
                            "Fase 1: Temukan klub kebugaran atau komunitas olahraga lokal di daerah Anda.",
                            "Fase 2: Ikuti *support group* atau komunitas peduli kesehatan mental terdekat.",
                            "Fase 3: Ajak lingkungan kampus untuk mengadakan senam bersama atau gerakan donor darah.",
                            "Fase 4: Ikuti perhelatan maraton massal (5K/10K) untuk merasakan antusiasme gaya hidup sehat.",
                            "Tindakan Wajib 1: Bergabung dengan komunitas lari pagi (Runners Club) atau gowes sepeda.",
                            "Tindakan Wajib 2: Menjadi panitia acara bakti sosial donor darah tahunan.",
                            "Tindakan Wajib 3: Berpartisipasi dalam diskusi kelompok sebaya mengenai manajemen stres.",
                            "Tindakan Wajib 4: Sosialisasikan bahaya merokok atau diet ekstrem di lingkungan pertemanan.",
                            "Proyeksi Akhir: Dikelilingi oleh orang-orang yang saling memotivasi untuk menjaga kebugaran fisik dan mental."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur Pengembangan: Transisi Bidang Kesehatan",
                            "Deskripsi: Peta jalan umum ini bertugas menuntun transisi awal Anda ke dalam ranah kesehatan secara bertahap dan sistematis.",
                            "Fase 1: Mulai dari riset pustaka dan observasi lingkungan.",
                            "Fase 2: Identifikasi peluang pengembangan diri yang tersedia.",
                            "Fase 3: Ikuti sesi pengantar dasar atau pelatihan perkenalan.",
                            "Fase 4: Deklarasikan tujuan utama (Karir/Skill/Hobi/Komunitas) secara tegas.",
                            "Tindakan Wajib 1: Pelajari silabus umum dari bidang terkait.",
                            "Tindakan Wajib 2: Tanyakan pengalaman orang-orang yang sudah lebih dulu terjun.",
                            "Tindakan Wajib 3: Dedikasikan setidaknya 2 jam per minggu untuk fokus.",
                            "Tindakan Wajib 4: Tetapkan tenggat waktu kapan Anda akan memilih fokus spesifik.",
                            "Proyeksi Akhir: Transisi yang lancar tanpa hambatan teknis menuju fase pendalaman spesialisasi."
                        );
                }
            case "Sains":
                switch (tujuan) {
                    case "Persiapan Karir":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Sains untuk Persiapan Karir",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres sains Anda terekam dengan matang.",
                            "Fase 1: Kuasai metodologi penelitian, perancangan eksperimen, dan literasi ilmiah dasar.",
                            "Fase 2: Tawarkan diri sebagai asisten riset (research assistant) di laboratorium dosen.",
                            "Fase 3: Publikasikan makalah penelitian Anda di jurnal ilmiah nasional maupun internasional.",
                            "Fase 4: Mulai persiapkan aplikasi beasiswa pascasarjana (S2/S3) atau program Fellowship.",
                            "Tindakan Wajib 1: Terlibat penuh dalam proyek penelitian payung milik program studi.",
                            "Tindakan Wajib 2: Pelajari cara menulis paper akademik (Scientific Writing) yang memenuhi standar IEEE/Scopus.",
                            "Tindakan Wajib 3: Presentasikan hasil temuan Anda pada konferensi sains antar-universitas.",
                            "Tindakan Wajib 4: Bangun koneksi dengan para pakar dan peneliti senior di bidang kajian Anda.",
                            "Proyeksi Akhir: Siap meniti karir akademis yang kokoh sebagai Ilmuwan, Peneliti, atau Dosen."
                        );
                    case "Pengembangan Skill":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Sains untuk Pengembangan Skill",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres sains Anda terekam dengan matang.",
                            "Fase 1: Pelajari perangkat lunak pengolahan statistik mutakhir (SPSS, R, Python Pandas).",
                            "Fase 2: Latih ketelitian dalam mengoperasikan instrumen dan alat laboratorium berat.",
                            "Fase 3: Tingkatkan kemampuan *Journal Reading* dengan membedah paper dari jurnal bergengsi.",
                            "Fase 4: Eksperimen dengan merancang model atau hipotesis pengujian secara mandiri.",
                            "Tindakan Wajib 1: Ikuti kursus *Data Science* untuk mengolah dataset riset berskala besar.",
                            "Tindakan Wajib 2: Biasakan membaca artikel dari jurnal Nature, Science, atau Elsevier secara kritis.",
                            "Tindakan Wajib 3: Susun tinjauan literatur (Literature Review) tentang topik sains terkini.",
                            "Tindakan Wajib 4: Lakukan simulasi komputasi atau pengujian teori dengan software spesifik.",
                            "Proyeksi Akhir: Menguasai keterampilan pengolahan data saintifik dan ketajaman analisa empiris tingkat tinggi."
                        );
                    case "Sekadar Hobi":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Sains untuk Sekadar Hobi",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres sains Anda terekam dengan matang.",
                            "Fase 1: Ganti tontonan santai Anda dengan tayangan edukatif, seperti kanal YouTube sains populer.",
                            "Fase 2: Belilah peralatan sederhana seperti teleskop portabel atau mikroskop saku.",
                            "Fase 3: Lakukan percobaan kimia atau fisika skala rumahan yang dijamin aman.",
                            "Fase 4: Jadikan topik fakta sains sebagai bahan obrolan pemecah kebekuan (*ice-breaker*) yang menarik.",
                            "Tindakan Wajib 1: Menonton video dari Veritasium, Vsauce, atau seri Cosmos.",
                            "Tindakan Wajib 2: Amati fenomena rasi bintang atau detail struktur daun di taman rumah.",
                            "Tindakan Wajib 3: Baca buku sains yang ramah awam karya Carl Sagan atau Neil deGrasse Tyson.",
                            "Tindakan Wajib 4: Kunjungi planetarium, kebun raya, atau museum sejarah alam terdekat.",
                            "Proyeksi Akhir: Memuaskan rasa ingin tahu intelektual (curiosity) yang mendalam secara menyenangkan."
                        );
                    case "Mencari Komunitas":
                        return Arrays.asList(
                            "Jalur Pengembangan: Strategi Eksekusi Sains untuk Mencari Komunitas",
                            "Deskripsi: Peta jalan ini menitikberatkan pada kronologi dan fase waktu pencapaian target. Ikuti instruksi pada setiap jenjang untuk memastikan progres sains Anda terekam dengan matang.",
                            "Fase 1: Bentuk Kelompok Studi Mahasiswa (KSM) khusus bagi pecinta teori dan riset.",
                            "Fase 2: Daftarkan tim Anda pada ajang perlombaan akademik bergengsi (Olimpiade Sains, PKM).",
                            "Fase 3: Seringlah mengunjungi seminar, diskusi panel, dan pameran inovasi teknologi sains.",
                            "Fase 4: Ciptakan proyek kolaborasi interdisipliner dengan mahasiswa dari fakultas lain.",
                            "Tindakan Wajib 1: Bergabung dengan Science Club kampus atau ikatan mahasiswa prodi.",
                            "Tindakan Wajib 2: Ikuti Pekan Ilmiah Mahasiswa Nasional (PIMNAS).",
                            "Tindakan Wajib 3: Adakan diskusi kelompok untuk membedah inovasi sains terbaru bersama pakar.",
                            "Tindakan Wajib 4: Jalin jejaring pertukaran informasi dengan klub sains dari universitas lain.",
                            "Proyeksi Akhir: Menjadi bagian dari lingkaran akademisi cerdas yang saling menantang gagasan inovatif."
                        );
                    default:
                        return Arrays.asList(
                            "Jalur Pengembangan: Transisi Bidang Sains",
                            "Deskripsi: Peta jalan umum ini bertugas menuntun transisi awal Anda ke dalam ranah sains secara bertahap dan sistematis.",
                            "Fase 1: Mulai dari riset pustaka dan observasi lingkungan.",
                            "Fase 2: Identifikasi peluang pengembangan diri yang tersedia.",
                            "Fase 3: Ikuti sesi pengantar dasar atau pelatihan perkenalan.",
                            "Fase 4: Deklarasikan tujuan utama (Karir/Skill/Hobi/Komunitas) secara tegas.",
                            "Tindakan Wajib 1: Pelajari silabus umum dari bidang terkait.",
                            "Tindakan Wajib 2: Tanyakan pengalaman orang-orang yang sudah lebih dulu terjun.",
                            "Tindakan Wajib 3: Dedikasikan setidaknya 2 jam per minggu untuk fokus.",
                            "Tindakan Wajib 4: Tetapkan tenggat waktu kapan Anda akan memilih fokus spesifik.",
                            "Proyeksi Akhir: Transisi yang lancar tanpa hambatan teknis menuju fase pendalaman spesialisasi."
                        );
                }
            default:
                return Arrays.asList(
                    "Jalur Pengembangan: Penemuan Jati Diri",
                    "Deskripsi: Peta jalan fundamental bagi individu yang masih mengeksplorasi potensi dan minat terpendam.",
                    "Fase 1: Bebaskan pikiran dan jangan membatasi diri pada satu bidang tertentu.",
                    "Fase 2: Terlibatlah secara aktif pada setiap kesempatan yang datang.",
                    "Fase 3: Analisis tingkat stres berbanding lurus dengan kepuasan setelah berkegiatan.",
                    "Fase 4: Fokuskan perhatian penuh pada 1 atau 2 bidang paling potensial.",
                    "Tindakan Wajib 1: Lakukan eksperimen minat selama 14 hari penuh.",
                    "Tindakan Wajib 2: Hindari zona nyaman dan cobalah kegiatan ekstrem secara positif.",
                    "Tindakan Wajib 3: Catat perkembangan mood dan antusiasme pada jurnal.",
                    "Tindakan Wajib 4: Mintalah pendapat obyektif dari teman terdekat.",
                    "Proyeksi Akhir: Menemukan kejelasan tujuan hidup dan landasan minat yang kuat."
                );
        }
    }
}
