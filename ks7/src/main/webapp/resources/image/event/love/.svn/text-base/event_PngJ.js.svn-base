// 브라우져 체크 (by web)
var appname   = navigator.appName;
var useragent = navigator.userAgent;
var IE   = appname == "Microsoft Internet Explorer" ? true: false;
var IE8  = ( useragent.indexOf('MSIE 8'  ) > 0 ); // 8.0 버전
var IE7  = ( useragent.indexOf('MSIE 7'  ) > 0 ); // 7.0 버전
var IE6  = ( useragent.indexOf('MSIE 6'  ) > 0 ); // 6.0 버전
var IE55 = ( useragent.indexOf('MSIE 5.5') > 0 ); // 5.5 버전

function setPng24( obj ){
	if( IE55 || IE6 ){
		if( !obj.src.match( /[\(\)]/ ) ){
			obj.width = obj.height = 1;
			obj.className = obj.className.replace( /\bpng24\b/i, '' );
			obj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+ obj.src +"',sizingMethod='image');"
			obj.src = 'imgs/blank.gif';
			return '';
		}
	}
}






























