<template id="app-frame">
  <div class="app-frame">
    <main class="app-content">
      <div class="app-bar">
        <a href="/">
          <wotel-logo class="wotel-logo"></wotel-logo>
        </a>
        <a class="button is-info is-rounded is-outlined" href="/profile">
          <b-icon icon="account-settings"></b-icon>
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
  background: #fff;
  max-width: 800px;
  min-height: 100vh;
}

.app-bar {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.wotel-logo {
  max-height: 40px;
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
    margin: 0 auto;
    border-radius: 2px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    min-height: auto;
  }

}
</style>
