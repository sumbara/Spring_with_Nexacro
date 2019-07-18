(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Inventory_Status");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1080,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"Label\" type=\"STRING\" size=\"256\"/><Column id=\"Level\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Label\">품 명</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">품목번호</Col><Col id=\"Level\">2</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsWarehouse", this);
            obj._setContents("<ColumnInfo><Column id=\"Product_id\" type=\"STRING\" size=\"256\"/><Column id=\"Product_name\" type=\"STRING\" size=\"256\"/><Column id=\"Count\" type=\"INT\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","50","50","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("재고 현황");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","122","156","118","34",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_innerdataset("Dataset00");
            obj.set_codecolumn("Level");
            obj.set_datacolumn("Label");
            obj.set_text("품 목");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","123","214","607","276",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_binddataset("dsWarehouse");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"150\"/><Column size=\"300\"/><Column size=\"150\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"품목 번호\"/><Cell col=\"1\" text=\"품 명\"/><Cell col=\"2\" text=\"수 량\"/></Band><Band id=\"body\"><Cell text=\"bind:Product_id\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:Product_name\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:Count\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("btn_find","610","154","120","39",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("검 색");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","247","156","293","34",null,null,null,null,null,null,this);
            obj.set_taborder("4");
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
        this.registerScript("Inventory_Status.xfdl", function() {
        this.Inventory_Status_onload = function(obj,e)
        {
        	var id = "selectAllWarehouse";
        	var url = "http://localhost:8080/sm/selectAllWarehouse";
        	var reqDs = "";
        	var resDs = "dsWarehouse=AllWarehouseData";
        	var args = "";
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.received = function (id,code,message)
        {

        };

        this.btn_find_onclick = function(obj,e)
        {
        	var index = this.Combo00.value;
        	var strCondition = this.Edit00.value;

        	if (index == 1) {
        		this.dsWarehouse.filter("Product_name.indexOf('" + strCondition + "') >= 0");
        	} else {
        		this.dsWarehouse.filter("Product_id.indexOf('" + strCondition + "') > = 0");
        	}
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Inventory_Status_onload,this);
            this.btn_find.addEventHandler("onclick",this.btn_find_onclick,this);
        };

        this.loadIncludeScript("Inventory_Status.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
