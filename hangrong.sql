CREATE DATABASE HANGRONG
GO
USE HANGRONG
GO

CREATE TABLE THANHVIEN
    (
      TENDANGNHAP NVARCHAR(50) PRIMARY KEY,
      MATKHAU NVARCHAR(100),
      TEN NVARCHAR(60) ,
      DIACHI NVARCHAR(60) ,
      SODIENTHOAI VARCHAR(30) ,
      NGAYTHAMGIA NVARCHAR(50) ,
      ANH NVARCHAR(1000) ,
      CHUCNANG NVARCHAR(50)
    )
GO
CREATE TABLE DANHMUC
    (
      MADANHMUC nvarchar(10) primary key,
      TenDanhMuc nvarchar(100)
      )
 go
CREATE TABLE MATHANG
    (
      MAMATHANG INT IDENTITY PRIMARY KEY,
      TENMATHANG NVARCHAR(100),
      NGAYDANG NVARCHAR(100) ,
      MADANHMUC nvarchar(10) Foreign key References DANHMUC (MADANHMUC),
      TINHTRANG NVARCHAR(50),
      Anh NVARCHAR(1000),
      Gia NUMERIC(19,0),
      MOTA NVARCHAR(500),
      NGUOIBAN NVARCHAR(50) FOREIGN KEY REFERENCES THANHVIEN (TENDANGNHAP)
    )
GO


/*danh mục*/
INSERT INTO DANHMUC
VALUES ('HRXE',N'Hàng rong xe')
INSERT INTO DANHMUC
VALUES ('HRNHA',N'Hàng rong nhà')
INSERT INTO DANHMUC
VALUES ('DGD',N'Đồ Gia Dụng')
INSERT INTO DANHMUC
VALUES ('DTCN',N'Điện tử công nghệ')
INSERT INTO DANHMUC
VALUES ('GTTT',N'Giải trí thể thao')
INSERT INTO DANHMUC
VALUES ('SPK',N'Sản Phẩm Khác')


/* Bảng Thành Viên*/
INSERT INTO THANHVIEN
VALUES('ngoc96','123',N'Lò Hồng Ngọc',N'Sơn La','08942244','08-09-2010','http://media.we25.vn/images/anh-the1.jpg','ADMIN')

INSERT INTO THANHVIEN
VALUES('PH002','234',N'Nguyễn Duy Thế',N'Thái Bình','0987654321','2-1-2012','https://kenh14cdn.com/k:vAlPVSnI3KlTFY5PiLWE2U51feyJY/Image/2014/12/anh_the9113-c11b9/ngam-anh-the-ngo-tau-cuc-dang-yeu-cua-hot-boy-viet.jpg','KHACHHANG')

INSERT INTO THANHVIEN
VALUES('PH003','456',N'Trần Thị Lương',N'Thanh Hóa','01626171997','7-6-2012','http://anhvienpiano.com/wp-content/uploads/2016/10/dich-vu-chup-anh-the-lay-ngay-sau-5-phut-3.jpg','KHACHHANG')

INSERT INTO THANHVIEN
VALUES('PH004','567',N'Vũ Trọng Hậu',N'Thanh Hóa','0988245776','5-8-2013','http://i.imgur.com/Dm684QQ.jpg','KHACHHANG')

INSERT INTO THANHVIEN 
VALUES('PH005','678',N'Đoàn Quốc Huy',N'Hải Phòng','0988555565','5-8-2011','http://st.phunulife.vn/staticFile/Subject/2017/08/28/21124342_1958743107700386_688619120_n_281959293.jpg?w=414','KHACHHANG')


/* Bảng mặt hàng */

