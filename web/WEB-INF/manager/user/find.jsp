<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>可编辑表格</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/demo/demo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div style="margin:20px 0;"></div>

<table id="dg" title="用户管理" style="width:100%;height:auto"
       data-options="
	   			rownumbers:true,
	   			singleSelect:true,
	   			pagination:true,
	   			striped:true,
				singleSelect: true,
				url:'${pageContext.request.contextPath }/action/user/find.do',
				method:'get'
			">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:80">用户ID</th>
        <th data-options="field:'name',width:100">姓名</th>
        <th data-options="field:'password',width:80,align:'right'">密码</th>
    </tr>
    </thead>
</table>

<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">用户信息</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>编号</label>
            <input name="id" readonly class="easyui-validatebox">
        </div>
        <div class="fitem">
            <label>姓名</label>
            <input name="name" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>密码</label>
            <input name="password">
        </div>
        <%--        <div class="fitem">
                    <label>邮箱</label>
                    <input name="email" class="easyui-validatebox" validType="email">
                </div>--%>
    </form>
</div>

<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#dlg').dialog('close')">Cancel</a>
</div>

<script type="text/javascript">

    $(function () {

        var pager = $('#dg').datagrid().datagrid('getPager');
        pager.pagination({
            displayMsg: "",
            buttons: [{
                iconCls: 'icon-search',
                handler: function () {
                    alert('search');
                }
            }, {
                iconCls: 'icon-remove',
                handler: function () {
                    destroyUser();
                }
            },
                {
                    iconCls: 'icon-add',
                    handler: function () {
                        $('#dlg').dialog('open').dialog('setTitle', 'New User');
                        $('#fm').form('clear');
                        url = '${pageContext.request.contextPath }/action/user/add.do';
                    }
                }, {
                    iconCls: 'icon-edit',
                    handler: function () {
                        var row = $('#dg').datagrid('getSelected');
                        if (row) {
                            $('#dlg').dialog('open').dialog('setTitle', 'Edit User');
                            $('#fm').form('load', row);
                            url = '${pageContext.request.contextPath }/action/user/update.do?id=' + row.id;
                        }
                    }
                }]
        });
    });


    function destroyUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', 'Are you sure you want to destroy this user?', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/action/user/delete.do', {id: row.id}, function (result) {
                        if (result.status) {
                            $('#dg').datagrid('reload');	// reload the user data
                        }

                        $.messager.show({	// show error message
                            title: '提示',
                            msg: result.msg
                        });

                    }, 'json');
                }
            });
        }
    }

    function saveUser() {
        $('#fm').form('submit', {
            url: url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (result) {
                var result = eval('(' + result + ')');
                if (result.msg) {
                    $.messager.show({
                        title: '提示',
                        msg: result.msg
                    });
                }
                if (result.status) {
                    $('#dlg').dialog('close');		// close the dialog
                    $('#dg').datagrid('reload');	// reload the user data
                }
            }
        });
    }

</script>
</body>
</html>