<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
    <div class="container-lg p-3 my-3 bg-primary text-white">
        <nav class="nav justify-content-left ">
            <h2>Subject Management</h2>
            <a class="nav-link" href="index.html"></a>
        </nav>
    </div>
    
    <div class="container-lg my-3 py-3 border-top">
        <select class="mdb-select md-form float-left active-cyan">
            <option value="" disabled selected>------All Subject------</option>
            <option value="1">Option 1</option>
            <option value="2">Option 2</option>
            <option value="3">Option 3</option>
        </select>
        <div class="md-form active-cyan active-cyan-2 mb-3 float-right">
            <input class="form-control" type="text" placeholder="Search" aria-label="Search"/>
        </div>
    </div>

    <div class="container-lg my-3 py-3">
        <table class="table table-hover  table-striped table-bordered">
            <thead>
                <tr style="background-color: #0275d8;">
                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>John</td>
                    <td>Doe</td>
                    <td>john@example.com</td>
                </tr>
                <tr>
                    <td>John</td>
                    <td>Doe</td>
                    <td>john@example.com</td>
                </tr>
                <tr>
                    <td>John</td>
                    <td>Doe</td>
                    <td>john@example.com</td>
                </tr>
            </tbody>
        </table>
        <input type="submit" class="btn btn-primary  float-right" value="+Add New"/>
    </div>

    
</body>
</html>