INSERT INTO MATHANG
VALUES ('TiVi','2-5-2013','DGD',N'Đang bán','https://cdn4.tgdd.vn/Products/Images/1942/79069/tivi-led-asanzo-25t350-550x340-1-550x340.png;https://sc02.alicdn.com/kf/HTB1r59_JpXXXXXDaXXXq6xXFXXXY/New-model-55-LED-TV.jpg;https://cdn.mediamart.vn/Product/tivi-sony-40-inch-40r350d-full-hd-mxr-100hz-xScIJk.jpg;http://topgia.vn/nch/images/2016/10/10/co-nen-mua-tivi-panasonic-0.jpg;https://cdn3.tgdd.vn/Products/Images/1942/71073/tivi-led-samsung-ua24j4100-4-550x340-550x340.jpg;','15000000',N'Smart Tivi LG 4K 65 inch 65UJ632T mang trong mình kiểu dáng hiện đại, đầy phong cách với tông đen sang trọng, mạnh mẽ, làm nên điểm nhấn ấn tượng trong phong cách thiết kế nội thất cho ngôi nhà bạn.
Bên cạnh đó, chân đế của tivi cũng được tạo kiểu hình chữ V úp ngược hài hòa, cho phép tivi có thể trụ vững trên nhiều dạng mặt phẳng khác nhau.','PH002')


INSERT INTO MATHANG
VALUES (N'Điều Hòa','3-5-2013','DGD',N'Hết Hàng','https://cdn.mediamart.vn/Product/-L1S8Ve.jpg;https://cdn.mediamart.vn/Product/-7kW4GD.jpg;http://hanelstore.vn/Uploads/images/Issue/Dieuhoa/IMG_5772.jpg;http://dieuhoabonmua.vn/wp-content/uploads/2016/11/dieu-hoa-casper-1-chieu-9000Btu-LC-09TL11.jpg;http://yesbuy.vn/sites/default/files/23811_16243_dieu-hoa-1-chieu-panasonic-cucs-yc9rkh-8-9000btu.jpg;','20000000',N'ĐIỀU HÒA 1 CHIỀU MIDEA MSMA1-09CR 9.000 BTU','PH003')


INSERT INTO MATHANG
VALUES (N'Xe','4-3-2013','HRXE',N'Đang bán','http://decalbinhduong.com/upload/images/tem-exciter150-monster-do-den-dep-nhat.jpg;http://media.giadinhvietnam.com/files/news/2015/02/10/1499068193.jpg;https://file.xemaycugiare.com/2016/07/11/20160711054109-ed99.jpeg;http://znews-photo-td.zadn.vn/w660/Uploaded/mfssa/2014_12_23/Exciter.jpg','50000000',N'Xe máy chính hãng Honda','PH004')

INSERT INTO MATHANG
VALUES (N'Điện Thoại','5-6-2012','DTCN',N'Đang chờ phê duyệt ','http://dhdeal.vn/images/stories/virtuemart/product/10157397_768780243265375_1481604284710848246_n.jpg;https://cdn.tgdd.vn/Products/Images/42/91920/epic-x9-plus-300-300x300.jpg;https://cdn.pico.vn/Product/33547/236691_mnqm2vna.jpg;https://www.thongtincongnghe.com/sites/default/files/images/2014/9/19/dap-hop-nokia-130-11.jpg;https://bizweb.dktcdn.net/100/245/134/products/dien-thoai-de-ban-panasonic-kxt7730-ouao26-1.jpg?v=1504085036240','2000000',N'Điện Thoại Nhập Khẩu','Ph005')

INSERT INTO MATHANG
VALUES (N'Laptop','7-2-2012','DTCN',N'Đang bán','http://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c05474005.png;https://c.s-microsoft.com/ja-jp/CMSImages/surface_L_Pivot-Blue-pos4_V2.jpg?version=a81a4f77-6cb4-a415-c4bc-486e11114fa1;https://cnet1.cbsistatic.com/img/IpuAKOhEDPeqd68CLY0UFlquv9M=/770x433/2017/03/31/c91b45cb-327a-47c9-a0d6-b5e9b53c789c/lenovo-ideapad-110s-7184-010.jpg;http://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c05535772.png;https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/m/bp/mbp15touch/gray/mbp15touch-gray-select-201610?wid=452&hei=420&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=1496611018929;','10000000',N'Bán lẻ Laptop chính hãng, HP, Dell, Asus, Lenovo... ✓Bảo hành chính hãng ✓Giao hàng toàn quốc ✓Cho phép đổi trả ✓Mua trả góp lãi suất thấp.','PH002')

INSERT INTO MATHANG
VALUES (N'Ô Tô','9-1-2013','HRXE',N'Đang chờ phê duyệt','https://img1.banxehoi.com/2016/05/04/20160504221159-d978_wm.jpg;http://cdn.muabannhanhoto.com/asset/home/img/500/55a870f7377a4_1437102327.jpg;https://muasamxe.com/uploadimg/upload/watermark-o-to-moi-mazda-6-2-0-premium-2017-1_big.jpg;https://img2.banxe.info/2016/12/02/c47eb9289f61c193407561000x740-9aab.jpg;http://sanotovietnam.com.vn/upload/2016/7/480-madaz-3-sanotovietnam-com-vn.jpg','20000000',N'Mẫu Oto đươc ưa chuộng nhất Việt Nam 2017','PH004')

INSERT INTO MATHANG
VALUES (N'Bất Động Sản','5-6-2013','HRNHA',N'Đang bán','http://resort.flamingodailai.com/sites/default/files/styles/1200x600/public/field/image/luu-tru/bt-bach-thanh-3.jpg?itok=xgvlHLIc;http://bdsdulich.vn/du-an/cover/mau-biet-thu-nghi-duong-hien-dai-1.jpg;http://www.keangnamapartments.com/images/users/images/vinhomes-riverside-villas.jpg;http://www.villasvinhomesriverside.com/images/products/cornerpostioned-3-bedroom-villa-for-rent-in-vinhomes-riverside-long-bien-hanoi_2015728105401.JPG;http://tanthoidai.com.vn/images/gallery/images/D%E1%BB%B1%20%C3%A1n%20Vinhomes%20Riverside/Vinhomes%20Riverside7.jpg','10000000',N'Biệt Thự Nghỉ Dưỡng','PH004')

INSERT INTO MATHANG 
VALUES (N'Quần Áo','3-1-2014','SPK',N'Đang bán','http://resources.cungmua.com/Product/cm_b25881.jpg;http://resources.nhommua.com/FTPProduct/27679/ao-thun-nam-nu-chu-s-viet-nam(1).jpg;http://s2-media.123mua.vn/2014/c/0/c0ab4dec947449ba2fafcb8f481c1ce9.jpg;http://resources.cungmua.com/ftpproduct/23093/ao-thun-nam-dam-nu-thoi-trang-gia-re%20(2).jpg;https://xuongquanao.vn/wp-content/uploads/2017/01/ao-thun-tay-dai-arsenal.jpg','200000',N'Quần áo đôi nam nữ hot nhất 2017','PH003')

INSERT INTO MATHANG
VALUES (N'SPINNER','2-5-2015','GTTT',N'Đang bán','https://ae01.alicdn.com/kf/HTB1VlL1RVXXXXbSaXXXq6xXFXXXQ/Captain-America-Fidget-Spiner-Metal-Shield-Finger-Slide-Spinner-For-ADHD-Anxiety-Stress-Relief-Wheel-Alloy.jpg_640x640.jpg;https://ae01.alicdn.com/kf/HTB1VJACQVXXXXatXXXXq6xXFXXX0/Doub-K-Metal-Finger-spiner-Tri-Spinner-spiners-puzzle-Toy-For-Adult-children-Anxiety-Stress-Relief.jpg_640x640.jpg;https://www.dhresource.com/0x0s/f2-albu-g5-M01-57-A7-rBVaJFj_Ii2AB5jeAATLT1DlrJ4804.jpg/new-colorful-crab-spiner-hand-spinner-decompression.jpg;https://www.dhresource.com/0x0s/f2-albu-g5-M00-A5-4F-rBVaI1lKfa2AJVJsAAMF1kaKKZQ330.jpg/alloy-fidget-spiner-metal-captain-america.jpg;https://ae01.alicdn.com/kf/HTB1XCxmRpXXXXXDapXXq6xXFXXXa/Hand-Finger-Fidget-Spinner-Rainbow-Colors-Metal-Hand-Spiner-Toys-Paars-Professional-Inox-Ijzer-Unique-En.jpg','200000',N'Spinner Đò Chơi Giải Trí','PH003')

INSERT INTO MATHANG
VALUES (N'Thiết Bị Máy Tính','2-2-2015','DTCN',N'Hết hàng','http://www.cardmanhinh.com/pictures/gigabyte-gioi-thieu-card-man-hinh-geforce-gtx-1080-g1-gaming.jpg;https://tinhte.cdnforo.com/store/2016/06/3770242_GIGA1080G1-6.jpg;http://www.cardmanhinh.com/pictures/card-man-hinh-msi-geforce-gtx-1080-sea-hawk.jpg;https://image.thanhnien.vn/665/uploaded/game/upload/image/article/2016/05/07/2ea348c3ba0d101896bc097f05544b45.jpg;https://tinhte.cdnforo.com/store/2016/06/3769914_GIGA1080G1-23.jpg','18000000',N'Card Đồ Họa Màn Hình','PH002')

INSERT INTO MATHANG
VALUES (N'Máy Giặt','10-2-2016','DGD',N'Đang bán','http://www.electrolux.com.ph/Additions/ImageResize/ImageExternal.aspx?src=http%3A%2F%2Fwww.electrolux.im%2Fproducts%2FXMLLARGERIMAGE%2FEWF14023_PH_700x700.png&width=1000&height=9999&interpolation=HighQualityBicubic&forcejpeg=true;http://file.vforum.vn/hinh/2016/05/loi-thuong-gap-cua-mayt-giat.jpg;http://www.lg.com/vn/images/may-giat/md05766189/Thumb_350_wt_Awd_logo.jpg;https://cdn2.meta.com.vn/thumb.ashx/Data/image/2016/04/07/may-giat-aqua-AQW-S90ZT.jpg;http://baohanhmaygiatelectrolux.com/data/products/toj1396663731.jpg','10000000',N'Tủ lạnh Aqua Sanyo, Hitachi,Tosiba,Panasonic, Samsung, LG, Electrolux... giá rẻ, hậu mãi chăm sóc khách hàng chuyên nghiệp tại Pico','PH005')

INSERT INTO MATHANG
VALUES(N'Thú Nuôi','1-1-2013','SPK',N'Đang chờ phê duyệt','https://www.thukieng.com/wp-content/uploads/2016/01/gi%E1%BB%91ng-ch%C3%B3-alaska-Alaskan-Malamute-1.jpg;https://lh3.googleusercontent.com/-tSyhlsGBiPE/VpR1jOcdUnI/AAAAAAAAVww/CJuQmOIfb6E/s640-Ic42/ch%2525C3%2525B3-alaska-gi%2525C3%2525A1-bao-nhi%2525C3%2525AAu-gi%2525C3%2525A1-ch%2525C3%2525B3-alaska-thu%2525E1%2525BA%2525A7n-ch%2525E1%2525BB%2525A7ng.jpg;https://traichoalaska.com/wp-content/uploads/2017/08/cho-giant-alaska.jpg;https://www.thukieng.com/wp-content/uploads/2016/05/ban-cho-alaska-den-trang-9-300x300.jpg;http://traichovungtau.com/upload/product/cho-alaska03003.jpg','15000000',N'Alaska đang là giống chó tuyết được “săn lùng” nhiều nhất ở Việt Nam. Một em Alaska dễ dàng gây ấn tượng mạnh với người yêu chó ngay từ cái nhìn đầu tiên','PH004')

INSERT INTO MATHANG
VALUES (N'Đồ Gỗ','5-5-2013','DGD',N'Đang bán','http://bizweb.dktcdn.net/thumb/grande/100/110/614/articles/item-s111210.jpg?v=1470798297440;http://daytiengtrung.vn/wp-content/uploads/2017/07/%C4%91%E1%BB%93-g%E1%BB%97-n%E1%BB%99i-th%E1%BA%A5t-1.jpg;http://thosuacua.com/wp-content/uploads/2015/12/s%E1%BB%ADa-b%C3%A0n-gh%E1%BA%BF-g%E1%BB%97.jpg;http://dogotuongminh.com/img/tintuc/phong-thuy.jpg','100000000',N'Đồ gỗ mỹ nghệ cao cấp','PH004')

INSERT INTO MATHANG
VALUES (N'Giầy','6-9-2012','DGD',N'Đang bán','http://giaynam123.com/image/data/tin-tuc-giay/mua-giay-nam-chat-luong-tot.jpg;http://giayphuyen.com/pic/New/images/s%E1%BA%A3n%20xu%E1%BA%A5t%20gi%E1%BA%A7y.png;http://giayqt.com/upfiles/image/IMG_3265.JPG;http://giayqt.com/upimages/products/img_0270.jpg;http://giaydongthinh.com/upload/product/950483699249.jpg','200000',N'Giầy Cao Cất Việt Nam','PH003')

INSERT INTO MATHANG
VALUES (N'Đồng Hồ','8-7-2013','DTCN',N'Đang bán','http://donghohoangkim.vn/images/upload/Image/Dong-ho-Rolex-0246-b-1100k.jpg;https://images-na.ssl-images-amazon.com/images/I/71yvNE8DN2L._UX342_.jpg;https://img.websosanh.vn/v2/users/root_product/images/QErj_k01K0U2.jpg?compress=85;https://bossluxury.vn/uploads/thuyndd/bang-gia-dong-ho-rolex-chinh-hang-oyster-perpetual-air-king.jpg','10000000','Đồng Hồ Rolex Thụy Sĩ Nâng Tầm Đẳng Cấp','Ph004')
