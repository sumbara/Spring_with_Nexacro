(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Collect");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1080,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"Label\" type=\"STRING\" size=\"256\"/><Column id=\"Level\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Level\">1</Col><Col id=\"Label\">거래처 번호</Col></Row><Row><Col id=\"Level\">2</Col><Col id=\"Label\">거래처 명</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsCollectCustomer", this);
            obj._setContents("<ColumnInfo><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"Customer_name\" type=\"STRING\" size=\"256\"/><Column id=\"Collectmoney\" type=\"INT\" size=\"256\"/><Column id=\"Non_collectmoney\" type=\"INT\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsCollect", this);
            obj._setContents("<ColumnInfo><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"Collectmoney\" type=\"INT\" size=\"256\"/><Column id=\"CollectDate\" type=\"DATE\" size=\"256\"/><Column id=\"Customer_name\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Button("btn_collect","600","461","100","39",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("수 금");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Button("btn_cancel","764","460","100","39",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("취 소");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","50","50","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("수 금");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","60","140","119","34",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_innerdataset("Dataset00");
            obj.set_codecolumn("Level");
            obj.set_datacolumn("Label");
            obj.set_text("품 목");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit03","184","140","231","34",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            this.addChild(obj.name, obj);

            obj = new Button("btn_Find","425","140","100","34",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("검 색");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","60","190","465","270",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_binddataset("dsCollectCustomer");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"130\"/><Column size=\"130\"/><Column size=\"100\"/><Column size=\"100\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"거래처 번호\"/><Cell col=\"1\" text=\"거래처 명\"/><Cell col=\"2\" text=\"수금액\"/><Cell col=\"3\" text=\"미수금액\"/></Band><Band id=\"body\"><Cell text=\"bind:Customer_id\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:Customer_name\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:Collectmoney\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:Non_collectmoney\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","576","235","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("거래처");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_NonCollectMoney","776","267","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_enable("false");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","776","235","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("미수금 금액");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_CustomerName","576","267","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_enable("false");
            this.addChild(obj.name, obj);

            obj = new Static("Static04","578","325","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_text("수금액");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_Money","576","353","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("12");
            this.addChild(obj.name, obj);

            obj = new Static("Static05","778","325","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("13");
            obj.set_text("수금 일자");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Calendar("edit_collectDate","776","353","164","31",null,null,null,null,null,null,this);
            obj.set_taborder("14");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1080,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("collectmoney","edit_Money","value","dsCollect","Collectmoney");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("collectdate","edit_collectDate","value","dsCollect","CollectDate");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("customer_name","edit_CustomerName","value","dsCollect","Customer_name");
            this.addChild(obj.name, obj);
            obj.bind();
        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Collect.xfdl", function() {
        var limit_money;

        this.Collect_onload = function(obj,e)
        {
        	var id = "selectCollectCustomer";
        	var url = "http://localhost:8080/sm/selectCollectCustomer";
        	var reqDs = "";
        	var resDs = "dsCollectCustomer=CustomerData";
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
        		this.alert("마감된 달입니다!!");
        	} else {
        		this.reload();
        	}
        };

        this.btn_Find_onclick = function(obj,e)
        {
        	var index = this.Combo00.value;
        	var strCondition = this.Edit03.value;

        	if (index == 1) {
        		this.dsCollectCustomer.filter("Customer_id.indexOf('" + strCondition + "') >= 0");
        	} else {
        		this.dsCollectCustomer.filter("Customer_name.indexOf('" + strCondition + "') >= 0");
        	}
        };


        this.Grid00_oncelldblclick = function(obj,e)
        {
        	var customer_id = this.dsCollectCustomer.getColumn(this.dsCollectCustomer.rowposition, "Customer_id");
        	this.dsCollect.setColumn(0, "Customer_id", customer_id);
        	this.edit_CustomerName.set_value(this.dsCollectCustomer.getColumn(this.dsCollectCustomer.rowposition, "Customer_name"));
        	this.edit_NonCollectMoney.set_value(this.dsCollectCustomer.getColumn(this.dsCollectCustomer.rowposition, "Non_collectmoney"));
        	limit_money = this.dsCollectCustomer.getColumn(this.dsCollectCustomer.rowposition, "Non_collectmoney");
        };

        this.btn_collect_onclick = function(obj,e)
        {
        	if (this.edit_collectDate == undefined || this.edit_CustomerName == undefined || this.edit_Money == undefined ||
        		this.edit_NonCollectMoney == undefined) {
        		this.alert("모든 내용을 꼭 채워주세요!!");
        	} else if (this.edit_Money.value > limit_money) {
        		this.alert("미수금액보다 많이 수금할 수 없습니다");
        	} else {
        		var id = "collect"
        		var url = "http://localhost:8080/sm/collect";
        		var reqDs = "collectData=dsCollect";
        		var resDs = "";
        		var args = "";
        		var callback = "received";

        		this.transaction(id, url, reqDs, resDs, args, callback);
        	}
        };

        this.btn_cancel_onclick = function(obj,e)
        {
        	this.edit_collectDate.set_value();
        	this.edit_CustomerName.set_value();
        	this.edit_Money.set_value();
        	this.edit_NonCollectMoney.set_value();
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Collect_onload,this);
            this.btn_collect.addEventHandler("onclick",this.btn_collect_onclick,this);
            this.btn_cancel.addEventHandler("onclick",this.btn_cancel_onclick,this);
            this.btn_Find.addEventHandler("onclick",this.btn_Find_onclick,this);
            this.Grid00.addEventHandler("oncelldblclick",this.Grid00_oncelldblclick,this);
        };

        this.loadIncludeScript("Collect.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
