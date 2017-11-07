$(document)
		.ready(
				function() {
					$('#username').blur(function() {
						if ($(this).val() != '') {
							$(this).css({
								border : ''
							});
							$('#name-error').html('');
						}
					});
					$('#profile-pass').blur(function() {
						if ($(this).val() != '' && $(this).val().length > 5) {
							$(this).css({
								border : ''
							});
							$('#pass-error').html('');
						}
					});
					$('#profile-address').blur(function() {
						if ($(this).val() != '') {
							$(this).css({
								border : ''
							});
							$('#address-error').html('');
						}
					});
					$('#profile-phone').blur(
							function() {
								if ($(this).val() != ''
										&& isNaN($(this).val()) == false
										&& $(this).val().length >= 8
										&& $(this).val().length <= 12) {
									$(this).css({
										border : ''
									});
									$('#phone-error').html('');
								}
							});
					$('#form-edit-profile')
							.submit(
									function() {
										let name = $('#username');
										let pass = $('#profile-pass');
										let address = $('#profile-address');
										let phone = $('#profile-phone');
										if (name.val() == '') {
											name.css({
												border : '2px solid red'
											});
											$('#name-error').html(
													'* Bạn phải nhập họ tên !');
											$('#name-error').css({
												color : 'red'
											});
											return false;
										}
										if (pass.val() == ''
												|| pass.val().length <= 5) {
											pass.css({
												border : '2px solid red'
											});
											$('#pass-error')
													.html(
															'* Bạn phải nhập mật khẩu dài hơn 5 ký tự !');
											$('#pass-error').css({
												color : 'red'
											});
											return false;
										}
										if (address.val() == '') {
											address.css({
												border : '2px solid red'
											});
											$('#address-error')
													.html(
															'* Bạn phải nhập địa chỉ !');
											$('#address-error').css({
												color : 'red'
											});
											return false;
										}
										if (phone.val() == '') {
											phone.css({
												border : '2px solid red'
											});
											$('#phone-error')
													.html(
															'* Bạn phải nhập số điện thoại !');
											$('#phone-error').css({
												color : 'red'
											});
											return false;
										} else if (isNaN(phone.val()) == true
												|| phone.val().length < 8
												|| phone.val().length > 12) {
											phone.css({
												border : '2px solid red'
											});
											$('#phone-error')
													.html(
															'* Bạn phải nhập số điện thoại là số và dài 8 - 12 số !');
											$('#phone-error').css({
												color : 'red'
											});
											return false;

										}
									});
					$('#avatar-img')
							.change(
									function() {
										let input = this;
										let url = $(this).val();
										let ext = url.substring(
												url.lastIndexOf('.') + 1)
												.toLowerCase();
										if (input.files
												&& input.files[0]
												&& (ext == "gif"
														|| ext == "png"
														|| ext == "jpeg" || ext == "jpg")) {
											let reader = new FileReader();
											reader.onload = function(e) {
												$('#avatar').attr('src',
														e.target.result);
											}
											reader
													.readAsDataURL(input.files[0]);
										}
									});
				});
