<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>${title}</h1>

    <a href="/animals/createForm" class="btn btn-success mb-3">Add New Animal</a>

    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Habitat</th>
            <th>Diet</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <#list animalsList as animal>
            <tr>
                <td>${animal.name}</td>
                <td>${animal.habitat}</td>
                <td>${animal.diet}</td>
                <td>
                    <a href="/animals/${animal.animalId}" class="btn btn-info btn-sm">View</a>
                    <a href="/animals/updateForm/${animal.animalId}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="/animals/delete/${animal.animalId}" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>