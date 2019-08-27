/*$("form").serialize()*/

/*
	<tr>
		<td colspan="8">
			<button onclick="getPage(1)">��ҳ</button>
			<button onclick="getPage(${pageUtil.prevPage })">��һҳ</button>
			��ǰҳ��${pageUtil.currentPage }/${pageUtil.totalPage }&nbsp;&nbsp;&nbsp;
			�ܼ�¼����${pageUtil.totalCount }
			<button onclick="getPage(${pageUtil.nextPage })">��һҳ</button>
			<button onclick="getPage(${pageUtil.totalPage })">βҳ</button>
		</td>
	</tr>
*/

/*
$.post("",
	$("form").serialize()
,function(){

},"text")
*/
$(function () {
    /*$("#ck").click(function(){
        var flag = $(this).is(":checked");
        $(":checkbox[name='cm']").prop("checked",flag);
    });*/

    /*$(":checkbox[name='cm']").click(function(){
    var len=0;
    $("[name='cm']").map(function(i,dom){
        if($(dom).is(":checked"))
            len++;
    $("#ck").prop("checked",len===$("[name='cm']").length);
    });
});*/
    //ȫѡ
    $("th").find(":checkbox").click(function () {
        var flag = $(this).is(":checked");
        $("td").find(":checkbox").prop("checked", flag);
    });

    //��ѡ
    $("#fx").click(function () {
        var len = 0;
        $("td").find(":checkbox").map(function (i, dom) {
            dom.checked = !dom.checked;
            if ($(dom).is(":checked"))
                len++;
        })
        $("th").find(":checkbox").prop("checked", len === $("td").find(":checkbox").length);
    });

    //����ѡ��
    $("td").find(":checkbox").click(function () {
        var len = 0;
        $("td").find(":checkbox").map(function (i, dom) {
            if ($(dom).is(":checked"))
                len++;
        });
        $("th").find(":checkbox").prop("checked", len === $("td").find(":checkbox").length);
    });
});

//����ɾ�� ��ȡids   var ids=getids()
function getIds() {
    var ids = "";
    $("td").find(":checkbox").map(function (i, dom) {
        if ($(dom).is(":checked")) {
            ids += "," + $(this).val()
        }
    });
    ids = ids.substring(1)
    return ids;
}
