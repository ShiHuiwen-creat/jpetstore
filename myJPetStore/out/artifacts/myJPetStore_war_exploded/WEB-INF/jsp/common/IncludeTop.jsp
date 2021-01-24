<%--
  Created by IntelliJ IDEA.
  User: ZZY
  Date: 2019-10-13
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    <title>MyPetStore</title>
    <title>Petstore</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- mobile specific metas
   ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">

    <!-- CSS
   ================================================== -->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/main.css">
    <!-- favicons
	================================================== -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <script src="js/autoComplete.js"></script>


</head>

<body id="top">
<div class="header">
<header id="header" class="row">

    <div class="header-logo">
        <a href="main">PETSTORE</a>
    </div>

    <nav id="header-nav-wrap">



            <form action="search" method="post" name="autoCompleteForm" class="search-container">
                <input type="text" style="float: right" name="keyword" id="keyword" list="products" size="14" onkeyup="completeItemList();"/>
                <datalist id="products"></datalist>

                <input type="submit" class="search button button-primary cta "  name="searchProducts" value="Search"  style="float:left"/>
            </form>


        <ul class="header-main-nav">
            <li class="current"><a class="smoothscroll"  href="main" title="home">Home</a></li>

            <c:if test="${sessionScope.account==null}">
            <li><a class="smoothscroll"  href="viewAccount?msg=SignOn" title="about">My Cart</a></li>
            </c:if>

            <c:if test="${sessionScope.account!=null}">
                <li><a class="smoothscroll"  href="viewCart" title="about">My Cart</a></li>
            </c:if>

            <c:if test="${sessionScope.account == null}">
                <li>
                    <a href="viewAccount?msg=SignOn">SignOn</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.account!=null}">
                <li><a class="smoothscroll" href="signOut">SignOut</a></li>
            </c:if>
            <c:if test="${sessionScope.account!=null}">
                <li><a class="smoothscroll"  href="viewAccount?msg=Edit">MyAccount</li>
            </c:if>
            <li><a href="help" class="smoothscroll" >Help</a> </li>

        </ul>


    </nav>
    <ul class="home-social-list">
        <li style="display: inline">
            <a href="viewCategory?categoryId=FISH"><p6>fish</p6></a>
        </li>
        <li style="display: inline">
            <a href="viewCategory?categoryId=DOGS"><p6>dogs</p6></a>
        </li>
        <li style="display: inline">
            <a href="viewCategory?categoryId=REPTILES"><p6>reptiles</p6></a>
        </li >
        <li style="display: inline">
            <a href="viewCategory?categoryId=CATS"><p6>cats</p6></a>
        </li>
          <li style="display: inline">
              <a href="viewCategory?categoryId=BIRDS"><p6>birds</p6></a>
          </li>

    </ul>

</header>
</div>


<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<script src="js/autoComplete.js"></script>
<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen" />

    <meta name="generator" content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>MyPetStore</title>
    <meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />
</head>

<body>--%>


<%--<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <c:if test="${sessionScope.account == null}"><a href="viewAccount?msg=SignOn"><img align="middle" name="img_cart" src="images/cart.gif" /></a></c:if>
            <c:if test="${sessionScope.account != null}"><a href="viewCart"><img align="middle" name="img_cart" src="images/cart.gif" /></a></c:if>
            <c:if test="${sessionScope.account == null}"><img align="middle" src="images/separator.gif" /><a href="viewAccount?msg=SignOn">Sign In</a></c:if>
            <c:if test="${sessionScope.account != null}"><img align="middle" src="images/separator.gif" /><a href="signOut">Sign Out</a></c:if>
            <c:if test="${sessionScope.account != null}"><img align="middle" src="images/separator.gif" /><a href="viewAccount?msg=Edit">My Account</a></c:if>
            <img align="middle" src="images/separator.gif" />
            <a href="help">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="search" method="post" name="autoCompleteForm">
                <input type="text" name="keyword" id="keyword" list="products" size="14" onkeyup="completeItemList();"/>
                <datalist id="products"></datalist>
                <input type="submit" name="searchProducts" value="Search" />
            </form>
        </div>
    </div>--%>

<%--    <div id="QuickLinks">
        <a href="viewCategory?categoryId=FISH"><img src="images/sm_fish.gif" /></a>
            <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=DOGS"><img src="images/sm_dogs.gif" /></a>
            <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=REPTILES"><img src="images/sm_reptiles.gif" /></a>
            <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=CATS"><img src="images/sm_cats.gif" /></a>
            <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=BIRDS"><img src="images/sm_birds.gif" /></a>
    </div>

</div>

<div id="Content">--%>
