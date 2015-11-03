<#-- @ftlvariable name="" type="com.kainos.training.dropwizard.login.frontends.views.LoginSuccessView" -->
<!DOCTYPE html>
<html>
<head>
<title>KTech</title>
    <meta charset="UTF-8">
    <link href="/assets/stylesheets/styles.css" type="text/css" rel="stylesheet" />
</head>

<body>
    
    <header>
        
        <div class="clearfix">
        
            <div class="logo pull-left">

                <h1 class="heading-one">K<span>Tech</span></h1>

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
                        <label class="btn primary pull-right" for="modal-trigger">Add framework</label>

                        <div class="modal-overlay">

                            <div class="modal-wrapper">

                                <div class="modal-header">

                                    <label for="modal-trigger" class="close-modal">&#10006;</label>
                                    <h2 class="heading-three">Add a new technology</h2>

                                </div>

                                <form method="post" action="#">

                                    <fieldset>

                                        <div class="form-body">

                                            <legend class="visiually-hidden">Add a new technology</legend>

                                            <div class="form-group">

                                                <label for="technology-name">Technology name</label>
                                                <input id="technology-name" type="text" name="textfield"> 

                                            </div>

                                            <div class="form-group">

                                                <label for="technology-vendor">Vendor</label>
                                                <input id="technology-vendor" type="text" name="textfield">

                                            </div>

                                            <div class="form-group">

                                                <label for="technology-license">License</label>
                                                <input id="technology-license" type="text" name="textfield"> 

                                            </div>

                                            <div class="form-group">

                                                <label for="technology-expert">Expert</label>
                                                <input id="technology-expert" type="text" name="textfield"> 

                                            </div>

                                        </div>

                                        <div class="form-footer clearfix">
                                            <input class="btn primary pull-right" type="submit" name="submit" value="Submit Technology">

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
        
            <#if frameworks??>
            <table class="technology-table">

                <caption class="visiually-hidden">Technology table</caption>
                <summary class="visiually-hidden">A list of all technolgies used by KTech</summary>

                <thead>

                    <tr>
                        <th scope="col" class="uppercase">Name</th>
                        <th scope="col" class="uppercase">Vendor</th>
                        <th scope="col" class="uppercase">Expert</th>
                        <th scope="col" class="uppercase">License</th>
                    </tr>

                </thead>

                <tbody>

                    <#list frameworks as framework>
                        <tr>
                            <td>
                                <span class="technology-name">
                                    ${framework.getFrameworkName()}
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

</body>

</html>
