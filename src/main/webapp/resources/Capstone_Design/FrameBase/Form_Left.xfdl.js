(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Left");
            this.set_titletext("Form_Left");
            this.set_background("URL(\"imagerc::main_left.jpg\")");
            this.set_accessibilityrole("none");
            if (Form == this.constructor)
            {
                this._setFormPosition(200,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"Label\" type=\"STRING\" size=\"256\"/><Column id=\"Level\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Label\">재고 현황</Col><Col id=\"Level\">0</Col></Row><Row><Col id=\"Label\">제품 입고</Col><Col id=\"Level\">0</Col></Row><Row><Col id=\"Label\">입 고</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">입고 내역</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">제품 출고</Col><Col id=\"Level\">0</Col></Row><Row><Col id=\"Label\">출 고</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">출고 내역</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">지급 관리</Col><Col id=\"Level\">0</Col></Row><Row><Col id=\"Label\">지 급</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">지급 내역</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">수금 관리</Col><Col id=\"Level\">0</Col></Row><Row><Col id=\"Label\">수 금</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">수금 내역</Col><Col id=\"Level\">1</Col></Row><Row><Col id=\"Label\">마 감</Col><Col id=\"Level\">0</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","10","70","180","340",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("Dataset00");
            obj.set_treeinitstatus("expand,all");
            obj.set_treeusecheckbox("false");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"188\"/></Columns><Rows><Row size=\"24\"/></Rows><Band id=\"body\"><Cell text=\"bind:Label\" displaytype=\"treeitemcontrol\" edittype=\"tree\" treelevel=\"bind:Level\" font=\"16px/normal &quot;LG스마트체 Bold&quot;\" cssclass=\"main_grid\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","20","12","112","38",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("태욱분식");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","Desktop_screen",200,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_Left.xfdl", function() {
        var objApp = nexacro.getApplication();

        this.Grid00_oncellclick = function(obj,e)
        {
        	if (e.row == 0) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Inventory_Status.xfdl");
        	} else if (e.row == 2) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Import.xfdl");
        	} else if (e.row == 3) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Import_History.xfdl");
        	} else if (e.row == 5) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Export.xfdl");
        	} else if (e.row == 6) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Export_History.xfdl");
        	} else if (e.row == 8) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Payment.xfdl");
        	} else if (e.row == 9) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Payment_History.xfdl");
        	} else if (e.row == 11) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Collect.xfdl");
        	} else if (e.row == 12) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Collect_History.xfdl");
        	} else if (e.row == 13) {
        		objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Settlement.xfdl");
        	}
        };

        this.Form_Left_onload = function(obj,e)
        {
        	objApp.mainframe.HFrameSet00.WorkFrame.set_formurl("Base::Inventory_Status.xfdl");
        };
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Form_Left_onload,this);
            this.Grid00.addEventHandler("oncellclick",this.Grid00_oncellclick,this);
        };

        this.loadIncludeScript("Form_Left.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
