<template id="profile-page">
  <app-frame class="profile-page">
    <div v-if="consents.loading">Loading ...</div>
    <div v-if="consents.loadError">Error loading profile</div>
    <div v-if="consents.loaded">
      {{ consents.data }}
    </div>
  </app-frame>
</template>
<script>
Vue.component("profile-page", {
  template: "#profile-page",
  data: () => ({
    consents: new LoadableData("/api/consents")
  }),
  methods: {},
});
</script>
<style>
</style>
