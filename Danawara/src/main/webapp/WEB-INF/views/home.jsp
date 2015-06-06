<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %> 
<html>
<head>
	<title>Home</title>
</head>
<body>

<h3>Cpu List</h3>
<c:if test="${!empty listCpus}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Socket</th>
    </tr>
    <c:forEach items="${listCpus}" var="Cpu">
        <tr>
            <td>${Cpu.id}</td>
            <td>${Cpu.name}</td>
            <td>${Cpu.socket}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<h3>Mainboard List</h3>
<c:if test="${!empty listMainboards}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Socket</th>
        <th width="120">Size</th>
    </tr>
    <c:forEach items="${listMainboards}" var="Mainboard">
        <tr>
            <td>${Mainboard.id}</td>
            <td>${Mainboard.name}</td>
            <td>${Mainboard.socket}</td>
            <td>${Mainboard.size}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<h3>Vga List</h3>
<c:if test="${!empty listVgas}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Size</th>
    </tr>
    <c:forEach items="${listVgas}" var="Vga">
        <tr>
            <td>${Vga.id}</td>
            <td>${Vga.name}</td>
            <td>${Vga.size}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<h3>Pc_case List</h3>
<c:if test="${!empty listPc_cases}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Size</th>
    </tr>
    <c:forEach items="${listPc_cases}" var="Pc_case">
        <tr>
            <td>${Pc_case.id}</td>
            <td>${Pc_case.name}</td>
            <td>${Pc_case.size}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>
