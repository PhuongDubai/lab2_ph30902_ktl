package com.example.lab2_ph30902_ktl

import java.util.*

// Lớp để quản lý thông tin của sinh viên
class SinhVien(
    val hoTen: String,
    val tuoi: Int,
    val lop: String
)

// Lớp để quản lý thông tin của thẻ mượn sách
class TheMuon(
    val maPhieuMuon: String,
    val ngayMuon: Int,
    val hanTra: Int,
    val soHieuSach: String,
    val sinhVien: SinhVien
)

// Lớp để quản lý danh sách các thẻ mượn sách và các thao tác liên quan
class QuanLyTheMuon {
    val danhSachTheMuon = mutableListOf<TheMuon>()

    // Phương thức thêm một thẻ mượn sách mới
    fun themTheMuon(theMuon: TheMuon) {
        danhSachTheMuon.add(theMuon)
    }

    // Phương thức xóa một thẻ mượn sách dựa trên mã phiếu mượn
    fun xoaTheMuon(maPhieuMuon: String) {
        val themuon = danhSachTheMuon.find { it.maPhieuMuon == maPhieuMuon }
        if (themuon != null) {
            danhSachTheMuon.remove(themuon)
            println("Xóa thành công phiếu mượn có mã số $maPhieuMuon")
        } else {
            println("Không tìm thay phiếu mượn có mã số là $maPhieuMuon.")
        }
    }

    fun xemDanhSachTheMuon() {
        if (danhSachTheMuon.isEmpty()) {
            println("Danh sách thẻ mượn trống ")

        } else {
            println("Danh sách các thẻ mượn sách:")
            for (theMuon in danhSachTheMuon) {
                println(
                    "Mã phiếu mượn: ${theMuon.maPhieuMuon}, Ngày mượn: ${theMuon.ngayMuon}, Hạn trả: ${theMuon.hanTra}, Số hiệu sách: ${theMuon.soHieuSach}, Sinh viên mượn sách: ${theMuon.sinhVien.hoTen},Tuổi sinh viên: ${
                        theMuon.sinhVien.tuoi
                    }, Lớp: ${theMuon.sinhVien.lop}"
                )
            }
        }
    }


}

// Hàm main để sử dụng các lớp đã định nghĩa
fun main() {
    val quanLyTheMuon = QuanLyTheMuon()

    // Thêm một số thẻ mượn sách mới
    val sinhVien1 = SinhVien("Nguyen Van A", 20, "K61C")
    val theMuon1 = TheMuon("PM001", 1, 7, "SH001", sinhVien1)
    quanLyTheMuon.themTheMuon(theMuon1)

    val sinhVien2 = SinhVien("Tran Thi B", 21, "K62A")
    val theMuon2 = TheMuon("PM002", 3, 10, "SH002", sinhVien2)
    quanLyTheMuon.themTheMuon(theMuon2)

    val scanner = Scanner(System.`in`)
    var choice: Int

    do {
        println("+==========================================+")
        println("|      CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN      |")
        println("|        1. Thêm thẻ mượn viên mới         |")
        println("|            2. Xóa phiếu mượn             |")
        println("|        3. Xem danh sách phiếu mượn       |")
        println("|          0. Thoát chương trình           |")
        println("+==========================================+")
        print("Nhập lựa chọn của bạn: ")
        choice = scanner.nextInt()

        when (choice) {
            1 -> {
                println("Nhập Thông tin sinh viên")
                print("Nhập tên sinh viên: ")
                val hoTen = readLine() ?: ""
                print("Nhập tuổi sinh viên: ")
                val tuoi = scanner.nextInt()
                print("Nhập lớp sinh viên: ")
                val lop = readLine() ?: ""
                val SV = SinhVien(hoTen, tuoi, lop)

                println("Nhập thông tin phiếu mượn mới")
                print("Mã Phiếu mượn mới: ")
                val maPH = readLine() ?: ""
                print("Ngày Mượn: ")
                val ngayMuon = scanner.nextInt()
                print("Hạn trả:")
                val hanTra = scanner.nextInt()
                print("Nhập số hiệu sách:")
                val soHieuSach = readLine() ?: ""

                quanLyTheMuon.themTheMuon(TheMuon(maPH, ngayMuon, hanTra, soHieuSach, SV))
                println("CBGV đã được thêm vào danh sách.")
            }

            2 -> {
                // Xóa the muon
                print("Nhập mã số mã phiếu cần xóa: ")
                val maSo = readLine() ?: ""
                quanLyTheMuon.xoaTheMuon(maSo)
            }

            3 -> {
                quanLyTheMuon.xemDanhSachTheMuon()
            }
            0 -> {
                println("Kết thúc chương trình.")
            }
        }
    } while (choice != 0)

}
