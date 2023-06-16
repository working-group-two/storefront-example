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
      <template v-if="showDisable && revokable">
        <b-button type="is-danger is-outlined" @click.stop.prevent="disableProduct(product.id)">Disable</b-button>
      </template>
      <template v-if="showDisable && !revokable">
        Bundled
      </template>
      <template v-if="!showDisable">
        <div v-if="product.priceBundledUsd != 0" class="product-price">${{ product.priceBundledUsd }}</div>
        <div v-if="product.priceBundledUsd == 0" class="product-price">Free</div>
      </template>
    </div>
  </a>
</template>
<script>
Vue.component("product-card", {
  template: "#product-card",
  props: {
    product: {type: Object, required: true},
    showDisable: {type: Boolean, default: false},
    revokable: {type: Boolean, default: false}
  },
  methods: {
    disableProduct(productId) {
      this.$buefy.dialog.confirm({
        title: "Disable product",
        message: `Are you sure you want to disable ${this.product.name}?`,
        confirmText: "Disable",
        type: "is-danger",
        hasIcon: true,
        onConfirm: () => {
          axios.delete(`/api/consents/revoke?productId=${productId}`)
              .then(() => location.href = "/profile")
              .catch(() => this.$buefy.toast.open({message: "Failed to disable product"}));
        }
      });
    }
  }
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
  padding: 10px 20px;
}

.info-and-price {
  width: calc(100% - 100px);
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
  height: 80px;
  width: 80px;
  overflow: hidden;
  margin-right: 20px;
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
