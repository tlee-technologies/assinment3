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

    <form action="/animals/update/${animal.animalId}" method="post" class="needs-validation">
        <div class="mb-3">
            <label for="name" class="form-label">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${animal.name}" required>
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="3" required>${animal.description}</textarea>
        </div>

        <div class="mb-3">
            <label for="habitat" class="form-label">Habitat:</label>
            <input type="text" class="form-control" id="habitat" name="habitat" value="${animal.habitat}">
        </div>

        <div class="mb-3">
            <label for="diet" class="form-label">Diet:</label>
            <input type="text" class="form-control" id="diet" name="diet" value="${animal.diet}">
        </div>

        <div class="mb-3">
            <label for="imageUrl" class="form-label">Image File Name (e.g. lion.jpg):</label>
            <input type="text" class="form-control" id="imageUrl" name="imageUrl" value="${animal.imageUrl}">
        </div>

        <button type="submit" class="btn btn-primary">Update Animal</button>
        <a href="/animals/${animal.animalId}" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>