import java.util.Scanner

class SinhVien(
    var tenSV: String,
    var mssv: String,
    var diemTB: Float,
    var daTotNghiep: Boolean?,
    var tuoi: Int?

)

class QuanLySinhVien() {
    private val danhSachSinhVien = mutableListOf<SinhVien>()
    fun themSinhVien(sv: SinhVien) {
        danhSachSinhVien.add(sv)

    }

    fun xoaSinhVien(mssv: String) {
        val sinhvien = danhSachSinhVien.find { it.mssv == mssv }
        if (sinhvien != null) {
            danhSachSinhVien.remove(sinhvien)
        } else {
            println("Không tìm thấy sinh viên có MSSV là $mssv.")
        }
    }

    fun suaThongTinSinhVien(
        mssv: String,
        tenMoi: String,
        diemTBMoi: Float,
        daTotNghiepMoi: Boolean?,
        tuoiMoi: Int?
    ) {
        val sinhvien = danhSachSinhVien.find { it.mssv == mssv }
        if (sinhvien != null) {
            sinhvien.apply {
                tenSV = tenMoi
                diemTB = diemTBMoi
                daTotNghiep = daTotNghiepMoi
                tuoi = tuoiMoi

            }
            println("Thông tin sinh viên đã được cập nhật")
        } else {
            println("không tìm thấy sinh viên có MSSV là : $mssv.")
        }
    }

    fun xemDanhSachSinhVien() {
        if (danhSachSinhVien.isEmpty()) {
            println("Danh sách sinh viên trống ")

        } else {
            danhSachSinhVien.forEach {
                println("Tên SV: ${it.tenSV}, MSSV: ${it.mssv}, Điểm TB: ${it.diemTB}, Đã tốt nghiệp: ${it.daTotNghiep}, Tuổi: ${it.tuoi}")

            }
        }
    }
}

fun main() {
    val quanLySV = QuanLySinhVien()
    quanLySV.themSinhVien(SinhVien("Nguyen Van Linh", "sv01", 8.5f, true, 20))
    quanLySV.themSinhVien(SinhVien("Tuan Kon", "sv02", 7.9f, true, 21))
    quanLySV.themSinhVien(SinhVien("Calobiado", "sv03", 6.8f, false, 19))

    val scanner = Scanner(System.`in`)
    var choice: Int
    do {
        println("+===============================+")
        println("|CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN |")
        println("|        1. Thêm sinh viên      |")
        println("|    2. Sửa thông tin sinh viên |")
        println("|        3. Xóa sinh viên       |")
        println("|    4. Xem danh sách sinh viên |")
        println("|      0. Thoát chương trình    |")
        println("+===============================+")
        print("Nhập lựa chọn của bạn: ")
        choice = scanner.nextInt()

        when (choice) {
            1 -> {
                println("Nhập thông tin sinh viên moi")
                print("Tên sinh viên: ")
                val tenSV = readLine() ?: ""
                print("Nhập mã sinh viên:")
                val masv = readLine() ?: ""
                print("Nhập điểm tb:")
                val diemTB = scanner.nextFloat()
                print("Đã tốt nghiệp (true/false): ")
                val daTotNghiep = scanner.nextBoolean()
                print("Tuổi: ")
                val tuoi = scanner.nextInt()
                quanLySV.themSinhVien(SinhVien(tenSV, masv, diemTB, daTotNghiep, tuoi))
                println("Sinh viên đã được thêm vào danh sách.")
            }

            2 -> {
                print("Nhập MSSV của sinh viên cần sửa thông tin: ")
                val mssv = readLine() ?: ""
                val sinhvien = quanLySV.xemDanhSachSinhVien()

                if (sinhvien != null) {
                    println("Nhập thông tin mới cho sinh viên:")
                    print("Tên mới: ")
                    val tenMoi = readLine() ?: ""
                    print("Điểm TB mới: ")
                    val diemTBMoi = scanner.nextFloat()
                    print("Đã tốt nghiệp mới (true/false): ")
                    val daTotNghiepMoi = scanner.nextBoolean()
                    print("Tuổi mới: ")
                    val tuoiMoi = scanner.nextInt()
                    quanLySV.suaThongTinSinhVien(mssv, tenMoi, diemTBMoi, daTotNghiepMoi, tuoiMoi)
                } else {
                    println("Không tìm thấy sinh viên có MSSV là $mssv.")
                }
            }

            3 -> {
                println("Nhập MSSV của sinh viên cần xóa: ")
                val mssv = readLine() ?: ""
                quanLySV.xoaSinhVien(mssv)
            }

            4 -> {
                println("Danh sách sinh viên:")
                quanLySV.xemDanhSachSinhVien()
            }

            0 -> {
                println("Kết thúc chương trình.")
            }
        }
    } while (choice != 0)
}

