(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Payment_History");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1080,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"Label\" type=\"STRING\" size=\"256\"/><Column id=\"Level\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Label\">거래처 번호</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">거래처 명</Col><Col id=\"Level\">2</Col></Row><Row><Col id=\"Label\">지급 일자</Col><Col id=\"Level\">3</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsPayment_History", this);
            obj._setContents("<ColumnInfo><Column id=\"Payment_num\" type=\"INT\" size=\"256\"/><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"Customer_name\" type=\"STRING\" size=\"256\"/><Column id=\"Paymoney\" type=\"INT\" size=\"256\"/><Column id=\"PayDate\" type=\"DATE\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsUpdateData", this);
            obj._setContents("<ColumnInfo><Column id=\"Payment_num\" type=\"INT\" size=\"256\"/><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"Money\" type=\"INT\" size=\"256\"/><Column id=\"Date\" type=\"DATE\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","50","50","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("지급 내역");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","63","114","118","34",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_innerdataset("Dataset00");
            obj.set_codecolumn("Level");
            obj.set_datacolumn("Label");
            obj.set_text("품 목");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","188","114","333","34",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Button("btn_find","720","109","130","39",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("검 색");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","63","174","787","346",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_binddataset("dsPayment_History");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"100\"/><Column size=\"200\"/><Column size=\"200\"/><Column size=\"140\"/><Column size=\"140\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"지급 번호\"/><Cell col=\"1\" text=\"거래처 번호\"/><Cell col=\"2\" text=\"거래처 명\"/><Cell col=\"3\" text=\"지급 금액\"/><Cell col=\"4\" text=\"지급 일자\"/></Band><Band id=\"body\"><Cell text=\"bind:Payment_num\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:Customer_id\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:Customer_name\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:Paymoney\" textAlign=\"center\" edittype=\"normal\"/><Cell col=\"4\" text=\"bind:PayDate\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("btn_update","625","550","95","39",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("수 정");
            obj.set_cssclass("bt_click");
            obj.set_enable("true");
            this.addChild(obj.name, obj);

            obj = new Button("btn_delete","750","550","95","39",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("삭 제");
            obj.set_cssclass("bt_click");
            this.addChild(obj.name, obj);

            obj = new Calendar("Calendar00","188","113","144","35",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Static("str_calendar","352","118","40","18",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("-");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Calendar("Calendar01","378","113","144","35",null,null,null,null,null,null,this);
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
        this.registerScript("Payment_History.xfdl", function() {
        var diff;

        this.Payment_History_onload = function(obj,e)
        {
        	var id = "selectPaymentHistory";
        	var url = "http://localhost:8080/sm/selectPaymentHistory";
        	var reqDs = "";
        	var resDs = "dsPayment_History=HistoryData";
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
        		this.dsPayment_History.filter("Customer_id.indexOf('" + strCondition + "') >= 0");
        	} else if (index == 2) {
        		this.dsPayment_History.filter("Customer_name.indexOf('" + strCondition + "') >= 0");
        	} else {
        		var before = this.Calendar00.value;
        		var after = this.Calendar01.value;
        		this.dsPayment_History.filter("PayDate >= " + before + " && PayDate <= " + after);
        	}
        };

        this.Combo00_onitemchanged = function(obj,e)
        {
        	if (obj.value == 3) {
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
        	var id = "updatePaymentHistory";
        	var url = "http://localhost:8080/sm/updatePaymentHistory";
        	var reqDs = "updateData=dsUpdateData";
        	var resDs = "";
        	var args = "diff=" + diff;
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.btn_delete_onclick = function(obj,e)
        {
        	var id = "deletePaymentHistory";
        	var url = "http://localhost:8080/sm/deletePaymentHistory";
        	var reqDs = "deleteData=dsUpdateData";
        	var resDs = "";
        	var args = "";
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.dsPayment_History_onrowposchanged = function(obj,e)
        {
        	this.dsUpdateData.setColumn(0, "Payment_num", this.dsPayment_History.getColumn(e.newrow, "Payment_num"));
        	this.dsUpdateData.setColumn(0, "Customer_id", this.dsPayment_History.getColumn(e.newrow, "Customer_id"));
        	this.dsUpdateData.setColumn(0, "Money", this.dsPayment_History.getColumn(e.newrow, "Paymoney"));
        	this.dsUpdateData.setColumn(0, "Date", this.dsPayment_History.getColumn(e.newrow, "PayDate"));
        };

        this.dsPayment_History_oncolumnchanged = function(obj,e)
        {
        	this.dsUpdateData.setColumn(0, "Money", e.newvalue);
        	diff = e.newvalue - e.oldvalue;
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Payment_History_onload,this);
            this.Combo00.addEventHandler("onitemchanged",this.Combo00_onitemchanged,this);
            this.btn_find.addEventHandler("onclick",this.btn_find_onclick,this);
            this.btn_update.addEventHandler("onclick",this.btn_update_onclick,this);
            this.btn_delete.addEventHandler("onclick",this.btn_delete_onclick,this);
            this.dsPayment_History.addEventHandler("onrowposchanged",this.dsPayment_History_onrowposchanged,this);
            this.dsPayment_History.addEventHandler("oncolumnchanged",this.dsPayment_History_oncolumnchanged,this);
        };

        this.loadIncludeScript("Payment_History.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
