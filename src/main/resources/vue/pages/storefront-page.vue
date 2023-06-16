<template id="storefront-page">
  <app-frame class="storefront-page">
    <div v-if="products.loading">Loading ...</div>
    <div v-if="products.loadError">Error loading products</div>
    <div v-if="products.loaded">
      <product-card v-for="product in products.data" :product="product"></product-card>
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

