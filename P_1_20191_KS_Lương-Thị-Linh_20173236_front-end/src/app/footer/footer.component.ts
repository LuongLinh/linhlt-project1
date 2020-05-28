import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
vebibis = ['Giới thiệu', 'Thướng hiệu phân phối', 'Hệ thống cửa hàng'];
chinhsachs = ['Chính sách thanh toán', 'Vận chuyển & giao nhận hàng',
              'Chính sách đổi, trả, hoàn tiền', 'Bảo mật thông tin'];
hds = ['Hướng dẫn mua hàng', 'Hướng dẫn chọn size', 'Xem đơn hàng',
      'Khuyến mãi, Mã giảm giá, Voucher', 'Phản hồi chất lượng, dịch vụ'];
  constructor() { }

  ngOnInit() {
  }

}
