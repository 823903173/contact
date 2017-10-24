<%--
  Created by IntelliJ IDEA.
  User: TR
  Date: 2017/10/12
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%-- <%@ include file="/head.jsp"%> --%>
<!DOCTYPE html>
<html>



<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>sim入库</title>
    <script src="${pageContext.request.contextPath }/js/jquery.min63b9.js" type="text/javascript"></script>
    <link rel="shortcut icon" href="favicon.ico"> <link href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <!-- validfrom -->
    <script src="${pageContext.request.contextPath }/js/Validform_v5.3.2.zh_CN.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath }/css/validfromStyle.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath }/js/ycDate.js" type="text/javascript"></script>
    <!-- auto -->
    <script src="${pageContext.request.contextPath }/js/control/jqueryui/jquery-ui.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath }/js/control/jqueryui/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">尊敬的用户
<c:forEach items="${contactAdmin}" var="contactAdmin">
    <tr>
        <td>${contactAdmin.contactNumber}</td>
    </tr>
</c:forEach>您好
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>批量导入用户信息 </h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form id="info" class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/ContactUserlogin/insertSimExcel.do">
                        <input name="contactAdminOrgId" value="${contactAdmin.organizationId}" type="hidden"  />
                        <input name="contactAdminNum" value="${contactAdmin.managementNumber}" type="hidden"  />
                        <input name="contactNumber" value="${contactAdmin.contactNumber}" type="hidden"  />
                        <!-- sim卡ccid -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">选择Excel文件</label>
                            <div class="col-sm-5">
                                <input type="file" name="file">
                            </div>
                            <div class="col-sm-2">
                                <div class="Validform_checktip"></div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit" >导入</button>
                                <button class="btn btn-white" onclick="window.location.reload()">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>批量删除用户信息 </h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form id="deleteinfo" class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/ContactUserlogin/deleteSiminfo.do">
                        <input name="contactNumber" value="${contactAdmin.contactNumber}" type="hidden"  />
                        <!-- sim卡ccid -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">选择Excel文件</label>
                            <div class="col-sm-5">
                                <input type="file" name="file">
                            </div>
                            <div class="col-sm-2">
                                <div class="Validform_checktip"></div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit" >删除</button>
                                <button class="btn btn-white" onclick="window.location.reload()">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>批量导入管理员及组织信息 </h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form id="admiminfo" class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/ContactAdminlogin/insertAdminExcel.do">
                        <input name="contactAdminOrgId" value="${contactAdmin.organizationId}" type="hidden"  />
                        <input name="contactAdminNum" value="${contactAdmin.managementNumber}" type="hidden"  />
                        <input name="contactNumber" value="${contactAdmin.contactNumber}" type="hidden"  />
                    <!-- sim卡ccid -->
                    <div class="form-group">
                        <label class="col-sm-2 control-label">选择Excel文件</label>
                        <div class="col-sm-5">
                            <input type="file" name="file">
                        </div>
                        <div class="col-sm-2">
                            <div class="Validform_checktip"></div>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>

                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit" >增加</button>
                            <button class="btn btn-white" onclick="window.location.reload()">重置</button>
                        </div>
                    </div>
                </form>
                    <form id="admimorginfo" class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/ContactOrglogin/insertOrgExcel.do">
                        <input name="contactAdminOrgId" value="${contactAdmin.organizationId}" type="hidden"  />
                        <input name="contactAdminNum" value="${contactAdmin.managementNumber}" type="hidden"  />
                        <input name="contactNumber" value="${contactAdmin.contactNumber}" type="hidden"  />
                        <!-- sim卡ccid -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">选择Excel文件</label>
                            <div class="col-sm-5">
                                <input type="file" name="file">
                            </div>
                            <div class="col-sm-2">
                                <div class="Validform_checktip"></div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit" >增加</button>
                                <button class="btn btn-white" onclick="window.location.reload()">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>批量删除管理员及组织信息 </h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form id="deleteadmiminfo" class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/ContactAdminlogin/deleteSiminfo.do">
                        <input name="contactAdminOrgId" value="${contactAdmin.organizationId}" type="hidden"  />
                        <input name="contactAdminNum" value="${contactAdmin.managementNumber}" type="hidden"  />
                        <input name="contactNumber" value="${contactAdmin.contactNumber}" type="hidden"  />
                        <!-- sim卡ccid -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">选择Excel文件</label>
                            <div class="col-sm-5">
                                <input type="file" name="file">
                            </div>
                            <div class="col-sm-2">
                                <div class="Validform_checktip"></div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit" >删除</button>
                                <button class="btn btn-white" onclick="window.location.reload()">重置</button>
                            </div>
                        </div>
                    </form>
                    <form id="deleteOrginfo" class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/ContactOrglogin/deleteOrginfo.do">
                        <input name="contactAdminOrgId" value="${contactAdmin.organizationId}" type="hidden"  />
                        <input name="contactAdminNum" value="${contactAdmin.managementNumber}" type="hidden"  />
                        <input name="contactNumber" value="${contactAdmin.contactNumber}" type="hidden"  />
                        <!-- sim卡ccid -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">选择Excel文件</label>
                            <div class="col-sm-5">
                                <input type="file" name="file">
                            </div>
                            <div class="col-sm-2">
                                <div class="Validform_checktip"></div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit" >删除</button>
                                <button class="btn btn-white" onclick="window.location.reload()">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath }/js/bootstrap.min14ed.js?v=3.3.6"></script>
<script src="${pageContext.request.contextPath }/js/contentt.js"></script>
<script src="${pageContext.request.contextPath }/js/plugins/iCheck/icheck.min.js"></script>

</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/form_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Mar 2016 12:29:21 GMT -->
</html>
