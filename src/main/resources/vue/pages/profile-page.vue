<template id="profile-page">
  <app-frame class="profile-page">
    <h1 class="title is-5">Hi {{ $javalin.state.currentUser }}, these are your products:</h1>
    <div v-if="consents.loading || products.loading">Loading ...</div>
    <div v-if="consents.loadError || products.loadError">Error loading profile</div>
    <div v-if="consents.loaded && products.loaded">
      <product-card v-for="product in productsThatHaveConsent" :product="product" :show-disable="true"></product-card>
      <div v-if="productsThatHaveConsent.length === 0">You haven't added any products yet!</div>
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
