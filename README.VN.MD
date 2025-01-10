# Ngôn ngữ
[![en](https://img.shields.io/badge/lang-en-blue.svg)](https://github.com/PhucTan1705/HealthCareApp/blob/master/README.md)
[![vn](https://img.shields.io/badge/lang-vn-red.svg)](https://github.com/PhucTan1705/HealthCareApp/blob/master/README.VN.md)

---
# The HealthCare App

## Tổng quan:

Một ứng dụng chăm sóc sức khỏe tích hợp với nhiều tính năng, cho phép người dùng dễ dàng đăng ký và tạo tài khoản để thực hiện các hoạt động như đặt mua thuốc trực tuyến, tra cứu thông tin sức khỏe chi tiết, đặt lịch hẹn với bác sĩ, và cập nhật nhanh chóng các tin tức y tế hữu ích...
<div align="center">
  <span><kbd><img src="https://drive.google.com/uc?export=view&id=1c6WeQpqzViW-3M40Gq0hfdwCNHw01fbu" width="300" height="530"  hspace="10"></kbd></span>
  <span><kbd><img src="https://drive.google.com/uc?export=view&id=1Lg5-IUjwgSIMzOB6nbK_dOalhw6DRF64" width="300" height="530"  hspace="10"></kbd></span>
  <span><kbd><img src="https://drive.google.com/uc?export=view&id=1WGZhbed6K_1I2bA6tk2YKrG1Rpux8bOY" width="300" height="530"  hspace="10"></kbd></span>
  <span><kbd><img src="https://drive.google.com/uc?export=view&id=1twCk7_bKgGghP9elLY_mL37js4KT370f" width="300" height="530"  hspace="10"></kbd></span>
</div>

## Cài đặt:

### 1. Razorpay:

Cài đặt Razorpay Java SDK và tích hợp nó với trang web hoặc ứng dụng dựa Java của bạn để chấp nhận thanh toán, hoàn tiền và thực hiện nhiều chức năng khác.

[Tìm hiểu thêm](https://razorpay.com/docs/payments/)

#### Tạo tài khoản Razorpay:

Nếu bạn mới sử dụng Razorpay, bạn có thể tạo tài khoản Razorpay trực tiếp từ ứng dụng di động. Nếu bạn đã là người dùng Razorpay, hãy đăng nhập vào ứng dụng Razorpay Payments Mobile bằng thông tin đăng nhập từ Razorpay Dashboard của bạn.

[Tìm hiểu thêm](https://razorpay.com/docs/payments/mobile-app/get-started/#create-a-new-account)

#### Dependencies:

- Bạn phải sử dụng Java v15 hoặc cao hơn. Tìm hiểu thêm về các [phiên bản của Java](https://www.java.com/releases/).
- Thêm các gói sau trước khi bắt đầu:

```
import org.json.JSONObject;
import com.razorpay.*;
```

#### Cài đặt:

- Bạn có thể cài đặt Razorpay bằng Gradle:
  + Tải và [Cài đặt Gradle](https://gradle.org/install/) trên máy tính của bạn.
- Tải bản mới nhất của [Razorpay](https://github.com/razorpay/razorpay-java/releases) ở trên GitHub.
- Giải nén và thêm các dependency để tạo file dự án:

```
implementation 'com.razorpay:razorpay-java:x.y.z" //x.y.z = the version you want to install
```

[Tìm hiểu thêm](https://razorpay.com/docs/payments/server-integration/java/)

### 2. Làm quen với SQLite:

SQLite là một thư viện in-process cung cấp một hệ quản trị cơ sở dữ liệu SQL độc lập, không cần máy chủ, không cần cấu hình và hỗ trợ giao dịch. Mã nguồn của SQLite thuộc phạm vi công cộng (public domain), do đó, hoàn toàn miễn phí để sử dụng cho bất kỳ mục đích nào, dù là thương mại hay cá nhân. SQLite là cơ sở dữ liệu được triển khai rộng rãi nhất trên thế giới, với số lượng ứng dụng sử dụng vượt quá khả năng đếm, bao gồm nhiều dự án nổi bật.

[Tìm hiểu thêm](https://www.sqlite.org/about.html)

[Tài liệu](https://www.sqlite.org/docs.html)

### 3. Cài SQLite:

#### Cài đặt:

- Bước 1 − Vào [Trang Download](https://www.sqlite.org/download.html) của SQLite, và tải phiên bản cho Windows.
- Bước 2 − Tải tệp: sqlite-tools-win-x64.zip and sqlite-dll-win-x64.zip.
- Bước 3 − Tạo thư mục C:\>sqlite và giải nén hai tệp ở trên vào thư mục này, bạn sẽ nhận được ba tệp: sqlite3.def, sqlite3.dll and sqlite3.exe files.
- Bước 4 − Thêm đường dẫn C:\>sqlite vào PATH environment variable và mở command prompt và chạy lệnh sqlite3, kết quả sau đây sẽ được hiển thị:

```
C:\>sqlite3
SQLite version 3.7.15.2 2013-01-09 11:53:05
Enter ".help" for instructions
Enter SQL statements terminated with a ";"
sqlite>
```

#### Sử dụng SQLite để lưu dữ liệu:

Các API bạn cần để sử dụng cơ sở dữ liệu trên Android có sẵn trong gói [android.database.sqlite](https://developer.android.com/reference/android/database/sqlite/package-summary).

#### Schema và contract:

- Sơ đồ (schema) được phản ánh trong các câu lệnh SQL mà bạn sử dụng để tạo cơ sở dữ liệu.
- Lớp giao ước (contract class) là một container chứa các hằng số định nghĩa tên cho URI, bảng và cột. Ví dụ

```
public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
```

#### Sử dụng SQL helper để tạo CSDL:

Sau khi bạn đã định nghĩa cấu trúc của cơ sở dữ liệu, bạn nên triển khai các phương thức để tạo và duy trì cơ sở dữ liệu cũng như các bảng. Dưới đây là một số câu lệnh điển hình để tạo và xóa bảng:

```
private static final String SQL_CREATE_ENTRIES =
    "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
    FeedEntry._ID + " INTEGER PRIMARY KEY," +
    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
    FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

private static final String SQL_DELETE_ENTRIES =
    "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
```

[Tìm hiểu thêm](https://developer.android.com/training/data-storage/sqlite#java)

### 4. Khởi chạy dự án:

- Bước 1: Tải và giải nén tệp dự án ơ trên github.
- Bước 2: Mở Android Studio. Chọn File -> New -> Import Project.
- Bước 3: Chọn dự án mà bạn muốn import và chọn Next->Finish.
- Bước 4: Gradle sẽ được khởi tạo tự động, và sau khi nó hoàn thành, nhấn Run app để chạy dự án.
