//js/products.js

document.addEventListener("DOMContentLoaded", ()=>{
  const API_URL = "../json/products.json";

  fetch(API_URL)
  .then((res)=>{
  if(!res.ok) throw new Error("Failed to fetch products");
  return res.json();
  })
  .then((data) => {
    const container = document.querySelector(".product-list");

    data.products.forEach((products)=>{
      const card = document.createElement("div");
      card.className="product-card";

      card.innerHTML=`
      <img src="../images/${products.image}" alt="${products.name}">
      <h4>${products.name}</h4>
      <p class ="price">₹ ${products.price}</p>
      <button class="show-btn">Show</button>
     `;
      container.appendChild(card);
    });
  })
  .catch((err) => {
    console.error("Error loading products:",err);
  });
});