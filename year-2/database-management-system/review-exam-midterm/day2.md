# Session 1
## Data Model
- It describes three things:
    1. the data objects and data types - what we store
    2. the relationships - how they connect
    3. the constraints - the rules about what is allowed
- It is like an architect's building plan
- It should en with relational data model
## Planning and Analysis
- Data Model gets its input from this
- Ways:
    - Sampling existing documents
    - Site visits
    - Questionnaires
    - Prototyping
    - Interview
    - Observation
    - Join requirements planning
## ER Diagram
- ER Model 
    - draw the logical relationships between entities to create a database
    - proposed by Peter Chen in 1970
- ER Diagram - the drawing itself that describes the relationships between entities using symbols

Part | Think of it as | Symbol
-- | -- | --
Entity | Noun | Rectangle
Attribute | Adjective | Ellipse
Relationship | Verb | Diamond
## Entity
- real-world objects that matters to the database
- Related terms:
    - Entity Set - group of related entities
    - Entity Occurrence (instance)
- Strong Entity
    - Exists on its own
    - has a primary key
    - Symbol: Single rectangle
- Weak Entity
    - Depends on another entity to exist
    - Key: foreign key + discriminator
    - Symbol: Double Rectangle  
## Attribute
- descriptive property of an entity
- identifier - uniquely identifies an instance
- descriptor - non-unique characteristic

Type | Symbol
-- | -- 
Simple/Single-valued | Ellipse
Composite | Ellipse with branching ellipses
Multivalued | Double Ellipse
Derived | Dotted Ellipse    
# Session 2
## Relationships
- Association between two or more entities
- Symbol: Diamond
- can get its own attribute
## Degree
- The number of entities in a relationship
    - Unary
    - Binary
    - Ternary
## Cardinality
- 1:1
- 1:N
- M:N 
    - can't be expressed on relational tables
    - add an associative entity
## Participation
- mandatory
- optional
## Identifying and Recursive Relationship
- Identifying Relationship - relationship between strong and weak entity
- Recursive Relationship - same entity takes part more than once