<div id="edit-customer-type" class="modal" >
					<div class="modal-dialog">
								<div class="modal-content" style="background-color: #F6F7F7">
									<div class="modal-header">
										<span>客户类型设置</span>
									</div>
									<div class="modal-body">
										<form onsubmit="return checkDataDictionary()" action="/crm/pc/setting/saveDataDictionary" method="post" accept-charset="utf-8" class="form-horizontal" role="form">	
											 <input name="id" type="hidden" />
											 <div class="form-group">
											    <label for="inputEmail3" class="col-sm-2 control-label">类型名称</label>
											    <div class="col-sm-10">
											      <input id="dname" name="name" type="text" class="form-control" placeholder="类型名称">
											    </div>
											  </div>
											  
											  <div class="form-group">
											    <label for="inputPassword3" class="col-sm-2 control-label">类型说明</label>
											    <div class="col-sm-10">
											      <textarea id="dvalue" name="value" class="form-control" placeholder="类型说明" rows="5"></textarea>
											    </div>
											  </div>
											  
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
													<button type="submit" class="btn btn-primary">保存</button>  
												</div>
										</form>
									</div>
								</div>
							</div>
				</div>