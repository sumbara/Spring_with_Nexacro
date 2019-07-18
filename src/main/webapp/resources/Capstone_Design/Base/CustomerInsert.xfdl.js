(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("CustomerInsert");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(400,300);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("dsCustomer", this);
            obj._setContents("<ColumnInfo><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"Customer_name\" type=\"STRING\" size=\"256\"/><Column id=\"Phone\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static01","26","43","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("사업자 번호");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","26","105","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("거래처 명");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","130","39","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit01","130","101","160","31",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","26","168","88","22",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("전화번호");
            obj.set_cssclass("st_content");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit02","130","165","160","31",null,null,null,null,null,null,this);
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
            obj = new BindItem("customer_id","Edit00","value","dsCustomer","Customer_id");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("customer_name","Edit01","value","dsCustomer","Customer_name");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("phone","Edit02","value","dsCustomer","Phone");
            this.addChild(obj.name, obj);
            obj.bind();
        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("CustomerInsert.xfdl", function() {

        this.btn_Insert_onclick = function(obj,e)
        {
        	var id = "insert_customer";
        	var url = "http://localhost:8080/sm/insertCustomer";
        	var reqDs = "customerData=dsCustomer";
        	var resDs = "";
        	var args = "";
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.received = function (id,code,message)
        {
        	if (code == 0) {
        		this.alert("거래처가 성공적으로 등록되었습니다!!");
        	} else {
        		this.alert("오류로 인해 거래처를 등록하지 못했습니다!");
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

        this.loadIncludeScript("CustomerInsert.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
