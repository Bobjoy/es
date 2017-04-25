<%--@elvariable id="ctx" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]><html lang="en" class="ie8 no-js"><![endif]-->
<!--[if IE 9]><html lang="en" class="ie9 no-js"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
  <meta charset="utf-8" />
  <title>登录</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1" name="viewport" />
  <!-- BEGIN GLOBAL MANDATORY STYLES -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
  <link href="${ctx}/static/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
  <link href="${ctx}/static/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="${ctx}/static/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
  <!-- END GLOBAL MANDATORY STYLES -->
  <!-- BEGIN PAGE LEVEL PLUGINS -->
  <link href="${ctx}/static/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
  <link href="${ctx}/static/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
  <!-- END PAGE LEVEL PLUGINS -->
  <!-- BEGIN THEME GLOBAL STYLES -->
  <link href="${ctx}/static/common/css/components-md.css" rel="stylesheet" id="style_components" type="text/css" />
  <link href="${ctx}/static/common/css/plugins-md.css" rel="stylesheet" type="text/css" />
  <!-- END THEME GLOBAL STYLES -->
  <!-- BEGIN PAGE LEVEL STYLES -->
  <link href="${ctx}/static/pages/css/login.css" rel="stylesheet" type="text/css" />
  <!-- END PAGE LEVEL STYLES -->
  <!-- BEGIN THEME LAYOUT STYLES -->
  <!-- END THEME LAYOUT STYLES -->
  <link rel="shortcut icon" href="${ctx}/static/common/img/favicon.ico" />
</head>
<!-- END HEAD -->

<body class=" login">
<!-- BEGIN LOGO -->
<div class="logo">
  <a href="">
    <img src="${ctx}/static/common/img/logo-big.png" alt="" />
  </a>
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content">
  <!-- BEGIN LOGIN FORM -->
  <form class="login-form" method="post">
    <h3 class="form-title font-green">Sign In</h3>
    <div class="alert alert-danger display-hide">
      <button class="close" data-close="alert"></button>
      <span> Enter any username and password. </span>
    </div>
    <div class="form-group">
      <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
      <label class="control-label visible-ie8 visible-ie9">Username</label>
      <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="Username" name="username"/>
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">Password</label>
      <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="Password" name="password" />
    </div>
    <div class="form-actions">
      <button type="submit" class="btn green uppercase">Login</button>
      <label class="rememberme check mt-checkbox mt-checkbox-outline">
        <input type="checkbox" name="remember" value="1" />Remember
        <span></span>
      </label>
      <a href="javascript:void(0);" id="forget-password" class="forget-password">Forgot Password?</a>
    </div>
    <div class="login-options">
      <h4>Or login with</h4>
      <ul class="social-icons">
        <li>
          <a class="social-icon-color facebook" data-original-title="facebook" href="javascript:void(0);"></a>
        </li>
        <li>
          <a class="social-icon-color twitter" data-original-title="Twitter" href="javascript:void(0);"></a>
        </li>
        <li>
          <a class="social-icon-color googleplus" data-original-title="Goole Plus" href="javascript:void(0);"></a>
        </li>
        <li>
          <a class="social-icon-color linkedin" data-original-title="Linkedin" href="javascript:void(0);"></a>
        </li>
      </ul>
    </div>
    <div class="create-account">
      <p>
        <a href="javascript:void(0);" id="register-btn" class="uppercase">Create an account</a>
      </p>
    </div>
  </form>
  <!-- END LOGIN FORM -->
  <!-- BEGIN FORGOT PASSWORD FORM -->
  <form class="forget-form" action="index.html" method="post">
    <h3 class="font-green">Forget Password ?</h3>
    <p> Enter your e-mail address below to reset your password. </p>
    <div class="form-group">
      <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Email" name="email" />
    </div>
    <div class="form-actions">
      <button type="button" id="back-btn" class="btn green btn-outline">Back</button>
      <button type="submit" class="btn btn-success uppercase pull-right">Submit</button>
    </div>
  </form>
  <!-- END FORGOT PASSWORD FORM -->
  <!-- BEGIN REGISTRATION FORM -->
  <form class="register-form" action="index.html" method="post">
    <h3 class="font-green">Sign Up</h3>
    <p class="hint"> Enter your personal details below: </p>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">Full Name</label>
      <input class="form-control placeholder-no-fix" type="text" placeholder="Full Name" name="fullname" />
    </div>
    <div class="form-group">
      <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
      <label class="control-label visible-ie8 visible-ie9">Email</label>
      <input class="form-control placeholder-no-fix" type="text" placeholder="Email" name="email" />
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">Address</label>
      <input class="form-control placeholder-no-fix" type="text" placeholder="Address" name="address" />
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">City/Town</label>
      <input class="form-control placeholder-no-fix" type="text" placeholder="City/Town" name="city" />
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">Country</label>
      <select name="country" class="form-control" title="">
        <option value="">Country</option>
        <option value="CN">China</option>
      </select>
    </div>
    <p class="hint"> Enter your account details below: </p>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">Username</label>
      <input class="form-control placeholder-no-fix" type="text" autocomplete="off"
             placeholder="Username" name="username" />
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">Password</label>
      <input class="form-control placeholder-no-fix" type="password" autocomplete="off"
             id="register_password" placeholder="Password" name="password" />
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">Re-type Your Password</label>
      <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Re-type Your Password" name="rpassword"
      /> </div>
    <div class="form-group margin-top-20 margin-bottom-20">
      <label class="mt-checkbox mt-checkbox-outline">
        <input type="checkbox" name="tnc" /> I agree to the
        <a href="javascript:void(0);">Terms of Service </a> &
        <a href="javascript:void(0);">Privacy Policy </a>
        <span></span>
      </label>
      <div id="register_tnc_error"> </div>
    </div>
    <div class="form-actions">
      <button type="button" id="register-back-btn" class="btn green btn-outline">Back</button>
      <button type="submit" id="register-submit-btn" class="btn btn-success uppercase pull-right">Submit</button>
    </div>
  </form>
  <!-- END REGISTRATION FORM -->
</div>
<div class="copyright"> 2014 © Metronic. Admin Dashboard Template. </div>
<!--[if lt IE 9]>
<script src="${ctx}/static/plugins/respond.min.js"></script>
<script src="${ctx}/static/plugins/excanvas.min.js"></script>
<script src="${ctx}/static/plugins/ie8.fix.min.js"></script>
<![endif]-->
<!-- BEGIN CORE PLUGINS -->
<script src="${ctx}/static/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/static/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/static/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="${ctx}/static/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ctx}/static/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ctx}/static/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${ctx}/static/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
<script src="${ctx}/static/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="${ctx}/static/common/js/app.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${ctx}/static/pages/js/login.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<!-- END THEME LAYOUT SCRIPTS -->
</body>


</html>
