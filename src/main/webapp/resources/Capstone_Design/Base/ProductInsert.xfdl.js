(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("ProductInsert");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(400,300);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("dsProduct", this);
            obj._setContents("<ColumnInfo><Column id=\"Product_id\" type=\"STRING\" size=\"256\"/><Column id=\"Product_name\" type=\"STRING\" size=\"256\"/><Column id=\"Price\" type=\"INT\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static01","26","43","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("품목번호");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","26","105","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("품 명");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","120","39","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit01","120","101","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","26","168","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("단 가");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit02","120","165","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            this.addChild(obj.name, obj);

            obj = new Button("btn_Insert","70","231","100","39",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("등 록");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            obj = new Button("btn_Cancel","200","231","100","39",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("취 소");
            obj.set_cssclass("bt_search");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",400,300,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("product_id","Edit00","value","dsProduct","Product_id");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("product_name","Edit01","value","dsProduct","Product_name");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("price","Edit02","value","dsProduct","Price");
            this.addChild(obj.name, obj);
            obj.bind();
        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("ProductInsert.xfdl", function() {

        this.btn_Insert_onclick = function(obj,e)
        {
        	var id = "insert_product";
        	var url = "http://localhost:8080/sm/insertProduct";
        	var reqDs = "productData=dsProduct";
        	var resDs = "";
        	var args = "";
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.received = function (id,code,message)
        {
        	if (code == 0) {
        		this.alert("제품이 성공적으로 등록되었습니다!!");
        	} else {
        		this.alert("오류로 인해 제품을 등록하지 못했습니다!");
        	}
        };

        this.btn_Cancel_onclick = function(obj,e)
        {
        	this.close();
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.btn_Insert.addEventHandler("onclick",this.btn_Insert_onclick,this);
            this.btn_Cancel.addEventHandler("onclick",this.btn_Cancel_onclick,this);
        };

        this.loadIncludeScript("ProductInsert.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
