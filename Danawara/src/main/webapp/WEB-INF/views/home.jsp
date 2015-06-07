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
            <select class="form-control" id="computerCase" name="computerCase">
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
            <input type="text" id="memory" class="form-control" placeholder="DDR4 16GB" disabled>
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
    
   <!-- modal -->
   <div class="modal fade" id="resultModal" tabindex="-1" role="dialog" aria-labelledby="resultModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="resultModalLabel">Result</h4>
	      </div>
	      <div class="modal-body">
	      	<input type="text" class="form-control" id="resultMessage">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Send message</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- modal end -->
    
    <script>
      $(document).ready(function() {
		  var ajaxData;
    	  $(".check").click(function() {
    		 var formData = $(".danawaraForm").serialize();

    		 var requestData = {
    			'cpu': $("#cpu").val(),
    			'mainboard': $("#mainboard").val(),
    			'vga': $("#vga").val(),
    			'computerCase': $("#computerCase").val(),
    		 };

    		 $.ajax({
    		   type: "POST",
    		   url: "http://localhost:8080/danawara/check",
    		   contentType: "application/json",
    		   data: JSON.stringify(requestData),
    		   success: function(data) {
    			   ajaxData = data;
    			   $("#resultModal").modal('show');
    		   },
    		   error: function(error) {
    			   console.log(error);
    		   }
    		});
    	  });
    	  
    	  $("#resultModal").on('show.bs.modal', function(e) {
    		  $(this).find('.modal-body input').val(ajaxData.msg1 +" "+ajaxData.msg2 +" " + ajaxData.msg3);
    	  });
      });
    </script>
  </body>
</html>
