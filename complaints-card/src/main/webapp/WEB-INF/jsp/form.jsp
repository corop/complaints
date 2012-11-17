<!-- %@ include file="/WEB-INF/jsp/includes.jsp" % -->

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@page contentType="text/html;charset=UTF-8" %>
    <%@page pageEncoding="UTF-8" %>

    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <meta charset="utf-8">

    <title>Подача жалобы</title>


    <link rel="stylesheet" type="text/css" media="screen" href='<spring:url value="resources/css/complaints.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<spring:url value="resources/css/form.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<spring:url value="resources/js/jquery-ui-1.9.1/themes/base/jquery-ui.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<spring:url value="resources/js/jquery-file-upload/css/jquery.fileupload-ui.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<spring:url value="resources/js/jquery-file-upload/css/jquery.fileupload-ui-noscript.css"/>'/>


    <script type='text/javascript' src='<spring:url value="resources/js/jquery-ui-1.9.1/jquery-1.8.2.js"/>'></script>
    <script type='text/javascript' src='<spring:url value="resources/js/util.js"/>'></script>
    <script type='text/javascript' src='<spring:url value="resources/js/jquery-ui-1.9.1/ui/jquery.ui.core.js"/>'></script>
    <script type='text/javascript' src='<spring:url value="resources/js/jquery-ui-1.9.1/ui/jquery.ui.widget.js"/>'></script>
    <script type='text/javascript' src='<spring:url value="resources/js/jquery-ui-1.9.1/ui/jquery.ui.button.js"/>'></script>
    <script type='text/javascript' src='<spring:url value="resources/js/jquery-file-upload/js/jquery.iframe-transport.js"/>'></script>
    <script type='text/javascript' src='<spring:url value="resources/js/jquery-file-upload/js/jquery-fileupload.js"/>'></script>

    <!-- Shim to make HTML5 elements usable in older Internet Explorer versions -->
    <!--[if lt IE 9]><!-- script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->


    <script type='text/javascript'>

        $(document).ready(function () {

            $("#post_index")
                    .val("Индекс")
                    .css("color", "#ccc")
                    .focus(function(){
                        $(this).css("color", "black");
                        if ($(this).val() == "Индекс") {
                            $(this).val("");
                        }
                    }).blur(function(){
                        $(this).css("color", "#ccc");
                        if ($(this).val() == "") {
                            $(this).val("Индекс");
                        }
                    });

            $("#post_address")
                    .val("Почтовый адрес")
                    .css("color", "#ccc")
                    .focus(function(){
                        $(this).css("color", "black");
                        if ($(this).val() == "Почтовый адрес") {
                            $(this).val("");
                        }
                    }).blur(function(){
                        $(this).css("color", "#ccc");
                        if ($(this).val() == "") {
                            $(this).val("Почтовый адрес");
                        }
                    });


            $('input:button').button();
            $('#submit').button();

            $('#cmplform').submit(function(event) {

                event.preventDefault();

                $.postJSON('sendform', {
                            department: $('#department').val(),
                            dep_name:  $('#dep_name').val(),
                            who: $('input[name=who]:checked').val(),
                            lastname: $('#lastname').val(),
                            firstname: $('#firstname').val(),
                            thirdname: $('#thirdname').val(),
                            entitlement: $('#entitlement').val(),
                            post_index: $('#post_index').val(),
                            post_address: $('#post_address').val(),
                            phone: $('#phone').val(),
                            email: $('#email').val(),
                            category: $('#categories').val(),
                            appeal: $('#appeal').val()
                        },
                        function(result) {
                            if (result.success == true) {
                                dialog('Success', 'Email has been sent!');
                            } else {
                                dialog('Failure', 'Email has not been sent!');
                            }
                        });
            });


            $.get("ref/departments",
                    function (responce) {
                        var select = $('#department').empty();
                        var options = '';
                        for (var i = 0; i < responce.data.length; i++) {
                            options += '<option value="' + responce.data[i].id + '">' + responce.data[i].code + "&nbsp;" + responce.data[i].name + '</option>';
                            //console.log(responce.data[i].name);
                        }
                        $("select#department").html(options);
                    }, "json");

            $.get("ref/categories",
                    function (responce) {
                        var select = $('#categories').empty();
                        var options = '';
                        for (var i = 0; i < responce.data.length; i++) {
                            options += '<option value="' + responce.data[i].id + '">' + responce.data[i].name + '</option>';
                            //console.log(responce.data[i].name);
                        }
                        $("select#categories").html(options);
                    }, "json");

            /* file uploader */

            $('#upload').fileupload({
                dataType:'json',
                done:function (e, data) {
                    $.each(data.result, function (index, file) {
                        $('body').data('filelist').push(file);
                        $('#filename').append(formatFileDisplay(file));
                        $('#attach').empty().append('Загрузить еще файл');
                    });
                    $('#progress .bar').css(
                            'width',
                            0 + '%'
                    );
                },
                progressall: function (e, data) {
                    var progress = parseInt(data.loaded / data.total * 100, 10);
                    $('#progress .bar').css(
                            'width',
                            progress + '%'
                    );
                },
                error: function (ev, data) {
                    console.log(ev);
                    dialog("Ошибка загрузки файла", data.filename);
                }
        });


            /* initial */
            $('#tr_lastname').show();
            $('#tr_firstname').show();
            $('#tr_thirdname').show();
            $('#tr_entitlement').hide();

            $('input[name=who]').click(function () {
                if ($(this).val() == "2") {               /* Юридическое лицо */
                    $('#tr_lastname').hide();
                    $('#tr_firstname').hide();
                    $('#tr_thirdname').hide();
                    $('#tr_entitlement').show();
                } else if ($(this).val() == "1") {    /* Физическое лицо */
                    $('#tr_lastname').show();
                    $('#tr_firstname').show();
                    $('#tr_thirdname').show();
                    $('#tr_entitlement').hide();
                } else if ($(this).val() == "3") {    /* Представитель физического лица */
                    $('#tr_lastname').show();
                    $('#tr_firstname').show();
                    $('#tr_thirdname').show();
                    $('#tr_entitlement').show();
                } else if ($(this).val() == "4") {    /* Представитель юридического лица */
                    $('#tr_lastname').show();
                    $('#tr_firstname').show();
                    $('#tr_thirdname').show();
                    $('#tr_entitlement').show();
                }
            });
            // Technique borrowed from http://stackoverflow.com/questions/1944267/how-to-change-the-button-text-of-input-type-file
            // http://stackoverflow.com/questions/210643/in-javascript-can-i-make-a-click-event-fire-programmatically-for-a-file-input
            $("#attach").click(function () {
                $("#upload").trigger('click');
            });

            $('body').data('filelist', new Array());

        });


        function formatFileDisplay(file) {
            var size = '<span style="font-style:italic">' + (file.size / 1000).toFixed(2) + 'K</span>';
            return file.name + ' (' + size + ')<br/>';
        }

        function getFilelist() {
            var files = $('body').data('filelist');
            var filenames = '';
            for (var i = 0; i < files.length; i < i++) {
                var suffix = (i == files.length - 1) ? '' : ',';
                filenames += files[i].name + suffix;
            }
            return filenames;
        }

        function dialog(title, text) {
            $('#msgbox').text(text);
            $('#msgbox').dialog(
                    {
                        title:title,
                        modal:true,
                        buttons:{"Ok":function () {
                            $(this).dialog("close");
                        }
                        }
                    });
        }
    </script>
