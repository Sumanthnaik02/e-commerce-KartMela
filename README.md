# e-commerce-KartMela

## 📁 Folder Structure
e-commerce-KartMela/
├── frontend/
│ ├── index.html
│ ├── cart.html
│ ├── checkout.html
│ ├── orders.html
│ ├── css/
│ ├── js/
│ └── img/
├── backend/
│ └── (Spring Boot Project)
└── README.md

## 📡 API Contract

### 🧩 Base URL
http://localhost:8080/api


---

### 🛍️ GET All Products

- **Endpoint:** `GET /api/products`  
- **Used In:** `index.html`  
- **Response:**

```json
[
  {
    "id": 1,
    "title": "Sony Lens",
    "price": 2999,
    "description": "High-quality zoom lens",
    "imageUrl": "/img/sony-lens.png"
  }
]

🔐 POST Signup
Endpoint: POST /api/signup

Used In: login.js

Request:
{
  "username": "sumanth",
  "password": "123456"
}

Response:
{
  "message": "Signup successful"
}

🔐 POST Login
Endpoint: POST /api/login
Used In: login.js

Request:
{
  "username": "sumanth",
  "password": "123456"
}

Response:
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5..."
}

🧾 POST Checkout
Endpoint: POST /api/checkout

Used In: checkout.js

Headers: Authorization: Bearer <token>

Request:
{
  "items": [
    { "productId": 1, "quantity": 2 },
    { "productId": 3, "quantity": 1 }
  ],
  "shippingAddress": "123, Bangalore"
}
Response:
{
  "message": "Order placed successfully"
}


📦 GET Orders
Endpoint: GET /api/orders

Used In: orders.js

Headers: Authorization: Bearer <token>

Response:
[
  {
    "orderId": 101,
    "date": "2025-07-11",
    "items": [
      { "name": "Sony Lens", "qty": 1 }
    ],
    "total": 2999
  }
]

