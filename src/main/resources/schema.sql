CREATE TABLE IF NOT EXISTS animals (
    animal_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    diet VARCHAR(255),
    habitat VARCHAR(255),
    image_url VARCHAR(255)
);