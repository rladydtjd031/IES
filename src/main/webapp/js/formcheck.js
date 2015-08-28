/**
 * 
 */
function joinFormCheck(f) {
	if (f.user_id.value == "") {
		alert("���̵� �Է��� �ּ���!");
		f.user_id.focus();
		return false;
	}
	if (f.idDup.value != f.user_id.value) {
		alert("����� �� ���� ���̵� �Դϴ�!")
		f.user_id.select();
		f.user_id.focus();
		return false;
	}
	if (f.user_pwd.value == ""){
		alert("��й�ȣ�� �Է��� �ּ���!");
		f.user_pwd.focus();
		return false;
	}
	if (f.pwdChk.value == "false"){
		alert("����� �� ���� ��й�ȣ �Դϴ�!");
		f.user_pwd.select();
		f.user_pwd.focus();
		return false;
	}
	if (f.user_pwd.value != f.user_pwd2.value){
		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�!");
		f.user_pwd2.select();
		f.user_pwd2.focus();
		return false;
	}
	if (f.line_no1.value == ""){
		alert("������ȣ�� �Է��� �ּ���!");
		f.line_no1.focus();
		return false;
	}
	if (f.line_no2.value == ""){
		alert("������ȣ�� �Է��� �ּ���!");
		f.line_no2.focus();
		return false;
	}
	if (f.line_no3.value == ""){
		alert("������ȣ�� �Է��� �ּ���!");
		f.line_no3.focus();
		return false;
	}
	if (f.phone_no1.value == ""){
		alert("�޴�����ȣ�� �Է��� �ּ���!");
		f.phone_no1.focus();
		return false;
	}
	if (f.phone_no2.value == ""){
		alert("�޴�����ȣ�� �Է��� �ּ���!");
		f.phone_no2.focus();
		return false;
	}
	if (f.phone_no3.value == "") {
		alert("�޴�����ȣ�� �Է��� �ּ���!");
		f.phone_no3.focus();
		return false;
	}
	if (f.post.value == ""){
		alert("�����ȣ ã�⸦ ���� �ּҸ� �Է��� �ּ���!");
		f.post.focus();
		return false;
	}
	if (f.address.value == ""){
		alert("�����ȣ ã�⸦ ���� �ּҸ� �Է��� �ּ���!");
		f.address.focus();
		return false;
	}
	if (f.email1.value == ""){
		alert("�̸����� �Է��� �ּ���!");
		f.email1.focus();
		return false;
	}
	if (f.email2.value == ""){
		alert("�̸����� �Է��� �ּ���!");
		f.email2.focus();
		return false;
	}
	return true;
}
function idCheck(val) {
	var params = "id="+ val;
	new ajax.xhr.Request("/IES/member/idCheck", params, idCheckResult, "POST");
}
function idCheckResult(xhr){
	if (xhr.readyState == 4 && xhr.status == 200) {
		var doc = xhr.responseXML;
		var id = getData(doc, "id");
		var msg = getData(doc, "msg");
		var val = getData(doc, "val");
		var idresult = new IDResult();
		if (val == "success") {
			idresult.ok(id, msg);
		} else {
			idresult.no(msg);
		}
	}
}


function getData(doc, id){
	return doc.getElementsByTagName(id).item(0).firstChild.nodeValue;
}
$(function(){
	var idRegx = /^[a-z0-9_]{6,18}$/;
	$("#id").keyup(function(){
		var val = $(this).val();
		if (idRegx.test(val)){
			idCheck(val);
		}else{
			var idresult = new IDResult();
			idresult.no("6~18�ڸ��� ����/���� ����");
		}
	});
	var pwdRegx = /^[a-z0-9_]{6,18}$/;
	$("#pswd1").keyup(function(){
		var val = $(this).val();
		if(pwdRegx.test(val)){
			document.frmjoin.pwdChk.value = "true";
			$("#pswd1Msg").hide();
		} else {
			document.frmjoin.pwdChk.value = "false";
			$("#pswd1Msg").text("6~18�ڸ��� ����/���� ����");
			$("#pswd1Msg").show();
		}
	})
	$("#pswd2").keyup(function(){
		var val = $(this).val();
		var pswd = document.frmjoin.user_pwd.value;
		if (val != pswd) {
			$("#pswd2Msg").show();
		} else {
			$("#pswd2Msg").hide();
		}
	})
  $('.num_only').css('imeMode', 'disabled').keypress(function(event) {
		if (event.which && (event.which < 48 || event.which > 57)) {
			event.preventDefault();
		}
	}).keyup(function() {
		if ($(this).val() != null && $(this).val() != '') {
			$(this).val($(this).val().replace(/[^0-9]/g, ''));
		}
	});
	
});

IDResult = function(id, msg){
	this.id = id;
	this.msg = msg;
}
IDResult.prototype={
	ok : function(id, msg){
		$("#idDup").val(id);
		$("#idMsg").text(msg);
		$("#idMsg").removeClass("error");
		$("#idMsg").addClass("nonError");		
	},
	no : function(msg){
		$("#idDup").val("");
		$("#idMsg").text(msg);
		$("#idMsg").removeClass("nonError");
		$("#idMsg").addClass("error");
	}
}
