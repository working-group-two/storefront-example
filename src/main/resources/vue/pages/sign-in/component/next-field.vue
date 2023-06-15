<template id="next-field">
  <div class="next-field">
    <b-field class="next-field">
      <b-input
          v-bind="$attrs"
          :value="value"
          @keypress.native.enter="action"
          @input="e => $emit('input', e)"
          autofocus
      >
      </b-input>
    </b-field>
    <button class="button is-primary" :class="{'is-loading' : loading}" @click="action">
      <b-icon icon="chevron-right"></b-icon>
    </button>
  </div>
</template>
<script>
Vue.component("next-field", {
  props: ["value", "action", "loading"],
  template: "#next-field",
});
</script>
<style>
.next-field {
  position: relative;
}

.next-field .button {
  position: absolute;
  right: 0;
  top: 0;
  border-top-left-radius: 0;
  border-bottom-left-radius: 0;
}
</style>
