Kiến trúc phân lớp xử lý
Sơ đồ luồng (Layered Architecture):

Controller Layer

Nhận request từ client (REST API).

Gọi TransactionService.performTransaction().

Không chứa logic kiểm duyệt hay logging.

Service Layer (TransactionService)

Chỉ giữ lại logic cốt lõi: cập nhật giao dịch vào DB.

Không kiểm tra số tiền, không kiểm tra ví, không log.

AOP Layer (Aspect)

Kiểm tra dữ liệu đầu vào: số tiền âm, địa chỉ ví ngắn.

Kiểm tra giao dịch > 10,000 USD → ném HighRiskException.

Ghi log request/response.

Tách toàn bộ logic kiểm duyệt ra khỏi Service.

GlobalExceptionHandler

Gom toàn bộ Exception thành JSON chuẩn.

Trả về HTTP 400 với format thống nhất.