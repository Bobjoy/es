<%@tag pageEncoding="UTF-8" description="构建子菜单" %>
<%@ attribute name="menu" type="com.sishuok.es.sys.resource.entity.tmp.Menu" required="true" description="当前菜单" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="es" tagdir="/WEB-INF/tags" %>
<li class="nav-item">
<c:choose>
    <c:when test="${!menu.hasChildren}">
      <a href="<%=menuUrl(request, menu.getUrl())%>" class="nav-link ">
        <span class="title">${menu.name}</span>
      </a>
    </c:when>
    <c:otherwise>
      <a href="javascript:void(0);" class="nav-link nav-toggle">
        <span class="title">${menu.name}</span>
        <span class="arrow"></span>
      </a>
      <ul class="sub-menu">
        <c:forEach items="${menu.children}" var="submenu">
          <es:submenu menu="${submenu}"/>
        </c:forEach>
      </ul>
    </c:otherwise>
</c:choose>
</li>
<%!
    private static String menuUrl(HttpServletRequest request, String url) {
        if(url.startsWith("http")) {
            return url;
        }
        String ctx = request.getContextPath();

        if(url.startsWith(ctx) || url.startsWith("/" + ctx  )) {
            return url;
        }

        if(!url.startsWith("/")) {
            url = url + "/";
        }
        return ctx + url;

    }
%>

