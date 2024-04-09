<template id="product-card">
  <a class="product-card" :href="`/p/${product.id}`">
    <div class="product-icon">
      <img :src="product.icon.url" alt="Product icon"/>
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
        <b-button type="is-danger is-outlined" disabled>Disable</b-button>
      </template>
      <template v-if="!showDisable">
        <b-button class="product-price" type="is-info" size="is-small">
          View
        </b-button>
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
  position: relative;
  min-height: 100px;
  display: flex;
  align-items: center;
  border-radius: 16px;
  border: 1px solid rgba(0, 0, 0, 0.1);
  overflow: hidden;
  padding: 8px 12px;
  background: white;
}

.info-and-price {
  width: calc(100% - calc(16px + 16px)); /* 64px is the width of the icon, 16px is the margin between the icon and the info */
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-left: 16px;
}

.product-card + .product-card {
  margin-top: 16px;
}

.product-card .product-icon {
  height: 64px;
  width: 64px;
  overflow: hidden;
}

.product-description {
  font-size: 0.8em;
  color: #666;
  padding-right: 8px;
}
</style>
