<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>kLibrary &middot; Book</title>
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

        <div class="form-group kainos-search">
          <input class="form-control input-sm kainos-searchbox" type="text" id="inputSmall" placeholder="Search">
        </div>


      </div>
    </nav>

  </div>


<div class="container-fluid">
<a href="/bookDetails/${book.id}"/>
    <div class="kainos-book-card">
      <div class="col-xs-6 kainos-book-cover">
        <img src="http://placehold.it/200x300" class="img-responsive" />
      </div>
      <div class="col-xs-6 kainos-book-details">
        <span class="label label-success kainos-label">Available</span>
        <h2>${book.bookTitle} <span class="year">${book.bookPublishedYearString}</span></h2>
        <h3 class="kainos-book-author">${book.bookAuthor}</h3>
        <h4 class="kainos-book-category">${book.bookCategory}</h4>
      </div>

      <div class="col-xs-12 kainos-book-description">
        <h3>Description</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum enim quisquam tenetur id nemo minus earum, iusto veniam obcaecati, deserunt!</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum enim quisquam tenetur id nemo minus earum, iusto veniam obcaecati, deserunt!</p>
      </div>
    </div>
	</a>

</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
