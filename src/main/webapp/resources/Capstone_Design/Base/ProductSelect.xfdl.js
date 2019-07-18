(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("ImportProductSelect");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(500,400);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"Label\" type=\"STRING\" size=\"256\"/><Column id=\"Level\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Label\">품 목</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">품목번호</Col><Col id=\"Level\">2</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsProduct", this);
            obj._setContents("<ColumnInfo><Column id=\"Product_id\" type=\"STRING\" size=\"256\"/><Column id=\"Product_name\" type=\"STRING\" size=\"256\"/><Column id=\"Price\" type=\"INT\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","15","90","465","270",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("dsProduct");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"100\"/><Column size=\"250\"/><Column size=\"110\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"품목번호\"/><Cell col=\"1\" text=\"품 명\"/><Cell col=\"2\" text=\"가 격\"/></Band><Band id=\"body\"><Cell text=\"bind:Product_id\"/><Cell col=\"1\" text=\"bind:Product_name\"/><Cell col=\"2\" text=\"bind:Price\" displaytype=\"currency\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","15","40","119","34",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_innerdataset("Dataset00");
            obj.set_codecolumn("Level");
            obj.set_datacolumn("Label");
            obj.set_text("품 목");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","139","40","231","34",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Button("btn_Find","380","40","100","34",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("검 색");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",500,400,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("ProductSelect.xfdl", function() {

        this.ImportProductSelect_onload = function(obj,e)
        {
        	var id = "selectAllProduct";
        	var url = "http://localhost:8080/sm/selectAllProduct";
        	var reqDs = "";
        	var resDs = "dsProduct=AllProductData";
        	var args = "";
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.received = function (id,code,message)
        {

        };

        this.Grid00_oncelldblclick = function(obj,e)
        {
        	var sRtn = this.dsProduct.getColumn(this.dsProduct.rowposition, "Product_id") + "|";
        	sRtn += this.dsProduct.getColumn(this.dsProduct.rowposition, "Product_name") + "|";
        	sRtn += this.dsProduct.getColumn(this.dsProduct.rowposition, "Price");

        	this.close(sRtn);
        };

        this.btn_Find_onclick = function(obj,e)
        {
        	var index = this.Combo00.value;
        	var strCondition = this.Edit00.value;

        	var url = "";
        	if (index == 1) {
        		url = "http://localhost:8080/sm/selectProductName";
        	} else {
        		url = "http://localhost:8080/sm/selectProductId";
        	}

        	var id = "selectProduct";
        	var reqDs = "";
        	var resDs = "dsProduct=FindProductData";
        	var args = "condition=" + strCondition;
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.ImportProductSelect_onload,this);
            this.Grid00.addEventHandler("oncelldblclick",this.Grid00_oncelldblclick,this);
            this.btn_Find.addEventHandler("onclick",this.btn_Find_onclick,this);
        };

        this.loadIncludeScript("ProductSelect.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
