(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Settlement");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1080,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("dsProduct", this);
            obj._setContents("<ColumnInfo><Column id=\"Year\" type=\"INT\" size=\"256\"/><Column id=\"Month\" type=\"INT\" size=\"256\"/><Column id=\"Product_id\" type=\"STRING\" size=\"256\"/><Column id=\"CarriedOverAmount\" type=\"INT\" size=\"256\"/><Column id=\"TotalImport\" type=\"INT\" size=\"256\"/><Column id=\"TotalExport\" type=\"INT\" size=\"256\"/><Column id=\"TotalAmount\" type=\"INT\" size=\"256\"/><Column id=\"SettleState\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsPayment", this);
            obj._setContents("<ColumnInfo><Column id=\"Year\" type=\"INT\" size=\"256\"/><Column id=\"Month\" type=\"INT\" size=\"256\"/><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"CarriedOverMoney\" type=\"INT\" size=\"256\"/><Column id=\"TotalPayMoney\" type=\"INT\" size=\"256\"/><Column id=\"TotalNon_PayMoney\" type=\"INT\" size=\"256\"/><Column id=\"TotalMoney\" type=\"INT\" size=\"256\"/><Column id=\"SettleState\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsCollect", this);
            obj._setContents("<ColumnInfo><Column id=\"Year\" type=\"INT\" size=\"256\"/><Column id=\"Month\" type=\"INT\" size=\"256\"/><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"CarriedOverMoney\" type=\"INT\" size=\"256\"/><Column id=\"TotalCollectMoney\" type=\"INT\" size=\"256\"/><Column id=\"TotalNon_CollectMoney\" type=\"INT\" size=\"256\"/><Column id=\"TotalMoney\" type=\"INT\" size=\"256\"/><Column id=\"SettleState\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"code\" type=\"STRING\" size=\"256\"/><Column id=\"data\" type=\"INT\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"code\">1</Col><Col id=\"data\">1</Col></Row><Row><Col id=\"code\">2</Col><Col id=\"data\">2</Col></Row><Row><Col id=\"code\">3</Col><Col id=\"data\">3</Col></Row><Row><Col id=\"code\">4</Col><Col id=\"data\">4</Col></Row><Row><Col id=\"code\">5</Col><Col id=\"data\">5</Col></Row><Row><Col id=\"code\">6</Col><Col id=\"data\">6</Col></Row><Row><Col id=\"code\">7</Col><Col id=\"data\">7</Col></Row><Row><Col id=\"code\">8</Col><Col id=\"data\">8</Col></Row><Row><Col id=\"code\">9</Col><Col id=\"data\">9</Col></Row><Row><Col id=\"code\">10</Col><Col id=\"data\">10</Col></Row><Row><Col id=\"code\">11</Col><Col id=\"data\">11</Col></Row><Row><Col id=\"code\">12</Col><Col id=\"data\">12</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","50","50","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("마 감");
            this.addChild(obj.name, obj);

            obj = new Grid("grid_main","100","170","764","310",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_binddataset("dsProduct");
            obj.set_autosizingtype("none");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"Year\"/><Cell col=\"1\" text=\"Month\"/><Cell col=\"2\" text=\"Product_id\"/><Cell col=\"3\" text=\"CarriedOverAmount\"/><Cell col=\"4\" text=\"TotalImport\"/><Cell col=\"5\" text=\"TotalExport\"/><Cell col=\"6\" text=\"TotalAmount\"/><Cell col=\"7\" text=\"SettleState\"/></Band><Band id=\"body\"><Cell text=\"bind:Year\" textAlign=\"center\" displaytype=\"text\"/><Cell col=\"1\" text=\"bind:Month\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:Product_id\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:CarriedOverAmount\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:TotalImport\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:TotalExport\" textAlign=\"center\"/><Cell col=\"6\" text=\"bind:TotalAmount\" textAlign=\"center\"/><Cell col=\"7\" text=\"bind:SettleState\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Radio("Radio00","90","113","280","34",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_direction("vertical");
            var Radio00_innerdataset = new nexacro.NormalDataset("Radio00_innerdataset", obj);
            Radio00_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">1</Col><Col id=\"datacolumn\">품목</Col></Row><Row><Col id=\"codecolumn\">2</Col><Col id=\"datacolumn\">지급</Col></Row><Row><Col id=\"codecolumn\">3</Col><Col id=\"datacolumn\">수금</Col></Row></Rows>");
            obj.set_innerdataset(Radio00_innerdataset);
            obj.set_text("품목");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","20","500","270","180",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_binddataset("dsPayment");
            obj.set_visible("false");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"년\"/><Cell col=\"1\" text=\"월\"/><Cell col=\"2\" text=\"거래처 번호\"/><Cell col=\"3\" text=\"이월 미지급액\"/><Cell col=\"4\" text=\"지급액\"/><Cell col=\"5\" text=\"미지급액\"/><Cell col=\"6\" text=\"총 미지급액\"/><Cell col=\"7\" text=\"마감여부\"/></Band><Band id=\"body\"><Cell text=\"bind:Year\" textAlign=\"center\" displaytype=\"text\"/><Cell col=\"1\" text=\"bind:Month\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:Customer_id\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:CarriedOverMoney\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:TotalPayMoney\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:TotalNon_PayMoney\" textAlign=\"center\"/><Cell col=\"6\" text=\"bind:TotalMoney\" textAlign=\"center\"/><Cell col=\"7\" text=\"bind:SettleState\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid01","50","530","270","180",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_binddataset("dsCollect");
            obj.set_visible("false");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"년\"/><Cell col=\"1\" text=\"월\"/><Cell col=\"2\" text=\"거래처 번호\"/><Cell col=\"3\" text=\"이월 미수금액\"/><Cell col=\"4\" text=\"수금액\"/><Cell col=\"5\" text=\"미수금액\"/><Cell col=\"6\" text=\"총 미수금액\"/><Cell col=\"7\" text=\"마감여부\"/></Band><Band id=\"body\"><Cell text=\"bind:Year\" displaytype=\"text\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:Month\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:Customer_id\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:CarriedOverMoney\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:TotalCollectMoney\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:TotalNon_CollectMoney\" textAlign=\"center\"/><Cell col=\"6\" text=\"bind:TotalMoney\" textAlign=\"center\"/><Cell col=\"7\" text=\"bind:SettleState\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid02","9","477","270","180",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_binddataset("dsProduct");
            obj.set_visible("false");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"년\"/><Cell col=\"1\" text=\"월\"/><Cell col=\"2\" text=\"품목 번호\"/><Cell col=\"3\" text=\"이월 재고량\"/><Cell col=\"4\" text=\"입고량\"/><Cell col=\"5\" text=\"출고량\"/><Cell col=\"6\" text=\"총 재고량\"/><Cell col=\"7\" text=\"마감 여부\"/></Band><Band id=\"body\"><Cell text=\"bind:Year\" displaytype=\"text\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:Month\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:Product_id\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:CarriedOverAmount\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:TotalImport\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:TotalExport\" textAlign=\"center\"/><Cell col=\"6\" text=\"bind:TotalAmount\" textAlign=\"center\"/><Cell col=\"7\" text=\"bind:SettleState\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_year","625","533","75","35",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","705","533","50","36",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("년");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","845","533","50","36",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("월");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Button("btn_cancelSettlement","740","601","120","39",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("마감 취소");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Button("btn_settlement","596","602","100","39",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_text("마 감");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","760","533","80","34",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_innerdataset("Dataset00");
            obj.set_codecolumn("code");
            obj.set_datacolumn("data");
            obj.set_text("Combo00");
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
        this.registerScript("Settlement.xfdl", function() {

        this.Settlement_onload = function(obj,e)
        {
        	var id = "selectSettlement";
        	var url = "http://localhost:8080/sm/selectSettlement";
        	var reqDs = "";
        	var resDs = "dsProduct=ProductData dsPayment=PaymentData dsCollect=CollectData";
        	var args = "";
        	var callback = "received_find";

        	this.transaction(id, url, reqDs, resDs, args, callback);

        	var sFormatContents = this.Grid02.getCurFormatString();
        	this.grid_main.set_formats("<Formats> " + sFormatContents+" </Formats>");
        };

        this.received_find = function (id,code,message)
        {

        };

        this.Radio00_onitemchanged = function(obj,e)
        {
        	if (obj.value == 1) {
        		this.grid_main.set_binddataset(this.dsProduct);
        		var sFormatContents = this.Grid02.getCurFormatString();

        		this.grid_main.createFormat();
        		this.grid_main.set_formats("<Formats> " + sFormatContents+" </Formats>");
        	} else if (obj.value == 2) {
        		this.grid_main.set_binddataset(this.dsPayment);
        		var sFormatContents = this.Grid00.getCurFormatString();

        		this.grid_main.createFormat();
        		this.grid_main.set_formats("<Formats> " +sFormatContents+" </Formats>");
        	} else if (obj.value == 3) {
        		this.grid_main.set_binddataset(this.dsCollect);
        		var sFromatContents = this.Grid01.getCurFormatString();

        		this.grid_main.createFormat();
        		this.grid_main.set_formats("<Formats> " +sFromatContents+" </Formats>");
        	}
        };

        this.btn_Settlement_onclick = function(obj,e)
        {
        	var year = this.edit_year.value;
        	var month = this.Combo00.value;

        	var id = "Settlement";
        	var url = "http://localhost:8080/sm/settlement";
        	var reqDs = "";
        	var resDs = "";
        	var args = "year=" + year + " month=" + month;
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.received = function (id,code,message)
        {
        	if (code == 2) {
        		this.alert(message);
        	} else {
        		this.reload();
        	}
        };

        this.btn_CancelSettlement_onclick = function(obj,e)
        {
        	var year = this.edit_year.value;
        	var month = this.Combo00.value;

        	var id = "cancelSettlement";
        	var url = "http://localhost:8080/sm/cancelSettlement";
        	var reqDs = "";
        	var resDs = "";
        	var args = "year=" + year + " month=" + month;
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Settlement_onload,this);
            this.Radio00.addEventHandler("onitemchanged",this.Radio00_onitemchanged,this);
            this.btn_cancelSettlement.addEventHandler("onclick",this.btn_CancelSettlement_onclick,this);
            this.btn_settlement.addEventHandler("onclick",this.btn_Settlement_onclick,this);
        };

        this.loadIncludeScript("Settlement.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
