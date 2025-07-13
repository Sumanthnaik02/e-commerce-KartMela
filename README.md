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

### GET Newest Products
- **Endpoint:** `GET /api/products/newest`  
- **Used In:** `index.html`  
- **Response:**

```json
[
  {
    "name": "Blazer",
    "image": "/frontend/images/blazer.png",
    "price": 2999
  },
  {
    "name": "Blue Chair",
    "image": "/frontend/images/bluechair.png",
    "price": 1999
  },
  {
    "name": "MacBook",
    "image": "/frontend/images/macbook.png",
    "price": 99999
  },
  {
    "name": "Power Bank",
    "image": "/frontend/images/powerbank.png",
    "price": 1999
  },
  {
    "name": "Rolex Watch",
    "image": "/frontend/images/rolexwatch.png",
    "price": 120000
  },
  {
    "name": "Sports Shoes",
    "image": "/frontend/images/shoes.png",
    "price": 2499
  },
  {
    "name": "Sunglasses",
    "image": "/frontend/images/sunglasses.png",
    "price": 899
  }
]

```

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

```

### 🔐 POST Signup
- **Endpoint:** `POST /api/signup`

- **Used In:** `login.js`

- **Request:**
```json
{
  "username": "sumanth",
  "password": "123456"
}
```

- **Response:**
```json
{
  "message": "Signup successful"
}
```

### 🔐 POST Login
- **Endpoint:** `POST /api/login`
- **Used In:** `login.js`

- **Request:**
```json
{
  "username": "sumanth",
  "password": "123456"
}
```
- **Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5..."
}
```

### 🧾 POST Checkout
- **Endpoint:** `POST /api/checkout`

- **Used In:** `checkout.js`

- **Headers:** `Authorization: Bearer <token>`

- **Request:**
```json
{
  "items": [
    { "productId": 1, "quantity": 2 },
    { "productId": 3, "quantity": 1 }
  ],
  "shippingAddress": "123, Bangalore"
}
```
- **Response:**
```json
{
  "message": "Order placed successfully"
}
```

### 📦 GET Orders
- **Endpoint:** `GET /api/orders`

- **Used In:** `orders.js`

- **Headers:** `Authorization: Bearer <token>`

- **Response:**
```json
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
```
