<template id="product-details-page">
  <app-frame class="product-details-page">
    <div class="content-box">
      <div v-if="product.loading">Loading ...</div>
      <div v-if="product.loadError">Error loading product</div>
      <div v-if="product.loaded">
        <div class="product-page">
          <img :src="product.data.banner.url" class="product-banner" alt="Product banner"/>
          <div class="product-name">{{ product.data.name }}</div>
          <div class="product-images">
            <ul>
              <li v-for="image in product.data.images" :key="image.url">
                <img :src="image.url" alt="Product image" width="400px" />
              </li>
            </ul>
          </div>
          <div class="product-description">{{ product.data.description }}</div>
          <template v-if="$javalin.state.userConsents.find(it => it.productId == product.data.id)">
            <b-notification type="is-info" :closable="false">
              This product is currently enabled for your subscription.
            </b-notification>
          </template>
          <template v-else>
            <b-button type="is-info is-fullwidth" @click="buy">Add product</b-button>
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
.product-details-page .product-page {
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.product-details-page .content-box {
  --content-padding: 20px;
  background: white;
  padding: 20px;
  border-radius: 16px;
}

.product-banner {
  width: 100%;
  height: auto;
  border-radius: 2px;
  padding-bottom: 24px;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
}

.product-name {
  font-size: 24px;
  font-weight: bold;
}

.product-details-page .product-images ul {
  --padding-bottom: 8px;
  display: flex;
  gap: 8px;
  overflow-x: auto;
  padding-bottom: var(--padding-bottom);
  height: calc(250px + var(--padding-bottom));
  margin-right: calc(var(--content-padding) * -1);
  padding-right: var(--content-padding);

  li {
    flex-shrink: 0;
    flex-grow: 0;
  }

  img {
    height: 100%;
    width: auto;
  }
}
</style>
