<%--
  Created by IntelliJ IDEA.
  User: ZZY
  Date: 2019-10-13
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../common/IncludeTop.jsp"%>


<section class="back-img" id="home" data-parallax="scroll" data-image-src="images/background.png" data-natural-width=3000 data-natural-height=2000>

    <div class="overlay"></div>
    <div class="home-content">

        <div class="row contents">
            <div class="home-content-left">

                <h3 data-aos="fade-up">Welcome to MyPetstore</h3>

                <h2 data-aos="fade-up">
                    <a href="viewCategory?categoryId=FISH" class="categoryName">
                        FISH
                         <h3>Saltwater, Freshwater</h3>
                    </a>
                    <a href="viewCategory?categoryId=DOGS" class="categoryName">
                        DOGS
                         <h3>Various Breeds</h3>
                    </a>
                    <a href="viewCategory?categoryId=CATS" class="categoryName">
                        CATS
                        <h3>Various Breeds, Exotic Varieties </h3>
                    </a>
                    <a href="viewCategory?categoryId=REPTILES" class="categoryName">
                        REPTILES
                        <h3> Lizards, Turtles, Snakes</h3>
                    </a>
                    <a href="viewCategory?categoryId=BIRDS" class="categoryName">
                        BIRDS
                       <h3> Exotic Varieties</h3>
                    </a>
                </h2>

            </div>
            <div class="home-image-right">
                <img src="images/iphone-app-470.png">
            </div>




        </div>

    </div> <!-- end home-content -->


    </div>


</section> <!-- end home -->
<%@include file="../common/IncludeBottom.jsp"%>
