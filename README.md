API Endpoints

Base URL: http://localhost:8080/animals


1. / (GET)

Gets a list of all animals in the database.

Response — A JSON array of Animal objects:

<pre>
[
  {
    "animalId": 1,
    "name": "Black Bear",
    "description": "Found in NC forests and wetlands",
    "habitat": "Forests and wetlands",
    "diet": "Berries, insects, small mammals",
    "imageUrl": "images/Black-Bear.jpg"
  },
  {
    "animalId": 2,
    "name": "Red Fox",
    "description": "Clever predator that thrives in suburbs",
    "habitat": "Forests, farms, neighborhoods",
    "diet": "Small animals, fruits, insects",
    "imageUrl": "images/Red-Fox.jpg"
  }
]
</pre>


2. /{animalId} (GET)

Gets a single animal by its ID.

Path Variable: animalId <Long> – REQUIRED

Response — A single Animal object:

<pre>
```json
{
  "animalId": 1,
  "name": "Black Bear",
  "description": "Found in NC forests and wetlands",
  "habitat": "Forests and wetlands",
  "diet": "Berries, insects, small mammals",
  "imageUrl": "images/Black-Bear.jpg"
}
```
</pre>



3. /name (GET)

Gets animals whose names contain the given string.

Query Parameter: search <String> – REQUIRED

Response — A JSON array of Animal objects:

<pre>
```json
[
  {
    "animalId": 2,
    "name": "Red Fox",
    "description": "Clever predator that thrives in suburbs",
    "habitat": "Forests, farms, neighborhoods",
    "diet": "Small animals, fruits, insects",
    "imageUrl": "images/Red-Fox.jpg"
  }
]
```
</pre>



4. /habitat/{habitat} (GET)

Gets animals that match a specific habitat string.

Path Variable: habitat <String> – REQUIRED

Response — A JSON array of Animal objects:

<pre>
```json
[
  {
    "animalId": 3,
    "name": "Eastern Box Turtle",
    "description": "Can fully close its shell when threatened",
    "habitat": "Moist forest floors and meadows",
    "diet": "Mushrooms, berries, worms, insects",
    "imageUrl": "images/Eastern-Box-Turtle.jpeg.webp"
  }
]
```
</pre>



5. / (POST)

Creates a new animal entry.

Request Body:

<pre>
```json
{
  "name": "Barred Owl",
  "description": "Known for its 'who-cooks-for-you' call",
  "habitat": "Woodlands near water",
  "diet": "Small mammals, birds, amphibians",
  "imageUrl": "images/Barred-Owl.jpg"
}
```
</pre>


Response — The newly created Animal:

<pre>
```json
{
  "animalId": 6,
  "name": "Barred Owl",
  "description": "Known for its 'who-cooks-for-you' call",
  "habitat": "Woodlands near water",
  "diet": "Small mammals, birds, amphibians",
  "imageUrl": "images/Barred-Owl.jpg"
}
```
</pre>



6. /{animalId} (PUT)

Updates an existing animal.

Path Variable: animalId <Long> – REQUIRED

Request Body:

<pre>
```json
{
  "name": "Updated Owl",
  "description": "Updated description",
  "habitat": "Deep Forest",
  "diet": "Rodents",
  "imageUrl": "images/Updated-Owl.jpg"
}
```
</pre>


Response — The updated Animal:

<pre>
```json
{
  "animalId": 6,
  "name": "Updated Owl",
  "description": "Updated description",
  "habitat": "Deep Forest",
  "diet": "Rodents",
  "imageUrl": "images/Updated-Owl.jpg"
}
```
</pre>



7. /{animalId} (DELETE)

Deletes an animal from the database.

Path Variable: animalId <Long> – REQUIRED

Response — A list of all remaining animals.

