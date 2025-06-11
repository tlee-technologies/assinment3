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

    <div class="card mb-4" style="max-width: 600px;">
        <div class="row g-0">
            <div class="col-md-4">
                <img src="/images/${animal.imageUrl?default('default.png')}" class="img-fluid rounded-start" alt="animal image">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">${animal.name}</h5>
                    <p class="card-text"><strong>Description:</strong> ${animal.description}</p>
                    <p class="card-text"><strong>Habitat:</strong> ${animal.habitat}</p>
                    <p class="card-text"><strong>Diet:</strong> ${animal.diet}</p>
                </div>
            </div>
        </div>
    </div>

    <a href="/animals/updateForm/${animal.animalId}" class="btn btn-primary">Edit</a>
    <a href="/animals/delete/${animal.animalId}" class="btn btn-danger">Delete</a>
    <a href="/animals" class="btn btn-secondary">Back to List</a>
</div>
</body>
</html>
