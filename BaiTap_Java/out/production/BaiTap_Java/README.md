# Bài tập điểm 2D và 3D (Java)

## Cách biên dịch và chạy

Mở terminal trong thư mục chứa các file rồi chạy:

```text
javac -encoding UTF-8 Point2D.java Point3D.java Main.java
java Main
```

## Ý chính

- `Point2D` lưu `x` và `y` bằng thuộc tính `private final`; các phương thức cần dùng bên ngoài là `public`.
- `Point3D extends Point2D` kế thừa `x`, `y` và bổ sung tọa độ `z`.
- `symmetric()` được ghi đè trong `Point3D` để đổi dấu cả ba tọa độ. `translate()` có phiên bản 2D và phiên bản 3D.
- Danh sách trong `Main` có kiểu `List<Point2D>` nhưng chứa được cả `Point2D` lẫn `Point3D` nhờ kế thừa.
- Hai tổng khoảng cách là tổng độ dài nối các điểm cùng loại liên tiếp theo thứ tự xuất hiện trong danh sách ban đầu.
- Các thao tác đối xứng và tịnh tiến tạo điểm mới, không sửa tọa độ của đối tượng cũ.
