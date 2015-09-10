<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>kLibrary &middot; Search results</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" href="/assets/stylesheets/bootstrap/css/bootstrap.min.css" media="screen">
  </head>
  <body>

  <div class="bs-component">
    <nav class="navbar navbar-default kainos-header">
      <div class="container-fluid">
        <a href="#0" class="btn btn-kainos-header">
          <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                    <path fill="#ffffff" d="M15.41,16.58L10.83,12L15.41,7.41L14,6L8,12L14,18L15.41,16.58Z" />
                    </svg> <span>Back</span></a>
        <div class="navbar-header">
          <a class="navbar-brand kainos-branding" href="#">kLibrary</a>
        </div>

        <form class="kainos-search-group" role="search" action="search" method="post">
          <div class="form-group">

            <input type="text" class="form-control input-sm kainos-search" placeholder="Search" value="${searchText}"  name="searchText">
            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
            <select class="form-control input-sm kainos-criteria" id="select" name="searchCriteria">
              <option>Title</option>
              <option>Author</option>
              <option>Category</option>
              <option>Year</option>
            </select>
            <button type="submit" class="btn btn-primary btn-sm kainos-search-button">Search</button>
          </div>

        </form>


      </div>
    </nav>

  </div>


<div class="container-fluid">

  <h3 class="kainos-result-header">${searchMessage}</h3>
  
  <#list books as book>

  <a href="#0">
    <div class="kainos-book-card">
      <div class="col-xs-4 col-md-2 kainos-book-cover">
        <img src="http://placehold.it/100x150" class="img-responsive" />
      </div>
      <div class="col-xs-8 col-md-8 kainos-book-details">
        <span class="label label-success kainos-label">Available</span>
        <h2>${book.bookTitle} <span class="year">${book.bookPublishedYear} </span></h2>
        <h3 class="kainos-book-author">${book.bookAuthor}</h3>
        <h4 class="kainos-book-category">${book.bookCategory}</h4>
      </div>
    </div>
  </a>
   </#list>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="/assets/stylesheets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>