$(document).ready(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop() > 100) {
			$('.header').css({
				'position' : 'fixed',
				'height' : '50px',
				'width' : '100%'
			});
			$('.header').addClass('header__fixed');
		} else {
			$('.header').css({
				'position' : 'relative',
				'height' : '80px',
				'width' : ''
			});
			$('.header').removeClass('header__fixed');

		}
	});
	$('#showPhone').click(function() {
		$(this).hide();
		$(this).next().show();
	});
	
});
function onSignIn(googleUser) {
	var id_token = googleUser.getAuthResponse().id_token;
	$.post("./google-sign-in",{idToken:id_token}).done(function(){
		window.location.href = "trang-chu";
	});
}
function signOut() {
	window.location.href = "https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/hangrong/dang-xuat";
}
