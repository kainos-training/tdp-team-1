<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>kLibrary &middot; Index of books</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="/assets/stylesheets/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
  </head>
  <body>

  <div class="bs-component">
    <nav class="navbar navbar-default kainos-header">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand kainos-branding" href="#">kLibrary</a>
        </div>

        <div class="form-group kainos-search">
          <input class="form-control input-sm kainos-searchbox" type="text" id="inputSmall" placeholder="Search">
        </div>


      </div>
    </nav>

  </div>


<div class="container-fluid">
<#list books as book>
  <a href="#0">
    <div class="kainos-book-card">
      <div class="col-xs-4 col-md-2 kainos-book-cover">
        <img src="http://placehold.it/100x150" class="img-responsive" />
      </div>
      <div class="col-xs-8 col-md-8 kainos-book-details">
        <span class="label label-success kainos-label">Available</span>
        <h2>${book.bookTitle} <span class="year">${book.bookPublishedYear}</span></h2>
        <h3 class="kainos-book-author">${book.bookAuthor}</h3>
        <h4 class="kainos-book-category">${book.bookCategory}</h4>
      </div>
    </div>
  </a>
   </#list>

</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>


