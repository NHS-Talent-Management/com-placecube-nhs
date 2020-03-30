AUI.add(
	'announcements-banner',
	function(A) {

		var AnnouncementsBanner = {
				init: function() {
					var elements = document.getElementsByClassName('announcement-dismiss-button');
					for(var i = 0; i < elements.length; i++){
						elements[i].onclick = function() {
							$.ajax({
								type: 'POST',
								url: $(this).attr("href")
							});
						}
					}
					
				}
		};

		A.AnnouncementsBanner = AnnouncementsBanner;
	},
	'',
	{
		requires: [	
			'aui-base'
		]
	}
);
