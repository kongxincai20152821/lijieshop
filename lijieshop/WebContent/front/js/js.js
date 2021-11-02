//window.onload=function(){
//	var list = document.getElementById("list");
//	//自增下标
//	var index = 0;
//	var time=setInterval(autoPlay,3000);
//	function autoPlay () {
//		index++;
//		if(index>5){
//			index=1;
//			list.style.left=0;
//		}
//		var gunTime = setInterval(function(){
//			var current = list.offsetLeft;//获取元素的left值
//			var target = -1200*index;//定义目标值
//			var speed = Math.ceil((current-target)/10);//定义一个速度，向上取整
//			
//			if (current==target) {
//				clearInterval(gunTime);
//			}
//			list.style.left=current-speed+"px";
//		},30)
//	}
//	
//	list.onmouseover=function  () {
//		clearInterval(time);
//	}
//	
//	list.onmouseout=function  () {
//		time=setInterval(autoPlay,3000);
//	}
//}
$(document).ready(function() {
	var index = 0;
	$('#list li').eq(0).show();
	time=setInterval(lunbo,3000);
	function lunbo () {
		index++;
		if (index==5) {
			index=0;
			$('.banner ol li').eq(index).addClass('current')
						.siblings().removeClass('current');
		}
		$('#list li').eq(index).fadeIn(1000).siblings().fadeOut(1000);
		$('.banner ol li').eq(index).addClass('current')
						.siblings().removeClass('current');
		
	}
	
	$('.banner ol li').click(function  () {
		clearInterval(time);
		index=$(this).index()-1;
		lunbo();
	})
	$('.banner').mouseenter(function  () {
		clearInterval(time);
		
	})
	$('.banner').mouseleave(function  () {
		time=setInterval(lunbo,3000);
	})
});
