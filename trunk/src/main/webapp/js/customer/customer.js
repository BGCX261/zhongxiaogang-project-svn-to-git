Ext.ns('UI.customer');
UI.customer.GridPanel = Ext.extend(OZ.grid.GridPanel,{
	viewConfig: {
        forceFit: true
    },
	initGrid : function(){
		this.store = new Ext.data.JsonStore({
			url : 'customer/josnList',
			root : 'customerList',
			autoDestroy : true,
			fields : ['name','address']
		});
		this.store.load();
		this.columns = [
			{
				dataIndex : 'name',
				header : 'Name'
			},
			{
				dataIndex : 'address',
				header : 'Address'
			}
		];
	}
});