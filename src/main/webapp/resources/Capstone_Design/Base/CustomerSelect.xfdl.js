(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("CustomerSelect");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(500,400);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("dsCustomer", this);
            obj._setContents("<ColumnInfo><Column id=\"Customer_id\" type=\"STRING\" size=\"256\"/><Column id=\"Customer_name\" type=\"STRING\" size=\"256\"/><Column id=\"Phone\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"Label\" type=\"STRING\" size=\"256\"/><Column id=\"Level\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Label\">거래처</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">사업자 번호</Col><Col id=\"Level\">2</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Combo("Combo00","15","40","119","34",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_innerdataset("Dataset00");
            obj.set_codecolumn("Level");
            obj.set_datacolumn("Label");
            obj.set_text("품 목");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","139","40","231","34",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            this.addChild(obj.name, obj);

            obj = new Button("btn_Find","380","40","100","34",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("검 색");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","15","90","465","270",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_binddataset("dsCustomer");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"140\"/><Column size=\"170\"/><Column size=\"140\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"사업자 번호\"/><Cell col=\"1\" text=\"거래처\"/><Cell col=\"2\" text=\"전화 번호\"/></Band><Band id=\"body\"><Cell text=\"bind:Customer_id\"/><Cell col=\"1\" text=\"bind:Customer_name\"/><Cell col=\"2\" text=\"bind:Phone\"/></Band></Format></Formats>");
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
        this.registerScript("CustomerSelect.xfdl", function() {

        this.CustomerSelect_onload = function(obj,e)
        {
        	var id = "selectAllCustomer";
        	var url = "http://localhost:8080/sm/selectAllCustomer";
        	var reqDs = "";
        	var resDs = "dsCustomer=AllCustomerData";
        	var args = "";
        	var callback = "received";

        	this.transaction(id, url, reqDs, resDs, args, callback);
        };

        this.received = function (id,code,message)
        {

        };

        this.btn_Find_onclick = function(obj,e)
        {
        	var index = this.Combo00.value;
        	var strCondition = this.Edit00.value;

        	var url = "";
        	if (index == 1) {
        		this.dsCustomer.filter("Customer_name.indexOf('" + strCondition + "') >= 0");
        	} else {
        		this.dsCustomer.filter("Customer_id.indexOf('" + strCondition + "') >= 0");
        	}
        };

        this.Grid00_oncelldblclick = function(obj,e)
        {
        	var sRtn = this.dsCustomer.getColumn(this.dsCustomer.rowposition, "Customer_id") + "|";
        	sRtn += this.dsCustomer.getColumn(this.dsCustomer.rowposition, "Customer_name") + "|";
        	sRtn += this.dsCustomer.getColumn(this.dsCustomer.rowposition, "Phone");

        	this.close(sRtn);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.CustomerSelect_onload,this);
            this.btn_Find.addEventHandler("onclick",this.btn_Find_onclick,this);
            this.Grid00.addEventHandler("oncelldblclick",this.Grid00_oncelldblclick,this);
        };

        this.loadIncludeScript("CustomerSelect.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
