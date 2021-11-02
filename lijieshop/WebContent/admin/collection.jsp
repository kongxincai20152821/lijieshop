<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏表管理</title>
<style type="text/css">
*{
   margin:0px;
   padding:0px;
}
</style>
<script type="text/javascript">
  function formToJson(id){
	  var arr=$("#"+id).serializeArray();
	  var jsonStr="";
	  jsonStr+="{";
	  for(var i=0;i<arr.length;i++){
		  jsonStr+=('"'+arr[i].name+'":"'+arr[i].value+'",');
	  }
	  jsonStr=jsonStr.substring(0,jsonStr.length-1);
	  jsonStr+="}";
	  var json=JSON.parse(jsonStr);
	  return json;
  }
  $(function(){
	  $("#dg").datagrid({
		 idField:"cid",
		 url:"../collectionQueryByPage",
		 queryParams:formToJson("searchform"),
				 columns:[[
					 {field:"",checkbox:true },
					 {field:"cid",width:100,title:"收藏ID",align:"center" },
					 {field:"user_id",width:100,title:"用户ID",align:"center" },
					 {field:"goods_id",width:100,title:"商品ID",align:"center" },
					 {field:"goodsName",width:100,title:"商品名称",align:"center" },
					 {field:"price",width:100,title:"商品价格",align:"center" },
					 {field:"newPrice",width:100,title:"商品现价",align:"center" },
					 {field:"introduce",width:100,title:"商品介绍",align:"center" },
					 {field:"logo_path",width:100,title:"商品图片",align:"center" }
		         ]],
					toolbar:[
						{
							text:"新增",
							iconCls: 'icon-add',
							handler: function(){
								add();
							}
						},
						{
							text:"编辑",
							iconCls: 'icon-edit',
							handler: function(){
									var selectedRow=$("#dg").datagrid("getSelections");
									if(selectedRow.length==0){
											$.messager.alert('提示消息','请选择数据','info');
											return;
									}else if(selectedRow.length>1){
											$.messager.alert('提示消息','只能选择一条数据','info');
											return;
									}
									$("#ff").form("reset");
									$("#editDialog").dialog({
										  title:"修改弹窗",
										  buttons:[{
												text:'保存',
												iconCls:"icon-save",
												handler:function(){
													update();
												}
											},{
												text:'重置',
												iconCls:"icon-reload",
												handler:function(){
													var selectedRow=$("#dg").datagrid("getSelections");
													if(selectedRow.length==0){
															$.messager.alert('提示消息','请选择数据','info');
															return;
													}else if(selectedRow.length>1){
															$.messager.alert('提示消息','只能选择一条数据','info');
															return;
													}
													$("#ff").form('load',selectedRow[0]);
												}
											},{
												text:'关闭',
												iconCls:"icon-cancel",
												handler:function(){
													$("#editDialog").dialog("close");
												}
											}]
									});
									$("#editDialog").window('open');
									//带上原数据
									$("#ff").form('load',selectedRow[0]);
							}
						},
						{
							text:"批量删除",
							iconCls: 'icon-remove',
							handler: function(){
								remove();
							}
						}
					],
					pagination:true,
					fitColumns:true,
					pageSize:20
	  });
	  
	    $("#search_btn").click(function() {
	        $('#dg').datagrid({ 
	        	queryParams: formToJson("searchform")
	        })  
	    });
	  
	    $("#research_btn").click(function() {
	        $('#searchform').form("reset");
	        $('#dg').datagrid({ 
	        	queryParams: formToJson("searchform")
	        });
	    });
	  
	    $('#select_file').filebox({    
	        buttonText: '选择文件'
	    });
	  
	    $("#import_btn").click(function(){
	    	$.messager.confirm("提示消息","您确认导入?",function(r){
	    		if(r){
	    			$.messager.alert("提示消息","导入","info");
	    		}
	    	});
	    	
	    });
	    $("#export_btn").click(function(r){
	    	$.messager.confirm("提示消息","您确认导出?",function(){
	    		if(r){
	    			$.messager.alert("提示消息","导出","info");
	    		}
	    	});
	    });
  }); 
 
  function add(){
	  $("#zz").form("reset");
	  $("#addDialog").dialog({
		  title:"增加弹窗",
		  buttons:[{
				text:'保存',
				iconCls:"icon-save",
				handler:function(){
					add1();
				}
			},{
				text:'关闭',
				iconCls:"icon-cancel",
				handler:function(){
					$("#addDialog").dialog("close");
				}
			}],
		  closed:false
	  });
  }
  
  function add1(){
	  $('#zz').form('submit',{
			url:'../collectionAdd',
			type:"post",
			dataType:'json',
			success: function(result){
				var result=JSON.parse(result);
				if(result.state==0){
						$.messager.alert('提示消息',result.msg,'info');
						$("#addDialog").window('close');
						$("#dg").datagrid("reload");
				}else{
						$.messager.alert('错误消息',result.msg,'error');
				}
			}
		});
    }
  
  function remove(){
	  var array = $("#dg").datagrid("getSelections");
		if(array.length==0){
			$.messager.alert('提示信息','请先选择要删除的记录','info');
			return;
		}
		$.messager.confirm('提示信息',"你确认要删除这"+array.length+"条记录？",function(r){
			if(r){
				var ids = "";
				for(var i=0;i<array.length;i++){
					ids += array[i].cid+","
				}
				ids = ids.substring(0,ids.length-1);
				$.ajax({
					url:"../collectionDeleteMore",
					type:"post",
					data:"ids="+ids,
					dataType:"json",
					success:function(result){
						if(result.state==0){
						    //刷新页面
						   $("#dg").datagrid("reload");
						   $.messager.alert("提示信息",result.msg,"info");
						}else{
						   $.messager.alert("提示信息",result.msg,"error");
						}
						$("#dg").datagrid("clearSelections");
					}
				});
			}
		});
  }
    
    function update(){
    	var selectedRow=$("#dg").datagrid("getSelected");
        //表单提交 会获取表单的所有信息
	    $('#ff').form('submit',{
				url:'../collectionUpdate?id='+selectedRow.cid, //selectedRow.empno 获取选中行的数据id
				success: function(msg){
					var msg=JSON.parse(msg);
					if(msg.state==0){
							$.messager.alert('提示消息',msg.msg,'info');
							$("#editDialog").window('close');
							$("#dg").datagrid("reload");
						}else{
							$.messager.alert('错误消息',msg.msg,'error');
					}
				}
	    });	    
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true">
<div style="">
   <form  id="searchform" method="post" style="text-align:center;padding:5px">
		   <a id="research_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:130px;position:relative;float:left">清空查询条件</a>
		      收藏ID：<input class="easyui-textbox" name="qCid"  style="width:100px"> 
		      用户ID：<input class="easyui-textbox" name="qUserId" style="width:100px"> 
		   <a id="search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
   </form>
 </div>
 <div style="width:100%;height:95%"  >
    <table id="dg" fit="true"></table>
 </div>
<!-- 增加弹窗 -->
<div id="addDialog" class="easyui-dialog" style="top:100px;padding:20px"   data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true"  >
  <form action="" method="post" id="zz" style="">
       <table>
			<tr><td>用户ID：</td><td><input name="user_id" class="easyui-textbox" data-options="required:true"></td></tr>
			<tr><td>商品ID：</td><td><input name="goods_id" class="easyui-textbox" data-options="required:true"></td></tr>
       </table>
  </form>
</div>
<!-- 修改弹窗 -->
<div id="editDialog" class="easyui-dialog" style="top:100px;padding:20px"   data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true"  >
  <form  method="post" id="ff">
     <table>
			<tr><td>收藏表ID：</td><td><input name="cid" class="easyui-textbox" data-options="required:true"></td></tr>
			<tr><td>用户ID：</td><td><input name="user_id" class="easyui-textbox" data-options="required:true"></td></tr>
			<tr><td>商品ID：</td><td><input name="goods_id" class="easyui-textbox" data-options="required:true"></td></tr>
       </table>
  </form>
</div>
</html>