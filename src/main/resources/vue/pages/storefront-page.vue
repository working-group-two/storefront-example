<template id="storefront-page">
  <app-frame class="storefront-page">
    <div v-if="products.loading">Loading ...</div>
    <div v-if="products.loadError">Error loading products</div>
    <div v-if="products.loaded">
      <a class="product-card" v-for="product in products.data" :href=`/p/${product.id}`>
        <div class="product-icon">
          <img :src="product.iconUrl" alt="Product icon"/>
        </div>
        <div class="info-and-price">
          <div class="product-name-and-description">
            <div class="product-name">{{ product.name }}</div>
            <div class="product-description">{{ product.description }}</div>
          </div>
          <div class="product-price">${{ product.price }}</div>
        </div>
      </a>
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
  height: 100px;
  display: flex;
  align-items: center;
  border-radius: 2px;
  border: 1px solid rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.info-and-price {
  width: calc(100% - 100px);
  padding: 10px 20px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.product-card + .product-card {
  margin-top: 20px;
}

.product-card .product-icon {
  position: relative;
  border-radius: 2px;
  height: 100px;
  width: 100px;
  overflow: hidden;
  border-right: 1px solid rgba(0, 0, 0, 0.1);
}

.product-description {
  font-size: 0.8em;
  color: #666;
  padding-right: 8px;
}

.product-name, .product-price {
  font-weight: bold;
}

@media (min-width: 480px) {
  .product-name, .product-price {
    font-size: 1.2em;
  }
}
</style>
