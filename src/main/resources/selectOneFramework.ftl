<!DOCTYPE html>
<html>
<head>
<title>KTech</title>
    <link rel="stylesheet" type="text/css" href="/assets/stylesheets/styles.css"/> 
</head>
<body>
    <header>  
        <div class="clearfix">
            
            
        
            <div class="logo pull-left">

                <h1 class="heading-one">K<span>Tech</span></h1>

            </div>

            <nav class="pull-left">

                <ul>

                    <li class="image-replace technolgies active has-tip" data-tip="Technolgies">Technolgies</li>
                        <!--Enable if search functionaltiy is played-->
<!--                    <li class="image-replace search">Search</li>-->

                </ul>
            </nav>  
        </div>
    </header>  
    <main>
        <div class="container">
          
            <div class="row clearfix">
                <p><a href="#" class="breadcrumb-item"><span>&#10094</span>Back</a></p>
                <h1 class="heading-two pull-left">${framework.getFrameworkName()}</h1>
                <dl class="pull-left">
                    <div class="dl-group pull-left">
                        <dt class="uppercase pull-left">Vendor</dt>
                        <dd class="pull-left">${framework.getVendor()}</dd>
                    </div>
                    <div class="dl-group pull-left">
                        <dt class="uppercase pull-left">Licenses</dt>
                        <dd class="pull-left">${framework.getLicense()}</dd>
                    </div>
                    
                     <div class="dl-group pull-left">
                        <dt class="uppercase pull-left">Expert</dt>
                        <dd class="pull-left">${framework.getExpert()}</dd>
                    </div>
                    
                </dl> 
            </div>
            
            
    <!--        <h2 class="heading-three-view">Projects</h2>
             <table class="technology-table">
                <caption class="visiually-hidden">Projects</caption>
                <summary class="visiually-hidden">A list of all projects the framework has been used on</summary>
                <thead>
                    <tr>
                        <th scope="col" class="uppercase">Projects</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        
                        
          
                    </tr>
                        <tr>
                        
                        <td></td>
                    </tr>
                </tbody>
            </table> -->
        </div>    
    </main>
</body>
</html>