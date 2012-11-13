<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<c:url value="/cmplsend" var="sendUrl"/>
<c:url value="/fileupload" var="uploadUrl"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ page session="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Подача жалобы</title>


    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/complaints.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/form.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/js/jquery-ui-1.9.1/themes/base/jquery-ui.css"/>'/>

    <script type='text/javascript' src='<c:url value="/resources/js/jquery-ui-1.9.1/jquery-1.8.2.js"/>'></script>
    <script type='text/javascript' src='<c:url value="/resources/js/jquery-ui-1.9.1/ui/jquery.ui.core.js"/>'></script>
    <script type='text/javascript' src='<c:url value="/resources/js/jquery-ui-1.9.1/ui/jquery.ui.widget.js"/>'></script>
    <script type='text/javascript' src='<c:url value="/resources/js/jquery-ui-1.9.1/ui/jquery.ui.button.js"/>'></script>

    <script type='text/javascript'>
        $(document).ready(function () {
            console.log("Initial script....");
            $.get("/ref/departments",
                    function (responce) {
                        var select = $('#department').empty();
                        var options = '';
                        for (var i = 0; i < responce.data.length; i++) {
                            options += '<option value="' + responce.data[i].id + '">'+ responce.data[i].code + "&nbsp;" + responce.data[i].name + '</option>';
                            console.log(responce.data[i].name);
                        }
                        $("select#department").html(options);
                    }, "json");

            /* initial */
            $('#lastname').show();
            $('#firstname').show();
            $('#thirdname').show();
            $('#entitlement').hide();

            $('input[name=who]').click(function () {
                if ($(this).val() == "company") {
                    $('#lastname').hide();
                    $('#firstname').hide();
                    $('#thirdname').hide();
                    $('#entitlement').show();
                } else if ($(this).val() == "man") {
                    $('#lastname').show();
                    $('#firstname').show();
                    $('#thirdname').show();
                    $('#entitlement').hide();
                } else if ($(this).val() == "rep_man") {
                    $('#lastname').show();
                    $('#firstname').show();
                    $('#thirdname').show();
                    $('#entitlement').show();
                } else if ($(this).val() == "rep_company") {
                    $('#lastname').show();
                    $('#firstname').show();
                    $('#thirdname').show();
                    $('#entitlement').show();
                }
            });
        });
    </script>
</head>

<body bgcolor="#F5F6F6">

