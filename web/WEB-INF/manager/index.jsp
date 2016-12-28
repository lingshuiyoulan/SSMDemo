<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>

</head>

<body style="margin: 0 auto;">
<div id="cc" class="easyui-layout" style="width:100%;height:100%;">
    <div data-options="region:'north'" style="height:100px;">
        <h2>XXX后台管理系统</h2>
    </div>
    <div data-options="region:'south'" style="height:100px;">
        south
    </div>
    <div data-options="region:'west',title:'菜单',split:true" style="width:250px;">
        <ul id="tt"></ul>
    </div>
    <div data-options="region:'center',title:'功能区'" style="padding:5px;background:#eee;">
        <div id="tabs" class="easyui-tabs" fit="true">
            <div title="主页面" style="padding:20px;">
                默认广告页面
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $('#tt').tree({
        url: '${pageContext.request.contextPath }/action/emp/json.do?empId=${user.id}',
        onClick: function (node) {
            openTab(node);
        }
    });
    function openTab(node) {
        if ($("#tabs").tabs("exists", node.text)) {
            $("#tabs").tabs("select", node.text);
        } else {
            var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src=" + node.attributes.url + "></iframe>";
            $("#tabs").tabs("add", {
                title: node.text,
                closable: true,
                content: content
            });
        }
    }
</script>
</body>
</html>