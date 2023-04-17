<#-- @ftlvariable name="" type="com.example.views.HomeView" -->
<html>
<head>
    <link rel="stylesheet" href="/assets/pure-min.css">
</head>
<body>
<h1>Welcome to the Prefab example-java-dropwizard application</h1>


<h2> Here's the current value of some sample properties</h2>

<table class="pure-table">
    <thead>
    <tr>
        <th>Key</th>
        <th>Value</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>sample.string</td>
        <td>${sampleString}</td>
    </tr>
    <tr>
        <td>sample.long</td>
        <td>${sampleLong}</td>
    </tr>
    </tbody>
</table>

<h3>Protected Links</h3>
<p> Use the following Basic Auth</p>
<table class="pure-table">
    <thead>
    <tr>
        <th>User</th>
        <th>Pass</th>
        <th>Roles</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>guest</td>
        <td>secret</td>
        <td></td>
    </tr>
    <tr>
        <td>basic</td>
        <td>secret</td>
        <td>BASIC</td>
    </tr>
    <tr>
        <td>admin</td>
        <td>secret</td>
        <td>ADMIN, BASIC</td>
    </tr>
    </tbody>
</table>

<ul>
    <li><a href="protected">Link requiring BASIC</a></li>
    <li><a href="protected/guest">Link allowing all </a></li>
    <li><a href="protected/admin">Link requiring ADMIN</a></li>
</ul>

</body>
</html>
