$(function() {
	
		//页面不足一屏，铺满一屏
	$('.layout').css('min-height',$(window).height());
	
	$('.h100').css('min-height',$(window).height());
	
		$('#n1').click(function(){
			$('.sub2').hide();
			$('.sub3').hide();
			if($('.sub').is(':visible')) { //true为显示 false为隐藏
				$(this).find('.sub').hide();
			}else{
				$(this).find('.sub').show();
			}
		});

		$('#n2').click(function(){
			$('.sub').hide();
			$('.sub3').hide();
			if($('.sub2').is(':visible')) { //true为显示 false为隐藏
				$(this).find('.sub2').hide();
			}else{
				$(this).find('.sub2').show();
			}
		});
		
		$('#n3').click(function(){
			$('.sub').hide();
			$('.sub2').hide();
			if($('.sub3').is(':visible')) { //true为显示 false为隐藏
				$(this).find('.sub3').hide();
			}else{
				$(this).find('.sub3').show();
			}
		});

		$('.dialog_blank').height($('body').height());
		$('#btn1').click(function(){
			$('.dialog_blank').show();
			$('.load-dialog').show();
		});
		$('.dialog_close, .dialog_goback').click(function(){
			$('.dialog_blank').hide();
			$(this).parents('.dialog').hide();
		});

})
