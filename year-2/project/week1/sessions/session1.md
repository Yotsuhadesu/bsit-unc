# How the Web Works

## Client-Server Model
- `Client` - service request and use
- `Server` - service provider 

## HTTP Request and Response
- `HTTP Request` - the browser sends this to the server to request for web resources
- `HTTP Response` - the server sends web resources to the client

## URL (Uniform Resource Locator)
- `URL` - an address used to access a web resource on the internet
- Anatomy:

        https://google.com/images/travel/photo.jpg
    - `https://` - protocol
    - `google.com` - domain name
    - `/images/travel/photo.jpg` - path
    - `photo.jpg` - file

## Opening a Website (Simple HTTP)
1. Enter URL
2. DNS Lookup
3. TCP Handshake
4. HTTP Request
5. Server processes the request
6. HTTP Response
7. Browser loads the page

## Front-end and Back-end
- `Front-end` - processes on the website interface (client side)
- `Back-end` - processes on the server side

- Example:
    - C in `CRUD` (Create) - creating a new object in the database

| Front-end | Messenger | Back-end |
| --- | --- | --- |
| Browser (form) | HTTP Request | PHP Receive |
| Browser shows the result | HTTP Response | SQL query, MySQL, PHP Reply |

## Hosting
- `Hosting` - uploading a web resource to a always on online platform
- `Hosting Platform` - an always on online platform with a stable Domain Name and IP address