<template id="app-frame">
  <div class="app-frame">
    <main class="app-content">
      <div class="app-bar">
        <a href="/">
          <wotel-logo class="wotel-logo"></wotel-logo>
        </a>
        <a class="button is-text is-rounded" href="/profile">
          <b-icon icon="account-circle-outline"></b-icon>
        </a>
      </div>
      <div class="page-content">
        <slot></slot>
      </div>
    </main>
  </div>
</template>
<script>
Vue.component("app-frame", {
  template: "#app-frame",
});
</script>
<style>
.app-content {
  padding: 20px;
  min-height: 100vh;
}

.app-bar {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.wotel-logo {
  max-height: 32px;
  width: auto;
}

.page-content {
  margin-top: 20px;
}

@media (min-width: 480px) {

  .app-frame {
    padding: 20px;
  }

  .app-content {
    max-width: 800px;
    margin: 0 auto;
    min-height: auto;
  }

}
</style>
