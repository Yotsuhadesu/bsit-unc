# Normalization
1. 1NF - columns should only contain atomic single values
2. 2NF - every non-key attribute must fully depend on the entire key attribute
3. 3NF - every non-key attribute must not depend on other non-key attributes

## Exercises
### POST
- Users
    user_id (PK) | user_name | 
    --- | --- 

- Posts
    post_id (PK) | date_posted | user_id (FK) | 
    --- | --- | --- 

- Comments
    comment_id (PK) | commenter_name | comment_content | post_id (FK)
    --- | --- | --- | ---

- Tags
    tag_id (PK) | tag_name 
    --- | --- 

- post_tags (Junction Table)
    post_id | tag_id
    --- | ---

### Loans 
- Unnormalized Library Book System
    loan_id (PK) | member_name | member_email | book_titles | isbn_list | librarian_id | librarian_name | branch_id | branch_name | loan_date | due_date
    --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
    1 | Ana Cruz | ana@email.com | "Dune, 1984" | "111-222-333-444" | L01 | Marco Reyes | B1 | Downtown Branch | 2026-09-01 | 2026-09-15

- Violations
    1. 1NF - a single loan_id can have multiple books at once
    2. 2NF - no violations
    3. 3NF - member_email depends on member_name

- Normalized Library Book System
    - Loans
        loan_id (PK) | loan_date | due_date | member_id (FK) | librarian_id (FK)
        --- | --- | --- | --- | --- | 
    - Borrowers
        member_id (PK) | member_name | member_email 
        --- | --- | --- | 
    - Books
        isbn (PK) | book_title | author_name 
        --- | --- | --- | 
    - Librarians    
        librarian_id (PK) | librarian_name | branch_id (FK)
        --- | --- | --- | 
    - Branches
        branch_id (PK) | branch_name
        --- | --- | 
    - loan_book
        isbn (FK) | loan_id (FK)
        --- | --- | 