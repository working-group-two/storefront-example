<template id="profile-page">
  <app-frame class="profile-page">
    <h1 class="title is-5">Hi {{ $javalin.state.currentUser.e164 }}, these are your products:</h1>
    <div v-if="products.loading">Loading ...</div>
    <div v-if="products.loadError">Error loading profile</div>
    <div v-if="products.loaded">
      <!-- go through all consents and products and show the ones that match on consent.productId and product.id -->
      <template v-for="consent in $javalin.state.userConsents">
        <product-card
            v-for="product in products.data"
            v-if="consent.productId === product.id"
            :product="product"
            :show-disable="true"
            :revokable="consent.revokable"
            :key="product.id"
        ></product-card>
      </template>
      <div v-if="productsThatHaveConsent.length === 0">You haven't added any products yet!</div>
    </div>
  </app-frame>
</template>
<script>
Vue.component("profile-page", {
  template: "#profile-page",
  data: () => ({
    products: new LoadableData("/api/products"),
  }),
  methods: {},
  computed: {
    productsThatHaveConsent() {
      return this.products.data.filter(p => this.$javalin.state.userConsents.find(c => c.productId == p.id)); // one is string, one is number
    }
  }
});
</script>
<style>
</style>
