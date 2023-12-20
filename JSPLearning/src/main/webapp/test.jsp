<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Learning</title>
<style>
        #ul{
            border: solid;
            float: left; 
            margin-left: 5%;
            width: 25vw;
        }
        #ol{
            border: solid;
            margin-left: 37%;
            width: 25vw;
            float: inherit;
        }
        #dl{
            border: solid;
            float: right;
            margin-right: 6%;
            width: 25vw;
            margin-top: -78%;
        }
        header{
            border: solid;
            height: 15vh;
        }
        main{
            border: solid;
            height: 70vh;
        }
        aside{
            border: solid;
            width: 30%;
            height: 100%;
            float: left;
        }
        article{
            border: solid;
            width: 70%;
            height: 100%;
            margin-left: 30%;
            /* margin-top: -65%; */
            /* It makes problem with different screen size */
        }
        footer{
            border: solid;
            height: 15vh;

        }
</style>
</head>
<body>
	<h1>This is jsp test page.</h1>
	<!-- All the tags which clearly describes its meaning from its name is known as semantic tags -->
    <!-- Tags which are as it is word in english having some meaning and same work is done by that tag -->

    <section>
        <header>This is header.</header>
        <main>
            <aside>This is side bar.</aside>
            <article>
                This is Article.
                <table></table>
                <form></form>
            </article>
        </main>
        <footer>This is footer.</footer>
    </section>
    
    
    
	<div>
    <div id="ul">
        <h1>UnOrdered List</h1>
        <h3>UL 1:</h3>
        <ul><!--By default value of type attribute for ul is disc-->
            <li>Potato</li>
            <li>Tomato</li>
            <li>Onion</li>
        </ul>
        <h3>UL 2:</h3>
        <ul type="square">
            <li>Potato</li>
            <li>Tomato</li>
            <li>Onion</li>
        </ul>
        <h3>UL 3:</h3>
        <ul type="circle">
            <li>Potato</li>
            <li>Tomato</li>
            <li>Onion</li>
        </ul>
        <h3>UL 4:</h3>
        <ul type="none">
            <li>Potato</li>
            <li>Tomato</li>
            <li>Onion</li>
        </ul>
        <h3>UL 5:</h3>
        <ul type="square">
            <li type="disc">Potato</li>
            <li >Tomato</li>
            <li type="circle">Onion</li>
            <li type="none">Cabbage</li>
        </ul>
        <h3>UL 6:</h3>
        <ul type="square">
            <li>Potato</li>
            <li>Tomato
                <ul><!--Nested list: by default value of type attribute of nested ul is circle-->
                    <li>Green Tomato</li>
                    <li>Tomato Sauce</li>
                </ul>
            </li>
            <li>Onion</li>
        </ul>
    </div>
    <div id="ol">
        <h1>Ordered List</h1>
        <h3>OL 1:</h3>
        <ol type="a" start="703" reversed>
            <li>Orange</li>
            <li type="1">Mango</li>
            <li type="A">Papaya</li>
            <li>Strawberry
                <ul>
                    <li>Apple Strawberry</li>
                    <li>Banana Strawberry</li>
                </ul>
            </li>
        </ol>
        <h3>OL 2:</h3>
        <ol><!--By default value of type attribute for Ol is 1 -->
            <li>Potato</li>
            <li>Tomato</li>
            <li>Onion</li>
        </ol>
        <h3>OL 3:</h3>
        <ol type="i">
            <li>Potato</li>
            <li>Tomato</li>
            <li>Onion</li>
        </ol>
        <h3>OL 4:</h3>
        <ol type="A">
            <li>Potato</li>
            <li>Tomato</li>
            <li>Onion</li>
        </ol>
        <h3>OL 5:</h3>
        <ol type="a">
            <li type="1">Potato</li>
            <li >Tomato</li>
            <li type="i">Onion</li>
            <li type="none">Cabbage</li>
        </ol>

        <h3>OL 6:</h3>
        <ol type="I">
            <li>Potato</li>
            <li>Tomato</li>
            <li>Onion</li>
        </ol>
        <h3>OL 7:</h3>
        <ol type="i">
            <li>Potato</li>
            <li>Tomato
                <ol><!--Nested list: by default value of type attribute of nested ol is 1 only-->
                    <li>Green Tomato</li>
                    <li>Tomato Sauce</li>
                </ol>
            </li>
            <li>Onion</li>
        </ol>
    </div>
    <div id="dl">
        <h1>Description List</h1>
        <h3>DL 1:</h3>
        <dl>
           <dt>Mobile</dt>
           <dd>8GB RAM and 128GB Storage.</dd>
           <dt>Laptop</dt>
           <dd>16GB RAM and 512GB SSD.</dd>
        </dl>
    </div>
    </div>
	
	
	
	 <div>
        <h1>Student Table</h1>
        <table border="5" cellpadding="5px" cellspacing="5px" >
            <caption>Students</caption>
            <thead>
                <tr>
                    <th rowspan="2">Name</th>
                    <th rowspan="2">Roll No.</th>
                    <th rowspan="2">Class</th>
                    <th rowspan="2">Email Id</th>
                    <th rowspan="2">College</th>
                    <th colspan="2">Phone No.</th>
                </tr>
                <tr>
                    <th>Primary</th>
                    <th>Secondary</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Kuldeep</td>
                    <td>101</td>
                    <td>B.tech</td>
                    <td>Kuldeep@gmail.com</td>
                    <td rowspan="5">B.H.U.</td>
                    <td>8282828282</td>
                    <td>9090909090</td>
                </tr>
                <tr>
                    <td>Anoop</td>
                    <td>102</td>
                    <td>B.tech</td>
                    <td>Anoop@gmail.com</td>
                    <td>7232727272</td>
                    <td>8585858585</td>
                </tr>
                <tr>
                    <td>Shubham</td>
                    <td>103</td>
                    <td>B.com</td>
                    <td>Shubham@gmail.com</td>
                    <td>9595959595</td>
                    <td>8787887878</td>
                </tr>
                <tr>
                    <td>Shreyansh</td>
                    <td>104</td>
                    <td>Mbbs</td>
                    <td>Shreyansh@gmail.com</td>
                    <td>8787878787</td>
                    <td>7272727272</td>
                </tr>
                <tr>
                    <td>Tripur</td>
                    <td>105</td>
                    <td>B.com</td>
                    <td>tripur@gmail.com</td>
                    <td>9292929292</td>
                    <td>7878788787</td>
                </tr>
            </tbody>
            <tfoot>
            </tfoot>
        </table>
    </div>
</body>
</html>