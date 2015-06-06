<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %> 


<!doctype html>
<html>
  <head>
    <title>조립 컴퓨터</title>
    <meta charset="utf-8" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  </head>
  <style>
    .container {
      width: 60%;
    }
  </style>
  <body>
    <div class="container">
      <div class="page-header">
        <h1> DANAWARA </h1>
      </div>
      <form class="form-horizontal danawaraForm">
        <div class="form-group">
          <label for="cpu" class="col-sm-3 control-label">CPU : </label>
          <div class="col-sm-6">
            <select class="form-control" id="cpu" name="cpu">
              <c:if test="${!empty listCpus}">
    		    <c:forEach items="${listCpus}" var="Cpu">
    		      <option value=${Cpu.id}>${Cpu.name}</option>
    			</c:forEach>
			  </c:if>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label for="mainboard" class="col-sm-3 control-label">MAINBOARD : </label>
          <div class="col-sm-6">
            <select class="form-control" id="mainboard" name="mainboard">
              <c:if test="${!empty listMainboards}">
    		    <c:forEach items="${listMainboards}" var="Mainboard">
    		      <option value=${Mainboard.id}>${Mainboard.name}</option>
    			</c:forEach>
			  </c:if>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label for="vga" class="col-sm-3 control-label">VGA : </label>
          <div class="col-sm-6">
            <select class="form-control" id="vga" name="vga">
              <c:if test="${!empty listVgas}">
    		    <c:forEach items="${listVgas}" var="Vga">
    		      <option value=${Vga.id}>${Vga.name}</option>
    			</c:forEach>
			  </c:if>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label for="case" class="col-sm-3 control-label">CASE : </label>
          <div class="col-sm-6">
            <select class="form-control" id="case" name="computerCase">
	          <c:if test="${!empty listPc_cases}">
	            <c:forEach items="${listPc_cases}" var="Pc_case">
	              <option value=${Pc_case.id}>${Pc_case.name}</option>
	    		</c:forEach>
			  </c:if>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label for="hdd" class="col-sm-3 control-label">HDD : </label>
          <div class="col-sm-6">
            <input type="text" id="hdd" class="form-control" placeholder="512GB SSD" disabled>
          </div>
        </div>
        <div class="form-group">
          <label for="memory" class="col-sm-3 control-label">MEMORY : </label>
          <div class="col-sm-6">
            <input type="text" id="memory" class="form-control" placeholder="DDR3 `6GB" disabled>
          </div>
        </div>
        <div class="form-group">
          <label for="power" class="col-sm-3 control-label">POWER : </label>
          <div class="col-sm-6">
            <input type="text" id="power" class="form-control" placeholder="600W POWER" disabled>
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-3 col-sm-10">
            <button type="button" class="btn btn-primary check">send</button>
          </div>
        </div>
      </form>
    </div>
    <script>
      $(document).ready(function() {

    	  $(".check").click(function() {
    		 var formData = $(".danawaraForm").serialize();
    		 $.ajax({
    			 url:"http://localhost:8080/danawara/check",
    			 type: "POST",
    			 contentType: "application/json",
    			 mimeType: "application/json",
    			 data: JSON.stringify(formData),
    			 success: function(data) {
    				 console.log("good");
    			 },
    			 error: function(error) {
    				 
    			 }
    		 });
    	  });
      });
    </script>
  </body>
</html>
