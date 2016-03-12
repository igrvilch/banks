<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Bootstrap 101 Template</title>

  <!-- Bootstrap -->
  <link href="<c:url value="/resourses/css/bootstrap.min.css" />" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>

 <div class="container">
   <div class="page-header">
     <h1>COURSES OF MOGILEVS BANKS</h1>
   </div>
   <div class="row">
     <div class="col-md-8">
       <div class="table-responsive">
         <table class="table">
           <thead>
            <tr>
              <th>Банк</th>
              <th>USD покупка</th>
              <th>USD продажа</th>
              <th>EUR покупка</th>
              <th>EUR продажа</th>
              <th>RUB покупка</th>
              <th>RUB продажа</th>
              <th>EUR-USD</th>
              <th>USD-RUB</th>
              <th>EUR-RUB</th>
            </tr>
           </thead>
           <tbody>
            <c:forEach items="${banks}" var="bank">
            <tr>
              <td>${bank.name}</td>
              <td>${bank.usdBuyRate}</td>
              <td>${bank.usdSellRate}</td>
              <td>${bank.eurBuyRate}</td>
              <td>${bank.eurSellRate}</td>
              <td>${bank.rubBuyRate}</td>
              <td>${bank.rubSellRate}</td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            </c:forEach>
           </tbody>
         </table>
       </div>
     </div>
     <div class="col-md-4">.col-md-4</div>
   </div>
  </div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/resourses/js/bootstrap.min.js" />"></script>
</body>
</html>