<table width="640" align="center">
    <tr>
        <td width="630">
            <div class="formCaption">
                Подача жалоб
            </div>
        </td></tr>
    <tr><td>
        <p>Поля отмеченные знаком <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" />, обязательны для заполнения</p>
    </td></tr>
    <tr><td>
        <form id="cmplform" name="cmplform" method="post" action="/sendcmpl">
            <form:hidden path="session-id" value="${session-id}" />
            <fieldset>
                <legend>&nbsp;<strong>Жалоба</strong>&nbsp;</legend>

                <p>Орган в который будет отправлена жалоба: <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /><br />
                    <!-- Генерируется из справочной таблицы CMPL_DEPARTMENT -->
                    <select name="department" size="1" id="department">
                        <option id="01" value="-1">Данные не загружены</option>
                    </select>

                </p>
                <p>Наименование  органа, предоставляющего государственную услугу, должностного лица органа, предоставляющего государственную услугу, либо федерального государственного служащего, решения и действия (бездействия) которых обжалуются <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /><br>
                    <input name="dep_name" type="text" id="dep_name" size="96" />
                </p>
                <hr>
                <table width="630" border="0">
                    <tr>
                        <td width="135" align="right"><strong>Кем являетесь:</strong></td>
                        <td width="218"><input name="who" type="radio" id="man" value="man" checked="checked" />
                            <label for="man">Физическое лицо</label></td>
                        <td width="263"><input type="radio" name="who" id="rep_man" value="rep_man" />
                            <label for="rep_man">Представитель физического лица</label></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="radio" name="who" id="company" value="company" />
                            <label for="company">Юридическое лицо</label></td>
                        <td><input type="radio" name="who" id="rep_company" value="rep_company" />
                            <label for="rep_company">Представитель юридического лица</label></td>

                    </tr>
                </table>
                <hr>


                <table width="697" border="0">
                    <tr id="lastname">
                        <td width="135" align="right" valign="middle">Фамилия: <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /></td>
                        <td width="528" align="left" valign="middle" nowrap="nowrap"><input type="text" name="lastname" id="lastname"  required="required"/></td>
                    </tr>
                    <tr id="firstname">
                        <td width="135" align="right" valign="middle">Имя: <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /></td>
                        <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="firstname" id="firstname" required="required" /></td>
                    </tr>
                    <tr id="thirdname">
                        <td width="135" align="right" valign="middle">Отчество: <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /></td>
                        <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="thirdname" id="thirdname" required="required" /></td>
                    </tr>
                    <tr id="entitlement">
                        <td width="135" align="right" valign="middle">Наименование: <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /></td>
                        <td align="left" valign="middle" nowrap="nowrap"><input name="entitlement" type="text" id="entitlement" size="80" required="required" /></td>
                    </tr>
                    <tr>
                        <td align="right" valign="middle">Местонахождение: <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /></td>
                        <td align="left" valign="middle" nowrap="nowrap"><input name="post_index" type="text" id="post_index" value="Индекс" size="8" />
                            <input name="post_address" type="text" id="post_address" value="Почтовый адрес" size="72" required="required" /></td>
                    </tr>
                    <tr>
                        <td align="right" valign="middle">Телефон: </td>
                        <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="phone" id="phone" /></td>
                    </tr>
                    <tr>
                        <td align="right" valign="middle">Адрес Email: <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /></td>
                        <td align="left" valign="middle" nowrap="nowrap"><input type="email" name="email" id="email" required="required"/></td>
                    </tr>
                </table>
                <hr>
                <p><strong>Тематика обращения:</strong> <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /></p>
                <table width="100%" border="0" align="center">
                    <tr>

                        <!-- Генерируется из справочной таблицы CMPL_CATEGORY -->

                        <td width="309" align="left" valign="top"><p>
                            <input type="radio" name="q" id="q1" value="q1" />
                            <label for="q1">Вопросы, связанные с государственной регистрацией прав на недвижимое имущество и сделок с ним и государственным кадастром недвижимости</label> <br/>
                            <input name="q" type="radio" id="q2" value="q2" checked="checked" />
                            <label for="q2">Вопросы, связанные с предоставлением информации из ЕГРП и ГКН</label><br/>
                            <input type="radio" name="q" id="q3" value="q3" />
                            <label for="q3">Вопросы срыва сроков предоставления сведений по ранее направленным запросам и функционированию Портала услуг Росреестра</label><br/>
                            <input type="radio" name="q" id="q4" value="q4" />
                            <label for="q4">Вопросы, связанные с деятельностью саморегулируемых организаций арбитражных управляющих</label><br/>
                            <input type="radio" name="q" id="q5" value="q5" />
                            <label for="q5">Вопросы, связанные с кадастровой оценкой объектов недвижимости</label><br/>
                            <input type="radio" name="q" id="q6" value="q6" />
                            <label for="q6">Вопросы, связанные с государственным земельным контролем, землеустройством и мониторингом земель</label><br/>
                            <input type="radio" name="q" id="q7" value="q7" />
                            <label for="q7">Вопросы, связанные с техническим учетом и инвентаризацией объектов капитального строительства</label></p></td>
                        <td width="309" align="left" valign="top"><p>
                            <input type="radio" name="q" id="q8" value="q8" />
                            <label for="q8">Вопросы, связанные с геодезической, картографической и навигационной деятельностью</label><br/>
                            <input type="radio" name="q" id="q9" value="q9" />
                            <label for="q9">Жалобы на организацию работы (отказ в приеме и выдаче документов, время ожидания в очереди превышает установленное административным регламентом, отсутствие предварительной записи (плохая организация), некорректное обслуживание заявителя на приеме,  требование внесения платы, не предусмотренной нормативными правовыми актами Российской Федерации и др.)</label><br />
                            <input type="radio" name="q" id="q10" value="q10" />
                            <label for="q10">Жалобы на работу руководителей (специалистов) территориальных органов Росреестра</label><br/>
                            <input type="radio" name="q" id="q11" value="q11" />
                            <label for="q11">Предложения по совершенствованию деятельности Росреестра и его территориальных органов</label><br/>
                            <input type="radio" name="q" id="q12" value="q12" />
                            <label for="q12">Другие вопросы, относящиеся к компетенции Росреестра</label></p></td>
                    </tr>
                </table>
                <p><strong>Текст обращения:</strong> <img src="/resources/img/attention.gif" width="16" height="16" alt="A!" /><br />
                    <textarea name="appeal" id="appeal" cols="96" rows="10"  required="required"></textarea>
                    <br />
                <fieldset>
                    <legend>&nbsp;<strong>Прилагаемые документы</strong>&nbsp;</legend>
                    <p>Если вы являетесь представителем физического или юридического лица, для отправки обращения вам необходимо приложить один из этих документов:</p>
                    <p>      доверенность, оформленную в соответствии с законодательством Российской Федерации, заверенную печатью заявителя и подписанную руководителем заявителя или уполномоченным этим руководителем лицом;<br>
                        копию решения о назначении или об избрании либо приказа о назначении физического лица на должность, в соответствии с которым </p>
                    <p>такое физическое лицо обладает правом действовать от имени заявителя без доверенности.<br>
                        В этом случае обращение необходимо подписать цифровой подписью с помощью кнопки «Подписать и отправить».
                    </p>
                    <p>
                        <input type="submit" name="addfile" id="addfile" value="Добавить" />
                    </p>
                </fieldset>
                </p>
            </fieldset>
            <input type="submit" value="Отправить" />
        </form>

        <p>&nbsp;</p>
    </td></tr>
</table>>
</body>
</html>
