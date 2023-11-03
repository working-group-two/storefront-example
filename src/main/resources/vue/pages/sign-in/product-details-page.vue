<template id="product-details-page">
  <app-frame class="product-details-page">
    <div class="content-box">
      <div v-if="product.loading">Loading ...</div>
      <div v-if="product.loadError">Error loading product</div>
      <div v-if="product.loaded">
        <div class="product-page">
          <!--<img :src="`https://developer.wgtwo.com/media/image/${product.data.bannerImageId}`" class="product-banner" alt="Product banner"/>-->
          <div class="product-name">{{ product.data.name }}</div>
          <div class="product-description">{{ product.data.description }}</div>
          <template v-if="$javalin.state.userConsents.find(it => it.productId == product.data.id)">
            <b-notification type="is-info" :closable="false" class="mt-3">
              This product is currently enabled for your subscription.
            </b-notification>
          </template>
          <template v-else>
            <b-button type="is-info is-fullwidth" class="mt-5" @click="buy">Add product</b-button>
          </template>
        </div>
      </div>
    </div>
  </app-frame>
</template>
<script>
Vue.component("product-details-page", {
  template: "#product-details-page",
  data: () => ({
    product: new LoadableData(`/api/products/${JavalinVue.pathParams["productId"]}`)
  }),
  methods: {
    buy() {
      let {version, id} = this.product.data
      axios.post(`/api/consents/create?productId=${id}`)
          .then(() => location.href = "/profile")
          .catch(() => this.$buefy.toast.open({message: "Failed to buy product"}));
    }
  },
});
</script>
<style>
.product-details-page .content-box {
  background: white;
  padding: 20px;
  border-radius: 16px;
}

.product-banner {
  border-radius: 2px;
  padding-bottom: 24px;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
  margin-bottom: 12px;
}

.product-name {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 12px;
}
</style>
