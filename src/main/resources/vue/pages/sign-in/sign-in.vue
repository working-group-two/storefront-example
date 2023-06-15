<template id="sign-in">
  <div class="sign-in">
    <wotel-logo class="big-logo"></wotel-logo>
    <div class="signin-screen">
      <div v-if="!pinSent">
        <p>Enter your mobile number and we'll send you a PIN code to make sure you're you.</p>
        <next-field
            v-model="phoneNumber"
            placeholder="Ex: 999 12 345"
            :action="sendPin"
            :loading="sendingPin"
            type="tel"
            autocomplete="tel"
            key="phone"
        >
        </next-field>
      </div>
      <div v-if="pinSent">
        <p>Please enter the PIN that we sent to <strong>{{phoneNumber}}</strong>.</p>
        <next-field
            v-model="pin"
            placeholder="Ex: '1234'"
            :action="validatePin"
            :loading="validatingPin"
            type="tel"
            autocomplete="off"
            key="pin"
            maxlength="4"
        >
        </next-field>
        <p class="is-size-7">Wrong number? <a @click="resetForm">Go back</a>.</p>
      </div>
    </div>
  </div>
</template>
<script>
Vue.component("sign-in", {
  template: "#sign-in",
  data: () => ({
    phoneNumber: "",
    sendingPin: false,
    pinSent: false,
    pin: "",
    validatingPin: false,
  }),
  methods: {
    sendPin() {
      this.sendingPin = true;
      axios.post("/api/auth/send-pin?phoneNumber=" + this.phoneNumber).then(() => {
        this.pinSent = true;
        setTimeout(() => this.$el.querySelector("input").focus(), 0);
      }).catch(() => {
        this.$buefy.dialog.alert({
          type: 'is-danger',
          message: 'Failed to send PIN to your number, please try again.',
        });
      }).finally(() => this.sendingPin = false)
    },
    validatePin() {
      this.validatingPin = true;
      axios.post("/api/auth/validate-pin?pin=" + this.pin).then(res => {
        location.href = "/";
      }).catch(e => {
        this.$buefy.dialog.confirm({
          type: 'is-danger',
          message: 'Failed to validate your PIN, please start over.',
          onConfirm: () => this.resetForm()
        });
      }).finally(() => this.validatingPin = false)
    },
    resetForm() {
      this.phoneNumber = "";
      this.sendingPin = false;
      this.pinSent = false;
      this.pin = "";
      this.validatingPin = false;
      setTimeout(() => this.$el.querySelector("input").focus(), 0);
    },
  },
});
</script>
<style>
html {
  background: #f5f5f5;
}

.big-logo {
  height: 80px;
  margin: 48px auto 32px;
  display: block;
}

.signin-screen {
  padding: 20px;
}

.signin-screen .next-field {
  margin-top: 32px;
}

.signin-screen .help.counter {
  display: none;
}

@media screen and (min-width: 769px) {
  .signin-screen {
    max-width: 360px;
    margin: 0 auto;
  }
}
</style>
