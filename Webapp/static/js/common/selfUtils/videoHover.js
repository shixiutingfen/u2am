function playVideoHover(parentElement){
	$('.box_cont', parentElement)
		.on('mouseover', function(e){
			$(this).find('.box_bg').css('opacity', 0.4);
			$(this).find('.box_ner').css('opacity', 1);
			$(this).find('.box_img img').css('transform', 'scale(1.1,1.1)');
		}).on('mouseout', function(e){
			$(this).find('.box_bg').css('opacity', 0);
			$(this).find('.box_ner').css('opacity', 0);
			$(this).find('.box_img img').css('transform', 'scale(1,1)');
		});
} 
		
