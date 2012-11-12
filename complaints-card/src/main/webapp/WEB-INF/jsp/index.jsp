<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ page  session="true"  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Подача жалобы</title>

    <link rel="stylesheet" type="text/css"  media="screen" href='<c:url value="../resources/css/complaints.css"/>'/>
    <link rel="stylesheet" type="text/css"  media="screen" href='<c:url value="../resources/js/jquery-ui-1.9.1/themes/base/jquery-ui.css"/>'/>

    <script type='text/javascript' src='<c:url value="../resources/js/jquery-ui-1.9.1/jquery-1.8.2.js"/>'></script>
    <script type='text/javascript' src='<c:url value="../resources/js/jquery-ui-1.9.1/ui/jquery.ui.core.js"/>'></script>
    <script type='text/javascript' src='<c:url value="../resources/js/jquery-ui-1.9.1/ui/jquery.ui.widget.js"/>'></script>
    <script type='text/javascript' src='<c:url value="../resources/js/jquery-ui-1.9.1/ui/jquery.ui.button.js"/>'></script>

    <script type="text/javascript">
        $(document).ready(function(){
            /* initial */
            $('#lastname').show();
            $('#firstname').show();
            $('#thirdname').show();
            $('#entitlement').hide();

            $('input[name=who]').click(function() {
                if($(this).val() == "company") {
                    $('#lastname').hide();
                    $('#firstname').hide();
                    $('#thirdname').hide();
                    $('#entitlement').show();
                } else if($(this).val() == "man") {
                    $('#lastname').show();
                    $('#firstname').show();
                    $('#thirdname').show();
                    $('#entitlement').hide();
                } else if($(this).val() == "rep_man") {
                    $('#lastname').show();
                    $('#firstname').show();
                    $('#thirdname').show();
                    $('#entitlement').show();
                } else if($(this).val() == "rep_company") {
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
<h2>Подача жалоб </h2>
<p>Поля отмеченные знаком <img src="img/attention.gif" width="16" height="16" alt="A!" />, обязательны для заполнения</p>
<form id="form1" name="form1" method="post" action="">
    <fieldset>
        <legend>&nbsp;<strong>Жалоба</strong>&nbsp;</legend>

        <p>Орган в который будет отправлена жалоба: <img src="img/attention.gif" width="16" height="16" alt="A!" /><br />

            <select name="department" size="1" id="department">
                <option id="01">01 Управление Росреестра по Республике Адыгея</option>
                <option id="02">02 Управление Росреестра по Республике Башкортостан</option>
                <option id="03">03 Управление Росреестра по Республике Бурятия</option>
                <option id="04">04 Управление Росреестра по Республике Алтай</option>
                <option id="06">06 Управление Росреестра по Республике Ингушетия</option>
            </select>

        </p>
        <p>Наименование  органа, предоставляющего государственную услугу, должностного лица органа, предоставляющего государственную услугу, либо федерального государственного служащего, решения и действия (бездействия) которых обжалуются <img src="img/attention.gif" width="16" height="16" alt="A!" /><br>
            <input name="dep_name" type="text" id="dep_name" size="128" />
        </p>
        <hr>
        <table width="616" border="0">
            <tr>
                <td width="190" align="right"><strong>Кем являетесь:</strong></td>
                <td width="156"><input name="who" type="radio" id="man" value="man" checked="checked" />
                    <label for="man">Физическое лицо</label></td>
                <td width="256"><input type="radio" name="who" id="rep_man" value="rep_man" />
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


        <table width="814" border="0">
            <tr id="lastname">
                <td width="195" align="right">Фамилия: <img src="img/attention.gif" width="16" height="16" alt="A!" /></td>
                <td width="609"><input type="text" name="lastname" id="lastname" /></td>
            </tr>
            <tr id="firstname">
                <td width="195" align="right">Имя: <img src="img/attention.gif" width="16" height="16" alt="A!" /></td>
                <td width="609"><input type="text" name="firstname" id="firstname" /></td>
            </tr>
            <tr id="thirdname">
                <td width="195" align="right">Отчество: <img src="img/attention.gif" width="16" height="16" alt="A!" /></td>
                <td width="609"><input type="text" name="thirdname" id="thirdname" /></td>
            </tr>
            <tr id="entitlement">
                <td width="195" align="right">Наименование: <img src="img/attention.gif" width="16" height="16" alt="A!" /></td>
                <td width="609"><input type="text" name="entitlement" id="entitlement" /></td>
            </tr>
            <tr>
                <td align="right">Местонахождение: <img src="img/attention.gif" width="16" height="16" alt="A!" /></td>
                <td><input name="post_index" type="text" id="post_index" value="Индекс" size="12" />
                    <input name="address" type="text" id="address" value="Почтовый адрес" size="64" /></td>
            </tr>
            <tr>
                <td align="right">Телефон: </td>
                <td><input type="text" name="phone" id="phone" /></td>
            </tr>
            <tr>
                <td align="right">Адрес Email: <img src="img/attention.gif" width="16" height="16" alt="A!" /></td>
                <td><input type="text" name="email" id="email" /></td>
            </tr>
        </table>
        <hr>
        <p><strong>Тематика обращения:</strong> <img src="img/attention.gif" width="16" height="16" alt="A!" /></p>
        <table width="813" border="0">
            <tr>
                <td width="405" align="left" valign="top"><p>
                    <input type="radio" name="radio" id="q1" value="q1" />
                    Вопросы, связанные с государственной регистрацией прав на недвижимое имущество и сделок с ним и государственным кадастром недвижимости <br />
                    <input type="radio" name="radio" id="q2" value="q2" />
                    Вопросы, связанные с предоставлением информации из ЕГРП и ГКН<br />
                    <input type="radio" name="radio" id="radio" value="radio" />
                    Вопросы срыва сроков предоставления сведений по ранее направленным запросам и функционированию Портала услуг Росреестра<br />
                    <input type="radio" name="radio2" id="radio2" value="radio2" />
                    Вопросы, связанные с деятельностью саморегулируемых организаций арбитражных управляющих    <br />
                    <input type="radio" name="radio3" id="radio3" value="radio3" />
                    Вопросы, связанные с кадастровой оценкой объектов недвижимости    <br />
                    <input type="radio" name="radio4" id="radio4" value="radio4" />
                    Вопросы, связанные с государственным земельным контролем, землеустройством и мониторингом земель<br />
                    <input type="radio" name="radio5" id="radio5" value="radio5" />
                    Вопросы, связанные с техническим учетом и инвентаризацией объектов капитального строительства    </p></td>
                <td width="398" align="left" valign="top"><p>
                    <input type="radio" name="radio6" id="radio6" value="radio6" />
                    Вопросы, связанные с геодезической, картографической и навигационной деятельностью<br />
                    <input type="radio" name="radio7" id="radio7" value="radio7" />
                    Жалобы на организацию работы (отказ в приеме и выдаче документов, время ожидания в очереди превышает установленное административным регламентом, отсутствие предварительной записи (плохая организация), некорректное обслуживание заявителя на приеме,  требование внесения платы, не предусмотренной нормативными правовыми актами Российской Федерации и др.)    <br />
                    <input type="radio" name="radio8" id="radio8" value="radio8" />
                    Жалобы на работу руководителей (специалистов) территориальных органов Росреестра    <br />
                    <input type="radio" name="radio9" id="radio9" value="radio9" />
                    Предложения по совершенствованию деятельности Росреестра и его территориальных органов    <br />
                    <input type="radio" name="radio10" id="radio10" value="radio10" />
                    Другие вопросы, относящиеся к компетенции Росреестра    </p></td>
            </tr>
        </table>
        <p><strong>Текст обращения:</strong> <img src="img/attention.gif" width="16" height="16" alt="A!" /><br />
            <textarea name="text" id="text" cols="120" rows="10"></textarea>
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
                <input type="submit" name="addfile" id="addfile" value="Добавить"  class="button_add"  />
            </p>
        </fieldset>
        </p>
    </fieldset>
    <input type="submit" value="Отправить" />
</form>

<p>&nbsp;</p>
</body>
</html>
