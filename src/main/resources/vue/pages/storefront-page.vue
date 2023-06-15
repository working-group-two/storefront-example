<template id="storefront-page">
  <app-frame class="storefront-page">
    <div v-if="products.loading">Loading ...</div>
    <div v-if="products.loadError">Error loading products</div>
    <div v-if="products.loaded">
      <div class="product-card" v-for="product in products.data">
        <div class="product-icon">
          <img :src="product.iconUrl" alt="Product icon"/>
        </div>
        <div class="product-name-and-description">
          <div class="product-name">{{ product.name }}</div>
          <div class="product-description">{{ product.description }}</div>
        </div>
        <div class="product-price">${{ product.price }}</div>
      </div>
    </div>
  </app-frame>
</template>
<script>
Vue.component("storefront-page", {
  template: "#storefront-page",
  data: () => ({
    products: new LoadableData("/api/products")
  }),
  methods: {},
});
</script>
<style>
.product-card {
  display: flex;
  align-items: center;
  padding: 20px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  border-radius: 4px;
}

.product-card + .product-card {
  margin-top: 20px;
}

.product-card .product-icon {
  position: relative;
  border-radius: 4px;
  width: 100px;
  margin-right: 20px;
  overflow: hidden;
}

.product-card .product-icon::after {
  position: absolute;
  background: rgba(0, 0, 0, 0.025);
  content: "";
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.product-name {
  font-size: 1.2em;
  font-weight: bold;
}

.product-price {
  font-size: 1.2em;
  font-weight: bold;
  margin-left: auto;
}
</style>
