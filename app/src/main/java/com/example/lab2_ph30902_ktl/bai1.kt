fun main() {
    var a = 0.0
    var b = 0.0
    print("Nhap a:")
    var s = readLine()
    if (s != null) a = s.toDouble()
    print("Nhap b:")
    s = readLine()
    if (s != null) b = s.toDouble()
    if (a == 0.0 && b == 0.0) {
        println("Phuong trinh vo so nghiem")

    } else if (a == 0.0 && b != 0.0) {
        println("Phuong trinh vo nghiem")

    } else {
        val x = -b / a
        println("No x= " + x)
    }

}