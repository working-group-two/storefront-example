<template id="app-frame">
  <div class="app-frame">
    <main class="app-content">
      <wotel-logo class="wotel-logo"></wotel-logo>
      <slot></slot>
    </main>
  </div>
</template>
<script>
Vue.component("app-frame", {template: "#app-frame"});
</script>
<style>
.app-content {
  padding: 20px;
  background: #fff;
  max-width: 800px;
}

.wotel-logo {
  max-height: 40px;
}

@media (min-width: 480px) {

  .app-frame {
    padding: 20px;
  }

  .app-content {
    margin: 0 auto;
    border-radius: 4px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  
}
</style>
