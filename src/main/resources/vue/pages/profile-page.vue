<template id="profile-page">
  <app-frame class="profile-page">
    <div v-if="consents.loading || products.loading">Loading ...</div>
    <div v-if="consents.loadError || products.loadError">Error loading profile</div>
    <div v-if="consents.loaded && products.loaded">
      <product-card v-for="product in productsThatHaveConsent" :product="product"></product-card>
    </div>
  </app-frame>
</template>
<script>
Vue.component("profile-page", {
  template: "#profile-page",
  data: () => ({
    products: new LoadableData("/api/products"),
    consents: new LoadableData("/api/consents")
  }),
  methods: {},
  computed: {
    productsThatHaveConsent() {
      return this.products.data.filter(p => this.consents.data.find(c => c.productId == p.id)); // one is string, one is number
    }
  }
});
</script>
<style>
</style>
