# Demo FetcherType và CascadeType

## Tổng quát về Project
- Cơ sở dữ liệu: Posgres
	- Gồm 2 bảng Classes và Students có quan hệ 1-n
	- Tạo bảng và thêm dữ liệu bằng câu lệnh SQL trong file sql_Simple.txt
- Là một Maven Project, cấu hình <dependency> Hibernate 5.2.
- Cơ sở dữ liệu được mapping = annotation

## Cài đặt
- Tạo cở sở dữ liệu sql_Simple theo câu lệnh trong file sql_Simple.txt
- Import Project vào IntelliJ
- Kiểm tra file cấu hình hibernate.cfg.xml
- Kiểm tra các Persistence và class HibernateUtil
- Chạy thử chương trình Query01: in ra danh sách sinh viên có trong cơ sở dữ liệu

## Kịch bản demo

### Demo FetcherType

#### Quy trình thực hiện:
- Class kiểm tra: Query02Fetch
- Vào phần cài đặt one-to-many ở class Classes và many-to-one ở class Students
- Bỏ "chú thích //" ở chế độ muốn chạy thử, ở đây là FetcherType.LAZY
- Chạy thử Query02Fetch, xem kết quả (1)
- Quay lại Query02Fetch, sửa chương trình: đóng session sau thao tác, chạy thử lại Query02Fetch và xem kết quả (2)
- Quay lại 2 class Classes và Students chọn chế độ FetcherType.EAGER bằng cách bỏ "chú thích //" của nó và vô hiệu hoá FetcherType.LAZY
- Đóng session trước thao tác in sinh viên lệnh: session.close();
- Chạy thử Query02Fetch, xem kết quả (3)

#### Kết quả:
- (1): Chương trình sẽ báo lỗi vì đối tượng con (Students) không thể gọi qua đối tượng cha (Classes) khi session đã bị đóng.
- (2): Chương trình sẽ chạy được vì lúc này ta đóng session ở cuối.
- (3): Chương trình sẽ chạy được với chế độ FetcherType.EAGER.

### Demo CascadeType

#### Quy trình thực hiện:
- Class kiểm tra: Query03Cascade
- Vào phần cài đặt one-to-many ở class Classes và many-to-one ở class Students
- Bỏ "chú thích //" ở chế độ muốn chạy thử, ở đây là CascadeType.DETACH
- Chạy thử Query03Cascade, xem kết quả (4)
- Xoá bản ghi id_classes = 13
- Quay lại 2 class Classes và Students chọn chế độ CascadeType.ALL bằng cách bỏ "chú thích //" của nó và vô hiệu hoá CascadeType.DETACH
- Chạy thử Query03Cascade, xem kết quả (5)

#### Kết quả:
- (4) Mở bảng Students và Classes ra, ta thấy chỉ có đối tượng cl13 id_classes=13 trong Classes được tạo ra và thêm vào CSDL, còn đối tượng cl12 và 2 đối tượng std1, std2 không được thêm vào bản ghi
- (5) Mở bảng Students và Classes ra, ta thấy cả 4 đối tượng cl12 cl13 std1 std2 đều được thêm vào CSDL

