Ext.ns('OZ.grid');
OZ.checkClassExists = function(clsName) {
	try {
		var obj = eval(clsName);
		if (obj) {
			return true;
		} else {
			return false;
		}
	} catch (e) {
		return false;
	}
}

OZ.loadClass = function(clsName,callBack) {
	Ext.Ajax.request({
		url : 'js/customer/customer.js',
		params : {
			componentName : clsName
		},
		success : function(response, opts) {
			eval(response.responseText);
			callBack();
		}
	});
}

OZ.openWindow = function(clsName){
	function open(){
		var CLS = eval(clsName);
		var panel = new CLS();
		var win=new Ext.Window({
			width : 300,
			height : 250,
			layout : 'fit',
			border : false,
			items : panel
		});
		win.show();
	}
	
	if(this.checkClassExists(clsName)){
		open();
	}else{
		OZ.loadClass(clsName,open);
	}
}

OZ.grid.GridPanel = Ext.extend(Ext.grid.GridPanel,{
	initGrid : function(){
		
	},
	initComponent : function(){
		this.initGrid();
		OZ.grid.GridPanel.superclass.initComponent.call(this);
	}
});