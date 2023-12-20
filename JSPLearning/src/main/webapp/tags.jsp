<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main>
	<h5>Article to read: <a href="https://www.techguruspeaks.com/jsp-tags/">JSP Tags</a></h5>
	<br><br>
<div>
	<h2>1. Directive Tag:</h2>
	<p>Directive tags provide general information about the JSP page to the JSP engine. A directive tag always starts with &lt%@ and ends with %&gt.
<br>
There are 3 types of directives: <b>page, include, and taglib.</b> <br>The general syntax for the 3 directives is:<br>
&lt%@ page attribute-list %&gt <br>
&lt%@ include attribute-list %&gt<br>
&lt%@ taglib attribute-list %&gt <br>
<br>
In the above shown syntax, the attribute-list represents one or more attribute value-pairs that are specific to the directive. Some important points that are needed to be remembered about the syntax of the directive are as follows:
<br><pre>
* The tag names, their attributes, and their values are all case sensitive.
* The value must be enclosed within a pair of single or double quotes.
* A pair of single quotes is equivalent to a pair of double quotes.
* There must be no space between the equals sign (=) and the value.
</pre>
<br>
A page directive informs the JSP engine about the overall properties of a JSP page. For example, the following page directives inform the JSP engine that Java will be used as scripting language in our JSP page:
<br>
An include directive tells the JSP engine to include the contents of another file (HTML, JSP, etc) into the current file.
<br>
A taglib directive is used to associate a prefix with a tag library. 
<br>
</p>
</div>
<div>
<h2>2. Declaration Tag:</h2>
<p>
<pre>
Declarations declare and define variables and methods that can be used in the JSP page (a JSP declaration can contain any valid Java declaration including inner classes and static code blocks. However, such declarations are rarely used). A declaration always starts with &lt%! and ends with %&gt.

For e.g.: <%! int i = 0; %>

This declares an integer variable i and initializes to 0. The variable is initialized only once when the page is first loaded by the JSP engine, and retains its value in subsequent client requests i.e. the value of i is not reset to 0 each time we access the page. It can contain any number of valid Java declaration statements. For example, the following tag declares a variable and a method in a single tag:
</pre><br>Code here see in file....
<%!
     String name[] = {"biswa", "amit", "sreejan"};

     String getName(int i) {
        return name[i];
     }
%>
<br>
The above declaration can also be written using two separate JSP declaration tags.
</p>
</div>
	
<div>
<h2>3. Scriptlet Tag:</h2>
<p>
<pre>
Scriptlets are used to embed any Java code fragments in the JSP page.

For example: <% i++; %>     

Here the scriptlet tag is executed and the value of i is incremented each time the page is requested. We can use scriptlets for printing HTML statements also. For e.g.:

Code here find in file....
<%@ page language="java" %>
<%! int i1 = 0; %>
<%
   out.print("");        
   i1++;
   out.print("The value of i1 is now:  " + i1);
   out.print("");
%>

</pre>
</p>
</div>

<div>
<h2>4. Expression Tag:</h2>
<p>
<pre>
Expression tags are used as a shortcut to print values in the output HTML in a JSP page. Syntax of Expression tag is:
<%! String variable="This is variable."; %>
<%= variable %>     
The variable denotes the variable value that is needed to be printed in the output HTML page.   For e.g.: <%= i %>  

The expression is evaluated each time the page is accessed, and its value is then embedded in the output HTML. Unlike variable declarations, expressions must not be terminated with a semicolon. Thus, the following is not valid: &lt%= i; %&gt
</pre>
</p>
</div>
	
	
<div>
<h2>5. Action Tag:</h2>
<p>
<pre>
Action tags are used to provide request–time instructions to the JSP container or JSP engine. There are 7 types of action tags. The following table describes various JSP action tags:

<b>1. &ltjsp:forward&gt</b>
Description: Used to forward a request to a target page
Attribute: page
Description of Attributes: Specifies the URL of the target page

<b>2. &ltjsp:include&gt</b>
Description: Includes a file in the current JSP page
Attribute: page flush
Description of Attributes:Specifies the URL of the resource to be included. Specifies whether the buffer should be flushed or not. The flush value can be either true or false. 

<b>3. &ltjsp:useBean&gt</b>
Description: Invokes and searches for an existing bean.
Attribute: id class scope beanName
Description of Attributes: Uniquely identifies the instance of the bean. Identifies the class from which the bean objects are to be implemented. Defines the scope of the bean. Defines the referential name for the bean.

<b>4. &ltjsp:getProperty&gt</b>
Description: Retrieves the property of a bean or create a bean into a defined scope
Attribute: name property
Description of Attributes: Defines the name for the bean. Defines the property from which the values are to be retrieved.

<b>5. &ltjsp:setProperty&gt</b>
Description: Used to set the property for a bean
Attribute: name property value param
Description of Attributes: Specifies a name for the bean. Defines the property for which values are to be set. Defines an explicit value for the bean property. Defines the name of the request parameter to be used.

<b>6. &ltjsp:param&gt</b>
Description: Defines a parameter to be passed to an included or forwarded page
Attribute: name value
Description of Attributes:Defines the name of the reference parameter. Defines the value of the specified parameter

<b>7. &ltjsp:plugin&gt</b>
Description: Embed a Java applets or a JavaBean
Attribute: type code codebase
Description of Attributes: Defines the type of plug-in to be included. Defines the name of the class to be executed by the plug-in. Defines the path of the code

The general syntax of a JSP action tag is:

<b>&ltjsp:actionName attribute-list /&gt</b>
In this tag, actionName is one of the seven actions mentioned and attribute-list represents one or more attribute-value pairs that are specific to the action.
</pre>
</p>
</div>

<div>
<p>
<pre>
<h2>6. Comment Tag:</h2>
Comments are used for documentation purposes but do not affect the output of the JSP page in any way. The syntax of a JSP comment is:
&lt%-- Anything you want to be commented --%&gt
</pre>
</p>
</div>
</main>
</body>
</html>