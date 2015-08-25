Ext.onReady(function(){
	Ext.get('test').on('click',function(){
		//OZ.openWindow('UI.customer.GridPanel');
		var p = [];
		Ext.Ajax.request({
			params : {
				service : 'customerService',
				method : 'listCustomer',
				params : Ext.encode(p)
			},
			url : 'remote',
			success : function(result){
				alert(Ext.decode(result.responseText));
			}
		});
	},this);
});