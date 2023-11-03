<template id="sign-in-page">
  <div class="sign-in-page">
    <div class="signin-screen">
      <div class="content-box">
        <wotel-logo class="big-logo"></wotel-logo>
        <div v-if="!pinSent">
          <p>Enter your mobile number and we will send you an access code</p>
          <b-field type="is-info">
            <b-input
                v-model="phoneNumber"
                placeholder="Ex: 999 12 345"
                type="tel"
                autocomplete="tel"
                key="phone"
            >
            </b-input>
          </b-field>
          <b-button type="is-info is-fullwidth" :loading="sendingPin" @click="sendPin">Send pin</b-button>
        </div>
        <div v-if="pinSent">
          <p>Please enter the PIN that we sent to <strong>{{ phoneNumber }}</strong>.</p>
          <b-field type="is-info">
            <b-input
                type="is-info"
                v-model="pin"
                placeholder="Ex: '1234'"
                type="tel"
                autocomplete="off"
                key="pin"
                maxlength="4"
            >
            </b-input>
          </b-field>
          <b-button type="is-info is-fullwidth" :loading="validatingPin" @click="validatePin">Verify</b-button>
          <p class="is-size-7">Wrong number? <a @click="resetForm">Go back</a>.</p>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
Vue.component("sign-in-page", {
  template: "#sign-in-page",
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
      }).catch(err => {
        const message = err.response.status === 401
            ? "You are not authorized to sign in, contact your operator to enable Wotel Storefront"
            : "Failed to send PIN to your number, please try again.";
        this.$buefy.dialog.alert({type: "is-danger", message: message});
      }).finally(() => this.sendingPin = false)
    },
    validatePin() {
      this.validatingPin = true;
      axios.post("/api/auth/validate-pin?pin=" + this.pin).then(() => {
        // redirect after 1s delay
        setTimeout(() => location.href = "/", 1000);
      }).catch(() => {
        this.validatingPin = false;
        this.$buefy.dialog.confirm({
          type: "is-danger",
          message: "Failed to validate your PIN, please start over.",
          onConfirm: () => this.resetForm()
        });
      });
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
.signin-screen {
  padding: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 70vh;
}

.signin-screen .content-box {
  background: white;
  padding: 32px;
  border-radius: 16px;
}

.signin-screen .big-logo {
  height: 32px;
  margin: 0 auto;
  display: block;
}

.signin-screen p {
  margin: 36px 0;
  text-align: center;
}

.signin-screen .button {
  margin-top: 16px;
}

.signin-screen .help.counter,
.signin-screen .icon.is-right.has-text-info {
  display: none;
}


@media screen and (min-width: 769px) {
  .signin-screen .content-box {
    max-width: 400px;
  }
}
</style>
