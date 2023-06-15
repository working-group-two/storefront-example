<template id="sign-in">
  <div class="sign-in">
    <div class="logo">
      <wotel-logo></wotel-logo>
    </div>
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
        <p>Please enter the PIN that we sent to <code>{{phoneNumber}}</code>.
          <br>
          Wrong number? <a @click="resetForm">Go back</a>.
        </p>
        <next-field
            v-model="pin"
            placeholder="Ex: '1234'"
            :action="validatePin"
            :loading="validatingPin"
            type="tel"
            autocomplete="off"
            key="pin"
        >
        </next-field>
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
        this.focusFirst(".next-field input");
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
        window.location = res.data || "/my-account"
      }).catch(e => {
        this.$buefy.dialog.confirm({
          type: 'is-danger',
          message: 'Failed to validate your PIN, please try again.',
          onConfirm: () => e.response.status === 401 ? this.resetForm() : ""
        });
      }).finally(() => this.validatingPin = false)
    },
    resetForm() {
      this.phoneNumber = "";
      this.sendingPin = false;
      this.pinSent = false;
      this.pin = "";
      this.validatingPin = false;
      this.focusFirst(".next-field input");
    },
  },
  created() {
    setInterval(() => this.phoneNumber = this.phoneNumber.replace(/[^\d+]/g, "").substr(0, 12), 100);
    setInterval(() => this.pin = this.pin.replace(/[^\d]/g, "").substr(0, 4), 100);
  }
});
</script>
<style>

.sign-in {
  height: 100vh;
  background: #f5f5f5;
  overflow: auto;
}

.signin-screen {
  padding: 16px;
}

.signin-screen .next-field {
  margin-top: 16px;
}

@media screen and (min-width: 769px) {
  .signin-screen {
    max-width: 360px;
    margin: 0 auto;
  }
}

.sign-in .logo svg {
  height: 80px;
  margin: 48px auto 32px;
  display: block;
}

</style>
