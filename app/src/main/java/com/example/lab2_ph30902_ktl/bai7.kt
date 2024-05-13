package com.example.lab2_ph30902_ktl

import java.util.Scanner

// Lớp để quản lý thông tin cá nhân của mỗi cá nhân
open class Nguoi(
    val hoTen: String,
    val tuoi: Int,
    val queQuan: String,
    val maSo: String
)

// Lớp để quản lý thông tin của cán bộ giáo viên
class CBGV(
     hoTen: String,
    tuoi: Int,
    queQuan: String,
    maSo: String,
    var luongCung: Double,
    var luongThuong: Double,
    var tienPhat: Double
) : Nguoi(hoTen, tuoi, queQuan, maSo) {
    // Phương thức tính lương thực lĩnh
    fun tinhLuongThucLinh(): Double {
        return luongCung + luongThuong - tienPhat
    }
}

// Lớp để quản lý danh sách các cán bộ giáo viên và các thao tác liên quan
class QuanLyCBGV {
    val danhSachCBGV = mutableListOf<CBGV>()

    // Phương thức thêm một cán bộ giáo viên mới
    fun themCBGV(cbgv: CBGV) {
        danhSachCBGV.add(cbgv)
    }

    // Phương thức xóa một cán bộ giáo viên dựa trên mã số giáo viên

    fun xoaCBGV(maSo: String) {
        val canbo = danhSachCBGV.find { it.maSo == maSo }
        if (canbo != null) {
            danhSachCBGV.remove(canbo)
            println("Xóa thành công cán bộ có mã số $maSo")
        } else {
            println("Không tìm thay cán bộ có mã số là $maSo.")
        }
    }
    fun xemDanhSachCBGV() {
        if (danhSachCBGV.isEmpty()) {
            println("Danh sách cán bộ trống ")

        } else {
            danhSachCBGV.forEach {
                println("Tên CB: ${it.hoTen}, Tuoi: ${it.tuoi}, Quê quán: ${it.queQuan}, Mã số: ${it.maSo}, Lương cứng: ${it.luongCung},Lương thưởng: ${it.luongThuong},Tiền phạt: ${it.tienPhat},Lương thực nhận đc : ${it.tinhLuongThucLinh()}")

            }
        }
    }
}

// Sử dụng các lớp đã định nghĩa
fun main() {
    val quanLy = QuanLyCBGV()
    quanLy.themCBGV(CBGV("Nguyễn Công Phương" , 20,"hà nội" , "GV001" , 7000.0,2000.0,100.0 ))
    val scanner = Scanner(System.`in`)
    var choice: Int

    do {
        println("+==========================================+")
        println("|      CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN      |")
        println("|       1. Thêm cán bộ giáo viên mới       |")
        println("|          2. Xóa cán bộ giáo viên         |")
        println("|    3. Xem danh sách cán bộ giáo viên     |")
        println("|          0. Thoát chương trình           |")
        println("+==========================================+")
        print("Nhập lựa chọn của bạn: ")
        choice = scanner.nextInt()

        when (choice) {
            1 -> {
                println("Nhập thông tin cán bộ mới")
                print("Tên CBGV: ")
                val tenCB = readLine() ?: ""
                print("Tuổi CBGV: ")
                val tuoiCB = scanner.nextInt()
                print("Quê quán CBGV:")
                val queCB = readLine() ?: ""
                print("Nhập lương cứng:")
                val luongCungCB = scanner.nextDouble()
                print("Nhập lương thưởng:")
                val luongThuongCB = scanner.nextDouble()
                print("Nhập tiền phạt:")
                val tienPhatCB = scanner.nextDouble()

                quanLy.themCBGV(CBGV(tenCB, tuoiCB, queCB, "GV00${quanLy.danhSachCBGV.size + 1}", luongCungCB, luongThuongCB, tienPhatCB))
                println("CBGV đã được thêm vào danh sách.")
            }
            2 -> {
                // Xóa CBGV
                print("Nhập mã số CBGV cần xóa: ")
                val maSo = readLine() ?: ""
                quanLy.xoaCBGV(maSo)
            }
            3 -> {
                println("Danh sách cán bộ:")
                quanLy.xemDanhSachCBGV()
            }
            0 -> {
                println("Kết thúc chương trình.")
            }
        }

//        // In danh sách CBGV
//        println("Danh sách cán bộ giáo viên sau khi thực hiện các thao tác:")
//        for (cbgv in quanLy.danhSachCBGV) {
//            println("${cbgv.hoTen}: Lương thực lĩnh = ${cbgv.tinhLuongThucLinh()} VND")
//        }
    } while (choice != 0)
}