</head>

<body bgcolor="#F5F6F6">

<table width="640" align="center">
    <tr>
        <td width="630">
            <div class="formCaption">
                Подача жалоб
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <p>Поля отмеченные знаком <img src="resources/img/attention.gif" width="16" height="16" alt="A!"/>,
                обязательны для заполнения</p>
        </td>
    </tr>
    <tr>
        <td>
            <form id="cmplform">
                <fieldset>
                    <legend>&nbsp;<strong>Жалоба, sid:&nbsp;<%=request.getSession().getId()%></strong>&nbsp;</legend>

                    <p>Орган в который будет отправлена жалоба: <img src="resources/img/attention.gif" width="16"
                                                                     height="16" alt="A!"/><br/>
                        <!-- Генерируется из справочной таблицы CMPL_DEPARTMENT -->
                        <select name="department" size="1" id="department">
                            <option id="-1" value="-1">Данные не загружены</option>
                        </select>

                    </p>
                    <p>Наименование органа, предоставляющего государственную услугу, должностного лица органа,
                        предоставляющего государственную услугу, либо федерального государственного служащего, решения и
                        действия (бездействия) которых обжалуются <img src="resources/img/attention.gif" width="16"
                                                                       height="16" alt="A!"/><br>
                        <input name="dep_name" type="text" id="dep_name" size="96" required="required"/>
                    </p>
                    <hr>
                    <table width="630" border="0">
                        <tr>
                            <td width="135" align="right"><strong>Кем являетесь:</strong></td>
                            <td width="218"><input name="who" type="radio" id="man" value="1" checked="checked"/>
                                <label for="man">Физическое лицо</label></td>
                            <td width="263"><input type="radio" name="who" id="rep_man" value="3"/>
                                <label for="rep_man">Представитель физического лица</label></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td><input type="radio" name="who" id="company" value="2"/>
                                <label for="company">Юридическое лицо</label></td>
                            <td><input type="radio" name="who" id="rep_company" value="4"/>
                                <label for="rep_company">Представитель юридического лица</label></td>

                        </tr>
                    </table>
                    <hr>


                    <table width="697" border="0">
                        <tr id="tr_lastname">
                            <td width="135" align="right" valign="middle">Фамилия: <img
                                    src="resources/img/attention.gif" width="16" height="16" alt="A!"/></td>
                            <td width="528" align="left" valign="middle" nowrap="nowrap"><input type="text"
                                                                                                name="lastname"
                                                                                                id="lastname"
                                                                                                required="required"/>
                            </td>
                        </tr>
                        <tr id="tr_firstname">
                            <td width="135" align="right" valign="middle">Имя: <img src="resources/img/attention.gif"
                                                                                    width="16" height="16" alt="A!"/>
                            </td>
                            <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="firstname"
                                                                                    id="firstname" required="required"/>
                            </td>
                        </tr>
                        <tr id="tr_thirdname">
                            <td width="135" align="right" valign="middle">Отчество: <img
                                    src="resources/img/attention.gif" width="16" height="16" alt="A!"/></td>
                            <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="thirdname"
                                                                                    id="thirdname" required="required"/>
                            </td>
                        </tr>
                        <tr id="tr_entitlement">
                            <td width="135" align="right" valign="middle">Наименование: <img
                                    src="resources/img/attention.gif" width="16" height="16" alt="A!"/></td>
                            <td align="left" valign="middle" nowrap="nowrap"><input name="entitlement" type="text"
                                                                                    id="entitlement" size="80"
                                                                                    required="required"/></td>
                        </tr>
                        <tr>
                            <td align="right" valign="middle">Местонахождение: <img src="resources/img/attention.gif"
                                                                                    width="16" height="16" alt="A!"/>
                            </td>
                            <td align="left" valign="middle" nowrap="nowrap"><input name="post_index" type="text"
                                                                                    id="post_index" value="Индекс"
                                                                                    size="8"/>
                                <input name="post_address" type="text" id="post_address" value="Почтовый адрес"
                                       size="72" required="required"/></td>
                        </tr>
                        <tr>
                            <td align="right" valign="middle">Телефон:</td>
                            <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="phone"
                                                                                    id="phone"/></td>
                        </tr>
                        <tr>
                            <td align="right" valign="middle">Адрес Email: <img src="resources/img/attention.gif"
                                                                                width="16" height="16" alt="A!"/></td>
                            <td align="left" valign="middle" nowrap="nowrap"><input type="email" name="email" id="email"
                                                                                    required="required"  size="80"/></td>
                        </tr>
                    </table>
                    <hr>
                    <p><strong>Тематика обращения:</strong> <img src="resources/img/attention.gif" width="16"
                                                                 height="16" alt="A!"/></p>
                            <!-- Генерируется из справочной таблицы CMPL_CATEGORY -->
                            <select name="categories" size="1" id="categories" style="word-wrap:break-word;width:700px;">
                                <option id="-1" value="-1">Данные не загружены</option>
                            </select>
                    <p><strong>Текст обращения:</strong> <img src="resources/img/attention.gif" width="16" height="16"
                                                              alt="A!"/><br/>
                        <textarea name="appeal" id="appeal" cols="96" rows="10" required="required"></textarea>
                        <br/>
                    <fieldset>
                        <legend>&nbsp;<strong>Прилагаемые документы</strong>&nbsp;</legend>
                        <p>Если вы являетесь представителем физического или юридического лица, для отправки обращения
                            вам необходимо приложить один из этих документов:</p>

                        <p> доверенность, оформленную в соответствии с законодательством Российской Федерации,
                            заверенную печатью заявителя и подписанную руководителем заявителя или уполномоченным этим
                            руководителем лицом;<br>
                            копию решения о назначении или об избрании либо приказа о назначении физического лица на
                            должность, в соответствии с которым </p>

                        <p>такое физическое лицо обладает правом действовать от имени заявителя без доверенности.<br>
                            В этом случае обращение необходимо подписать цифровой подписью с помощью кнопки «Подписать и
                            отправить».
                        </p>


                        <a href='#attach' id='attach'>Загрузить файл</a><br/>
                        <span id='filename'></span><br/>

                        <div id="progress">
                            <div class="bar" style="width: 0%;"></div>
                        </div>

                        <input id="upload" type="file" name="file" data-url="fileupload" multiple
                               style="opacity: 0; filter:alpha(opacity: 0);"><br/>

                    </fieldset>
                    </p>
                </fieldset>
                <input id="submit" name="submit" type="submit" value="Отправить"/>
            </form>
            <div id='msgbox' title='' style='display:none'></div>
        </td>
    </tr>
</table>
>
</body>
</html>
