/* 
 * @date: 2010-5-22 21:42:15 
 * @author: ghg 
 * Depends: 
 * jquery.js 
 * 
 * function:类似GOOGLE搜索框提示功能 
 */
(function($) {
	$.fn.autopoint = function(options) {
		defaults = {
			url : options.url,
			openurl : options.openurl,
			keyLeft : 37,// 向左方向键
			keyUp : 38,// 向上方向键
			keyRight : 39,// 向右方向键
			keyDown : 40,// 向下方向键
			keyEnter : 13,// 回车键
			listHoverCSS : 'jhover',// 提示框列表鼠标悬浮的样式
			//tpl : '<div class="list"><div class="word">{word}</div><div class="view">约{view}条记录</div></div>',
			tpl : '<div class="list"><div class="word">{name}</div><div class="hidden">{id}</div></div>',
			topoffset : options.topoffset || 0
		};
		var options = $.extend(defaults, options);
		var dropDiv = $('<div></div>').addClass('dropDiv').appendTo('body');
		var isOver = false;
		dropDiv.hover(function() {
			isOver = true;
		}, function() {
			isOver = false;
		});
		return this
				.each(function() {
					var pa = $(this);
					$(this)
							.bind(
									'keydown',
									function(event) {
										if (dropDiv.css('display') != 'none') {// 当提示层显示时才对键盘事件处理
											var currentList = dropDiv.find('.'
													+ options.listHoverCSS);
											if (event.keyCode == options.keyDown) {// 如果按的是向下方向键
												if (currentList.length == 0) {
													// 如果提示列表没有一个被选中,则将列表第一个选中
													$(this)
															.val(
																	getPointWord(dropDiv
																			.find(
																					'.list:first')
																			.mouseover()));
												} else if (currentList.next().length == 0) {
													// 如果是最后一个被选中,则取消选中,即可认为是输入框被选中
													unHoverAll();
												} else {
													unHoverAll();
													// 将原先选中列的下一列选中
													if (currentList.next().length != 0)
														$(this)
																.val(
																		getPointWord(currentList
																				.next()
																				.mouseover()));
												}
												return false;
											} else if (event.keyCode == options.keyUp) {// 如果按的是向上方向键
												if (currentList.length == 0) {
													$(this)
															.val(
																	getPointWord(dropDiv
																			.find(
																					'.list:last')
																			.mouseover()));
												} else if (currentList.prev().length == 0) {
													unHoverAll();
												} else {
													unHoverAll();
													if (currentList.prev().length != 0)
														$(this)
																.val(
																		getPointWord(currentList
																				.prev()
																				.mouseover()));
												}
												return false;
											} else if (event.keyCode == options.keyEnter)
												dropDiv.empty().hide();
										}
										// 当按下键之前记录输入框值,以方便查看键弹起时值有没有变
										$(this).attr('alt', $(this).val());
									})
							.bind(
									'keyup',
									function(event) {
										// 如果弹起的键是向上或向下方向键则返回
										if (event.keyCode == options.keyDown
												|| event.keyCode == options.keyUp)
											return;
										if ($(this).val() == '') {
											dropDiv.empty().hide();
											return;
										}
										// 若输入框值没有改变或变为空则返回
										if ($(this).val() == $(this)
												.attr('alt'))
											return;
										getData(pa, $(this).val());
									})
							.bind(
									'blur',
									function() {
										if (isOver
												&& dropDiv.find('.'
														+ options.listHoverCSS) != 0)
											return;
										// 文本输入框失去焦点则清空并隐藏提示层
										dropDiv.empty().hide();
									});
					/** 处理ajax返回成功的方法* */
					handleResponse = function(parent, json) {
						var isEmpty = true;
//						for ( var o in json) {
//							if (o == 'data')
//								isEmpty = false;
//						}
						if(json){
							isEmpty = false;
						}
						if (isEmpty) {
							showError("返回数据格式错误,请检查请求URL是否正确!");
							return;
						}
						if (json['data'].length == 0) {
							// 返回数据为空
							return;
						}
						refreshDropDiv(parent, json);
						dropDiv.show();
					}
					/** 处理ajax失败的方法* */
					handleError = function(error) {
						// showError("由于url错误或超时请求失败!");
					}
					showError = function(error) {
						alert(error);
					}
					/** 通过ajax返回json格式数据生成用来创建dom的字符串* */
					render = function(parent, json) {
						var res = json['data'] || json;
						var appendStr = '';
						// 用json对象中内容替换模版字符串中匹配/\{([a-z]+)\}/ig的内容,如{word},{view}
						for (var i = 0; i < res.length; i += 1) {
							appendStr += options.tpl.replace(/\{([a-z]+)\}/ig,
									function(m, n) {
										return res[i][n];
									});
						}
						jebind(parent, appendStr);
					}
					/** 将新建dom对象插入到提示框中,并重新绑定mouseover事件监听* */
					jebind = function(parent, a) {
						dropDiv.append(a);
						dropDiv.find('.list').each(function() {
							$(this).unbind('mouseover').mouseover(function() {
								unHoverAll();
								$(this).addClass(options.listHoverCSS);
							}).unbind('click').click(function() {
								//alert(options.openurl+getPointHideWord($(this)));
								 window.open(options.openurl+getPointHideWord($(this)),"_self");
//								parent.val(getPointWord($(this)));
//								dropDiv.empty().hide();
//								parent.focus();
							});
						});
					}
					/**将提示框中所有列的hover样式去掉**/
					unHoverAll = function() {
						dropDiv.find('.list').each(function() {
							$(this).removeClass(options.listHoverCSS);
						});
					}
					/**在提示框中取得当前选中的提示关键字**/
					getPointWord = function(p) {
						//alert(p.find('div.hidden').text());
						//var v = p.find('div.hidden');
						return p.find('div:first').text()
					}
					
					/**在提示框中取得当前选中的提示关键字**/
					getPointHideWord = function(p) {
						//alert(p.find('div.hidden').text());
						//var v = p.find('div.hidden');
						return p.find('div:hidden').text()
					}
					
					/**刷新提示框,并设定样式**/
					refreshDropDiv = function(parent, json) {
						var left = parent.offset().left;
						var height = parent.height();
						var top = parent.offset().top + options.topoffset	+ height;
						var width = (options.width || parent.width())+25;
						dropDiv.empty();
						dropDiv.css({
							'border' : '1px solid #3c763d',
							'background-color':'#FFF',
							'left' : left,
							'top' : top  + 5,
							'width' : width+ 'px'
						});
						render(parent, json);
						//防止ajax返回之前输入框失去焦点导致提示框不消失 
						parent.focus();
					}
					/**通过ajax向服务器请求数据**/
					getData = function(parent, word) {
						$.ajax({
							type : 'GET',
							data : "word=" + word,
							url : options.url,
							dataType : 'json',
							timeout : 1000,
							success : function(json) {
								handleResponse(parent, json);
							},
							error : handleError
						});
					}
				});
	}
})(jQuery);
