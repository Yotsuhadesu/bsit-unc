# SQL

## CREATE TABLE
Format:

    CREATE TABLE table_name (
        column_name DATA_TYPE constraints,
        ...
    );

    -- with foreign key
    CREATE TABLE table_name (
        column_name DATA_TYPE constraints,
        FOREIGN KEY (column_name) REFERENCES other_table(column_name)
        ...
    );
    

Data Types:
1. INT - numbers
2. VARCHAR(n) - characters with n as the max number of characters
3. TIMESTAMP - date/time
4. TEXT - characters with no length limit

Constraints:
1. AUTO_INCREMENT - increment every row created
2. PRIMARY KEY - table's unique identifier
3. NOT NULL - required value
4. UNIQUE - value that cannot be repeated
5. DEFAULT CURRENT_TIMESTAMP - auto-fill current date/time when the row is created

        CREATE TABLE users (
            user_id INT AUTO_INCREMENT PRIMARY KEY,
            username VARCHAR(50) NOT NULL UNIQUE,
            email VARCHAR(100) NOT NULL,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        );

        CREATE TABLE posts (
            post_id INT AUTO_INCREMENT PRIMARY KEY,
            user_id INT NOT NULL,
            title VARCHAR(150) NOT NULL,
            body TEXT,
            FOREIGN KEY (user_id) REFERENCES users(user_id)
        );

        CREATE TABLE tags (
            tag_id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(50) NOT NULL UNIQUE
        );

        -- Junction Table
        CREATE TABLE post_tags (
            post_id INT NOT NULL,
            tag_id INT NOT NULL,
            PRIMARY KEY (post_id, tag_id),
            FOREIGN KEY (post_id) REFERENCES posts(post_id),
            FOREIGN KEY (tag_id) REFERENCES tags(tag_id)
        )

## INSERT
Format:

    INSERT INTO table_name (column1, column2, ...) VALUES (value1, value2, ...);

    INSERT INTO users (username, email) VALUES ('Yotsuha', 'yotsuhadesu@example.com');

    INSERT INTO posts (user_id, title, body) VALUES (1, 'Violet Evergarden', 'Bayoretto Ebagaden des'), (1, 'SQL', 'SQL PHP Tutorial');

    INSERT INTO tags (name) VALUES ('VioletEvergarden'), ('Kyoto Animation'), ('SQL');

    -- Linking via Junction Table
    INSERT INTO post_tags (post_id, tag_id) VALUES (1, 1), (1, 2), (2, 3);

## SELECT
Format:

    SELECT column1, column2 FROM table_name;

    -- for junction table data selection
    SELECT tableA.column, tableB.column
    FROM tableA
    JOIN junctionTable ON tableA.id = junctionTable.tableA_id
    JOIN tableB ON junctionTable.tableB_id = tableB_id;
Keywords:
- `SELECT *` to select all columns
- `WHERE condition` - filter rows
- `ORDER BY column [ASC or DESC]` - sort results

Exercise:
1. A SELECT that gets all columns from posts

        SELECT * FROM posts;
2. A SELECT that gets only title and body from posts, but only where user_id = 1

        SELECT title, body FROM posts WHERE user_id =1;
3. A SELECT that gets all users, ordered by username alphabetically

        SELECT * FROM users ORDER BY username ASC;

## UPDATE and DELETE
Format:

    UPDATE table_name SET column = value WHERE condition;

    DELETE FROM table_name WHERE condition;

Exercise:
1. An UPDATE that changes the email of the user with user_id = 1 to newemail@example.com

        UPDATE users SET email = 'newemail@example.com' WHERE user_id = 1;
2. A DELETE that removes the post with post_id = 1

        DELETE FROM posts WHERE post_id = 1;