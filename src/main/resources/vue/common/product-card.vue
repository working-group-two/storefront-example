<template id="product-card">
  <a class="product-card" :href=`/p/${product.id}`>
    <div class="product-icon">
      <img :src="`https://developer.wgtwo.com/media/image/${product.iconImageId}`" alt="Product icon"/>
    </div>
    <div class="info-and-price">
      <div class="product-name-and-description">
        <div class="product-name">{{ product.name }}</div>
        <div class="product-description">{{ product.subtitle }}</div>
      </div>
      <div v-if="product.priceBundledUsd != 0" class="product-price">${{ product.priceBundledUsd }}</div>
      <div v-if="product.priceBundledUsd == 0" class="product-price">Free</div>
    </div>
  </a>
</template>
<script>
Vue.component("product-card", {
  template: "#product-card",
  props: {
    product: { type: Object, required: true }
  },
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
