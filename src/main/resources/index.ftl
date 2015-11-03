<#-- @ftlvariable name="" type="com.kainos.training.dropwizard.login.frontends.views.LoginSuccessView" -->
<!DOCTYPE html>
<html>
<head>
<title>KTech</title>
    <meta charset="UTF-8">
    <link href="/assets/stylesheets/styles.css" type="text/css" rel="stylesheet" />
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>

<body>
    
    <header>
        
        <div class="clearfix">
        
            <div class="logo pull-left">

                <h1 class="heading-one">KTech<span>Matrix</span></h1>

            </div>

            <nav class="pull-left">

                <ul>

                    <li class="image-replace technolgies active has-tip" data-tip="Technolgies">Technologies</li>

                </ul>

            </nav>
            
        </div>
    
    </header>
    
    <main>
        
     
        
        <div class="container">
        

            <div class="row clearfix">

                    <h1 class="heading-two pull-left">Frameworks</h1>
                    
<div class="modal">

                        <input class="visiually-hidden" id="modal-trigger" type="checkbox">
                        <label class="btn primary pull-right" for="modal-trigger">Add a framework</label>

                        <div class="modal-overlay">

                            <div class="modal-wrapper">

                                <div class="modal-header">

                                    <label for="modal-trigger" class="close-modal">&#10006;</label>
                                    <h2 class="heading-three">Add a new framework</h2>

                                </div>

                                <form method="post" action="insertFramework">

                                    <fieldset>

                                        <div class="form-body">

                                            <legend class="visiually-hidden">Add a new framework</legend>

                                            <div class="form-group">

                                                <label for="framework-name">Framework name</label>
                                                <input id="framework-name" type="text" name="nameField" maxLength="50" required> 
 
                                            </div>
                                            
                                            <div class="form-group">

                                                <label for="framework-license">License</label>
                                                <input id="framework-license" type="text" name="licenseField" maxLength="50" required> 

                                            </div>
                                            
                                            <div class="form-group">

                                                <label for="framework-expert">Expert</label>
                                                <input id="framework-expert" type="text" name="expertField" maxLength="25" required> 

                                            </div>
                                            
                                            <div class="form-group">

                                                <label for="framework-vendor">Vendor</label>
                                                <input id="framework-vendor" type="text" name="vendorField" maxLength="25" required>

                                            </div>

                                        </div>

                                        <div class="form-footer clearfix">
                                            <input class="btn primary pull-right" type="submit" name="submit" value="Submit framework">

                                            <label class="close pull-right" for="modal-trigger">Cancel</label>

                                        </div>

                                    </fieldset>

                                </form>

                            </div>

                        </div>

                    </div>

            </div>
            
            
        </div>
           
            <div class="container">
            
            <form action="#" method="get" class="searchFramework-form clearfix">
                        
                <fieldset>
                            
                    <legend class="visiually-hidden">Search for framework</legend>
                    
                    <div class="group pull-left">
                        
                        <label for="select-menu" class="framework-name">Search by</label>
                        <select id="select-menu" name="select" class="float-left">
                            <option value="frameworkName">Framework name</option>
                            <option value="license">License</option>
                            <option value="expert">Expert</option>
                            <option value="vendor">Vendor</option>
                        </select>
                    
                        <label for="framework-name" class="visiually-hidden">Framework name</label>
                        <input id="framework-name" type="text" name="textfield" class="search-input" placeholder="AngularJS etc" maxLength='50' required> 
                        
                    </div>
                    
                    <div class="group pull-left">
                    
                     <input class="btn default search-btn" type="submit" name="submit" value="Search framework">
                        
                    </div>
                        
                </fieldset>
                
            </form>
        
            <#if frameworks??>
            <table class="technology-table">

                <caption class="visiually-hidden">Technology table</caption>
                <summary class="visiually-hidden">A list of all technolgies used by KTech</summary>

                <thead>

                    <tr>
                        <th scope="col" class="uppercase">Name</th>
                        <th scope="col" class="uppercase">License</th>
                        <th scope="col" class="uppercase">Expert</th>
                        <th scope="col" class="uppercase">Vendor</th>
                    </tr>

                </thead>

                <tbody>

                    <#list frameworks as framework>
                        <tr>
                            <td>
                                <span class="technology-name">
                                   <a href="/selectOneFramework/${framework.getId()}">${framework.getFrameworkName()}</a>
                                </span>
                            </td>
                            <td>
                                ${framework.getLicense()}
                            </td>
                            <td>
                                ${framework.getExpert()}
                            </td>
                            <td>
                                ${framework.getVendor()}
                            </td>
                        </tr> 
                    </#list>

                </tbody>


            </table>
            <#else>
                <p>No technologies added</p>
            </#if>

            </div>
            
    
    
    </main>

<script type="text/javascript">
//Closes validaiton message
$(".close-validation").on("click", function(){
    $(this).parent().fadeOut();
});
</script>

</body>

</html>
