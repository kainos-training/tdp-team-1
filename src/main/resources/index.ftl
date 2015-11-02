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

                    <h1 class="heading-two pull-left">Technologies</h1>

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
                        <th scope="col" class="uppercase">License</th>
                        <th scope="col" class="uppercase">Expert</th>
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