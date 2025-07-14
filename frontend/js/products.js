//js/products.js

document.addEventListener("DOMContentLoaded", () => {
  const API_URL = "../json/products.json";

  fetch(API_URL)
    .then((res) => {
      if (!res.ok) throw new Error("Failed to fetch products");
      return res.json();
    })
    .then((data) => {
      const container = document.querySelector(".product-list");
      const posterContainer = document.querySelector(".poster-gallery");


      //function to create product card
      const createProductCard = (products) => {
        const card = document.createElement("div");
        card.className = "product-card";

        card.innerHTML = `
      <img src="../images/${products.image}" alt="${products.name}">
      <h4>${products.name}</h4>
      <p class ="price">₹ ${products.price}</p>
      <button class="show-btn">Show</button>
     `;
        return card;
      };

      //=== poster image function ===
      const createPoster = (poster) => {
        const img = document.createElement("img");
        img.src = `/frontend/images/poster/${poster.image}`;
        img.alt = "Poster Image";
        img.className = "poster-img";
        return img;
      }
      //append products
      data.products.forEach((products) => {
        container.appendChild(createProductCard(products));
      });
      //duplicate
      data.products.forEach((products) => {
        container.appendChild(createProductCard(products));
      });

      //append posters
      if (posterContainer) {
        data.poster.forEach((poster) => {
          posterContainer.appendChild(createPoster(poster));
        });

        //duplicate posters for seamless scroll
        data.poster.forEach((poster) =>{
          posterContainer.appendChild(createPoster(poster));
        });
      }
    })
    .catch((err) => {
      console.error("Error loading products:", err);
    });
});