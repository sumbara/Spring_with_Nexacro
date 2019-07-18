(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Export_History");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1080,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"Label\" type=\"STRING\" size=\"256\"/><Column id=\"Level\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Label\">거래처 번호</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">거래처 명</Col><Col id=\"Level\">2</Col></Row><Row><Col id=\"Label\">품목 번호</Col><Col id=\"Level\">3</Col></Row><Row><Col id=\"Label\">품 명</Col><Col id=\"Level\">4</Col></Row><Row><Col id=\"Label\">출고 일자</Col><Col id=\"Level\">5</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsExport_History", this);
            obj._setContents("<ColumnInfo><Column id=\"Export_num\" type=\"INT\" size=\"256\"/><Column id=\"Export_Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"Export_Customer_name\" type=\"STRING\" size=\"256\"/><Column id=\"Export_Product_id\" type=\"STRING\" size=\"256\"/><Column id=\"Export_Product_name\" type=\"STRING\" size=\"256\"/><Column id=\"Export_Amount\" type=\"INT\" size=\"256\"/><Column id=\"Export_Date\" type=\"DATE\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsUpdateData", this);
            obj._setContents("<ColumnInfo><Column id=\"Export_num\" type=\"INT\" size=\"256\"/><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"Product_id\" type=\"STRING\" size=\"256\"/><Column id=\"Amount\" type=\"INT\" size=\"256\"/><Column id=\"Date\" type=\"DATE\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","50","50","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("출고 현황");
            this.addChild(obj.name, obj);

            obj = new Button("btn_update","625","550","95","39",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("수 정");
            obj.set_cssclass("bt_click");
            obj.set_enable("true");
            this.addChild(obj.name, obj);

            obj = new Button("btn_delete","750","550","95","39",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("삭 제");
            obj.set_cssclass("bt_click");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","62","116","125","34",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_innerdataset("Dataset00");
            obj.set_codecolumn("Level");
            obj.set_datacolumn("Label");
            obj.set_text("품 목");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","197","116","333","34",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            this.addChild(obj.name, obj);

            obj = new Button("btn_find","720","116","130","39",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("검 색");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","63","174","787","346",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_binddataset("dsExport_History");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"120\"/><Column size=\"120\"/><Column size=\"120\"/><Column size=\"120\"/><Column size=\"100\"/><Column size=\"120\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"출고 번호\"/><Cell col=\"1\" text=\"거래처 번호\"/><Cell col=\"2\" text=\"거래처 명\"/><Cell col=\"3\" text=\"품목 번호\"/><Cell col=\"4\" text=\"품 명\"/><Cell col=\"5\" text=\"출고량\"/><Cell col=\"6\" text=\"출고 일자\"/></Band><Band id=\"body\"><Cell text=\"bind:Export_num\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:Export_Customer_id\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:Export_Customer_name\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:Export_Product_id\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:Export_Product_name\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:Export_Amount\" textAlign=\"center\" edittype=\"normal\"/><Cell col=\"6\" text=\"bind:Export_Date\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Calendar("Calendar01","386","115","144","35",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Static("str_calendar","360","120","40","18",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("-");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Calendar("Calendar00","196","115","144","35",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1080,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Export_History.xfdl", function() {
        var diff;

        this.Export_History_onload = function(obj,e)
        {
        	var id = "selectExportHistory";
        	var url = "http://localhost:8080/sm/selectExportHistory";
        	var reqDs = "";
        	var resDs = "dsExport_History=ExportHistoryData";
        	var args = "";
        	var callback = "received_find";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.received_find = function (id,code,message)
        {

        };

        this.received = function (id,code,message)
        {
        	if (code == 2) {
        		this.alert(message);
        	} else {
        		this.reload();
        	}
        };

        this.btn_find_onclick = function(obj,e)
        {
        	var index = this.Combo00.value;
        	var strCondition = this.Edit00.value;

        	if (index == 1) {
        		this.dsExport_History.filter("Export_Customer_id.indexOf('" + strCondition + "') >= 0");
        	} else if (index == 2) {
        		this.dsExport_History.filter("Export_Customer_name.indexOf('" + strCondition + "') >= 0");
        	} else if (index == 3) {
        		this.dsExport_History.filter("Export_Product_id.indexOf('" + strCondition + "') >= 0");
        	} else if (index == 4) {
        		this.dsExport_History.filter("Export_Product_name.indexOf('" + strCondition + "') >= 0");
        	} else {
        		var before = this.Calendar00.value;
        		var after = this.Calendar01.value;
        		this.dsExport_History.filter("Export_Date >= " + before + " && Export_Date <= " + after);
        	}
        };

        this.Combo00_onitemchanged = function(obj,e)
        {
        	if (obj.value == 5) {
        		this.Edit00.set_visible(false);
        		this.Calendar00.set_visible(true);
        		this.Calendar01.set_visible(true);
        		this.str_calendar.set_visible(true);
        	} else {
        		this.Edit00.set_visible(true);
        		this.Calendar00.set_visible(false);
        		this.Calendar01.set_visible(false);
        		this.str_calendar.set_visible(false);
        	}
        };

        this.btn_update_onclick = function(obj,e)
        {
        	var id = "updateExportHistory";
        	var url = "http://localhost:8080/sm/updateExportHistory";
        	var reqDs = "updateData=dsUpdateData";
        	var resDs = "";
        	var args = "diff=" + diff;
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.btn_delete_onclick = function(obj,e)
        {
        	var id = "deleteExportHistory";
        	var url = "http://localhost:8080/sm/deleteExportHistory";
        	var reqDs = "deleteData=dsUpdateData";
        	var resDs = "";
        	var args = "";
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.dsExport_History_onrowposchanged = function(obj,e)
        {
        	this.dsUpdateData.setColumn(0, "Export_num", this.dsExport_History.getColumn(e.newrow, "Export_num"));
        	this.dsUpdateData.setColumn(0, "Customer_id", this.dsExport_History.getColumn(e.newrow, "Export_Customer_id"));
        	this.dsUpdateData.setColumn(0, "Product_id", this.dsExport_History.getColumn(e.newrow, "Export_Product_id"));
        	this.dsUpdateData.setColumn(0, "Amount", this.dsExport_History.getColumn(e.newrow, "Export_Amount"));
        	this.dsUpdateData.setColumn(0, "Date", this.dsExport_History.getColumn(e.newrow, "Export_Date"));
        };

        this.dsExport_History_oncolumnchanged = function(obj,e)
        {
        	this.dsUpdateData.setColumn(0, "Amount", e.newvalue);
        	diff = e.newvalue - e.oldvalue;
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Export_History_onload,this);
            this.btn_update.addEventHandler("onclick",this.btn_update_onclick,this);
            this.btn_delete.addEventHandler("onclick",this.btn_delete_onclick,this);
            this.Combo00.addEventHandler("onitemchanged",this.Combo00_onitemchanged,this);
            this.btn_find.addEventHandler("onclick",this.btn_find_onclick,this);
            this.dsExport_History.addEventHandler("onrowposchanged",this.dsExport_History_onrowposchanged,this);
            this.dsExport_History.addEventHandler("oncolumnchanged",this.dsExport_History_oncolumnchanged,this);
        };

        this.loadIncludeScript("Export_History.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
