(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Import");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1080,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"Label\" type=\"STRING\" size=\"256\"/><Column id=\"Level\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Label\">품 명</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">품목번호</Col><Col id=\"Level\">2</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsProduct", this);
            obj._setContents("<ColumnInfo><Column id=\"Product_id\" type=\"STRING\" size=\"256\"/><Column id=\"Product_name\" type=\"STRING\" size=\"256\"/><Column id=\"Price\" type=\"INT\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsImport", this);
            obj._setContents("<ColumnInfo><Column id=\"Product_id\" type=\"STRING\" size=\"256\"/><Column id=\"Product_name\" type=\"STRING\" size=\"256\"/><Column id=\"Price\" type=\"INT\" size=\"256\"/><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"Import_amount\" type=\"INT\" size=\"256\"/><Column id=\"Import_date\" type=\"DATE\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","50","50","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("입 고");
            this.addChild(obj.name, obj);

            obj = new Button("btn_ProductInsert","60","540","150","39",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("입고 제품 등록");
            obj.set_cssclass("bt_click");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","650","173","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("거래처");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_Customer","650","200","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_enable("false");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","650","253","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("품 목");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_ProductPrice","830","285","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_enable("false");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","830","253","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("단 가");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_ProductName","650","285","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_enable("false");
            this.addChild(obj.name, obj);

            obj = new Static("Static04","652","343","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("수 량");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("edit_Amount","650","371","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            this.addChild(obj.name, obj);

            obj = new Static("Static05","832","343","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_text("입고 일자");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Calendar("edit_ImportDate","830","371","164","31",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            this.addChild(obj.name, obj);

            obj = new Button("btn_searchCustomer","810","200","150","31",null,null,null,null,null,null,this);
            obj.set_taborder("12");
            obj.set_text("거래처 선택");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Button("btn_Cancel","850","479","100","39",null,null,null,null,null,null,this);
            obj.set_taborder("13");
            obj.set_text("취 소");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Button("btn_Import","686","480","100","39",null,null,null,null,null,null,this);
            obj.set_taborder("14");
            obj.set_text("입 고");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","60","190","465","270",null,null,null,null,null,null,this);
            obj.set_taborder("15");
            obj.set_binddataset("dsProduct");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"130\"/><Column size=\"190\"/><Column size=\"120\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"품목 번호\"/><Cell col=\"1\" text=\"품목 명\"/><Cell col=\"2\" text=\"단 가\"/></Band><Band id=\"body\"><Cell text=\"bind:Product_id\"/><Cell col=\"1\" text=\"bind:Product_name\"/><Cell col=\"2\" text=\"bind:Price\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","60","140","119","34",null,null,null,null,null,null,this);
            obj.set_taborder("16");
            obj.set_innerdataset("Dataset00");
            obj.set_codecolumn("Level");
            obj.set_datacolumn("Label");
            obj.set_text("품 목");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","184","140","231","34",null,null,null,null,null,null,this);
            obj.set_taborder("17");
            this.addChild(obj.name, obj);

            obj = new Button("btn_Find","425","140","100","34",null,null,null,null,null,null,this);
            obj.set_taborder("18");
            obj.set_text("검 색");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1080,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("product_name","edit_ProductName","value","dsImport","Product_name");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("price","edit_ProductPrice","value","dsImport","Price");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("import_amount","edit_Amount","value","dsImport","Import_amount");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("import_date","edit_ImportDate","value","dsImport","Import_date");
            this.addChild(obj.name, obj);
            obj.bind();
        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Import.xfdl", function() {
        this.Import_onload = function(obj,e)
        {
        	var id = "selectAllProduct";
        	var url = "http://localhost:8080/sm/selectAllProduct";
        	var reqDs = "";
        	var resDs = "dsProduct=AllProductData";
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

        this.btn_Find_onclick = function(obj,e)
        {
        	var index = this.Combo00.value;
        	var strCondition = this.Edit00.value;

        	if (index == 1) {
        		this.dsProduct.filter("Product_name.indexOf('" + strCondition + "') >= 0");
        	} else {
        		this.dsProduct.filter("Product_id.indexOf('" + strCondition + "') >= 0");
        	}
        };

        this.Grid00_oncelldblclick = function(obj,e)
        {
        	var product_id = this.dsProduct.getColumn(this.dsProduct.rowposition, "Product_id");
        	this.dsImport.setColumn(0, "Product_id", product_id);
        	this.edit_ProductName.set_value(this.dsProduct.getColumn(this.dsProduct.rowposition, "Product_name"));
        	this.edit_ProductPrice.set_value(this.dsProduct.getColumn(this.dsProduct.rowposition, "Price"))
        };

        this.btn_ProductInsert_onclick = function(obj,e)
        {
        	var objChildFrame = new ChildFrame();
        		objChildFrame.init("popProductInsert"
        						  , 0
        						  , 0
        						  , 400
        						  , 300
        						  , null
        						  , null
        						  , "Base::ProductInsert.xfdl");

        	objChildFrame.set_dragmovetype("all");
        	objChildFrame.set_openalign("center middle");
        	objChildFrame.set_overlaycolor("RGBA(196,196,196,0.5)");

        	var objParam = {};
        	objChildFrame.showModal(this.getOwnerFrame()
        							  , objParam
        							  , this
        							  , "fn_insertCallback");
        };

        this.fn_insertCallback = function (strPopupID,strReturn)
        {
        	this.reload();
        };

        this.btn_searchCustomer_onclick = function(obj,e)
        {
        	var objChildFrame = new ChildFrame();
        		objChildFrame.init("popCustomerSelect"
        						  , 0
        						  , 0
        						  , 400
        						  , 300
        						  , null
        						  , null
        						  , "Base::CustomerSelect.xfdl");

        	objChildFrame.set_dragmovetype("all");
        	objChildFrame.set_openalign("center middle");
        	objChildFrame.set_overlaycolor("RGBA(196,196,196,0.5)");

        	var objParam = {};
        	objChildFrame.showModal(this.getOwnerFrame()
        							  , objParam
        							  , this
        							  , "fn_searchCallback");
        };

        this.fn_searchCallback = function (strPopupID,strReturn)
        {
        	if(strPopupID == "popCustomerSelect"){
                if (strReturn.length > 0) {
        			var arrRtn = strReturn.split("|");
        			this.edit_Customer.set_value(arrRtn[1]);
        			this.dsImport.setColumn(0, "Customer_id", arrRtn[0]);
        		}
            }
        };

        this.btn_Import_onclick = function(obj,e)
        {
        	if(this.edit_Amount.value == undefined || this.edit_Customer.value == undefined || this.edit_ImportDate.value == undefined ||
        		this.edit_ProductName.value == undefined || this.edit_ProductPrice == undefined) {
        		this.alert("모든 내용을 꼭 채워주세요!!");
        	} else {
        		var id = "importProduct";
        		var url = "http://localhost:8080/sm/importProduct";
        		var reqDs = "importData=dsImport";
        		var resDs = "";
        		var args = "";
        		var callback = "received";

        		this.transaction(id, url, reqDs, resDs, args, callback);
        	}
        };

        this.btn_Cancel_onclick = function(obj,e)
        {
        	this.edit_Customer.set_value();
        	this.edit_ProductName.set_value();
        	this.edit_ProductPrice.set_value();
        	this.edit_Amount.set_value();
        	this.edit_ImportDate.set_value();
        };
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Import_onload,this);
            this.btn_ProductInsert.addEventHandler("onclick",this.btn_ProductInsert_onclick,this);
            this.btn_searchCustomer.addEventHandler("onclick",this.btn_searchCustomer_onclick,this);
            this.btn_Cancel.addEventHandler("onclick",this.btn_Cancel_onclick,this);
            this.btn_Import.addEventHandler("onclick",this.btn_Import_onclick,this);
            this.Grid00.addEventHandler("oncelldblclick",this.Grid00_oncelldblclick,this);
            this.btn_Find.addEventHandler("onclick",this.btn_Find_onclick,this);
        };

        this.loadIncludeScript("Import.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
